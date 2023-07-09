package com.mygdx.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class bullet extends Sprite {
    public World world;
    public GameScreen screen;
    public Body b2body;
    private TextureRegion tankstand;
    private Fixture fixture1;

    public bullet(World world,GameScreen screen,String x,int x1,int y,int x2,int y2,int width,int height){
        super(screen.getAtlas().findRegion(x));
        this.world=world;
        defineTank(x2,y2);
        tankstand=new TextureRegion(getTexture(),x1,y,width,height);
        setBounds(x1,y,width,height);
        setRegion(tankstand);

    }
    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()*2/5);
    }
    public void defineTank(int x2,int y2){

        BodyDef bdef=new BodyDef();
        bdef.position.set(x2,y2);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5);
        fdef.shape=shape;
        fixture1=b2body.createFixture(fdef);

    }
    public Fixture getfixture(){
        return fixture1;
    }


}
