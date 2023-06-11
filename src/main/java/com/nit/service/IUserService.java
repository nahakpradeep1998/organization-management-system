package com.nit.service;

import java.sql.SQLException;
import java.util.List;

import com.nit.model.UserVO;

public interface IUserService {
	public int registerUser(UserVO userVo);

	public int updateUser(UserVO userVo);

	public boolean deleteUser(Long userId) throws SQLException;

	public boolean checkUserByEmail(String email);

	public List<UserVO> getUserListByOrgId(Long orgId);

	public UserVO getUserByUserId(Long userId);
}
