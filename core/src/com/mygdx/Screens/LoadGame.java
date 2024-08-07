package com.mygdx.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.Screens.MainMenu;
import com.mygdx.game.MyGdxGame;

public class LoadGame implements Screen {

    final MyGdxGame game;
    OrthographicCamera camera;
    Texture loadScreen;


    public LoadGame(MyGdxGame game){
        this.game = game;

        loadScreen = new Texture("loadScreen.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, loadScreen.getWidth(), loadScreen.getHeight());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);

        game.sb.begin();
        game.sb.draw(loadScreen, 0, 0);
        game.sb.end();

        if (Gdx.input.justTouched()) {
//            System.out.print(Gdx.input.getX());
//            System.out.print("   ");
//            System.out.println(Gdx.input.getY());

            if (Gdx.input.getX() > 1170 && Gdx.input.getX() < 1350
                    && Gdx.input.getY() > 600 && Gdx.input.getY() < 670) {
                game.setScreen(new MainMenu(game));
                dispose();
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
