package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage{
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height){
        constructor(color, width, height);
    }

    public PaletteRasterImage(Color[][] colors){
        constructor(colors);
    }

    @Override
    public void createRepresentation(){
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[this.width][this.height];
    }

    @Override
    public void setPixelColor(Color color, int x, int y){
        if(!this.palette.contains(color))
            this.palette.add(color);
        this.indexesOfColors[x][y]=this.palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y){
        return this.palette.get(this.indexesOfColors[x][y]);
    }




}
