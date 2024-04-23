package com.example.Studentdemo.model.Login;

public class LoginResponse {

	private String message;
    private String userRole;

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public LoginResponse(String message, String userRole) {
        this.message = message;
        this.userRole = userRole;
    }
}