package modelo;

import java.awt.*;

public class Figura {
    protected int  x, y;
    protected Dimension size;
    protected Dimension containerSize;
    protected Image imagen;

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }
    public int estaColisionando(Pelota pelota) {
    Rectangle coliderBloque = new Rectangle(x, y, size.width, size.height);
    Rectangle coliderPelota = new Rectangle(pelota.getX(), pelota.getY(), pelota.getSize().width, pelota.getSize().height);

    if (coliderPelota.intersects(coliderBloque)) {
        // Calculamos las distancias entre los bordes de la pelota y el bloque
        int pelotaDerecha = coliderPelota.x + coliderPelota.width;
        int pelotaIzquierda = coliderPelota.x;
        int pelotaAbajo = coliderPelota.y + coliderPelota.height;
        int pelotaArriba = coliderPelota.y;

        int bloqueDerecha = coliderBloque.x + coliderBloque.width;
        int bloqueIzquierda = coliderBloque.x;
        int bloqueAbajo = coliderBloque.y + coliderBloque.height;
        int bloqueArriba = coliderBloque.y;

        // Calcular las distancias de colisión en cada dirección
        int distanciaDerecha = Math.abs(pelotaDerecha - bloqueIzquierda);
        int distanciaIzquierda = Math.abs(pelotaIzquierda - bloqueDerecha);
        int distanciaArriba = Math.abs(pelotaArriba - bloqueAbajo);
        int distanciaAbajo = Math.abs(pelotaAbajo - bloqueArriba);

        // Determina cuál borde fue alcanzado primero (el que tenga la menor distancia)
        int minDistanciaX = Math.min(distanciaDerecha, distanciaIzquierda);
        int minDistanciaY = Math.min(distanciaArriba, distanciaAbajo);

        // Comparar distancias para determinar si es colisión horizontal (X) o vertical (Y)
        if (minDistanciaX < minDistanciaY) {
            return 2; // Colisión en X (horizontal)
        } else {
            return 1; // Colisión en Y (vertical)
        }
    }
    return 0; // No hubo colisión
}


}
