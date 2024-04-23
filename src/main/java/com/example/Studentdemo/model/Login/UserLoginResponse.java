package com.example.Studentdemo.model.Login;

public class UserLoginResponse {
	
	private boolean authenticated;
    private String userRole;

    public UserLoginResponse(boolean authenticated, String userRole) {
        this.authenticated = authenticated;
        this.userRole = userRole;
    }

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
