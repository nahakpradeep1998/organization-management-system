package com.nit.dao;

import java.sql.SQLException;
import java.util.List;

import com.nit.model.UserBO;
import com.nit.model.UserVO;

public interface IUserDAO {
	int registerUser(UserBO userBo);

	public List<UserBO> fetchUserListByOrgId(Long orgId);

	public int getUserByEmail(String email);

	public UserVO getUserByUserId(Long userId);

	public List<UserBO> getAllUsers();

	public boolean deleteUser(Long userId) throws SQLException;

	public int updateUser(UserBO userBO);
}