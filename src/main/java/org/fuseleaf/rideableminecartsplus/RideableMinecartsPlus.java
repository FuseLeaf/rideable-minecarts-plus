package org.fuseleaf.rideableminecartsplus;

import org.fuseleaf.rideableminecartsplus.Initializer.Initializer;

import net.neoforged.fml.common.Mod;

@Mod(RideableMinecartsPlus.MOD_ID)
public class RideableMinecartsPlus {

    public static final String MOD_ID = "rideable_minecarts_plus";

    public RideableMinecartsPlus() {
        Initializer.init();
    }
}
