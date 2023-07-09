package com.mygdx.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;

public class dropbox extends Sprite {
    public World world;
    public GameScreen screen;
    public Body b2body;
    private TextureRegion tankstand;
    private Texture tankstand1;

    public dropbox(World world,String x,int x2,int y2){
//        super(screen.getAtlas1().findRegion(x));
        this.world=world;
        BodyDef bdef=new BodyDef();
        bdef.position.set(x2,y2);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(3);
        fdef.shape=shape;
        b2body.createFixture(fdef);
        tankstand1=new Texture(x);
//        tankstand=new TextureRegion(getTexture(),x1,y,width,height);
        setBounds(0,0,16,16);
        setRegion(tankstand1);

    }

    public void setTankstand1(Texture tankstand1) {
        this.tankstand1 = tankstand1;
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/3);
    }


}
