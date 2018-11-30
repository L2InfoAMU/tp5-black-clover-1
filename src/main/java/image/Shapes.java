package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Shapes implements ImageFactory{
    @Override
    public Image makeImage() {
        List<Shape> list = new ArrayList<>();
        list.add(new Cercle(50, 100, 50, Color.RED));
        list.add(new Cercle(150, 100, 50, Color.ORANGE));
        list.add(new Rectangle(0,0, 200, 50, Color.AQUA));
        list.add(new Rectangle(201,0, 200, 50, Color.BLUE));

        return new VectorImage(list, 600, 300);
    }
}
