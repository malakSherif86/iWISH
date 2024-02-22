package loginscene;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import loginscene.ItemInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

class ImageTableCell extends TableCell<ItemInfo, String> {
    private final ImageView imageView = new ImageView();

    public ImageTableCell() {
        setGraphic(imageView);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setMaxHeight(40);
        setMaxWidth(40);
    }

    @Override
    protected void updateItem(String imagePath, boolean empty) {
        super.updateItem(imagePath, empty);
        if (empty || imagePath == null) {
            setGraphic(null);
        } else {
            Image image = new Image(getClass().getResource(imagePath).toExternalForm());
            imageView.setFitWidth(40); // Set your desired width
            imageView.setFitHeight(40); // Set your desired height
            imageView.setImage(image);
            setGraphic(imageView);
        }
    }
}



public class HomePageClass extends AnchorPane {

    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
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
    protected final BorderPane borderPane0;
    protected final AnchorPane anchorPane0;
    protected final Label nameTF;
    protected final Label balance;
    protected final AnchorPane anchorPane1;
    protected final AnchorPane anchorPane2;
    protected final TableView tableView;
    protected final TableColumn idCol;
    protected final TableColumn itemPh;
    protected final TableColumn nameCol;
    protected final TableColumn PriceCol;
    protected final TableColumn AmountLeftCol;
    private Parent root;
    private Stage stage;
    private Scene scene;
    static Socket socket;
    static DataInputStream dis ;
    static PrintStream ps ;
    
    
    
    private ArrayList<ItemInfo> jsonToArrayList(String jsonStr) {
    ArrayList<ItemInfo> itemInfoList = new ArrayList<>();

    try {
        // Parse the JSON array directly
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonStr);

        // Convert JSON array to ArrayList<ItemInfo>
        for (Object obj : jsonArray) {
            JSONObject jsonItem = (JSONObject) obj;

            // Extract values from the JSON object
            String itemId = (String) jsonItem.get("itemId");
            String itemName = (String) jsonItem.get("itemName");
            String itemPrice = (String) jsonItem.get("itemPrice");
            String itemAmountLeft = (String) jsonItem.get("itemAmountLeft");
            String itemPhoto = (String) jsonItem.get("itemPhoto");
            System.out.println(itemPhoto);

            // Create ItemInfo object and add to the list
            ItemInfo itemInfo = new ItemInfo(itemId, itemName, itemPrice, itemAmountLeft, itemPhoto );
            itemInfoList.add(itemInfo);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return itemInfoList;
}
    
    
    


    

    public HomePageClass() {

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
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
        borderPane0 = new BorderPane();
        anchorPane0 = new AnchorPane();
        nameTF = new Label();
        balance = new Label();
        anchorPane1 = new AnchorPane();
        anchorPane2 = new AnchorPane();
        tableView = new TableView();
        idCol = new TableColumn();
        itemPh = new TableColumn();
        nameCol = new TableColumn();
        PriceCol = new TableColumn();
        AmountLeftCol = new TableColumn();
        


        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(780.0);
        setPrefWidth(1000.0);

        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        borderPane.setPrefHeight(720.0);
        borderPane.setPrefWidth(720.0);
        borderPane.setStyle("-fx-background-color: #fffafa;");

        BorderPane.setMargin(anchorPane, new Insets(0.0));

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(780.0);
        vBox.setPrefWidth(190.0);
        vBox.setSpacing(60.0);
 

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(170.0);

        imageView.setFitHeight(66.0);
        imageView.setFitWidth(168.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
    

        vBox0.setPrefHeight(666.0);
        vBox0.setPrefWidth(170.0);
        vBox0.setSpacing(13.0);
 

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(60.0);
        hBox0.setPrefWidth(200.0);

        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(40.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("1-removebg-preview.png").toExternalForm()));

        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(133.0);
   
        
        button.setFont(new Font(16.0));
 
 //FirstnameTextField.setStyle("-fx-background-color: #ffffff;-fx-font-family: 'Georgia'; -fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(10.0);
        hBox1.setPrefHeight(60.0);
        hBox1.setPrefWidth(200.0);

        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(40.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("friends.png").toExternalForm()));

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(31.0);
        button0.setPrefWidth(133.0);
        imageView.setImage(new Image(getClass().getResource("we-removebg-preview.png").toExternalForm()));
        vBox0.setStyle("-fx-background-color:#9a8bd9;");
        vBox.setStyle("-fx-background-color:#9a8bd9;");
        button.setStyle("-fx-background-color: 	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button0.setStyle("-fx-background-color:	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button1.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button2.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button3.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button4.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button5.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button0.setText("Friends");
        button0.setFont(new Font( 16.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setLayoutX(10.0);
        hBox2.setLayoutY(156.0);
        hBox2.setPrefHeight(60.0);
        hBox2.setPrefWidth(200.0);

        imageView2.setFitHeight(40.0);
        imageView2.setFitWidth(40.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("notification.png").toExternalForm()));

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(31.0);
        button1.setPrefWidth(133.0);
     
        button1.setText("Notification");
        button1.setFont(new Font( 16.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setLayoutX(10.0);
        hBox3.setLayoutY(229.0);
        hBox3.setPrefHeight(60.0);
        hBox3.setPrefWidth(200.0);

        imageView3.setFitHeight(40.0);
        imageView3.setFitWidth(40.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Additem.png").toExternalForm()));

        button2.setMnemonicParsing(false);
        button2.setPrefHeight(31.0);
        button2.setPrefWidth(121.0);
      
        button2.setText("Add item");
        button2.setFont(new Font( 16.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox4.setLayoutX(10.0);
        hBox4.setLayoutY(302.0);
        hBox4.setPrefHeight(60.0);
        hBox4.setPrefWidth(200.0);

        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(40.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("wallet.png").toExternalForm()));

        button3.setMnemonicParsing(false);
        button3.setPrefHeight(31.0);
        button3.setPrefWidth(133.0);
        button3.setText("Wallet");
        button3.setFont(new Font( 16.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox5.setLayoutX(10.0);
        hBox5.setLayoutY(375.0);
        hBox5.setPrefHeight(60.0);
        hBox5.setPrefWidth(200.0);

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("friendwish.png").toExternalForm()));

        button4.setMnemonicParsing(false);
        button4.setPrefHeight(31.0);
        button4.setPrefWidth(133.0);
        button4.setText("Friend wish");
        button4.setFont(new Font( 16.0));

        hBox6.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox6.setLayoutX(10.0);
        hBox6.setLayoutY(448.0);
        hBox6.setPrefHeight(60.0);
        hBox6.setPrefWidth(200.0);

        imageView6.setFitHeight(40.0);
        imageView6.setFitWidth(40.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("logout.png").toExternalForm()));

        button5.setMnemonicParsing(false);
        button5.setPrefHeight(31.0);
        button5.setPrefWidth(133.0);
    
        button5.setText("Logout ");
        button5.setFont(new Font( 16.0));
        borderPane.setLeft(anchorPane);

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);
        borderPane0.setPrefHeight(200.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(104.0);
        anchorPane0.setPrefWidth(610.0);

        AnchorPane.setBottomAnchor(nameTF, 30.0);
        AnchorPane.setTopAnchor(nameTF, 31.0);
        nameTF.setLayoutX(107.0);
        nameTF.setLayoutY(29.0);
        nameTF.setPrefHeight(43.0);
        nameTF.setPrefWidth(240.0);
      
        nameTF.setFont(new Font("georgia",28.0));
        nameTF.setTextFill(Color.web("#BA73D9"));
        nameTF.setStyle("-fx-background-color:#ccc5ec; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        nameTF.setAlignment(Pos.CENTER);
        

        AnchorPane.setBottomAnchor(balance, 30.0);
        AnchorPane.setTopAnchor(balance, 31.0);
        balance.setLayoutX(351.0);
        balance.setLayoutY(31.0);
        balance.setPrefHeight(43.0);
        balance.setPrefWidth(207.0);
        balance.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));
        balance.setFont(new Font("georgia",28.0));
        balance.setTextFill(Color.web("#BA73D9"));
        balance.setStyle("-fx-background-color:#ccc5ec; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        balance.setAlignment(Pos.CENTER);

        borderPane0.setTop(anchorPane0);

        BorderPane.setAlignment(anchorPane1, javafx.geometry.Pos.CENTER);
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);

        anchorPane2.setPrefHeight(676.0);
        anchorPane2.setPrefWidth(609.0);

        tableView.setLayoutX(100);
        tableView.setLayoutY(50);
        tableView.setPrefHeight(550.0);
        tableView.setPrefWidth(609.0);
        idCol.setPrefWidth(92);
        idCol.setText("ID");
        
        itemPh.setPrefWidth(126);
        itemPh.setText("Photo");

        nameCol.setPrefWidth(126);
        nameCol.setText("Name");

        PriceCol.setPrefWidth(120);
        PriceCol.setText("Price");

        AmountLeftCol.setPrefWidth(146);
        AmountLeftCol.setText("Amount Collected");
        
        borderPane0.setCenter(anchorPane1);
        borderPane.setCenter(borderPane0);
        
   
        
        String imagePath = "99.jpg"; // Change this to the actual path of your image
        Image backgroundImage = new Image(getClass().getResource(imagePath).toExternalForm());

        // Set the BackgroundSize to 100% width and height without preserving the aspect ratio
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);

        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        //menuVBox.setBackground(new Background(background));
        //borderPane0.setBackground(new Background(background));
        BorderPane contentPane = new BorderPane();

        contentPane.setCenter(borderPane0);

        // Set the background for the BorderPane
        contentPane.setBackground(new Background(new BackgroundImage(
                backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, backgroundSize
        )));

        // Set the center of the borderPane to be the contentPane
        borderPane.setCenter(contentPane);

        // Set the center of the borderPane to be the StackPane

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
        anchorPane.getChildren().add(vBox);
        anchorPane0.getChildren().add(nameTF);
        anchorPane0.getChildren().add(balance);
        tableView.getColumns().add(idCol);
        tableView.getColumns().add(itemPh);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(PriceCol);
        tableView.getColumns().add(AmountLeftCol);
        anchorPane2.getChildren().add(tableView);
        anchorPane1.getChildren().add(anchorPane2);
        
        
        
        getChildren().add(borderPane);
        try {
            socket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
        
        
        ps.println("homeRequest");
        ps.println(LoginScene.curEmail);
        System.out.println(LoginScene.curEmail);
        try {
            String name = dis.readLine();
            button.setText("Profile");
            nameTF.setText(name);
        } catch (IOException ex) {
            Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String cur_balance = dis.readLine();
            balance.setText(cur_balance + "$");
        } catch (IOException ex) {
            Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String itemInfoJsonString = dis.readLine();
            System.out.println(itemInfoJsonString);
            ArrayList<ItemInfo> itemInfoList = jsonToArrayList(itemInfoJsonString);
            //System.out.println(itemInfoList);
            ObservableList<ItemInfo> itemInfoObservableList = FXCollections.observableArrayList(itemInfoList);
            tableView.setItems(itemInfoObservableList);
                
            
            
            // Set cell value factories for each column
            idCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            PriceCol.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            AmountLeftCol.setCellValueFactory(new PropertyValueFactory<>("amountLeft"));
            
            // Set the cell value factory for the itemPhoto column
            itemPh.setCellValueFactory(new PropertyValueFactory<>("itemPhoto"));
            itemPh.setPrefWidth(122);
            // Set the cell factory for the itemPhoto column
            itemPh.setCellFactory(column -> new ImageTableCell());

            // Now set the items in the TableView
            tableView.setItems(itemInfoObservableList);

        } catch (IOException ex) {
            Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // button 2 is add item button
        button2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Parent root = new  MarketSceneBase();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                //scene.getStylesheets().add("CSS/tableStyle.css");
                stage.setScene(scene);
                stage.show();   
            }
        });
        
        // button 5 is log out button
        button5.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  LoginScene();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
        
        button3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  WalletBase();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();            }
        });
        
        button1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = new  NotificatonsBase1();
                    scene = new Scene(root);
                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        button0.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                try {   
                    Parent root;
                    root = new  Friends();
                    scene = new Scene(root);
                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show(); 
                } catch (IOException ex) {
                    Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        button4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    root = new  friendsWishListBase();
                    scene = new Scene(root);
                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
            }
        });
        
        String cssFile = getClass().getResource("tableStyle.css").toExternalForm();
        tableView.getStylesheets().add(cssFile);
        
        
    }
}


