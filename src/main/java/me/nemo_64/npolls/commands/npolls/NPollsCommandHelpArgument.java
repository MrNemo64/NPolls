package me.nemo_64.npolls.commands.npolls;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.npolls.util.constants.IMessageConstants;
import me.nemo_64.npolls.util.constants.IPermissionsConstants;
import me.nemo_64.spigotutilities.commands.Argument;
import me.nemo_64.spigotutilities.interfaces.IMessageUtil;

public class NPollsCommandHelpArgument extends Argument implements IMessageUtil, IMessageConstants {

	public NPollsCommandHelpArgument(NPolls main) {
		super(main, IPermissionsConstants.NPOLLS_COMMAND_NPOLLS_HELP);
	}

	@Override
	public void runArgument(CommandSender sender, String... args) {
		sendMessageTo(sender);
	}

	public void sendMessageTo(CommandSender sender) {
		sender.sendMessage(getMessage(COMMANDS_NPOLLS_ARGUMENTS_HELP_HEADER));
		sender.sendMessage(getMessageListAsArray(COMMANDS_NPOLLS_ARGUMENTS_HELP_COMMANDS));
		sender.sendMessage(getMessageListAsArray(COMMANDS_NPOLLS_ARGUMENTS_HELP_APIS));
		sender.sendMessage(getMessage(COMMANDS_NPOLLS_ARGUMENTS_HELP_HEADER));
	}

	@Override
	public FileConfiguration getMessageFile() {
		return plugin.getMessageFile();
	}

}
