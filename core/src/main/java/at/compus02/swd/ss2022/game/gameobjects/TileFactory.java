package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileFactory {

    public Tile createTile (TileType tileType){
        switch(tileType){
            case GRASS:
                return new TileGrass();
            case GRAVEL:
                return new TileGravel();
            case WALL:
                return new TileWall();
            case WATER:
                return new TileWater();
            default:
                return null;
        }
    }

    public void drawFullBackground(TileType tileType, SpriteBatch batch){

        int posX = -256;
        int posY = -256;

        while(posX != 240 && posY != 240){
            Tile tile = createTile(tileType);
            tile.setPosition(posX, posY);
            tile.draw(batch);

            if(posX != 256){
                posX += 32;
            }
            else if(posX == 256 && posY == 256){
                return;
            }
            else {
                posX = -256;
                posY += 32;
            }
        }
    }

    public void drawSingleTile(TileType tileType, SpriteBatch batch, int positionX, int positionY){
        Tile tile = createTile(tileType);
        tile.setPosition(positionX, positionY);
        tile.draw(batch);
    }
}
