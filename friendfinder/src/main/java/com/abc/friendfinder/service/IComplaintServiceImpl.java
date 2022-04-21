package com.abc.friendfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.friendfinder.entity.Complaint;
import com.abc.friendfinder.exception.ComplaintNotFoundException;
import com.abc.friendfinder.repository.ComplaintRepository;

@Service
public class IComplaintServiceImpl implements IComplaintService {
	private ComplaintRepository complaintRepo;

	@Autowired
	public IComplaintServiceImpl(ComplaintRepository complaintRepo) {
		super();
		this.complaintRepo = complaintRepo;
	}

	@Override
	public Complaint addComplaint(Complaint complaint) {
		complaintRepo.saveAndFlush(complaint);
		return complaint;
	}

	@Override
	public Complaint viewComplaintById(long id) throws ComplaintNotFoundException {
		if (complaintRepo.existsById(id)) {
			return complaintRepo.findById(id).get();
		} else {
			throw new ComplaintNotFoundException("Complaint Not Found");
		}
	}

	@Override
	public List<Complaint> viewAllComplaints() {
		return complaintRepo.findAll();
	}

	@Override
	public boolean resolveComplaint(Complaint complaint) {
		if (complaintRepo.existsById(complaint.getId())) {
			complaintRepo.deleteById(complaint.getId());
			return true;
		} else {
			return false;
		}
	}

}
