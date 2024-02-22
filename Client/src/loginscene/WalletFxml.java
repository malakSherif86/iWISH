package loginscene;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static loginscene.LoginScene.ps;
import static loginscene.LoginScene.dis;

public class WalletFxml extends AnchorPane {
   

private Parent root;
    private Stage stage;
    private Scene scene;
    
    
    
  
   
    protected final BorderPane currentbalance;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ImageView imageView;
    protected final VBox vBox0;
    protected final HBox hBox0;
    protected final ImageView imageView0;
    protected final Button button;
    protected final HBox hBox1;
    protected final ImageView imageView1;
    protected final Button button0;
    protected final HBox hBox2;
    protected final ImageView imageView2;
    protected final Button button1;
    protected final HBox hBox3;
    protected final ImageView imageView3;
    protected final Button button2;
    protected final HBox hBox4;
    protected final ImageView imageView4;
    protected final Button button3;
    protected final HBox hBox5;
    protected final ImageView imageView5;
    protected final Button button4;
    protected final HBox hBox6;
    protected final ImageView imageView6;
    protected final Button button5;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final TextField EnterMoneyTextField;
    protected final Button EnterMoneyBTN;
    protected final Label label2;
    protected final Label label3;
    protected final Label currentBalanceLebel;

    public WalletFxml() {
        
        

        currentbalance = new BorderPane();
        vBox = new VBox();
        hBox = new HBox();
        imageView = new ImageView();
        vBox0 = new VBox();
        hBox0 = new HBox();
        imageView0 = new ImageView();
        button = new Button();
        hBox1 = new HBox();
        imageView1 = new ImageView();
        button0 = new Button();
        hBox2 = new HBox();
        imageView2 = new ImageView();
        button1 = new Button();
        hBox3 = new HBox();
        imageView3 = new ImageView();
        button2 = new Button();
        hBox4 = new HBox();
        imageView4 = new ImageView();
        button3 = new Button();
        hBox5 = new HBox();
        imageView5 = new ImageView();
        button4 = new Button();
        hBox6 = new HBox();
        imageView6 = new ImageView();
        button5 = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        EnterMoneyTextField = new TextField();
        EnterMoneyBTN = new Button();
        label2 = new Label();
        label3 = new Label();
        currentBalanceLebel = new Label();

        setId("AnchorPane");
        setPrefHeight(813.0);
        setPrefWidth(810.0);

        AnchorPane.setBottomAnchor(currentbalance, 0.0);
        AnchorPane.setLeftAnchor(currentbalance, 0.0);
        AnchorPane.setTopAnchor(currentbalance, 0.0);
        currentbalance.setLayoutX(-2.0);
        currentbalance.setLayoutY(1.0);
        currentbalance.setPrefHeight(813.0);
        currentbalance.setPrefWidth(810.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(780.0);
        vBox.setPrefWidth(170.0);
        vBox.setSpacing(60.0);
        vBox.setStyle("-fx-background-color: #d2f8d2;");

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(170.0);

        imageView.setFitHeight(51.0);
        imageView.setFitWidth(128.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
       // imageView.setImage(new Image(getClass().getResource("../loginscene/Wish-Logo.png").toExternalForm()));

        vBox0.setPrefHeight(401.0);
        vBox0.setPrefWidth(163.0);
        vBox0.setSpacing(13.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(60.0);
        hBox0.setPrefWidth(200.0);

        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(40.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        //imageView0.setImage(new Image(getClass().getResource("../loginscene/1-removebg-preview.png").toExternalForm()));

        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(133.0);
        button.setStyle("-fx-background-color: #d2f8d2;");
        button.setText("Profile");
        button.setFont(new Font("System Bold", 16.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(10.0);
        hBox1.setPrefHeight(60.0);
        hBox1.setPrefWidth(200.0);

        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(40.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
       // imageView1.setImage(new Image(getClass().getResource("../loginscene/friends.png").toExternalForm()));

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(31.0);
        button0.setPrefWidth(133.0);
        button0.setStyle("-fx-background-color: #d2f8d2;");
        button0.setText("Friends");
        button0.setFont(new Font("System Bold", 16.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setLayoutX(10.0);
        hBox2.setLayoutY(156.0);
        hBox2.setPrefHeight(60.0);
        hBox2.setPrefWidth(200.0);

        imageView2.setFitHeight(40.0);
        imageView2.setFitWidth(40.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
       // imageView2.setImage(new Image(getClass().getResource("../loginscene/notification.png").toExternalForm()));

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(31.0);
        button1.setPrefWidth(133.0);
        button1.setStyle("-fx-background-color: #d2f8d2;");
        button1.setText("Notification");
        button1.setFont(new Font("System Bold", 16.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setLayoutX(10.0);
        hBox3.setLayoutY(229.0);
        hBox3.setPrefHeight(60.0);
        hBox3.setPrefWidth(200.0);

        imageView3.setFitHeight(40.0);
        imageView3.setFitWidth(40.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        //imageView3.setImage(new Image(getClass().getResource("../loginscene/Add%20item.png").toExternalForm()));

        button2.setMnemonicParsing(false);
        button2.setPrefHeight(31.0);
        button2.setPrefWidth(133.0);
        button2.setStyle("-fx-background-color: #d2f8d2;");
        button2.setText("Add Item");
        button2.setFont(new Font("System Bold", 16.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox4.setLayoutX(10.0);
        hBox4.setLayoutY(302.0);
        hBox4.setPrefHeight(60.0);
        hBox4.setPrefWidth(200.0);

        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(40.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
   //     imageView4.setImage(new Image(getClass().getResource("../loginscene/wallet.png").toExternalForm()));

        button3.setMnemonicParsing(false);
        button3.setPrefHeight(31.0);
        button3.setPrefWidth(133.0);
        button3.setStyle("-fx-background-color: #d2f8d2;");
        button3.setText("Wallet");
        button3.setFont(new Font("System Bold", 16.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox5.setLayoutX(10.0);
        hBox5.setLayoutY(375.0);
        hBox5.setPrefHeight(60.0);
        hBox5.setPrefWidth(200.0);

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
      //  imageView5.setImage(new Image(getClass().getResource("../loginscene/friend%20wish.png").toExternalForm()));

        button4.setMnemonicParsing(false);
        button4.setPrefHeight(31.0);
        button4.setPrefWidth(133.0);
        button4.setStyle("-fx-background-color: #d2f8d2;");
        button4.setText("Friend wish");
        button4.setFont(new Font("System Bold", 16.0));

        hBox6.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox6.setLayoutX(10.0);
        hBox6.setLayoutY(448.0);
        hBox6.setPrefHeight(60.0);
        hBox6.setPrefWidth(200.0);

        imageView6.setFitHeight(40.0);
        imageView6.setFitWidth(40.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
      //  imageView6.setImage(new Image(getClass().getResource("../loginscene/log%20out.png").toExternalForm()));

        button5.setMnemonicParsing(false);
        button5.setPrefHeight(31.0);
        button5.setPrefWidth(133.0);
        button5.setStyle("-fx-background-color: #d2f8d2;");
        button5.setText("Logout ");
        button5.setFont(new Font("System Bold", 16.0));
        currentbalance.setLeft(vBox);

        BorderPane.setAlignment(label, javafx.geometry.Pos.TOP_LEFT);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label.setPrefHeight(118.0);
        label.setPrefWidth(221.0);
        label.setText("personal");
        label.setFont(new Font("System Italic", 45.0));
        currentbalance.setCenter(label);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label0.setLayoutX(179.0);
        label0.setLayoutY(294.0);
        label0.setPrefHeight(76.0);
        label0.setPrefWidth(531.0);
        label0.setText("please enter the amount you want to add into your balance");
        label0.setFont(new Font(20.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label1.setLayoutX(352.0);
        label1.setLayoutY(10.0);
        label1.setPrefHeight(105.0);
        label1.setPrefWidth(192.0);
        label1.setText("Wallet");
        label1.setFont(new Font("System Bold Italic", 45.0));

        EnterMoneyTextField.setLayoutX(189.0);
        EnterMoneyTextField.setLayoutY(377.0);
        EnterMoneyTextField.setPrefHeight(59.0);
        EnterMoneyTextField.setPrefWidth(192.0);
        EnterMoneyTextField.setPromptText("LE");

        EnterMoneyBTN.setLayoutX(425.0);
        EnterMoneyBTN.setLayoutY(394.0);
        EnterMoneyBTN.setMnemonicParsing(false);
        EnterMoneyBTN.setPrefHeight(34.0);
        EnterMoneyBTN.setPrefWidth(37.0);
        EnterMoneyBTN.setText("+");

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label2.setLayoutX(155.0);
        label2.setLayoutY(145.0);
        label2.setPrefHeight(67.0);
        label2.setPrefWidth(181.0);
        label2.setText("Add to ");
        label2.setFont(new Font("System Bold Italic", 33.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label3.setLayoutX(259.0);
        label3.setLayoutY(147.0);
        label3.setPrefHeight(67.0);
        label3.setPrefWidth(226.0);
        label3.setText("Ur balance");
        label3.setFont(new Font(31.0));

        currentBalanceLebel.setAlignment(javafx.geometry.Pos.CENTER);
        currentBalanceLebel.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        currentBalanceLebel.setLayoutX(287.0);
        currentBalanceLebel.setLayoutY(219.0);
        currentBalanceLebel.setPrefHeight(76.0);
        currentBalanceLebel.setPrefWidth(292.0);
        currentBalanceLebel.setFont(new Font("System Bold Italic", 20.0));

        hBox.getChildren().add(imageView);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(imageView0);
        hBox0.getChildren().add(button);
        vBox0.getChildren().add(hBox0);
        hBox1.getChildren().add(imageView1);
        hBox1.getChildren().add(button0);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(imageView2);
        hBox2.getChildren().add(button1);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(imageView3);
        hBox3.getChildren().add(button2);
        vBox0.getChildren().add(hBox3);
        hBox4.getChildren().add(imageView4);
        hBox4.getChildren().add(button3);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(imageView5);
        hBox5.getChildren().add(button4);
        vBox0.getChildren().add(hBox5);
        hBox6.getChildren().add(imageView6);
        hBox6.getChildren().add(button5);
        vBox0.getChildren().add(hBox6);
        vBox.getChildren().add(vBox0);
        getChildren().add(currentbalance);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(EnterMoneyTextField);
        getChildren().add(EnterMoneyBTN);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(currentBalanceLebel);
       
  
          EnterMoneyBTN.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() 
         {
            @Override
            public void handle(ActionEvent event) {
                
               String enteredAmount = EnterMoneyTextField.getText();
               
               ps.println("updateBalanceReq");
               ps.println(enteredAmount);
                try {
                    String currentBalance = dis.readLine();
                    System.out.println(currentBalance);
                    currentBalanceLebel.setText(currentBalance);
                } catch (IOException ex) {
                    Logger.getLogger(WalletFxml.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
                 EnterMoneyTextField.clear();
            }
        });
     
    button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  HomePageClass();
                    scene = new Scene(root);
                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
            }
        });
    }


}

