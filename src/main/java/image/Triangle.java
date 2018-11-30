package image;

import javafx.scene.paint.Color;

public class Triangle implements Shape{
    public Point A,B,C;
    public Color color;

    public Triangle(Point A, Point B, Point C, Color color){
        this.A = A;
        this.B = B;
        this.C = C;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        Point p = point;
        int AMB = ((A.x - p.x) * (B.y - p.y)) - ((A.y - p.y) * (B.x - p.x)) ;
        int BMC = ((B.x - p.x) * (C.y - p.y)) - ((B.y - p.y) * (C.x - p.x));
        int CMA = ((C.x - p.x) * (A.y - p.y)) - ((C.y - p.y) * (A.x - p.x));
        if((AMB >= 0 && BMC >= 0 && CMA >= 0) || (AMB < 0 && BMC < 0 && CMA < 0))
            return true;
        return false;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
