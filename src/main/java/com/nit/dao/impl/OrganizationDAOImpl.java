package com.nit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.nit.dao.IOrganizationDAO;
import com.nit.model.OrganizationBO;
import com.nit.util.DBConnection;

public class OrganizationDAOImpl implements IOrganizationDAO {
	private static final Logger logger = Logger.getLogger(OrganizationDAOImpl.class.getName());
	private Connection con;
	@Override
	public int registerOrganization(OrganizationBO orgBo) {
		int rowInserted = 0;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT into Organization(orgId, orgName, email, password) VALUES(ORG_SEQ.NEXTVAL, ?, ?, ?)");
			ps.setString(1, orgBo.getOrgName());
			ps.setString(2, orgBo.getEmail());
			ps.setString(3, orgBo.getPassword());
			rowInserted = ps.executeUpdate();
		} catch (Exception e) {
			logger.severe("Error while registering organization: " + e.getMessage());
			e.printStackTrace();
		}
		return rowInserted;
	}
	@Override
	public int getOrganizationByEmail(String email) {
		int count = 0;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT count(*) from organization WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			logger.severe("Error while getting organization by email: " + e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public int updateOrganization(OrganizationBO orgBo) {
//		int rowUpdated = 0;
//		try {
//			con = DBConnection.getConnection();
//			PreparedStatement ps = con
//					.prepareStatement("UPDATE organization SET orgName=?, email=?, password=? where orgId=?");
//			ps.setString(1, orgBo.getOrgName());
//			ps.setString(2, orgBo.getEmail());
//			ps.setString(3, orgBo.getPassword());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return rowUpdated;
//	}
//
//	@Override
//	public Long deleteOrganization(Long orgId) {
//		try {
//			con = DBConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("DELETE from organization where orgId = ?");
//			ps.setLong(1, orgId);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return orgId;
//	}
//
//	@Override
//	public List<OrganizationBO> getAllOrganizations() {
//		List<OrganizationBO> organizations = new ArrayList<>();
//		try {
//			con = DBConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT * from organization");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				OrganizationBO orgBo = new OrganizationBO();
//				orgBo.setOrgId(rs.getLong(1));
//				orgBo.setOrgName(rs.getString(3));
//				orgBo.setEmail(rs.getString(4));
//				orgBo.setPassword(rs.getString(4));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return organizations;
//	}

}
