package com.almasb.game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class SimpleGameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {

    }

    @Override
    protected void initInput() {
        onKeyDown(KeyCode.F, () -> {
            getNotificationService().pushNotification("Hello world");
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new SimpleFactory());

        run(() -> {
            spawn("ally", FXGLMath.randomPoint(
                    new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );

            spawn("enemy", FXGLMath.randomPoint(
                    new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );
        }, Duration.seconds(1));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
