package elucent.rootsclassic.component.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.google.common.collect.Lists;
import elucent.rootsclassic.PlayerManager;
import elucent.rootsclassic.RegistryManager;
import elucent.rootsclassic.Util;
import elucent.rootsclassic.component.ComponentBase;
import elucent.rootsclassic.component.ComponentEffect;
import elucent.rootsclassic.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ComponentFlareOrchid extends ComponentBase {

  Random random = new Random();

  public ComponentFlareOrchid() {
    super("flareorchid", "Combustion", RegistryManager.flareOrchid, 36);
  }

  @Override
  public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size) {
    if (type == EnumCastType.SPELL) {
      BlockPos pos = Util.getRayTrace(world, (EntityPlayer) caster, 16 + 8 * (int) size);
      world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), (float) (3.0 + (double) potency), true, true);
    }
  }
}
