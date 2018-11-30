package image;

import util.Matrices;
import javafx.scene.paint.Color;



public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width, height;

    public BruteRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonNull(colors);
        setHeight(Matrices.getColumnCount(colors));
        setWidth(Matrices.getRowCount(colors));
        createRepresentation();
        setPixelsColor(colors);
    }

    public void createRepresentation(){
        this.pixels = new Color[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixels[x][y];
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
