package image;

import javafx.scene.paint.Color;

public class Cercle implements Shape{
    public Color color;
    public int rayon;
    Point centre;

    public Cercle(int x, int y, int rayon, Color color){
        this.centre = new Point(x,y);
        this.color = color;
        this.rayon = rayon;
    }

    @Override
    public boolean contains(Point point){
        Point p = point;
        Point c = this.centre;
        int distancecarre = ((p.x - c.x) * (p.x - c.x)) + ((p.y - c.y) * (p.y - c.y));
        if(distancecarre <= this.rayon * this.rayon)
            return true;
        return false;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
