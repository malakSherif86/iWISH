package loginscene;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginScene extends BorderPane {

    protected final AnchorPane rightAnchor;
    protected final ImageView lockImg;
    protected final TextField userNameTF;
    protected final PasswordField passwordTF;
    protected final Button loginButton;
    protected final Button signupButton;
    
    protected final ImageView logoImg;
    private Parent root;
    private Stage stage;
    private Scene scene;
    static Socket socket;
    static DataInputStream dis ;
    static PrintStream ps ;
    public static String curEmail;
    


    public LoginScene() {

        rightAnchor = new AnchorPane();
        lockImg = new ImageView();
        userNameTF = new TextField();
        passwordTF = new PasswordField();
        loginButton = new Button();
        signupButton = new Button();
        
        logoImg = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(rightAnchor, javafx.geometry.Pos.CENTER);
        rightAnchor.setPrefHeight(26.0);
        rightAnchor.setPrefWidth(417.0);
        
        ////////
        lockImg.setFitHeight(200.0);
        lockImg.setFitWidth(200.0);
        lockImg.setLayoutX(210.0);
        lockImg.setLayoutY(90.0);
        lockImg.setPickOnBounds(true);
        lockImg.setPreserveRatio(true);
        lockImg.setImage(new Image(getClass().getResource("logopur.png").toExternalForm()));

        
        

        userNameTF.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        userNameTF.setCache(true);
        userNameTF.setLayoutX(220.0);
        userNameTF.setLayoutY(170.0);
        userNameTF.setPromptText("Email");
        userNameTF.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");


        passwordTF.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        passwordTF.setCache(true);
        passwordTF.setLayoutX(220.0);
        passwordTF.setLayoutY(230.0);
        passwordTF.setPromptText("Password");
        passwordTF.setStyle("-fx-background-color:#ffffff; -fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");

        loginButton.setLayoutX(190.0);
        loginButton.setLayoutY(280.0);
        loginButton.setMnemonicParsing(false);
        loginButton.setPrefHeight(42.0);
        loginButton.setPrefWidth(256.0);
        loginButton.setStyle("-fx-background-color: #C188D9; -fx-background-radius: 22;-fx-text-fill:#F2F2F2;");
        loginButton.setText("Login");

        signupButton.setLayoutX(190.0);
        signupButton.setLayoutY(333.0);
        signupButton.setMnemonicParsing(false);
        signupButton.setPrefHeight(42.0);
        signupButton.setPrefWidth(256.0);
        signupButton.setStyle("-fx-background-color: #C188D9; -fx-background-radius: 22;-fx-text-fill:#F2F2F2;");
        signupButton.setText("Sign up");
        
        setCenter(rightAnchor);

        String imagePath = "99.jpg"; // Change this to the actual path of your image
        Image backgroundImage = new Image(getClass().getResource(imagePath).toExternalForm());
        
        // Set the BackgroundSize to 100% width and height without preserving the aspect ratio
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        rightAnchor.setBackground(new Background(background));


        

        rightAnchor.getChildren().add(lockImg);
        rightAnchor.getChildren().add(userNameTF);
        rightAnchor.getChildren().add(passwordTF);
        rightAnchor.getChildren().add(loginButton);
        rightAnchor.getChildren().add(signupButton);
        
        
        loginButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    socket = new Socket("127.0.0.1", 5005);
                    dis = new DataInputStream(socket.getInputStream());
                    ps = new PrintStream(socket.getOutputStream());
                    
                    if (userNameTF.getText().isEmpty() || passwordTF.getText().isEmpty()){
                        userNameTF.clear();
                        passwordTF.clear();
                        JOptionPane.showMessageDialog(null,"Failed Log in, Empty Email or Password");
                    } 
                    else
                    {
                        try {
                            ps.println("loginReq");
                            Logindto logindto = new Logindto(userNameTF.getText(),passwordTF.getText());
                            ps.println(logindto.getEmail());
                            ps.println(logindto.getPassword());
                            String str = dis.readLine();
                            if (str.equals("loginSuccess"))
                                {
                                    LoginScene.curEmail = userNameTF.getText();
                                    //System.out.println(LoginScene.curEmail);
                                    Parent root = new  HomePageClass();
                                    scene = new Scene(root);
                                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                                    //scene.getStylesheets().add("CSS/tableStyle.css");
                                    stage.setScene(scene);
                                    stage.show();
                                }
                                else{
                                        JOptionPane.showMessageDialog(null,"Failed Log in, Wrong Email or passwod");
                                    }
                            } catch (IOException ex) {
                                        Logger.getLogger(LoginScene.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        
                           
                 
                catch (IOException ex) {
                    Logger.getLogger(LoginScene.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        
        signupButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Parent root = new  RegisterBase();
               scene = new Scene(root);
               stage =(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();

            }
        });
    }
}
