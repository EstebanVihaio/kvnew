package com.adruijter.kingsvalley1.screens;

import java.io.IOException;

import com.adruijter.kingsvalley1.KingsValley1;
import com.adruijter.kingsvalley1.level.Level;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

	//Fields
	private KingsValley1 game;
	private Level level;
	private OrthographicCamera cam;
	private float width, height;
	
	//Constructor
	public GameScreen(KingsValley1 game) {
		this.game = game;
		this.width = Gdx.graphics.getWidth();
		this.height = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera(); 
		cam.setToOrtho(true, width, height);
		cam.update();
		this.game.getBatch().setProjectionMatrix(cam.combined);	
	}

	
	@Override
	public void render(float delta) {
		//Gdx.app.log("test", "I was here");
		this.level.Update(delta);
		
		cam.position.set(280f, 250f, 0);
		cam.update();
		this.game.getBatch().setProjectionMatrix(cam.combined);	
		this.game.getBatch().begin();
		this.level.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		try {
			this.level = new Level(this.game, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
