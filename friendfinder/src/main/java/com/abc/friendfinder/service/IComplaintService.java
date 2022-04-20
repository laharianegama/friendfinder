package com.abc.friendfinder.service;

import java.util.List;

import com.abc.friendfinder.entity.Complaint;
import com.abc.friendfinder.exception.ComplaintNotFoundException;

public interface IComplaintService {

	public Complaint addComplaint(Complaint complaint);

	public Complaint viewComplaintById(long id) throws ComplaintNotFoundException;

	public List<Complaint> viewAllComplaints();

	public boolean resolveComplaint(Complaint complaint);

}
