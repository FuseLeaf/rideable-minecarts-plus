package org.fuseleaf.rideableminecartsplus;

import org.fuseleaf.rideableminecartsplus.Initializer.Initializer;

import net.fabricmc.api.ModInitializer;

public class RideableMinecartsPlus implements ModInitializer {

    public static final String MOD_ID = "rideable-minecarts-plus";

    @Override
    public void onInitialize() {
        Initializer.init();
    }
}
