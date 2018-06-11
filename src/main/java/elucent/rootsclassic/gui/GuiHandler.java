package elucent.rootsclassic.gui;

import elucent.rootsclassic.research.ResearchBase;
import elucent.rootsclassic.research.ResearchGroup;
import elucent.rootsclassic.research.ResearchManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 1){
			return new GuiTablet(player);
		}
		if (ID == 2){
			ResearchBase research = ResearchManager.getResearch(player.getEntityData().getString("RMOD_researchGroup"),player.getEntityData().getString("RMOD_researchBase"));
			ResearchGroup group = ResearchManager.getResearchGroup(player.getEntityData().getString("RMOD_researchGroup"));
			player.getEntityData().removeTag("RMOD_researchGroup");
			player.getEntityData().removeTag("RMOD_researchBase");
			if (research != null && group != null){
				return new GuiTabletPage(group, research, player);
			}
		}
		return null;
	}
}
