package org.fuseleaf.rideableminecartsplus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.Minecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartHopper;
import net.minecraft.world.phys.Vec3;

@Mixin(AbstractMinecart.class)
public class AbstractMinecartMixin {

    @Inject(method = "isRideable", at = @At("TAIL"), cancellable = true)
    public void injectIsRideable(CallbackInfoReturnable<Boolean> cir) {
        if (!((AbstractMinecart)(Object)this instanceof Minecart)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getPassengerAttachmentPoint", at = @At("RETURN"), cancellable = true)
    private void injectGetPassengerAttachmentPoint(CallbackInfoReturnable<Vec3> cir) {
        AbstractMinecart cart = (AbstractMinecart)(Object)this;
        Vec3 vec3 = cir.getReturnValue();

        if (!(cart instanceof Minecart)) {

            if (cart instanceof MinecartHopper) {
                cir.setReturnValue(vec3.add(0.0, 0.6, 0.0));
            } else {
                cir.setReturnValue(vec3.add(0.0, 0.8, 0.0));
            }
        }
    }
}
