package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public class HeadshotBox<T extends LivingEntity> implements IHeadBox<T> {
    protected double headWidth;
    protected double headHeight;
    protected double headYOffset;

    public HeadshotBox(double headSize, double headYOffset) {
        this.headWidth = headSize;
        this.headHeight = headSize;
        this.headYOffset = headYOffset;
    }

    public HeadshotBox(double headWidth, double headHeight, double headYOffset) {
        this.headWidth = headWidth;
        this.headHeight = headHeight;
        this.headYOffset = headYOffset;
    }

    @Nullable
    @Override
    public AxisAlignedBB getHeadshotBox(T entity) {
        double halfWidth = this.headWidth / 2.0;
        AxisAlignedBB headBox = new AxisAlignedBB(-halfWidth * 0.0625, 0, -halfWidth * 0.0625, halfWidth * 0.0625, this.headHeight * 0.0625, halfWidth * 0.0625);
        headBox = headBox.offset(0, this.headYOffset * 0.0625, 0);
        return headBox;
    }
}
