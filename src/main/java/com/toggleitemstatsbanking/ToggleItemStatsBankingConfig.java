package com.toggleitemstatsbanking;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("toggleitemstatsbanking")
public interface ToggleItemStatsBankingConfig extends Config
{
	@ConfigItem(
			keyName = "consumableStats",
			name = "Toggle consumable stats",
			description = "Toggles tooltips for consumable items (food, boosts)"
	)
	default boolean consumableStats()
	{
		return true;
	}

	@ConfigItem(
			keyName = "equipmentStats",
			name = "Toggle equipment stats",
			description = "Toggles tooltips for equipment items (combat bonuses, weight, prayer bonuses)"
	)
	default boolean equipmentStats()
	{
		return true;
	}
}
