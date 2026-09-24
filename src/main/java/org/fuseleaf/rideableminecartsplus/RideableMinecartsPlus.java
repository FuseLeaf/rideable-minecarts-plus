package org.fuseleaf.rideableminecartsplus;

import org.fuseleaf.rideableminecartsplus.Initializer.Initializer;

import net.fabricmc.api.ModInitializer;

public class RideableMinecartsPlus implements ModInitializer {

    @Override
    public void onInitialize() {
        Initializer.init();
    }
}
