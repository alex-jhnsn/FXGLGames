package com.almasb.fxglgames.td.collision;

import com.almasb.fxgl.annotation.AddCollisionHandler;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.ecs.Entity;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxglgames.td.TowerDefenseType;
import com.almasb.fxglgames.td.event.EnemyKilledEvent;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
@AddCollisionHandler
public class BulletEnemyHandler extends CollisionHandler {

    public BulletEnemyHandler() {
        super(TowerDefenseType.BULLET, TowerDefenseType.ENEMY);
    }

    @Override
    protected void onCollisionBegin(Entity bullet, Entity enemy) {

        bullet.removeFromWorld();

        // TODO: add HP/Damage system
        FXGL.getEventBus().fireEvent(new EnemyKilledEvent((GameEntity) enemy));
        enemy.removeFromWorld();
    }
}
