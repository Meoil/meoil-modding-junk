package com.meoil.teststuff;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemBooster extends Item {
	public ItemBooster() {
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "item.booster"));
		this.setUnlocalizedName(TestStuff.MODID + ".item.booster");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(worldIn.isRemote) {
			Vec3d pushVec = playerIn.getLookVec().scale(playerIn.getHeldItem(handIn).getCount());
			playerIn.motionX += pushVec.x;
			playerIn.motionY += pushVec.y;
			playerIn.motionZ += pushVec.z;
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, (playerIn.isCreative()) ? playerIn.getHeldItem(handIn) : new ItemStack(Blocks.AIR));
	}
}
