package com.nit.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nit.dao.IUserDAO;
import com.nit.dao.impl.UserDAOImpl;
import com.nit.model.UserBO;
import com.nit.model.UserVO;
import com.nit.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao;

	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}

	@Override
	public int registerUser(UserVO userVo) {
		UserBO userBo = new UserBO();
		userBo.setFirstName(userVo.getFirstName());
		userBo.setLastName(userVo.getLastName());
		userBo.setEmail(userVo.getEmail());
		userBo.setPhoneNo(userVo.getPhoneNo());
		userBo.setDesignation(userVo.getDesignation());
		userBo.setDateOfJoin(userVo.getDateOfJoin());
		userBo.setOrgId(userVo.getOrgId());
		int result = dao.registerUser(userBo);
		return result;
	}

	@Override
	public int updateUser(UserVO userVo) {
		UserBO userBo = new UserBO();
		userBo.setUserId(userVo.getUserId());
		userBo.setFirstName(userVo.getFirstName());
		userBo.setLastName(userVo.getLastName());
		userBo.setEmail(userVo.getEmail());
		userBo.setPhoneNo(userVo.getPhoneNo());
		userBo.setDesignation(userVo.getDesignation());
		userBo.setDateOfJoin(userVo.getDateOfJoin());
		int result = dao.updateUser(userBo);
		return result;
	}

	@Override
	public boolean deleteUser(Long userId) throws SQLException {
		boolean deleted = dao.deleteUser(userId);
		return deleted;
	}

	@Override
	public boolean checkUserByEmail(String email) {
		int count = dao.getUserByEmail(email);
		return count > 0;
	}

	@Override
	public UserVO getUserByUserId(Long userId) {
		return dao.getUserByUserId(userId);
	}

	public List<UserVO> getUserListByOrgId(Long orgId) {
		List<UserBO> listBo = dao.fetchUserListByOrgId(orgId);
		List<UserVO> userVOList = new ArrayList<UserVO>();
		for (UserBO bo : listBo) {
			UserVO vo = new UserVO();
			vo.setUserId(bo.getUserId());
			vo.setFirstName(bo.getFirstName());
			vo.setLastName(bo.getLastName());
			vo.setEmail(bo.getEmail());
			vo.setPhoneNo(bo.getPhoneNo());
			vo.setDesignation(bo.getDesignation());
			vo.setDateOfJoin(bo.getDateOfJoin());
			vo.setOrgId(bo.getOrgId());
			userVOList.add(vo);
		}
		return userVOList;
	}
}