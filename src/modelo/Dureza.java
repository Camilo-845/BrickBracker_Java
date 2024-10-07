package modelo;
import java.awt.Image;

public class Dureza {
    public java.util.List<Image> imagenes;
    public int dureza;

    public Dureza(java.util.List<Image> imagePaths) {
        this.imagenes = imagePaths;
        this.dureza = imagePaths.size();
    }
    
}