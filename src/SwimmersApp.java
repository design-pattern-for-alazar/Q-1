import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/*The main JavaFx class, the Application*/
public class SwimmersApp extends Application {

    SwimmersData dataOriginal = new SwimmersData();
    SwimmersData dataClone=null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Swimmers Data");
        //Create the Layout
        VBox root = new VBox();
        root.setPrefWidth(1100.0);
        root.setPadding(new Insets(1));
        Scene scene = new Scene(root);
        HBox listBox = new HBox();
        HBox sortOpt = new HBox(5);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton sex = new RadioButton("Sex");
        RadioButton  age = new RadioButton("Age");
        RadioButton  time = new RadioButton("Time");

        sex.setToggleGroup(toggleGroup);
        age.setToggleGroup(toggleGroup);
        time.setToggleGroup(toggleGroup);

        Text sortText = new Text("Sorting by age group");

        final ObservableList<Swimmer> observableList = FXCollections.observableArrayList(dataOriginal.getSwimmers().toArray(new Swimmer[]{}));
        ObservableList<Swimmer> observableListOrg = FXCollections.observableArrayList(dataOriginal.getSwimmers().toArray(new Swimmer[]{}));

        ListView<Swimmer> listView = new ListView<>(observableListOrg);
        ListView<Swimmer> listViewL = new ListView<>(observableList);
        listView.setPrefWidth(550);
        listViewL.setPrefWidth(550);

        listViewL.setEditable(true);

        //Listen for changes in the radio buttons
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
            sortText.setText("Sorting by : " + selected.getText());
            if( selected.getText().equalsIgnoreCase("time")){

                //Clone The original data and sort it by time
                ArrayList<Swimmer> arrayListSorted =  sortByTime(dataOriginal).getSwimmers();
                observableList.clear();
                Swimmer[] swimmers = arrayListSorted.toArray(new Swimmer[]{});
                observableList.addAll(swimmers);
            }
            else if( selected.getText().equalsIgnoreCase("age")){
                //Clone The original data and sort it by age
                ArrayList<Swimmer> arrayListSorted =  sortByAge(dataOriginal).getSwimmers();
                observableList.clear();
                observableList.addAll(arrayListSorted.toArray(new Swimmer[]{}));
            }
            else if( selected.getText().equalsIgnoreCase("sex")){
                //Clone The original data and sort it by sex
                ArrayList<Swimmer> arrayListSorted =  sortBySex(dataOriginal).getSwimmers();
                observableList.clear();
                observableList.addAll(arrayListSorted.toArray(new Swimmer[]{}));
            }
        });

        //Add the radio buttons to their parent containers
        sortOpt.getChildren().add(sex);
        sortOpt.getChildren().add(time);
        sortOpt.getChildren().add(age);
        sortOpt.setPadding(new Insets(20));

        listBox.getChildren().add(listViewL);
        listBox.getChildren().add(listView);

        root.getChildren().add(sortOpt);
        root.getChildren().add(sortText);
        root.getChildren().add(listBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Clones The original data and sorts the new cloned data by sex
    public SwimmersData sortBySex(SwimmersData swimmersData){
        if ( dataClone == null){
            //Data not cloned yet
            try {
                dataClone = (SwimmersData) swimmersData.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        dataClone.swimmers.sort((o1, o2) -> {
            if( o1.sex < o2.sex){
                return -1;
            }
            else if(o1.sex < o2.sex){
                return 1;
            }
            return 0;
        });
        return dataClone;
    }

    //Clones The original data and sorts the new cloned data by Time
    public SwimmersData sortByTime(SwimmersData swimmersData){
        if ( dataClone == null){
            //Data not cloned yet
            try {
                dataClone = (SwimmersData) swimmersData.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        dataClone.swimmers.sort((o1, o2) -> {
            if( o1.time < o2.time){
                return -1;
            }
            else if(o1.time < o2.time){
                return 1;
            }
            return 0;
        });
        return dataClone;

    }

    //Clones The original data and sorts the new cloned data by sex
    public  SwimmersData sortByAge(SwimmersData swimmersData){
        if ( dataClone == null){
            //Data not cloned yet
            try {
                dataClone = (SwimmersData) swimmersData.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        dataClone.swimmers.sort((o1, o2) -> {
            if( o1.age < o2.age){
                return -1;
            }
            else if(o1.age < o2.age){
                return 1;
            }
            return 0;
        });
        return dataClone;
    }
}
