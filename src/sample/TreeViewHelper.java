package sample;

/**
 * Created by vzhop on 14.06.2017.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import sample.Controller;

public class TreeViewHelper
{


    //для EXCELL
    public FileInputStream fis2;
    public Workbook wb2;
    Sheet sheet2;
    Sheet sheet_Sootv;
    Sheet sheet_Sootv1;

    ArrayList<String> arrayList;
    Map<String,String> map;
    Cell cell1;
    Cell c11;
    String splitString="";

    StringBuilder sb,sb_new;
    String s = "";
    int maxSplit = 0;
    int mSplit = 0;

    char charSplit=',';
    int lenghtCell=0;
    double k=0.0;

    public String stringFilePath="";








    public TreeViewHelper(String ss) throws URISyntaxException

    {
        // = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
       // Path path = Paths.get(Main.class.getResource(".").toURI());
        //stringFilePath = sample.Controller.path.getParent().toString()+ "\\file.xls";
        stringFilePath=ss;

        try {



            //Для Операций
            //       String fileName="oper_new.xls";
//        FileInputStream fis2 = new FileInputStream(fileName);

            //Для Трудоемксости
            //String fileName1="file.xls";
            fis2 = new FileInputStream(stringFilePath);

            // FileInputStream fis1New = new FileInputStream("Tree_new.xls");

            //    Workbook wb1New = WorkbookFactory.create(fis1New);
            wb2 = new HSSFWorkbook(fis2);


            sheet2 = wb2.getSheetAt(0);
            //  FindDubl fd = new FindDubl();
            StringBuilder sb,sb_new;
            String s = "";
            //Заполняем список соответствия
           sheet_Sootv = wb2.getSheetAt(1);
          //  sheet_Sootv1 = wb2.getSheet("Лист1");
            arrayList=new ArrayList<>();
            map =new HashMap<String,String>();

            //Ячейка соответствия
            // Cell cell1;
            //  Cell c11;
            //  s=sheet_Sootv.getRow(1).getCell(0).getStringCellValue();





            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информацио об открытии файла");
            alert.setHeaderText("Файл успешно загружен в систему");
            alert.setContentText("Можете начинать преобразовывать!");

            alert.showAndWait();
       //     lbEX.setText("Файл готов для преобразования");
         //   lbEX.setTextFill(Color.GREEN);
        }
        catch (Exception e){
     //       Alert alert = new Alert(Alert.AlertType.INFORMATION);
         //   alert.setTitle("Информацио об открытии файла");
         ///   alert.setHeaderText("Файл успешно загружен в систему");
         //   alert.setContentText("Можете начинать преобразовывать!");

            //   lbEX.setText("Ошибка загрузки!");
         //   lbEX.setTextFill(Color.DARKRED);
        }

    }

    private final Image depIcon =  new Image(getClass().getResourceAsStream("map.png"));

    // This method creates an ArrayList of TreeItems (Products)
    public ArrayList<TreeItem> getProducts()
    {


        ArrayList<TreeItem> products = new ArrayList<TreeItem>();
        /*1
        System.out.println("1");*/

int l=4;
        for (Row row : sheet2) {
            //System.out.println( row.getLastCellNum());


            for (Cell cell : row) {

                if (cell.getColumnIndex() == 1) {
                    if (cell.getStringCellValue().equals("")) {

                    } else {

                        if (cell.getCellTypeEnum() != CellType.STRING) {
                            cell.setCellType(CellType.STRING);
                        }


                        TreeItem detal = new TreeItem(cell.getStringCellValue(),  new ImageView(depIcon));
                        detal.getChildren().addAll(getColl(2, l));
l=l+4;
                        System.out.println("l"+l);

                        products.add(detal);
                    }


                }
            }
        }



/*
        TreeItem detal = new TreeItem("2");



        detal.getChildren().addAll(getColl(1));


        products.add(detal);
        products.add(detal);

       //detal.getChildren().addAll(getColl(2));
        
        


        
        /*4
        System.out.println("4");*/

       // detal.getChildren().addAll(getCars());
       // sheet2.getLastRowNum();

       /* for (Row row : sheet2) {
            //System.out.println( row.getLastCellNum());


            for (Cell cell : row) {



                    if (cell.getCellTypeEnum() != CellType.STRING) {
                        cell.setCellType(CellType.STRING);
                    }




                }
            }

*/


        /*

        TreeItem cars = new TreeItem("Cars");
        cars.getChildren().addAll(getCars());

        TreeItem buses = new TreeItem("Buses");
        buses.getChildren().addAll(getBuses());

        TreeItem trucks = new TreeItem("Trucks");
        trucks.getChildren().addAll(getTrucks());

        TreeItem motorbikes = new TreeItem("Motorcycles");
        motorbikes.getChildren().addAll(getMotorcycles());


        products.add(cars);
        products.add(buses);
        products.add(trucks);
        products.add(motorbikes);

*/


        return products;
    }


    private ArrayList<TreeItem> getColl(int i,int j)
    {



        int k=0;

        ArrayList<TreeItem> det= new ArrayList<TreeItem>();
        for (Row row : sheet2) {
            if (row.getRowNum()>=(j-4) & (row.getRowNum()<=j))
            {
            for (Cell cell : row) {

                Row r=row;
                Cell c;
               // System.out.println("1233");
            //    System.out.println(cell.getColumnIndex()-1);
                if (k!=j) {
                  //  c=r.getCell(cell.getColumnIndex()-1);


                if (cell.getColumnIndex() == i) {
                    if (cell.getStringCellValue().equals("")) {

                    } else {
                        //System.out.println(c.getStringCellValue());
                       // if (c.getStringCellValue().equals("")) {
                            if (cell.getCellTypeEnum() != CellType.STRING) {
                                cell.setCellType(CellType.STRING);
                            }

                            det.add(new TreeItem(cell.getStringCellValue()));
                        k++;
                            // }
                        }//}
                    }
                }


            }
        }
        }
    return det;
    }



    public StringBuilder getCollect(String s) {

StringBuilder poddet = new StringBuilder(s+" \nПараметры:");
       // ArrayList<String> poddet= new ArrayList<String>();
        for (Row row : sheet_Sootv) {

            for (Cell cell : row) {
                if (cell.getColumnIndex() == 0) {
                    if (cell.getStringCellValue().equals(s)){

                        poddet.append(row.getCell(1).getStringCellValue());
                        poddet.append("\n");
                        poddet.append(row.getCell(2).getStringCellValue());
                        poddet.append("\n");
                        poddet.append(row.getCell(3).getStringCellValue());

                    }


                }
            }
        }



        return  poddet;
    }

    public void getEdit(String s1, String s2) {


        for (Row row : sheet2)

            for (Cell cell : row)
                if (cell.getStringCellValue().equals(s1))
                    cell.setCellValue(s2);

        for (Row row : sheet_Sootv)

            for (Cell cell : row)
                if (cell.getStringCellValue().equals(s1))
                    cell.setCellValue(s2);



    }

    public void saveXLS () throws IOException {
        FileOutputStream fileOut = new FileOutputStream(stringFilePath);
        wb2.write(fileOut);
        fileOut.close();
        fis2.close();


    }



}
