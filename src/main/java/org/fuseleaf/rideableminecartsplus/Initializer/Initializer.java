package org.fuseleaf.rideableminecartsplus.Initializer;

import org.fuseleaf.rideableminecartsplus.ride.Ride;

import net.minecraft.world.InteractionResult;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class Initializer {

    public static void init() {
        Events.init();
    }

    private static class Events {

        public static void init() {
            NeoForge.EVENT_BUS.addListener((PlayerInteractEvent.EntityInteract event) -> {
                InteractionResult result = Ride.ride(
                    event.getTarget(),
                    event.getLocation(),
                    event.getEntity()
                );

                if (result != InteractionResult.PASS) {
                    event.setCancellationResult(result);
                    event.setCanceled(true);
                }
            });
        }
    }
}
