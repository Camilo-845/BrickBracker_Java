package controlador;

import Utils.utilsMusica;
import vista.VistaMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuPrincipal implements ActionListener {
    private VistaMenuPrincipal view;
    private MainController mainController;
    private utilsMusica bgmusic;

    public ControladorMenuPrincipal(MainController controller, VistaMenuPrincipal view) {
        this.view = view;
        this.mainController = controller;
        this.view.getBotonInicarJuego().addActionListener(this);
        this.view.getBotonCreditos().addActionListener(this);
        this.view.getBotonSalir().addActionListener(this);
        this.view.getBotonConfiguracion().addActionListener(this);
        this.view.getBotonTienda().addActionListener(this);
        if(mainController.musicaActiva){
            utilsMusica.getInstancia().cargarOST("src/recursos/ost/bgmenu.wav");
            utilsMusica.getInstancia().playuntil();   
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBotonInicarJuego()) {
            mainController.iniciarVistaSeleccionarNivel();
        }
        if (e.getSource() == view.getBotonCreditos()) {
            mainController.iniciarVistaCreditos();
        }
        if (e.getSource() == view.getBotonSalir()) {
            System.exit(0);
        }
        
        if (e.getSource() == view.getBotonConfiguracion()) {
            mainController.iniciarVistaConfiguracion();
        }
        if (e.getSource() == view.getBotonTienda()) {
            mainController.iniciarVistaTienda();
        }
    }
}
