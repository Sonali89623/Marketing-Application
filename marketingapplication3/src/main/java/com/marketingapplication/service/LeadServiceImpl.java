package com.marketingapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marketingapplication.dto.LeadDto;
import com.marketingapplication.entity.Lead;
import com.marketingapplication.repo.LeadRepo;
@Service
public class LeadServiceImpl implements LeadService {
	//Also we have constructor based DI, here we don't require @Autowired.
	@Autowired
	private LeadRepo leadRepo;
	@Override
	public void saveLead(@ModelAttribute Lead lead) {//Mod Attr binds form data with entity class, here optional to write this.
		leadRepo.save(lead);

	}
	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);;
		
	}
	@Override
	public Lead findLead(long id) {
		Lead lead = leadRepo.findById(id).get();
		return lead;
	}
	@Override
	public void updateLead(LeadDto leadDto) {
		Lead lead=new Lead();
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadRepo.save(lead);
}}
