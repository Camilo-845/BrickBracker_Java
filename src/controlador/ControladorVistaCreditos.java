
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCreditos;

public class ControladorVistaCreditos implements ActionListener{
    private VistaCreditos view;
    private MainController mainController;

    public ControladorVistaCreditos(MainController controller, VistaCreditos view) {
        this.view = view;
        this.mainController = controller;
        this.view.getBotonVolver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBotonVolver()) {
            mainController.iniciarVistaMenu();
        }
    }
}
