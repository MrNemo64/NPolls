package me.nemo_64.spigotutilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FileConfigurationManager {

	private Plugin p;
	private File file;
	private FileConfiguration conf;

	/**
	 * @param file
	 *            The file
	 * @param autoRegister
	 *            If true, the file will be autoregistered
	 */
	public FileConfigurationManager(@Nonnull File file, @Nonnull Plugin main, boolean autoRegister) {
		this.file = file;
		this.p = main;
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Bukkit.getLogger().warning("Couldn't create the file " + file.getName());
			}
		}
		if (autoRegister)
			registerFile();
	}

	public void registerFile() {
		conf = YamlConfiguration.loadConfiguration(getFile());
		if (check())
			save();
	}

	public void registerFile(@Nullable String defPath) {
		conf = YamlConfiguration.loadConfiguration(getFile());
		if (check(defPath))
			save();
	}

	/**
	 * Check is the file contains all the keys as another one<br>
	 * A file with the same name inside the jar file will be searched. If not found
	 * this methof will return false and a message will show on console
	 * 
	 * @return True if the file has been updated
	 */
	public boolean check() {
		try (InputStream in = p.getResource(getFile().getName())) {
			if (in == null) {
				Bukkit.getLogger().warning("Couldn't find the defaults the file " + file.getName());
				return false;
			}
			InputStreamReader reader = new InputStreamReader(in);
			FileConfiguration def = YamlConfiguration.loadConfiguration(reader);
			return check(def);
		} catch (IOException e) {
			Bukkit.getLogger().warning("Couldn't find the defaults the file " + file.getName());
			return false;
		}
	}

	/**
	 * Check is the file contains all the keys as another one
	 * 
	 * @param def
	 *            The file with all the keys to be checked
	 * @return True if the file has been updated
	 */
	public boolean check(@Nonnull FileConfiguration def) {
		return checkFile(getConfFile(), def);
	}

	/**
	 * Check is the file contains all the keys as another one<br>
	 * A file with the same name inside the jar file will be searched. If not found
	 * this methof will return false and a message will show on console
	 * 
	 * @param def
	 *            The file with all the keys to be checked
	 * @return True if the file has been updated
	 */
	public boolean check(@Nonnull String defS) {
		try (InputStream in = p.getResource(defS)) {
			if (in == null) {
				Bukkit.getLogger().warning("Couldn't find the defaults the file " + defS);
				return false;
			}
			InputStreamReader reader = new InputStreamReader(in);
			FileConfiguration def = YamlConfiguration.loadConfiguration(reader);
			return check(def);
		} catch (IOException e) {
			Bukkit.getLogger().warning("Couldn't find the defaults the file " + defS);
			return false;
		}
	}

	/**
	 * Saves the file configuration
	 */
	public void save() {
		try {
			getConfFile().save(getFile());
		} catch (IOException e) {
			Bukkit.getLogger().warning("Couldn't save the file " + file.getName());
		}
	}

	/**
	 * Check is a given file contains all the keys as another one
	 * 
	 * @param toCheck
	 *            The file to check if it has all the keys
	 * @param def
	 *            The file with all the keys to be checked
	 * @return True if the file to check has been updated
	 */
	public static boolean checkFile(@Nonnull FileConfiguration toCheck, @Nonnull FileConfiguration def) {
		boolean flag = false;
		for (String key : def.getKeys(true)) {
			if (def.get(key) instanceof ConfigurationSection)
				continue;
			if (!toCheck.contains(key)) {
				toCheck.set(key, def.get(key));
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * @return The file of the file configuration
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @return The configuration file
	 */
	public FileConfiguration getConfFile() {
		return conf;
	}

	@Nullable
	public String getString(@Nonnull String path, @Nullable String def) {
		return getConfFile().getString(path, def);
	}

	@Nullable
	public String getString(@Nonnull String path) {
		return getConfFile().getString(path);
	}

	public int getInt(@Nonnull String path) {
		return getConfFile().getInt(path);
	}

	public int getInt(@Nonnull String path, int def) {
		return getConfFile().getInt(path, def);
	}

}