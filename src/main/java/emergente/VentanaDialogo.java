/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emergente;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class VentanaDialogo {
    
    private static Stage miStage;
    private static boolean botonSiPulsado;

    public static boolean mostrar(String mensaje, String titulo) {
        // crear stage
        miStage = new Stage();
        miStage.initModality(Modality.APPLICATION_MODAL);
        
        miStage.setTitle(titulo);
        miStage.setMinWidth(350);
        
        Label miLabel = new Label();
        miLabel.setText(mensaje);
        
        // Creación Botón Sí
        Button miBotonSi = new Button("Sí");
        miBotonSi.setOnAction(e->miBotonSi_clicked());
        
        // Creación Botón No
        Button miBotonNo = new Button("No");
        miBotonNo.setOnAction(e->miBotonNo_clicked());
        
        //panel HBox para distribuir elementos en horizontal
        HBox panelHBox = new HBox(20);
        panelHBox.getChildren().addAll(miBotonSi, miBotonNo);
        //alinear elementos
        panelHBox.setAlignment(Pos.CENTER);
        
        //panel VBox para la caja de texto
        VBox panelVBox = new VBox(20);
        panelVBox.getChildren().addAll(miLabel,panelHBox);
        panelVBox.setAlignment(Pos.CENTER);
        
        // crear scene agregando el panel vertical que a su vez tiene dentro el panel horizontal
        //Scene miScene = new Scene(panelVBox, 400, 150);
        Scene miScene = new Scene(panelVBox);//sin medidas se adapta el tamaño al contenido
        
        
        // decir que stage contiene un scene
        miStage.setScene(miScene);
        // mostrar la ventana y detener el flujo del programa. show mostraría la ventana pero seguiría corriendo el programa
        // showAndWait() se espera hasta que se cierra para seguir.
        miStage.showAndWait(); 
        
        return botonSiPulsado;
    }

    private static void miBotonSi_clicked() {
        botonSiPulsado=true;
                
        miStage.close();
    }

    private static void miBotonNo_clicked() {
        botonSiPulsado=false;
        
        miStage.close();
    }

}
