package io.github.chaosawakens.common.events;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.api.IPreEnchanted;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;

/**
 * Class with method(s) that subscribe to the ItemCraftedEvent
 * @author invalid2
 */
public class CraftingEventSubscriber {
	
	public static void onItemCraftedEvent(final ItemCraftedEvent event) {
		
		ChaosAwakens.debug("CRAFTING", event.getCrafting());
		
		Item enchantedItem = event.getCrafting().getItem();
		if(event.getCrafting().getItem() instanceof IPreEnchanted) {
			for(EnchantmentData enchant : ((IPreEnchanted) enchantedItem).enchant()) {
				event.getCrafting().addEnchantment( enchant.enchantment, enchant.enchantmentLevel);
			}
		}
	}
}
