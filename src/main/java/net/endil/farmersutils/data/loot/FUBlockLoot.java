package net.endil.farmersutils.data.loot;

import net.endil.farmersutils.common.block.CrateBlock;
import net.endil.farmersutils.common.registry.FUBlockEntityTypes;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FUBlockLoot extends BlockLootSubProvider {
    private final Set<Block> generatedLootTables = new HashSet<>();

    public FUBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for (RegistryObject<Block> blockRegistryObject : Arrays.asList(FUBlocks.APPLE_BAG, FUBlocks.BROWN_MUSHROOM_BAG, FUBlocks.COCOA_BEAN_BAG, FUBlocks.CRIMSON_FUNGUS_BAG, FUBlocks.EGG_BOX, FUBlocks.GLOW_BERRY_BAG, FUBlocks.GOLDEN_APPLE_BAG, FUBlocks.KELP_BLOCK, FUBlocks.RED_MUSHROOM_BAG, FUBlocks.SUGAR_CANE_BALE, FUBlocks.SWEET_BERRY_BAG, FUBlocks.WARPED_FUNGUS_BAG,
                FUBlocks.GOLDEN_MUSHROOM_BAG, FUBlocks.GOLDEN_COCOA_BEAN_BAG, FUBlocks.GOLDEN_FUNGUS_BAG, FUBlocks.GOLDEN_EGG_BOX, FUBlocks.GOLDEN_GLOW_BERRY_BAG, FUBlocks.GOLDEN_KELP_BLOCK, FUBlocks.GOLDEN_SUGAR_CANE_BALE, FUBlocks.SWEET_GOLDEN_BERRY_BAG, FUBlocks.TRAY)) {
            this.dropSelf(blockRegistryObject.get());
        }
        this.add(FUBlocks.CRATE.get(), (block) -> createCrateDrop(FUBlocks.CRATE.get()));
    }

    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    protected LootTable.Builder createCrateDrop(Block pBlock) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(pBlock, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pBlock).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Lock", "BlockEntityTag.Lock").copy("LootTable", "BlockEntityTag.LootTable").copy("LootTableSeed", "BlockEntityTag.LootTableSeed")).apply(SetContainerContents.setContents(FUBlockEntityTypes.CRATE.get()).withEntry(DynamicLoot.dynamicEntry(CrateBlock.CONTENTS))))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return generatedLootTables;
    }
}
