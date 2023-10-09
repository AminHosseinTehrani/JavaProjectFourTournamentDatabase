package com.example.amindesmond_comp228lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Text;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn s_gameName_column;
    @FXML
    private TableColumn s_gameId_column;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField postalCodeTextField;
    @FXML
    private TextField provinceTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField gameIDTextField;
    @FXML
    private TextField gameTitleTextField;

    @FXML
    private TextField dateTextField;
    @FXML
    private TextField scoreTextField;

    @FXML
    private TextField playerIDTextField;

    @FXML
    private Button submitPlayerInfoButton;

    @FXML
    private Button submitGameInfoButton;
    @FXML
    private Button  editPlayerInfoButton;

    @FXML
    private ComboBox gameListComboBox;


    private ResultSet set;

    CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();

    ResultSet tabledata = DBUtil.query("select * from Game");
    ObservableList<Game> games = FXCollections.observableArrayList();


    private   ObservableList<String> comboBoxText;


    private String[]  list;

    public Controller() throws SQLException {






    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }





    public void OnSubmitPlayerInfo(ActionEvent actionEvent) {

        firstNameTextField.getText();
       lastNameTextField.getText();
        addressTextField.getText();
        postalCodeTextField.getText();
        provinceTextField.getText();
        phoneNumberTextField.getText();
        IDTextField.getText();
        gameIDTextField.getText();



        // database code
    }

    public void OnSubmitGameInfo(ActionEvent actionEvent) throws SQLException {

String[] gameInfo = new String[] {gameIDTextField.getText(),   gameTitleTextField.getText() };












     DBUtil.insertGameData(gameIDTextField.getText(),gameTitleTextField.getText());
        //database code
    }

    public void OnEditPlayerInfo(ActionEvent actionEvent) {


        //  DBUtil.insertData("gameTable",gameInfo);


    }

    public void OnEditGameInfo(ActionEvent actionEvent) throws SQLException {

        DBUtil.updateGameData(gameIDTextField.getText(),gameTitleTextField.getText());


    }

    public void OnGameListItemClicked(ActionEvent actionEvent) throws SQLException {

//        while (tabledata.next()){
//            list[0] =      tabledata.getString("game_id");
//             list[1] =       tabledata.getString("game_title");
//
//}

//
//        while(set.next()){
//            int index = 0;
//            String val = set.getString(index);
//            list[index] = val;
//        }









        System.out.println();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ResultSetMetaData rsmd = null;

        try {
            set = DBUtil.query("SELECT * FROM Game" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            crs.populate(set);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rsmd = set.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        try {
//
//            int column_count =   Integer.parseInt( DBUtil.query("SELECT COUNT(*) FROM Game").getMetaData().toString());
//            list  = new String[column_count];
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        int b = 0;


        try {
            set.beforeFirst();
            while(set.next()) {
Game game = new Game();
game.setGame_id(set.getString("game_id"));
game.setGame_title(set.getString("game_title"));
games.add(game);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


      s_gameName_column.setCellValueFactory(new PropertyValueFactory("game_title")); //name of Student attribute "name"
      s_gameId_column.setCellValueFactory(new PropertyValueFactory("game_id")); // name of student attribute "id"

        //clear table before adding new records
       table.getItems().clear();

        // add data to the table
      table.getItems().addAll(games);

        // sort the table by student id
   s_gameId_column.setSortType(TableColumn.SortType.ASCENDING);
    table.getSortOrder().add(s_gameId_column);
    table.sort();

        comboBoxText  = FXCollections.observableArrayList();



   for(int i = 0; i<= games.size()-1; i+=1) {

     System.out.println(games.get(i).getGame_id());
  }

  // comboBoxText = FXCollections.observableArrayList( list);


        gameListComboBox.setItems(comboBoxText);

    }



}