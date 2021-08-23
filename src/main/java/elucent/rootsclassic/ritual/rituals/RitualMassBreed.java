package elucent.rootsclassic.ritual.rituals;

import elucent.rootsclassic.ritual.RitualBase;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class RitualMassBreed extends RitualBase {

	public RitualMassBreed(ResourceLocation name, int level, double r, double g, double b) {
		super(name, level, r, g, b);
	}

	@Override
	public void doEffect(World world, BlockPos pos, IInventory inventory, List<ItemStack> incenses) {
		inventory.clear();
		List<AnimalEntity> animals = world.getEntitiesWithinAABB(AnimalEntity.class, new AxisAlignedBB(pos.getX() - 22, pos.getY() - 8, pos.getZ() - 22, pos.getX() + 23, pos.getY() + 9, pos.getZ() + 23));
		if (animals.size() > 0) {
			for (AnimalEntity animal : animals) {
				animal.setInLove(world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false));
				animal.getPersistentData().putInt("InLove", 400);
			}
		}
	}
}
