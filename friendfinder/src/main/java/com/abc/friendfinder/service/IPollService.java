package com.abc.friendfinder.service;

import com.abc.friendfinder.entity.Poll;
import com.abc.friendfinder.exception.PollNotFoundException;

public interface IPollService {

	public Poll createPoll(Poll poll);

	public Poll veiwPollById(long id) throws PollNotFoundException;

	public void deletePoll(long id) throws PollNotFoundException;

	public boolean participatePoll(Poll poll, String answer);

}
