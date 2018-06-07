package ocdiary.deadlydimensions.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ocdiary.deadlydimensions.blocks.DEClock;

import java.util.ArrayList;
import java.util.List;

public class DEBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static Block DE_CLOCK = new DEClock("de_clock", Material.IRON);
}
