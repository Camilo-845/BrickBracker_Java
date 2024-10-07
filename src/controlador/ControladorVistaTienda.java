
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaTienda;

public class ControladorVistaTienda implements ActionListener{
    private VistaTienda view;
    private MainController mainController;

    public ControladorVistaTienda(MainController controller, VistaTienda view) {
        this.view = view;
        this.mainController = controller;
        this.view.getBotonAnterior().addActionListener(this);
        this.view.getBotonSiguiente().addActionListener(this);
        this.view.getBotonVolver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBotonAnterior()) {
            view.getBotonAnterior().setEnabled(false);
        }
        if (e.getSource() == view.getBotonSiguiente()) {
            view.getBotonSiguiente().setEnabled(false);
        }
        if (e.getSource() == view.getBotonVolver()) {
            this.mainController.iniciarVistaMenu();
        }
    }
}
