package com.meoil.teststuff;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpicyCube extends Block{
	//make it do random hottakes
	public BlockSpicyCube(){
		super(Material.ANVIL);
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "block.spicycube"));
		this.setUnlocalizedName(TestStuff.MODID + ".block.spicycube");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer(){
		return BlockRenderLayer.SOLID;
	}
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn){
		entityIn.addVelocity(0, 5, 0);
	}
}
