package com.abc.friendfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.friendfinder.entity.Poll;
import com.abc.friendfinder.exception.PollNotFoundException;
import com.abc.friendfinder.repository.PollRepository;

@Service
public class IPollServiceImpl implements IPollService {
	private PollRepository pollRepo;

	@Autowired
	public IPollServiceImpl(PollRepository pollRepo) {
		this.pollRepo = pollRepo;
	}

	@Override
	public Poll createPoll(Poll poll) {
		return pollRepo.saveAndFlush(poll);
	}

	@Override
	public Poll veiwPollById(long id) throws PollNotFoundException {
		if (pollRepo.existsById(id)) {
			return pollRepo.findById(id).get();
		} else {
			throw new PollNotFoundException("Poll Not Found");
		}
	}

	@Override
	public void deletePoll(long id) throws PollNotFoundException {
		if (pollRepo.existsById(id)) {
			pollRepo.deleteById(id);
		} else {
			throw new PollNotFoundException("Poll Not Found");
		}

	}

	@Override
	public boolean participatePoll(Poll poll, String answer) {
		if (pollRepo.existsById(poll.getId())) {
			if (poll.getAnswers().contains(answer)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
