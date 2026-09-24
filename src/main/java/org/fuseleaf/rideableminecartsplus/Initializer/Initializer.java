package org.fuseleaf.rideableminecartsplus.Initializer;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.Minecart;
import net.minecraft.world.phys.AABB;

public class Initializer {

    public static void init() {
        Events.init();
    }

    private static class Events {

        private static void init() {
            UseEntityCallback.EVENT.register((player, level, hand, entity, hitResult) -> {
                if (entity instanceof AbstractMinecart && !(entity instanceof Minecart)) {
                    AABB aabb = entity.getBoundingBox();
                    double rideY = aabb.minY + (aabb.maxY - aabb.minY) * 0.9;
                    double hitY = hitResult.getLocation().y;

                    if (hitY < rideY) {
                        player.startRiding(entity, true, true);

                        return InteractionResult.SUCCESS;
                    }
                }

                return InteractionResult.PASS;
            });
        }
    }
}
