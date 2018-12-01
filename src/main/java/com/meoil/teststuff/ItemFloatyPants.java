package com.meoil.teststuff;

import java.awt.TextComponent;
import java.util.UUID;

import com.meoil.teststuff.TestStuff;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemFloatyPants extends Item{

	public ItemFloatyPants() {
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "armor.floatypants"));
		this.setUnlocalizedName(TestStuff.MODID + ".armor.floatypants");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	@Override
	public boolean isValidArmor(ItemStack item, EntityEquipmentSlot slot, Entity entity) {
		return (slot == EntityEquipmentSlot.LEGS);
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		BlockPos checkPos = player.getPosition();
		//where the player is on the block, and then also their y position
		Vec3d onBlock = player.getPositionVector().subtract(checkPos.getX()+.5, 0, checkPos.getZ()+.5);
		int xBorder = (onBlock.x*onBlock.x >= .04) ? ((onBlock.x>0)?1:-1) : 0; //-1 is west 1 is east
		int zBorder = (onBlock.z*onBlock.z >= .04) ? ((onBlock.z>0)?1:-1) : 0; //-1 is north 1 is south
		for (int i = 0; i < 10; i++) {
			IBlockState thisBlock = world.getBlockState(checkPos);
			if (!thisBlock.getBlock().isAir(thisBlock, world, checkPos)){
				break; 
			} else {
				if (xBorder != 0) {
					checkPos = checkPos.east(xBorder);
					thisBlock = world.getBlockState(checkPos);
					if (!thisBlock.getBlock().isAir(thisBlock, world, checkPos)){
						break; 
					} else {
						if (zBorder != 0) {
							checkPos = checkPos.south(zBorder);
							thisBlock = world.getBlockState(checkPos);
							if (!thisBlock.getBlock().isAir(thisBlock, world, checkPos)){
								break; 
							}
							checkPos = checkPos.north(zBorder);
						}
					}
					checkPos = checkPos.west(xBorder);
				}
				if (zBorder != 0) {
					checkPos = checkPos.south(zBorder);
					thisBlock = world.getBlockState(checkPos);
					if (!thisBlock.getBlock().isAir(thisBlock, world, checkPos)){
						break; 
					}
					checkPos = checkPos.north(zBorder);
				}
			}
			checkPos = checkPos.down();
		}
		double groundHeight = onBlock.y - checkPos.getY();
		double upForce = (groundHeight > 10) ? 0 : (10 - groundHeight)/50.0;
		player.addVelocity(0, upForce, 0);
	}
}
