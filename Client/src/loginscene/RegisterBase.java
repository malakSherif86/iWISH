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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static loginscene.LoginScene.dis;
import static loginscene.LoginScene.ps;
import static loginscene.LoginScene.socket;
import javafx.scene.control.Hyperlink;

public  class RegisterBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final ImageView imageView;
    //  protected final Label label0;
    protected final TextField FirstnameTextField;
    //  protected final Label label1;
    protected final TextField lastnameTextField;
    //  protected final Label label2;
    protected final TextField usernameTextField;
    // protected final Label label3;
    protected final PasswordField setPassword;
    protected final Button registerButton;
    private Parent root;
    private Stage stage;
    private Scene scene;
    static Socket socket;
    static DataInputStream dis ;
    static PrintStream ps ;
    protected final AnchorPane rightAnchor;
    protected final Hyperlink loginLink;  // Add a Hyperlink for the login scene
    
    public RegisterBase() {
        
        
        anchorPane = new AnchorPane();
        label = new Label();
        imageView = new ImageView();
        //  label0 = new Label();
        FirstnameTextField = new TextField();
        //  label1 = new Label();
        lastnameTextField = new TextField();
        // label2 = new Label();
        usernameTextField = new TextField();
        //  label3 = new Label();
        setPassword = new PasswordField();
        registerButton = new Button();
         rightAnchor = new AnchorPane();
        BorderPane.setAlignment(rightAnchor, javafx.geometry.Pos.CENTER);
        rightAnchor.setPrefHeight(26.0);
        rightAnchor.setPrefWidth(417.0);
        loginLink = new Hyperlink("Already have an account? Login");  // Text for the hyperlink
        
 
    setBackground(new Background(new BackgroundImage(
                new Image(getClass().getResource("99.jpg").toExternalForm(), true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        

        setId("AnchorPane");
        setPrefHeight(460.0);
        setPrefWidth(520.0);

        anchorPane.setPrefHeight(82.0);
        anchorPane.setPrefWidth(520.0);
        anchorPane.setStyle("-fx-background-color:#C18BD9;");
        
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(imageView);
        getChildren().add(anchorPane);
       // getChildren().add(label0);
        getChildren().add(FirstnameTextField);
       // getChildren().add(label1);
        getChildren().add(lastnameTextField);
       // getChildren().add(label2);
        getChildren().add(usernameTextField);
        //getChildren().add(label3);
        getChildren().add(setPassword);
        getChildren().add(registerButton);

        label.setLayoutX(175.0);
        label.setLayoutY(30.0);
        label.setText("User Registeration");
      // label.setTextFill(javafx.scene.paint.Color.WHITE);
       
        label.setFont(new Font("georgia",20.0));

        label.setTextFill(Color.web("#F2F2F2"));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(150.0);
        imageView.setLayoutX(9.0);
        imageView.setLayoutY(25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("whitelogo.png").toExternalForm()));

     
        FirstnameTextField.setLayoutX(92.0);
        FirstnameTextField.setLayoutY(128.0);
        FirstnameTextField.setPrefHeight(25.0);
        FirstnameTextField.setPrefWidth(336.0);
        FirstnameTextField.setPromptText("Firstname");
        

      

        lastnameTextField.setLayoutX(92.0);
        lastnameTextField.setLayoutY(195.0);
        lastnameTextField.setPrefHeight(25.0);
        lastnameTextField.setPrefWidth(336.0);
        lastnameTextField.setPromptText("Lastname");


        usernameTextField.setLayoutX(92.0);
        usernameTextField.setLayoutY(265.0);
        usernameTextField.setPrefHeight(25.0);
        usernameTextField.setPrefWidth(336.0);
        usernameTextField.setPromptText("email");

       
        setPassword.setLayoutX(92.0);
        setPassword.setLayoutY(331.0);
        setPassword.setPrefHeight(25.0);
        setPassword.setPrefWidth(336.0);
        setPassword.setPromptText("Password");

        registerButton.setLayoutX(217.0);
        registerButton.setLayoutY(384.0);
        registerButton.setMnemonicParsing(false);
        registerButton.setPrefHeight(27.0);
        registerButton.setPrefWidth(80.0);
       // registerButton.setStyle("-fx-background-color: #90ee90;");
        registerButton.setText("Register");
      //  registerButton.setTextFill(javafx.scene.paint.Color.WHITE);
        registerButton.setFont(new Font("merriweather ",13.0));
        
        loginLink.setLayoutX(160.0);
        loginLink.setLayoutY(420.0);
        loginLink.setFont(new Font("merriweather", 13.0));
        loginLink.setTextFill(Color.web("#BA73D9"));

        // Add the login hyperlink to the scene
        getChildren().add(loginLink);

  
        registerButton.setStyle("-fx-background-color: #C188D9;-fx-font-family: 'Georgia'; -fx-background-radius: 22;-fx-text-fill:#F2F2F2;");
        FirstnameTextField.setStyle("-fx-background-color: #ffffff;-fx-font-family: 'Georgia'; -fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        usernameTextField.setStyle("-fx-background-color:#ffffff; -fx-font-family: 'Georgia';-fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        lastnameTextField.setStyle("-fx-background-color: #ffffff; -fx-font-family: 'Georgia';-fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        setPassword.setStyle("-fx-background-color: #ffffff;-fx-font-family: 'Georgia'; -fx-background-radius: 22; -fx-prompt-text-fill:#BA73D9;");
        
        loginLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Switch to the login scene
                Parent root = new LoginScene();
                Scene loginScene = new Scene(root);
                Stage currentStage = (Stage) getScene().getWindow();
                currentStage.setScene(loginScene);
                currentStage.show();
            }
        });
        registerButton.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    socket = new Socket("127.0.0.1", 5005);
                    dis = new DataInputStream(socket.getInputStream());
                    ps = new PrintStream(socket.getOutputStream());
                    
                    ps.println("registerReq");
                    ps.println(FirstnameTextField.getText());
                    ps.println(lastnameTextField.getText());
                    ps.println(usernameTextField.getText());
                    ps.println(setPassword.getText());
                    if (FirstnameTextField.getText().isEmpty() || lastnameTextField.getText().isEmpty() || 
                            usernameTextField.getText().isEmpty() || setPassword.getText().isEmpty())
                    {JOptionPane.showMessageDialog(null,"Please fill empty fields");}
                    
                    else
                    {
                        new Thread(){
                            @Override
                            public void run(){
                                while (true)
                                {
                                    try {
                                        String str = dis.readLine();
                                        if (str.equals("RegisterationSuccess"))
                                        {
                                            JOptionPane.showMessageDialog(null,"Registeration Successed");
                                            Platform.runLater(new Runnable(){
                                                @Override
                                                public void run() {
                                                    Parent root = new  LoginScene();
                                                    scene = new Scene(root);
                                                    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                                                    stage.setScene(scene);
                                                    stage.show();
                                                }
                                            });
                                        
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"Failed Register, Enter valid Email");
                                        }
                                    } catch (IOException ex) {
                                        Logger.getLogger(LoginScene.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }.start();
                    
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(RegisterBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
