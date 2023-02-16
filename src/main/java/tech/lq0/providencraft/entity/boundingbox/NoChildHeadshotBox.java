package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public class NoChildHeadshotBox<T extends LivingEntity> extends HeadshotBox<T> {
    public NoChildHeadshotBox(double headSize, double headYOffset) {
        super(headSize, headYOffset);
    }

    public NoChildHeadshotBox(double headWidth, double headHeight, double headYOffset) {
        super(headWidth, headHeight, headYOffset);
    }

    @Nullable
    @Override
    public AxisAlignedBB getHeadshotBox(T entity) {
        if(entity.isChild()) return null;
        return super.getHeadshotBox(entity);
    }
}