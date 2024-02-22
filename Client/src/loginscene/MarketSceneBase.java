package loginscene;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static loginscene.LoginScene.dis;
import static loginscene.LoginScene.ps;
import static loginscene.RegisterBase.socket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MarketSceneBase extends AnchorPane {

    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ImageView imageView;
    protected final VBox vBox0;
    protected final HBox hBox0;
    protected final ImageView imageView0;
    protected final Button profileBtn;
    protected final HBox friendbtn;
    protected final ImageView imageView1;
    protected final Button button;
    protected final HBox hBox1;
    protected final ImageView imageView2;
    protected final Button notificationBtn;
    protected final HBox hBox2;
    protected final ImageView imageView3;
    protected final Button addItemBtn;
    protected final HBox hBox3;
    protected final ImageView imageView4;
    protected final Button walletBtn;
    protected final HBox hBox4;
    protected final ImageView imageView5;
    protected final Button friendWishBtn;
    protected final HBox hBox5;
    protected final ImageView imageView6;
    protected final Button logoutBtn;
    protected final BorderPane borderPane0;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final TableView tableView;
    protected final TableColumn<itemDto, String> idCol;
    protected final TableColumn<itemDto, String> itemPh; 
    protected final TableColumn<itemDto, String> nameCol;
    protected final TableColumn<itemDto, String> PriceCol;
    protected final TableColumn<itemDto, Void> actioncol;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    
    
    private ArrayList<itemDto> jsonToArrayList(String jsonStr) {
    ArrayList<itemDto> itemInfoList = new ArrayList<>();

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
            String itemPhoto = (String) jsonItem.get("itemPhoto");
            
            // Create ItemInfo object and add to the list
            itemDto itemInfo = new itemDto(itemId, itemName, itemPrice,itemPhoto);
            itemInfoList.add(itemInfo);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return itemInfoList;
}

    public MarketSceneBase() {

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        vBox = new VBox();
        hBox = new HBox();
        imageView = new ImageView();
        vBox0 = new VBox();
        hBox0 = new HBox();
        imageView0 = new ImageView();
        profileBtn = new Button();
        friendbtn = new HBox();
        imageView1 = new ImageView();
        button = new Button();
        hBox1 = new HBox();
        imageView2 = new ImageView();
        notificationBtn = new Button();
        hBox2 = new HBox();
        imageView3 = new ImageView();
        addItemBtn = new Button();
        hBox3 = new HBox();
        imageView4 = new ImageView();
        walletBtn = new Button();
        hBox4 = new HBox();
        imageView5 = new ImageView();
        friendWishBtn = new Button();
        hBox5 = new HBox();
        imageView6 = new ImageView();
        logoutBtn = new Button();
        borderPane0 = new BorderPane();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        tableView = new TableView();
        idCol = new TableColumn();
        itemPh = new TableColumn();
        nameCol = new TableColumn();
        PriceCol = new TableColumn();
        actioncol = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(780.0);
        setPrefWidth(780.0);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(780.0);
        setPrefWidth(1000.0);
  

        imageView.setFitHeight(66.0);
        imageView.setFitWidth(168.0);
        imageView.setImage(new Image(getClass().getResource("we-removebg-preview.png").toExternalForm()));
        vBox0.setStyle("-fx-background-color:#9a8bd9;");
        vBox.setStyle("-fx-background-color:#9a8bd9;");
        profileBtn.setStyle("-fx-background-color: 	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button.setStyle("-fx-background-color:	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        notificationBtn.setStyle("-fx-background-color: 	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        addItemBtn.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        walletBtn.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        friendWishBtn.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        logoutBtn.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        borderPane.setPrefHeight(720.0);
        borderPane.setPrefWidth(720.0);
        borderPane.setStyle("-fx-background-color:#ccc5ec;");

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

        profileBtn.setMnemonicParsing(false);
        profileBtn.setPrefHeight(31.0);
        profileBtn.setPrefWidth(133.0);
      
        profileBtn.setText("Profile");
        profileBtn.setFont(new Font( 16.0));

        friendbtn.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        friendbtn.setLayoutX(10.0);
        friendbtn.setLayoutY(10.0);
        friendbtn.setPrefHeight(60.0);
        friendbtn.setPrefWidth(200.0);

        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(40.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("friends.png").toExternalForm()));

        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(133.0);
        
        button.setText("Friends");
        button.setFont(new Font(16.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(156.0);
        hBox1.setPrefHeight(60.0);
        hBox1.setPrefWidth(200.0);

        imageView2.setFitHeight(40.0);
        imageView2.setFitWidth(40.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("notification.png").toExternalForm()));

        notificationBtn.setMnemonicParsing(false);
        notificationBtn.setPrefHeight(31.0);
        notificationBtn.setPrefWidth(133.0);
   
        notificationBtn.setText("Notification");
        notificationBtn.setFont(new Font(16.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setLayoutX(10.0);
        hBox2.setLayoutY(229.0);
        hBox2.setPrefHeight(60.0);
        hBox2.setPrefWidth(200.0);

        imageView3.setFitHeight(40.0);
        imageView3.setFitWidth(40.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Additem.png").toExternalForm()));

        addItemBtn.setMnemonicParsing(false);
        addItemBtn.setPrefHeight(31.0);
        addItemBtn.setPrefWidth(121.0);
     
        addItemBtn.setText("Add item");
        addItemBtn.setFont(new Font(16.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setLayoutX(10.0);
        hBox3.setLayoutY(302.0);
        hBox3.setPrefHeight(60.0);
        hBox3.setPrefWidth(200.0);

        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(40.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("wallet.png").toExternalForm()));

        walletBtn.setMnemonicParsing(false);
        walletBtn.setPrefHeight(31.0);
        walletBtn.setPrefWidth(133.0);

        walletBtn.setText("Wallet");
        walletBtn.setFont(new Font(16.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox4.setLayoutX(10.0);
        hBox4.setLayoutY(375.0);
        hBox4.setPrefHeight(60.0);
        hBox4.setPrefWidth(200.0);

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("friendwish.png").toExternalForm()));

        friendWishBtn.setMnemonicParsing(false);
        friendWishBtn.setPrefHeight(31.0);
        friendWishBtn.setPrefWidth(133.0);
       
        friendWishBtn.setText("Friend wish");
        friendWishBtn.setFont(new Font( 16.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox5.setLayoutX(10.0);
        hBox5.setLayoutY(448.0);
        hBox5.setPrefHeight(60.0);
        hBox5.setPrefWidth(200.0);

        imageView6.setFitHeight(40.0);
        imageView6.setFitWidth(40.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("logout.png").toExternalForm()));

        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setPrefHeight(31.0);
        logoutBtn.setPrefWidth(133.0);
  
        logoutBtn.setText("Logout ");
        logoutBtn.setFont(new Font( 16.0));
        borderPane.setLeft(anchorPane);

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);
        borderPane0.setPrefHeight(200.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        anchorPane1.setPrefHeight(780.0);
        anchorPane1.setPrefWidth(609.0);

        AnchorPane.setBottomAnchor(tableView, 0.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setTopAnchor(tableView, 0.0);
        tableView.setPrefHeight(780.0);
        tableView.setPrefWidth(830.0);

        idCol.setPrefWidth(146);
        idCol.setText("ItemID");
        
        itemPh.setPrefWidth(166);
        itemPh.setText("ItemPhoto");
                
        nameCol.setPrefWidth(166);
        nameCol.setText("ItemName");

        PriceCol.setPrefWidth(166);
        PriceCol.setText("Price");

        actioncol.setPrefWidth(166);
        actioncol.setText("Action");
        borderPane0.setCenter(anchorPane0);
        borderPane.setCenter(borderPane0);

        hBox.getChildren().add(imageView);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(imageView0);
        hBox0.getChildren().add(profileBtn);
        vBox0.getChildren().add(hBox0);
        friendbtn.getChildren().add(imageView1);
        friendbtn.getChildren().add(button);
        vBox0.getChildren().add(friendbtn);
        hBox1.getChildren().add(imageView2);
        hBox1.getChildren().add(notificationBtn);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(imageView3);
        hBox2.getChildren().add(addItemBtn);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(imageView4);
        hBox3.getChildren().add(walletBtn);
        vBox0.getChildren().add(hBox3);
        hBox4.getChildren().add(imageView5);
        hBox4.getChildren().add(friendWishBtn);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(imageView6);
        hBox5.getChildren().add(logoutBtn);
        vBox0.getChildren().add(hBox5);
        vBox.getChildren().add(vBox0);
        anchorPane.getChildren().add(vBox);
        tableView.getColumns().add(idCol);
        tableView.getColumns().add(itemPh);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(PriceCol);
        tableView.getColumns().add(actioncol);
        anchorPane1.getChildren().add(tableView);
        anchorPane0.getChildren().add(anchorPane1);
        getChildren().add(borderPane);
        try {
            socket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HomePageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread() {
            public void run (){
                ps.println("addItemRequest");
                ps.println(LoginScene.curEmail);
                System.out.println(LoginScene.curEmail);

                try {
                    String marektInfoJsonString = dis.readLine();
                    System.out.println(marektInfoJsonString);
                    ArrayList<itemDto> marektInfoList = jsonToArrayList(marektInfoJsonString);
                    System.out.println(marektInfoList);

                    // Update UI on the JavaFX Application Thread
                    Platform.runLater(() -> {
                        ObservableList<itemDto> marektInfoObservableList = FXCollections.observableArrayList(marektInfoList);
                        tableView.setItems(marektInfoObservableList);

                        // Set cell value factories for each column
                        idCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
                        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
                        PriceCol.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
                        itemPh.setCellValueFactory(new PropertyValueFactory<>("itemPhoto")); 
                        
                        itemPh.setCellFactory(param -> new TableCell<itemDto, String>() {
                            private final ImageView imageView = new ImageView();
                            private final VBox vbox = new VBox(imageView);

                            {
                                // Set the size you want for the image
                                imageView.setFitWidth(50);  // Set the width
                                imageView.setFitHeight(50); // Set the height
                                vbox.setSpacing(5);
                            }

                            @Override
                            protected void updateItem(String imagePath, boolean empty) {
                                super.updateItem(imagePath, empty);

                                if (empty || imagePath == null) {
                                    setGraphic(null);
                                } else {
                                    // Load the image and set it to the ImageView
                                    Image image = new Image(getClass().getResource(imagePath).toExternalForm());
                                    imageView.setImage(image);
                                    setGraphic(vbox);
                                }
                            }
                        });
                        
                        actioncol.setCellFactory(param -> new TableCell<itemDto, Void>() {
                            private final Button actionButton = new Button("Add Item");

                            {
                                actionButton.setStyle("-fx-background-color:#C18BD9;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#F2F2F2;");
                                actionButton.setPrefHeight(31.0);
                                actionButton.setPrefWidth(133.0);
                                // Set the action for the button
                                actionButton.setOnAction(event -> {
                                    itemDto itemInfo = getTableView().getItems().get(getIndex());
                                    // Perform action when the button is clicked, you can customize this part
                                    // System.out.println("Button clicked for item: " + itemInfo.getItemId());
                                    ps.println(itemInfo.getItemId());
                                });
                            }

                            @Override
                            protected void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);

                                // Display the button only if the cell is not empty
                                if (!empty) {
                                    setGraphic(actionButton);
                                } else {
                                    setGraphic(null);
                                }
                            }
                        });

                        // Add the actioncol to the tableView
                        if (!tableView.getColumns().contains(actioncol)) {
                            tableView.getColumns().add(actioncol);
                        }
                        
                    });

                } catch (IOException ex) {
                    Logger.getLogger(MarketSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
           
        }.start();

        
        
        logoutBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            Parent root = new  LoginScene();
            scene = new Scene(root);
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            }
        });
        
        profileBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                // UI update code (e.g., switching scenes)
                Parent root = new HomePageClass();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene.getStylesheets().add("CSS/tableStyle.css");
                stage.setScene(scene);
                stage.show();
                });        
            }
        });
        
        friendbtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        
        notificationBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        
        walletBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  WalletBase();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();            }
        });
        
        friendWishBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
