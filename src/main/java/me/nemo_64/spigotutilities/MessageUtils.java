package me.nemo_64.spigotutilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import me.nemo_64.spigotutilities.interfaces.IMessageUtil;

/**
 * A class with a lot of usefull methods to handle messages
 * 
 * @author Nemo_64
 * @see IMessageUtil
 *
 */
public class MessageUtils {

	/**
	 * Colores a message
	 * 
	 * @param colorChar
	 *            The char to indicate the color
	 * @param message
	 *            The message to be colored
	 * @return The colored message
	 * @see #color(String)
	 */
	@Nonnull
	public static String color(char colorChar, @Nonnull String message) {
		return ChatColor.translateAlternateColorCodes(colorChar, message);
	}

	/**
	 * Colores a message. It uses as color char '&'
	 * 
	 * @param message
	 *            The message to be colored
	 * @return The colored message
	 * @see #color(char, String)
	 */
	@Nonnull
	public static String color(@Nonnull String message) {
		return color('&', message);
	}

	/**
	 * Colors a message
	 * 
	 * @param colorChar
	 *            The char to identificate a color
	 * @param message
	 *            The message to be colored
	 * @return The message colored
	 * @see #color(List)
	 */
	@Nonnull
	public static List<String> color(char colorChar, @Nonnull List<String> message) {
		for (int i = 0; i < message.size(); i++)
			message.set(i, color(colorChar, message.get(i)));
		return message;
	}

	/**
	 * Colors a message
	 * 
	 * @param message
	 *            The message to be colored
	 * @return The message colored
	 * @see #color(char, List)
	 */
	@Nonnull
	public static List<String> color(@Nonnull List<String> message) {
		for (int i = 0; i < message.size(); i++)
			message.set(i, color(message.get(i)));
		return message;
	}

	/**
	 * Colors a message
	 * 
	 * @param colorChar
	 *            The char to identificate a color
	 * @param message
	 *            The message to be colored
	 * @return The message colored
	 * @see #color(String...)
	 */
	@Nonnull
	public static String[] color(char colorChar, @Nonnull String... message) {
		for (int i = 0; i < message.length; i++)
			message[i] = color(colorChar, message[i]);
		return message;
	}

	/**
	 * Colors a message
	 * 
	 * @param message
	 *            The message to be colored
	 * @return The message colored
	 * @see #color(char, String...)
	 * 
	 */
	@Nonnull
	public static String[] color(@Nonnull String... message) {
		for (int i = 0; i < message.length; i++)
			message[i] = color(message[i]);
		return message;
	}

	/**
	 * Replaces all the variables in a given string
	 * 
	 * @param str
	 *            The string to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 * @see #replaceVariables(String, String...)
	 * @see #replaceVariables(String, String[][])
	 */
	@Nonnull
	public static String replaceVariables(@Nonnull String str, @Nonnull Map<String, String> variables) {
		for (Entry<String, String> variable : variables.entrySet())
			str = str.replace(variable.getKey(), variable.getValue());
		return str;
	}

	/**
	 * Replaces all the variables in a given list
	 * 
	 * @param strs
	 *            The list to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 * @see #replaceVariables(String, Map)
	 * @see #replaceVariables(String, String...)
	 * @see #arrayToMap(String[][])
	 */
	public static String replaceVariables(@Nonnull String str, @Nonnull String[][] vars) {
		return replaceVariables(str, arrayToMap(vars));
	}

	/**
	 * Replaces all the variables in a given list
	 * 
	 * @param strs
	 *            The list to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 * @see #replaceVariables(String, Map)
	 * @see #replaceVariables(String, String[][])
	 * @see #arrayToMap(String...)
	 */
	public static String replaceVariables(@Nonnull String str, @Nonnull String... vars) {
		return replaceVariables(str, arrayToMap(vars));
	}

	/**
	 * Replaces all the variables in a given list
	 * 
	 * @param strs
	 *            The list to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 */
	@Nonnull
	public static List<String> replaceVariables(@Nonnull List<String> strs, @Nonnull Map<String, String> variables) {
		for (int i = 0; i < strs.size(); i++)
			strs.set(i, replaceVariables(strs.get(i), variables));
		return strs;
	}

	/**
	 * Replaces all the variables in a given list
	 * 
	 * @param strs
	 *            The list to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 * @see #replaceVariables(List, Map)
	 * @see #replaceVariables(List, String...)
	 * @see #arrayToMap(String[][])
	 */
	public static List<String> replaceVariables(@Nonnull List<String> str, @Nonnull String[][] vars) {
		return replaceVariables(str, arrayToMap(vars));
	}

	/**
	 * Replaces all the variables in a given list
	 * 
	 * @param strs
	 *            The list to replace the variables on
	 * @param variables
	 *            The variables
	 * @return The string with the variables replaced
	 * @see #replaceVariables(List, Map)
	 * @see #replaceVariables(List, String[][])
	 * @see #arrayToMap(String...)
	 */
	public static List<String> replaceVariables(@Nonnull List<String> str, @Nonnull String... vars) {
		return replaceVariables(str, arrayToMap(vars));
	}

	/**
	 * Converts an array to a map. The value of a key is the value in the array in
	 * the next spot. The map gets created like<br>
	 * <code>
		for (int i = 0; i < array.length; i++)<br>
			map.put(array[i], array[++i]);
	 * </code><br>
	 * 
	 * @throws IllegalArgumentException
	 *             If the size of the array is odd
	 * @param array
	 *            The array to be convertted to a map
	 * @return The array as a map
	 */
	@Nonnull
	public static Map<String, String> arrayToMap(@Nonnull String... array) {
		if (array.length % 2 != 0)
			throw new IllegalArgumentException("The specified array has not a even number size");
		Map<String, String> map = new HashMap<String, String>(array.length / 2);
		for (int i = 0; i < array.length; i++)
			map.put(array[i], array[++i]);
		return map;
	}

	/**
	 * Converts a bidimensional array to a map.<br>
	 * If {@code array[i].length == 1} the value for that key will be null.<br>
	 * If {@code array[i].length > 2 } the value for that key will be
	 * {@code array[i][1]}.<br>
	 * 
	 * @param array
	 *            The bidimensional array to turn into a map
	 * @return The bidimensional array as a map
	 */
	@Nonnull
	public static Map<String, String> arrayToMap(@Nonnull String[][] array) {
		Map<String, String> map = new HashMap<String, String>(array.length);
		for (int i = 0; i < array.length; i++)
			map.put(array[i][0], array[i].length > 1 ? array[i][1] : null);
		return map;
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message. If there is no path the path will be used
	 *            as value and this method will return the path
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns the path
	 */
	@Nonnull
	public static String getMessage(@Nonnull FileConfiguration messages, @Nonnull String path) {
		return color(messages.getString(path, path));
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @param def
	 *            A static value that will get colored and returned if the specified
	 *            path does not exist
	 * @return The message in the specified path or the static value if the path
	 *         does not exist colored
	 */
	@Nullable
	public static String getMessage(@Nonnull FileConfiguration messages, @Nonnull String path, @Nullable String def) {
		return color(messages.getString(path, def));
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message. If there is no path the path will be used
	 *            as value and this method will return the path
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns the path
	 */
	@Nonnull
	public static String getMessage(@Nonnull FileConfiguration messages, @Nonnull String path,
			@Nonnull Map<String, String> vars) {
		return color(replaceVariables(messages.getString(path, path), vars));
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @param def
	 *            A static value that will get colored and returned if the specified
	 *            path does not exist
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path or the static value if the path
	 *         does not exist colored
	 */
	@Nullable
	public static String getMessage(@Nonnull FileConfiguration messages, @Nonnull String path, @Nullable String def,
			@Nonnull Map<String, String> vars) {
		return color(replaceVariables(messages.getString(path, def), vars));
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public static List<String> getMessageList(@Nonnull FileConfiguration messages, @Nonnull String path) {
		return color(messages.getStringList(path));
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public static List<String> getMessageList(@Nonnull FileConfiguration messages, @Nonnull String path,
			@Nonnull Map<String, String> vars) {
		return color(replaceVariables(messages.getStringList(path), vars));
	}
	
	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public static String[] getMessageListAsArray(@Nonnull FileConfiguration messages, @Nonnull String path) {
		List<String> list = color(messages.getStringList(path));
		return list.toArray(new String[list.size()]);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * and the variables replaced
	 * 
	 * @param messages
	 *            The {@link FileConfiguration} with the messages
	 * @param path
	 *            The path of the message
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public static String[] getMessageListAsArray(@Nonnull FileConfiguration messages, @Nonnull String path,
			@Nonnull Map<String, String> vars) {
		List<String> list = color(replaceVariables(messages.getStringList(path), vars));
		return list.toArray(new String[list.size()]);
	}

}
