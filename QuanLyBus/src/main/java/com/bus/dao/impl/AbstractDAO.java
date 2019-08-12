package com.bus.dao.impl;

/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bus.dao.IGenericDAO;
import com.bus.mapper.IRowMapper;
public class AbstractDAO<T> implements IGenericDAO<T>{
	
	private Connection getConnection()
	{
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mockproject?useSSL=false";
			String username = "root";
			String password = "123456";
			Connection connection = (Connection) DriverManager.getConnection(url, username,password);
			return connection;
		} catch (SQLException  | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		 return null;
	}
	@Override
	public List<T> query(String sql, IRowMapper<T> mapper, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<>();
		if(connection != null)
		{
			try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
				setParameter(preparedStatement,parameters);
				rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					list.add(mapper.mapRow(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeDataBase(connection,preparedStatement);
			}
		}
		return list;
	}
	private void closeDataBase(Connection connection, PreparedStatement preparedStatement) {
		try {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
		
	}
	private void setParameter(PreparedStatement preparedStatement, Object[] parameters) {
		for(int i = 0; i < parameters.length;i++)
		{
				try {
					Object x = parameters[i];
					if(x instanceof Integer)
						preparedStatement.setInt(i+1, (int)x);
					else if(x instanceof String)
						preparedStatement.setString(i+1, (String) x);
					else if(x instanceof Timestamp)
						preparedStatement.setTimestamp(i+1,  (Timestamp) x);
					else if(x instanceof Boolean)
						preparedStatement.setBoolean(i+1, (boolean) x);
					else
						preparedStatement.setString(i+1, null);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	@Override
	public int insert(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		if(connection != null)
		{
			try {
				connection.setAutoCommit(false);
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				setParameter(preparedStatement,parameters);
				preparedStatement.executeUpdate();
				connection.commit();
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next())
					return (int)resultSet.getLong(1);
			} catch (SQLException e) {
				try {
					e.printStackTrace();
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}finally {
				closeDataBase(connection, preparedStatement);
			}
		
		}
		return -1;
	}
	@Override
	public int update(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		if(connection != null)
		{
			try {
				connection.setAutoCommit(false);
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
				setParameter(preparedStatement,parameters);
				int numbers = preparedStatement.executeUpdate();
				connection.commit();
				if(numbers != 0)
					return 1;
			} catch (SQLException e) {
				try {
					e.printStackTrace();
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}finally {
				closeDataBase(connection, preparedStatement);
			}
		
		}
		return -1;
		
	}
	@Override
	public int delete(String sql, Object... parameters) {
		return update(sql,parameters);
	}
	@Override
	public int getTotalItem(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int item = 0;
		if(connection != null)
		{
			try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
				setParameter(preparedStatement,parameters);
				rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					item = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeDataBase(connection,preparedStatement);
			}
		}
		return item;
	}
	
	
	

}
