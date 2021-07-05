package Me.Akio.ChaosAwakens.Armors;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;

public class Royal_Boots extends ItemArmor{

	private int armor_material;
	private Object boots;
	public Royal_Boots(ArmorMaterial armorMat, int RenderIn, int armorType) {
		super(armorMat, RenderIn, armorType);
	     setCreativeTab(ChaosAwaken.ChaosTab2);

	}
 
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String Type) {
		if(this.armorType == 2) {
			return "ChaosAwakens:textures/models/armor/royal_guardian_layer_2.png";

		}
		
		return "ChaosAwakens:textures/models/armor/royal_guardian_layer_1.png";
		
	}
	
	   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack);
		     if (lvl <= 0) {
		       stack.addEnchantment(Enchantment.protection, 10);
		       stack.addEnchantment(Enchantment.fireProtection, 10);
		       stack.addEnchantment(Enchantment.blastProtection, 10);
		       stack.addEnchantment(Enchantment.projectileProtection, 10);
		       stack.addEnchantment(Enchantment.featherFalling, 5);
		     }
		  }
	   
       public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

           
           if (player.motionY < -0.10000000149011612D) player.motionY = -0.10000000149011612D; 
           player.fallDistance = -0.0F;
		            
       } 
		   
	   
		   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
		     onUsingTick(stack, (EntityPlayer)null, 0);
		  }
		   
}