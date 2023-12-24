package net.endil.farmersutils.common.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.endil.farmersutils.common.registry.FURecipeSerializers;
import net.endil.farmersutils.common.registry.FURecipeTypes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DryingRecipe implements Recipe<Container> {
    protected final ResourceLocation id;
    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final int dryingTime;

    public DryingRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result, int dryingTime) {
        this.id = id;
        this.ingredient = ingredient;
        this.result = result;
        this.dryingTime = dryingTime;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.ingredient.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FURecipeSerializers.DRYING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return FURecipeTypes.DRYING.get();
    }

    public int getDryingTime() {
        return this.dryingTime;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(FUBlocks.DRYING_RACK.get());
    }

    public static class Serializer implements RecipeSerializer<DryingRecipe> {
        public Serializer() {
        }

        @Override
        public DryingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement, false);

            int dryingTime = GsonHelper.getAsInt(json, "dryingtime");
            return new DryingRecipe(id, ingredient, result, dryingTime);
        }

        @Override
        public @Nullable DryingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf pBuffer) {
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack result = pBuffer.readItem();
            int dryingTime = pBuffer.readVarInt();
            return new DryingRecipe(id, ingredient, result, dryingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, DryingRecipe pRecipe) {
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
            pBuffer.writeVarInt(pRecipe.dryingTime);
        }
    }
}
