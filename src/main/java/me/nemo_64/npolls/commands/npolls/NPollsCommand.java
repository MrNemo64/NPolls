package me.nemo_64.npolls.commands.npolls;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.npolls.util.constants.IMessageConstants;
import me.nemo_64.npolls.util.constants.IPermissionsConstants;
import me.nemo_64.spigotutilities.commands.Command;
import me.nemo_64.spigotutilities.interfaces.IMessageUtil;

public class NPollsCommand extends Command implements IMessageUtil, IMessageConstants, IPermissionsConstants {

	public NPollsCommand(NPolls main, String perm) {
		super(main, perm);
	}

	@Override
	public void runCommand(CommandSender sender, String... args) {
		if (args.length == 0) {
			new NPollsCommandHelpArgument(plugin).executeArgument(sender, args);
			return;
		}
		
		switch (args[0].toLowerCase()) {
		case "help":
			new NPollsCommandHelpArgument(plugin).executeArgument(sender, args);
			break;
		case "create":
			new NPollsCommandCreateArgument(plugin).executeArgument(sender, args);
			break;
		default:
			break;
		}
	}

	@Override
	public void notEnoughPermissions(CommandSender sender, org.bukkit.command.Command command, String... args) {
		sender.sendMessage(getMessage(NOT_ENOUGH_PERMISSIONS));
	}

	@Override
	public FileConfiguration getMessageFile() {
		return plugin.getMessageFile();
	}
}
