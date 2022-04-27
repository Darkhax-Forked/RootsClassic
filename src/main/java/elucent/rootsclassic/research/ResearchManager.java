package elucent.rootsclassic.research;

import elucent.rootsclassic.Const;
import elucent.rootsclassic.component.ComponentRegistry;
import elucent.rootsclassic.registry.RootsRegistry;
import elucent.rootsclassic.ritual.RitualBase;
import elucent.rootsclassic.ritual.RitualBaseRegistry;
import elucent.rootsclassic.ritual.RitualRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class ResearchManager {
  public static ArrayList<ResearchGroup> globalResearches = new ArrayList<>();

  public static void onRecipesUpdated(RecipesUpdatedEvent event) {
    reload(event.getRecipeManager());
  }

  public static void reload(RecipeManager recipeManager) {
    globalResearches.clear();

    IForgeRegistry<RitualBase> ritualRegistry = RitualBaseRegistry.RITUALS.get();
    //create first page of tablet book
    globalResearches.add(new ResearchGroup("nature", "Natural Arts")
        .addResearch(new ResearchBase("bark_harvesting", new ItemStack(RootsRegistry.BARK_KNIFE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.BARK_KNIFE.get()))))
        .addResearch(new ResearchBase("magical_materials", new ItemStack(RootsRegistry.OLD_ROOT.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.OLD_ROOT.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.VERDANT_SPRIG.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.INFERNAL_BULB.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.DRAGONS_EYE.get()))))
        .addResearch(new ResearchBase("growth_powder", new ItemStack(RootsRegistry.GROWTH_POWDER.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.GROWTH_POWDER.get(), 4))))
        .addResearch(new ResearchBase("mutating_powder", new ItemStack(RootsRegistry.MUTATING_POWDER.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.MUTATING_POWDER.get()))))
        .addResearch(new ResearchBase("berries", new ItemStack(RootsRegistry.REDCURRANT.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.REDCURRANT.get()))))
        .addResearch(new ResearchBase("stew", new ItemStack(RootsRegistry.ROOTY_STEW.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ROOTY_STEW.get()))))
        .addResearch(new ResearchBase("poultice", new ItemStack(RootsRegistry.HEALING_POULTICE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.HEALING_POULTICE.get(), 2)))));
    //second page of tablet book
    globalResearches.add(new ResearchGroup("spells", "Spellcraft")
        .addResearch(new ResearchBase("mortar", new ItemStack(RootsRegistry.MORTAR.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.MORTAR.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.PESTLE.get())))
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("imbuer", new ItemStack(RootsRegistry.IMBUER.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.IMBUER.get())))
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("modifiers", new ItemStack(Items.GLOWSTONE_DUST))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("mana", new ItemStack(RootsRegistry.MANA_RESEARCH_ICON.get()))
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("poppy", new ItemStack(Blocks.POPPY, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "poppy")))))
        .addResearch(new ResearchBase("blue_orchid", new ItemStack(Blocks.BLUE_ORCHID, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "blue_orchid")))))
        .addResearch(new ResearchBase("allium", new ItemStack(Blocks.ALLIUM, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "allium")))))
        .addResearch(new ResearchBase("azure_bluet", new ItemStack(Blocks.AZURE_BLUET, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "azure_bluet")))))
        .addResearch(new ResearchBase("red_tulip", new ItemStack(Blocks.RED_TULIP, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "red_tulip")))))
        .addResearch(new ResearchBase("orange_tulip", new ItemStack(Blocks.ORANGE_TULIP, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "orange_tulip")))))
        .addResearch(new ResearchBase("white_tulip", new ItemStack(Blocks.WHITE_TULIP, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "white_tulip")))))
        .addResearch(new ResearchBase("pink_tulip", new ItemStack(Blocks.PINK_TULIP, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "pink_tulip")))))
        .addResearch(new ResearchBase("oxeye_daisy", new ItemStack(Blocks.OXEYE_DAISY, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "oxeye_daisy")))))
        .addResearch(new ResearchBase("dandelion", new ItemStack(Blocks.DANDELION))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "dandelion")))))
        .addResearch(new ResearchBase("sunflower", new ItemStack(Blocks.SUNFLOWER, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "sunflower")))))
        .addResearch(new ResearchBase("lilac", new ItemStack(Blocks.LILAC, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "lilac")))))
        .addResearch(new ResearchBase("rose_bush", new ItemStack(Blocks.ROSE_BUSH, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "rose_bush")))))
        .addResearch(new ResearchBase("peony", new ItemStack(Blocks.PEONY, 1))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "peony")))))
        .addResearch(new ResearchBase("apple", new ItemStack(Items.APPLE))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "apple")))))
        .addResearch(new ResearchBase("lily_pad", new ItemStack(Blocks.LILY_PAD))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "lily_pad")))))
        .addResearch(new ResearchBase("poisonous_potato", new ItemStack(Items.POISONOUS_POTATO))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "poisonous_potato")))))
        .addResearch(new ResearchBase("nether_wart", new ItemStack(Items.NETHER_WART))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "nether_wart")))))
        .addResearch(new ResearchBase("chorus", new ItemStack(Items.CHORUS_FRUIT))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "chorus")))))
        .addResearch(new ResearchBase("radiant_daisy", new ItemStack(RootsRegistry.RADIANT_DAISY.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.RADIANT_DAISY.get())))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "radiant_daisy")))))
        .addResearch(new ResearchBase("flare_orchid", new ItemStack(RootsRegistry.FLARE_ORCHID.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.FLARE_ORCHID.get())))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "flare_orchid")))))
        .addResearch(new ResearchBase("midnight_bloom", new ItemStack(RootsRegistry.MIDNIGHT_BLOOM.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.MIDNIGHT_BLOOM.get())))
            .addPage(new ResearchPage()
                .addMortarRecipe(ComponentRegistry.getSpellFromName(recipeManager, new ResourceLocation(Const.MODID, "midnight_bloom"))))));
    //third page of tablet book
    globalResearches.add(new ResearchGroup("ritual", "Rituals")
        .addResearch(new ResearchBase("ritual", new ItemStack(RootsRegistry.ALTAR.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ALTAR.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.BRAZIER.get())))
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("living_tools", new ItemStack(RootsRegistry.LIVING_SWORD.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIVING_PICKAXE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIVING_AXE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIVING_SHOVEL_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIVING_SWORD_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIVING_HOE_CRAFTING.get())))
        .addResearch(new ResearchBase("grow", new ItemStack(Items.BONE_MEAL, 1))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.GROW.get())))
        .addResearch(new ResearchBase("standing_stones", new ItemStack(RootsRegistry.MUNDANE_STANDING_STONE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.MUNDANE_STANDING_STONE.get()))))
        .addResearch(new ResearchBase("animal_summoning", new ItemStack(Items.PORKCHOP))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.PIG_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.COW_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SHEEP_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.CHICKEN_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.RABBIT_SUMMONING.get())))
        .addResearch(new ResearchBase("crystal_staff", new ItemStack(RootsRegistry.CRYSTAL_STAFF.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.CRYSTAL_STAFF.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.STAFF_CRAFTING.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.IMBUER.get()))
            .addPage(new ResearchPage()))
        .addResearch(new ResearchBase("rain_rituals", new ItemStack(Items.WATER_BUCKET))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.CAUSE_RAIN.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.BANISH_RAIN.get())))
        .addResearch(new ResearchBase("flare", new ItemStack(Items.BLAZE_POWDER))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.FLARE.get())))
        .addResearch(new ResearchBase("standing_stones2", new ItemStack(RootsRegistry.ATTUNED_STANDING_STONE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ATTUNED_STANDING_STONE.get()))))
        .addResearch(new ResearchBase("monster_summoning", new ItemStack(Items.ROTTEN_FLESH))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.ZOMBIE_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SKELETON_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SPIDER_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.CREEPER_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.CAVE_SPIDER_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SLIME_SUMMONING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.ENDERMAN_SUMMONING.get())))
        .addResearch(new ResearchBase("sylvan_armor", new ItemStack(RootsRegistry.SYLVAN_HOOD.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SYLVAN_HOOD_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SYLVAN_CHEST_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SYLVAN_LEGS_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SYLVAN_BOOTS_CRAFTING.get())))
        .addResearch(new ResearchBase("wildwood_armor", new ItemStack(RootsRegistry.WILDWOOD_MASK.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.WILDWOOD_HEAD_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.WILDWOOD_CHEST_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.WILDWOOD_LEGS_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.WILDWOOD_BOOTS_CRAFTING.get())))
        .addResearch(new ResearchBase("powered_stones", new ItemStack(RootsRegistry.ACCELERATOR_STANDING_STONE.get()))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.ACCELERATOR_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ACCELERATOR_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.ENTANGLER_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ENTANGLER_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.GROWER_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.GROWTH_POWDER.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.HEALER_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.HEALER_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.IGNITER_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.IGNITER_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.REPULSOR_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.REPULSOR_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.VACUUM_STONE_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.VACUUM_STANDING_STONE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.STANDING_STONE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.AESTHETIC_STANDING_STONE.get()))))
        .addResearch(new ResearchBase("mass_breeding", new ItemStack(Items.GOLDEN_CARROT))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.MASS_BREEDING.get())))
        .addResearch(new ResearchBase("life_drain", new ItemStack(Items.NETHER_WART))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.LIFE_DRAIN.get())))
        .addResearch(new ResearchBase("sacrifice", new ItemStack(Items.IRON_SWORD))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.SACRIFICE.get())))
        .addResearch(new ResearchBase("runic_focus", new ItemStack(RootsRegistry.RUNIC_FOCUS.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.RUNIC_FOCUS.get(), 1)))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.RUNIC_FOCUS_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.CHARGED_RUNIC_FOCUS.get(), 1)))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.RUNIC_FOCUS_CHARGING.get())))
        .addResearch(new ResearchBase("engraved_blade", new ItemStack(RootsRegistry.ENGRAVED_BLADE.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ENGRAVED_BLADE.get())))
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.ENGRAVED_CRAFTING.get()))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.ACACIA_BARK.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.SPRUCE_BARK.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.BIRCH_BARK.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.JUNGLE_BARK.get())))
            .addPage(new ResearchPage()
                .addDisplayItem(new ItemStack(RootsRegistry.DARK_OAK_BARK.get()))))
        .addResearch(new ResearchBase("time_shift", new ItemStack(Items.CLOCK))
            .addPage(new ResearchPage())
            .addPage(new ResearchPage()
                .addAltarRecipe(RitualRegistry.TIME_SHIFT.get()))));
  }

  public static ResearchBase getResearch(String groupName, String researchName) {
    for (ResearchGroup globalResearch : globalResearches) {
      if (globalResearch.getName().equals(groupName)) {
        for (int j = 0; j < globalResearch.researches.size(); j++) {
          if (globalResearch.researches.get(j).getName().equals(researchName)) {
            return globalResearch.researches.get(j);
          }
        }
      }
    }
    return null;
  }

  public static ResearchGroup getResearchGroup(String groupName) {
    for (ResearchGroup globalResearch : globalResearches) {
      if (globalResearch.getName().equals(groupName)) {
        return globalResearch;
      }
    }
    return null;
  }
}
