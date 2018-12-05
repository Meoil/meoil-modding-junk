package com.meoil.teststuff;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockConveyor extends Block {
	public BlockConveyor() {
		super(Material.CIRCUITS);
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "block.conveyor"));
		this.setUnlocalizedName(TestStuff.MODID + ".block.conveyor");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.openGui(TestStuff.instance(), 0, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
