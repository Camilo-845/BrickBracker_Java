package modelo;

import java.awt.*;

public class Pelota extends FiguraMovil{

    private final int velocidadMaximaX;
    private final int velocidadMaximaY;

    public Pelota(int x, int y, int radio, int velocidadX, int velocidadY, int
            anchoPanel, int altoPanel, Image imagen) {
        this.x = x;
        this.y = y;
        this.size = new Dimension(radio * 2, radio * 2);
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.containerSize = new Dimension(anchoPanel, altoPanel);
        this.imagen = imagen;

        // Guardamos las velocidades iniciales como las máximas permitidas
        this.velocidadMaximaX = Math.abs(velocidadX);
        this.velocidadMaximaY = Math.abs(velocidadY);
    }

    @Override
    public void mover() {
        x += velocidadX;
        y += velocidadY;
    }

    public int getVelocidadX() {
        return velocidadX;
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadX() {
        this.velocidadX = -velocidadX;
    }

    public void setVelocidadX(int value) {
        // Ajustar la velocidad sin exceder la velocidad máxima
        this.velocidadX = Math.max(-velocidadMaximaX, Math.min(value, velocidadMaximaX));
    }

    public void setVelocidadY() {
        this.velocidadY = -velocidadY;
    }

    public void setVelocidadY(int value) {
        // Ajustar la velocidad sin exceder la velocidad máxima
        this.velocidadY = Math.max(-velocidadMaximaY, Math.min(value, velocidadMaximaY));
    }

    @Override
    public void colisionar() {
        velocidadY = -velocidadY; // Invertimos la dirección en Y
    }

    public int getRadio() {
        return (int) (size.getHeight() / 2);
    }
}
