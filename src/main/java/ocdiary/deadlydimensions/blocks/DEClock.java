package ocdiary.deadlydimensions.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import ocdiary.deadlydimensions.DeadlyDimensions;
import ocdiary.deadlydimensions.blocks.tiles.TileDEClock;
import ocdiary.deadlydimensions.handlers.DEModelRegistry;
import ocdiary.deadlydimensions.init.DEBlocks;
import ocdiary.deadlydimensions.init.DEItems;

import javax.annotation.Nullable;

public class DEClock extends BlockContainer implements DEModelRegistry {
    public DEClock(String name, Material materialIn) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);

        DEBlocks.BLOCKS.add(this);
        DEItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileDEClock();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void registerModels() {
        DeadlyDimensions.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}