package com.sunsharelaw.bg.domain;

public class Company {
	private String company_id;
	private String company_name;
	private String welcome_content;
	private String admin_username;
	private String admin_pwd;
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getWelcome_content() {
		return welcome_content;
	}
	public void setWelcome_content(String welcome_content) {
		this.welcome_content = welcome_content;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

}
