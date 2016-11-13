package com.usernamelist.viewBean;

import java.util.List;

public class LoginBean {
	private String username;
	private List<String> sugesstedNames;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getSugesstedNames() {
		
		return sugesstedNames;
	}

	public void setSugesstedNames(List<String> sugesstedNames) {
		this.sugesstedNames = sugesstedNames;
	}

	

}
