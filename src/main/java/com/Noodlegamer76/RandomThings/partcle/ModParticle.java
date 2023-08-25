package com.Noodlegamer76.RandomThings.partcle;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.partcle.custom.ConfettiParticles;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModParticle {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, RandomThingsMod.MODID);

    public static final RegistryObject<SimpleParticleType> CONFETTI =
            PARTICLE_TYPES.register("confetti_particles", () -> new SimpleParticleType(true));
}
