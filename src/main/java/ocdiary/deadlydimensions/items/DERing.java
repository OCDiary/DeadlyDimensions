package ocdiary.deadlydimensions.items;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DERing extends DEItemBase {
    public DERing(String name) {
        super(name);
        this.setMaxDamage(5);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        ItemStack stack1 = new ItemStack(this);
        if (((EntityPlayer) entityIn).inventory.hasItemStack(stack1)) {
            if (!worldIn.isRemote) {
                if (worldIn.getWorldTime() > 450 && worldIn.getWorldTime() < 12000) {
                    worldIn.setWorldTime(13000);
                    stack1.setItemDamage(1);
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("This special ring will keep you safe in the Overworld by making it always night time!");
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add("Uses left: ");
        }
        if (!GuiScreen.isShiftKeyDown())
            tooltip.add(TextFormatting.AQUA + I18n.format("press.for.info.name", "SHIFT"));
    }
}
