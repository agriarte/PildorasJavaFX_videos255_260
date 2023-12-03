/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pildoras.misolucionpizza;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * Funciona
 */
public class pruebaCheckBox2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // set title for the stage
        primaryStage.setTitle("Probando CheckBox");

        // Ejemplo de checkbox de verificación presentadas con el objetivo de que queden justificadas, alineadas y manteniendo control sobre la separación entre ellas.
        // Seguro que hay una forma más sencilla, pero comencé con TilePane y quise que todo estuviera ordenado. Poco a poco, se fue complicando y terminé
        // creando HBox en bucle, que se encuentran dentro del TilePane, y esto, a su vez, se insertó dentro de un VBox con la etiqueta que utilizo como título.
        // crer un label. No forma parte de la list de checkbox
        Label lbIngredientes = new Label("Selecciona ingredientes:");
        lbIngredientes.setPadding(new Insets(20, 0, 0, 20));// margen arriba,derecha,abajo,izquierda

        //Contenedor de los checkbox
        TilePane tilePaneIngredientes = new TilePane();
        tilePaneIngredientes.setPadding(new Insets(20));
        tilePaneIngredientes.setHgap(15); // Espacio horizontal entre elementos
        tilePaneIngredientes.setVgap(5); // Espacio vertical entre elementos
        tilePaneIngredientes.setAlignment(Pos.TOP_LEFT); // Alinear tilepane elementos en la esquina superior izquierda

        // string array
        String ingredientes[] = {"Atún", "Maiz", "Champiñones", "Pollo", "Salsa picante", "Cebolla", "Queso", "Tomate"};

        for (String st1 : ingredientes) {
            // crear checkbox
            CheckBox miCheckBox = new CheckBox(st1);
            // Establecer un tamaño preferido
            miCheckBox.setPrefSize(100, 20);
            Label l1 = new Label(st1 + " no seleccionado");
            l1.setPrefWidth(180);// muy ancho para que entre la etiqueta "champiñones no seleccionado"
            // Crear un evento que cambia label según estado de checkbox
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (miCheckBox.isSelected()) {
                        l1.setText(st1 + " seleccionado ");
                    } else {
                        l1.setText(st1 + " no seleccionado ");
                    }
                }
            };
            // asignar evento a cada checkbox del buclue
            miCheckBox.setOnAction(event);

            // Crear un HBox para alinear CheckBox y Label horizontalmente
            // Se añaden en bucle los HBox con la pareja checkbox y su label para poder ajustar la separación entre ellos.
            HBox hbox = new HBox(5, miCheckBox, l1);

            // agregar HBox al TilePane
            tilePaneIngredientes.getChildren().add(hbox);
        }

        // creando VBox para con el label "Seleccione ingredientes" y el TilePane que contiene los checkbox
        VBox vBoxIngredientes = new VBox(10, lbIngredientes, tilePaneIngredientes);

        // create a scene
        Scene miEscena = new Scene(vBoxIngredientes, 600, 400);

        // set the scene
        primaryStage.setScene(miEscena);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
