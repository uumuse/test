package com.kuke.resetPassword.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ResetPasswordMapper {
	
	public List<Map<String, String>> userList(@Param("email")String email);
	
	public void resetUser(@Param("userId")String userId,@Param("password")String password);

}
