package pildoras.misolucionpizza;

import emergente.VentanaEmergente;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX EjercicioPizza_mimanera
 */
public class EjercicioPizza_mimanera extends Application {

    private TextField txtTelefono, txtNombre, txtDireccion;
    private ToggleGroup medidaPizza;
    private ToggleGroup masaPizza;

    private List<CheckBox> ingredientesCheckBoxList;

    @Override
    public void start(Stage primaryStage) {
        //Nombre
        Label lbNombre = new Label("Nombre: ");
        lbNombre.setMinWidth(100);
        lbNombre.setAlignment(Pos.BOTTOM_RIGHT);
        //campo de texto del nombre
        txtNombre = new TextField();
        txtNombre.setMinWidth(100);
        txtNombre.setMaxWidth(100);
        txtNombre.setPromptText("tu nombre");

        //Telefono
        Label lbTelefono = new Label("Telefono: ");
        lbTelefono.setMinWidth(100);
        lbTelefono.setAlignment(Pos.BOTTOM_RIGHT);
        //campo de texto del telefono
        txtTelefono = new TextField();
        txtTelefono.setMinWidth(100);
        txtTelefono.setMaxWidth(100);
        txtTelefono.setPromptText("tu telefono");

        //Dirección
        Label lbDirección = new Label("Dirección: ");
        lbDirección.setMinWidth(100);
        lbDirección.setAlignment(Pos.BOTTOM_RIGHT);
        //campo de texto de la dirección
        txtDireccion = new TextField();
        txtDireccion.setMinWidth(300);
        txtDireccion.setMaxWidth(300);
        txtDireccion.setPromptText("tu dirección");

        //creacion del pane del nombre
        HBox hBoxNombre = new HBox(5, lbNombre, txtNombre);
        hBoxNombre.setPadding(new Insets(10));//añadir un padding de una forma que parece un poco rebuscada
        //Crea una clase de tipo Insets con un margen de 10 para los 4 lados. Esta línea es equivalente a:
        //hBoxEquipo.setPadding(new Insets(10,10,10,10));
        //El método setPadding requiere objeto tipo Insets como parámetro. No es válido hacer hBoxNombre.setPadding(10); que sería lo
        //más intuitivo y fácil.

        //creacion del pane del telefono
        HBox hBoxTelefono = new HBox(5, lbTelefono, txtTelefono);
        hBoxTelefono.setPadding(new Insets(10));

        //creacion del pane de direccion
        HBox hBoxDireccion = new HBox(5, lbDirección, txtDireccion);
        hBoxDireccion.setPadding(new Insets(10));

        // Tamaño de pizza
        Label lbMedida = new Label("Medida");
        medidaPizza = new ToggleGroup();
        RadioButton medidaPeque = new RadioButton("Pequeña");
        medidaPeque.setToggleGroup(medidaPizza);

        RadioButton medidaMediana = new RadioButton("Mediana");
        medidaMediana.setToggleGroup(medidaPizza);
        medidaMediana.setSelected(true);
        RadioButton medidaGrande = new RadioButton("Grande");
        medidaGrande.setToggleGroup(medidaPizza);
        //creacion del pane de Medida Pizza
        VBox hVBoxMedida = new VBox(20, lbMedida, medidaPeque, medidaMediana, medidaGrande);
        hVBoxMedida.setMinWidth(120);//para que no se aplaste la columna Medida
        hVBoxMedida.setPadding(new Insets(10));

        // Tipo de Masa
        Label lbMasa = new Label("Tipo de masa");
        masaPizza = new ToggleGroup();
        RadioButton masaFina = new RadioButton("Masa Fina");
        masaFina.setToggleGroup(masaPizza);

        RadioButton masaGorda = new RadioButton("Masa Gorda");
        masaGorda.setToggleGroup(masaPizza);
        masaGorda.setSelected(true);
        //creacion del pane de Masa Pizza
        VBox hVBoxMasa = new VBox(20, lbMasa, masaFina, masaGorda);
        hVBoxMasa.setMinWidth(120);
        hVBoxMasa.setPadding(new Insets(10));
        //boton
        Button miBoton = new Button("entrar");
        miBoton.setMinWidth(80);
        miBoton.setMaxWidth(80);
        //evento de boton
        miBoton.setOnAction(e -> accionClick());
        //creacion del pane del boton
        HBox hBoxBoton = new HBox(20, miBoton);
        hBoxBoton.setPadding(new Insets(10));
        hBoxBoton.setAlignment(Pos.BOTTOM_CENTER);

        //*** TODO ESTO ES EL TILEPANE CON LOS CHECKBOX
        // crer un label. No forma parte de la list de checkbox
        Label lbIngredientes = new Label("Selecciona ingredientes:");
        lbIngredientes.setPadding(new Insets(10, 0, 0, 5));// margen arriba,derecha,abajo,izquierda

        //Contenedor de los checkbox
        TilePane tilePaneIngredientes = new TilePane();
        tilePaneIngredientes.setPadding(new Insets(5));
        tilePaneIngredientes.setHgap(15); // Espacio horizontal entre elementos
        tilePaneIngredientes.setVgap(5); // Espacio vertical entre elementos
        tilePaneIngredientes.setAlignment(Pos.TOP_LEFT); // Alinear tilepane elementos en la esquina superior izquierda

        // string array
        String ingredientes[] = {"Atún", "Maiz", "Champiñones", "Pollo", "Salsa picante", "Cebolla", "Queso", "Tomate"};

        // Lista para almacenar los CheckBox
        ingredientesCheckBoxList = new ArrayList<>();

        for (String st1 : ingredientes) {
            // crear checkbox
            CheckBox miCheckBox = new CheckBox(st1);
            // Establecer un tamaño preferido
            miCheckBox.setPrefSize(100, 20);

            //añadir a una lista las instancias de checkBox para poder comprobar su estado en el método acciónClick
            ingredientesCheckBoxList.add(miCheckBox);
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

        //*** FIN TILEPANE
        //CREACION DEL VBOX QUE INCLUYE LOS 4 HBOX
        VBox miVBoxSuperior = new VBox(hBoxNombre, hBoxTelefono, hBoxDireccion);
        //CREACION DEL HBOX QUE INCLUYE MEDIDA, MASA INGREDIENTES
        HBox miHBoxInferior = new HBox(hVBoxMedida, hVBoxMasa, vBoxIngredientes);
        //SUMA EN VERTICAL DE LOS 2 CONTENEDORES
        VBox finalVBox = new VBox(miVBoxSuperior, miHBoxInferior, hBoxBoton);

        Scene miScene = new Scene(finalVBox, 800, 600);

        primaryStage.setTitle("Pedido de pizza");
        primaryStage.setScene(miScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void accionClick() {
        String mensaje = "***PEDIDO***\n";
        mensaje += "CLIENTE\n";
        mensaje += "Nombre: " + txtNombre.getText() + " Telefono: " + txtTelefono.getText() + " Dirección:" + txtDireccion.getText() + "\n";
        mensaje += "PIZZA" + "\n";

        // Obtener el valor seleccionado del RadioButton de medida
        RadioButton seleccionMedida = (RadioButton) medidaPizza.getSelectedToggle();
        String medidaSeleccionada = seleccionMedida.getText();
        //System.out.println("Medida seleccionada: " + medidaSeleccionada);

        // Obtener el valor seleccionado del RadioButton de masa
        RadioButton seleccionMasa = (RadioButton) masaPizza.getSelectedToggle();
        String masaSeleccionada = seleccionMasa.getText();
        mensaje += "Masa seleccionada: " + masaSeleccionada + "\n";

        // Obtener los ingredientes seleccionados
        List<String> ingredientesSeleccionados = new ArrayList<>();

        for (CheckBox checkBox : ingredientesCheckBoxList) {
            if (checkBox.isSelected()) {
                ingredientesSeleccionados.add(checkBox.getText());
            }
        }

        // Mostrar ingredientes seleccionados
        mensaje += "Ingredientes seleccionados: " + ingredientesSeleccionados + "\n";

        VentanaEmergente.mostrar(mensaje, "Tu Pedido");

    }

}
