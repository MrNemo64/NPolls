package me.nemo_64.npolls.polls;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

public class Poll {

	protected List<PollItem> options;
	protected String permission;

	public Poll() {
		this(new ArrayList<PollItem>());
	}

	public Poll(@Nonnull List<PollItem> options) {
		this.options = options;
	}

	@Nonnull
	public ActivePoll startPoll() {
		return new ActivePoll(this);
	}

	@Nonnull
	public List<PollItem> getOptions() {
		return options;
	}

	public String getPermission() {
		return permission;
	}

}