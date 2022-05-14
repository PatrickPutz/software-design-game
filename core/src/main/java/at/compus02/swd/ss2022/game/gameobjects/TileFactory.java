package at.compus02.swd.ss2022.game.gameobjects;

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

}
