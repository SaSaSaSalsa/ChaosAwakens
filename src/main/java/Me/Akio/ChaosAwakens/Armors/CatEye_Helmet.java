package Me.Akio.ChaosAwakens.Armors;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class CatEye_Helmet extends ItemArmor {
	
	public CatEye_Helmet(ArmorMaterial armorMat, int RenderIn, int armorType) {
		super(armorMat, RenderIn, armorType);
	     setCreativeTab(ChaosAwaken.ChaosTab2);

	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String Type) {
		if(this.armorType == 2) {
			return "ChaosAwakens:textures/models/armor/cats_eye_layer_2.png";

		}
		
		return "ChaosAwakens:textures/models/armor/cats_eye_layer_1.png";
		
	}

}
