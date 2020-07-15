package me.nemo_64.npolls.polls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActivePoll {

	private List<ActivePollItem> options;
	private String permission;
	private Date startedOn;
	private long duration;

	protected ActivePoll() {}

	public ActivePoll(@Nonnull Poll poll) {
		startedOn = new Date();
		duration = -1;
		options = new ArrayList<ActivePollItem>();
		permission = poll.getPermission();
		poll.getOptions().forEach(option -> options.add(new ActivePollItem(option)));
	}

	public void anounce() {
		Bukkit.getOnlinePlayers().forEach((player) -> {
			if(player.hasPermission(getPermission()))
				sendVoteMessage(player);
		});
	}
	
	public void sendVoteMessage(Player player) {
		throw new NotImplementedException(getClass());
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public List<ActivePollItem> getOptions() {
		return options;
	}

	public Date getStartedOn() {
		return startedOn;
	}

}
