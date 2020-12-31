package com.almasb.game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class SimpleFactory implements EntityFactory {

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        return FXGL.entityBuilder(data)
                .view("brick.png")
                .with(new ProjectileComponent(new Point2D(1, 0), 150))
                .build();
    }

    @Spawns("ally")
    public Entity newAlly(SpawnData data) {
        var texture = FXGL.texture("brick.png").multiplyColor(Color.GREEN);

        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(-1, 0), 150))
                .build();
    }
}
