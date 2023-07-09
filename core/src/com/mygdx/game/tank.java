package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class tank extends Game {

	public SpriteBatch batch;

	public BitmapFont font;
	public static AssetManager manager;
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 200;
	public static final float ppm = 100;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		manager=new AssetManager();
		manager.load("Tank (1).mp3", Music.class);
		manager.load("password-infinity-123276.mp3", Sound.class);
		manager.finishLoading();
		this.setScreen(new first_screen(this));
	}

	public void render() {
		super.render(); // important!
		manager.update();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
		manager.dispose();

	}

}
