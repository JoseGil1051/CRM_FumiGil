package aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.logging.Logger;

public class MainApp extends Application {
    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml"))
            );
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm()
            );
            
            primaryStage.setTitle("CRM FumiGil - Inicio de Sesion");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            
            LOGGER.info("Aplicacion iniciada correctamente");
        } catch (Exception e) {
            LOGGER.severe("Error al iniciar la aplicacion: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}