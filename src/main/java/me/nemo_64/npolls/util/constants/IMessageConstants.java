package me.nemo_64.npolls.util.constants;

public interface IMessageConstants {

	public static final String NOT_ENOUGH_PERMISSIONS = "not-enough-permissions";

	static final String INVENTORY_TITLE = "title";
	
	static final String POLLS = "polls.";
	static final String POLLS_EDITTING = POLLS + "editting.";
	static final String POLLS_EDITTING_GENERAL_PAGE = POLLS_EDITTING + "general-page.";
	public static final String POLLS_EDITTING_GENERAL_PAGE_TITLE = POLLS_EDITTING_GENERAL_PAGE + INVENTORY_TITLE;
	static final String POLLS_EDITTING_OPTIONS_PAGE = POLLS_EDITTING + "options-page.";
	public static final String POLLS_EDITTING_OPTIONS_PAGE_TITLE = POLLS_EDITTING_OPTIONS_PAGE + INVENTORY_TITLE;
	
	static final String COMMANDS = "commands.";
	static final String ARGUMENTS = "arguments.";

	static final String COMMANDS_NPOLLS = COMMANDS + "npolls.";
	static final String COMMANDS_NPOLLS_ARGUMENTS = COMMANDS_NPOLLS + ARGUMENTS;
	static final String COMMANDS_NPOLLS_ARGUMENTS_HELP = COMMANDS_NPOLLS_ARGUMENTS + "help.";
	public static final String COMMANDS_NPOLLS_ARGUMENTS_HELP_HEADER = COMMANDS_NPOLLS_ARGUMENTS_HELP + "header";
	public static final String COMMANDS_NPOLLS_ARGUMENTS_HELP_COMMANDS = COMMANDS_NPOLLS_ARGUMENTS_HELP + "commands";
	public static final String COMMANDS_NPOLLS_ARGUMENTS_HELP_APIS = COMMANDS_NPOLLS_ARGUMENTS_HELP + "apis";

}
