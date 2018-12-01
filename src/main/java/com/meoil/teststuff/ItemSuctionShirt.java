package com.meoil.teststuff;

import java.awt.List;
import java.awt.TextComponent;
import java.util.UUID;

import com.meoil.teststuff.TestStuff;
import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemSuctionShirt extends Item{

	private Vec3d lastPlayerPosition = new Vec3d(0,0,0);
	private Vec3d orbitalVector = new Vec3d(0,1,0);
	public ItemSuctionShirt() {
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "armor.suctionshirt"));
		this.setUnlocalizedName(TestStuff.MODID + ".armor.suctionshirt");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	
	@Override
	public boolean isValidArmor(ItemStack item, EntityEquipmentSlot slot, Entity entity) {
		return (slot == EntityEquipmentSlot.CHEST);
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		Predicate<Entity> d = null;
		Vec3d pos = player.getPositionVector();
		Vec3d dims = new Vec3d(12, 12, 12); //this should be inherent to the shirt, right now this is fine
		AxisAlignedBB boundingBox = new AxisAlignedBB(pos.subtract(dims), pos.add(dims));
		java.util.List<Entity> coarseList = world.getEntitiesInAABBexcluding(player, boundingBox, d);
		int cycles = 0;
		//player.sendMessage(new TextComponentString(Double.toString(player.motionY)));
		for (Entity entity : coarseList) {
			if(cycles > 100) {
				break;
			}
			cycles++;
			if(entity.isEntityAlive()){ //this pulls them to their position projected on to a sphere around the player
				Vec3d playerVelocity = player.getPositionVector().subtract(lastPlayerPosition).scale(1.5);
				Vec3d vecTo = pos.addVector(0, .5, 0);
				vecTo = vecTo.subtract(entity.getPositionVector());
				Vec3d sphereProjection = vecTo.scale((-3.0+playerVelocity.lengthVector())/vecTo.lengthVector());
				vecTo = vecTo.add(sphereProjection).scale(.2);
				vecTo = vecTo.add(playerVelocity);
				orbitalVector = orbitalVector.add(playerVelocity.scale(.01)).normalize();
				Vec3d orbitalForce = sphereProjection.crossProduct(orbitalVector).scale(.05);
				vecTo = vecTo.add(orbitalForce);
				entity.motionX = vecTo.x;
				entity.motionY = vecTo.y;
				entity.motionZ = vecTo.z;
				entity.fallDistance = 0;
				//player.sendMessage(new TextComponentString(Double.toString(playerVelocity.lengthVector())));
			}
		}
	lastPlayerPosition = player.getPositionVector();
	}
}
