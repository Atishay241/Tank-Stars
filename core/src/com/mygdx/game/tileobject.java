package com.mygdx.game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.physics.box2d.*;

public abstract class tileobject  {
    protected World world;
    protected TiledMap map;
    protected Polyline bounds;
    protected Body body;
    protected GameScreen screen;
    protected MapObject object;

    protected Fixture fixture;

    public tileobject(GameScreen screen, MapObject object){
        this.object = object;
        this.screen = screen;
        this.world = screen.getWorld();
        this.map = screen.getMap();
        this.bounds = ((PolylineMapObject) object).getPolyline();

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getLength()) , (bounds.getY() + bounds.getLength() / 2));

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getLength()/ 2 , bounds.getLength() / 2 );
        fdef.shape = shape;
        fixture = body.createFixture(fdef);

    }

    public abstract void onHeadHit(bullet bullet1);
}