package modelo;

import java.awt.*;

public class Barra extends Figura{

    public Barra(int x, int y, int ancho, int alto, Dimension containerSize) {
        this.x = x;
        this.y = y;
        this.size = new Dimension(ancho, alto);
        this.containerSize = containerSize;
    }

    public void mover(int nuevaX) {
        //System.out.println("Nueva pos: "+ (containerSize.getWidth() - size.getWidth()));
        if (nuevaX < 0) {
            x = 0;
        } else if (nuevaX + size.getWidth() > containerSize.getWidth()) {
            x = (int) (containerSize.getWidth() - size.getWidth());
        } else {
            x = nuevaX;
        }
    }
}
