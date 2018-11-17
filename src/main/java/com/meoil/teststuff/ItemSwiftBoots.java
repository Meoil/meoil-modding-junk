package com.meoil.teststuff;

import java.util.UUID;

import com.meoil.teststuff.TestStuff;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemSwiftBoots extends Item {
	public static final UUID SPEED_BOOST = UUID.fromString("9e0a25b9-93d7-483e-a8c0-d109ec6b2b28");

	public ItemSwiftBoots() {
		this.setRegistryName(new ResourceLocation(TestStuff.MODID, "armor.fastboots"));
		this.setUnlocalizedName(TestStuff.MODID + ".armor.fastboots");
		this.setCreativeTab(TestStuff.TAB_TESTSTUFF);
	}
	@Override
	public boolean isValidArmor(ItemStack item, EntityEquipmentSlot slot, Entity entity) {
		return (slot == EntityEquipmentSlot.FEET);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multi = super.getAttributeModifiers(slot, stack);
		if (slot == EntityEquipmentSlot.FEET) {
			multi.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Boot boost", 10, 2));
		}
		return multi;
	}
}
