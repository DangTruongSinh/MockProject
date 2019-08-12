package com.bus.model;

public class RoleModel extends AbstractModel{
		private Integer idRole;
		private String name;
		
		public RoleModel(Integer idRole, String name) {
			this.idRole = idRole;
			this.name = name;
		}
		public RoleModel()
		{
			
		}
		public Integer getIdRole() {
			return idRole;
		}
		public void setIdRole(int idRole) {
			this.idRole = idRole;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
