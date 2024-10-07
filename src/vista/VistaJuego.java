package vista;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseMotionListener; 
import java.util.List;
import java.util.Random;

import modelo.*;



public class VistaJuego extends JPanel {
            
    public Image backgroundImage;
    private Pelota pelota; 
    private Barra barra; 
    private List<Bloque> bloques;
    public int puntaje;
    public int vidas;

    public void setBloques(List<Bloque> bloques) {
        this.bloques = bloques;
    }
    
    private MouseMotionListener mouseListener;  // Mueve la declaración aquí

    public void setPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    public void setBarra(Barra barra) {
        this.barra = barra;
    }
    
    public VistaJuego() { 
        setPreferredSize(new Dimension(800, 600)); 
        this.puntaje = 0;
        this.vidas = 3;
        // Inicializa el listener aquí y lo guardas en la variable
        mouseListener = new MouseMotionListener() { 
            @Override 
            public void mouseMoved(MouseEvent e) { 
                barra.mover(e.getX()); 
                repaint(); 
            } 

            @Override 
            public void mouseDragged(MouseEvent e) { } 
        };
        
    } 
 
    @Override 
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
 
        
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Sagoe UI",0, 20));
        g.drawString("Puntaje", 685, 20);
        g.drawString(""+this.puntaje, 770, 20);
        
        g.drawString("Vidas", 500, 20);
        g.drawString(""+this.vidas, 600, 20);
        
        g.setColor(Color.RED); 
        g.fillOval(pelota.getX() - pelota.getRadio(), pelota.getY() - pelota.getRadio(), 
                   pelota.getRadio() * 2, pelota.getRadio() * 2); 
        g.setColor(Color.BLUE); 
        
        g.drawImage(barra.getImagen(), barra.getX(), barra.getY(), barra.getSize().width,barra.getSize().height,this);
//        g.fillRect(barra.getX(), barra.getY(), barra.getSize().width, barra.getSize().height);
        
        for (int n = 0; n < bloques.size(); n++){
            Bloque bloque = bloques.get(n);
            g.drawImage(bloque.getImagen(), bloque.getX(), bloque.getY(), bloque.getSize().width,bloque.getSize().height,this);
        }   
    } 
 
    public void actualizarPanel() { 
        repaint(); 
    } 
    public void iniciar(){
         this.addMouseMotionListener(mouseListener);
    }
    public void detener(){
        this.removeMouseMotionListener(mouseListener);  // Se remueve correctamente
    }
    
    // Color Aleatorio
    public Color obtenerColorAleatorio() {
           Random random = new Random();

           // Generar valores aleatorios para rojo, verde y azul
           int rojo = random.nextInt(256);   // Valor entre 0 y 255
           int verde = random.nextInt(256);  // Valor entre 0 y 255
           int azul = random.nextInt(256);   // Valor entre 0 y 255

           // Crear y devolver el color
           return new Color(rojo, verde, azul);
   }

}


