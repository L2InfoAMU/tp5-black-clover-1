package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape{
    public Color color;
    public int x,y,width,height;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean contains(Point point){
        int x =point.x;
        int y =point.y;
        if((x>=this.x && x<this.x+this.width) && (y>=this.y && y<this.y+this.height))
            return true;
        return false;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
