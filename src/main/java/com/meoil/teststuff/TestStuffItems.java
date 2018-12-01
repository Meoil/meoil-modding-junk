package com.meoil.teststuff;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TestStuffItems {
	
	public static ItemSuctionShirt SUCTION_SHIRT;
	public static ItemFloatyPants FLOATY_PANTS;
	public static ItemSwiftBoots SWIFT_BOOTS;
	public static ItemBooster BOOSTER;
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> r = event.getRegistry();
		SUCTION_SHIRT = new ItemSuctionShirt();
		FLOATY_PANTS = new ItemFloatyPants();
		BOOSTER = new ItemBooster();
		SWIFT_BOOTS = new ItemSwiftBoots();
		r.register(SUCTION_SHIRT);
		r.register(FLOATY_PANTS);
		r.register(BOOSTER);
		r.register(SWIFT_BOOTS);
	}
}
