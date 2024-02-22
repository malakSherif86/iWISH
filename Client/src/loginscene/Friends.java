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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static loginscene.LoginScene.ps;


public class Friends extends AnchorPane {

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
    protected final AnchorPane anchorPane0;
    protected final Pane pane;
    protected final Text text;
    protected final Blend blend;
    protected final TableView friendsrequests;
    protected final TableColumn email1;
    protected final TableColumn actionAccept;
    protected final TableColumn actionDecline;
    protected final Pane pane0;
    protected final TableView friendstable;
    protected final TableColumn fname;
    protected final TableColumn lname;
    protected final TableColumn email;
    protected final Button addfriend;
    protected final Button removefriend;
    protected final TextField textField;
    protected final TextField textField0;
    protected final Pane pane1;
    protected final Blend blend0;
    protected final Text text0;
    private Parent root;
    private Stage stage;
    private Scene scene;
	
    private ArrayList<userFriendsDto> jsonToArrayList(String jsonStr) {
    ArrayList<userFriendsDto> userfriendsdtoList = new ArrayList<>();

    try {
        // Parse the JSON array directly
        JSONArray jsonArray1 = (JSONArray) new JSONParser().parse(jsonStr);

        // Convert JSON array to ArrayList<userFriendsDto>
        for (Object obj : jsonArray1) {
            JSONObject jsonFriends = (JSONObject) obj;

            // Extract values from the JSON object
            String fname = (String) jsonFriends.get("first_name");
            String lname = (String) jsonFriends.get("last_name");
            String email = (String) jsonFriends.get("email");
           

            // Create userFriendsDto object and add to the list
            userFriendsDto userfriendsdto = new userFriendsDto(fname, lname, email);
            userfriendsdtoList.add(userfriendsdto);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return userfriendsdtoList;
}
    
        private ArrayList<userFriendsDto> jsonToArrayList1(String jsonStr) {
    ArrayList<userFriendsDto> userfriendsdtoList = new ArrayList<>();

    try {
        // Parse the JSON array directly
        JSONArray jsonArray1 = (JSONArray) new JSONParser().parse(jsonStr);

        // Convert JSON array to ArrayList<userFriendsDto>
        for (Object obj : jsonArray1) {
            JSONObject jsonFriends = (JSONObject) obj;

            // Extract values from the JSON object
            String email = (String) jsonFriends.get("email");

            // Create userFriendsDto object and add to the list
            userFriendsDto userfriendsdto = new userFriendsDto(email);
            userfriendsdtoList.add(userfriendsdto);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }

    return userfriendsdtoList;
}
    
    private static <T> String getFieldValue(T item) {
        // Example: Assuming your data has a getName() method
        if (item instanceof userFriendsDto) {
            return ((userFriendsDto) item).getFriend_email();
        }
        return "";
    }

    public  <T> void deleteRowByFieldValue(TableView<T> tableView, ObservableList<T> data, TextField textField) {
        String valueToDelete = textField.getText();

        if (!valueToDelete.isEmpty()) {
            for (T item : data) {
                // Customize this part based on your data structure
                String fieldValue = getFieldValue(item);

                // Check if the field value matches the specified criteria
                if (fieldValue.equals(valueToDelete)) {
                    data.remove(item);
                    tableView.refresh();
                    return; // Assuming that the value is unique; remove and return if found
                }
            }
            // Handle case when the value is not found
            System.out.println("Value not found in the TableView");
        } else {
            // Handle case when the text field is empty
            System.out.println("Please enter a value in the TextField");
        }
    }
    

    public Friends() throws IOException {

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
        anchorPane0 = new AnchorPane();
        pane = new Pane();
        text = new Text();
        blend = new Blend();
        friendsrequests = new TableView();
        email1 = new TableColumn();
        actionAccept = new TableColumn();
        actionDecline = new TableColumn();
        pane0 = new Pane();
        friendstable = new TableView();
        fname = new TableColumn();
        lname = new TableColumn();
        email = new TableColumn();
        addfriend = new Button();
        removefriend = new Button();
        textField = new TextField();
        textField0 = new TextField();
        pane1 = new Pane();
        blend0 = new Blend();
        text0 = new Text();

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
        borderPane.setStyle("-fx-background-color: #ccc5ec;");//////////////////////////

        BorderPane.setMargin(anchorPane, new Insets(0.0));

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(780.0);
        vBox.setPrefWidth(190.0);
        vBox.setSpacing(60.0);
    

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(170.0);

        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        
        imageView.setFitHeight(66.0);
        imageView.setFitWidth(168.0);
        imageView.setImage(new Image(getClass().getResource("we-removebg-preview.png").toExternalForm()));
        vBox0.setStyle("-fx-background-color:#9a8bd9;");
        vBox.setStyle("-fx-background-color:#9a8bd9;");
        button.setStyle("-fx-background-color: 	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button0.setStyle("-fx-background-color:	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button1.setStyle("-fx-background-color: 	#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button2.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button3.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button4.setStyle("-fx-background-color: #ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        button5.setStyle("-fx-background-color:#ccc5ec;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#81409e;");
        
        vBox0.setPrefHeight(666.0);
        vBox0.setPrefWidth(190.0);
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
      
        button.setText("Profile");
        button.setFont(new Font(16.0));

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
        button2.setPrefWidth(133.0);

        button2.setText("Add Item");
        button2.setFont(new Font(16.0));

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

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(780.0);
        anchorPane0.setPrefWidth(397.0);
      anchorPane0.setStyle("-fx-background-color: #ccc5ec;");////////////////

        pane.setLayoutX(96.0);
        pane.setLayoutY(20.0);
        pane.setPrefHeight(39.0);
        pane.setPrefWidth(167.0);
        
        
        pane.setStyle("-fx-background-color: #ccc5ec; -fx-background-radius: 10;");//////////////////////

        text.setLayoutX(-7.0);
        text.setLayoutY(27.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Friend Requests");
        text.setFont(new Font("Georgia Bold Italic", 25.0));
         text.setFill(Color.web("#ad7dc3"));
          text0.setFill(Color.web("#ad7dc3"));
        pane.setOpaqueInsets(new Insets(0.0));

        pane.setEffect(blend);

        friendsrequests.setLayoutX(9.0);
        friendsrequests.setLayoutY(86.0);
        friendsrequests.setPrefHeight(475.0);
        friendsrequests.setPrefWidth(341.0);

        email1.setEditable(false);
        email1.setMinWidth(0.0);
        email1.setPrefWidth(175.0);
        email1.setText("Email");

        actionAccept.setEditable(false);
        actionAccept.setPrefWidth(84.0);
        actionAccept.setText("Action");

        actionDecline.setEditable(false);
        actionDecline.setPrefWidth(81.0);
        actionDecline.setText("Action");
        borderPane.setRight(anchorPane0);

        BorderPane.setAlignment(pane0, javafx.geometry.Pos.CENTER);
        pane0.setPrefHeight(780.0);
        pane0.setPrefWidth(476.0);
      pane0.setStyle("-fx-background-color:#ccc5ec;");

        friendstable.setLayoutX(11.0);
        friendstable.setLayoutY(89.0);
        friendstable.setPrefHeight(473.0);
        friendstable.setPrefWidth(389.0);

        fname.setEditable(false);
        fname.setPrefWidth(106.0);
        fname.setText("First Name");

        lname.setEditable(false);
        lname.setPrefWidth(107.0);
        lname.setText("Last Name");

        email.setEditable(false);
        email.setPrefWidth(174.0);
        email.setText("Email");

        addfriend.setLayoutX(26.0);
        addfriend.setLayoutY(602.0);
        addfriend.setMnemonicParsing(false);
        addfriend.setPrefHeight(31.0);
        addfriend.setPrefWidth(134.0);
        addfriend.setText("Add Friend");
        addfriend.setFont(new Font("System Bold", 14.0));
        addfriend.setStyle("-fx-background-color:#C18BD9;-fx-font-family: 'Georgia'; -fx-background-radius: 15;-fx-text-fill:#e7ecf7;");
        
        removefriend.setStyle("-fx-background-color:#C18BD9;-fx-font-family: 'Georgia'; -fx-background-radius: 15;-fx-text-fill:#e7ecf7;");
        removefriend.setLayoutX(26.0);
        removefriend.setLayoutY(660.0);
        removefriend.setMnemonicParsing(false);
        removefriend.setText("Remove Friend");
        removefriend.setFont(new Font("System Bold", 14.0));
         removefriend.setPrefHeight(31.0);
        removefriend.setPrefWidth(134.0);
 
        textField.setLayoutX(167.0);
        textField.setLayoutY(602.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(233.0);
       
  
        textField.setStyle("-fx-background-color:#ffffff; -fx-font-family: 'Georgia';-fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        textField0.setStyle("-fx-background-color:#ffffff; -fx-font-family: 'Georgia';-fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        textField0.setLayoutX(167.0);
        textField0.setLayoutY(660.0);
        textField0.setPrefHeight(31.0);
        textField0.setPrefWidth(232.0);
        textField0.setStyle("-fx-background-radius: 10;");
        textField.setStyle("-fx-background-radius: 10;");
        textField0.setPromptText("enter email");
        textField.setPromptText("enter email");
        pane1.setLayoutX(122.0);
        pane1.setLayoutY(21.0);
        pane1.setPrefHeight(39.0);
        pane1.setPrefWidth(167.0);
        //pane1.setStyle("-fx-background-color: #d2f8d2; -fx-background-radius: 10;");/////////////////////////////
        pane1.setOpaqueInsets(new Insets(0.0));

        pane1.setEffect(blend0);

        text0.setLayoutX(-4.0);
        text0.setLayoutY(27.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("User Friends List");
        text0.setFont(new Font("Georgia Bold Italic", 25.0));
        
        borderPane.setCenter(pane0);

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
        pane.getChildren().add(text);
        anchorPane0.getChildren().add(pane);
        friendsrequests.getColumns().add(email1);
        friendsrequests.getColumns().add(actionAccept);
        friendsrequests.getColumns().add(actionDecline);
        anchorPane0.getChildren().add(friendsrequests);
        friendstable.getColumns().add(fname);
        friendstable.getColumns().add(lname);
        friendstable.getColumns().add(email);
        pane0.getChildren().add(friendstable);
        pane0.getChildren().add(addfriend);
        pane0.getChildren().add(removefriend);
        pane0.getChildren().add(textField);
        pane0.getChildren().add(textField0);
        pane1.getChildren().add(text0);
        pane0.getChildren().add(pane1);
        getChildren().add(borderPane);
	
        
        
        Socket socket = new Socket("127.0.0.1", 5005);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        PrintStream ps = new PrintStream(socket.getOutputStream());
        
        ps.println("userFriends");
        ps.println(LoginScene.curEmail);
        String userFriendsJsonString = dis.readLine();
        System.out.println(userFriendsJsonString);
        ArrayList<userFriendsDto> userFriendsList = jsonToArrayList(userFriendsJsonString);
        System.out.println(userFriendsList);
        ObservableList<userFriendsDto> userFriendsObservableList = FXCollections.observableArrayList(userFriendsList);
        System.out.println(userFriendsObservableList);
            // Set cell value factories for each column
        friendstable.setItems(userFriendsObservableList);
        fname.setCellValueFactory(new PropertyValueFactory<>("friend_fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("friend_lname"));
        email.setCellValueFactory(new PropertyValueFactory<>("friend_email"));
        
        
        ps.println("userRequests");
        ps.println(LoginScene.curEmail);
        String userFriendsJsonString1 = dis.readLine();
        System.out.println(userFriendsJsonString1);
        ArrayList<userFriendsDto> userFriendsList1 = jsonToArrayList1(userFriendsJsonString1);
        System.out.println(userFriendsList1);
        ObservableList<userFriendsDto> userFriendsObservableList1 = FXCollections.observableArrayList(userFriendsList1);
        System.out.println(userFriendsObservableList1);
            // Set cell value factories for each column
        friendsrequests.setItems(userFriendsObservableList1);
        email1.setCellValueFactory(new PropertyValueFactory<>("friend_email"));
    
        removefriend.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
         public void handle(ActionEvent event) {
        // Check if the text field is empty
        if (textField0.getText().isEmpty()) {
            // Display an error message
            JOptionPane.showMessageDialog(null, "Please enter a friend's name before removing.");
            return; // Exit the method without sending the request
        }
        
        if (textField.getText().equals(LoginScene.curEmail)) {
                JOptionPane.showMessageDialog(null, "You cannot add yourself as a friend.");
                 return; // Exit the method without sending the request
        }

        try {
            Socket socket = new Socket("127.0.0.1", 5005);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            PrintStream ps = new PrintStream(socket.getOutputStream());

            
            ps.println("removeFriend");
            ps.println(LoginScene.curEmail);
            ps.println(textField0.getText());

            String str = dis.readLine();

            if (str.equals("removalSuccess")) {
                deleteRowByFieldValue(friendstable, userFriendsObservableList, textField0);
                JOptionPane.showMessageDialog(null, "Friend is removed successfully ");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove friend");
            }

        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});

        
        addfriend.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textField.getText().isEmpty()) {
                // Display an error message
                JOptionPane.showMessageDialog(null, "Please enter a friend's name before adding.");
                return; // Exit the method without sending the request
                    }
                       try {
                    Socket socket = new Socket("127.0.0.1", 5005);
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println("addFriend");
                    ps.println(LoginScene.curEmail);
                    ps.println(textField.getText());
                    String str = dis.readLine();
                        if (str.equals("AddSuccess"))
                        {
                              
                                JOptionPane.showMessageDialog(null,"Request is sent successfully ");
                                
                        }
                        else{
                                JOptionPane.showMessageDialog(null,"The request has been sent before or the user is already a friend");
                            }
                } catch (IOException ex) {
                    Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        });
        
        
        actionDecline.setCellFactory(param -> new TableCell<userFriendsDto, Void>() {
                            private final Button declinebtn = new Button("Decline");

                            {
                                // Set the action for the button
                                declinebtn.setOnAction(event -> {
                                    try {
                                        userFriendsDto userrequest = getTableView().getItems().get(getIndex());
                                        Socket socket = new Socket("127.0.0.1", 5005);
                                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                                        PrintStream ps = new PrintStream(socket.getOutputStream());
                                        ps.println("declineRequest");
                                        ps.println(LoginScene.curEmail);
                                        ps.println(userrequest.getFriend_email());
                                        getTableView().getItems().remove(getIndex());
                                        getTableView().refresh();
                                        
                                    } catch (IOException ex) {
                                        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            }

                            @Override
                            protected void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);

                                // Display the button only if the cell is not empty
                                if (!empty) {
                                    setGraphic(declinebtn);
                                } else {
                                    setGraphic(null);
                                }
                            }
                        });

                        
        
        
        actionAccept.setCellFactory(param -> new TableCell<userFriendsDto, Void>() {
                            private final Button acceptbtn = new Button("Accept");

                            {
                                // Set the action for the button
                                acceptbtn.setOnAction(event -> {
                                    try {
                                        userFriendsDto userrequest1 = getTableView().getItems().get(getIndex());
                                        Socket socket = new Socket("127.0.0.1", 5005);
                                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                                        PrintStream ps = new PrintStream(socket.getOutputStream());
                                        ps.println("acceptRequest");
                                        ps.println(LoginScene.curEmail);
                                        ps.println(userrequest1.getFriend_email());
                                        
                                        getTableView().getItems().remove(getIndex());
                                        getTableView().refresh();
                                        friendstable.refresh();
                                        
                                        
                                    } catch (IOException ex) {
                                        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            }
                            

                            @Override
                            protected void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);

                                // Display the button only if the cell is not empty
                                if (!empty) {
                                    setGraphic(acceptbtn);
                                } else {
                                    setGraphic(null);
                                }
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
        friendsrequests.getStylesheets().add(cssFile);
        friendstable.getStylesheets().add(cssFile);    
            
                    
       }
}
