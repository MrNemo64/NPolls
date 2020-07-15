package me.nemo_64.npolls;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.tchristofferson.pagedinventories.PagedInventoryAPI;

import me.nemo_64.npolls.commands.CommandRegister;
import me.nemo_64.npolls.polls.EditePoll;
import me.nemo_64.spigotutilities.FileConfigurationManager;
import me.nemo_64.spigotutilities.LangFileConfigurationManager;

public class NPolls extends JavaPlugin {

	public static PagedInventoryAPI PAGED_INVENTORY;

	private Map<UUID, EditePoll> editingSesions;

	private FileConfigurationManager config;
	private LangFileConfigurationManager messages;

	@Override
	public void onEnable() {
		Bukkit.getLogger().info("[NPolls] Starting");
		Bukkit.getLogger().info("[NPolls] Loading configuration and messages");
		config = new FileConfigurationManager(new File(getDataFolder(), "config.yml"), this, true);
		messages = new LangFileConfigurationManager(getConfig(), this, true);
		editingSesions = new HashMap<UUID, EditePoll>();
		Bukkit.getLogger().info("[NPolls] Registering commands");
		CommandRegister.registerCommands(this);
		Bukkit.getLogger().info("[NPolls] Loading apis");
		PAGED_INVENTORY = new PagedInventoryAPI(this);
		Bukkit.getLogger().info("[NPolls] Plugin started");
	}

	public Map<UUID, EditePoll> getEditingSesions() {
		return editingSesions;
	}
	///////////////////
	// Configuration //
	///////////////////

	public FileConfigurationManager getConfiguration() {
		return config;
	}

	@Override
	public FileConfiguration getConfig() {
		return getConfiguration().getConfFile();
	}

	//////////////
	// Messages //
	//////////////

	public FileConfigurationManager getMessages() {
		return messages;
	}

	public FileConfiguration getMessageFile() {
		return messages.getConfFile();
	}
}
