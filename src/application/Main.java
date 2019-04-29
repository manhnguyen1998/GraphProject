package application;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main  extends Application {
  
 
   @Override
   public void start(Stage primaryStage) {
       try {
           // Đọc file fxml và vẽ giao diện.
           Parent root = FXMLLoader.load(getClass()
                   .getResource("Scene.fxml"));
 
           primaryStage.setTitle("My Application");
           primaryStage.setScene(new Scene(root));
           primaryStage.show();
        
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
  
  
   public static void main(String[] args) {
       launch(args);
   }
  
}