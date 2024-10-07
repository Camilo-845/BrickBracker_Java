
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utils.utilsMusica;
import vista.SeleccionarNivelPanel;

public class ControladorSeleccionarNivel implements ActionListener {

    private SeleccionarNivelPanel view;
    private MainController mainController;
    protected utilsMusica bgmusic;

    public ControladorSeleccionarNivel(MainController controller, SeleccionarNivelPanel view) {
        this.view = view;
        this.mainController = controller;
        this.view.getNivel1Boton().addActionListener(this);
        this.view.getNivel2Boton().addActionListener(this);
        this.view.getNivel3Boton().addActionListener(this);
        this.view.getBotonVolver().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bgmusic = utilsMusica.getInstancia();
        if (e.getSource() == view.getNivel1Boton()) {
            mainController.nivelDificultad = 1;
            mainController.iniciarVistaJuego();
        }
        if (e.getSource() == view.getNivel2Boton()) {
            mainController.nivelDificultad = 2;
            mainController.iniciarVistaJuego();
        }
        if (e.getSource() == view.getNivel3Boton()) {
            mainController.nivelDificultad = 3;
            mainController.iniciarVistaJuego();
        }
        if (e.getSource() == view.getBotonVolver()) {
            mainController.iniciarVistaMenu();
        }
    }
}
