package me.nemo_64.npolls.polls;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.cryptomorin.xseries.XMaterial;
import com.tchristofferson.pagedinventories.IPagedInventory;
import com.tchristofferson.pagedinventories.NavigationRow;
import com.tchristofferson.pagedinventories.handlers.PagedInventoryClickHandler;
import com.tchristofferson.pagedinventories.handlers.PagedInventoryCloseHandler;
import com.tchristofferson.pagedinventories.navigationitems.CloseNavigationItem;
import com.tchristofferson.pagedinventories.navigationitems.NextNavigationItem;
import com.tchristofferson.pagedinventories.navigationitems.PreviousNavigationItem;

import me.nemo_64.npolls.NPolls;
import me.nemo_64.npolls.util.constants.IMessageConstants;
import me.nemo_64.spigotutilities.ItemBuilder;
import me.nemo_64.spigotutilities.interfaces.IMessageUtil;

public class EditePoll extends Poll implements IMessageConstants, IMessageUtil {

	private Player editor;
	private IPagedInventory inv;
	private NPolls plugin;

	public EditePoll(@Nonnull UUID editor, @Nonnull NPolls plugin) {
		this(Bukkit.getPlayer(editor), plugin);
	}

	public EditePoll(@Nonnull Player editor, @Nonnull NPolls plugin) {
		super();
		this.editor = editor;
		this.plugin = plugin;
	}

	public void openInventory() {
		if (inv == null)
			createInventory();
		inv.open(editor);
	}

	private void createInventory() {
		NavigationRow row = new NavigationRow(new NextNavigationItem(XMaterial.ARROW.parseItem()),
				new PreviousNavigationItem(XMaterial.ARROW.parseItem()),
				new CloseNavigationItem(new ItemBuilder(XMaterial.BARRIER.parseMaterial()).setName("&6Test").build()));
		inv = NPolls.PAGED_INVENTORY.createPagedInventory(row);
		Inventory pageGeneral = Bukkit.createInventory(null, 54, getMessage(POLLS_EDITTING_GENERAL_PAGE_TITLE));

		inv.addPage(pageGeneral);

		Inventory pageOptions = Bukkit.createInventory(null, 54, getMessage(POLLS_EDITTING_OPTIONS_PAGE_TITLE));
		inv.addPage(pageOptions);

		inv.addHandler(new PagedInventoryClickHandler() {
			@Override
			public void handle(
					com.tchristofferson.pagedinventories.handlers.PagedInventoryClickHandler.Handler handler) {
				handler.getPlayer().sendMessage("click(noraw):" + handler.getSlot() + " (raw):" + handler.getRawSlot()
						+ " (hotbar):" + handler.getHotbarButton());
			}
		});

		inv.addHandler(new PagedInventoryCloseHandler() {
			@Override
			public void handle(
					com.tchristofferson.pagedinventories.handlers.PagedInventoryCloseHandler.Handler handler) {
				handler.getPlayer().sendMessage("close");
				plugin.getEditingSesions().remove(editor.getUniqueId());
			}
		});
	}

	public void addOption(@Nonnull PollItem option) {
		getOptions().add(option);
	}

	public void addOption(@Nonnull ItemStack option) {
		addOption(new PollItem(option));
	}

	@Nonnull
	public PollItem removeOption(@Nonnegative int i) {
		return getOptions().remove(i);
	}

	@Nullable
	public PollItem removeOption(@Nonnull PollItem option) {
		return getOptions().contains(option) ? getOptions().remove(getOptions().indexOf(option)) : null;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setOptions(@Nonnull List<PollItem> options) {
		this.options = options;
	}

	public Player getEditor() {
		return editor;
	}

	@Override
	public FileConfiguration getMessageFile() {
		return plugin.getMessageFile();
	}

}
