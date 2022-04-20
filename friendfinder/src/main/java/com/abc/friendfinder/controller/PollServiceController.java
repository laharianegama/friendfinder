package com.abc.friendfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.friendfinder.entity.Poll;
import com.abc.friendfinder.exception.PollNotFoundException;
import com.abc.friendfinder.service.IPollServiceImpl;

//Poll requests are mapped to this controller
@RestController
@RequestMapping("/poll")
public class PollServiceController {
	
	
	@Autowired
	private IPollServiceImpl pollservice;
	
	//admin creates a poll 
	@PostMapping("/admin/create")
	public Poll createPoll(@RequestBody Poll poll) {
		return pollservice.createPoll(poll);
	}
	
	//admin views a poll by its id
	@GetMapping({"admin/view/{pollId}"})
	public Poll viewPollbyIdAdmin(@PathVariable long pollId)throws PollNotFoundException{
		return pollservice.veiwPollById(pollId);
	}
	
	//user views a poll by its id
	@GetMapping({"user/view/{pollId}"})
	public Poll viewPollbyIdUser(@PathVariable long pollId)throws PollNotFoundException{
		return pollservice.veiwPollById(pollId);
	}
	
	//admin deletes a poll by its id
	@DeleteMapping("/admin/delete/{pollId}")
	public void deletePollbyId(@PathVariable long pollId)throws PollNotFoundException{
		pollservice.deletePoll(pollId);
	}
	
	//user participates in a poll,answer is send in the path
	@GetMapping("user/participate/{answer}")
	public boolean participateInPoll(@RequestBody Poll poll,@PathVariable String answer) throws PollNotFoundException{
		return pollservice.participatePoll(poll,answer);
	}

}
