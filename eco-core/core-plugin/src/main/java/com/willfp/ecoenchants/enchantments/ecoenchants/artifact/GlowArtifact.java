package com.willfp.ecoenchants.enchantments.ecoenchants.artifact;

import com.willfp.eco.core.Prerequisite;
import com.willfp.ecoenchants.enchantments.itemtypes.Artifact;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

public class GlowArtifact extends Artifact {
    public GlowArtifact() {
        super(
                "glow_artifact",
                Prerequisite.v1_17
        );
    }

    @Override
    public @NotNull Particle getParticle() {
        return Particle.GLOW;
    }
}
