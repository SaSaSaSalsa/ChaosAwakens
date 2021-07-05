package Me.Akio.ChaosAwakens.util;

/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenericTargetSorter
/*    */   implements Comparator
/*    */ {
/*    */   private Entity theEntity;
/*    */   
/*    */   public GenericTargetSorter(Entity par2Entity) {
/* 15 */     this.theEntity = par2Entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
/* 20 */     double weight = 0.0D;
/* 21 */     double var3 = this.theEntity.getDistanceSqToEntity(par1Entity);
/* 22 */     if (par1Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 23 */       var3 /= 2.0D;
/*    */     }
/* 25 */     weight = (par1Entity.height * par1Entity.width);
/* 26 */     if (weight > 1.0D) var3 /= weight;
/*    */     
/* 28 */     double var5 = this.theEntity.getDistanceSqToEntity(par2Entity);
/* 29 */     if (par2Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 30 */       var5 /= 2.0D;
/*    */     }
/* 32 */     weight = (par2Entity.height * par2Entity.width);
/* 33 */     if (weight > 1.0D) var5 /= weight;
/*    */     
/* 35 */     return (var3 < var5) ? -1 : ((var3 > var5) ? 1 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Object par1Obj, Object par2Obj) {
/* 40 */     return compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
/*    */   }
/*    */ }