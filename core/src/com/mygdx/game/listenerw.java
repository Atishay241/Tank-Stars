package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.*;

public class listenerw implements ContactListener {
    private static listenerw gen = null;
    public static listenerw getInstance()
    {
        if (gen == null) {
            gen = new listenerw();
        }
        return gen;
    }
    private listenerw(){

    }
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA=contact.getFixtureA();
        if(fixA.getUserData()!=null && tileobject.class.isAssignableFrom(fixA.getUserData().getClass())){

        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private tileobject object1;
}
