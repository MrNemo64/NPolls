package me.nemo_64.spigotutilities.commands;

import java.util.Arrays;

import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.nemo_64.npolls.NPolls;

public abstract class Argument {

	protected NPolls plugin;
	protected String perm;

	public Argument() {
		this(null, null);
	}

	public Argument(@Nullable String perm) {
		this(null, perm);
	}

	public Argument(@Nullable NPolls plugin) {
		this(plugin, null);
	}

	public Argument(@Nullable NPolls plugin, @Nullable String perm) {
		this.plugin = plugin;
		this.perm = perm;
	}

	protected abstract void runArgument(CommandSender sender, String... args);

	public void executeArgument(CommandSender sender, String... args) {
		if (perm == null || sender.hasPermission(perm)) {
			runArgument(sender, args.length <= 1 ? new String[] {} : Arrays.copyOfRange(args, 1, args.length));
		} else {
			notEnoughPermissions(sender, args.length <= 1 ? new String[] {} : Arrays.copyOfRange(args, 1, args.length));
		}
	}

	public void notEnoughPermissions(CommandSender sender, String... args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&cYou can't use this argument. You don't have enough permissions"));
	}

}
