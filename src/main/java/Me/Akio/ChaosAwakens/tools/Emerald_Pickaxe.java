package Me.Akio.ChaosAwakens.tools;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class Emerald_Pickaxe extends ItemPickaxe {

    public static  Item.ToolMaterial EmeraldMaterials = EnumHelper.addToolMaterial("EmeraldMaterials", 2, 192, 50F, 15F, 12);
	 
	   
	   public Emerald_Pickaxe(ToolMaterial material) {
	    super(material);
	     this.maxStackSize = 1;
	     setMaxDamage(1300);
	     setCreativeTab(ChaosAwaken.ChaosTab);
	   }
	 

	   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
	     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, stack);
	     if (lvl <= 0) {
	       stack.addEnchantment(Enchantment.silkTouch, 1);
	     }
	  }
	   
	   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
	     onUsingTick(stack, (EntityPlayer)null, 0);
	  }
	 
	 
	 
	 
	   
	 
	   public String getMaterialName() {
	    return "Emerald";
	   }
	   
}
