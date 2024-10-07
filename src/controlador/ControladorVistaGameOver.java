
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import controlador.ControladorSeleccionarNivel;
import Utils.utilsMusica;
import vista.VistaGameOver;

public class ControladorVistaGameOver implements ActionListener{
    private VistaGameOver view;
    private MainController mainController;

    public ControladorVistaGameOver(MainController controller, VistaGameOver view) {
        this.view = view;
        this.mainController = controller;
        this.view.getBotonSalir().addActionListener(this);
        this.view.getBotonVolverAJugar().addActionListener(this);
        this.view.getLabelPuntaje().setText("" + mainController.puntajeJuego);
        this.view.getBotonImagen().setIcon(new ImageIcon(getClass().getResource(mainController.resultadoUltimoJuego?"/recursos/GanarBackground.png":"/recursos/DerrotaBackground.png")));
        if(mainController.musicaActiva){
            utilsMusica.getInstancia().stop();
            utilsMusica.getInstancia().cargarOST("src/recursos/ost/bggameover.wav");
            utilsMusica.getInstancia().play();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        utilsMusica.getInstancia();
        if (e.getSource() == view.getBotonSalir()) {
            mainController.iniciarVistaMenu();
            utilsMusica.getInstancia().stop();
            utilsMusica.getInstancia().cargarOST("src/recursos/ost/bgmenu.wav");
            utilsMusica.getInstancia().playuntil();
        }
        if (e.getSource() == view.getBotonVolverAJugar()) {
            mainController.iniciarVistaJuego();
        }
    }
}
