package controlador;

import Utils.utilsMusica;
import vista.*;

import javax.swing.ImageIcon;

public class MainController {
    public MainView view;
    //Variables configuracion
    public boolean musicaActiva;
    public boolean sonidoActivo;

    //Variables Juego
    public int nivelDificultad;
    public int puntajeJuego;
    public boolean resultadoUltimoJuego; // Victoria true, Perdida false
    public int nivelOST;

    public MainController(MainView view) {
        this.view = view;
       
        this.musicaActiva = true;
        this.sonidoActivo = true;

        this.nivelDificultad = 1;
        this.puntajeJuego = 0;
    }

    public void iniciarVistaMenu(){
        VistaMenuPrincipal vistaMenu = new VistaMenuPrincipal();
        view.changeView(vistaMenu.getjPanel1());
        ControladorMenuPrincipal controladorMenu = new ControladorMenuPrincipal(this, vistaMenu);
    }
    
    public void iniciarVistaSeleccionarNivel(){
        SeleccionarNivelPanel vistaNivel = new SeleccionarNivelPanel();
        view.changeView(vistaNivel.getjPanel1());
        ControladorSeleccionarNivel controladorNivel = new ControladorSeleccionarNivel(this, vistaNivel);
    }
    
    public void iniciarVistaCreditos(){
        VistaCreditos vistaCreditos = new VistaCreditos();
        view.changeView(vistaCreditos.getjPanel1());
        ControladorVistaCreditos controladorCreditos = new ControladorVistaCreditos(this, vistaCreditos);
    }
    
    public void iniciarVistaTienda(){
        VistaTienda vistaTienda = new VistaTienda();
        view.changeView(vistaTienda.getjPanel1());
        ControladorVistaTienda controladorTienda = new ControladorVistaTienda(this,vistaTienda);
    }
    
    public void iniciarVistaConfiguracion(){
        VistaConfiguracion vistaConfiguracion = new VistaConfiguracion();
        view.changeView(vistaConfiguracion.getjPanel1());
        ControladorVistaConfiguracion controladorConfiguracion = new ControladorVistaConfiguracion(this, vistaConfiguracion);
    }
    
    public void inicarVistaGameOver(){
        VistaGameOver vistaGameOver = new VistaGameOver();
        view.changeView(vistaGameOver.getjPanel1());
        ControladorVistaGameOver controladorGameOver1 = new ControladorVistaGameOver(this, vistaGameOver);
    }

    public void iniciarVistaJuego(){
        String bgImagePath = "/recursos/NivelUnoBackg.png";
        
        switch(this.nivelDificultad){
            case 1:
                bgImagePath = "/recursos/NivelUnoBackg.png";
                if(musicaActiva){
                    utilsMusica.getInstancia().stop();
                    utilsMusica.getInstancia();
                    utilsMusica.getInstancia().cargarOST("src/recursos/ost/primero.wav");
                    utilsMusica.getInstancia().playuntil();
                }
                break;
            case 2:
                if(musicaActiva){
                    bgImagePath = "/recursos/NivelDosBackGround.png";
                    utilsMusica.getInstancia().stop();
                    utilsMusica.getInstancia();
                    utilsMusica.getInstancia().cargarOST("src/recursos/ost/segundo.wav");
                    utilsMusica.getInstancia().playuntil();
                }
                break;
            case 3:
                if(musicaActiva){
                    bgImagePath = "/recursos/NivelTresBackground.png";
                    utilsMusica.getInstancia().stop();
                    utilsMusica.getInstancia();
                    utilsMusica.getInstancia().cargarOST("src/recursos/ost/tercer.wav");
                    utilsMusica.getInstancia().playuntil();
                }
                break;
        }

        VistaJuego gameView = new VistaJuego();
        gameView.backgroundImage = new ImageIcon(getClass().getResource(bgImagePath)).getImage();
        view.changeView(gameView);
        ControladorJuego controladorPelota = new ControladorJuego(this,gameView);
        controladorPelota.iniciar();
        this.puntajeJuego = 0;
        this.resultadoUltimoJuego = true;
    }

    public void iniciar() {
        iniciarVistaMenu();
        this.view.iniciar();
    }
}
