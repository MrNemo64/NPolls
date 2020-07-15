package me.nemo_64.spigotutilities.commands;

import javax.annotation.Nullable;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.spigotutilities.MessageUtils;

public abstract class PlayerCommand extends Command {

	public PlayerCommand(@Nullable NPolls plugin, @Nullable String perm) {
		super(plugin, perm);
	}

	@Override
	public void runCommand(CommandSender sender, String... args) {
		if (!(sender instanceof Player)) {
			noPlayerEjecutesCommand(sender);
			return;
		}
		runPlayerCommand((Player) sender, args);
	}

	/**
	 * Method ejecuted if the command is executed but the comand sender is not a
	 * player
	 * 
	 * @param sender
	 *            The sender
	 */
	public void noPlayerEjecutesCommand(CommandSender sender) {
		sender.sendMessage(MessageUtils.color("&cThis command is only for players"));
	}

	public abstract void runPlayerCommand(Player player, String... args);

}
