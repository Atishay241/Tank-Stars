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

public class selection_tanks implements Screen, Serializable {
    final tank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    private Music music4;
    public String tank_selection;
    public selection_tanks(final tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("selecttans.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        music4=tank.manager.get("Tank (1).mp3", Music.class);
//        music4.setLooping(true);
        music4.play();
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void show() {

    }

    public String getTank_selection() {
        return tank_selection;
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
            //factory design pattern
            if(touchPos.x>89 && touchPos.x<365 && touchPos.y>285 && touchPos.y<457){
                tank_selection="tank2.png";
                game.setScreen((new selection_tanks1(game,tank_selection)));
            //factory design pattern
            }
            if(touchPos.x>465 && touchPos.x<735 && touchPos.y>285 && touchPos.y<457){
                tank_selection="tank3.png";
                game.setScreen((new selection_tanks1(game,tank_selection)));


            }
            if(touchPos.x>842 && touchPos.x<1120 && touchPos.y>285 && touchPos.y<457){
                tank_selection="tank1.png";
                game.setScreen((new selection_tanks1(game,tank_selection)));

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
        music4.dispose();
    }
}
