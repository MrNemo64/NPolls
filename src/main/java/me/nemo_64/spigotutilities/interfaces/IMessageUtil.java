package me.nemo_64.spigotutilities.interfaces;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;

import me.nemo_64.spigotutilities.MessageUtils;

/**
 * An implementation of {@link MessageUtils}. It has all the methods that
 * {@link MessageUtils} has but insted of asking in the arguments for a
 * {@link FileConfiguration} it has a method, {@link #getMessageFile()}, where
 * it gets the messages file
 * 
 * @author Nemo_64
 *
 */
@FunctionalInterface
public interface IMessageUtil {

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
	public default String color(char colorChar, @Nonnull String message) {
		return MessageUtils.color(colorChar, message);
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
	public default String color(@Nonnull String message) {
		return MessageUtils.color(message);
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
	public default List<String> color(char colorChar, @Nonnull List<String> message) {
		return MessageUtils.color(colorChar, message);
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
	public default List<String> color(@Nonnull List<String> message) {
		return MessageUtils.color(message);
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
	public default String[] color(char colorChar, @Nonnull String... message) {
		return MessageUtils.color(colorChar, message);
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
	public default String[] color(@Nonnull String... message) {
		return MessageUtils.color(message);
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
	public default String replaceVariables(@Nonnull String str, @Nonnull Map<String, String> variables) {
		return MessageUtils.replaceVariables(str, variables);
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
	public default String replaceVariables(@Nonnull String str, @Nonnull String[][] vars) {
		return MessageUtils.replaceVariables(str, vars);
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
	public default String replaceVariables(@Nonnull String str, @Nonnull String... vars) {
		return MessageUtils.replaceVariables(str, vars);
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
	public default List<String> replaceVariables(@Nonnull List<String> strs, @Nonnull Map<String, String> variables) {
		return MessageUtils.replaceVariables(strs, variables);
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
	public default List<String> replaceVariables(@Nonnull List<String> str, @Nonnull String[][] vars) {
		return MessageUtils.replaceVariables(str, vars);
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
	public default List<String> replaceVariables(@Nonnull List<String> str, @Nonnull String... vars) {
		return MessageUtils.replaceVariables(str, vars);
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
	public default Map<String, String> arrayToMap(@Nonnull String... array) {
		return MessageUtils.arrayToMap(array);
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
	public default Map<String, String> arrayToMap(@Nonnull String[][] array) {
		return MessageUtils.arrayToMap(array);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param path
	 *            The path of the message. If there is no path the path will be used
	 *            as value and this method will return the path
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns the path
	 */
	@Nonnull
	public default String getMessage(@Nonnull String path) {
		return MessageUtils.getMessage(getMessageFile(), path);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param path
	 *            The path of the message
	 * @param def
	 *            A default value that will get colored and returned if the
	 *            specified path does not exist
	 * @return The message in the specified path or the default value if the path
	 *         does not exist colored
	 */
	@Nullable
	public default String getMessage(@Nonnull String path, @Nullable String def) {
		return MessageUtils.getMessage(getMessageFile(), path, def);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param path
	 *            The path of the message. If there is no path the path will be used
	 *            as value and this method will return the path
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns the path
	 */
	@Nonnull
	public default String getMessage(@Nonnull String path, @Nonnull Map<String, String> vars) {
		return MessageUtils.getMessage(getMessageFile(), path, vars);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(String)}
	 * 
	 * @param path
	 *            The path of the message
	 * @param def
	 *            A default value that will get colored and returned if the
	 *            specified path does not exist
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path or the default value if the path
	 *         does not exist colored
	 */
	@Nullable
	public default String getMessage(@Nonnull String path, @Nullable String def, @Nonnull Map<String, String> vars) {
		return MessageUtils.getMessage(getMessageFile(), path, def, vars);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(List)}
	 * 
	 * @param path
	 *            The path of the message
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public default List<String> getMessageList(@Nonnull String path) {
		return MessageUtils.getMessageList(getMessageFile(), path);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #getMessageFile()}. This message gets then colored using
	 * {@link #color(List)}
	 * 
	 * @param path
	 *            The path of the message
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public default List<String> getMessageList(@Nonnull String path, @Nonnull Map<String, String> vars) {
		return MessageUtils.getMessageList(getMessageFile(), path, vars);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * 
	 * @param path
	 *            The path of the message
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public default String[] getMessageListAsArray(@Nonnull String path) {
		return MessageUtils.getMessageListAsArray(getMessageFile(), path);
	}

	/**
	 * Gets a message from the {@link FileConfiguration} specified in
	 * {@link #messages}. This message gets then colored using {@link #color(List)}
	 * and the variables replaced
	 * 
	 * @param path
	 *            The path of the message
	 * @param vars
	 *            The variables to replace on the string
	 * @return The message in the specified path colored. If the path does not exist
	 *         returns an empty list
	 */
	@Nonnull
	public default String[] getMessageListAsArray(@Nonnull String path, @Nonnull Map<String, String> vars) {
		return MessageUtils.getMessageListAsArray(getMessageFile(), path, vars);
	}

	/**
	 * Gets the {@link FileConfiguration} with all the messages
	 * 
	 * @return The {@link FileConfiguration}
	 */
	@Nonnull
	public FileConfiguration getMessageFile();

}