package com.nit.service;

import com.nit.dao.IOrganizationDAO;
import com.nit.model.OrganizationBO;
import com.nit.model.OrganizationVO;

public interface IOrganizationService {
	public int registerOrganization(OrganizationVO orgVo);

	public boolean checkOrganizationByEmail(String email);
	
	public OrganizationBO login(OrganizationBO orgBo);

	public OrganizationBO getOrganizationByEmail(String email);
	
//	public String updateOrganization(OrganizationVO orgVo);
//	public String deleteOrganization(Long orgId);

}
