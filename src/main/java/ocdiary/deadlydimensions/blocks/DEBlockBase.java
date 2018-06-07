package ocdiary.deadlydimensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ocdiary.deadlydimensions.handlers.DEModelRegistry;

public class DEBlockBase extends Block implements DEModelRegistry {
    public DEBlockBase(String name, Material materialIn) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }

    @Override
    public void registerModels() {

    }
}
