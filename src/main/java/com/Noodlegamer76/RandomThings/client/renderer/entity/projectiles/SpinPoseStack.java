package com.Noodlegamer76.RandomThings.client.renderer.entity.projectiles;

import com.Noodlegamer76.RandomThings.Entities.projectiles.LightningBall;
import com.Noodlegamer76.RandomThings.Entities.projectiles.ThrownTntEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.Quaternionf;

public class SpinPoseStack {

    public static void spinPoseStack(ThrownTntEntity entity, PoseStack ps) {
        float rotSpeed = entity.rotSpeed;
        float rotation = entity.rotation;
        spin(rotSpeed, rotation, ps);
    }

    public static void spinPoseStack(LightningBall entity, PoseStack ps) {
        float rotSpeed = entity.rotSpeed;
        float rotation = entity.rotation;
        spin(rotSpeed, rotation, ps);
    }
    public static void spinPoseStack(float rotSpeed, float rotation, PoseStack ps) {
        spin(rotSpeed, rotation, ps);
    }

    public static void spin(float speed, float rotation, PoseStack ps) {
        Quaternionf quaternion = new Quaternionf();
        quaternion.rotateXYZ(rotation * speed, rotation / 2 * speed, rotation / 3 * speed);

        ps.mulPose(quaternion);

    }
}
