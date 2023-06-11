package com.nit.dao;

import com.nit.model.OrganizationBO;

public interface IOrganizationDAO {
	int registerOrganization(OrganizationBO orgBo);

	public int getOrganizationByEmail(String email);

//	public boolean checkOrganizationByEmail(String email);
//
//	public OrganizationBO login(OrganizationBO orgBo);
//
//	int updateOrganization(OrganizationBO orgBo);
//
//	Long deleteOrganization(Long orgId);
//
//	List<OrganizationBO> getAllOrganizations();

}
