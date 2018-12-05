package com.meoil.teststuff;

import net.minecraft.init.Blocks;

import com.elytradev.concrete.inventory.IContainerInventoryHolder;
import com.elytradev.concrete.inventory.gui.ConcreteContainer;
import com.elytradev.concrete.inventory.gui.client.ConcreteGui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = TestStuff.MODID, name = TestStuff.NAME, version = TestStuff.VERSION)
public class TestStuff {
    public static final String MODID = "teststuff";
    public static final String NAME = "Test Stuff";
    public static final String VERSION = "1.0";
    
    private static TestStuff theMod;

    public static CreativeTabs TAB_TESTSTUFF = new CreativeTabs("teststuff") {
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
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new IGuiHandler() {
			@Override
			public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
				System.out.println("Sever did a thing!");
				TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
				if (te != null) {
					ConcreteContainer box = new ConcreteContainer(player.inventory,((IContainerInventoryHolder)te).getContainerInventory());
					box.validate();
					return new ConcreteGui(box);
				}
				return null;
			}
			@Override
			public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
				System.out.println("Client did a thing!");
				TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
				if (te != null) {
					ConcreteContainer box = new ConcreteContainer(player.inventory,((IContainerInventoryHolder)te).getContainerInventory());
					box.validate();
					return new ConcreteGui(box);
				}
				return null;
			}
		});
    }
    
    public static TestStuff instance() {
    	return theMod;
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

    }
}
