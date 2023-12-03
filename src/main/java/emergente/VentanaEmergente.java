/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emergente;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class VentanaEmergente {

    public static void mostrar(String mensaje, String titulo) {
        // crear stage
        Stage miStage = new Stage();
        miStage.initModality(Modality.APPLICATION_MODAL);
        
        miStage.setTitle(titulo);
        miStage.setMinWidth(450);
        
        Label miLabel = new Label();
        miLabel.setText(mensaje);
        
        Button miBoton = new Button("Cerrar");
        miBoton.setOnAction(e->miStage.close());
        
        //crear pane
        BorderPane miPane = new BorderPane();
        // crear scene
        Scene miScene = new Scene(miPane, 600, 450);
        
        //ubicar elemento       
        miPane.setTop(miLabel);
        miPane.setCenter(miBoton);
        
        // decir que stage contiene un scene
        miStage.setScene(miScene);
        // mostrar la ventana y detener el flujo del programa. show mostraría la ventana pero seguiría corriendo el programa
        // showAndWait() se espera hasta que se cierra para seguir.
        miStage.showAndWait();      
    }

}
