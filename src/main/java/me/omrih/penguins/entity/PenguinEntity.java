package me.omrih.penguins.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PenguinEntity extends PathAwareEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PenguinEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(10, new WanderAroundFarGoal(this, 0.3d));
    }

    @Override
    public LivingEntity getControllingPassenger() {
        return this.getFirstPassenger() instanceof PlayerEntity playerEntity ? playerEntity : null;
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);
        Vec2f vec2f = new Vec2f(controllingPlayer.getPitch() * 0.5F, controllingPlayer.getYaw());
        this.setRotation(vec2f.y, vec2f.x);
        this.prevYaw = this.bodyYaw = this.headYaw = this.getYaw();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        player.setYaw(this.getYaw());
        player.setPitch(this.getPitch());
        player.startRiding(this);
        return ActionResult.SUCCESS;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(DefaultAnimations.genericWalkIdleController(this));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
