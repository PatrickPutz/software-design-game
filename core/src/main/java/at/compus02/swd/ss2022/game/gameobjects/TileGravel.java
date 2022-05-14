package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TileGravel extends Tile{

    public TileGravel() {
        image = new Texture("tile_gravel.png");
        sprite = new Sprite(image);
    }

}
