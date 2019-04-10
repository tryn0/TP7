import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;


public class graf extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    //Cartel de bienvenido
    Label bienvenido = new Label("BIENVENIDO");
    bienvenido.setStyle(
                "-fx-font-size: 75px;"
      );
    bienvenido.setLayoutX(35);
    bienvenido.setLayoutY(175);
    //Nombre de la tienda, que aparece en la esquina inferior derecha
    Label nombretienda = new Label ("Fruteria Robert y Guille    @Copyright");
    nombretienda.setLayoutX(300);
    nombretienda.setLayoutY(480);
    //boton que cubre el color de fondo, que se ira agrandando
    Button btn = new Button();
    btn.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 3px; " +
                "-fx-min-height: 3px; " +
                "-fx-max-width: 1000px; " +
                "-fx-max-height: 1000px;" +
                "-fx-background-color: lightblue;"
      );
    //boton para comprar
    Button comprar=new Button("Comprar");
    comprar.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 200px; " +
                "-fx-max-height: 200px;" +
                "-fx-background-color: #98ff61;"+
                "-fx-font-family: Impact;"+
                 "-fx-font-size: 18px;"+
                 "-fx-border-color:black;"+
                 "-fx-border-radius:5em;"
      ); 

    comprar.setLayoutX(-400);
    comprar.setLayoutY(200);
     comprar.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            {
            	try {
            	 
            	Image producto1 = new Image(new FileInputStream("peras.jpg"));
            	ImageView peras = new ImageView(producto1); 
    			peras.setLayoutX(35);
    			peras.setLayoutY(60);
    			peras.setFitHeight(75);
    			peras.setFitWidth(75);

    			Label nombrePeras = new Label("PERAS");
    			  nombrePeras.setStyle(
                "-fx-font-size: 25px;"+
                "-fx-font-family: Impact;"
      			);
    			nombrePeras.setLayoutX(120);
   				nombrePeras.setLayoutY(55);

    			Spinner<Integer> perasSpinner = new Spinner<>(0, 1000, 0, 1);
				SpinnerValueFactory.IntegerSpinnerValueFactory perasFactory = (SpinnerValueFactory.IntegerSpinnerValueFactory) perasSpinner.getValueFactory();
				int imin1 = perasFactory.getMin(); // 0
				int imax1 = perasFactory.getMax(); // 10
				int istep1 = perasFactory.getAmountToStepBy(); // 1
				perasSpinner.setLayoutX(120);
				perasSpinner.setLayoutY(100); 
				perasSpinner.setPrefWidth(60);
 	
            	Image producto2 = new Image(new FileInputStream("sandias.jpg"));
            	ImageView sandias = new ImageView(producto2); 
    			sandias.setLayoutX(290);
    			sandias.setLayoutY(60);
    			sandias.setFitHeight(75);
    			sandias.setFitWidth(75);

    			Label nombreSandias = new Label("SANDIAS");
    			  nombreSandias.setStyle(
                "-fx-font-size: 25px;"+
                "-fx-font-family: Impact;"
      			);
    			nombreSandias.setLayoutX(375);
   				nombreSandias.setLayoutY(55);

    			Spinner<Integer> sandiasSpinner = new Spinner<>(0, 1000, 0, 1);
				SpinnerValueFactory.IntegerSpinnerValueFactory sandiasFactory = (SpinnerValueFactory.IntegerSpinnerValueFactory) sandiasSpinner.getValueFactory();
				int imin2 = sandiasFactory.getMin(); // 0
				int imax2 = sandiasFactory.getMax(); // 1000
				int istep2 = sandiasFactory.getAmountToStepBy(); // 1
				sandiasSpinner.setLayoutX(375);
				sandiasSpinner.setLayoutY(100); 
				sandiasSpinner.setPrefWidth(60);
            	Group group2a= new Group(peras,nombrePeras,perasSpinner,sandias,nombreSandias,sandiasSpinner);






				Image producto3 = new Image(new FileInputStream("mangos.jpg"));
            	ImageView mangos = new ImageView(producto3); 
    			mangos.setLayoutX(290);
    			mangos.setLayoutY(180);
    			mangos.setFitHeight(75);
    			mangos.setFitWidth(75);

    			Label nombreMangos = new Label("MANG0S");
    			  nombreMangos.setStyle(
                "-fx-font-size: 25px;"+
                "-fx-font-family: Impact;"
      			);
    			nombreMangos.setLayoutX(375);
   				nombreMangos.setLayoutY(175);


    			Spinner<Integer> mangosSpinner = new Spinner<>(0, 1000, 0, 1);
				SpinnerValueFactory.IntegerSpinnerValueFactory mangosFactory = (SpinnerValueFactory.IntegerSpinnerValueFactory) mangosSpinner.getValueFactory();
				int imin3 = mangosFactory.getMin();
				int imax3 = mangosFactory.getMax();
				int istep3 = mangosFactory.getAmountToStepBy();
				mangosSpinner.setLayoutX(375);
				mangosSpinner.setLayoutY(220); 
				mangosSpinner.setPrefWidth(60);

            	Group group2= new Group(group2a,mangos,nombreMangos,mangosSpinner);
            	Scene scene2 = new Scene(group2,500,500,Color.LIGHTBLUE);
                primaryStage.setScene(scene2);
                primaryStage.show();
                }
                catch(Exception ex) {
     				 System.out.println("Error, no se encuentra la imagen.");
    			}
            }
        });     
    //boton para consultar
    Button consultar=new Button("Consultar");
    consultar.setStyle(
                "-fx-background-radius: 6em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 200px; " +
                "-fx-max-height: 200px;" +
                "-fx-background-color: #f5d273;"+
                "-fx-font-family: Impact;"+
                 "-fx-font-size: 18px;"+
                 "-fx-border-color:black;"+
                 "-fx-border-radius:6em;"
      );
    consultar.setLayoutX(200);
    consultar.setLayoutY(800);
    //boton para salir
    Button salir = new Button ("Salir");
    salir.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 200px; " +
                "-fx-max-height: 200px;" +
                "-fx-background-color: #f27474;"+
                "-fx-font-family: Impact;"+
                 "-fx-font-size: 18px;"+
                 "-fx-border-color:black;"+
                 "-fx-border-radius:5em;"
        );
    salir.setLayoutX(800);
    salir.setLayoutY(200);
    //grupos donde se guardan todas las variables
    Group group = new Group(btn,bienvenido,nombretienda,comprar,consultar,salir);
    //escenas
    Scene scene = new Scene(group, 500, 500);
    //TRANSICCIONES
    //transiccion del boton de fondo
    Duration duration = Duration.millis(3000);
    ScaleTransition scaleTransition = new ScaleTransition(duration, btn);
    scaleTransition.setByX(100);
    scaleTransition.setByY(100);
    scaleTransition.play();
    //transiccion del cartel de bienvenido
    Duration duration2 = Duration.millis(3000);
    TranslateTransition transition = new TranslateTransition(duration2, bienvenido);
    transition.setByY(-175);
    transition.play();
    //transiccion de botones
        Duration duration3 = Duration.millis(4000);
        TranslateTransition transitionconsultar = new TranslateTransition(duration3, consultar);
        transitionconsultar.setByY(-450);
        transitionconsultar.play();
        TranslateTransition transitionsalir = new TranslateTransition(duration3, salir);
        transitionsalir.setByX(-450);
        transitionsalir.play();
        TranslateTransition transitioncomprar = new TranslateTransition(duration3, comprar);
        transitioncomprar.setByX(450);
        transitioncomprar.play();
    //set de la escena, y mostrar
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
  public static void main(String[] args) {
    Application.launch(args);
  }
}