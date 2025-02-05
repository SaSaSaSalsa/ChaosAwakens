package io.github.chaosawakens.common.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import software.bernie.geckolib3.core.*;
import software.bernie.geckolib3.core.manager.*;

import java.util.UUID;

public class ExtendedHitWeaponItem extends EnchantedSwordItem implements IVanishable, IAnimatable {

	public AnimationFactory factory = new AnimationFactory(this);
	private final Multimap<Attribute, AttributeModifier> attributeModifiers;
	protected static final UUID ATTACK_KNOCKBACK_MODIFIER = UUID.fromString("C59EC38E-DC43-11EB-BA80-0242AC130004");

	public ExtendedHitWeaponItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, float attackKnockbackIn, Properties builderIn, EnchantmentData[] enchants) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn, enchants);
		float attackDamage = (float) attackDamageIn + tier.getAttackDamage();
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackSpeedIn, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ATTACK_KNOCKBACK_MODIFIER, "Weapon modifier", attackKnockbackIn, AttributeModifier.Operation.ADDITION));
		this.attributeModifiers = builder.build();
	}

	@Override
	public void registerControllers(AnimationData data) {
		// insert controllers here
	}

	@Override
	public AnimationFactory getFactory()
	{
		return this.factory;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot);
	}
}