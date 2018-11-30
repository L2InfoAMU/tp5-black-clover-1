package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image{
    public int width,height;
    public List<Shape> shapes;

    public VectorImage(List<Shape> shapes, int width, int height){
        setHeight(height);
        setWidth(width);
        this.shapes = shapes;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        for(int i = 0; i<shapes.size(); i++){
            if(shapes.get(i).contains(new Point(x, y)))
                return shapes.get(i).getColor();
        }
        return Color.WHITE;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }
}
