package Me.Akio.ChaosAwakens.tools;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import Me.Akio.ChaosAwakens.CreativeTabs.ToolsTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class Amethyst_Axe extends ItemAxe{

	public Amethyst_Axe(ToolMaterial material) {
	    super(material);
	     this.maxStackSize = 1;
	     setMaxDamage(1300);
	     setCreativeTab(ChaosAwaken.ChaosTab);
	   }
}