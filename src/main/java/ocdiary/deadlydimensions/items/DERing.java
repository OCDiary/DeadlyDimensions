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
        this.setMaxDamage(2);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof EntityPlayer){
            if (worldIn.getWorldTime() > 450 && worldIn.getWorldTime() < 12000) {
                worldIn.setWorldTime(13000);
                stack.damageItem(1, (EntityPlayer)entityIn);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("This special ring will keep you safe in the Overworld by making it always night time!");
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add("Uses left: " + (stack.getMaxDamage() - stack.getItemDamage() + 1));
        }
        if (!GuiScreen.isShiftKeyDown())
            tooltip.add(TextFormatting.AQUA + I18n.format("press.for.info.name", "SHIFT"));
    }
}
