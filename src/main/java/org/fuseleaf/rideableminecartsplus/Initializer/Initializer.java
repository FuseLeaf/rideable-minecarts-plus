package org.fuseleaf.rideableminecartsplus.Initializer;

import org.fuseleaf.rideableminecartsplus.ride.Ride;

import net.minecraft.world.InteractionResult;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Initializer {

    public static void init() {
        Events.init();
    }

    private static class Events {

        private static void init() {
            MinecraftForge.EVENT_BUS.addListener(
                (PlayerInteractEvent.EntityInteractSpecific event) -> {
                    InteractionResult result = Ride.ride(
                        event.getTarget(),
                        event.getLocalPos(),
                        event.getEntity()
                    );

                    if (result != InteractionResult.PASS) {
                        event.setCancellationResult(result);
                        event.setCanceled(true);
                    }
                }
            );
        }
    }
}
