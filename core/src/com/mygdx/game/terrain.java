package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;

public class terrain extends tileobject{

    public terrain(GameScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
    }

    @Override
    public void onHeadHit(bullet bullet1) {
        Gdx.app.log("collision","terrain");
    }
}
