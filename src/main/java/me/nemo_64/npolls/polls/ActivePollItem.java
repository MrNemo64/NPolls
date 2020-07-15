package me.nemo_64.npolls.polls;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ActivePollItem extends PollItem {

	private List<UUID> voted;

	protected ActivePollItem() {}

	public ActivePollItem(ItemStack item) {
		super(item);
		voted = new ArrayList<UUID>();
	}

	public ActivePollItem(Material mat, String name, String... lore) {
		super(mat, name, lore);
		voted = new ArrayList<UUID>();
	}

	public ActivePollItem(Material mat, String name, List<String> lore) {
		super(mat, name, lore);
		voted = new ArrayList<UUID>();
	}

	public ActivePollItem(@Nonnull PollItem option) {
		super();
		setType(option.getType());
		setName(option.getName());
		setLore(option.getLore());
		voted = new ArrayList<UUID>();
	}

	@Nonnull
	public List<UUID> getVoted() {
		return voted;
	}

	public void setVoted(@Nonnull List<UUID> voted) {
		this.voted = voted;
	}

	public void addVoter(@Nonnull UUID voter) {
		getVoted().add(voter);
	}

	@Nullable
	public UUID removeVoter(@Nonnull UUID voter) {
		return getVoted().contains(voter) ? getVoted().remove(getVoted().indexOf(voter)) : null;
	}

	@Nullable
	public UUID removeVoter(@Nonnegative int i) {
		if (i < getVoted().size())
			return getVoted().remove(i);
		return null;
	}

}
