package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image{
    private List<Color> palette;
    private int[][] indexesOfColors;
    private int width, height;

    public PaletteRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        Matrices.requiresNonNull(pixels);
        setHeight(Matrices.getColumnCount(pixels));
        setWidth(Matrices.getRowCount(pixels));
        createRepresentation();
        setPixelsColor(pixels);
    }

    public void createRepresentation(){
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y){
        if(!this.palette.contains(color))
            this.palette.add(color);
        this.indexesOfColors[x][y]=this.palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y){
        return this.palette.get(this.indexesOfColors[x][y]);
    }

    private void setPixelsColor(Color[][] pixels){
        for(int i=0; i < this.width; i++){
            for(int j=0; j < this.height; j++){
                setPixelColor(pixels[i][j], i, j);
            }
        }
    }

    private void setPixelsColor(Color color){
        for(int i=0; i < this.width; i++){
            for(int j=0; j < this.height; j++){
                setPixelColor(color, i, j);
            }
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
