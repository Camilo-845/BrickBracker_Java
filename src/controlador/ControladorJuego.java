package controlador;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.Random;
import java.util.Arrays;

import Utils.utilsMusica;
import modelo.*;
import vista.*;

public class ControladorJuego { 
    private Pelota pelota;
    private Barra barra; 
    private List<Bloque> bloques;
    
    private VistaJuego panelPelota; 
    private Timer temporizador; 
    private MainController mainController;
    private Dimension mainContainerSize;
 
    public ControladorJuego(MainController controller,VistaJuego panelPelota) {
        this.panelPelota = panelPelota;
        this.mainController = controller;
        this.mainContainerSize = mainController.view.viewSize;
        
        this.pelota = new Pelota(400, 400, 10, 6,6,(int) mainContainerSize.getWidth(), (int)mainContainerSize.getHeight(), null);
        this.barra = new Barra(10, mainContainerSize.height - 50, 100, 10 , mainContainerSize);
        this.barra.setImagen(new ImageIcon(getClass().getResource("/recursos/Barra.png")).getImage());
        this.bloques = new ArrayList<>();
        this.generarBloques(4, 10, 30, 10, 40);
        
        pelota.setVelocidadX();
        pelota.setVelocidadY();
            
        this.panelPelota.setBarra(barra);
        this.panelPelota.setPelota(pelota);
        this.panelPelota.setBloques(bloques);
        
        this.temporizador = new Timer(16, new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) { 
                if(bloques.size()==0){
                    detener();
                    mainController.inicarVistaGameOver();
                }
                pelota.mover(); 
                verificarColision();
                panelPelota.actualizarPanel(); 
            } 
        });
    }
    private void verificarColision() { 
        //Colisiones pelota con panel
        if(pelota.getY() + pelota.getRadio() > mainContainerSize.getHeight()){
            mainController.resultadoUltimoJuego = false;
            mainController.inicarVistaGameOver();
            detener();
        }
        
        if (pelota.getX()- pelota.getRadio() < 0 || pelota.getX() + pelota.getRadio() > mainContainerSize.width){
            pelota.setVelocidadX();
        }
        
        if (pelota.getY() - pelota.getRadio() < 0 ) {
            pelota.setVelocidadY();
        }
        
        //Conlisiones pelota con barra
        if (barra.estaColisionando(pelota) != 0) {
            // Obtener el centro de la barra y la pelota
            int centroBarra = barra.getX() + (barra.getSize().width / 2);
            int centroPelota = pelota.getX() + (pelota.getSize().width / 2);

            // Distancia entre el centro de la pelota y el centro de la barra
            int distancia = centroPelota - centroBarra;

            // Factor de ajuste para cambiar la velocidad en X en función de la distancia
            int factor = 2;  // Puedes ajustar este valor para que la velocidad cambie más o menos

            // Cambiar la dirección de la velocidad en X basado en la distancia del centro
            pelota.setVelocidadX(distancia / factor);

            // Invertir la dirección de la pelota en Y (asume que colisionó en Y)
            pelota.colisionar();
            
        }
        
        //Colisiones pelota con bloques
        for(int i = 0; i<bloques.size(); i++){
            Bloque bloque = bloques.get(i);
            int isColisionado = bloque.estaColisionando(pelota);
            if(isColisionado != 0){
                if(isColisionado == 1){
                    pelota.setVelocidadY();
                }
                else{
                    pelota.setVelocidadX();
                }
                bloque.dureza.dureza --;
                if( bloque.dureza.dureza <= 0){
                    bloques.remove(i);
                }else{
                    bloque.setImagen(bloque.dureza.imagenes.get(bloque.dureza.dureza-1));
                } 
                mainController.puntajeJuego++;
            }
        }
    } 
 
    public void iniciar() {
        panelPelota.iniciar();
        temporizador.start(); 
    } 
 
    public void detener() { 
        temporizador.stop(); 
        panelPelota.detener();
    }
    
    private void generarBloques(int filas, int columnas, int margenX, int margenY, int alturaBloques){
        int anchoPanel = this.mainContainerSize.width - (2 * margenX);
        int anchoColumna = anchoPanel / columnas;
        for(int n = 1 ; n <= ( filas * columnas ) ; n++){
            
            int fila = ((n - 1) / columnas )+1;
            int columna = ((n - 1) % columnas )+1; 
            int posX = margenX + ((columna - 1) * anchoColumna);
            int posY = margenY + ((fila - 1) * alturaBloques) + (fila/2);
            
            Bloque bloque = new Bloque(posX, posY, anchoColumna - 1, alturaBloques - 1, mainContainerSize);
            
            //Se le añade una imagen aleatoria
                                                            
            List<Dureza> listaDurezas = Arrays.asList(
                new Dureza(Arrays.asList(
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueAmarrillo_1.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueAmarrillo_2.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueAmarrillo_3.png")).getImage()
                )),
                new Dureza(Arrays.asList(
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueCeleste_1.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueCeleste_2.png")).getImage()
                )),
                new Dureza(Arrays.asList(
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueVerde.png")).getImage()
                )),
                new Dureza(Arrays.asList(
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueRosado_1.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueRosado_2.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueRosado_3.png")).getImage(),
                    new ImageIcon(getClass().getResource("/recursos/ImagenesBloques/BloqueRosado_4.png")).getImage()
                ))
            );
            int aleatorio = obtenerAleatorio(0, listaDurezas.size()-1);
            bloque.dureza = listaDurezas.get(aleatorio);
            bloque.setImagen(bloque.dureza.imagenes.get(bloque.dureza.dureza-1));
            this.bloques.add(bloque);
        }
    }
    
    
    private int obtenerAleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
} 
