package org.fuseleaf.rideableminecartsplus.ride;

import org.jspecify.annotations.NonNull;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.Minecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartHopper;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Ride {

    public static @NonNull InteractionResult ride(Entity entity, Vec3 hitLocation, Player player) {
        if (entity instanceof AbstractMinecart && !(entity instanceof Minecart)) {
            AABB aabb = entity.getBoundingBox();
            double rideY = aabb.minY + (aabb.maxY - aabb.minY) * 0.9;
            double hitY = entity.getY() + hitLocation.y;

            if (hitY < rideY) {
                player.startRiding(entity, true, true);

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static Vec3 adjustPassengerPosition(AbstractMinecart cart, Vec3 vec3) {
        if (cart instanceof MinecartHopper) {
            return vec3.add(0.0, 0.6, 0.0);
        } else {
            return vec3.add(0.0, 0.8, 0.0);
        }
    }
}
