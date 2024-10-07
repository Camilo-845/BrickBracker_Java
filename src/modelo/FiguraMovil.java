package modelo;

public abstract class FiguraMovil extends Figura{
    protected int velocidadX;
    protected int velocidadY;

    protected abstract void mover();
    protected abstract void colisionar();
}
