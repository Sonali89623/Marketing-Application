package com.marketingapplication.service;

import java.util.List;

import com.marketingapplication.dto.LeadDto;
import com.marketingapplication.entity.Lead;

public interface LeadService {
	public void saveLead(Lead lead);

	public List<Lead> getAllLeads();

	public void deleteLead(long id);

	public Lead findLead(long id);

	public void updateLead(LeadDto leadDto);

}
