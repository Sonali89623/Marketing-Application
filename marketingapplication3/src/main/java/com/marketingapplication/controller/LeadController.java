package com.marketingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapplication.dto.LeadDto;
import com.marketingapplication.entity.Lead;
import com.marketingapplication.service.LeadService;
import com.marketingapplication.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private LeadService leadService;
	@GetMapping("/view") //GetMapping=Load the form.
	public String viewCreateLeadPage() {
		return "create_lead";
	}
//	@RequestMapping("/saveLead")
//	public String saveLead( Lead lead,Model model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Record saved!");
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveRecord(@RequestParam("first Name")String firstName,
//			@RequestParam("last Name")String lastName,
//			@RequestParam("email")String email,
//			@RequestParam("mobile")Long mobile
//			,Model model) {
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Record Saved!!");
//		return "create_lead";
//	}
	@PostMapping("/saveLead") //PostMapping=Submit the form data to db.
	public String saveLead(LeadDto dto,Model model) {
		Lead lead=new Lead();
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadService.saveLead(lead);
		emailService.sendEmail(dto.getEmail(), "Test", "Test Email Sending");
		model.addAttribute("msg", "Record Saved!!");
		return "create_lead";
	}
	@GetMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> lead=leadService.getAllLeads();
		model.addAttribute("lead", lead);
		return "list_leads";
	}
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> lead=leadService.getAllLeads();
		model.addAttribute("lead", lead);
		return "list_leads";
		
	}
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long id,ModelMap model) {
		Lead lead=leadService.findLead(id);
		model.addAttribute("lead", lead);
		return "update_leads";
	
}
	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadDto leadDto,Model model) {
		leadService.updateLead(leadDto);
		List<Lead> lead=leadService.getAllLeads();
		model.addAttribute("lead", lead);
		return "list_leads";
	}





}
