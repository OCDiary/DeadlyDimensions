package ocdiary.deadlydimensions.blocks.tiles;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileDEClock extends TileEntity implements ITickable {
    @Override
    public void update() {
        if(!world.isRemote){
            world.getMinecraftServer().worlds[0].getWorldTime();
        }
    }
}
