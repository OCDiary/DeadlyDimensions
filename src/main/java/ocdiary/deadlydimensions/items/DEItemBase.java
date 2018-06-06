package ocdiary.deadlydimensions.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ocdiary.deadlydimensions.DeadlyDimensions;
import ocdiary.deadlydimensions.handlers.DEModelRegistry;
import ocdiary.deadlydimensions.init.DEItems;

public class DEItemBase extends Item implements DEModelRegistry {

    public DEItemBase(String name){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MISC);


        DEItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        DeadlyDimensions.proxy.registerItemRenderer(this, 0, "inventory");
    }
}