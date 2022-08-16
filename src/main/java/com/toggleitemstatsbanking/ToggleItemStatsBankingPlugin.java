package com.toggleitemstatsbanking;

import com.google.inject.Provides;
import javax.inject.Inject;

import jdk.tools.jlink.internal.Jlink;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.itemstats.ItemStatConfig;
import net.runelite.client.plugins.itemstats.ItemStatPlugin;
import net.runelite.http.api.item.ItemStats;

@Slf4j
@PluginDescriptor(
	name = "Bank Item Stats Toggle",
	description = "Toggles Item Stats plugin's overlays when banking."
)

@PluginDependency(ItemStatPlugin.class)
public class ToggleItemStatsBankingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ToggleItemStatsBankingConfig config;

	@Inject
	public ConfigManager configManager;

	@Subscribe void onWidgetLoaded(WidgetLoaded event){
		if (event.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			if (config.equipmentStats())
			{
				configManager.setConfiguration("itemstat","equipmentStats",true);
			}

			if (config.consumableStats())
			{
				configManager.setConfiguration("itemstat","consumableStats",true);
			}
		}
	}

	@Subscribe void onWidgetClosed(WidgetClosed event){
		if(event.getGroupId() == WidgetID.BANK_GROUP_ID){
			if (config.equipmentStats())
			{
				configManager.setConfiguration("itemstat","equipmentStats",false);
			}

			if (config.consumableStats())
			{
				configManager.setConfiguration("itemstat","consumableStats",false);
			}
		}
	}

	@Provides
	ToggleItemStatsBankingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ToggleItemStatsBankingConfig.class);
	}
}
