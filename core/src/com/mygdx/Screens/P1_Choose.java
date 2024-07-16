package com.mygdx.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.Screens.MainMenu;
import com.mygdx.game.MyGdxGame;

public class P1_Choose implements Screen {

    final MyGdxGame game;
    OrthographicCamera camera;
    Texture P1Choose;

    public P1_Choose(MyGdxGame game) {
        this.game = game;

        P1Choose = new Texture("P1Choose.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, P1Choose.getWidth(), P1Choose.getHeight());
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
        game.sb.draw(P1Choose, 0, 0);
        game.sb.end();

        if (Gdx.input.justTouched()) {

//            System.out.print(Gdx.input.getX());
//            System.out.print("   ");
//            System.out.println(Gdx.input.getY());

            if (Gdx.input.getX() > 85 && Gdx.input.getX() < 410
                    && Gdx.input.getY() > 270 && Gdx.input.getY() < 560) {
                game.setScreen(new P2_Choose(game));
                dispose();
            }
            else if (Gdx.input.getX() > 540 && Gdx.input.getX() < 860
                    && Gdx.input.getY() > 270 && Gdx.input.getY() < 560) {
                game.setScreen(new P2_Choose(game));
                dispose();
            }
            else if(Gdx.input.getX() > 990 && Gdx.input.getX() < 1310
                    && Gdx.input.getY() > 270 && Gdx.input.getY() < 560){
                game.setScreen(new P2_Choose(game));
                dispose();
            }
            else if(Gdx.input.getX() > 1180 && Gdx.input.getX() < 1345
                    && Gdx.input.getY() > 600 && Gdx.input.getY() < 670){
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
