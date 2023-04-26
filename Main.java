
package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Main extends Application{
    @Override
    public void start(Stage stage2) throws FileNotFoundException{
        Image image = new Image(new FileInputStream("C:\\Users\\وسام\\Downloads\\download.png"));
        ImageView imageview = new ImageView(image);
        imageview.setX(227);
        imageview.setY(14);
        imageview.setFitWidth(146);
        imageview.setFitHeight(100);
      
        Text intro = new Text("Welcom to the school system, choose the service you need ");
        intro.setLayoutX(142);
        intro.setLayoutY(139);
        
      /*  Button techer= new Button("Teacher");
        techer.setLayoutX(142);
        techer.setLayoutY(160);
        */
        Button stuinfo = new Button("Student info.");
        stuinfo.setLayoutX(250);
        stuinfo.setLayoutY(284);
        
        Button add= new Button("Add a student");
        add.setLayoutX(250);
        add.setLayoutY(217);
         Pane pane = new Pane();
        pane.getChildren().addAll(imageview,intro,add,stuinfo);
      Scene set = new Scene(pane,600,400);
        stage2.setScene(set);
        stage2.setTitle("Main");
        stage2.show();  
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        stuinfo.setOnAction(e->{
            try {
                //////////////////////////////////////////////stu info
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/System","Hr","hr");
                Statement st = con.createStatement();
                
                Label id= new Label("Enter Id");
        id.setLayoutX(63);
        id.setLayoutY(58);
        TextField idt= new TextField();
        idt.setLayoutX(66);
        idt.setLayoutY(94);
        
         Text idd= new Text();
     Text naned= new Text();
     Text dobd = new Text();
     Text genderd = new Text();
     Text techd = new Text();
     Text edd = new Text();
     Text locd = new Text();
     Text pasd = new Text();
              ///main buttom  
     Button submit = new Button("Submit");
        submit.setLayoutX(256);
        submit.setLayoutY(94);
        Button signout= new Button ("Sign out");
        signout.setLayoutX(256);
        signout.setLayoutY(145);
        //seconf scene buttom
        submit.setOnAction(g->{
            try {
                
                 String idn = idt.getText().toString();
                String sql = "select * from STRUDENTS where ID='"+idn+"'";
                ResultSet rs= st.executeQuery(sql);
                rs.next();
          idd.setText("ID: "+ rs.getString(1));
          idd.setLayoutX(66);
          idd.setLayoutY(260);
         
          naned.setText("Name: "+rs.getString(2));
          naned.setLayoutX(66);
          naned.setLayoutY(296);
          
          dobd.setText("Date of birth: "+ rs.getString(3));
          dobd.setLayoutX(66);
          dobd.setLayoutY(328);
          
          genderd.setText("Gender: "+rs.getString(4));
          genderd.setLayoutX(66);
          genderd.setLayoutY(360);
          
          techd.setText("Technology knoledge: "+ rs.getString(5));
          techd.setLayoutX(271);
          techd.setLayoutY(259);
          
          edd.setText("Educational level: "+ rs.getString(6));
          edd.setLayoutX(271);
          edd.setLayoutY(296);
          
          locd.setText("City: "+rs.getString(7));
locd.setLayoutX(271);
locd.setLayoutY(327);
            } catch (SQLException ex) {
                Logger.getLogger(AdminS.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        signout.setOnAction(d->{
        stage2.setScene(set);
        });
         Pane ad = new Pane();
        ad.getChildren().addAll(id,idt,idd,naned,dobd,genderd,techd,edd,locd,pasd,submit,signout);
                
                 Scene scene = new Scene(ad,600,400);
        stage2.setScene(scene);
        stage2.setTitle("Student");
        stage2.show();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        add.setOnAction(a->{
        //Name label
        Label Nlabel = new Label("Name");
        //Name text-field
        TextField Ntextfield = new TextField();
        Ntextfield.setPromptText("Enter");

        //

        //ID label
        Label IDnum= new Label("ID/national number");
        //ID text-field
        TextField Idfield= new TextField();
        Idfield.setPromptText("Enter");
        //Date of birth label
        Label DOBlabel = new Label("Date of birth");
        //Date-picker to chose date
        DatePicker datePicker= new DatePicker();
        //
        //Label for gender
        Label Glabel = new Label("Gender");
        //Set the radio buttons for gender
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(toggleGroup);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(toggleGroup);

        //
        //Knowledge label
        Label Klabel = new Label("Technologies known");
       // Checkbox for tech
        CheckBox java= new CheckBox("java");
        CheckBox cplus = new CheckBox("C++");
       //
       //Educational label
        Label edq= new Label("Educational qualification");
        //list view for EQ
        ListView listView = new ListView<>();
        ObservableList data2 = FXCollections.observableArrayList();
        data2.addAll("Bachelor","Php","master's","Plus 2");
        listView.setItems(data2);
        listView.setPrefSize(100,100);
        //

        //label for location
        Label location = new Label("Location");
        //choice box for location
        ChoiceBox<Object> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Amman","Al-Salt","Al-Zarqa'a","Outside Jordan");

        //label for pass
        Label passwordw = new Label("Password");
        //text field for pss
        PasswordField password = new PasswordField();
        password.setPromptText("Enter");


        // Button of register
        Button reg= new Button("Register");
        //Button to singout
        Button out= new Button("sign out");
        //Action of button
        reg.setOnAction(k ->{
            try {
                 Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/System","Hr","hr");
        Statement ST =con.createStatement();
                String st_insert ="insert into STRUDENTS(ID,Name,DOB,GENDER,TECHNO,EDUC,CITY,PASS) values(?,?,?,?,?,?,?,?)";
                PreparedStatement perp= con.prepareStatement(st_insert);
               //ID
                perp.setString(1, Idfield.getText());
                //Nmae
                perp.setString(2, Ntextfield.getText());
                //DOB
                perp.setString(3, datePicker.getValue().toString());
                //gender
                if (male.isSelected()) {
                    perp.setString(4, male.getText());
                }else{
                    perp.setString(4, female.getText());
                }
                //Techco
                if (java.isSelected()&&cplus.isSelected()) {
                    perp.setString(5,java.getText()+"&"+cplus.getText() );
                }else if (java.isSelected()) {
                    perp.setString(5, java.getText());
                }else if (cplus.isSelected()) {
                    perp.setString(5, cplus.getText());
                }else{
                    perp.setString(5, "None");
                }
                //Educational
               perp.setString(6, listView.getSelectionModel().getSelectedItem().toString());
                //city
                perp.setString(7, choiceBox.getValue().toString());
                //pasword
                perp.setString(8, password.getText());
                perp.executeUpdate();
                
                Idfield.deleteText(0, Idfield.getText().length());
                Ntextfield.deleteText(0,Ntextfield.getText().length());
                datePicker.getEditor().clear();
                male.setSelected(false);
                female.setSelected(false);
                java.setSelected(false);
                cplus.setSelected(false);
                password.deleteText(0, password.getText().length());
                JOptionPane.showMessageDialog(null, "Registration successful!");
                System.out.println("One data was added");
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationS.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
     out.setOnAction(h->{
     stage2.setScene(set);
     });
        
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(7);
        gridPane.setVgap(7);
        gridPane.add(Nlabel,0,0);
        gridPane.add(Ntextfield,1,0);

        gridPane.add(DOBlabel,0,1);
        gridPane.add(datePicker,1,1);

        gridPane.add(Glabel,0,2);
        gridPane.add(male,1,2);
        gridPane.add(female,2,2);

        gridPane.add(Klabel,0,3);
        gridPane.add(java,1,3);
        gridPane.add(cplus,2,3);

        gridPane.add(edq,0,4);
        gridPane.add(listView,1,4);

        gridPane.add(location,0,5);
        gridPane.add(choiceBox,1,5);

        gridPane.add(passwordw,0,6);
        gridPane.add(password,1,6);

        gridPane.add(IDnum,0,7);
        gridPane.add(Idfield,1,7);

        gridPane.add(reg,2,4);
        gridPane.add(out,2,5);
        
        Scene scene = new Scene(gridPane,500,300);
        stage2.setScene(scene);
        stage2.setTitle("Registration");
        stage2.show();
          });
        
        
        
        
        
       
         
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
