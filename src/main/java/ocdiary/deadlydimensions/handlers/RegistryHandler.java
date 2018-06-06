package ocdiary.deadlydimensions.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ocdiary.deadlydimensions.init.DEBlocks;
import ocdiary.deadlydimensions.init.DEItems;

@Mod.EventBusSubscriber
public class RegistryHandler {

    /**
     * Registering the items
     */
    @SubscribeEvent
    public static void itemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll((DEItems.ITEMS.toArray(new Item[0])));
    }

    /**
     * Registering the blocks
     */
    @SubscribeEvent
    public static void blockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll((DEBlocks.BLOCKS.toArray(new Block[0])));
    }

    @SubscribeEvent
    public static void modelRegister(ModelRegistryEvent event) {
        for(Item item : DEItems.ITEMS)
            if(item instanceof DEModelRegistry)
                ((DEModelRegistry)item).registerModels();

        for(Block block : DEBlocks.BLOCKS)
            if(block instanceof DEModelRegistry)
                ((DEModelRegistry)block).registerModels();
    }
}
