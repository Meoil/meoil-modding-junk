package com.meoil.teststuff;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TestStuffItems {
	
	public static ItemSwiftBoots SWIFT_BOOTS;
	public static ItemBooster BOOSTER;
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> r = event.getRegistry();
		BOOSTER = new ItemBooster();
		SWIFT_BOOTS = new ItemSwiftBoots();
		r.register(SWIFT_BOOTS);
		r.register(BOOSTER);
	}
}
