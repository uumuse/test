package com.kuke.resetPassword.service;

import java.util.List;
import java.util.Map;

public interface IresetPasswordService {

	public List<Map<String, String>> userList(String email);
	
	public void resetUser(String userId,String password);
}
