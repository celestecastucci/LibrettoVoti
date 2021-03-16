package it.polito.tdp.librettovoti;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
     
    	/**
    	 * EFFETTUO QUESTE MODIFICHE PER LA CLASSE ENTRYPOINT (riga dalla 23 alla 28)
    	 * NELLA CLASSE CONTROLLER dichiaro il model e il suo set (riga 15 e 31)
    	 * ATTENZIONE DEVO FARE ALCUNI IMPORT!
    	 */
    	
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/Scene.fxml")); //creo una classe che può ricevere cosa riceveva root
    	Parent root = loader.load();
    	FXMLController controller=loader.getController();
        
        Libretto model= new Libretto();
         controller.setModel(model);
         
         
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
