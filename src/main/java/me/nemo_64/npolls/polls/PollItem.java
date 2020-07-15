package me.nemo_64.npolls.polls;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PollItem {

	private ItemStack item;

	public PollItem() {
		this(createDefaultItem());
	}

	public PollItem(@Nonnull ItemStack item) {
		this.item = item;
	}

	public PollItem(@Nonnull Material mat, @Nullable String name, @Nullable String... lore) {
		this(mat, name, Arrays.asList(lore));
	}

	public PollItem(@Nonnull Material mat, @Nullable String name, @Nullable List<String> lore) {
		ItemStack item = new ItemStack(mat);

		ItemMeta meta = item.getItemMeta();

		if (name != null)
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		if (lore != null)
			for (int i = 0; i < lore.size(); i++)
				lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
		meta.setLore(lore);

		item.setItemMeta(meta);

		this.item = item;
	}

	public void setName(@Nullable String name) {
		item.getItemMeta().setDisplayName(name);
	}

	@Nullable
	public String getName() {
		return item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : null;
	}

	public void setLore(@Nullable List<String> lore) {
		item.getItemMeta().setLore(lore);
	}

	public void setLore(@Nullable String... lore) {
		setLore(Arrays.asList(lore));
	}

	@Nullable
	public List<String> getLore() {
		return item.getItemMeta().hasLore() ? item.getItemMeta().getLore() : null;
	}

	public void setType(@Nonnull Material type) {
		item.setType(type);
	}

	@Nonnull
	public Material getType() {
		return item.getType();
	}

	@Nonnull
	public ItemStack getItem() {
		return item;
	}

	public void setItem(@Nonnull ItemStack item) {
		this.item = item;
	}

	@Nonnull
	public static ItemStack createDefaultItem() {
		ItemStack item = new ItemStack(Material.PAPER);
		return item;
	}

}
