package com.toggleitemstatsbanking;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ToggleItemStatsBankingPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ToggleItemStatsBankingPlugin.class);
		RuneLite.main(args);
	}
}