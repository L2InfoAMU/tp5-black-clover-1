package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage{
    public Map<Point,Color> map;

    public SparseRasterImage(Color color, int width, int height){
        constructor(color, width, height);
    }

    public SparseRasterImage(Color[][] colors){
        constructor(colors);
    }

    @Override
    public void createRepresentation(){
        this.map = new HashMap<>();
    }

    @Override
    public void setPixelColor(Color color, int x, int y){
        map.put(new Point(x, y), color);
    }

    @Override
    public Color getPixelColor(int x, int y){
        return map.getOrDefault(new Point(x, y), Color.WHITE);
    }

}
