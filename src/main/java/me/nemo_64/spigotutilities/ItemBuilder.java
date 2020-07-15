package me.nemo_64.spigotutilities;

import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

	private Material material;
	private String name;
	private List<String> lore;
	private int amount;
	private boolean glowing;

	public ItemBuilder(@Nonnull Material material) {
		this(material, null, null , 1, false);
	}

	public ItemBuilder(@Nonnull Material material, @Nullable String name) {
		this(material, name, null, 1, false);
	}

	public ItemBuilder(@Nonnull Material material, @Nullable String name, @Nonnegative int amount, boolean glowing) {
		this(material, name, null, amount, glowing);
	}

	public ItemBuilder(@Nonnull Material material, @Nullable String name, @Nullable List<String> lore,
			@Nonnegative int amount, boolean glowing) {
		super();
		this.material = material;
		this.name = name;
		this.lore = lore;
		this.amount = amount;
		this.glowing = glowing;
	}

	public ItemBuilder setMaterial(@Nonnull Material material) {
		this.material = material;
		return this;
	}

	public ItemBuilder setName(@Nullable String name) {
		this.name = ChatColor.translateAlternateColorCodes('&', name);
		return this;
	}

	public ItemBuilder setLore(@Nullable List<String> lore) {
		for (int i = 0; i < lore.size(); i++)
			lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
		this.lore = lore;
		return this;
	}

	public ItemBuilder setAmount(@Nonnegative int amount) {
		this.amount = amount;
		return this;
	}

	public ItemBuilder setGlowing(boolean glowing) {
		this.glowing = glowing;
		return this;
	}

	@Nonnull
	public ItemStack build() {
		ItemStack item = new ItemStack(material, amount);
		if (name != null || lore != null || glowing) {
			ItemMeta meta = item.getItemMeta();

			if (name != null)
				meta.setDisplayName(name);

			if (lore != null)
				meta.setLore(lore);

			if (glowing) {
				item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}

			item.setItemMeta(meta);
		}
		return item;
	}

}
