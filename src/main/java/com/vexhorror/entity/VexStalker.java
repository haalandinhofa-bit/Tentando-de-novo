package com.vexhorror.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class VexStalker extends Zombie {
    public VexStalker(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
        this.setCanBreakDoors(true);
        this.xpReward = 18;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH, 70.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.34D)
                .add(Attributes.ATTACK_DAMAGE, 9.0D)
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D);
    }
}
