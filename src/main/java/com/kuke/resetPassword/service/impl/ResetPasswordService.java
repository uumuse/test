package com.kuke.resetPassword.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.resetPassword.mapper.ResetPasswordMapper;
import com.kuke.resetPassword.service.IresetPasswordService;

@Service
public class ResetPasswordService implements IresetPasswordService {
	
	@Autowired
	private ResetPasswordMapper resetPasswordMapper;

	@Override
	public List<Map<String, String>> userList(String email) {
		List<Map<String, String>> list = resetPasswordMapper.userList(email);
		return list;
	}

	@Override
	public void resetUser(String userId, String password) {
		resetPasswordMapper.resetUser(userId, password);	
	}


}
