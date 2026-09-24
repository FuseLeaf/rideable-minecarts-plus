package org.fuseleaf.rideableminecartsplus.Initializer;

import org.fuseleaf.rideableminecartsplus.ride.Ride;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class Initializer {

    public static void init() {
        Events.init();
    }

    private static class Events {

        private static void init() {
            UseEntityCallback.EVENT.register((player, level, hand, entity, hitResult) -> {
                return Ride.ride(entity, hitResult, player);
            });
        }
    }
}
