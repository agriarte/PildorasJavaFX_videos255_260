/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package solucionPizza;

import emergente.VentanaEmergente;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * Solución según el curso. He cambiado la obtención de valores de checkbox usando un bucle y un ArrayList de checkbox
 */
public class Video255_260AppPizza extends Application {

    Stage miStage;
    TextField cuadroNombre, cuadroTelefono, cuadroDireccion;
    RadioButton radioPeq, radioMed, radioGran;
    RadioButton radioFina, radioNormal;
    CheckBox chkPepperoni, chkPimiento, chkAceitunas, chkChampi, chkTomate, chkAnchoas;
    ToggleGroup grupoTamano, grupoMasa;

    @Override
    public void start(Stage primaryStage) {

        miStage = primaryStage;
        //---------- creación del panel superior -------------------
        Text txtCabecera = new Text("Pide tu pizza ahora");
        txtCabecera.setFont(new Font(20));

        HBox paneSuperior = new HBox(txtCabecera);
        paneSuperior.setPadding(new Insets(20, 10, 20, 10));

        //---------- creación del panel datos del cliente -------------------
        //Label y text field del nombre
        Label lblNombre = new Label("Nombre: ");
        lblNombre.setPrefWidth(100);//ancho en pixeles

        cuadroNombre = new TextField();
        cuadroNombre.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroNombre.setPromptText("Introduce tu nombre");// texto por defecto

        HBox paneNombre = new HBox(lblNombre, cuadroNombre);

        //Label y text field del telefono
        Label lblTelefono = new Label("Telefono: ");
        lblTelefono.setPrefWidth(100);//ancho en pixeles

        cuadroTelefono = new TextField();
        cuadroTelefono.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroTelefono.setPromptText("Introduce tu telefono");// texto por defecto

        HBox paneTelefono = new HBox(lblTelefono, cuadroTelefono);

        //Label y text field de la dirección
        Label lblDirección = new Label("Dirección: ");
        lblDirección.setPrefWidth(100);//ancho en pixeles

        cuadroDireccion = new TextField();
        cuadroDireccion.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroDireccion.setPromptText("Introduce tu dirección");// texto por defecto

        HBox paneDirecion = new HBox(lblDirección, cuadroDireccion);

        // panel de datos con la suma de los 4 anteriores
        VBox paneCliente = new VBox(10, paneSuperior, paneNombre, paneTelefono, paneDirecion);

        //---------- creación del panel de los pedidos -------------------
        // Creación del pane de tamaño
        Label lblTamaño = new Label("Tamaño:");
        radioPeq = new RadioButton("Pequeña");
        radioMed = new RadioButton("Mediana");
        radioGran = new RadioButton("Grande");

        radioMed.setSelected(true);

        grupoTamano = new ToggleGroup();
        radioPeq.setToggleGroup(grupoTamano);
        radioMed.setToggleGroup(grupoTamano);
        radioGran.setToggleGroup(grupoTamano);

        VBox paneTamano = new VBox(10, lblTamaño, radioPeq, radioMed, radioGran);
        paneTamano.setSpacing(10);

        // Creación del pane de Masa
        Label lblMasa = new Label("Masa:");
        radioFina = new RadioButton("Fina");
        radioNormal = new RadioButton("Normal");

        radioFina.setSelected(true);

        grupoMasa = new ToggleGroup();
        radioFina.setToggleGroup(grupoMasa);
        radioNormal.setToggleGroup(grupoMasa);

        VBox paneMasa = new VBox(10, lblMasa, radioFina, radioNormal);
        paneMasa.setSpacing(10);

        // Creación del pane de Ingredientes
        Label lblIngredientes = new Label("Ingredientes");

        chkPepperoni = new CheckBox("Pepperoni");

        chkPimiento = new CheckBox("Pimiento");

        chkAceitunas = new CheckBox("Aceitunas");

        chkChampi = new CheckBox("Champiñones");

        chkTomate = new CheckBox("Tomate");

        chkAnchoas = new CheckBox("Anchoas");

        FlowPane paneIngredientes = new FlowPane(Orientation.VERTICAL, chkPepperoni, chkPimiento, chkAceitunas, chkChampi, chkTomate, chkAnchoas);
        paneIngredientes.setPadding(new Insets(10, 0, 10, 0));
        paneIngredientes.setHgap(20);
        paneIngredientes.setVgap(10);
        paneIngredientes.setPrefWrapLength(100);

        VBox paneIngredientesVertical = new VBox();
        paneIngredientesVertical.getChildren().addAll(lblIngredientes, paneIngredientes);

        //-------------- Crear pane de características de pizza -----------------
        HBox paneOrden = new HBox(50, paneTamano, paneMasa, paneIngredientesVertical);

        //-------------- Crear pane de datos cliente + pedido  -----------------
        VBox paneCentral = new VBox(20, paneCliente, paneOrden);
        paneCentral.setPadding(new Insets(0, 10, 0, 10));

        //-------------- Crear pane inferior: botones  -----------------
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btn_OK_Click());

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setPrefWidth(80);
        btnCancelar.setOnAction(e -> btn_Cancelar_Click());

        //Se usa la clase Region para mejorar el aspecto
        Region espacio = new Region();

        HBox paneInferior = new HBox(10, espacio, btnOK, btnCancelar);
        paneInferior.setHgrow(espacio, Priority.ALWAYS);//prioridad de crecimiento si este panel tiene que competir por otras al reescalar la pantalla
        paneInferior.setPadding(new Insets(20, 10, 20, 10));

        //----------- FINALIZAR LA SCENE ---------------
        BorderPane panePrincipalTodo = new BorderPane();
        panePrincipalTodo.setTop(paneSuperior);
        panePrincipalTodo.setCenter(paneCentral);
        panePrincipalTodo.setBottom(paneInferior);

        Scene scene = new Scene(panePrincipalTodo, 600, 400);

        miStage.setTitle("Solución Pizza Pildoras Informaticas");
        miStage.setScene(scene);
        miStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void btn_OK_Click() {
        //Creación con el String del cliente
        String msg = "Cliente:\n\n";
        msg += "\t" + cuadroNombre.getText() + "\n" + "\t" +cuadroTelefono.getText() + "\n" + "\t" + cuadroDireccion.getText() + "\n";
        msg += "\tHas pedido:\n";
        msg += "\tTamaño: " + ((RadioButton) grupoTamano.getSelectedToggle()).getText()  + "\n";
        msg += "\tMasa: " + ((RadioButton) grupoMasa.getSelectedToggle()).getText() + "\n";
        msg += "\tLista de ingredientes: " + obtenerIngredientes() + "\n";
        
        
        VentanaEmergente.mostrar(msg,"Tu pedido");

    }

    private void btn_Cancelar_Click() {
        miStage.close();
    }

    private String obtenerIngredientes() {
        String ingredientes = "";
        List<CheckBox> ingredientesCheckBoxList = new ArrayList<>();
        ingredientesCheckBoxList.add(chkPepperoni);
        ingredientesCheckBoxList.add(chkPimiento);
        ingredientesCheckBoxList.add(chkAceitunas);
        ingredientesCheckBoxList.add(chkChampi);
        ingredientesCheckBoxList.add(chkTomate);
        ingredientesCheckBoxList.add(chkAnchoas);

        // lógica para obtener los ingredientes seleccionados
        for (CheckBox checkBox : ingredientesCheckBoxList) {
            if (checkBox.isSelected()) {
                ingredientes += checkBox.getText() + ", ";
            }
        }
     // Eliminar la última coma y espacio si es necesario solo si se selecciona algún ingrediente
    if (!ingredientes.isEmpty()) {
        //Crear subcadena desde el primer caracter (índice 0) hasta el último -2 para eliminar ", "
        ingredientes = ingredientes.substring(0, ingredientes.length() - 2);
    }
        return ingredientes;
    }

}
