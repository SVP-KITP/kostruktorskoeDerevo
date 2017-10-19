package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import sample.TreeViewHelper;

public class Controller {

    @FXML
    TreeView tView;
    @FXML
    TextArea tArea;
    @FXML
    TextField tField;
    @FXML
    ListView lView;
@FXML
        TextField tFieldEdit;
@FXML
        Button btnEdit;
@FXML
        Button btnOpen;
@FXML
        Button btnSave;
    @FXML
    Button btnPrepare;

    public static Path path;
    public Stage stage;
    public File file ;
    @FXML
    private void initialize() throws URISyntaxException {
        try {


            path = Paths.get(Main.class.getResource(".").toURI());
            tField.setText(path.getParent().toString() + "\\file.xls");
        } catch (Exception e) {
            //  path=Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
            //  path=new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent());
            path = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            tField.setText(new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent() + "\\file.xls");
        }
    }


    @FXML
    private void handleOpen() throws URISyntaxException {
        path = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
      //   path = Paths.get(Main.class.getResource(".").toURI());

        FileChooser fileChooser = new FileChooser();

        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XLS files (*.xls)", "*.xls");
        fileChooser.getExtensionFilters().add(extFilter);

        // Показываем диалог загрузки файла
        file = fileChooser.showOpenDialog( stage);


        //   l=file.getAbsolutePath().toString();
        try {
            tField.setText(file.getAbsolutePath().toString());
            btnOpen.setTextFill(Color.GREEN);
        } catch (Exception e){
           tField.setText("Файл не выбран");
            btnOpen.setTextFill(Color.DARKRED);
        }


    }



    @FXML
    public void handleClose() {
        //Platform.exit();
        System.exit(0);
    }

    private final Node rootIcon =  new ImageView(new Image(getClass().getResourceAsStream("root.png")));
    TreeViewHelper helper;

    @FXML
    public void handlePrepare() throws URISyntaxException {
        try {

            System.out.println("1");
         helper = new TreeViewHelper(tField.getText());
            System.out.println("2");
        ArrayList<TreeItem> products = helper.getProducts();
            System.out.println("3");
        TreeItem rootItem = new TreeItem("11Т1ОР56ГО", rootIcon);

            System.out.println("4");
        rootItem.getChildren().addAll(products);
        tView.setEditable(true);

        tView.setRoot(rootItem);
            btnPrepare.setTextFill(Color.GREEN);
            System.out.println("5");
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Информацио об открытии файла");
            alert.setHeaderText("Файл НЕ НАЙДЕН");
            alert.setContentText("Укажите верный путь!");

            alert.showAndWait();
            btnPrepare.setTextFill(Color.DARKRED);
            //tView=null;


        }
    }


    @FXML
    private void handleSootv(){

    }


String st;
    @FXML
    private void handleTest(){
      /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Руководство пользователя");
        alert.setHeaderText("Руководство пользователя можете найти в файле Readme.doc");
        alert.setContentText("Приятной работы!");

        alert.showAndWait();*/

       // lView.setEditable(true);
        st=tView.getEditingItem().getValue().toString();
        System.out.println(st);
        //lView.setItems(helper.getCollect(tView.getEditingItem().getValue().toString()));
        //lView.se
        tArea.setEditable(true);
    //    tArea.setText(String.valueOf(helper.getCollect(tView.getEditingItem().getValue().toString())));
        tArea.setText(String.valueOf(helper.getCollect(st)));
        tFieldEdit.setText(st);
        btnEdit.setDisable(false);

    }




     @FXML
    private void handleEditXLS(){


        btnSave.setDisable(false);
         System.out.println(tFieldEdit.getText());
        helper.getEdit(st,tFieldEdit.getText());
         tView.getEditingItem().setValue(tFieldEdit.getText());
    }

     @FXML
    private void handleSave() throws IOException {


        helper.saveXLS();

       Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Информация");
        alert.setHeaderText("Успешно сохранено");
        alert.setContentText("Приятной работы!");

        alert.showAndWait();
    }






    @FXML
    private void handleWinRazrab(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Руководство пользователя");
        alert.setHeaderText("Руководство пользователя можете найти в файле Readme.doc");
        alert.setContentText("Приятной работы!");

        alert.showAndWait();
    }


    @FXML
    private void handleWinAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Информацио разработчике");
        alert.setHeaderText("Программа разработана студентом группы АМ-131з\n Нкифоров\n Максим\n Владимирович");
        alert.setContentText("Приятной работы!");

        alert.showAndWait();
    }
}
