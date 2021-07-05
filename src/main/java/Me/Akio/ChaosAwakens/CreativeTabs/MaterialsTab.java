package Me.Akio.ChaosAwakens.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MaterialsTab extends CreativeTabs{

	public MaterialsTab(String lable) {
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