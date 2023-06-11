package com.nit.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nit.dao.IOrganizationDAO;
import com.nit.dao.impl.OrganizationDAOImpl;
import com.nit.model.OrganizationBO;
import com.nit.model.OrganizationVO;
import com.nit.service.IOrganizationService;
import com.nit.util.DBConnection;

public class OrganizationServiceImpl implements IOrganizationService {
	private IOrganizationDAO dao;
	private Connection con;

	public OrganizationServiceImpl() {
		dao = new OrganizationDAOImpl ();
	}

	@Override
	public int registerOrganization(OrganizationVO orgVo) {
		OrganizationBO orgBo = new OrganizationBO();
		orgBo.setOrgName(orgVo.getOrgName());
		orgBo.setEmail(orgVo.getEmail());
		orgBo.setPassword(orgVo.getPassword());
		int result = dao.registerOrganization(orgBo);
		return result;
	}

	@Override
	public OrganizationBO login(OrganizationBO orgBo) {
		int count = dao.getOrganizationByEmail(orgBo.getEmail());
		if (count != 0) {
			OrganizationBO dbOrgBo = getOrganizationByEmail(orgBo.getEmail());
			if (dbOrgBo.getPassword().equals(orgBo.getPassword())) {
				return dbOrgBo; // login successful
			}
		}
		return null; // login failed
	}

	@Override
	public boolean checkOrganizationByEmail(String email) {
		int count = dao.getOrganizationByEmail(email);
		boolean result = count == 1;
		return result;
	}

	public OrganizationBO getOrganizationByEmail(String email) {
		OrganizationBO orgBo = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from organization WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orgBo = new OrganizationBO();
				orgBo.setOrgId(rs.getLong("orgId"));
				orgBo.setOrgName(rs.getString("orgName"));
				orgBo.setEmail(rs.getString("email"));
				orgBo.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orgBo;
	}
}

//		@Override
//		public String updateOrganization(OrganizationVO orgVo) {
//			OrganizationBO orgBo = new OrganizationBO();
//			orgBo.setOrgName(orgVo.getOrgName());
//			orgBo.setEmail(orgVo.getEmail());
//			orgBo.setPassword(orgVo.getPassword());
//
//			int result = dao.updateOrganization(orgBo);
//			String msg = null;
//			if (result > 0)
//				msg = "organization updated";
//			else
//				msg = "organization NOT updated";
//
//			return msg;
//		}
//
//		@Override
//		public String deleteOrganization(Long userId) {
//			Long result = dao.deleteOrganization(userId);
//			String msg = null;
//			if (result > 0) {
//				msg = "organization deleted";
//			} else {
//				msg = "organization NOT deleted";
//			}
//			return msg;
//		}
