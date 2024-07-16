package com.mygdx.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.Screens.FirstScreen;
import com.mygdx.game.MyGdxGame;

import static java.lang.System.exit;

public class MainMenu implements Screen {

    final MyGdxGame game;
    OrthographicCamera camera;
    Texture mainMenuScreen;


    public MainMenu(MyGdxGame game){
        this.game = game;

        mainMenuScreen = new Texture("mainMenuScreen.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, mainMenuScreen.getWidth(), mainMenuScreen.getHeight());
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
        game.sb.draw(mainMenuScreen, 0, 0);
        game.sb.end();


        if (Gdx.input.justTouched()) {

//            System.out.print(Gdx.input.getX());
//            System.out.print("   ");
//            System.out.println(Gdx.input.getY());

            if(Gdx.input.getX() > 475 && Gdx.input.getX() < 925
                    && Gdx.input.getY() > 375 && Gdx.input.getY() < 465){
                game.setScreen(new P1_Choose(game));
                dispose();
            }
            else if(Gdx.input.getX() > 3 && Gdx.input.getX() < 155
                    && Gdx.input.getY() > 3 && Gdx.input.getY() < 75){
                game.setScreen(new FirstScreen(game));
                dispose();
            }
            else if(Gdx.input.getX() > 475 && Gdx.input.getX() < 925
                    && Gdx.input.getY() > 480 && Gdx.input.getY() < 580){
                game.setScreen(new LoadGame(game));
                dispose();
            }
            else if(Gdx.input.getX() > 475 && Gdx.input.getX() < 925
                    && Gdx.input.getY() > 595 && Gdx.input.getY() < 690){
                dispose();
                exit(0);

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
