package Me.Akio.ChaosAwakens.Renderer;

import org.lwjgl.opengl.GL11;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import Me.Akio.ChaosAwakens.Entities.Beaver;
import Me.Akio.ChaosAwakens.Entities.HerculesBeetle;
import Me.Akio.ChaosAwakens.Models.HerculesBeetleModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderHerculesBeetle extends RenderLiving{
	
	/*    */   protected HerculesBeetleModel model;
	/* 15 */   private float scale = 6.0F;
	private static final ResourceLocation mobTextures = new ResourceLocation(ChaosAwaken.MODID + ":textures/entity/hercules_beetle.png");

	/*    */   public RenderHerculesBeetle(HerculesBeetleModel par1ModelBase, float par2) {
	/* 19 */     super(par1ModelBase, par2);
	/* 20 */     this.model = (HerculesBeetleModel)this.mainModel;
	/*    */   }
	/*    */ 
	/*    */ 
	/*    */   
	/*    */   public void renderHerculesBeetle(HerculesBeetle par1EntityHerculesBeetle, double par2, double par4, double par6, float par8, float par9) {
	/* 27 */     super.doRender((EntityLiving)par1EntityHerculesBeetle, par2, par4, par6, par8, par9);
	/*    */   }
	/*    */ 
	/*    */   
	/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
	/* 32 */     renderHerculesBeetle((HerculesBeetle)par1EntityLiving, par2, par4, par6, par8, par9);
	/*    */   }
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */   
	/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
	/* 43 */     renderHerculesBeetle((HerculesBeetle)par1Entity, par2, par4, par6, par8, par9);
	/*    */   }
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */   
	/*    */   protected void preRenderScale(HerculesBeetle par1Entity, float par2) {
	/* 51 */     GL11.glScalef(this.scale, this.scale, this.scale);
	/*    */   }
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */ 
	/*    */   
	/*    */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
	/* 60 */     preRenderScale((HerculesBeetle)par1EntityLiving, par2);
	/*    */   }
	/*    */ 
			
			protected ResourceLocation getEntityTexture(HerculesBeetle entity) {
				return mobTextures;
			}

			@Override
			protected ResourceLocation getEntityTexture(Entity entity) {
				return this.getEntityTexture((HerculesBeetle)entity);
			}
}
