package org.fuseleaf.rideableminecartsplus.mixin;

import org.fuseleaf.rideableminecartsplus.ride.Ride;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.phys.Vec3;

@Mixin(AbstractMinecart.class)
public class AbstractMinecartMixin {

    @Inject(method = "getPassengerAttachmentPoint", at = @At("RETURN"), cancellable = true)
    private void injectGetPassengerAttachmentPoint(CallbackInfoReturnable<Vec3> cir) {
        AbstractMinecart cart = (AbstractMinecart)(Object)this;
        Vec3 vec3 = cir.getReturnValue();

        if (!(cart instanceof Minecart)) {
            cir.setReturnValue(Ride.adjustPassengerPosition(cart, vec3));
        }
    }
}
