package modelo;

import java.awt.*;

public class Bloque extends Figura{
    
    public Dureza dureza;
    
    public Bloque(int x, int y, int ancho, int alto, Dimension containerSize) {
        this.x = x;
        this.y = y;
        this.size = new Dimension(ancho, alto);
        this.containerSize = containerSize;
    }
    // return 0 -> no colisiono 1-> colision en x  2 -> colision en y
}

