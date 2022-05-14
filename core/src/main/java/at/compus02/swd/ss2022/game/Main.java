package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Sign;
import at.compus02.swd.ss2022.game.gameobjects.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.TileType;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		gameObjects.add(new Sign());
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}
	TileFactory tileFactory = new TileFactory();

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}
		font.draw(batch, "Hello Game", -220, -220);
		tileFactory.drawFullBackground(TileType.GRASS, batch);
		tileFactory.drawSingleTile(TileType.WATER, batch, 0, 0);
		tileFactory.drawSingleTile(TileType.WATER, batch, 32, 0);
		tileFactory.drawSingleTile(TileType.WATER, batch, 0, 32);
		tileFactory.drawSingleTile(TileType.WATER, batch, 32, 32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 64, 64);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 64, 32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 64, 0);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 64, -32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 32, 64);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 0, 64);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, -32, 64);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, -32, 32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, -32, 0);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, -32, -32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 0, -32);
		tileFactory.drawSingleTile(TileType.GRAVEL, batch, 32, -32);
		batch.end();
	}



	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}