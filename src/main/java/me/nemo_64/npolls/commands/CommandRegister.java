package me.nemo_64.npolls.commands;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.npolls.commands.npolls.NPollsCommand;
import me.nemo_64.npolls.util.constants.IPermissionsConstants;

public class CommandRegister implements IPermissionsConstants {

	public static void registerCommands(NPolls main) {
		main.getCommand("npolls").setExecutor(new NPollsCommand(main, NPOLLS_COMMAND_NPOLLS));
	}

}
