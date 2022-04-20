package com.abc.friendfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.friendfinder.entity.Complaint;
import com.abc.friendfinder.exception.ComplaintNotFoundException;
import com.abc.friendfinder.service.IComplaintServiceImpl;


//All complaint related requests are mapped to this controller
@RestController
@RequestMapping("/complaint")
public class ComplaintServiceController {
	
	@Autowired
	private IComplaintServiceImpl complaintservice;
	
	//User adds a complaint
	@PostMapping("/add")
	public Complaint addComplaint(@RequestBody Complaint complaint)throws ComplaintNotFoundException {
		return complaintservice.addComplaint(complaint);	
	}
	
	//User views a complaint by specifying its Id
	@GetMapping("/view/{complaintId}")
	public Complaint viewComplaint(@PathVariable Long complaintId)throws ComplaintNotFoundException  {
		return complaintservice.viewComplaintById(complaintId);
	}
	
	//Admin views all the complaints
	@GetMapping("/admin/view")
	public List<Complaint>viewComplaints(){
		return complaintservice.viewAllComplaints();
	}
	
	//Admin resolves the complaint that is provided in the requestBody
	@GetMapping("/admin/resolve")
	public boolean ResolveComplaint(@RequestBody Complaint complaint)throws ComplaintNotFoundException{
		return complaintservice.resolveComplaint(complaint) ;
	}
	
	

}
