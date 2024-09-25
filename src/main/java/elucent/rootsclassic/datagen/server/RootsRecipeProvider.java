package elucent.rootsclassic.datagen.server;

import elucent.rootsclassic.Const;
import elucent.rootsclassic.component.ComponentRegistry;
import elucent.rootsclassic.datagen.recipe.ComponentRecipeBuilder;
import elucent.rootsclassic.datagen.recipe.RitualRecipeBuilder;
import elucent.rootsclassic.registry.RootsRegistry;
import elucent.rootsclassic.ritual.RitualRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class RootsRecipeProvider extends RecipeProvider {

	public RootsRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void buildRecipes(RecipeOutput consumer, HolderLookup.Provider holderLookup) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.PESTLE.get())
			.define('X', Blocks.DIORITE)
			.group("pestle")
			.pattern("X  ").pattern(" XX").pattern(" XX")
			.unlockedBy("has_diorite", has(Blocks.DIORITE))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.PESTLE.get())
			.define('X', Blocks.DIORITE)
			.group("pestle")
			.pattern("  X").pattern("XX ").pattern("XX ")
			.unlockedBy("has_diorite", has(Blocks.DIORITE))
			.save(consumer, RootsRegistry.PESTLE.getId() + "2");
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.MORTAR.get())
			.define('X', Tags.Items.STONES)
			.pattern("X X").pattern("X X").pattern(" X ")
			.unlockedBy("has_stone", has(Tags.Items.STONES))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.IMBUER.get())
			.define('X', Tags.Items.RODS_WOODEN)
			.define('L', ItemTags.LOGS)
			.define('S', Blocks.CHISELED_STONE_BRICKS)
			.pattern("X X").pattern("LSL")
			.unlockedBy("has_chiseled_stone_bricks", has(Blocks.CHISELED_STONE_BRICKS))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.MUNDANE_STANDING_STONE.get())
			.define('S', Tags.Items.STONES)
			.define('B', Blocks.STONE_BRICKS)
			.define('L', Tags.Items.STORAGE_BLOCKS_LAPIS)
			.pattern("SBS").pattern("BLB").pattern("SBS")
			.unlockedBy("has_lapis_block", has(Tags.Items.STORAGE_BLOCKS_LAPIS))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.ATTUNED_STANDING_STONE.get())
			.define('S', Tags.Items.STONES)
			.define('N', Items.NETHER_BRICK)
			.define('D', Tags.Items.GEMS_DIAMOND)
			.pattern("SNS").pattern("NDN").pattern("SNS")
			.unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.BRAZIER.get())
			.define('I', Tags.Items.INGOTS_IRON)
			.define('S', Tags.Items.STRINGS)
			.define('C', Items.CAULDRON)
			.define('X', Tags.Items.RODS_WOODEN)
			.pattern("ISI").pattern("ICI").pattern("IXI")
			.unlockedBy("has_cauldron", has(Items.CAULDRON))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.ALTAR.get())
			.define('S', Tags.Items.STONES)
			.define('F', Items.POPPY)
			.define('B', RootsRegistry.VERDANT_SPRIG.get())
			.define('G', Tags.Items.STORAGE_BLOCKS_GOLD)
			.define('C', Blocks.CHISELED_STONE_BRICKS)
			.pattern("BFB").pattern("SGS").pattern(" C ")
			.unlockedBy("has_gold_block", has(Tags.Items.STORAGE_BLOCKS_GOLD))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RootsRegistry.BARK_KNIFE.get())
			.define('S', Tags.Items.RODS_WOODEN)
			.define('V', ItemTags.SAPLINGS)
			.define('P', ItemTags.PLANKS)
			.pattern(" VV").pattern("VPV").pattern("SV ")
			.unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
			.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RootsRegistry.RUNIC_TABLET.get())
			.define('S', Tags.Items.SEEDS_WHEAT)
			.define('B', Tags.Items.STONES)
			.define('R', RootsRegistry.OLD_ROOT.get())
			.pattern(" R ").pattern("SBS").pattern(" S ")
			.unlockedBy("has_old_root", has(RootsRegistry.OLD_ROOT.get()))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RootsRegistry.GROWTH_POWDER.get(), 4)
			.requires(Tags.Items.SEEDS_WHEAT)
			.requires(Items.SHORT_GRASS)
			.requires(Tags.Items.DUSTS_REDSTONE)
			.requires(RootsRegistry.PESTLE.get())
			.unlockedBy("has_pestle", has(RootsRegistry.PESTLE.get()))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RootsRegistry.MUTATING_POWDER.get())
			.requires(RootsRegistry.GROWTH_POWDER.get())
			.requires(RootsRegistry.GROWTH_POWDER.get())
			.requires(RootsRegistry.GROWTH_POWDER.get())
			.requires(RootsRegistry.GROWTH_POWDER.get())
			.requires(Tags.Items.NETHER_STARS)
			.requires(Tags.Items.CROPS_NETHER_WART)
			.requires(RootsRegistry.PESTLE.get())
			.unlockedBy("has_pestle", has(RootsRegistry.PESTLE.get()))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, RootsRegistry.ROOTY_STEW.get())
			.requires(Tags.Items.CROPS_WHEAT)
			.requires(Items.BOWL)
			.requires(RootsRegistry.OLD_ROOT.get())
			.unlockedBy("has_bowl", has(Items.BOWL))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, RootsRegistry.FRUIT_SALAD.get())
			.requires(Items.MELON)
			.requires(Items.MELON)
			.requires(Items.MELON)
			.requires(Items.APPLE)
			.requires(Items.BOWL)
			.requires(RootsRegistry.ELDERBERRY.get())
			.requires(RootsRegistry.WHITECURRANT.get())
			.requires(RootsRegistry.BLACKCURRANT.get())
			.requires(RootsRegistry.REDCURRANT.get())
			.unlockedBy("has_bowl", has(Items.BOWL))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RootsRegistry.HEALING_POULTICE.get(), 2)
			.requires(RootsRegistry.REDCURRANT.get())
			.requires(Items.PAPER)
			.requires(RootsRegistry.PESTLE.get())
			.requires(RootsRegistry.VERDANT_SPRIG.get())
			.unlockedBy("has_pestle", has(RootsRegistry.PESTLE.get()))
			.save(consumer);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(RootsRegistry.DRAGONS_EYE.get()), RecipeCategory.MISC, Items.ENDER_PEARL, 1F, 200)
			.unlockedBy("has_dragons_eye", has(RootsRegistry.DRAGONS_EYE.get()))
			.save(consumer, "rootsclassic:ender_pearl");

		/**
		 * Components
		 */
		new ComponentRecipeBuilder(ComponentRegistry.ALLIUM.getId())
			.materials(
				Ingredient.of(Items.ALLIUM),
				Ingredient.of(Items.SOUL_SAND),
				Ingredient.of(Items.BROWN_MUSHROOM),
				Ingredient.of(RootsRegistry.ELDERBERRY)
			)
			.save(consumer, Const.modLoc("component/allium"));
		new ComponentRecipeBuilder(ComponentRegistry.APPLE.getId())
			.materials(
				Ingredient.of(Items.APPLE),
				Ingredient.of(Items.GLISTERING_MELON_SLICE),
				Ingredient.of(Items.GOLDEN_APPLE),
				Ingredient.of(RootsRegistry.BLACKCURRANT)
			)
			.save(consumer, Const.modLoc("component/apple"));
		new ComponentRecipeBuilder(ComponentRegistry.AZURE_BLUET.getId())
			.materials(
				Ingredient.of(Items.AZURE_BLUET),
				Ingredient.of(Items.IRON_INGOT),
				Ingredient.of(Items.SPRUCE_SAPLING),
				Ingredient.of(RootsRegistry.WHITECURRANT)
			)
			.save(consumer, Const.modLoc("component/azure_bluet"));
		new ComponentRecipeBuilder(ComponentRegistry.BLUE_ORCHID.getId())
			.materials(
				Ingredient.of(Items.BLUE_ORCHID),
				Ingredient.of(Items.PRISMARINE_SHARD),
				Ingredient.of(Items.LAPIS_LAZULI),
				Ingredient.of(Items.VINE)
			)
			.save(consumer, Const.modLoc("component/blue_orchid"));
		new ComponentRecipeBuilder(ComponentRegistry.CHORUS.getId())
			.materials(
				Ingredient.of(Items.CHORUS_FRUIT),
				Ingredient.of(Items.ENDER_PEARL),
				Ingredient.of(Items.PURPLE_DYE),
				Ingredient.of(Items.POPPED_CHORUS_FRUIT)
			)
			.save(consumer, Const.modLoc("component/chorus"));
		new ComponentRecipeBuilder(ComponentRegistry.DANDELION.getId())
			.materials(
				Ingredient.of(Items.DANDELION),
				Ingredient.of(Items.STRING),
				Ingredient.of(Items.FEATHER),
				Ingredient.of(RootsRegistry.WHITECURRANT)
			)
			.save(consumer, Const.modLoc("component/dandelion"));
		new ComponentRecipeBuilder(ComponentRegistry.FLARE_ORCHID.getId())
			.materials(
				Ingredient.of(Items.NETHERRACK),
				Ingredient.of(Items.MAGMA_CREAM),
				Ingredient.of(Items.BLAZE_ROD),
				Ingredient.of(RootsRegistry.FLARE_ORCHID)
			)
			.save(consumer, Const.modLoc("component/flare_orchid"));
		new ComponentRecipeBuilder(ComponentRegistry.LILAC.getId())
			.materials(
				Ingredient.of(Items.LILAC),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.BEETROOT),
				Ingredient.of(Items.VINE)
			)
			.save(consumer, Const.modLoc("component/lilac"));
		new ComponentRecipeBuilder(ComponentRegistry.LILY_PAD.getId())
			.materials(
				Ingredient.of(Items.LILY_PAD),
				Ingredient.of(Items.WET_SPONGE),
				Ingredient.of(Items.BEETROOT),
				Ingredient.of(RootsRegistry.BLACKCURRANT)
			)
			.save(consumer, Const.modLoc("component/lily_pad"));
		new ComponentRecipeBuilder(ComponentRegistry.MIDNIGHT_BLOOM.getId())
			.materials(
				Ingredient.of(Items.OBSIDIAN),
				Ingredient.of(Items.DRAGON_BREATH),
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(RootsRegistry.MIDNIGHT_BLOOM)
			)
			.save(consumer, Const.modLoc("component/midnight_bloom"));
		new ComponentRecipeBuilder(ComponentRegistry.NETHER_WART.getId())
			.materials(
				Ingredient.of(Items.NETHER_WART),
				Ingredient.of(Items.BLAZE_POWDER),
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.CHARCOAL)
			)
			.save(consumer, Const.modLoc("component/nether_wart"));
		new ComponentRecipeBuilder(ComponentRegistry.ORANGE_TULIP.getId())
			.materials(
				Ingredient.of(Items.ORANGE_TULIP),
				Ingredient.of(Items.SPONGE),
				Ingredient.of(Items.LEATHER),
				Ingredient.of(RootsRegistry.REDCURRANT)
			)
			.save(consumer, Const.modLoc("component/orange_tulip"));
		new ComponentRecipeBuilder(ComponentRegistry.OXEYE_DAISY.getId())
			.materials(
				Ingredient.of(Items.OXEYE_DAISY),
				Ingredient.of(Items.END_STONE),
				Ingredient.of(Items.GOLD_INGOT),
				Ingredient.of(Items.SUGAR)
			)
			.save(consumer, Const.modLoc("component/oxeye_daisy"));
		new ComponentRecipeBuilder(ComponentRegistry.PEONY.getId())
			.materials(
				Ingredient.of(Items.PEONY),
				Ingredient.of(Items.MELON),
				Ingredient.of(Items.RED_DYE),
				Ingredient.of(RootsRegistry.NIGHTSHADE)
			)
			.save(consumer, Const.modLoc("component/peony"));
		new ComponentRecipeBuilder(ComponentRegistry.PINK_TULIP.getId())
			.materials(
				Ingredient.of(Items.PINK_TULIP),
				Ingredient.of(Items.MELON_SEEDS),
				Ingredient.of(Items.PORKCHOP),
				Ingredient.of(Items.GRANITE)
			)
			.save(consumer, Const.modLoc("component/pink_tulip"));
		new ComponentRecipeBuilder(ComponentRegistry.POISONOUS_POTATO.getId())
			.materials(
				Ingredient.of(Items.POISONOUS_POTATO),
				Ingredient.of(Items.GLASS),
				Ingredient.of(Items.GLOWSTONE),
				Ingredient.of(Items.SUGAR_CANE)
			)
			.save(consumer, Const.modLoc("component/poisonous_potato"));
		new ComponentRecipeBuilder(ComponentRegistry.POPPY.getId())
			.materials(
				Ingredient.of(Items.POPPY),
				Ingredient.of(Items.RED_MUSHROOM),
				Ingredient.of(Items.BEEF),
				Ingredient.of(RootsRegistry.REDCURRANT)
			)
			.save(consumer, Const.modLoc("component/poppy"));
		new ComponentRecipeBuilder(ComponentRegistry.RADIANT_DAISY.getId())
			.materials(
				Ingredient.of(Items.REDSTONE_BLOCK),
				Ingredient.of(Items.GLOWSTONE),
				Ingredient.of(RootsRegistry.NIGHTSHADE),
				Ingredient.of(RootsRegistry.RADIANT_DAISY)
			)
			.save(consumer, Const.modLoc("component/radiant_daisy"));
		new ComponentRecipeBuilder(ComponentRegistry.RED_TULIP.getId())
			.materials(
				Ingredient.of(Items.RED_TULIP),
				Ingredient.of(Items.NETHER_BRICK),
				Ingredient.of(Items.QUARTZ),
				Ingredient.of(Items.RED_SAND)
			)
			.save(consumer, Const.modLoc("component/red_tulip"));
		new ComponentRecipeBuilder(ComponentRegistry.ROSE_BUSH.getId())
			.materials(
				Ingredient.of(Items.ROSE_BUSH),
				Ingredient.of(Items.FERMENTED_SPIDER_EYE),
				Ingredient.of(Items.IRON_NUGGET),
				Ingredient.of(Items.BONE)
			)
			.save(consumer, Const.modLoc("component/rose_bush"));
		new ComponentRecipeBuilder(ComponentRegistry.SUNFLOWER.getId())
			.materials(
				Ingredient.of(Items.SUNFLOWER),
				Ingredient.of(Items.JACK_O_LANTERN),
				Ingredient.of(Items.BONE_MEAL),
				Ingredient.of(RootsRegistry.ELDERBERRY)
			)
			.save(consumer, Const.modLoc("component/sunflower"));
		new ComponentRecipeBuilder(ComponentRegistry.WHITE_TULIP.getId())
			.materials(
				Ingredient.of(Items.WHITE_TULIP),
				Ingredient.of(Items.SNOWBALL),
				Ingredient.of(Items.BIRCH_SAPLING),
				Ingredient.of(RootsRegistry.WHITECURRANT)
			)
			.save(consumer, Const.modLoc("component/white_tulip"));


		/**
		 * Rituals
		 */

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.ACCELERATOR_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.STONE_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.JUNGLE_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/accelerator_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.AESTHETIC_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.MOSSY_STONE_BRICKS)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/aesthetic_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.CHARGED_RUNIC_FOCUS.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.RUNIC_FOCUS),
				Ingredient.of(Items.REDSTONE),
				Ingredient.of(Items.GLOWSTONE_DUST)
			)
			.incenses(
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT)
			)
			.level(0)
			.color("#00f26d")
			.save(consumer, Const.modLoc("ritual/crafting/charged_runic_focus"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.CRYSTAL_STAFF.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND_BLOCK),
				Ingredient.of(Items.STICK),
				Ingredient.of(Items.BLAZE_POWDER)
			)
			.incenses(
				Ingredient.of(Items.COAL_BLOCK),
				Ingredient.of(RootsRegistry.ACACIA_BARK),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.BIRCH_BARK)
			)
			.level(2)
			.color("#cd5600")
			.save(consumer, Const.modLoc("ritual/crafting/crystal_staff"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.GROWER_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.STONE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.BIRCH_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/grower_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.HEALER_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.REDSTONE),
				Ingredient.of(Items.CHISELED_STONE_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.GHAST_TEAR)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/healer_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.IGNITER_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.REDSTONE),
				Ingredient.of(Items.CRACKED_STONE_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.ACACIA_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/igniter_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.LIVING_AXE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.WOODEN_AXE),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.GOLD_NUGGET)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.color("#92d62b")
			.save(consumer, Const.modLoc("ritual/crafting/living_axe"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.LIVING_HOE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.WOODEN_HOE),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.GOLD_NUGGET)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.color("#92d62b")
			.save(consumer, Const.modLoc("ritual/crafting/living_hoe"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.LIVING_PICKAXE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.WOODEN_PICKAXE),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.GOLD_NUGGET)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.color("#92d62b")
			.save(consumer, Const.modLoc("ritual/crafting/living_pickaxe"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.LIVING_SHOVEL.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.WOODEN_SHOVEL),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.GOLD_NUGGET)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.color("#92d62b")
			.save(consumer, Const.modLoc("ritual/crafting/living_shovel"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.LIVING_SWORD.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.WOODEN_SWORD),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.GOLD_NUGGET)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.color("#92d62b")
			.save(consumer, Const.modLoc("ritual/crafting/living_sword"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.REPULSOR_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.CHISELED_STONE_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.SPRUCE_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/repulsor_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.RUNIC_FOCUS.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.STONE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.SPRUCE_BARK),
				Ingredient.of(RootsRegistry.ACACIA_BARK),
				Ingredient.of(RootsRegistry.JUNGLE_BARK)
			)
			.level(2)
			.color("#00f26d")
			.save(consumer, Const.modLoc("ritual/crafting/runic_focus"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.SYLVAN_BOOTS.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.LEATHER_BOOTS),
				Ingredient.of(Items.VINE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(Items.GOLDEN_APPLE),
				Ingredient.of(Items.POPPY)
			)
			.level(2)
			.color("#3e8a3e")
			.save(consumer, Const.modLoc("ritual/crafting/sylvan_boots"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.SYLVAN_HOOD.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.LEATHER_HELMET),
				Ingredient.of(Items.VINE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(Items.GOLDEN_APPLE),
				Ingredient.of(Items.POPPY)
			)
			.level(2)
			.color("#3e8a3e")
			.save(consumer, Const.modLoc("ritual/crafting/sylvan_hood"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.SYLVAN_ROBE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.LEATHER_CHESTPLATE),
				Ingredient.of(Items.VINE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(Items.GOLDEN_APPLE),
				Ingredient.of(Items.POPPY)
			)
			.level(2)
			.color("#3e8a3e")
			.save(consumer, Const.modLoc("ritual/crafting/sylvan_robe"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.SYLVAN_TUNIC.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.LEATHER_LEGGINGS),
				Ingredient.of(Items.VINE)
			)
			.incenses(
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(RootsRegistry.BIRCH_BARK),
				Ingredient.of(Items.GOLDEN_APPLE),
				Ingredient.of(Items.POPPY)
			)
			.level(2)
			.color("#3e8a3e")
			.save(consumer, Const.modLoc("ritual/crafting/sylvan_tunic"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.VACUUM_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.NETHER_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.DARK_OAK_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/vacuum_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.WILDWOOD_BOOTS.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.IRON_BOOTS),
				Ingredient.of(Items.OAK_PLANKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.OAK_SAPLING)
			)
			.level(2)
			.color("#917341")
			.save(consumer, Const.modLoc("ritual/crafting/wildwood_boots"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.WILDWOOD_LEGGINGS.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.IRON_LEGGINGS),
				Ingredient.of(Items.OAK_PLANKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.OAK_SAPLING)
			)
			.level(2)
			.color("#917341")
			.save(consumer, Const.modLoc("ritual/crafting/wildwood_leggings"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.WILDWOOD_MASK.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.IRON_HELMET),
				Ingredient.of(Items.OAK_PLANKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.OAK_SAPLING)
			)
			.level(2)
			.color("#917341")
			.save(consumer, Const.modLoc("ritual/crafting/wildwood_mask"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.WILDWOOD_PLATE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.DIAMOND),
				Ingredient.of(Items.IRON_CHESTPLATE),
				Ingredient.of(Items.OAK_PLANKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(RootsRegistry.OAK_BARK),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.OAK_SAPLING)
			)
			.level(2)
			.color("#917341")
			.save(consumer, Const.modLoc("ritual/crafting/wildwood_plate"));

		new RitualRecipeBuilder(RitualRegistry.CRAFTING.getId())
			.config(stackTag(RootsRegistry.ENTANGLER_STANDING_STONE.toStack(), holderLookup))
			.materials(
				Ingredient.of(RootsRegistry.ATTUNED_STANDING_STONE),
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.CRACKED_STONE_BRICKS)
			)
			.incenses(
				Ingredient.of(RootsRegistry.VERDANT_SPRIG),
				Ingredient.of(RootsRegistry.INFERNAL_BULB),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(RootsRegistry.OAK_BARK)
			)
			.level(2)
			.color("#006949")
			.save(consumer, Const.modLoc("ritual/crafting/entangler_standing_stone"));

		new RitualRecipeBuilder(RitualRegistry.ENGRAVED_CRAFTING.getId())
			.config(stackTag(RootsRegistry.ENGRAVED_BLADE.toStack(), holderLookup))
			.materials(
				Ingredient.of(Items.STONE_SWORD),
				Ingredient.of(RootsRegistry.RUNIC_FOCUS),
				Ingredient.of(Items.GLOWSTONE_DUST)
			)
			.incenses(
				Ingredient.of(Items.GOLDEN_CARROT),
				Ingredient.of(Items.GOLDEN_APPLE)
			)
			.level(2)
			.color("#686a6b")
			.save(consumer, Const.modLoc("ritual/crafting/engraved_crafting"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.CAVE_SPIDER, holderLookup))
			.materials(
				Ingredient.of(Items.STRING),
				Ingredient.of(Items.FERMENTED_SPIDER_EYE),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/cave_spider"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.CHICKEN, holderLookup))
			.materials(
				Ingredient.of(Items.CHICKEN),
				Ingredient.of(Items.FEATHER),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(1)
			.color("#c769c1")
			.save(consumer, Const.modLoc("ritual/summoning/chicken"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.COW, holderLookup))
			.materials(
				Ingredient.of(Items.BEEF),
				Ingredient.of(Items.LEATHER),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(1)
			.color("#c769c1")
			.save(consumer, Const.modLoc("ritual/summoning/cow"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.CREEPER, holderLookup))
			.materials(
				Ingredient.of(Items.GUNPOWDER),
				Ingredient.of(Items.GUNPOWDER),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/creeper"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.ENDERMAN, holderLookup))
			.materials(
				Ingredient.of(Items.ENDER_PEARL),
				Ingredient.of(Items.ENDER_PEARL),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/enderman"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.PIG, holderLookup))
			.materials(
				Ingredient.of(Items.PORKCHOP),
				Ingredient.of(Items.PORKCHOP),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(1)
			.color("#c769c1")
			.save(consumer, Const.modLoc("ritual/summoning/pig"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.RABBIT, holderLookup))
			.materials(
				Ingredient.of(Items.RABBIT),
				Ingredient.of(Items.RABBIT_HIDE),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(1)
			.color("#c769c1")
			.save(consumer, Const.modLoc("ritual/summoning/rabbit"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.SHEEP, holderLookup))
			.materials(
				Ingredient.of(Items.MUTTON),
				Ingredient.of(ItemTags.WOOL),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(1)
			.color("#c769c1")
			.save(consumer, Const.modLoc("ritual/summoning/sheep"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.SKELETON, holderLookup))
			.materials(
				Ingredient.of(Items.ARROW),
				Ingredient.of(Items.BONE),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/skeleton"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.SLIME, holderLookup))
			.materials(
				Ingredient.of(Items.SLIME_BALL),
				Ingredient.of(Items.SLIME_BALL),
				Ingredient.of(Items.SLIME_BALL)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/slime"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.SPIDER, holderLookup))
			.materials(
				Ingredient.of(Items.STRING),
				Ingredient.of(Items.SPIDER_EYE),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/spider"));

		new RitualRecipeBuilder(RitualRegistry.SUMMONING.getId())
			.config(entityTag(EntityType.ZOMBIE, holderLookup))
			.materials(
				Ingredient.of(Items.ROTTEN_FLESH),
				Ingredient.of(Items.ROTTEN_FLESH),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.NETHER_WART)
			)
			.level(2)
			.color("#3a0254")
			.save(consumer, Const.modLoc("ritual/summoning/zombie"));

		new RitualRecipeBuilder(RitualRegistry.BANISH_RAIN.getId())
			.materials(
				Ingredient.of(Items.WHEAT)
			)
			.incenses(
				Ingredient.of(Items.VINE),
				Ingredient.of(RootsRegistry.OLD_ROOT)
			)
			.level(1)
			.color("#cc9f23")
			.save(consumer, Const.modLoc("ritual/banish_rain"));

		new RitualRecipeBuilder(RitualRegistry.CAUSE_RAIN.getId())
			.materials(
				Ingredient.of(Items.LILY_PAD)
			)
			.incenses(
				Ingredient.of(Items.VINE)
			)
			.level(1)
			.color("#17008a")
			.save(consumer, Const.modLoc("ritual/cause_rain"));

		new RitualRecipeBuilder(RitualRegistry.FLARE.getId())
			.materials(
				Ingredient.of(Items.FLINT),
				Ingredient.of(Items.COAL),
				Ingredient.of(Items.CHARCOAL)
			)
			.incenses(
				Ingredient.of(Items.GUNPOWDER),
				Ingredient.of(RootsRegistry.INFERNAL_BULB)
			)
			.level(1)
			.color("#ff5b19")
			.save(consumer, Const.modLoc("ritual/flare"));

		new RitualRecipeBuilder(RitualRegistry.GROW.getId())
			.materials(
				Ingredient.of(Items.REDSTONE),
				Ingredient.of(Items.BONE_MEAL),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG)
			)
			.incenses(
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.BEETROOT),
				Ingredient.of(Items.POTATO),
				Ingredient.of(Items.CARROT)
			)
			.color("#52d42f")
			.save(consumer, Const.modLoc("ritual/grow"));

		new RitualRecipeBuilder(RitualRegistry.IMBUER.getId())
			.materials(
				Ingredient.of(RootsRegistry.CRYSTAL_STAFF),
				Ingredient.of(RootsRegistry.VERDANT_SPRIG)
			)
			.level(1)
			.color("#ffffff")
			.save(consumer, Const.modLoc("ritual/imbuer"));

		new RitualRecipeBuilder(RitualRegistry.LIFE_DRAIN.getId())
			.materials(
				Ingredient.of(Items.BLAZE_POWDER),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.WOODEN_SWORD),
				Ingredient.of(Items.WOODEN_AXE),
				Ingredient.of(RootsRegistry.DARK_OAK_BARK),
				Ingredient.of(RootsRegistry.BIRCH_BARK)
			)
			.color("#8b1628")
			.save(consumer, Const.modLoc("ritual/life_drain"));

		new RitualRecipeBuilder(RitualRegistry.MASS_BREEDING.getId())
			.materials(
				Ingredient.of(Items.GLOWSTONE_DUST),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.CARROT),
				Ingredient.of(Items.WHEAT),
				Ingredient.of(Items.WHEAT_SEEDS),
				Ingredient.of(Items.COD)
			)
			.level(2)
			.color("#943d51")
			.save(consumer, Const.modLoc("ritual/mass_breeding"));

		new RitualRecipeBuilder(RitualRegistry.SACRIFICE.getId())
			.materials(
				Ingredient.of(Items.FLINT),
				Ingredient.of(Items.IRON_SWORD),
				Ingredient.of(Items.BONE)
			)
			.incenses(
				Ingredient.of(Items.BLAZE_POWDER),
				Ingredient.of(RootsRegistry.DARK_OAK_BARK)
			)
			.level(2)
			.color("#5e0938")
			.save(consumer, Const.modLoc("ritual/sacrifice"));

		new RitualRecipeBuilder(RitualRegistry.TIME_SHIFT.getId())
			.materials(Ingredient.of(Items.CLOCK), Ingredient.of(Items.IRON_INGOT))
			.incenses(Ingredient.of(Items.CLOCK))
			.level(1)
			.color("#f0f563").secondaryColor("#fca223")
			.save(consumer, Const.modLoc("ritual/time_shift"));
	}

	private CompoundTag stackTag(ItemStack stack, HolderLookup.Provider holderLookup) {
		CompoundTag tag = new CompoundTag();
		tag.put("result", stack.save(holderLookup, new CompoundTag()));
		return tag;
	}

	private CompoundTag entityTag(EntityType<?> entityType, HolderLookup.Provider holderLookup) {
		CompoundTag tag = new CompoundTag();
		tag.putString("entity", BuiltInRegistries.ENTITY_TYPE.getKey(entityType).toString());
		return tag;
	}
}
