package io.github.chaosawakens.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import org.apache.commons.lang3.tuple.Pair;

public class CAConfig {

    public static class Common {
        public final ConfigValue<Float> ultimateSwordDamage;
        public final ConfigValue<Float> ultimateAxeDamage;
        public final ConfigValue<Float> ultimatePickaxeDamage;
        public final ConfigValue<Float> ultimateShovelDamage;
        public final ConfigValue<Float> ultimateHoeDamage;
        public final ConfigValue<Float> emeraldSwordDamage;
        public final ConfigValue<Float> emeraldAxeDamage;
        public final ConfigValue<Float> emeraldPickaxeDamage;
        public final ConfigValue<Float> emeraldShovelDamage;
        public final ConfigValue<Float> emeraldHoeDamage;
        public final ConfigValue<Float> rubySwordDamage;
        public final ConfigValue<Float> rubyAxeDamage;
        public final ConfigValue<Float> rubyPickaxeDamage;
        public final ConfigValue<Float> rubyShovelDamage;
        public final ConfigValue<Float> rubyHoeDamage;
        public final ConfigValue<Float> amethystSwordDamage;
        public final ConfigValue<Float> amethystAxeDamage;
        public final ConfigValue<Float> amethystPickaxeDamage;
        public final ConfigValue<Float> amethystShovelDamage;
        public final ConfigValue<Float> amethystHoeDamage;
        public final ConfigValue<Float> tigersEyeSwordDamage;
        public final ConfigValue<Float> tigersEyeAxeDamage;
        public final ConfigValue<Float> tigersEyePickaxeDamage;
        public final ConfigValue<Float> tigersEyeShovelDamage;
        public final ConfigValue<Float> tigersEyeHoeDamage;
        public final ConfigValue<Float> nightmareSwordDamage;
        public final ConfigValue<Float> experienceSwordDamage;
        public final ConfigValue<Float> poisonSwordDamage;
        public final ConfigValue<Float> ratSwordDamage;
        public final ConfigValue<Float> fairySwordDamage;
        public final ConfigValue<Float> bigHammerDamage;
        public final ConfigValue<Float> prismaticReaperDamage;
        public final ConfigValue<Integer> explosionSize;
        public final ConfigValue<Integer> explosionType;
        public final ConfigValue<Boolean> explosionFire;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Attack Damage");
            builder.push("Ultimate Weapons/Tools");
            ultimateSwordDamage = builder.define("Damage of the Ultimate Sword:", 40.0F);
            ultimateAxeDamage = builder.define("Damage of the Ultimate Axe:", 42.0F);
            ultimatePickaxeDamage = builder.define("Damage of the Ultimate Pickaxe:", 38.0F);
            ultimateShovelDamage = builder.define("Damage of the Ultimate Shovel:", 38.5F);
            ultimateHoeDamage = builder.define("Damage of the Ultimate Hoe:", 1.0F);
            builder.pop();
            builder.push("Emerald Weapons/Tools");
            emeraldSwordDamage = builder.define("Damage of the Emerald Sword:", 10.0F);
            emeraldAxeDamage = builder.define("Damage of the Emerald Axe:", 12.0F);
            emeraldPickaxeDamage = builder.define("Damage of the Emerald Pickaxe:", 8.0F);
            emeraldShovelDamage = builder.define("Damage of the Emerald Shovel:", 8.5F);
            emeraldHoeDamage = builder.define("Damage of the Emerald Hoe:", 1.0F);
            builder.pop();
            builder.push("Ruby Weapons/Tools");
            rubySwordDamage = builder.define("Damage of the Ruby Sword:", 20.0F);
            rubyAxeDamage = builder.define("Damage of the Ruby Axe:", 22.0F);
            rubyPickaxeDamage = builder.define("Damage of the Ruby Pickaxe:", 18.0F);
            rubyShovelDamage = builder.define("Damage of the Ruby Shovel:", 18.5F);
            rubyHoeDamage = builder.define("Damage of the Ruby Hoe:", 1.0F);
            builder.pop();
            builder.push("Amethyst Weapons/Tools");
            amethystSwordDamage = builder.define("Damage of the Amethyst Sword:", 15.0F);
            amethystAxeDamage = builder.define("Damage of the Amethyst Axe:", 17.0F);
            amethystPickaxeDamage = builder.define("Damage of the Amethyst Pickaxe:", 13.0F);
            amethystShovelDamage = builder.define("Damage of the Amethyst Shovel:", 13.5F);
            amethystHoeDamage = builder.define("Damage of the Amethyst Hoe:", 1.0F);
            builder.pop();
            builder.push("Tiger's Eye Weapons/Tools");
            tigersEyeSwordDamage = builder.define("Damage of the Tiger's Eye Sword:", 12.0F);
            tigersEyeAxeDamage = builder.define("Damage of the Tiger's Eye Axe:", 14.0F);
            tigersEyePickaxeDamage = builder.define("Damage of the Tiger's Eye Pickaxe:", 10.0F);
            tigersEyeShovelDamage = builder.define("Damage of the Tiger's Eye Shovel:", 10.5F);
            tigersEyeHoeDamage = builder.define("Damage of the Tiger's Eye Hoe:", 1.0F);
            builder.pop();
            builder.push("Misc Weapons/Tools");
            nightmareSwordDamage = builder.define("Damage of the Nightmare Sword", 30.0F);
            experienceSwordDamage = builder.define("Damage of the Experience Sword", 10.0F);
            poisonSwordDamage = builder.define("Damage of the Poison Sword", 10.0F);
            ratSwordDamage = builder.define("Damage of the Rat Sword", 10.0F);
            fairySwordDamage = builder.define("Damage of the Fairy Sword", 10.0F);
            bigHammerDamage = builder.define("Damage of the Big Hammer", 15.0F);
            prismaticReaperDamage = builder.define("Damage of the Prismatic Reaper:", 29.0F);
            builder.pop();
            builder.pop();
            builder.push("Thunder Staff");
            explosionSize = builder.define("Thunder Staff Explosion Size", 5);
            explosionType = builder
                    .comment("0 = NONE - The Thunder Staff will no break blocks." + "\n" +
                            "1 = BREAK - The Thunder Staff will drop some blocks that it breaks. (May not work due to lightning)" + "\n" +
                            "2 = DESTROY - The Thunder Staff will destroy blocks and never drop them.")
                    .defineInRange("Thunder Staff Explosion Type:", 2, 0, 2);
            explosionFire = builder.define("Fire From Explosion:", true);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}