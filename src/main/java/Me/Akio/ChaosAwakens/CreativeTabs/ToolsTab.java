package Me.Akio.ChaosAwakens.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolsTab extends CreativeTabs{

	public ToolsTab(String lable) {
		super(lable);
		
	}
	
	@Override
	public Item getTabIconItem() {
		return null;
		
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return this.getTabLabel();
	}
	
    	}