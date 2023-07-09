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

public class gameover2 implements Screen, Serializable {
    final tank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private Music music3;
    OrthographicCamera camera;

    public gameover2(final tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("4.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
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
        if(Gdx.input.justTouched()){
            if (Gdx.input.justTouched()) {
                Vector3 touchPos = new Vector3();
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

                if(touchPos.x>455 && touchPos.x<744 && touchPos.y>229 && touchPos.y<300 ){
                    game.setScreen(new Mainmenu(game));
                }

            }
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
    }
}
