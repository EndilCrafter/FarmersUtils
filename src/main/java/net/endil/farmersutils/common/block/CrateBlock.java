package net.endil.farmersutils.common.block;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.block.entity.CrateBlockEntity;
import net.endil.farmersutils.common.registry.FUBlockEntityTypes;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class CrateBlock extends BaseEntityBlock {
    public static final ResourceLocation CONTENTS = new ResourceLocation(FarmersUtils.MOD_ID, "contents");
    public static final IntegerProperty FILLED = FUBlockStateProperties.FILLED;
    private static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    private static final VoxelShape NORTH_BASE = Block.box(0.0D, 2.0D, 0.0D, 16.0D, 4.0D, 2.0D);
    private static final VoxelShape NORTH_POST1 = Block.box(0.0D, 4.0D, 0.0D, 2.0D, 14.0D, 2.0D);
    private static final VoxelShape NORTH_POST2 = Block.box(14.0D, 4.0D, 0.0D, 16.0D, 14.0D, 2.0D);
    private static final VoxelShape NORTH_POST3 = Block.box(2.0D, 6.0D, 0.0D, 14.0D, 8.0D, 2.0D);
    private static final VoxelShape NORTH_POST4 = Block.box(2.0D, 10.0D, 0.0D, 14.0D, 12.0D, 2.0D);
    private static final VoxelShape NORTH_TOP = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 2.0D);
    private static final VoxelShape SOUTH_BASE = Block.box(0.0D, 2.0D, 14.0D, 16.0D, 4.0D, 16.0D);
    private static final VoxelShape SOUTH_POST1 = Block.box(0.0D, 4.0D, 14.0D, 2.0D, 14.0D, 16.0D);
    private static final VoxelShape SOUTH_POST2 = Block.box(14.0D, 4.0D, 14.0D, 16.0D, 14.0D, 16.0D);
    private static final VoxelShape SOUTH_POST3 = Block.box(2.0D, 6.0D, 14.0D, 14.0D, 8.0D, 16.0D);
    private static final VoxelShape SOUTH_POST4 = Block.box(2.0D, 10.0D, 14.0D, 14.0D, 12.0D, 16.0D);
    private static final VoxelShape SOUTH_TOP = Block.box(0.0D, 14.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_BASE = Block.box(14.0D, 2.0D, 2.0D, 16.0D, 4.0D, 14.0D);
    private static final VoxelShape EAST_POST1 = Block.box(14.0D, 6.0D, 2.0D, 16.0D, 8.0D, 14.0D);
    private static final VoxelShape EAST_POST2 = Block.box(14.0D, 10.0D, 2.0D, 16.0D, 12.0D, 14.0D);
    private static final VoxelShape EAST_TOP = Block.box(14.0D, 14.0D, 2.0D, 16.0D, 16.0D, 14.0D);
    private static final VoxelShape WEST_BASE = Block.box(0.0D, 2.0D, 2.0D, 2.0D, 4.0D, 14.0D);
    private static final VoxelShape WEST_POST1 = Block.box(0.0D, 6.0D, 2.0D, 2.0D, 8.0D, 14.0D);
    private static final VoxelShape WEST_POST2 = Block.box(0.0D, 10.0D, 2.0D, 2.0D, 12.0D, 14.0D);
    private static final VoxelShape WEST_TOP = Block.box(0.0D, 14.0D, 2.0D, 2.0D, 16.0D, 14.0D);
    private static final VoxelShape FILLED1 = Block.box(2.0D, 2.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    private static final VoxelShape FILLED2 = Block.box(2.0D, 2.0D, 2.0D, 14.0D, 10.0D, 14.0D);
    private static final VoxelShape FILLED3 = Block.box(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D);
    private static final VoxelShape BASE0 = Shapes.or(BOTTOM,
            NORTH_BASE, NORTH_POST1, NORTH_POST2, NORTH_POST3, NORTH_POST4, NORTH_TOP,
            SOUTH_BASE, SOUTH_POST1, SOUTH_POST2, SOUTH_POST3, SOUTH_POST4, SOUTH_TOP,
            EAST_BASE, EAST_POST1, EAST_POST2, EAST_TOP, WEST_BASE, WEST_POST1, WEST_POST2, WEST_TOP);
    private static final VoxelShape BASE1 = Shapes.or(BASE0, FILLED1);
    private static final VoxelShape BASE2 = Shapes.or(BASE0, FILLED2);
    private static final VoxelShape BASE3 = Shapes.or(BASE0, FILLED3);

    public CrateBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FILLED, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FUBlockStateProperties.FILLED);
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof CrateBlockEntity crateBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !crateBlockEntity.isEmpty()) {
                ItemStack itemstack = new ItemStack(FUBlocks.CRATE.get());
                blockentity.saveToItem(itemstack);
                if (crateBlockEntity.hasCustomName()) {
                    itemstack.setHoverName(crateBlockEntity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            } else {
                crateBlockEntity.unpackLootTable(player);
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockentity instanceof CrateBlockEntity crateBlockEntity) {
            builder = builder.withDynamicDrop(CONTENTS, (consumer) -> {
                for (int i = 0; i < crateBlockEntity.getContainerSize(); ++i) {
                    consumer.accept(crateBlockEntity.getItem(i));
                }

            });
        }

        return super.getDrops(state, builder);
    }


    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        if (pStack.hasCustomHoverName()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof CrateBlockEntity) {
                ((CrateBlockEntity) blockentity).setCustomName(pStack.getHoverName());
            }
        }

    }

    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof CrateBlockEntity) {
                pLevel.updateNeighbourForOutputSignal(pPos, pState.getBlock());
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FILLED, 3);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FILLED)) {
            default -> BASE0;
            case 1 -> BASE1;
            case 2 -> BASE2;
            case 3 -> BASE3;
        };
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrateBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else if (pPlayer.isSpectator()) {
            return InteractionResult.CONSUME;
        } else {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof CrateBlockEntity crateBlockEntity) {
                pPlayer.openMenu(crateBlockEntity);
                return InteractionResult.CONSUME;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer((Container) pLevel.getBlockEntity(pPos));
    }

    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        ItemStack itemstack = super.getCloneItemStack(pLevel, pPos, pState);
        pLevel.getBlockEntity(pPos, FUBlockEntityTypes.CRATE.get()).ifPresent((crateBlockEntity) -> {
            crateBlockEntity.saveToItem(itemstack);
        });
        return itemstack;
    }

    public void appendHoverText(ItemStack text, @javax.annotation.Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(text, pLevel, pTooltip, pFlag);
        CompoundTag compoundtag = BlockItem.getBlockEntityData(text);
        if (compoundtag != null) {
            if (compoundtag.contains("LootTable", 8)) {
                pTooltip.add(Component.literal("???????"));
            }

            if (compoundtag.contains("Items", 9)) {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundtag, nonnulllist);
                int i = 0;
                int j = 0;

                for (ItemStack itemstack : nonnulllist) {
                    if (!itemstack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            MutableComponent mutablecomponent = itemstack.getHoverName().copy();
                            mutablecomponent.append(" x").append(String.valueOf(itemstack.getCount()));
                            pTooltip.add(mutablecomponent);
                        }
                    }
                }

                if (j - i > 0) {
                    pTooltip.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.WHITE));
                }
            }
        }
    }
}
