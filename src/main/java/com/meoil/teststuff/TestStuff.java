package com.meoil.teststuff;

import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TestStuff.MODID, name = TestStuff.NAME, version = TestStuff.VERSION)
public class TestStuff {
    public static final String MODID = "teststuff";
    public static final String NAME = "Test Stuff";
    public static final String VERSION = "1.0";

    public static CreativeTabs TAB_TESTSTUFF = new CreativeTabs("Test Stuff") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.FEATHER);
		}
	};
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(TestStuffItems.class);
		MinecraftForge.EVENT_BUS.register(TestStuffBlocks.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

    }
}
