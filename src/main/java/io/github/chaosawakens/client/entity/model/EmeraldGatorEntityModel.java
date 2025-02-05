package io.github.chaosawakens.client.entity.model;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.entity.EmeraldGatorEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EmeraldGatorEntityModel extends AnimatedGeoModel<EmeraldGatorEntity> {
	
	@Override
	public ResourceLocation getModelLocation(EmeraldGatorEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "geo/emerald_gator.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureLocation(EmeraldGatorEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "textures/entity/emerald_gator.png");
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation(EmeraldGatorEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "animations/emerald_gator.animation.json");
	}
	
	@Override
	public void setLivingAnimations(EmeraldGatorEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		
		IBone head = this.getAnimationProcessor().getBone("head");
		//ChaosAwakens.LOGGER.debug(entity);
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX((extraData.headPitch) * ((float) Math.PI / 180F));
		head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 270F));
	}
}