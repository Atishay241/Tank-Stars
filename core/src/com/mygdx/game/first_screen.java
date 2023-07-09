package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;

public class first_screen implements Screen, Serializable {
    final tank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private Music music1;
    OrthographicCamera camera;
    public first_screen(final tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("first_screen.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        music1=tank.manager.get("Tank (1).mp3", Music.class);
//        music1.setLooping(true);
        music1.play();
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
            game.setScreen(new Mainmenu(game));
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
        music1.dispose();
    }
}
