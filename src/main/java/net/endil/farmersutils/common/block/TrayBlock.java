package net.endil.farmersutils.common.block;

import net.endil.farmersutils.common.block.entity.CrateBlockEntity;
import net.endil.farmersutils.common.block.entity.TrayBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TrayBlock extends BaseEntityBlock {
    private static final VoxelShape BOTTOM = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 1.0F, 15.0F);
    private static final VoxelShape NORTH = Block.box(1.0F, 1.0F, 1.0F, 15.0F, 2.0F, 2.0F);
    private static final VoxelShape SOUTH = Block.box(1.0F, 1.0F, 14.0F, 15.0F, 2.0F, 15.0F);
    private static final VoxelShape EAST = Block.box(14.0F, 1.0F, 2.0F, 15.0F, 2.0F, 14.0F);
    private static final VoxelShape WEST = Block.box(1.0F, 1.0F, 2.0F, 2.0F, 2.0F, 14.0F);
    private static final VoxelShape SHAPE = Shapes.or(BOTTOM, NORTH, SOUTH, EAST ,WEST);

    public TrayBlock(Properties pProperties) {
        super(pProperties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TrayBlockEntity(pPos, pState);
    }
}
