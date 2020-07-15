package me.nemo_64.spigotutilities.commands;

import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.nemo_64.npolls.NPolls;

public abstract class Command implements CommandExecutor {

	protected NPolls plugin;
	protected String perm;

	public Command() {
		this(null, null);
	}

	public Command(@Nullable String perm) {
		this(null, perm);
	}

	public Command(@Nullable NPolls plugin) {
		this(plugin, null);
	}

	public Command(@Nullable NPolls plugin, @Nullable String perm) {
		this.plugin = plugin;
		this.perm = perm;
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String cmd, String[] args) {
		if (perm == null || sender.hasPermission(perm)) {
			runCommand(sender, args);
		} else {
			notEnoughPermissions(sender, command, args);
		}
		return false;
	}

	public void notEnoughPermissions(CommandSender sender, org.bukkit.command.Command command, String... args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"You can't use this command. You don't have enough permissions"));
	}

	public abstract void runCommand(CommandSender sender, String... args);

}
