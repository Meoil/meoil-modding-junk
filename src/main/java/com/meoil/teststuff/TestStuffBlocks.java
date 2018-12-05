package com.meoil.teststuff;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class TestStuffBlocks {
	public static BlockSpicyCube SPICYCUBE;
	public static BlockBoringBlock BORINGBLOCK;
	public static BlockConveyor CONVEYOR;
	public static ItemBlock ITEMBLOCKSPICYCUBE;
	public static ItemBlock ITEMBLOCKBORINGBLOCK;
	public static ItemBlock ITEMBLOCKCONVEYOR;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> r = event.getRegistry();
		SPICYCUBE = new BlockSpicyCube();
		BORINGBLOCK = new BlockBoringBlock();
		CONVEYOR = new BlockConveyor();
		r.register(SPICYCUBE);
		r.register(BORINGBLOCK);
		r.register(CONVEYOR);
		GameRegistry.registerTileEntity(TileEntityConveyor.class, new ResourceLocation(TestStuff.MODID, "block.conveyor"));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> r = event.getRegistry();
		ITEMBLOCKSPICYCUBE = new ItemBlock(SPICYCUBE);
		ITEMBLOCKBORINGBLOCK = new ItemBlock(BORINGBLOCK);
		ITEMBLOCKCONVEYOR = new ItemBlock(CONVEYOR);
		ITEMBLOCKSPICYCUBE.setRegistryName(SPICYCUBE.getRegistryName());
		ITEMBLOCKBORINGBLOCK.setRegistryName(BORINGBLOCK.getRegistryName());
		ITEMBLOCKCONVEYOR.setRegistryName(CONVEYOR.getRegistryName());
		r.register(ITEMBLOCKSPICYCUBE);
		r.register(ITEMBLOCKBORINGBLOCK);
		r.register(ITEMBLOCKCONVEYOR);
	}
}
