package Me.Akio.ChaosAwakens;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.Random;

import Me.Akio.ChaosAwakens.Armors.Amethyst_Boots;
import Me.Akio.ChaosAwakens.Armors.Amethyst_Chestplate;
import Me.Akio.ChaosAwakens.Armors.Amethyst_Helmet;
import Me.Akio.ChaosAwakens.Armors.Amethyst_Leggings;
import Me.Akio.ChaosAwakens.Armors.CatEye_Boots;
import Me.Akio.ChaosAwakens.Armors.CatEye_Chestplate;
import Me.Akio.ChaosAwakens.Armors.Queen_Boots;
import Me.Akio.ChaosAwakens.Armors.Queen_Chestplate;
import Me.Akio.ChaosAwakens.Armors.Queen_Helmet;
import Me.Akio.ChaosAwakens.Armors.Queen_Leggings;
import Me.Akio.ChaosAwakens.Armors.Royal_Boots;
import Me.Akio.ChaosAwakens.Armors.Royal_Chestplate;
import Me.Akio.ChaosAwakens.Armors.Royal_Helmet;
import Me.Akio.ChaosAwakens.Armors.Royal_Leggings;
import Me.Akio.ChaosAwakens.Armors.CatEye_Helmet;
import Me.Akio.ChaosAwakens.Armors.CatEye_Leggings;
import Me.Akio.ChaosAwakens.Armors.Ultimate_Boots;
import Me.Akio.ChaosAwakens.Armors.Ultimate_Chestplate;
import Me.Akio.ChaosAwakens.Armors.Ultimate_Helmet;
import Me.Akio.ChaosAwakens.Armors.Ultimate_Leggings;
import Me.Akio.ChaosAwakens.CreativeTabs.ToolsTab;
import Me.Akio.ChaosAwakens.Critters.Critter;
import Me.Akio.ChaosAwakens.Critters.Critter_Creeper;
import Me.Akio.ChaosAwakens.Foods.BLT;
import Me.Akio.ChaosAwakens.Foods.Bacon;
import Me.Akio.ChaosAwakens.Foods.Butter;
import Me.Akio.ChaosAwakens.Foods.Candy_Cane;
import Me.Akio.ChaosAwakens.Foods.Cheese;
import Me.Akio.ChaosAwakens.Foods.Cherries;
import Me.Akio.ChaosAwakens.Foods.Cooked_Bacon;
import Me.Akio.ChaosAwakens.Foods.Cooked_Corndog;
import Me.Akio.ChaosAwakens.Foods.Corn;
import Me.Akio.ChaosAwakens.Seeds.Apple_Seeds;
import Me.Akio.ChaosAwakens.materials.Aluminum_Ingot;
import Me.Akio.ChaosAwakens.materials.Amethyst;
import Me.Akio.ChaosAwakens.materials.Queen_Scale;
import Me.Akio.ChaosAwakens.materials.Ruby;
import Me.Akio.ChaosAwakens.materials.Titanium_Ingot;
import Me.Akio.ChaosAwakens.materials.Titanium_Nugget;
import Me.Akio.ChaosAwakens.materials.Uranium_Ingot;
import Me.Akio.ChaosAwakens.materials.Uranium_Nugget;
import Me.Akio.ChaosAwakens.stats.MobStats;
import Me.Akio.ChaosAwakens.stats.WeaponStats;
import Me.Akio.ChaosAwakens.tools.Amethyst_Axe;
import Me.Akio.ChaosAwakens.tools.Amethyst_Hoe;
import Me.Akio.ChaosAwakens.tools.Amethyst_Pickaxe;
import Me.Akio.ChaosAwakens.tools.Amethyst_Shovel;
import Me.Akio.ChaosAwakens.tools.Amethyst_Sword;
import Me.Akio.ChaosAwakens.tools.Attitude_Adjuster;
import Me.Akio.ChaosAwakens.tools.Emerald_Axe;
import Me.Akio.ChaosAwakens.tools.Emerald_Pickaxe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ChaosAwaken.MODID, name = ChaosAwaken.CName, version = ChaosAwaken.VERSION)
public class ChaosAwaken
{
    public static final String MODID = "ChaosAwakens";
    public static final String CName = "Chaos Awakens";
    public static final String VERSION = "0.1";

    //Armors
    
    public static final ItemArmor.ArmorMaterial AmethystHelmet = EnumHelper.addArmorMaterial("AmethystHelmet", 2000, new int[] {4,4,4,4}, 4);
    public static final ItemArmor.ArmorMaterial AmethystChestplate = EnumHelper.addArmorMaterial("AmethystChestplate", 2000, new int[] {8,8,8,8}, 8);
    public static final ItemArmor.ArmorMaterial AmethystLeggings = EnumHelper.addArmorMaterial("AmethystLeggings", 2000, new int[] {7,7,7,7}, 7);
    public static final ItemArmor.ArmorMaterial AmethystBoots = EnumHelper.addArmorMaterial("AmethystBoots", 2000, new int[] {3,3,3,3}, 3);

    public static final ItemArmor.ArmorMaterial CatEyeHelmet = EnumHelper.addArmorMaterial("CatEyeHelmet", 2000, new int[] {4,4,4,4}, 4);
    public static final ItemArmor.ArmorMaterial CatEyeChestplate = EnumHelper.addArmorMaterial("CatEyeChestplate", 2000, new int[] {8,8,8,8}, 8);
    public static final ItemArmor.ArmorMaterial CatEyeLeggings = EnumHelper.addArmorMaterial("CatEyeLeggings", 2000, new int[] {7,7,7,7}, 7);
    public static final ItemArmor.ArmorMaterial CatEyeBoots = EnumHelper.addArmorMaterial("CatEyeBoots", 2000, new int[] {3,3,3,3}, 3);
    
    public static final ItemArmor.ArmorMaterial RoyalHelmet = EnumHelper.addArmorMaterial("RoyalHelmet", 5000, new int[] {8,8,8,8}, 8);
    public static final ItemArmor.ArmorMaterial RoyalChestplate = EnumHelper.addArmorMaterial("RoyalChestplate", 5000, new int[] {14,14,14,14}, 14);
    public static final ItemArmor.ArmorMaterial RoyalLeggings = EnumHelper.addArmorMaterial("RoyalLeggings", 5000, new int[] {12,12,12,12}, 12);
    public static final ItemArmor.ArmorMaterial RoyalBoots = EnumHelper.addArmorMaterial("RoyalBoots", 5000, new int[] {8,8,8,8}, 8);
    
    public static final ItemArmor.ArmorMaterial QueenHelmet = EnumHelper.addArmorMaterial("QueenHelmet", 5000, new int[] {8,8,8,8}, 8);
    public static final ItemArmor.ArmorMaterial QueenChestplate = EnumHelper.addArmorMaterial("QueenChestplate", 5000, new int[] {14,14,14,14}, 14);
    public static final ItemArmor.ArmorMaterial QueenLeggings = EnumHelper.addArmorMaterial("QueenLeggings", 5000, new int[] {12,12,12,12}, 12);
    public static final ItemArmor.ArmorMaterial QueenBoots = EnumHelper.addArmorMaterial("QueenBoots", 5000, new int[] {8,8,8,8}, 8);
    
    public static final ItemArmor.ArmorMaterial UltimateHelmet = EnumHelper.addArmorMaterial("UltimateHelmet", 3000, new int[] {6,6,6,6}, 30);
    public static final ItemArmor.ArmorMaterial UltimateChestplate = EnumHelper.addArmorMaterial("UltimateChestplate", 3000, new int[] {12,12,12,12}, 12);
    public static final ItemArmor.ArmorMaterial UltimateLeggings = EnumHelper.addArmorMaterial("UltimateLeggings", 3000, new int[] {10,10,10,10}, 10);
    public static final ItemArmor.ArmorMaterial UltimateBoots = EnumHelper.addArmorMaterial("UltimateBoots", 3000, new int[] {6,6,6,6}, 6);
    
    
    public static final ToolsTab ChaosTab=new ToolsTab("Chaos Awakens: Tools") {
    	@Override
    	public Item getTabIconItem() {
    		return new ItemStack(amethyst_axe).getItem();
    	}
    };

    
    public static final ToolsTab ChaosTab1=new ToolsTab("Chaos Awakens: Foods") {
    	@Override
    	public Item getTabIconItem() {
    		return new ItemStack(blt).getItem();
    	}
    };
    
    public static final ToolsTab ChaosTab2=new ToolsTab("Chaos Awakens: Armors") {
    	@Override
    	public Item getTabIconItem() {
    		return new ItemStack(royalhelmet).getItem();
    	}
    };

    public static final ToolsTab ChaosTab3=new ToolsTab("Chaos Awakens: Materials") {
    	@Override
    	public Item getTabIconItem() {
    		return new ItemStack(queen_scale).getItem();
    	}
    };
    
    public static final Item.ToolMaterial EmeraldPickaxe = EnumHelper.addToolMaterial("EmeraldPickaxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial EmeraldAxe = EnumHelper.addToolMaterial("EmeraldAxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AmethystAxe = EnumHelper.addToolMaterial("AmethystAxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AmethystPickaxe = EnumHelper.addToolMaterial("AmethystPickaxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AmethystHoe = EnumHelper.addToolMaterial("AmethystHoe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AmethystShovel = EnumHelper.addToolMaterial("AmethystShovel", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AmethystSword = EnumHelper.addToolMaterial("AmethystSword", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial AttitudeAdjuster = EnumHelper.addToolMaterial("AttitudeAdjuster", 3, 1300, 10F, 6F, 75);
    
    public static Item CrystalApple;
    public static Item uranium_nugget;
    public static Item uranium_ingot;
    public static Item titanium_ingot;
    public static Item titanium_nugget;
    public static Item amethyst;
    public static Item amethyst_hoe;
    public static Item amethyst_axe;
    public static Item amethyst_pickaxe;
    public static Item amethyst_shovel;
    public static Item amethyst_sword;
    public static Item emerald_pickaxe;
    public static Item emerald_axe;
    public static Item emerald_shovel;
    public static Item emerald_sword;
    public static Item ruby;
    public static Item queen_scale;
    public static Item aluminum_ingot;
    public static Item critter_creeper;
    public static Item critter;
    public static Item amethysthelmet;
    public static Item amethystchestplate;
    public static Item amethystleggings;
    public static Item amethystboots;
    public static Item queenhelmet;
    public static Item queenchestplate;
    public static Item queenleggings;
    public static Item queenboots;
    public static Item ultimatehelmet;
    public static Item ultimatechestplate;
    public static Item ultimateleggings;
    public static Item ultimateboots;
    public static Item royalhelmet;
    public static Item royalchestplate;
    public static Item royalleggings;
    public static Item royalboots;
    public static Item cateyehelmet;
    public static Item cateyechestplate;
    public static Item cateyeleggings;
    public static Item cateyeboots;
    public static Item attitude_adjuster;
    //FoodsReg
    
    public static Item blt;
    public static Item corn;
    public static Item bacon;
    public static Item cooked_bacon;
    public static Item butter;
    public static Item candy_cane;
    public static Item cheese;
    public static Item cherries;
    public static Item cooked_corndog;

    //EntitiesReg
    
    public static int RedCowID = 0;
    public static int GoldCowID = 0;
    public static int EnchantedCowID = 0;
    
    //SeedsReg
    public static Item apple_seeds;
    
        
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    	queen_scale = new Queen_Scale().setUnlocalizedName("Queen_Scale").setTextureName("chaosawakens:queen_scale");
    	GameRegistry.registerItem(queen_scale, queen_scale.getUnlocalizedName().substring(5));

        ruby = new Ruby().setUnlocalizedName("Ruby").setTextureName("chaosawakens:ruby");
    	GameRegistry.registerItem(ruby, ruby.getUnlocalizedName().substring(5));
    	
    	amethyst = new Amethyst().setUnlocalizedName("Amethyst").setTextureName("chaosawakens:amethyst");
    	GameRegistry.registerItem(amethyst, amethyst.getUnlocalizedName().substring(5));
    	
    	aluminum_ingot = new Aluminum_Ingot().setUnlocalizedName("Aluminum_Ingot").setTextureName("chaosawakens:aluminum_ingot");
    	GameRegistry.registerItem(aluminum_ingot, aluminum_ingot.getUnlocalizedName().substring(5));
    	
    	titanium_ingot = new Titanium_Ingot().setUnlocalizedName("Titanium_Ingot").setTextureName("chaosawakens:titanium_ingot");
    	GameRegistry.registerItem(titanium_ingot, titanium_ingot.getUnlocalizedName().substring(5));

    	titanium_nugget = new Titanium_Nugget().setUnlocalizedName("Titanium_Nugget").setTextureName("chaosawakens:titanium_nugget");
    	GameRegistry.registerItem(titanium_nugget, titanium_nugget.getUnlocalizedName().substring(5));
    	
    	uranium_ingot = new Uranium_Ingot().setUnlocalizedName("Uranium_Ingot").setTextureName("chaosawakens:uranium_ingot");
    	GameRegistry.registerItem(uranium_ingot, uranium_ingot.getUnlocalizedName().substring(5));

    	uranium_nugget = new Uranium_Nugget().setUnlocalizedName("Uranium_Nugget").setTextureName("chaosawakens:uranium_nugget");
    	GameRegistry.registerItem(uranium_nugget, uranium_nugget.getUnlocalizedName().substring(5));
    	
    	//Amors
    	
    	amethysthelmet = new Amethyst_Helmet(AmethystHelmet, 0, 0).setUnlocalizedName("Amethyst_Helmet").setTextureName("chaosawakens:amethyst_helmet");
    	GameRegistry.registerItem(amethysthelmet, amethysthelmet.getUnlocalizedName().substring(5)); 
    	
    	amethystchestplate = new Amethyst_Chestplate(AmethystChestplate, 0, 1).setUnlocalizedName("Amethyst_Chestplate").setTextureName("chaosawakens:amethyst_chestplate");
    	GameRegistry.registerItem(amethystchestplate, amethystchestplate.getUnlocalizedName().substring(5)); 
    	
    	amethystleggings = new Amethyst_Leggings(AmethystLeggings, 0, 2).setUnlocalizedName("Amethyst_Leggings").setTextureName("chaosawakens:amethyst_leggings");
    	GameRegistry.registerItem(amethystleggings, amethystleggings.getUnlocalizedName().substring(5)); 
    	
    	amethystboots = new Amethyst_Boots(AmethystBoots, 0, 3).setUnlocalizedName("Amethyst_Boots").setTextureName("chaosawakens:amethyst_boots");
    	GameRegistry.registerItem(amethystboots, amethystboots.getUnlocalizedName().substring(5)); 
    	
    	cateyehelmet = new CatEye_Helmet(CatEyeHelmet, 0, 0).setUnlocalizedName("CatEye_Helmet").setTextureName("chaosawakens:cats_eye_helmet");
    	GameRegistry.registerItem(cateyehelmet, cateyehelmet.getUnlocalizedName().substring(5)); 
    	
    	cateyechestplate = new CatEye_Chestplate(CatEyeChestplate, 0, 1).setUnlocalizedName("CatEye_Chestplate").setTextureName("chaosawakens:cats_eye_chestplate");
    	GameRegistry.registerItem(cateyechestplate, cateyechestplate.getUnlocalizedName().substring(5)); 
    	
    	cateyeleggings = new CatEye_Leggings(CatEyeLeggings, 0, 2).setUnlocalizedName("CatEye_Leggings").setTextureName("chaosawakens:cats_eye_leggings");
    	GameRegistry.registerItem(cateyeleggings, cateyeleggings.getUnlocalizedName().substring(5)); 
    	
    	cateyeboots = new CatEye_Boots(CatEyeBoots, 0, 3).setUnlocalizedName("CatEye_Boots").setTextureName("chaosawakens:cats_eye_boots");
    	GameRegistry.registerItem(cateyeboots, cateyeboots.getUnlocalizedName().substring(5)); 
    	
    	royalhelmet = new Royal_Helmet(RoyalHelmet, 0, 0).setUnlocalizedName("Royal_Helmet").setTextureName("chaosawakens:royal_guardian_helmet");
    	GameRegistry.registerItem(royalhelmet, royalhelmet.getUnlocalizedName().substring(5)); 
    	
    	royalchestplate = new Royal_Chestplate(RoyalChestplate, 0, 1).setUnlocalizedName("Royal_Chestplate").setTextureName("chaosawakens:royal_guardian_chestplate");
    	GameRegistry.registerItem(royalchestplate, royalchestplate.getUnlocalizedName().substring(5)); 
    	
    	royalleggings = new Royal_Leggings(RoyalLeggings, 0, 2).setUnlocalizedName("Royal_Leggings").setTextureName("chaosawakens:royal_guardian_leggings");
    	GameRegistry.registerItem(royalleggings, royalleggings.getUnlocalizedName().substring(5)); 
    	
    	royalboots = new Royal_Boots(RoyalBoots, 0, 3).setUnlocalizedName("Royal_Boots").setTextureName("chaosawakens:royal_guardian_boots");
    	GameRegistry.registerItem(royalboots, royalboots.getUnlocalizedName().substring(5)); 
    	
    	queenhelmet = new Queen_Helmet(QueenHelmet, 0, 0).setUnlocalizedName("Queen_Helmet").setTextureName("chaosawakens:queen_scale_helmet");
    	GameRegistry.registerItem(queenhelmet, queenhelmet.getUnlocalizedName().substring(5)); 
    	
    	queenchestplate = new Queen_Chestplate(QueenChestplate, 0, 1).setUnlocalizedName("Queen_Chestplate").setTextureName("chaosawakens:queen_scale_chestplate");
    	GameRegistry.registerItem(queenchestplate, queenchestplate.getUnlocalizedName().substring(5)); 
    	
    	queenleggings = new Queen_Leggings(QueenLeggings, 0, 2).setUnlocalizedName("Queen_Leggings").setTextureName("chaosawakens:queen_scale_leggings");
    	GameRegistry.registerItem(queenleggings, queenleggings.getUnlocalizedName().substring(5)); 
    	
    	queenboots = new Queen_Boots(QueenBoots, 0, 3).setUnlocalizedName("Queen_Boots").setTextureName("chaosawakens:queen_scale_boots");
    	GameRegistry.registerItem(queenboots, queenboots.getUnlocalizedName().substring(5)); 
    	
    	ultimatehelmet = new Ultimate_Helmet(UltimateHelmet, 0, 0).setUnlocalizedName("Ultimate_Helmet").setTextureName("chaosawakens:ultimate_helmet");
    	GameRegistry.registerItem(ultimatehelmet, ultimatehelmet.getUnlocalizedName().substring(5)); 
    	
    	ultimatechestplate = new Ultimate_Chestplate(UltimateChestplate, 0, 1).setUnlocalizedName("Ultimate_Chestplate").setTextureName("chaosawakens:ultimate_chestplate");
    	GameRegistry.registerItem(ultimatechestplate, ultimatechestplate.getUnlocalizedName().substring(5)); 
    	
    	ultimateleggings = new Ultimate_Leggings(UltimateLeggings, 0, 2).setUnlocalizedName("Ultimate_Leggings").setTextureName("chaosawakens:ultimate_leggings");
    	GameRegistry.registerItem(ultimateleggings, ultimateleggings.getUnlocalizedName().substring(5)); 
    	
    	ultimateboots = new Ultimate_Boots(UltimateBoots, 0, 3).setUnlocalizedName("Ultimate_Boots").setTextureName("chaosawakens:ultimate_boots");
    	GameRegistry.registerItem(ultimateboots, ultimateboots.getUnlocalizedName().substring(5)); 
    	
    	//Tools
    	
    	amethyst_axe = new Amethyst_Axe(AmethystAxe).setUnlocalizedName("Amethyst_Axe").setTextureName("chaosawakens:amethyst_axe");
    	GameRegistry.registerItem(amethyst_axe, amethyst_axe.getUnlocalizedName().substring(5)); 
    	
    	emerald_axe = new Emerald_Axe(EmeraldAxe).setUnlocalizedName("Emerald_Axe").setTextureName("chaosawakens:emerald_axe");
    	GameRegistry.registerItem(emerald_axe, emerald_axe.getUnlocalizedName().substring(5)); 

    	emerald_pickaxe = new Emerald_Pickaxe(EmeraldPickaxe).setUnlocalizedName("Emerald_Pickaxe").setTextureName("chaosawakens:emerald_pickaxe");
    	GameRegistry.registerItem(emerald_pickaxe, emerald_pickaxe.getUnlocalizedName().substring(5)); 
    	
    	amethyst_pickaxe = new Amethyst_Pickaxe(AmethystPickaxe).setUnlocalizedName("Amethyst_Pickaxe").setTextureName("chaosawakens:amethyst_pickaxe");
    	GameRegistry.registerItem(amethyst_pickaxe, amethyst_pickaxe.getUnlocalizedName().substring(5)); 

    	amethyst_hoe = new Amethyst_Hoe(AmethystHoe).setUnlocalizedName("Amethyst_Hoe").setTextureName("chaosawakens:amethyst_hoe");
    	GameRegistry.registerItem(amethyst_hoe, amethyst_hoe.getUnlocalizedName().substring(5)); 
    	
    	amethyst_shovel = new Amethyst_Shovel(AmethystShovel).setUnlocalizedName("Amethyst_Shovel").setTextureName("chaosawakens:amethyst_shovel");
    	GameRegistry.registerItem(amethyst_shovel, amethyst_shovel.getUnlocalizedName().substring(5)); 

    	amethyst_sword = new Amethyst_Sword(AmethystSword).setUnlocalizedName("Amethyst_Sword").setTextureName("chaosawakens:amethyst_sword");
    	GameRegistry.registerItem(amethyst_sword, amethyst_sword.getUnlocalizedName().substring(5)); 
    	
    	attitude_adjuster = new Attitude_Adjuster(AttitudeAdjuster).setUnlocalizedName("Attitude_Adjuster").setTextureName("chaosawakens:attitude_adjuster");
    	GameRegistry.registerItem(attitude_adjuster, attitude_adjuster.getUnlocalizedName().substring(5)); 
    	
    	//Foods
    	
    	cooked_corndog = new Cooked_Corndog(12, 12, 0.95, true).setUnlocalizedName("Cooked_Corndog").setTextureName("chaosawakens:cooked_corndog");
    	GameRegistry.registerItem(cooked_corndog, cooked_corndog.getUnlocalizedName().substring(5)); 
    	
      	cherries = new Cherries(12, 12, 0.95, true).setUnlocalizedName("Cherries").setTextureName("chaosawakens:cherries");
    	GameRegistry.registerItem(cherries, cherries.getUnlocalizedName().substring(5)); 
    	
    	cheese = new Cheese(12, 12, 0.95, true).setUnlocalizedName("Cheese").setTextureName("chaosawakens:cheese");
    	GameRegistry.registerItem(cheese, cheese.getUnlocalizedName().substring(5)); 

    	candy_cane = new Candy_Cane(12, 12, 0.95, true).setUnlocalizedName("Candy_Cane").setTextureName("chaosawakens:candycane");
    	GameRegistry.registerItem(candy_cane, candy_cane.getUnlocalizedName().substring(5)); 
    	    	
    	butter = new Butter(12, 12, 0.95, true).setUnlocalizedName("Butter").setTextureName("chaosawakens:butter");
    	GameRegistry.registerItem(butter, butter.getUnlocalizedName().substring(5)); 

    	corn = new Corn(12, 12, 0.95, true).setUnlocalizedName("Corn").setTextureName("chaosawakens:corn");
    	GameRegistry.registerItem(corn, corn.getUnlocalizedName().substring(5)); 
    	
    	blt = new BLT(6, 6, 0.75, true).setUnlocalizedName("BLT").setTextureName("chaosawakens:blt");
    	GameRegistry.registerItem(blt, blt.getUnlocalizedName().substring(5)); 

    	cooked_bacon = new Cooked_Bacon(6, 6, 0.75, true).setUnlocalizedName("Cooked_Bacon").setTextureName("chaosawakens:cooked_bacon");
    	GameRegistry.registerItem(cooked_bacon, cooked_bacon.getUnlocalizedName().substring(5)); 
    	
    	bacon = new Bacon(6, 6, 0.75, true).setUnlocalizedName("Bacon").setTextureName("chaosawakens:bacon");
    	GameRegistry.registerItem(bacon, bacon.getUnlocalizedName().substring(5)); 
    	
    	GameRegistry.addSmelting(bacon, new ItemStack(cooked_bacon), 5.0F);
        
    	
    	//Critter
    	
     	critter = new Critter().setUnlocalizedName("Critter_Cage").setTextureName("chaosawakens:empty");
    	GameRegistry.registerItem(critter, critter.getUnlocalizedName().substring(5));
    	
    	critter_creeper = new Critter_Creeper().setUnlocalizedName("Critter_Creeper").setTextureName("chaosawakens:creeper");
    	GameRegistry.registerItem(critter_creeper, critter_creeper.getUnlocalizedName().substring(5));
    	
    	//Seeds
    	
    	apple_seeds = new Apple_Seeds(null, null).setUnlocalizedName("Apple_Seeds").setTextureName("chaosawakens:apple_seeds");
    	GameRegistry.registerItem(apple_seeds, apple_seeds.getUnlocalizedName().substring(5));

    }



	@EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	GameRegistry.addRecipe(new ItemStack(amethysthelmet), "DDD", "D D", 'D', ChaosAwaken.amethyst);
    	
    	GameRegistry.addRecipe(new ItemStack(amethystchestplate), "D D", "DDD", "DDD", 'D', ChaosAwaken.amethyst);

    	GameRegistry.addRecipe(new ItemStack(amethystleggings), "DDD", "D D", "D D", 'D', ChaosAwaken.amethyst);

    	GameRegistry.addRecipe(new ItemStack(amethystboots), "D D", "D D", 'D', ChaosAwaken.amethyst);
    	
    	GameRegistry.addRecipe(new ItemStack(queenhelmet), "DDD", "D D", 'D', ChaosAwaken.queen_scale);
    	
    	GameRegistry.addRecipe(new ItemStack(queenchestplate), "D D", "DDD", "DDD", 'D', ChaosAwaken.queen_scale);

    	GameRegistry.addRecipe(new ItemStack(queenleggings), "DDD", "D D", "D D", 'D', ChaosAwaken.queen_scale);

    	GameRegistry.addRecipe(new ItemStack(queenboots), "D D", "D D", 'D', ChaosAwaken.queen_scale);
    	
    	GameRegistry.addRecipe(new ItemStack(ultimatehelmet), "DID", "U U", 'D', ChaosAwaken.titanium_ingot, 'U', ChaosAwaken.uranium_ingot, 'I', Items.iron_ingot);
    	 
    	GameRegistry.addRecipe(new ItemStack(ultimatechestplate), "I I", "DDD", "UUU", 'D', ChaosAwaken.titanium_ingot, 'U', ChaosAwaken.uranium_ingot, 'I', Items.iron_ingot);

    	GameRegistry.addRecipe(new ItemStack(ultimateleggings), "III", "D D", "U U", 'D', ChaosAwaken.titanium_ingot, 'U', ChaosAwaken.uranium_ingot, 'I', Items.iron_ingot);

    	GameRegistry.addRecipe(new ItemStack(ultimateboots), "D D", "U U", 'D', ChaosAwaken.titanium_ingot, 'U', ChaosAwaken.uranium_ingot);
    	
    	GameRegistry.addRecipe(new ItemStack(titanium_ingot), "TTT", "TTT", "TTT", 'T', ChaosAwaken.titanium_nugget);
    	
    	GameRegistry.addRecipe(new ItemStack(emerald_pickaxe), "DDD", " S ", " S ", 'D', Items.emerald, 'S', Items.stick);
    	
    	GameRegistry.addRecipe(new ItemStack(amethyst_axe), "AAA", " S ", " S ", 'A', ChaosAwaken.amethyst, 'S', Items.stick);
    	
    	GameRegistry.addRecipe(new ItemStack(emerald_axe), "EE ", "ES ", " S ", 'E', Items.emerald, 'S', Items.stick);
    	
    	
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {      
     
     	}
    

    }
    
