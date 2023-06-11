package com.nit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nit.dao.IUserDAO;
import com.nit.model.UserBO;
import com.nit.model.UserVO;
import com.nit.util.DBConnection;

public class UserDAOImpl implements IUserDAO {
	private Connection con = null;

	@Override
	public int registerUser(UserBO userBo) {
		int rowInserted = 0;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO user_info (userId, firstName, lastName, email, phoneNo, designation, dateOfJoin, orgId) VALUES (USER_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, userBo.getFirstName());
			ps.setString(2, userBo.getLastName());
			ps.setString(3, userBo.getEmail());
			ps.setLong(4, userBo.getPhoneNo());
			ps.setString(5, userBo.getDesignation());
			ps.setString(6, userBo.getDateOfJoin());
			ps.setLong(7, userBo.getOrgId());
			rowInserted = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rowInserted;
	}


	@Override
	public int updateUser(UserBO userBO) {
		int rowsUpdated = 0;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE user_info SET firstName=?, lastName=?, email=?, phoneNo=?, designation=?, dateOfJoin=?  WHERE userId=?");
			ps.setString(1, userBO.getFirstName());
			ps.setString(2, userBO.getLastName());
			ps.setString(3, userBO.getEmail());
			ps.setLong(4, userBO.getPhoneNo());
			ps.setString(5, userBO.getDesignation());
			ps.setString(6, userBO.getDateOfJoin());
			ps.setLong(7, userBO.getUserId());
			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rowsUpdated;
	}

	@Override
	public boolean deleteUser(Long userId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement("DELETE from user_info where userId=?");
		stmt.setLong(1, userId);
		int rowsAffected = stmt.executeUpdate();
		return rowsAffected == 1;

	}

	@Override
	public List<UserBO> fetchUserListByOrgId(Long orgId) {
		List<UserBO> userBOList = new ArrayList<UserBO>();
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user_info where orgId=?");
			ps.setLong(1, orgId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBO userBO = new UserBO();
				userBO.setUserId(rs.getLong("userId"));
				userBO.setFirstName(rs.getString("firstName"));
				userBO.setLastName(rs.getString("lastName"));
				userBO.setEmail(rs.getString("email"));
				userBO.setPhoneNo(rs.getLong("phoneNo"));
				userBO.setDesignation(rs.getString("designation"));
				userBO.setDateOfJoin(rs.getString("dateOfJoin"));
				userBO.setOrgId(rs.getLong("orgId"));
				userBOList.add(userBO);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return userBOList;
	}

	@Override
	public int getUserByEmail(String email) {
		int count = 0;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT count(*) from user_info WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public UserVO getUserByUserId(Long userId) {
		UserVO user = null ;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from user_info WHERE userId=?");
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setUserId(rs.getLong("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNo(rs.getLong("phoneNo"));
				user.setDesignation(rs.getString("designation"));
				user.setDateOfJoin(rs.getString("dateOfJoin"));
				user.setOrgId(rs.getLong("orgId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<UserBO> getAllUsers() {
		System.out.println("UserDAOImpl.getAllUsers()");
		List<UserBO> userList = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from user_info");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBO userBO = new UserBO();
				userBO.setUserId(rs.getLong("userId"));
				userBO.setFirstName(rs.getString("firstName"));
				userBO.setLastName(rs.getString("lastName"));
				userBO.setEmail(rs.getString("email"));
				userBO.setPhoneNo(rs.getLong("phoneNo"));
				userBO.setDesignation(rs.getString("designation"));
				userBO.setDateOfJoin(rs.getString("dateOfJoin"));
				userBO.setOrgId(rs.getLong("orgId"));
				userList.add(userBO);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return userList;
	}

}