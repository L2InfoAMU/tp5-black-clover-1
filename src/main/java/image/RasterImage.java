package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image{
    public int height,width;

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    abstract void createRepresentation();

    abstract void setPixelColor(Color color, int x, int y);

    public void constructor(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public void constructor(Color[][] colors){
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonNull(colors);
        setHeight(Matrices.getColumnCount(colors));
        setWidth(Matrices.getRowCount(colors));
        createRepresentation();
        setPixelsColor(colors);
    }

    public void setPixelsColor(Color[][] pixels){
        for(int i=0; i < this.width; i++){
            for(int j=0; j < this.height; j++){
                setPixelColor(pixels[i][j], i, j);
            }
        }
    }

    public void setPixelsColor(Color color){
        for(int i=0; i < this.width; i++){
            for(int j=0; j < this.height; j++){
                setPixelColor(color, i, j);
            }
        }
    }

}
