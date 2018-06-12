package elucent.rootsclassic.item;

import java.util.Random;
import com.google.common.collect.Sets;
import elucent.rootsclassic.RegistryManager;
import elucent.rootsclassic.Roots;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLivingAxe extends ItemTool {

  Random random = new Random();

  public ItemLivingAxe() {
    super(RegistryManager.livingMaterial, Sets.newHashSet(new Block[] { Blocks.PLANKS }));

    setCreativeTab(Roots.tab);
    setHarvestLevel("axe", this.toolMaterial.getHarvestLevel());
    this.damageVsEntity = this.toolMaterial.getDamageVsEntity() + 6.0f;
    this.attackSpeed = -3.1f;
  }

  @Override
  public float getStrVsBlock(ItemStack stack, IBlockState state) {
    Material material = state.getMaterial();
    return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
  }

  @Override
  public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (random.nextInt(80) == 0) {
      if (stack.getItemDamage() > 0) {
        stack.setItemDamage(stack.getItemDamage() - 1);
      }
    }
  }

  @SideOnly(Side.CLIENT)
  public void initModel() {
    ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
  }
}
