package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TileWall extends Tile{

    public TileWall() {
        image = new Texture("tile_gras.png");
        sprite = new Sprite(image);
    }

}
