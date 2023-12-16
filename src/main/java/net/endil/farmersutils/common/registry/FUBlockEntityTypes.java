package net.endil.farmersutils.common.registry;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.block.entity.CrateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FUBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FarmersUtils.MOD_ID);

    public static void register(IEventBus eventBus) {
        TILES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<CrateBlockEntity>> CRATE = TILES.register("crate",
            () -> BlockEntityType.Builder.of(CrateBlockEntity::new, FUBlocks.CRATE.get()).build(null));


}
