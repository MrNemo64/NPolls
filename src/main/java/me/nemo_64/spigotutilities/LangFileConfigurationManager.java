package me.nemo_64.spigotutilities;

import java.io.File;

import javax.annotation.Nonnull;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class LangFileConfigurationManager extends FileConfigurationManager {

	public LangFileConfigurationManager(@Nonnull File file, @Nonnull Plugin main, boolean autoRegister) {
		super(file, main, autoRegister);
	}

	public LangFileConfigurationManager(@Nonnull FileConfiguration config, @Nonnull String path,
			@Nonnull File langFolder, @Nonnull Plugin plugin, boolean autoRegister) {
		this(new File(langFolder, config.getString(path, "lang.yml")), plugin, autoRegister);
	}

	public LangFileConfigurationManager(@Nonnull FileConfiguration config, @Nonnull File langFolder,
			@Nonnull Plugin plugin, boolean autoRegister) {
		this(new File(langFolder, config.getString("lang", "lang.yml")), plugin, autoRegister);
	}

	public LangFileConfigurationManager(@Nonnull FileConfiguration config, @Nonnull Plugin plugin,
			boolean autoRegister) {
		this(new File(new File(plugin.getDataFolder(), "lang"), config.getString("lang", "lang.yml")), plugin,
				autoRegister);
	}

	@Override
	public void registerFile() {
		super.registerFile("lang/" + getFile().getName());
	}

	@Override
	public boolean check() {
		return super.check("lang/" + getFile().getName());
	}

}
