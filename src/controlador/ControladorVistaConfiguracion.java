
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utils.utilsMusica;
import vista.VistaConfiguracion;

public class ControladorVistaConfiguracion implements ActionListener{
    private VistaConfiguracion view;
    private MainController mainController;

    public ControladorVistaConfiguracion(MainController controller, VistaConfiguracion view) {
        this.view = view;
        this.mainController = controller;
        this.view.getBotonVolver().addActionListener(this);
        this.view.getComboBoxMusica().addActionListener(this);
        this.view.getComboBoxSonido().addActionListener(this);
        
        this.view.getComboBoxMusica().setSelectedIndex((controller.musicaActiva)?0:1);
        this.view.getComboBoxSonido().setSelectedIndex((controller.sonidoActivo)?0:1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBotonVolver()) {
            mainController.iniciarVistaMenu();
        }
        if (e.getSource() == view.getComboBoxMusica()) {
            mainController.musicaActiva = view.getComboBoxMusica().getSelectedIndex() == 0;
            if (view.getComboBoxMusica().getSelectedIndex() == 0) {
                utilsMusica.getInstancia().play();
            } else {
                utilsMusica.getInstancia().pause();
            }
        }
        if (e.getSource() == view.getComboBoxSonido()) {
            mainController.sonidoActivo = view.getComboBoxSonido().getSelectedIndex() == 0;
        }
        
    }
}
