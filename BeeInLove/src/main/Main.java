package main;

//import java.io.File;
//import java.net.URL;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class Main{
//public class Main extends Application {
//    public void start(Stage primaryStage) {
//        try {
//        	File fxmlFile = new File("D:\Download\AOL\OOP\UI\\FRONTPAGE.fxml");
//        	URL url = fxmlFile.toURI().toURL();
//        	Parent root = FXMLLoader.load(url);
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//
//            Button nextBtn = (Button) root.lookup("#nextBtn");
//            nextBtn.setOnAction(e -> {
//            		try {
//                    	File menuFile = new File("D:\Download\AOL\OOP\UIapplication\\MENU.fxml");
//                    	URL menuURL = menuFile.toURI().toURL();
//                    	Parent menu = FXMLLoader.load(menuURL);
//                    	primaryStage.setTitle("Menu");
//                    	primaryStage.setScene(new Scene(menu));
//                	} catch (Exception ex) {
//                		ex.printStackTrace();
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public Main() {
    	Menu.Greet();
    }
    
    public static void main(String[] args) {
//        launch(args);
        new Main();
    }
}
