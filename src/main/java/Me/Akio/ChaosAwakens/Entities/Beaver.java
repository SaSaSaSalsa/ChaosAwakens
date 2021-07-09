package Me.Akio.ChaosAwakens.Entities;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Me.Akio.ChaosAwakens.ChaosAwaken;
import Me.Akio.ChaosAwakens.util.GenericTargetSorter;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Beaver extends EntityAnimal {
  private float moveSpeed = 0.15F;
  
  /*  51 */   private GenericTargetSorter TargetSorter = null;
  /*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
  /*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
  /*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
  /*  55 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D); } public Beaver(World par1World) { super(par1World);
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */     
  /* 108 */     this.closest = 99999;
  /* 109 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.6F, 0.8F); this.moveSpeed = 0.2F; this.fireResistance = 100; getNavigator().setAvoidsWater(false); this.experienceValue = 5; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.5D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
  /*     */     this.tasks.addTask(7, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
  /*     */     this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
  /* 112 */   protected void entityInit() { super.entityInit(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
  /*     */ 
  /*     */     
  /*     */     int i;
  /*     */     
  /* 117 */     for (i = -dy; i <= dy; i++) {
  /* 118 */       for (int j = -dz; j <= dz; j++) {
  /* 119 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
  /* 120 */         if (isWood(bid)) {
  /* 121 */           int d = dx * dx + j * j + i * i;
  /* 122 */           if (d < this.closest) {
  /* 123 */             this.closest = d;
  /* 124 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
  /* 125 */             found++;
  /*     */           } 
  /*     */         } 
  /* 128 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
  /* 129 */         if (isWood(bid)) {
  /* 130 */           int d = dx * dx + j * j + i * i;
  /* 131 */           if (d < this.closest) {
  /* 132 */             this.closest = d;
  /* 133 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
  /* 134 */             found++;
  /*     */           } 
  /*     */         } 
  /*     */       } 
  /*     */     } 
  /*     */     
  /* 140 */     for (i = -dx; i <= dx; i++) {
  /* 141 */       for (int j = -dz; j <= dz; j++) {
  /* 142 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
  /* 143 */         if (isWood(bid)) {
  /* 144 */           int d = dy * dy + j * j + i * i;
  /* 145 */           if (d < this.closest) {
  /* 146 */             this.closest = d;
  /* 147 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
  /* 148 */             found++;
  /*     */           } 
  /*     */         } 
  /* 151 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
  /* 152 */         if (isWood(bid)) {
  /* 153 */           int d = dy * dy + j * j + i * i;
  /* 154 */           if (d < this.closest) {
  /* 155 */             this.closest = d;
  /* 156 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
  /* 157 */             found++;
  /*     */           } 
  /*     */         } 
  /*     */       } 
  /*     */     } 
  /*     */     
  /* 163 */     for (i = -dx; i <= dx; i++) {
  /* 164 */       for (int j = -dy; j <= dy; j++) {
  /* 165 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
  /* 166 */         if (isWood(bid)) {
  /* 167 */           int d = dz * dz + j * j + i * i;
  /* 168 */           if (d < this.closest) {
  /* 169 */             this.closest = d;
  /* 170 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
  /* 171 */             found++;
  /*     */           } 
  /*     */         } 
  /* 174 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
  /* 175 */         if (isWood(bid)) {
  /* 176 */           int d = dz * dz + j * j + i * i;
  /* 177 */           if (d < this.closest) {
  /* 178 */             this.closest = d;
  /* 179 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
  /* 180 */             found++;
  /*     */           } 
  /*     */         } 
  /*     */       } 
  /*     */     } 
  /*     */     
  /* 186 */     if (found != 0) return true; 
  /* 187 */     return false; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); }
  /*     */   public boolean isWood(Block bid) { if (bid == Blocks.log || bid == Blocks.acacia_stairs || bid == Blocks.acacia_stairs)
  /*     */       return true;  if (bid == Blocks.fence || bid == Blocks.fence_gate || bid == Blocks.standing_sign)
  /*     */       return true; 
  /*     */     return false; }
  /* 192 */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null;
  /* 193 */     ItemStack is = new ItemStack(index, par1, 0);
  /* 194 */     var3 = new EntityItem(this.worldObj, this.posX + ChaosAwaken.OreSpawnRand.nextInt(4) - ChaosAwaken.OreSpawnRand.nextInt(4), this.posY + 4.0D + this.worldObj.rand.nextInt(4), this.posZ + ChaosAwaken.OreSpawnRand.nextInt(4) - ChaosAwaken.OreSpawnRand.nextInt(4), is);
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */     
  /* 199 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
  /* 200 */     return is; }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public void breakRecursor(World world, int x, int y, int z, int xf, int yf, int zf, int recursion) {
  /* 208 */     int var7 = 1;
  /*     */     
  /* 210 */     if (recursion > 200)
  /*     */       return; 
  /* 212 */     for (int var9 = -var7; var9 <= var7; var9++) {
  /*     */       
  /* 214 */       for (int var10 = -var7; var10 <= var7; var10++) {
  /*     */         
  /* 216 */         for (int var11 = -var7; var11 <= var7; var11++) {
  /*     */ 
  /*     */           
  /* 219 */           if ((var9 != 0 || var10 != 0 || var11 != 0) && (
  /* 220 */             x + var9 != xf || y + var10 != yf || z + var11 != zf) && (
  /* 221 */             recursion <= 0 || x + var9 < xf - var7 || x + var9 > xf + var7 || y + var10 < yf - var7 || y + var10 > yf + var7 || z + var11 < zf - var7 || z + var11 > zf + var7)) {
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */             
  /* 227 */             Block var12 = world.getBlock(x + var9, y + var10, z + var11);
  /* 228 */             if (isWood(var12)) {
  /*     */               
  /* 230 */               world.setBlock(x + var9, y + var10, z + var11, Blocks.air, 0, 2);
  /* 231 */               dropItemRand(Item.getItemFromBlock(var12), 1);
  /* 232 */               breakRecursor(world, x + var9, y + var10, z + var11, x, y, z, recursion + 1);
  /*     */             } 
  /*     */           } 
  /*     */         } 
  /*     */       } 
  /*     */     } 
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected void updateAITick() {
  /* 248 */     if (this.isDead)
  /* 249 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
  /* 250 */     if ((this.worldObj.rand.nextInt(30) == 0 && getBeaverHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(350) == 1)
  /*     */     {
  /* 252 */       if (ChaosAwaken.PlayNicely == 0) {
  /*     */ 
  /*     */         
  /* 255 */         this.closest = 99999;
  /* 256 */         this.tx = this.ty = this.tz = 0; int i;
  /* 257 */         for (i = 1; i < 11; i++) {
  /* 258 */           int j = i;
  /* 259 */           if (j > 2) j = 2; 
  /* 260 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
  /* 261 */             break;  if (i >= 6) i++; 
  /*     */         } 
  /* 263 */         i = 0;
  /* 264 */         if (this.closest < 99999) {
  /*     */           
  /* 266 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
  /* 267 */           if (this.closest < 12) {
  /*     */             
  /* 269 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
  /* 270 */               this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
  /* 271 */               breakRecursor(this.worldObj, this.tx, this.ty, this.tz, this.tx, this.ty, this.tz, i);
  /*     */             } 
  /* 273 */             heal(1.0F);
  /* 274 */             playSound("orespawn:chainsaw", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
  /*     */           } 
  /*     */         } 
  /*     */       } 
  /*     */     }
  /*     */ 
  /*     */     
  /* 281 */     if (this.worldObj.rand.nextInt(200) == 1) {
  /* 282 */       Beaver buddy = findBuddy();
  /* 283 */       if (buddy != null) {
  /* 284 */         getNavigator().tryMoveToXYZ(buddy.posX, buddy.posY, buddy.posZ, 0.5D);
  /*     */       }
  /*     */     } 
  /*     */     
  /* 288 */     super.updateAITick();
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   private Beaver findBuddy() {
  /* 294 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(Beaver.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D));
  /* 295 */     Collections.sort(var5, this.TargetSorter);
  /* 296 */     Iterator<?> var2 = var5.iterator();
  /* 297 */     Entity var3 = null;
  /* 298 */     Beaver var4 = null;
  /*     */     
  /* 300 */     if (var2.hasNext()) {
  /*     */       
  /* 302 */       var3 = (Entity)var2.next();
  /* 303 */       var4 = (Beaver)var3;
  /* 304 */       return var4;
  /*     */     } 
  /* 306 */     return null;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public boolean isAIEnabled() {
  /* 314 */     return true;
  /*     */   }
  /*     */ 
  /*     */   
  /*     */   public boolean canBreatheUnderwater() {
  /* 319 */     return true;
  /*     */   }
  /*     */ 
  /*     */   
  /*     */   public int mygetMaxHealth() {
  /* 324 */     return 15;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public int getBeaverHealth() {
  /* 331 */     return (int)getHealth();
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected String getLivingSound() {
  /* 341 */     return null;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected String getHurtSound() {
  /* 349 */     return "orespawn:scorpion_hit";
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected String getDeathSound() {
  /* 357 */     return "orespawn:cryo_death";
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected float getSoundVolume() {
  /* 365 */     return 0.4F;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected Item getDropItem() {
  /* 373 */     return Items.porkchop;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected float getSoundPitch() {
  /* 383 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public boolean getCanSpawnHere() {
  /* 390 */     if (this.posY < 50.0D) return false; 
  /* 391 */     if (this.posY > 100.0D) return false; 
  /* 392 */     Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ);
  /* 393 */     if (bid != Blocks.dirt && bid != Blocks.grass && bid != Blocks.tallgrass && bid != Blocks.leaves) return false; 
  /* 394 */     return true;
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   protected boolean canDespawn() {
  /* 402 */     return false;
  /*     */   }
  /*     */ 
  /*     */   
  /*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
  /* 407 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public Beaver spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
  /* 413 */     return new Beaver(this.worldObj);
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public boolean isWheat(ItemStack par1ItemStack) {
  /* 421 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
  /*     */   }
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */ 
  /*     */   
  /*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
  /* 430 */     return (par1ItemStack.getItem() == ChaosAwaken.amethyst);
  /*     */   }
  /*     */ }
