package elucent.rootsclassic.ritual.rituals;

import elucent.rootsclassic.ritual.RitualBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;

public class RitualTimeShift extends RitualBase {

	public RitualTimeShift(ResourceLocation parName, int level, double r, double g, double b) {
		super(parName, level, r, g, b);
	}

	@Override
	public void doEffect(World world, BlockPos pos, IInventory inventory, List<ItemStack> incenses) {
		long shiftAmount = 0;
		List<Item> items = new ArrayList<>();
		for (ItemStack i : incenses) {
			items.add(i.getItem());
		}
		for (Item i : items) {
			if (i == Items.CLOCK) {
				shiftAmount += 1000;
			}
		}
		inventory.clear();
		if(!world.isRemote && world.getServer() != null) {
			for(ServerWorld serverworld : world.getServer().getWorlds()) {
				serverworld.setDayTime(serverworld.getDayTime() + shiftAmount);
			}
		}
	}
}
