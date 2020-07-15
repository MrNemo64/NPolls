package me.nemo_64.npolls.commands.npolls;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.npolls.polls.EditePoll;
import me.nemo_64.npolls.util.constants.IPermissionsConstants;
import me.nemo_64.spigotutilities.commands.Argument;

public class NPollsCommandCreateArgument extends Argument {

	public NPollsCommandCreateArgument(NPolls main) {
		super(main, IPermissionsConstants.NPOLLS_COMMAND_NPOLLS_CREATE);
	}

	@Override
	protected void runArgument(CommandSender sender, String... args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				EditePoll editePoll = new EditePoll(player, plugin);
				editePoll.openInventory();
				plugin.getEditingSesions().put(player.getUniqueId(), editePoll);
			} else {

			}
			return;
		}
	}

}
