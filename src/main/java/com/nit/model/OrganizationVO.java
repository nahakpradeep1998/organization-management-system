package com.nit.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrganizationVO implements Serializable {
	private String orgName;
	private String email;
	private String password;

	public OrganizationVO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
