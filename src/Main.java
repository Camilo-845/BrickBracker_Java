import vista.*;
import controlador.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainView frame = new MainView("Pelota que Rebota con Barra",new Dimension(800, 600));
        MainController controller = new MainController(frame);
        controller.iniciar();
    }
}