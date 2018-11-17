package com.meoil.teststuff;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TestStuffBlocks {
	public static BlockSpicyCube SPICYCUBE;
	public static BlockBoringBlock BORINGBLOCK;
	public static ItemBlock ITEMBLOCKSPICYCUBE;
	public static ItemBlock ITEMBLOCKBORINGBLOCK;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> r = event.getRegistry();
		SPICYCUBE = new BlockSpicyCube();
		BORINGBLOCK = new BlockBoringBlock();
		r.register(SPICYCUBE);
		r.register(BORINGBLOCK);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> r = event.getRegistry();
		ITEMBLOCKSPICYCUBE = new ItemBlock(SPICYCUBE);
		ITEMBLOCKBORINGBLOCK = new ItemBlock(BORINGBLOCK);
		ITEMBLOCKSPICYCUBE.setRegistryName(SPICYCUBE.getRegistryName());
		ITEMBLOCKBORINGBLOCK.setRegistryName(BORINGBLOCK.getRegistryName());
		r.register(ITEMBLOCKSPICYCUBE);
		r.register(ITEMBLOCKBORINGBLOCK);
	}
}
