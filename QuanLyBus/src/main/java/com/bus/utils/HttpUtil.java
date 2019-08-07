package com.bus.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	public HttpUtil(String value)
	{
		this.value = value;
	}
	public <T>  T toModel(Class<T> t)
	{
		try {
			return new ObjectMapper().readValue(this.value, t);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtil of(BufferedReader buReader)
	{
		StringBuilder builder = new StringBuilder();
		String line;
		try {
			while((line = buReader.readLine()) != null)
			{
				builder.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HttpUtil(builder.toString());
	}

}
