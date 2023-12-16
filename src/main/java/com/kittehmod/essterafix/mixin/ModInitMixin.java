package com.kittehmod.essterafix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;

import elocindev.teraphobia.forge.Teraphobia;

@Mixin(Teraphobia.class)
public class ModInitMixin
{
	
	@Inject(method = "setup(Lnet/minecraftforge/fml/event/lifecycle/FMLCommonSetupEvent;)V", at = @At(value = "INVOKE", target = "Lelocindev/teraphobia/forge/registry/PacketRegistry;register()V", shift = Shift.AFTER), cancellable = true, remap = false)
	private void injectInit(CallbackInfo ci) {
		ci.cancel();
	}
}
