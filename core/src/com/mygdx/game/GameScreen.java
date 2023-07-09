package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen, Serializable {
    tank game;
    private transient OrthographicCamera gamecam;
    private transient Viewport gamePort;
    private transient TextureAtlas atlas;
    private transient TextureAtlas atlas1;
    private transient Hud hud;
    private transient TmxMapLoader maploader;
    private transient TiledMap map;
    private transient dropbox dropbox1;
    private transient bullet bullet1;
    private transient bullet bullet2;

    private transient OrthogonalTiledMapRenderer renderer;
    private transient World world;
    private transient int a;
    private transient movetank tank1;
    private transient movetank tank2;
    private transient Box2DDebugRenderer b2dr;
    private transient int power;
    private transient int angle;
    private transient Sound music7;
    private transient boolean flag=true;
    private transient String dropbox5="icons8-airdrop-64.png";


    private Vector2 box2DToScreen(Vector2 position) {
        // Get the viewport dimensions
        int viewportWidth = Gdx.graphics.getWidth();
        int viewportHeight = Gdx.graphics.getHeight();

        // Get the camera position and zoom level
        Vector3 cameraPosition = gamecam.position;
        float cameraZoom = gamecam.zoom;

        // Convert the position from world coordinates to screen coordinates
        Vector2 screenPosition = new Vector2();
        screenPosition.x = (position.x - cameraPosition.x) * cameraZoom + viewportWidth / 2;
        screenPosition.y = (position.y - cameraPosition.y) * cameraZoom + viewportHeight / 2;

        return screenPosition;
    }
    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);
        tank1.update(dt);
        tank2.update(dt);
        dropbox1.update(dt);
        gamecam.update();
        renderer.setView(gamecam);
    }

    private void handleInput(float dt) {
        if(flag && Hud.getFuel1()!=0){

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank1.b2body.getLinearVelocity().x <= 2)
                tank1.b2body.applyLinearImpulse(new Vector2(10f, 0), tank1.b2body.getWorldCenter(), true);
                tank.manager.get("password-infinity-123276.mp3", Sound.class).play();
            if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                Hud.minusfuel1(10);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                Hud.minusfuel1(10);
            }
            tank.manager.get("password-infinity-123276.mp3", Sound.class).pause();

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1.b2body.getLinearVelocity().x >= -2)
                tank1.b2body.applyLinearImpulse(new Vector2(-10f, 0), tank1.b2body.getWorldCenter(), true);

            if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
                Hud.poweradd();
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                Hud.powerminus();
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
                Hud.angleadd();
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
                Hud.angleminux();
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                bullet1=new bullet(world,this,"Bullet",93,33, (int) tank1.getX()+15, (int) tank1.getY()+30,16,16);
                bullet1.b2body.applyForce(new Vector2(Hud.getPower1(),Hud.getAngle1()),bullet1.b2body.getWorldCenter(),true);
                bullet1.update(dt);
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT)){
                if(tank1.getX()<=dropbox1.getX()+10 && tank1.getX()>=dropbox1.getX()-10){
                    Hud.setScore1(100);
                    world.destroyBody(dropbox1.b2body);
                }
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                if(bullet1.b2body.getLinearVelocity().x==0 && bullet1.b2body.getLinearVelocity().y==0){
                    if((bullet1.getfixture().getBody().getPosition().x<=tank2.getX()+20 && bullet1.getfixture().getBody().getPosition().x>=tank2.getX()-20)){
                        Hud.minushealth2(20);
                    }
                    if((bullet1.getfixture().getBody().getPosition().x<=tank2.getX()+40 && bullet1.getfixture().getBody().getPosition().x>=tank2.getX()-40)){
                        Hud.minushealth2(20);
                    }
                    world.destroyBody(bullet1.b2body);
                }
                if(Hud.getScore1()<=0){
                    game.setScreen(new gameover2(game));
                }
                if(Hud.getScore2()<=0){
                    game.setScreen(new gameover1(game));
                }
                flag=!flag;
            }
            if(Gdx.input.justTouched()){
                game.setScreen(new menuscreen(game));
            }
        }
        else if(!flag && Hud.getFuel2()!=0){
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank2.b2body.getLinearVelocity().x <= 2)
                tank2.b2body.applyLinearImpulse(new Vector2(10f, 0), tank2.b2body.getWorldCenter(), true);

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank2.b2body.getLinearVelocity().x >= -2)
                tank2.b2body.applyLinearImpulse(new Vector2(-20f, 0), tank2.b2body.getWorldCenter(), true);
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
                Hud.poweradd();
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                Hud.powerminus();
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
                Hud.angleadd();
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
                Hud.angleminux();
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                Hud.minusfuel2(10);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                Hud.minusfuel2(10);
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                bullet2=new bullet(world,this,"Bullet",90,33, (int) tank2.getX()+10, (int) tank2.getY()+30,16,16);
                bullet2.b2body.applyForce(new Vector2(-(Hud.getPower1()),Hud.getAngle1()),bullet2.b2body.getWorldCenter(),true);
                bullet2.update(dt);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT)){
                if(tank2.getX()<=a+10 && tank2.getX()>=a-10){
                    Hud.setScore2(100);
                    world.destroyBody(dropbox1.b2body);
                }
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                if(bullet2.b2body.getLinearVelocity().x==0 && bullet2.b2body.getLinearVelocity().y==0){
                    if((bullet2.getfixture().getBody().getPosition().x<=tank1.getX()+20 && bullet2.getfixture().getBody().getPosition().x>=tank1.getX()-20)){
                        Hud.minushealth1(20);
                    }
                    if((bullet2.getfixture().getBody().getPosition().x<=tank1.getX()+27 && bullet2.getfixture().getBody().getPosition().x>=tank1.getX()-27)){
                        Hud.minushealth1(20);
                    }
                    world.destroyBody(bullet2.b2body);
                }

                if(Hud.getScore1()<=0){
                    game.setScreen(new gameover2(game));
                }
                if(Hud.getScore2()<=0){
                    game.setScreen(new gameover1(game));
                }

                flag=!flag;
            }

        }

    }


    public GameScreen(final tank game,String selectank1,String selecttank2) {
        atlas=new TextureAtlas("bullet.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(tank.V_WIDTH, tank.V_HEIGHT, gamecam);
        gamePort.apply();
        hud = new Hud(game.batch);
        maploader = new TmxMapLoader();
        map = maploader.load("level2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(tank.V_WIDTH / 2, tank.V_HEIGHT / 2, 0);
        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();
        tank1=new movetank(world,selectank1,1,1,48,100,64,64);
        a=getRandomNumber(1,380);
        int b=getRandomNumber(100,190);
        dropbox1=new dropbox(world,dropbox5,a,b);

        tank2=new movetank(world,selecttank2,67,49,330,100,64,64);
        //singleton design pattern
        listenerw l1=listenerw.getInstance();
        world.setContactListener(l1);
        //iterator design pattern
//        Iterator it=
        for(PolylineMapObject obj :map.getLayers().get(2).getObjects().getByType(PolylineMapObject.class)){
            Shape shape;
            shape = createPolyLine(obj);
            Body body;
            BodyDef bdef = new BodyDef();
            bdef.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(bdef);
            body.createFixture(shape, 1.0f);
            shape.dispose();
        }
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(game);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, IOException {
        in.defaultReadObject();
        game=(tank) in.readObject();
    }

    static Vector2[] worldVertices ;
    static ArrayList<Integer> worldVertices1 =new ArrayList<>();
    private static ChainShape createPolyLine(PolylineMapObject polyline){
        float[] vertices = polyline.getPolyline().getTransformedVertices();
        worldVertices1.add(5);
        worldVertices=new Vector2[vertices.length/2];
        Iterator<Integer> it= worldVertices1.iterator();
        while(it.hasNext()){
            int j=it.next();
        }
        for(int i=0; i<worldVertices.length; i++){
            worldVertices[i] = new Vector2(vertices[i*2], vertices[i*2 + 1]);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(worldVertices);
        return cs;
    }
    public TiledMap getMap(){
        return map;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Override
    public void show() {

    }

    public TextureAtlas getAtlas() {
        return atlas;
    }
    public TextureAtlas getAtlas1(){
        return atlas1;
    }

    public World getWorld(){
        return world;
    }

    @Override
    public void render(float delta) {

        update(delta);
        renderer.render();
        b2dr.render(world,gamecam.combined);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        game.batch.begin();

        tank1.draw(game.batch);
        tank2.draw(game.batch);
        dropbox1.draw(game.batch);

        game.batch.end();
        hud.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
