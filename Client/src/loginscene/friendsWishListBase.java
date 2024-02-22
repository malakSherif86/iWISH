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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static loginscene.LoginScene.socket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import static loginscene.HomePageClass.ps;



public  class friendsWishListBase extends AnchorPane {

    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ImageView imageView;
    protected final VBox vBox0;
    protected final HBox hBox0;
    protected final Button btnProfile;
    protected final HBox hBox1;
    protected final Button btnFriends;
    protected final HBox hBox2;
    protected final Button btnNotification;
    protected final HBox hBox3;
    protected final Button btnAddItem;
    protected final HBox hBox4;
    protected final Button btnWallet;
    protected final HBox hBox5;
    protected final Button btnFriendWish;
    protected final HBox hBox6;
    protected final Button btnLogOut;
    protected final BorderPane borderPane0;
    protected final AnchorPane anchorPane0;
    protected final TableView tableFriendList;
    protected final TableColumn colFirstName;
    protected final TableColumn colLastName;
    protected final TableColumn colEmail;
    protected final Label labelFriendList;
    protected final Label labelFriendWishList;
    protected final TableView tableFriendWishList;
    protected final TableColumn colitemPhoto;
    protected final TableColumn colName;
    protected final TableColumn colPrice;
    protected final TableColumn colAmountPaid;
    protected final AnchorPane PaneContribute;
    protected final TextField textFieldContribute;
    protected final Text labelContribute;
    protected final Button btnCancelContribute;
    protected final Button btnSendContribute;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public static String friendEmail;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final ImageView imageView5;
    protected final ImageView imageView6;
    
    static Socket socket;
    static DataInputStream dis ;
    static PrintStream ps ;

    private ArrayList<FriendList> jsonToArrayList(String jsonStr) {
    ArrayList<FriendList> friendList = new ArrayList<>();

    try {
        // Parse the JSON array directly
        JSONArray jsonArray1 = (JSONArray) new JSONParser().parse(jsonStr);

        // Convert JSON array to ArrayList<FriendList>
        for (Object obj : jsonArray1) {
            JSONObject jsonfriend = (JSONObject) obj;
            
            // Extract values from the JSON object
            String email = (String) jsonfriend.get("email");
            String FirstName = (String) jsonfriend.get("FirstName");
            String LastName = (String) jsonfriend.get("LastName");

            // Create FriendList object and add to the list
            FriendList friend = new FriendList(email, FirstName, LastName);
            friendList.add(friend);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return friendList;
}
    private ArrayList<FriendWishdto> jsonToArrayListWish(String jsonStr) {
    ArrayList<FriendWishdto> friendWishList = new ArrayList<>();

    try {
        // Parse the JSON array directly
        JSONArray jsonArray2 = (JSONArray) new JSONParser().parse(jsonStr);

        // Convert JSON array to ArrayList<FriendList>
        for (Object obj : jsonArray2) {
            JSONObject jsonfriendwish = (JSONObject) obj;
            
            // Extract values from the JSON object
            String ItemPhoto = (String) jsonfriendwish.get("ItemPhoto");
            String ItemName = (String) jsonfriendwish.get("ItemName");
            String ItemPrice = (String) jsonfriendwish.get("ItemPrice");
            String AmountPaid = (String) jsonfriendwish.get("AmountPaid");
            String FriendUser = (String) jsonfriendwish.get("FriendUser");
            String ItemID = (String) jsonfriendwish.get("ItemID");
            // Create FriendList object and add to the list
            FriendWishdto friendwish = new FriendWishdto(ItemPhoto, ItemName, ItemPrice, AmountPaid, FriendUser, ItemID);
            friendWishList.add(friendwish);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return friendWishList;
}

    public friendsWishListBase() {

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        vBox = new VBox();
        hBox = new HBox();
        imageView = new ImageView();
        vBox0 = new VBox();
        hBox0 = new HBox();
        btnProfile = new Button();
        hBox1 = new HBox();
        btnFriends = new Button();
        hBox2 = new HBox();
        btnNotification = new Button();
        hBox3 = new HBox();
        btnAddItem = new Button();
        hBox4 = new HBox();
        btnWallet = new Button();
        hBox5 = new HBox();
        btnFriendWish = new Button();
        hBox6 = new HBox();
        btnLogOut = new Button();
        borderPane0 = new BorderPane();
        anchorPane0 = new AnchorPane();
        tableFriendList = new TableView();
        colFirstName = new TableColumn();
        colLastName = new TableColumn();
        colEmail = new TableColumn();
        labelFriendList = new Label();
        labelFriendWishList = new Label();
        tableFriendWishList = new TableView();
        colitemPhoto = new TableColumn();
        colName = new TableColumn();
        colPrice = new TableColumn();
        colAmountPaid = new TableColumn();
        PaneContribute = new AnchorPane();
        textFieldContribute = new TextField();
        labelContribute = new Text();
        btnCancelContribute = new Button();
        btnSendContribute = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        
        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(40.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("1-removebg-preview.png").toExternalForm()));
        
        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(40.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("friends.png").toExternalForm()));
        
        imageView2.setFitHeight(40.0);
        imageView2.setFitWidth(40.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("notification.png").toExternalForm()));
        
        imageView3.setFitHeight(40.0);
        imageView3.setFitWidth(40.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Additem.png").toExternalForm()));
        
        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(40.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("wallet.png").toExternalForm()));
        
        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("friendwish.png").toExternalForm()));
        
        imageView6.setFitHeight(40.0);
        imageView6.setFitWidth(40.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("logout.png").toExternalForm()));

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
        borderPane.setStyle("-fx-background-color:#ccc5ec;");

        anchorPane.setPrefHeight(740.0);
        anchorPane.setPrefWidth(170.0);
        BorderPane.setMargin(anchorPane, new Insets(0.0));

        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(780.0);
        vBox.setPrefWidth(190.0);
        vBox.setSpacing(60.0);
      

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(170.0);

        imageView.setFitHeight(100.0);
        imageView.setFitWidth(170.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("we-removebg-preview.png").toExternalForm()));
        
        

        vBox0.setPrefHeight(666.0);
        vBox0.setPrefWidth(170.0);
        vBox0.setSpacing(13.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(60.0);
        hBox0.setPrefWidth(200.0);

        btnProfile.setMnemonicParsing(false);
        btnProfile.setPrefHeight(31.0);
        btnProfile.setPrefWidth(133.0);
      
        btnProfile.setText("Profile");
        btnProfile.setFont(new Font( 16.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(10.0);
        hBox1.setPrefHeight(60.0);
        hBox1.setPrefWidth(200.0);
        
        imageView.setFitHeight(66.0);
        imageView.setFitWidth(168.0);
        imageView.setImage(new Image(getClass().getResource("we-removebg-preview.png").toExternalForm()));
        vBox0.setStyle("-fx-background-color:#9a8bd9;");
        vBox.setStyle("-fx-background-color:#9a8bd9;");
        btnProfile.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnFriends.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnNotification.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnAddItem.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnWallet.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnFriendWish.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        btnLogOut.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        

        btnFriends.setMnemonicParsing(false);
        btnFriends.setPrefHeight(31.0);
        btnFriends.setPrefWidth(133.0);
       
        btnFriends.setText("Friends");
        btnFriends.setFont(new Font( 16.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setLayoutX(10.0);
        hBox2.setLayoutY(156.0);
        hBox2.setPrefHeight(60.0);
        hBox2.setPrefWidth(200.0);

        btnNotification.setMnemonicParsing(false);
        btnNotification.setPrefHeight(31.0);
        btnNotification.setPrefWidth(133.0);
      
        btnNotification.setText("Notification");
        btnNotification.setFont(new Font( 16.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setLayoutX(10.0);
        hBox3.setLayoutY(229.0);
        hBox3.setPrefHeight(60.0);
        hBox3.setPrefWidth(200.0);

        btnAddItem.setMnemonicParsing(false);
        btnAddItem.setPrefHeight(31.0);
        btnAddItem.setPrefWidth(133.0);
  
        btnAddItem.setText("Add Item");
        btnAddItem.setFont(new Font(16.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox4.setLayoutX(10.0);
        hBox4.setLayoutY(302.0);
        hBox4.setPrefHeight(60.0);
        hBox4.setPrefWidth(200.0);

        btnWallet.setMnemonicParsing(false);
        btnWallet.setPrefHeight(31.0);
        btnWallet.setPrefWidth(133.0);
    
        btnWallet.setText("Wallet");
        btnWallet.setFont(new Font( 16.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox5.setLayoutX(10.0);
        hBox5.setLayoutY(375.0);
        hBox5.setPrefHeight(60.0);
        hBox5.setPrefWidth(200.0);

        btnFriendWish.setMnemonicParsing(false);
        btnFriendWish.setPrefHeight(31.0);
        btnFriendWish.setPrefWidth(133.0);
     
        btnFriendWish.setText("Friend wish");
        btnFriendWish.setFont(new Font(16.0));

        hBox6.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox6.setLayoutX(10.0);
        hBox6.setLayoutY(448.0);
        hBox6.setPrefHeight(60.0);
        hBox6.setPrefWidth(200.0);

        btnLogOut.setMnemonicParsing(false);
        btnLogOut.setPrefHeight(31.0);
        btnLogOut.setPrefWidth(133.0);
        btnLogOut.setText("Logout ");
        btnLogOut.setFont(new Font(16.0));
        borderPane.setLeft(anchorPane);

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);
        borderPane0.setPrefHeight(200.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(700.0);
        anchorPane0.setPrefWidth(704.0);

        AnchorPane.setLeftAnchor(tableFriendList, 25.0);
        tableFriendList.setLayoutX(25.0);
        tableFriendList.setLayoutY(65.0);
        tableFriendList.setPrefHeight(368.0);
        tableFriendList.setPrefWidth(351.0);

        colFirstName.setPrefWidth(107.0);
        colFirstName.setText("First Name");

        colLastName.setPrefWidth(107.0);
        colLastName.setText("Last Name");

        colEmail.setPrefWidth(137.0);
        colEmail.setText("Email");

        labelFriendList.setLayoutX(142.0);
        labelFriendList.setLayoutY(25.0);
       
        labelFriendList.setText("Friend List");
        labelFriendList.setStyle("-fx-background-color: #aea2e0;-fx-background-radius: 10;");
       
        labelFriendList.setFont(new Font("georgia",20.0));

        labelFriendList.setTextFill(Color.web("#000000"));

        AnchorPane.setRightAnchor(labelFriendWishList, 97.0);
        labelFriendWishList.setLayoutX(435.0);
        labelFriendWishList.setLayoutY(25.0);
        labelFriendWishList.setText("Friend wish list");
        labelFriendWishList.setStyle("-fx-background-color: #aea2e0;-fx-background-radius: 10;");
                               
        labelFriendWishList.setFont(new Font("georgia",20.0));

        labelFriendWishList.setTextFill(Color.web("#000000"));

        AnchorPane.setRightAnchor(tableFriendWishList, 16.0);
        tableFriendWishList.setLayoutX(248.0);
        tableFriendWishList.setLayoutY(65.0);
        tableFriendWishList.setPrefHeight(474.0);
        tableFriendWishList.setPrefWidth(400.0);

        colitemPhoto.setPrefWidth(100.0);
        colitemPhoto.setText("Item photo");

        colName.setPrefWidth(100.0);
        colName.setText("Name");

        colPrice.setPrefWidth(80.0);
        colPrice.setText("Price");

        colAmountPaid.setMinWidth(5.0);
        colAmountPaid.setPrefWidth(120.0);
        colAmountPaid.setText("Amount Paid");

        AnchorPane.setRightAnchor(PaneContribute, 60.0);
        PaneContribute.setLayoutX(0.0);
        PaneContribute.setLayoutY(551.0);
        PaneContribute.setPrefHeight(130.0);
        PaneContribute.setPrefWidth(310.0);
        PaneContribute.setStyle("-fx-background-color: #aea2e0;-fx-background-radius: 22;");
        textFieldContribute.setLayoutX(108.0);
        textFieldContribute.setLayoutY(28.0);
        textFieldContribute.setPrefHeight(25.0);
        textFieldContribute.setPrefWidth(171.0);
        textFieldContribute.setPromptText("$$");
        textFieldContribute.setStyle("-fx-background-color: #ffffff; -fx-font-family: 'Georgia';-fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        labelContribute.setLayoutX(25.0);
        labelContribute.setLayoutY(45.0);
        labelContribute.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        labelContribute.setStrokeWidth(0.0);
        labelContribute.setText("contribute");
        labelContribute.setFont(new Font("Georgia Bold Italic", 14.0));
        labelContribute.setFill(Color.web("#81409e"));
        btnCancelContribute.setStyle("-fx-background-color:#81409e;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#ccc5ec;");
        btnSendContribute.setStyle("-fx-background-color:#81409e;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#ccc5ec;");

        btnCancelContribute.setLayoutX(184.0);
        btnCancelContribute.setLayoutY(76.0);
        btnCancelContribute.setMnemonicParsing(false);
        btnCancelContribute.setText("Cancel");
        btnSendContribute.setPrefWidth(61.0);
        btnSendContribute.setLayoutX(150.0);
        btnSendContribute.setLayoutY(76.0);
        btnSendContribute.setMnemonicParsing(false);
        btnSendContribute.setText("Send");
        borderPane0.setBottom(anchorPane0);
        borderPane.setCenter(borderPane0);

        hBox.getChildren().add(imageView);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(imageView0);
        hBox0.getChildren().add(btnProfile);
        vBox0.getChildren().add(hBox0);
        hBox1.getChildren().add(imageView1);
        hBox1.getChildren().add(btnFriends);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(imageView2);
        hBox2.getChildren().add(btnNotification);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(imageView3);
        hBox3.getChildren().add(btnAddItem);
        vBox0.getChildren().add(hBox3);
        hBox4.getChildren().add(imageView4);
        hBox4.getChildren().add(btnWallet);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(imageView5);
        hBox5.getChildren().add(btnFriendWish);
        vBox0.getChildren().add(hBox5);
        hBox6.getChildren().add(imageView6);
        hBox6.getChildren().add(btnLogOut);
        vBox0.getChildren().add(hBox6);
        vBox.getChildren().add(vBox0);
        anchorPane.getChildren().add(vBox);
        tableFriendList.getColumns().add(colFirstName);
        tableFriendList.getColumns().add(colLastName);
        tableFriendList.getColumns().add(colEmail);
        anchorPane0.getChildren().add(tableFriendList);
        anchorPane0.getChildren().add(labelFriendList);
        anchorPane0.getChildren().add(labelFriendWishList);
        tableFriendWishList.getColumns().add(colitemPhoto);
        tableFriendWishList.getColumns().add(colName);
        tableFriendWishList.getColumns().add(colPrice);
        tableFriendWishList.getColumns().add(colAmountPaid);
        anchorPane0.getChildren().add(tableFriendWishList);
        PaneContribute.getChildren().add(textFieldContribute);
        PaneContribute.getChildren().add(labelContribute);
        //PaneContribute.getChildren().add(btnCancelContribute);
        PaneContribute.getChildren().add(btnSendContribute);
        anchorPane0.getChildren().add(PaneContribute);
        getChildren().add(borderPane);
        
        try {
            socket = new Socket("127.0.0.1", 5005);
        } catch (IOException ex) {
            Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
        }
            ps.println("FriendList");
            try {
                ps.println(LoginScene.curEmail);
                String itemInfoJsonString = dis.readLine();
                //System.out.println(itemInfoJsonString);
                ArrayList<FriendList> myFriendList = jsonToArrayList(itemInfoJsonString);
                //System.out.println(myFriendList);
                ObservableList<FriendList> friendInfoObservableList = FXCollections.observableArrayList(myFriendList);
                tableFriendList.setItems(friendInfoObservableList);

                // Set cell value factories for each column
                colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));    
                

            } catch (IOException ex) {
                Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
            }

            tableFriendList.setOnMouseClicked(event -> {

                if (event.getClickCount() == 1) {
                    FriendList selectedFriend = (FriendList) tableFriendList.getSelectionModel().getSelectedItem();
                    if (selectedFriend != null) {
                        try {
                            ps.println("showFriendWishList");
                            ps.println(selectedFriend.getEmail());
                            friendEmail = selectedFriend.getEmail();
                            //System.out.println("Target is "+selectedFriend.getEmail());
                            String wishInfoJsonString = dis.readLine();
                            
                            System.out.println(wishInfoJsonString);
                            ArrayList<FriendWishdto> myFriendWishList = jsonToArrayListWish(wishInfoJsonString);
                            //System.out.println(myFriendWishList);
                            ObservableList<FriendWishdto> friendWishInfoObservableList = FXCollections.observableArrayList(myFriendWishList);
                            tableFriendWishList.setItems(friendWishInfoObservableList);

                            // Set cell value factories for each column
                            
                            colName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
                            colPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
                            colAmountPaid.setCellValueFactory(new PropertyValueFactory<>("AmountPaid"));
                            
                            colitemPhoto.setCellValueFactory(new PropertyValueFactory<>("ItemPhoto"));
                            colitemPhoto.setPrefWidth(100);
                            colitemPhoto.setCellFactory(column -> new ImageTableCell());
                            
                            } catch (IOException ex) {
                                Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                }
            });
            
            btnProfile.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  HomePageClass();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            });

            tableFriendWishList.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {
                    FriendWishdto selectedFriendWish = (FriendWishdto) tableFriendWishList.getSelectionModel().getSelectedItem();
                    if (selectedFriendWish != null) {
                        // Assuming you have a button named btnContribute and a button named btnCancelContribute
                        btnSendContribute.setOnAction(contributeEvent -> {
                            // Handle contribution
                            try{
                            String contributionAmount = textFieldContribute.getText();
                            //System.out.println(contributionAmount);
                            int IntegerContribution =Integer.valueOf(contributionAmount);
                            if (!contributionAmount.isEmpty() && IntegerContribution !=0 ) {
                                // Assuming AmountPaid is a numeric value (adjust the parsing accordingly)
                                
                                ps.println("contribute");
                                ps.println(LoginScene.curEmail);
                                ps.println(textFieldContribute.getText());
                                ps.println(selectedFriendWish.getItemName());
                                ps.println(selectedFriendWish.getItemID());
                                ps.println(selectedFriendWish.getItemPrice());
                                ps.println(selectedFriendWish.getAmountPaid());
                                ps.println(friendEmail);
                                /*System.out.println("--------------");
                                System.out.println("ap " + selectedFriendWish.getAmountPaid());
                                System.out.println("item name "+ selectedFriendWish.getItemName());
                                System.out.println("Item id "+selectedFriendWish.getItemID());
                                System.out.println("Price "+selectedFriendWish.getItemPrice());
                                System.out.println("email "+ selectedFriendWish.getFriendUser());
                                System.out.println("ph " + selectedFriendWish.ItemPhoto);
                                System.out.println("Target is "+friendEmail);*/
                                String ResponeString = dis.readLine();
                                //System.out.println(ResponeString);
                                if("nomoney".equals(ResponeString)){
                                    showAlert("You Dont enough money", Alert.AlertType.WARNING);
                                }
                                if("HugeContribute".equals(ResponeString)){
                                    showAlert("Your contribution is greater than the item needs", Alert.AlertType.WARNING);
                                }
                                if("MyContribute".equals(ResponeString)){
                                    showAlert("Your contribution is successful", Alert.AlertType.WARNING);
                                    String str = dis.readLine();
                                    //System.out.println(str);
                                    //double newAmountPaid = Double.parseDouble(selectedFriendWish.getAmountPaid()) + Double.parseDouble(contributionAmount);
                                    selectedFriendWish.setAmountPaid(str);
                                }
                               
                                // Update the table
                                tableFriendWishList.refresh();
                                                             
                            
                            } if(contributionAmount.isEmpty() || IntegerContribution == 0 ) {
                                showAlert("Enter your contribution ", Alert.AlertType.WARNING);
                            }
                            } catch (IOException ex) {
                                Logger.getLogger(friendsWishListBase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });

                        btnCancelContribute.setOnAction(cancelEvent -> {
                            // Handle cancel contribution
                            // You can add any specific logic here

                            // For example, show a confirmation dialog
                            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel the contribution?", ButtonType.YES, ButtonType.NO);
                            confirmation.showAndWait();

                            if (confirmation.getResult() == ButtonType.YES) {
                                // User clicked Yes, perform cancel operation
                                // For example, clear the contribution amount field
                                textFieldContribute.clear();
                            }
                        });
                    }
                }
            });
            
            btnAddItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        btnLogOut.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  LoginScene();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
        
        btnWallet.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new  WalletBase();
                scene = new Scene(root);
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();            }
        });
        
        btnNotification.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        
        btnFriends.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
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
        
        String cssFile = getClass().getResource("tableStyle.css").toExternalForm();
        tableFriendList.getStylesheets().add(cssFile);
        tableFriendWishList.getStylesheets().add(cssFile);
        
        
                   
    }
    private void showAlert(String message, Alert.AlertType alertType) {
            Alert alert = new Alert(alertType, message, ButtonType.OK);
            alert.showAndWait();
        }
    
    
    
}

