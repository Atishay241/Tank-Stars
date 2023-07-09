package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;

public class selection_tanks1 implements Screen, Serializable {
    final tank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private String reversetankselect;
    private String tankselection1;
    private Music music5;
    OrthographicCamera camera;
    public selection_tanks1(final tank game,String tank_select) {
        this.game = game;
        this.tankselection1=tank_select;
        backgroundImage = new Texture(Gdx.files.internal("selecttanks1.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        music5=tank.manager.get("Tank (1).mp3", Music.class);
//        music5.setLooping(true);
        music5.play();
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 1920, 1080);
        game.batch.end();
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            System.out.println(touchPos.x);
//            System.out.println(touchPos.y);
            if(touchPos.x>89 && touchPos.x<365 && touchPos.y>285 && touchPos.y<457){
                reversetankselect="tank2reverse.png";
                game.setScreen((new GameScreen(game,tankselection1,reversetankselect)));

            }
            if(touchPos.x>465 && touchPos.x<735 && touchPos.y>285 && touchPos.y<457){
                reversetankselect="tank3reverse.png";
                game.setScreen((new GameScreen(game,tankselection1,reversetankselect)));

            }
            if(touchPos.x>840 && touchPos.x<1120 && touchPos.y>285 && touchPos.y<457){
                reversetankselect="tank1reverse.png";
                game.setScreen((new GameScreen(game,tankselection1,reversetankselect)));

            }

            if(touchPos.x>10 && touchPos.x<185 && touchPos.y>15 && touchPos.y<80){
                game.setScreen(new Mainmenu(game));
            }
//            if(touchPos.x)
//            game.setScreen(new Mainmenu(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    public String getReversetankselect() {
        return reversetankselect;
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
        music5.dispose();
    }
}
