package image;

import util.Matrices;
import javafx.scene.paint.Color;



public class BruteRasterImage extends RasterImage {
    public Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        constructor(color, width, height);
    }

    public BruteRasterImage(Color[][] colors){
        constructor(colors);
    }

    @Override
    public void createRepresentation(){
        this.pixels = new Color[this.width][this.height];
    }

    @Override
    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixels[x][y];
    }

}
