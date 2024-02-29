package com.mycompany.makeupstoreapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.StackPane; 
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import static javafx.scene.effect.BlendMode.BLUE;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * JavaFX App
 */
public class App extends Application {
    ScrollBar redScroller;
    ScrollBar greenScroller;
    ScrollBar blueScroller;
    Label redLabel;
    Label greenLabel;
    Label blueLabel;
    Rectangle selectedColorShape, selectedColorShape1, selectedColorShape2;
    Label selectedColorLabel;
    Color color = Color.rgb(202, 101, 127, 1);

    static int speed = 1;
    static int totalScore = -1;
    static int foodcolor = 0;
    static int width = 17;
    static int height = 29;
    static int foodX = 0;
    static int foodY = 0;
    static int cornersize = 25;
    static List<Corner> snake = new ArrayList<>();
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static Random rand = new Random();
    // Declare a flag to track if the alert has been shown
    private static boolean alertShown = false;
       private int count1 = 1;
    private int count2 = 1;
    private int count3 = 1;
    private int count4 = 1;
    private int count5 = 1;
    //lip
    private int count1wine = 1;
    private int count2charry = 1;
    private int count3delight = 1;
    //face
    private int count1primer = 1;
    private int count2plush = 1;
    private int count3concealer = 1;
    private int count4highliter = 1;
    private int count5fondation = 1;
    private int count6spray = 1;
    private int totalitemsofAll=0;
    int totalpriceofAll;
    String totalpriceofAllOS= String.valueOf(totalpriceofAll); ;

    private TextField cardNumber;
    private TextField expiryDate;
    private TextField cardHolder;
    private TextField cvv;
    private RadioButton CardButton;
    private RadioButton applePayButton;
    private RadioButton CashButton;
    int ordnumDB;

    Scene scene1;// CATEGORY SCENE
    Scene scene;// LIPS SCENE
    Scene scene4;// FACE SCENE
    Scene scene2;//EYES SCENE
    Scene scene9;// CART SCENE
Scene Shscene;// SHIPPING SCENE
    private products currentProducts = new products();


  public String getColorValue() {
        return "Color: " + (int) redScroller.getValue() + ", " + (int) greenScroller.getValue() + ", " + (int) blueScroller.getValue();
    }

    public enum Dir {
        left, right, up, down
    }

    public static class Corner {

        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    @Override
    public void start(Stage stage) {
      Color headersCB = Color.web("#E8708C",1.0); // Pink 
      Color titleCP=Color.web("#393646",1.0); //the Darkest shade of Purple
      Color Background=Color.web("#FDF8F8",0.5); //Background color

 ////______________________________________________
 ////______________________________________________
 ////------------------OPENING PAGE-------------------
 ////______________________________________________
 ////______________________________________________      
        
        
         BorderPane OPn=new BorderPane();
         StackPane stOP = new StackPane();
        VBox vboxOP = new VBox();
        VBox vbox2OP = new VBox();
     
        ImageView logoImageOP= new ImageView("https://mrkzgulfup.com/do.php?img=74167");
        logoImageOP.setFitHeight(150); 
        logoImageOP.setFitWidth(150);
        logoImageOP.setTranslateX(380);
        logoImageOP.setTranslateY(575);
          
         Button logoImage1OP=new Button(); 
       logoImage1OP.setGraphic(logoImageOP);
       logoImage1OP.setStyle("-fx-background-color: transparent");
           

          
         vboxOP.getChildren().add(logoImage1OP);

         
        ImageView openPage= new ImageView("https://mrkzgulfup.com/do.php?img=74827");
        openPage.setFitHeight(750); 
        openPage.setFitWidth(600);
   
         vbox2OP.getChildren().add(openPage);
    
     ScaleTransition scaleTransitionOP = new ScaleTransition();

        scaleTransitionOP.setDuration(Duration.seconds(10));
   
        scaleTransitionOP.setNode(logoImageOP);

        scaleTransitionOP.setByY(1);
        scaleTransitionOP.setByX(1);    

       scaleTransitionOP.setCycleCount(-1);

        scaleTransitionOP.setAutoReverse(true);

       scaleTransitionOP.play();
  
      stOP.getChildren().addAll(vbox2OP,vboxOP);
        OPn.setCenter(stOP);
        Scene sceneOP = new Scene(OPn, 600, 750);
        stage.setScene(sceneOP);
 
 ////______________________________________________
 ////______________________________________________
 ////---------------- END OPENING PAGE-----------------
 ////______________________________________________
 ////______________________________________________      
          
        
     

 ////______________________________________________
 ////______________________________________________
 ////------------------LOG IN PAGE-------------------
 ////______________________________________________
 ////______________________________________________      
 
        VBox border = new VBox(30);//space betwwen the boxes

        TextField EmailOP = new TextField();
        EmailOP.setMinWidth(300);
        EmailOP.setMaxWidth(400);
        EmailOP.setPromptText("Enter your Email..");
        
        
         Tooltip tooltipOP = new Tooltip();
         tooltipOP.setText("Password should be at least 8 characters");
         
        Image tool = new Image("https://cdn-icons-png.flaticon.com/512/11199/11199372.png");
        ImageView tool1 = new ImageView(tool);
        tool1.setFitHeight(35);
        tool1.setFitWidth(35);
        tooltipOP.setGraphic(tool1);
        tooltipOP.getHideDelay();
        tooltipOP.setShowDuration(Duration.seconds(0));
        tooltipOP.getShowDelay();
      
        PasswordField Pass = new PasswordField();
        Pass.setTooltip(tooltipOP);
        Pass.setMinWidth(300);
        Pass.setMaxWidth(400);
        Pass.setPromptText("Enter your Password..");

        Label lb1LI = new Label("Hello there, Log in");
        lb1LI.setFont(Font.font("Bell MT", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 28));

        Image velvetLI = new Image("https://mrkzgulfup.com/do.php?img=67647");
        ImageView logoLI = new ImageView(velvetLI);
        logoLI.setFitHeight(140);
        logoLI.setFitWidth(140);
        logoLI.setX(20);
        logoLI.setY(20);
        logoLI.setPreserveRatio(true);

        Button bt1LI = new Button(" Login ");
        
        bt1LI.setStyle("-fx-background-color:#E8708C; -fx-background-size: cover;  -fx-text-color:#393646; -fx-font: normal bold 15px 'Bell MT';");
        Label lb2LI = new Label("if you don't have an account");
        lb2LI.setFont(Font.font("Bell MT", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 17));
         Button Sign = new Button(" SignIn ");
        Sign.setStyle("-fx-background-color:#E8708C; -fx-background-size: cover;  -fx-text-color:#393646; -fx-font: normal bold 15px 'Bell MT';");
        
        
        border.getChildren().addAll(logoLI, lb1LI, EmailOP, Pass, bt1LI, lb2LI, Sign);
        border.setAlignment(Pos.CENTER);
        border.setStyle("-fx-background-color:rgb(63, 46, 62,0.10)");
        
        
        Scene LogIn = new Scene(border, 600, 750);
        
         logoImage1OP.setOnAction(e->{
          stage.setScene(LogIn); 
         });
 
         border.setStyle("-fx-background-color:#FDF8F8;");
            
       
 ////______________________________________________
 ////______________________________________________
 ////---------------END LOG IN PAGE----------------
 ////______________________________________________
 ////______________________________________________     
 
 
 
 ////______________________________________________
 ////______________________________________________
 ////------------------SINGIN PAGE------------------
 ////______________________________________________
 ////______________________________________________     
    Text NameTFS = new Text("Enter your name: ");
        NameTFS.setFill(Color.web("#4c3a5e"));
        TextField NametextTFS= new TextField();
        NametextTFS.setPromptText("Enter your User name....");
      String  NametextTFTS=NametextTFS.getText().toString();
        
        Text Email2TFS = new Text("Enter your email: ");
        Email2TFS.setFill(Color.web("#4c3a5e"));
        TextField EmailtextTFS= new TextField();
        
        EmailtextTFS.setPromptText("Enter your email....");
        String userEm=EmailtextTFS.getText().toString();
        
        Text Phone_No = new Text("Enter your phone number: ");
        Phone_No.setFill(Color.web("#4c3a5e"));
        TextField Phone_Notext= new TextField();
        Phone_Notext.setPromptText("966....");
      String  phToS=Phone_Notext.getText().toString();

        Text PassWord = new Text("Enter your password: ");
        PassWord.setFill(Color.web("#4c3a5e"));
        PasswordField PassWordtext= new PasswordField();
        PassWordtext.setTooltip(tooltipOP);
        Text confirmPassWord = new Text("confirm your password: ");
        confirmPassWord.setFill(Color.web("#4c3a5e"));
        PasswordField confirmPassWordtext= new PasswordField();
        confirmPassWordtext.setTooltip(tooltipOP);
        String PassWordtextTS=PassWordtext.getText().toString();
        VBox labelsSI = new VBox(20);
        labelsSI.setAlignment(Pos.CENTER);
        labelsSI.setPadding(new Insets(250));
        labelsSI.getChildren().addAll(NameTFS,NametextTFS,Email2TFS,EmailtextTFS,Phone_No,Phone_Notext,PassWord,PassWordtext,confirmPassWord,confirmPassWordtext);

        
            
        //logo pattern
        
        Image imageTFS = new Image("https://mrkzgulfup.com/do.php?img=73590");
        ImageView imageTFSV=new ImageView(imageTFS);
           imageTFSV.setFitWidth(150);
           imageTFSV.setFitHeight(150);
        //lebels background
        // Create a Rectangle object
        Rectangle rectangleTFS = new Rectangle(300, 450);
        rectangleTFS.setArcWidth(20); // Set the horizontal radius of the rounded corners
        rectangleTFS.setArcHeight(20); // Set the vertical radius of the rounded corners
        rectangleTFS.setFill(Color.web("#FFFFFF")); // Set the fill color of the rectangle

        Button Sing_InB =new Button("Sing In");
        Sing_InB.setStyle("-fx-color: #db798d;");
        Sing_InB.setTranslateY(250);
        
     
                
        Button login_signinBt =new Button("Login");
        //login_signinBt.setStyle("-fx-color: #db798d;");

        Label login_signinBtlbl=new Label("I have an account",login_signinBt)  ;
        login_signinBtlbl.setContentDisplay(ContentDisplay.BOTTOM);
        login_signinBtlbl.setTranslateY(298);
        
        
        StackPane stacklabels = new StackPane();
        stacklabels.getChildren().addAll(rectangleTFS,labelsSI,Sing_InB,login_signinBtlbl);
        
        //--- a listener to only add digits & a pop massage----
        Phone_Notext.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Phone_Notext.setText(newValue.replaceAll("[^\\d]", ""));

                // Display a popup message when a letter is inserted
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please enter only digits in the phone number.");

                alert.showAndWait();
                // Revert the text value to the previous valid value
                Phone_Notext.setText(oldValue);
            }
        });



        //the interface
        VBox singIn = new VBox();

        singIn.getChildren().addAll(imageTFSV,stacklabels);
          singIn.setAlignment(Pos.TOP_CENTER);
          stacklabels.setTranslateY(-200);

     
        Sing_InB.setStyle("-fx-background-color:#E8708C; -fx-background-size: cover;  -fx-text-color:#393646; -fx-font: normal bold 15px 'Bell MT';");
        login_signinBt.setStyle("-fx-background-color:#E8708C; -fx-background-size: cover;  -fx-text-color:#393646; -fx-font: normal bold 15px 'Bell MT';");
        Scene SingIN = new Scene( singIn,600, 750);
      
          singIn.setStyle("-fx-background-color:#FDF8F8;");
          SingIN.setFill(Background);
 
        
        
        
        
        
        login_signinBt.setOnAction(e->{
          stage.setScene(LogIn); 
         });
        
        
         Sign.setOnAction(e->{
          stage.setScene(SingIN); 
         });
  ////______________________________________________
 ////______________________________________________
 ////------------------END SINGIN PAGE-------------------
 ////______________________________________________
 ////______________________________________________     
 
 
 
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
 ////______________________________________________
 ////______________________________________________
 ////------------------HOME PAGE-------------------
 ////______________________________________________
 ////______________________________________________
 

 BorderPane BP=new BorderPane();
  Scene HPScene=new Scene(BP,600,750);
    HPScene.setFill(Background);
    
    
 bt1LI.setOnAction(e->{
     stage.setScene(HPScene);

 
 });
 
 

//---------------TOP-----------------//
HBox HBTopL=new HBox(50);
//Logo
ImageView logoImage=new ImageView("https://mrkzgulfup.com/do.php?img=73590");
logoImage.setFitHeight(150); 
logoImage.setFitWidth(150); 
logoImage.setTranslateY(5);

//logo Background
ImageView logoBGImage=new ImageView("https://mrkzgulfup.com/do.php?img=73584");
logoBGImage.setFitWidth(600); 

HBTopL.getChildren().add(logoImage);
HBTopL.setAlignment(Pos.CENTER);

HBox HBTopLBg=new HBox();
HBTopLBg.getChildren().add(logoBGImage);
HBTopLBg.setAlignment(Pos.TOP_CENTER);

StackPane stackTop= new StackPane();
stackTop.getChildren().addAll(HBTopLBg,HBTopL);

BP.setTop(stackTop);



//--------------Center-------------------//
HBox center1=new HBox();
StackPane stackcenter= new StackPane();

Image codeImage1=new Image("https://mrkzgulfup.com/do.php?img=73583");
Image PosImage=new Image("https://mrkzgulfup.com/do.php?img=73594");

ImageView HPImage=new ImageView(codeImage1); //discount Code Pic
HPImage.setFitHeight(200); 
HPImage.setFitWidth(220);


Button lABt=new Button();
ImageView leftArow=new ImageView("https://mrkzgulfup.com/do.php?img=73591"); // Left Arrow Code Pic
leftArow.setFitHeight(70); 
leftArow.setFitWidth(70);
lABt.setGraphic(leftArow);
lABt.setStyle("-fx-background-color: #FDF8F8;");
        
ImageView picBG=new ImageView("https://mrkzgulfup.com/do.php?img=73582"); //Images background Code 
picBG.setFitHeight(230); 
picBG.setFitWidth(280);


Button rABt=new Button();
ImageView rightArow=new ImageView("https://mrkzgulfup.com/do.php?img=73592"); //Images background Code 
rightArow.setFitHeight(70); 
rightArow.setFitWidth(70);
rABt.setGraphic(rightArow);
rABt.setStyle("-fx-background-color: #FDF8F8;");


center1.getChildren().addAll(lABt,picBG,rABt);
center1.setAlignment(Pos.CENTER);

stackcenter.getChildren().addAll(center1,HPImage);

//------arrows Buttons action--------
rABt.setOnAction(e -> {
 HPImage.setImage(PosImage);

 
});

 lABt.setOnAction(e -> {
HPImage.setImage(codeImage1);

 });
//----------------------------------------

HBox center2=new HBox(50);
center2.setPadding(new Insets(0,20, 0, 40));

//testers Image
ImageView testerIc =new ImageView("https://mrkzgulfup.com/do.php?img=75130");
testerIc.setFitHeight(120); 
testerIc.setFitWidth(120); 


Button testerbT=new Button();
testerbT.setGraphic(testerIc);
testerbT.setStyle("-fx-background-color: transparent");
testerbT.setTranslateY(-130);
testerbT.setTranslateX(-200);

testerbT.setOnAction(e->{
 Alert alerttTesterMesage= new Alert(Alert.AlertType.INFORMATION);
            alerttTesterMesage.setTitle("TESTERS SERVICES");
            alerttTesterMesage.setHeaderText("♡COMING SOON♡");
            alerttTesterMesage.setContentText("insta account");
            alerttTesterMesage.getDialogPane().setStyle("-fx-background-color: #EEA19F;");
            alerttTesterMesage.showAndWait();
});

//Game Icon

ImageView gameIcon =new ImageView("https://mrkzgulfup.com/do.php?img=75128");
gameIcon.setFitHeight(120); 
gameIcon.setFitWidth(120); 

Button gameBt=new Button();
gameBt.setGraphic(gameIcon);
gameBt.setStyle("-fx-background-color: transparent");
gameBt.setTranslateY(-127);
gameBt.setTranslateX(-20);


//choose your color
StackPane clrStack=new StackPane();

ImageView sugClor =new ImageView("https://mrkzgulfup.com/do.php?img=75132");
sugClor.setFitHeight(230); 
sugClor.setFitWidth(180); 

Button colorBt=new Button();
colorBt.setGraphic(sugClor);
colorBt.setStyle("-fx-background-color: transparent");
colorBt.setTranslateY(-10);
colorBt.setTranslateX(180);


//------


//--------Chat--------
//chat Image
ImageView chMA =new ImageView("https://mrkzgulfup.com/do.php?img=75233");
chMA.setFitHeight(120); 
chMA.setFitWidth(120); 
//chat button 
Button chMABt=new Button();

chMABt.setGraphic(chMA);
chMABt.setStyle("-fx-background-color: transparent");
chMABt.setTranslateY(30);
chMABt.setTranslateX(-200); 

ImageView alertIAc=new ImageView("https://mrkzgulfup.com/do.php?img=75561");
alertIAc.setFitWidth(250);
alertIAc.setFitHeight(250);
chMABt.setOnAction(e->{
 Alert alertChatmesage= new Alert(Alert.AlertType.INFORMATION);
            alertChatmesage.setHeaderText(" ");
            alertChatmesage.setTitle("♡♡Our Accounts♡♡");
            alertChatmesage.setGraphic(alertIAc);
            alertChatmesage.setHeight(250);
            alertChatmesage.setWidth(250);

            alertChatmesage.showAndWait();
});
//--------Location--------
// Image
ImageView locatIm =new ImageView("https://mrkzgulfup.com/do.php?img=75558");
locatIm.setFitHeight(120); 
locatIm.setFitWidth(120); 

//chat button 
Button locationBt=new Button();
locationBt.setGraphic(locatIm);
locationBt.setStyle("-fx-background-color: transparent");
locationBt.setTranslateY(30);
locationBt.setTranslateX(-22);

locationBt.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Our Location");
            alert.setHeaderText(" ");
            Image locationImage = new Image("https://mrkzgulfup.com/do.php?img=75567");
            ImageView locationImage1 = new ImageView(locationImage);
            locationImage1.setPreserveRatio(true); // Preserve the aspect ratio of the image
            locationImage1.setFitWidth(Double.MAX_VALUE); // Set the width to match its parent
            locationImage1.setFitHeight(600); 
            alert.setGraphic(locationImage1);
            alert.getDialogPane().setStyle("-fx-background-color: #EEA19F;");
            alert.showAndWait();
        });



//--------------------------------------
VBox centerVB=new VBox(40);
centerVB.getChildren().addAll(stackcenter);
clrStack.getChildren().addAll(centerVB,chMABt,testerbT,gameBt,colorBt,locationBt);
clrStack.setAlignment(Pos.BOTTOM_CENTER);

BP.setCenter(clrStack);

//---------------BOTTOM------------------//
HBox HBBot=new HBox(20);

//----Home page----
//Home page Image
ImageView homePageIc=new ImageView("https://mrkzgulfup.com/do.php?img=73585");
homePageIc.setFitHeight(85); 
homePageIc.setFitWidth(85);

//Home Page Button
Button hPBt=new Button(); 
hPBt.setGraphic(homePageIc);
hPBt.setStyle("-fx-background-color: transparent");

//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryIc= new ImageView("https://mrkzgulfup.com/do.php?img=73589");
categoryIc.setFitHeight(85); 
categoryIc.setFitWidth(85);

//Catetoreies Button

Button catoBt=new Button(); 
catoBt.setGraphic(categoryIc );
catoBt.setStyle( "-fx-background-color: transparent");

//----Cart Page----
//Cart Page Image

ImageView cartIc= new ImageView("https://mrkzgulfup.com/do.php?img=73587");
cartIc.setFitHeight(85); 
cartIc.setFitWidth(85);

//Cart Button

Button cartBt=new Button(); 
cartBt.setGraphic(cartIc );
cartBt.setStyle( "-fx-background-color: transparent");

//----Brand Page----
//Brand Page Image

ImageView brandIc= new ImageView("https://mrkzgulfup.com/do.php?img=73588");
brandIc.setFitHeight(85); 
brandIc.setFitWidth(85);

//Brand Button

Button brandBt=new Button(); 
brandBt.setGraphic(brandIc);
brandBt.setStyle( "-fx-background-color: transparent");

//----Account Page----
//Account Page Image

ImageView acontIc= new ImageView("https://mrkzgulfup.com/do.php?img=73586");
acontIc.setFitHeight(85); 
acontIc.setFitWidth(85);

//Account Button

Button acontBt=new Button(); 
acontBt.setGraphic(acontIc);
acontBt.setStyle( "-fx-background-color: transparent");


//-------Buttons Background-------
ImageView icnBG= new ImageView("https://mrkzgulfup.com/do.php?img=73593");
icnBG.setFitHeight(120); 
icnBG.setFitWidth(600);

HBBot.getChildren().addAll(hPBt ,catoBt,cartBt,brandBt,acontBt);
HBBot.setAlignment(Pos.BOTTOM_CENTER);
HBBot.setTranslateY(-6);

StackPane stack= new StackPane(icnBG,HBBot);
stack.setTranslateY(20);
//-----set Buttons in the Bottom-----
BP.setBottom(stack);
//----------------------------------------
    BP.setStyle("-fx-background-color: #FDF8F8;");

   
    
             
 ////______________________________________________
 ////______________________________________________
 ////----------------HOME PAGE END-----------------
 ////______________________________________________
 ////______________________________________________
    
    
    
 // ------------------------------------------------ 
    
 ////______________________________________________
 ////______________________________________________
 ////----------------ACCOUNT PAGE------------------
 ////______________________________________________
 ////______________________________________________
  
 BorderPane AcBP=new BorderPane();
 AcBP.setStyle("-fx-background-color: #FDF8F8;");

//---------------TOP-----------------//
HBox HBTopAc=new HBox(50);
//Logo
ImageView logoImageAc=new ImageView("https://mrkzgulfup.com/do.php?img=73590");
logoImageAc.setFitHeight(150); 
logoImageAc.setFitWidth(150); 
logoImageAc.setTranslateY(10);
//logo Background
ImageView logoBGImageAc=new ImageView("https://mrkzgulfup.com/do.php?img=73584");
logoBGImageAc.setFitWidth(600); 

HBTopAc.getChildren().add(logoImageAc);
HBTopAc.setAlignment(Pos.CENTER);

HBox HBTopLBgAc=new HBox();
HBTopLBgAc.getChildren().add(logoBGImageAc);
HBTopLBgAc.setAlignment(Pos.TOP_CENTER);

StackPane stackAcTop= new StackPane();
stackAcTop.getChildren().addAll(HBTopAc);


 
    Scene AcontScene=new Scene(AcBP,600,750);
    acontBt.setOnAction(e->{
   stage.setScene(AcontScene); 

});
//--------------Left-------------------//
//setting icon
VBox acSAO=new VBox(10);//acount setting and Order


ImageView acSetting= new ImageView("https://mrkzgulfup.com/do.php?img=73921");
acSetting.setFitHeight(65); 
acSetting.setFitWidth(65);

Button acSettingBt=new Button();
acSettingBt.setStyle("-fx-background-color: transparent");
acSettingBt.setGraphic(acSetting);


//Order Icon
ImageView acOrder= new ImageView("https://mrkzgulfup.com/do.php?img=74477");
acOrder.setFitHeight(60); 
acOrder.setFitWidth(60);

Button acOrderBt=new Button();
acOrderBt.setStyle("-fx-background-color: transparent");
acOrderBt.setGraphic(acOrder);


acSAO.getChildren().addAll(acSettingBt,acOrderBt); //setting buttons to vbox
acSAO.setAlignment(Pos.TOP_LEFT);
acSAO.setTranslateY(-70);

 //---------------CENTER------------------//
 VBox VBAcCnt=new VBox(20);
//Ivtar
ImageView AvtarIm=new ImageView("https://mrkzgulfup.com/do.php?img=73668");
AvtarIm.setFitHeight(200); 
AvtarIm.setFitWidth(200);

//name Labeles
Label nameLB=new Label("Name:");
nameLB.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 25));

Label userNameLB=new Label(" We are Waiting to know your Name♡ ");
userNameLB.setFont(Font.font("BELL MT", FontWeight.BOLD, FontPosture.REGULAR, 20));
userNameLB.setStyle("-fx-text-fill: #E8708C; ");

//Email Labeles

Label emailLB=new Label("Email:");
emailLB.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 25));

Label UserEmailLB=new Label();
//EmailtextTFS.textProperty().bind(UserEmailLB.textProperty());
UserEmailLB.textProperty().bind(EmailtextTFS.textProperty());

UserEmailLB.setFont(Font.font("BELL MT", FontWeight.BOLD, FontPosture.REGULAR, 20));
UserEmailLB.setStyle("-fx-text-fill: #E8708C; ");

//Extra
VBox pinkI=new VBox();
ImageView PinkBG= new ImageView("https://mrkzgulfup.com/do.php?img=73669");
PinkBG.setFitHeight(500); 
PinkBG.setFitWidth(400);
PinkBG.setTranslateX(160);
PinkBG.setTranslateY(-180);

pinkI.getChildren().addAll(PinkBG);
pinkI.setAlignment(Pos.TOP_RIGHT);

VBox purpleI=new VBox();
ImageView purpleBG= new ImageView("https://mrkzgulfup.com/do.php?img=73670");
purpleBG.setFitHeight(500); 
purpleBG.setFitWidth(400);
purpleBG.setTranslateX(-180);
purpleBG.setTranslateY(250);
purpleI.getChildren().addAll(purpleBG);
purpleI.setAlignment(Pos.BOTTOM_LEFT);
///


/////////////////////////////

VBAcCnt.getChildren().setAll(AvtarIm,nameLB,userNameLB,emailLB,UserEmailLB);
VBAcCnt.setAlignment(Pos.CENTER);
HBTopLBgAc.setTranslateY(-150);

StackPane extraStack=new StackPane();
extraStack.getChildren().addAll(pinkI,purpleI,VBAcCnt,HBTopLBgAc);


StackPane AllAcontStack= new StackPane();
AllAcontStack.getChildren().addAll(extraStack,acSAO);

AcBP.setTop(stackAcTop);
AcBP.setCenter(AllAcontStack);

 

//---------------BOTTOM------------------//
HBox HBAcBot=new HBox(20);


//----Home Page----
//Home page Image
ImageView homePageAcIc=new ImageView("https://mrkzgulfup.com/do.php?img=73585");
homePageAcIc.setFitHeight(85); 
homePageAcIc.setFitWidth(85);


//Home Page Button
Button hAcPBt=new Button(); 
hAcPBt.setGraphic(homePageAcIc);
hAcPBt.setStyle("-fx-background-color: transparent");

hAcPBt.setOnAction(e->{
stage.setScene(HPScene);

});



//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryAcIc= new ImageView("https://mrkzgulfup.com/do.php?img=73589");
categoryAcIc.setFitHeight(85); 
categoryAcIc.setFitWidth(85);

//Catetoreies Button

Button catoAcBt=new Button(); 
catoAcBt.setGraphic(categoryAcIc );
catoAcBt.setStyle( "-fx-background-color: transparent");

//----Cart Page----

ImageView cartAcIc= new ImageView("https://mrkzgulfup.com/do.php?img=73587");
cartAcIc.setFitHeight(85); 
cartAcIc.setFitWidth(85);
//Cart Button

Button cartAcBt=new Button(); 
cartAcBt.setGraphic(cartAcIc );
cartAcBt.setStyle( "-fx-background-color: transparent");


//----Brand Page----
//Brand Page Image

ImageView brandAcIc= new ImageView("https://mrkzgulfup.com/do.php?img=73588");
brandAcIc.setFitHeight(85); 
brandAcIc.setFitWidth(85);

//Brand Button

Button brandAcBt=new Button(); 
brandAcBt.setGraphic(brandAcIc);
brandAcBt.setStyle( "-fx-background-color: transparent");

//----Account Page----
//Account Page Image

ImageView acontAcIc= new ImageView("https://mrkzgulfup.com/do.php?img=73586");
acontAcIc.setFitHeight(85); 
acontAcIc.setFitWidth(85);


//Account Button

Button acontAcBt=new Button(); 
acontAcBt.setGraphic(acontAcIc);
acontAcBt.setStyle( "-fx-background-color: transparent");


//-------Buttons Background-------
ImageView icnAcBG= new ImageView("https://mrkzgulfup.com/do.php?img=73593");
icnAcBG.setFitHeight(120); 
icnAcBG.setFitWidth(600);

HBAcBot.getChildren().addAll(hAcPBt ,catoAcBt,cartAcBt,brandAcBt,acontAcBt);
HBAcBot.setAlignment(Pos.BOTTOM_CENTER);
HBAcBot.setTranslateY(-6);

StackPane AcStack= new StackPane(icnAcBG,HBAcBot);
AcStack.setTranslateY(-1);
//-----set Buttons in the Bottom-----
AcBP.setBottom(AcStack);
//----------------------------------------
 

    
 ////______________________________________________
 ////______________________________________________
 ////-------------END ACCOUNT PAGE-------------
 ////______________________________________________
 ////______________________________________________
  






    
 // ------------------------------------------------ 
    
 ////______________________________________________
 ////______________________________________________
 ////-------------ACCOUNT SETTING PAGE-------------
 ////______________________________________________
 ////______________________________________________
  
 BorderPane AcSBP=new BorderPane();
 AcSBP.setStyle("-fx-background-color: #FDF8F8;");


//---------------TOP-----------------//
HBox HBTopAcS=new HBox(50);
//Logo
ImageView logoImageAcS=new ImageView("https://mrkzgulfup.com/do.php?img=73590");
logoImageAcS.setFitHeight(150); 
logoImageAcS.setFitWidth(150); 
logoImageAcS.setTranslateY(10);

//logo Background
ImageView logoBGImageAcS=new ImageView("https://mrkzgulfup.com/do.php?img=73584");
logoBGImageAcS.setFitWidth(600); 

HBTopAcS.getChildren().add(logoImageAcS);
HBTopAcS.setAlignment(Pos.CENTER);

HBox HBTopLBgAcS=new HBox();
HBTopLBgAcS.getChildren().add(logoBGImageAcS);
HBTopLBgAcS.setAlignment(Pos.TOP_CENTER);


 Scene AcontSScene=new Scene(AcSBP,600,750);
 
acSettingBt.setOnAction(e->{
stage.setScene(AcontSScene);

});

 
//--------------Left-------------------//
// REVERS icon

ImageView acRevrs= new ImageView("https://mrkzgulfup.com/do.php?img=73591");
acRevrs.setFitHeight(65); 
acRevrs.setFitWidth(65);
Button acRevrsBt=new Button();
acRevrsBt.setGraphic(acRevrs);
acRevrsBt.setStyle("-fx-background-color: transparent");

acRevrsBt.setTranslateX(-250);
acRevrsBt.setTranslateY(-275);


acRevrsBt.setOnAction(e->{
    stage.setScene(AcontScene);
        });

 //---------------CENTER------------------//
 VBox VBAcSCnt=new VBox(6);
//Ivtar
ToggleGroup AvtarGroup = new ToggleGroup();

ImageView AvtarSIm=new ImageView("https://mrkzgulfup.com/do.php?img=73668");
AvtarSIm.setFitHeight(200); 
AvtarSIm.setFitWidth(200);

///////////////// AVTARS iMAGES/////////////////
HBox avtarHB=new HBox();
avtarHB.setAlignment(Pos.TOP_CENTER);
//---------------first Avtar----------------
ImageView Avtar1=new ImageView("https://mrkzgulfup.com/do.php?img=74023");
Avtar1.setFitHeight(50); 
Avtar1.setFitWidth(50);

//---------------SECOND Avtar----------------

ImageView Avtar2=new ImageView("https://mrkzgulfup.com/do.php?img=74024");
Avtar2.setFitHeight(50); 
Avtar2.setFitWidth(50);

//---------------THIRD Avtar----------------

ImageView Avtar3=new ImageView("https://mrkzgulfup.com/do.php?img=74025");
Avtar3.setFitHeight(50); 
Avtar3.setFitWidth(50);


//---------------FORTH Avtar----------------

ImageView Avtar4=new ImageView("https://mrkzgulfup.com/do.php?img=74026");
Avtar4.setFitHeight(50); 
Avtar4.setFitWidth(50);

/////////////////////////////////////////////////
//---------------------SET AVTAR 1---------------------

RadioButton Avtar1RB=new RadioButton();
Avtar1RB.setGraphic(Avtar1);
Avtar1RB.setToggleGroup(AvtarGroup);
Avtar1RB.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

Avtar1RB.setOnAction(e->{
if(Avtar1RB.isSelected())   
AvtarSIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73990"));
});
//---------------------SET AVTAR 2---------------------

RadioButton Avtar2RB=new RadioButton();
Avtar2RB.setGraphic(Avtar2);
Avtar2RB.setToggleGroup(AvtarGroup);
Avtar2RB.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
Avtar2RB.setOnAction(e->{
if(Avtar2RB.isSelected())   
AvtarSIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73991"));
});
     

//---------------------SET AVTAR 3---------------------

RadioButton Avtar3RB=new RadioButton();
Avtar3RB.setGraphic(Avtar3);
Avtar3RB.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
Avtar3RB.setToggleGroup(AvtarGroup);

Avtar3RB.setOnAction(e->{
if(Avtar3RB.isSelected())   
AvtarSIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73992"));
});

//---------------------SET AVTAR 4---------------------

RadioButton Avtar4RB=new RadioButton();
Avtar4RB.setGraphic(Avtar4);
Avtar4RB.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
Avtar4RB.setToggleGroup(AvtarGroup);

Avtar4RB.setOnAction(e->{
if(Avtar4RB.isSelected())   
AvtarSIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73993"));
});

////////////////////////////////////////////////////////////////////////////////////

avtarHB.getChildren().addAll(Avtar1RB,Avtar2RB,Avtar3RB,Avtar4RB);
//------------------------------SAVE AVTAR-------------------------
Button saveAvtar=new Button("Save");
saveAvtar.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");
saveAvtar.setOnAction(e->{
if(Avtar1RB.isSelected()){
    AvtarIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73990"));  
}
else if(Avtar2RB.isSelected()){
    AvtarIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73991"));  
}
else if(Avtar3RB.isSelected()){
    AvtarIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73992"));  
}
else if(Avtar4RB.isSelected()){
    AvtarIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73993"));  
}
else{
    AvtarIm.setImage(new Image("https://mrkzgulfup.com/do.php?img=73668"));  
}
});
//-----------------------------------------------------------------
//name Labele
Label nameSLB=new Label("New Name:");
nameSLB.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 25));


TextField newNameTF=new TextField();

Button saveName=new Button("Save");
saveName.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");

saveName.setOnAction(e->{
 if(!newNameTF.getText().isEmpty()&&!newNameTF.getText().isBlank())
userNameLB.textProperty().bind(newNameTF.textProperty());

 else
     newNameTF.clear();
    
});



HBox HBCN=new HBox();
HBCN.setAlignment(Pos.CENTER);
HBCN.getChildren().addAll(newNameTF,saveName);

   
     Sing_InB.setOnAction(e->{

             if(!NametextTFS.getText().isEmpty()
             &&!EmailtextTFS.getText().isEmpty()
             &&!Phone_Notext.getText().isEmpty()  
             &&!PassWordtext.getText().isEmpty() 
             &&!confirmPassWordtext.getText().isEmpty()
             && confirmPassWordtext.getText().equals((PassWordtext).getText()) 
             &&EmailtextTFS.getText().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")){
             stage.setScene(HPScene);

             Session sessionus = HibernateUtil.getSessionFactory().openSession();
             Transaction txop = sessionus.beginTransaction();
                 sessionus = HibernateUtil.getSessionFactory().openSession();
       
                 userinfo userinf=new userinfo();
        userinf.setEmail(userEm);       
        userinf.setUserID(NametextTFTS);
        userinf.setName(newNameTF.getText().toString());

        userinf.setPhone(phToS);  
        userinf.setPass(PassWordtextTS);
                txop = sessionus.beginTransaction();
                sessionus.save(userinf);
                txop.commit();
                sessionus.close();

     }
             else if(!EmailtextTFS.getText().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")){
                 EmailtextTFS.clear();
                 EmailtextTFS.setPromptText(" Enter Correct Email");

             }
             else{
     if(NametextTFS.getText().isEmpty()){
         NametextTFS.setPromptText("This Field is Required");
     }
     if(EmailtextTFS.getText().isEmpty()){
         EmailtextTFS.setPromptText("This Field is Required");
     }
     if(Phone_Notext.getText().isEmpty()){
         Phone_Notext.setPromptText("This Field is Required");
     }
     if(PassWordtext.getText().isEmpty()){
        PassWordtext.setPromptText("This Field is Required");
     }
     if(confirmPassWordtext.getText().isEmpty()||!confirmPassWordtext.getText().equals(PassWordtext)){
        if(!confirmPassWordtext.getText().equals(PassWordtext)){
      
            confirmPassWordtext.clear();
            confirmPassWordtext.setPromptText("Not Matched");  
      }
        else{
         
         confirmPassWordtext.setPromptText("This Field is Required");
     }
     }
   }
       });
          
          bt1LI.setOnAction(e->{
            if(!EmailOP.getText().isEmpty()
             &&!Pass.getText().isEmpty()) {
            
             stage.setScene(HPScene);

            }
            else{
            
            if(EmailOP.getText().isEmpty()){
         EmailOP.setPromptText("This Field is Required");
     }
           if(Pass.getText().isEmpty()){
         Pass.setPromptText("This Field is Required");
     }
            }
        });
 
 

///////////////////////////////////////////////////////////////////
//Email Labele
Label emailSLB=new Label("New Email:");
emailSLB.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 25));

TextField newEmailTF=new TextField();

Button saveEmail=new Button("Save");
saveEmail.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");




saveEmail.setOnAction(e->{
if(!newEmailTF.getText().isEmpty()&&!newEmailTF.getText().isBlank()&& newEmailTF.getText().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"))
UserEmailLB.textProperty().bind(newEmailTF.textProperty());
else{
    newEmailTF.clear();
    newEmailTF.setPromptText(" Enter Correct Email");
}
});




HBox HBCE=new HBox();
HBCE.setAlignment(Pos.CENTER);
HBCE.getChildren().addAll(newEmailTF,saveEmail);

//Password Labele
Label passwordLb=new Label("New Password:");
passwordLb.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 25));

PasswordField newPassTF=new PasswordField();

Button savePass=new Button("Save");
savePass.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");

HBox HBCP=new HBox();
HBCP.setAlignment(Pos.CENTER);
HBCP.getChildren().addAll(newPassTF,savePass);
////////////////////////////////////////////////////////////////////
//Extra
VBox pinkSI=new VBox();
ImageView PinkSBG= new ImageView("https://mrkzgulfup.com/do.php?img=73669");
PinkSBG.setFitHeight(500); 
PinkSBG.setFitWidth(400);
PinkSBG.setTranslateX(160);
PinkSBG.setTranslateY(-180);

pinkSI.getChildren().addAll(PinkSBG);
pinkSI.setAlignment(Pos.TOP_RIGHT);

VBox purpleSI=new VBox();
ImageView purpleSBG= new ImageView("https://mrkzgulfup.com/do.php?img=73670");
purpleSBG.setFitHeight(500); 
purpleSBG.setFitWidth(400);
purpleSBG.setTranslateX(-180);
purpleSBG.setTranslateY(250);
purpleSI.getChildren().addAll(purpleSBG);
purpleSI.setAlignment(Pos.BOTTOM_LEFT);
///

VBAcSCnt.getChildren().setAll(AvtarSIm,avtarHB,saveAvtar,nameSLB,HBCN,emailSLB,HBCE,passwordLb,HBCP);
VBAcSCnt.setAlignment(Pos.CENTER);

StackPane extraSStack=new StackPane();

HBTopLBgAcS.setTranslateY(-150);
extraSStack.getChildren().addAll(pinkSI,purpleSI,HBTopLBgAcS,VBAcSCnt);


StackPane stackAcSTop= new StackPane();
stackAcSTop.getChildren().addAll(HBTopAcS);

StackPane AllAcontSStack= new StackPane();
AllAcontSStack.getChildren().addAll(extraSStack,acRevrsBt);
AcSBP.setTop(stackAcSTop);
AcSBP.setCenter(AllAcontSStack);

 

//---------------BOTTOM------------------//
HBox HBAcSBot=new HBox(20);


//----Home Page----
//Home page Image
ImageView homePageAcSIc=new ImageView("https://mrkzgulfup.com/do.php?img=73585");
homePageAcSIc.setFitHeight(85); 
homePageAcSIc.setFitWidth(85);


//Home Page Button
Button hAcSPBt=new Button(); 
hAcSPBt.setGraphic(homePageAcSIc);
hAcSPBt.setStyle("-fx-background-color: transparent");

hAcSPBt.setOnAction(e->{
stage.setScene(HPScene);

});



//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryAcSIc= new ImageView("https://mrkzgulfup.com/do.php?img=73589");
categoryAcSIc.setFitHeight(85); 
categoryAcSIc.setFitWidth(85);

//Catetoreies Button

Button catoAcSBt=new Button(); 
catoAcSBt.setGraphic(categoryAcSIc );
catoAcSBt.setStyle( "-fx-background-color: transparent");
      
//----Cart Page----

ImageView cartAcSIc= new ImageView("https://mrkzgulfup.com/do.php?img=73587");
cartAcSIc.setFitHeight(85); 
cartAcSIc.setFitWidth(85);
//Cart Button

Button cartAcSBt=new Button(); 
cartAcSBt.setGraphic(cartAcSIc );
cartAcSBt.setStyle( "-fx-background-color: transparent");


//----Brand Page----
//Brand Page Image

ImageView brandAcSIc= new ImageView("https://mrkzgulfup.com/do.php?img=73588");
brandAcSIc.setFitHeight(85); 
brandAcSIc.setFitWidth(85);

//Brand Button

Button brandAcSBt=new Button(); 
brandAcSBt.setGraphic(brandAcSIc);
brandAcSBt.setStyle( "-fx-background-color: transparent");

//----Account Page----
//Account Page Image

ImageView acontAcSIc= new ImageView("https://mrkzgulfup.com/do.php?img=73586");
acontAcSIc.setFitHeight(85); 
acontAcSIc.setFitWidth(85);


//Account Button

Button acontAcSBt=new Button(); 
acontAcSBt.setGraphic(acontAcSIc);
acontAcSBt.setStyle( "-fx-background-color: transparent");

acontAcSBt.setOnAction(e->{
stage.setScene(AcontScene);

});

//-------Buttons Background-------
ImageView icnAcSBG= new ImageView("https://mrkzgulfup.com/do.php?img=73593");
icnAcSBG.setFitHeight(120); 
icnAcSBG.setFitWidth(600);

HBAcSBot.getChildren().addAll(hAcSPBt ,catoAcSBt,cartAcSBt,brandAcSBt,acontAcSBt);
HBAcSBot.setAlignment(Pos.BOTTOM_CENTER);
HBAcSBot.setTranslateY(-6);

StackPane AcSStack= new StackPane(icnAcSBG,HBAcSBot);
AcSStack.setTranslateY(-1);
//-----set Buttons in the Bottom-----
AcSBP.setBottom(AcSStack);
//----------------------------------------
 
    
 ////______________________________________________
 ////______________________________________________
 ////----------------ACCOUNT ORDER PAGE------------
 ////______________________________________________
 ////______________________________________________
  
 BorderPane AcOBP=new BorderPane();
 AcOBP.setStyle("-fx-background-color: #FDF8F8;");

//---------------TOP-----------------//
HBox HBTopAcO=new HBox(50);
//Logo
ImageView logoImageAcO=new ImageView("https://mrkzgulfup.com/do.php?img=73590");
logoImageAcO.setFitHeight(150); 
logoImageAcO.setFitWidth(150); 
logoImageAcO.setTranslateY(10);
//logo Background
ImageView logoBGImageAcO=new ImageView("https://mrkzgulfup.com/do.php?img=73584");
logoBGImageAcO.setFitWidth(600); 

HBTopAcO.getChildren().add(logoImageAcO);
HBTopAcO.setAlignment(Pos.CENTER);

HBox HBTopLBgAcO=new HBox();
HBTopLBgAcO.getChildren().add(logoBGImageAcO);
HBTopLBgAcO.setAlignment(Pos.TOP_CENTER);
HBTopLBgAcO.setTranslateY(-150);

StackPane stackAcOTop= new StackPane();
stackAcOTop.getChildren().addAll(HBTopAcO);


 
    Scene AcontOScene=new Scene(AcOBP,600,750);
    acOrderBt.setOnAction(e->{
   stage.setScene(AcontOScene); 

});
//--------------Left-------------------//
ImageView acORevrs= new ImageView("https://mrkzgulfup.com/do.php?img=73591");
acORevrs.setFitHeight(65); 
acORevrs.setFitWidth(65);
Button acORevrsBt=new Button();
acORevrsBt.setGraphic(acORevrs);
acORevrsBt.setStyle("-fx-background-color: transparent");

acORevrsBt.setTranslateX(-250);
acORevrsBt.setTranslateY(-275);


acORevrsBt.setOnAction(e->{
    stage.setScene(AcontScene);
        });


 //---------------CENTER------------------//
Rectangle listHead=new Rectangle(0,1,500,40);
listHead.setFill(headersCB);
listHead.setTranslateY(-200);

VBox orderNum=new VBox(40);
orderNum.getChildren().addAll(new Label("Order Number"));
orderNum.setAlignment(Pos.TOP_LEFT);
orderNum.setTranslateX(110);
orderNum.setTranslateY(30);
orderNum.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill:#393646;");
        
VBox orderPrice=new VBox(40);
orderPrice.getChildren().add(new Label("Total price"));
orderPrice.setAlignment(Pos.TOP_RIGHT);
orderPrice.setTranslateY(30);
orderPrice.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill:#393646;");
orderPrice.setTranslateX(-110);


StackPane extraOStack=new StackPane();
extraOStack.getChildren().addAll(HBTopLBgAcO,listHead,orderNum,orderPrice,acORevrsBt);


AcOBP.setTop(stackAcOTop);
AcOBP.setCenter(extraOStack);


//---------------BOTTOM------------------//
HBox HBAcOBot=new HBox(20);


//----Home Page----
//Home page Image
ImageView homePageAcOIc=new ImageView("https://mrkzgulfup.com/do.php?img=73585");
homePageAcOIc.setFitHeight(85); 
homePageAcOIc.setFitWidth(85);


//Home Page Button
Button hAcOPBt=new Button(); 
hAcOPBt.setGraphic(homePageAcOIc);
hAcOPBt.setStyle("-fx-background-color: transparent");

hAcOPBt.setOnAction(e->{
stage.setScene(HPScene);

});



//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryAcOIc= new ImageView("https://mrkzgulfup.com/do.php?img=73589");
categoryAcOIc.setFitHeight(85); 
categoryAcOIc.setFitWidth(85);

//Catetoreies Button

Button catoAcOBt=new Button(); 
catoAcOBt.setGraphic(categoryAcOIc );
catoAcOBt.setStyle( "-fx-background-color: transparent");

//----Cart Page----

ImageView cartAcOIc= new ImageView("https://mrkzgulfup.com/do.php?img=73587");
cartAcOIc.setFitHeight(85); 
cartAcOIc.setFitWidth(85);
//Cart Button

Button cartAcOBt=new Button(); 
cartAcOBt.setGraphic(cartAcOIc );
cartAcOBt.setStyle( "-fx-background-color: transparent");


//----Brand Page----
//Brand Page Image

ImageView brandAcOIc= new ImageView("https://mrkzgulfup.com/do.php?img=73588");
brandAcOIc.setFitHeight(85); 
brandAcOIc.setFitWidth(85);

//Brand Button

Button brandAcOBt=new Button(); 
brandAcOBt.setGraphic(brandAcOIc);
brandAcOBt.setStyle( "-fx-background-color: transparent");

//----Account Page----
//Account Page Image

ImageView acontAcOIc= new ImageView("https://mrkzgulfup.com/do.php?img=73586");
acontAcOIc.setFitHeight(85); 
acontAcOIc.setFitWidth(85);


//Account Button

Button acontAcOBt=new Button(); 
acontAcOBt.setGraphic(acontAcOIc);
acontAcOBt.setStyle( "-fx-background-color: transparent");


acontAcOBt.setOnAction(e->{
stage.setScene(AcontScene);

});


//-------Buttons Background-------
ImageView icnAcOBG= new ImageView("https://mrkzgulfup.com/do.php?img=73593");
icnAcOBG.setFitHeight(120); 
icnAcOBG.setFitWidth(600);

HBAcOBot.getChildren().addAll(hAcOPBt ,catoAcOBt,cartAcOBt,brandAcOBt,acontAcOBt);
HBAcOBot.setAlignment(Pos.BOTTOM_CENTER);
HBAcOBot.setTranslateY(-6);

StackPane AcOStack= new StackPane(icnAcOBG,HBAcOBot);
AcOStack.setTranslateY(20);
//-----set Buttons in the Bottom-----
AcOBP.setBottom(AcOStack);
//----------------------------------------
 

    
 ////______________________________________________
 ////______________________________________________
 ////-------------END ORDER PAGE-------------
 ////______________________________________________
 ////______________________________________________
  
 
 
 
 
 
 ////______________________________________________
 ////______________________________________________
 ////-----------------Brand PAGE-------------------
 ////______________________________________________
 ////______________________________________________
  BorderPane BrBP=new BorderPane();
   Scene sceneBr=new Scene(BrBP,600,750);
       
brandBt.setOnAction(e->{
          stage.setScene(sceneBr);

   });
   
brandAcOBt.setOnAction(e->{
          stage.setScene(sceneBr);

   });
brandAcSBt.setOnAction(e->{
          stage.setScene(sceneBr);

   });
brandAcBt.setOnAction(e->{
          stage.setScene(sceneBr);

   });
    sceneBr.setFill(Background);
//---------------TOP-----------------//
HBox HBBrTopL=new HBox();
//Logo
ImageView logoBrImage=new ImageView("https://mrkzgulfup.com/do.php?img=74167");
logoBrImage.setFitHeight(150); 
logoBrImage.setFitWidth(150);
//logo Background
ImageView logoBBrGImage=new ImageView("https://mrkzgulfup.com/do.php?img=74168");
logoBBrGImage.setFitHeight(100); 
logoBBrGImage.setFitWidth(600); 

HBBrTopL.getChildren().add(logoBrImage);
HBBrTopL.setAlignment(Pos.CENTER);

HBox HBBrTopLBg=new HBox();
HBBrTopLBg.getChildren().add(logoBBrGImage);
HBBrTopLBg.setAlignment(Pos.TOP_CENTER);

Text textBr = new Text();
textBr.setText("ABOUT US"); 
textBr.setFont(Font.font("Georgia",FontWeight.BOLD ,30)); 
textBr.setFill(Color.BLACK);
textBr.setStrokeWidth(2);
textBr.setTranslateX(5); 
textBr.setTranslateY(30);  

StackPane stackBrTop= new StackPane();
stackBrTop.getChildren().addAll(HBBrTopLBg,textBr);

BrBP.setTop(stackBrTop);

//--------------Center-------------------//





StackPane stackBrcenter= new StackPane();



Image image6Br = new Image("https://mrkzgulfup.com/do.php?img=74226");
ImageView imageView6Br = new ImageView(image6Br);
imageView6Br.setPreserveRatio(true); 
imageView6Br.setFitHeight(570); 
imageView6Br.setFitWidth(1200); 
imageView6Br.setTranslateX(5); 
stackBrcenter.getChildren().add(imageView6Br);
HBox center2Br=new HBox(50);
center2Br.setPadding(new Insets(0,20, 0, 40));




Button gameBtBr=new Button();
gameBtBr.setStyle("-fx-background-color: transparent");
gameBtBr.setTranslateY(-30);

center2.getChildren().addAll(gameBtBr);

//choose your color
StackPane clrStackBr=new StackPane();

Button colorBtBr=new Button();

colorBtBr.setStyle("-fx-background-color: transparent");
colorBtBr.setTranslateY(80);
colorBtBr.setTranslateX(180);

//------

HBox center3Br=new HBox(50);
center3Br.setPadding(new Insets(0,20, 0, 40));

//--------Chat--------
//chat Image

//chat button 
Button chMABtBr=new Button();
chMABtBr.setStyle("-fx-background-color: transparent");
chMABtBr.setTranslateY(-60);
chMABtBr.setTranslateX(-8);


center3Br.getChildren().addAll(chMABtBr);

//--------------------------------------
VBox centerVBBr=new VBox();
centerVBBr.getChildren().addAll(stackBrcenter,center2Br,center3Br);
clrStackBr.getChildren().addAll(colorBtBr,centerVBBr);

BrBP.setCenter(clrStackBr);

//---------------BOTTOM------------------//
HBox HBBrBot=new HBox(20);

//----Home page----
//Home page Image
ImageView homePageIcBr=new ImageView("https://mrkzgulfup.com/do.php?img=74173");
homePageIcBr.setFitHeight(85); 
homePageIcBr.setFitWidth(85);

//Home Page Button
Button hPBrBt=new Button(); 
hPBrBt.setGraphic(homePageIcBr);
hPBrBt.setStyle("-fx-background-color: transparent");
hPBrBt.setOnAction(e->{
stage.setScene(HPScene);

});
//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryIcBr= new ImageView("https://mrkzgulfup.com/do.php?img=74172");
categoryIcBr.setFitHeight(85); 
categoryIcBr.setFitWidth(85);

//Catetoreies Button

Button catoBrBt=new Button(); 
catoBrBt.setGraphic(categoryIcBr );
catoBrBt.setStyle( "-fx-background-color: transparent");

//----Cart Page----
//Cart Page Image

ImageView cartIcBr= new ImageView("https://mrkzgulfup.com/do.php?img=74171");
cartIcBr.setFitHeight(85); 
cartIcBr.setFitWidth(85);

//Cart Button

Button cartBrBt=new Button(); 
cartBrBt.setGraphic(cartIcBr );
cartBrBt.setStyle( "-fx-background-color: transparent");



//----Brand Page----
//Brand Page Image

ImageView brandIcBr= new ImageView("https://mrkzgulfup.com/do.php?img=74170");
brandIcBr.setFitHeight(85); 
brandIcBr.setFitWidth(85);

//Brand Button

Button brandBrBt=new Button(); 
brandBrBt.setGraphic(brandIcBr);
brandBrBt.setStyle( "-fx-background-color: transparent");

//----Account Page----
//Account Page Image

ImageView acontIcBr= new ImageView("https://mrkzgulfup.com/do.php?img=74169");
acontIcBr.setFitHeight(85); 
acontIcBr.setFitWidth(85);

//Account Button

Button acontBrBt=new Button(); 
acontBrBt.setGraphic(acontIcBr);
acontBrBt.setStyle( "-fx-background-color: transparent");

acontBrBt.setOnAction(e->{
stage.setScene(AcontScene);

});

//-------Buttons Background-------
ImageView icnBGBr= new ImageView("https://mrkzgulfup.com/do.php?img=74174");
icnBGBr.setFitHeight(120); 
icnBGBr.setFitWidth(600);

HBBrBot.getChildren().addAll(hPBrBt ,catoBrBt,cartBrBt,brandBrBt,acontBrBt);
HBBrBot.setAlignment(Pos.BOTTOM_CENTER);

StackPane stackBr= new StackPane(icnBGBr,HBBrBot);
stackBr.setTranslateY(-55);
//-----set Buttons in the Bottom-----
BrBP.setBottom(stackBr);
BrBP.setStyle("-fx-background-color: #FDF8F8;");

   
 
 ////______________________________________________
 ////______________________________________________
 ////----------------END Brand PAGE----------------
 ////______________________________________________
 ////______________________________________________
                
   
        //cart
        //ob for  itema
        ObservableList<StackPane> ProductToCart = FXCollections.observableArrayList();
        //list view show the  ob
        ListView<StackPane> Orders =new ListView<>(ProductToCart);
        
       //---------------------------------------------
        //---------------------------------------------
        
        //    **********  FACE SCENE  **********
        
        //---------------------------------------------
        //---------------------------------------------
        BorderPane border4 = new BorderPane();

        //Images display
        GridPane grid4 = new GridPane();
        grid4.setHgap(20);
        grid4.setVgap(15);

        // adding the price and add to cart
        HBox priceprim = new HBox(10);
        HBox priceconc = new HBox(15);
        HBox pricefond = new HBox(15);
        HBox priceplush = new HBox(15);
        HBox pricehighliter = new HBox(15);
        HBox pricespary = new HBox(15);

        //add children
        VBox prime = new VBox(10);
        VBox concealer = new VBox(10);
        VBox fondation = new VBox(10);
        VBox plush = new VBox(10);
        VBox highliter = new VBox(10);
        VBox spray = new VBox(10);

        //Logo
        HBox HBTopL03 = new HBox(50);
        ImageView logoImage03 = new ImageView("https://mrkzgulfup.com/do.php?img=73590");
        logoImage03.setFitHeight(150);
        logoImage03.setFitWidth(150);
        logoImage03.setTranslateY(5);

        //logo Background
        ImageView logoBGImage03 = new ImageView("https://mrkzgulfup.com/do.php?img=73584");
        logoBGImage03.setFitWidth(600);

        HBTopL03.getChildren().add(logoImage03);
        HBTopL03.setAlignment(Pos.CENTER);

        HBox HBTopLBg03 = new HBox();
        HBTopLBg03.getChildren().add(logoBGImage03);
        HBTopLBg03.setAlignment(Pos.TOP_CENTER);

        HBox HBBack03 = new HBox();
        ImageView back03 = new ImageView("https://mrkzgulfup.com/do.php?img=73591");
        back03.setFitHeight(65);
        back03.setFitWidth(65);
        Button back003=new Button();
        back003.setGraphic(back03);
        back003.setBackground(null);
        HBBack03.getChildren().add(back003);
        HBBack03.setAlignment(Pos.CENTER_LEFT);

        StackPane stackTop03 = new StackPane();
        stackTop03.getChildren().addAll(HBTopLBg03, HBTopL03,HBBack03);

        //face PRODUCTS
        Image primerIMG=new Image("https://mrkzgulfup.com/do.php?img=72881");
        ImageView viewpprimer = new ImageView(primerIMG);
        viewpprimer.setFitHeight(200);
        viewpprimer.setFitWidth(200);

        Image conselIMG=new Image("https://mrkzgulfup.com/do.php?img=72875");
        ImageView viewpconcealer = new ImageView(conselIMG);
        viewpconcealer.setFitHeight(200);
        viewpconcealer.setFitWidth(200);

        Image fondIMG=new Image("https://mrkzgulfup.com/do.php?img=72877");
        ImageView viewpfondation = new ImageView(fondIMG);
        viewpfondation.setFitHeight(200);
        viewpfondation.setFitWidth(200);

        Image plushIMG=new Image("https://mrkzgulfup.com/do.php?img=72876");
        ImageView viewplush = new ImageView(plushIMG);
        viewplush.setFitHeight(200);
        viewplush.setFitWidth(200);

        Image highlhIMG=new Image("https://mrkzgulfup.com/do.php?img=72878");
        ImageView viewphighliter = new ImageView(highlhIMG);
        viewphighliter.setFitHeight(200);
        viewphighliter.setFitWidth(200);

        Image sparyhIMG=new Image("https://mrkzgulfup.com/do.php?img=72879");
        ImageView viewpspary = new ImageView(sparyhIMG);
        viewpspary.setFitHeight(200);
        viewpspary.setFitWidth(200);

        //FACE PRODUCTS COLORS
        //color prime
        ComboBox<String> cboprime = new ComboBox<>();
        cboprime.getItems().addAll("DULLNESS ERASER", "SHINE CONTROL", "REDNESS CORRECTER"); //primer colors 3
        cboprime.setEditable(false);
        cboprime.setPrefWidth(120);
        cboprime.setVisibleRowCount(2);

        Label primercolor = new Label("no color Selected ");
        primercolor.setStyle("-fx-font-size: 10px;");
        cboprime.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "DULLNESS ERASER":
                        cboprime.setStyle("-fx-background-color:rgb(255,218,190)");
                        primercolor.setText("DULLNESS ERASER");
                        break;
                    case "SHINE CONTROL":
                        cboprime.setStyle("-fx-background-color:rgb(255,229,200)");
                        primercolor.setText("SHINE CONTROL");
                        break;
                    case "REDNESS CORRECTER":
                        cboprime.setStyle("-fx-background-color:rgb(192, 64, 0)");
                        primercolor.setText("REDNESS CORRECTER");
                        break;
                    default:
                        cboprime.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootprime = new StackPane();
        rootprime.getChildren().add(cboprime);

        Label concealrcolor = new Label("no color Selected ");
        concealrcolor.setStyle("-fx-font-size: 10px;");
        //color concelear
        ComboBox<String> cboconc = new ComboBox<>();
        cboconc.getItems().addAll("HIGH COVERAGE CONCEALER1", "MEDIUM COVERAGE CONCEALER1", "LIGHT COVERAGE CONCEALER1", "HIGH COVERAGE CONCEALER2", "MEDIUM COVERAGE CONCEALER2", "LIGHT COVERAGE CONCEALER2", "HIGH COVERAGE CONCEALER3", "MEDIUM COVERAGE CONCEALER3", "LIGHT COVERAGE CONCEALER3"); //concelear colors 4
        cboconc.setEditable(false);
        cboconc.setPrefWidth(120);
        cboconc.setVisibleRowCount(2);


        cboconc.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "HIGH COVERAGE CONCEALER1":
                        cboconc.setStyle("-fx-background-color:rgb(255,219,172)");//done light color
                        concealrcolor.setText("HIGH COVERAGE CONCEALER1");
                        break;
                    case "MEDIUM COVERAGE CONCEALER1":
                        cboconc.setStyle("-fx-background-color:rgb(255,219,172)");// done light ppl
                        concealrcolor.setText("MEDIUM COVERAGE CONCEALER1");
                        break;
                    case "LIGHT COVERAGE CONCEALER1":
                        cboconc.setStyle("-fx-background-color:rgb(255,219,172)");//done light color
                        concealrcolor.setText("LIGHT COVERAGE CONCEALER1");
                        break;
                    case "HIGH COVERAGE CONCEALER2":
                        cboconc.setStyle("-fx-background-color:rgb(224,172,105)");//done natural color
                        concealrcolor.setText("HIGH COVERAGE CONCEALER2");
                        break;
                    case "MEDIUM COVERAGE CONCEALER2":
                        cboconc.setStyle("-fx-background-color:rgb(224,172,105)");// done natural ppl
                        concealrcolor.setText("MEDIUM COVERAGE CONCEALER2");
                        break;
                    case "LIGHT COVERAGE CONCEALER2":
                        cboconc.setStyle("-fx-background-color:rgb(224,172,105)");//done natural color
                        concealrcolor.setText("LIGHT COVERAGE CONCEALER2");
                        break;
                    case "HIGH COVERAGE CONCEALER3":
                        cboconc.setStyle("-fx-background-color:rgb(141,85,36)");//done dark color
                        concealrcolor.setText("HIGH COVERAGE CONCEALER3");
                        break;
                    case "MEDIUM COVERAGE CONCEALER3":
                        cboconc.setStyle("-fx-background-color:rgb(141,85,36)");// done dark ppl
                        concealrcolor.setText("MEDIUM COVERAGE CONCEALER3");
                        break;
                    case "LIGHT COVERAGE CONCEALER3":
                        cboconc.setStyle("-fx-background-color:rgb(141,85,36)");//done dark color
                        concealrcolor.setText("LIGHT COVERAGE CONCEALER3");
                        break;
                    default:
                        cboconc.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootcon = new StackPane();
        rootcon.getChildren().add(cboconc);

        Label fondcolor = new Label("no color Selected ");
        fondcolor.setStyle("-fx-font-size: 10px;");
        //color fondation
        ComboBox<String> cbofon = new ComboBox<>();
        cbofon.getItems().addAll("VERY LIGHT", "LIGHT", "NATURAL", "TAN", "COFFEE"); //fondation colors 5
        cbofon.setEditable(false);
        cbofon.setPrefWidth(120);
        cbofon.setVisibleRowCount(2);

        cbofon.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "VERY LIGHT":
                        cbofon.setStyle("-fx-background-color:rgb(253,231,214)");//done
                        fondcolor.setText("VERY LIGHT");
                        break;
                    case "LIGHT":
                        cbofon.setStyle("-fx-background-color:rgb(255,226,198)");// done
                        fondcolor.setText(" LIGHT");
                        break;
                    case "NATURAL":
                        cbofon.setStyle("-fx-background-color:rgb(255,215,174)");//done
                        fondcolor.setText(" NATURAL");
                        break;
                    case "TAN":
                        cbofon.setStyle("-fx-background-color:rgb(198,134,66)");//done
                        fondcolor.setText(" TAN");
                        break;
                    case "COFFEE":
                        cbofon.setStyle("-fx-background-color:rgb(141,85,36)");// done natural ppl
                        fondcolor.setText(" COFFEE");
                        break;
                    default:
                        cboconc.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootfon = new StackPane();
        rootfon.getChildren().add(cbofon);

        //FACE'S LABELS UNDER IMAGES
        Label prim = new Label("Velvet Primer");
        prim.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label conc = new Label("Velvet Concealer");
        conc.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label fon = new Label("Velvet fondation");
        fon.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label plusher = new Label("Velvet plush");
        plusher.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label high = new Label("Velvet highliter");
        high.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label spr = new Label("Velvet spray");
        spr.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        //PRODUCTS'S PRICE
        Label primprice = new Label("83 SR");

        Label concprice = new Label("249 SR");

        Label fonprice = new Label("119 SR");

        Label plushprice = new Label("165 SR");

        Label highliterprice = new Label("139 SR");

        Label sparyprice = new Label("75 SR");

        Button addprim = new Button("Add to cart");
        Button addcon = new Button("Add to cart");
        Button addfon = new Button("Add to cart");
        Button addplush = new Button("Add to cart");
        Button addhighliter = new Button("Add to cart");
        Button addspray = new Button("Add to cart");


        //GATHER ALL PRICES
        priceprim.getChildren().addAll(primprice, addprim);
        priceconc.getChildren().addAll(concprice, addcon);
        pricefond.getChildren().addAll(fonprice, addfon);
        priceplush.getChildren().addAll(plushprice, addplush);
        pricehighliter.getChildren().addAll(highliterprice, addhighliter);
        pricespary.getChildren().addAll(sparyprice, addspray);

        //GATHER ALL
        prime.getChildren().addAll(viewpprimer, prim, rootprime,  priceprim);
        concealer.getChildren().addAll(viewpconcealer,conc ,rootcon,  priceconc);
        fondation.getChildren().addAll(viewpfondation, fon,rootfon,  pricefond);
        plush.getChildren().addAll(viewplush, plusher,  priceplush);
        highliter.getChildren().addAll(viewphighliter, high,  pricehighliter);
        spray.getChildren().addAll(viewpspary, spr,  pricespary);

        //ORDER OF DISPLAYING IMAGES
        grid4.add(prime, 0, 0);
        grid4.add(concealer, 0, 1);
        grid4.add(fondation, 0, 2);
        grid4.add(plush, 1, 0);
        grid4.add(highliter, 1, 1);
        grid4.add(spray, 1, 2);

        // DISPLAY CONTENT
        grid4.setAlignment(Pos.CENTER);
        ListView<GridPane> listView4 = new ListView<>();
        listView4.getItems().add(grid4);
        listView4.setFocusTraversable(false);

        //---------------BOTTOM------------------//
        HBox HBBot03 = new HBox(20);

        //----Home page----
        //Home page Image
        ImageView homePageIc03 = new ImageView("https://mrkzgulfup.com/do.php?img=73585");
        homePageIc03.setFitHeight(85);
        homePageIc03.setFitWidth(85);

        //Home Page Button
        Button hPBt03 = new Button();
        hPBt03.setGraphic(homePageIc03);
        hPBt03.setStyle("-fx-background-color: transparent");
        hPBt03.setOnAction(e->{stage.setScene(HPScene);  });

        //----Catetoreies Page----
        //Catetoreies Page Image
        ImageView categoryIc03 = new ImageView("https://mrkzgulfup.com/do.php?img=73589");
        categoryIc03.setFitHeight(85);
        categoryIc03.setFitWidth(85);

        //Catetoreies Button
        Button catoBt03 = new Button();
        catoBt03.setGraphic(categoryIc03);
        catoBt03.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CATEGORIES
        catoBt03.setOnAction(e->{stage.setScene(scene1);});

        //----Cart Page----
        //Cart Page Image
        ImageView cartIc03 = new ImageView("https://mrkzgulfup.com/do.php?img=73587");
        cartIc03.setFitHeight(85);
        cartIc03.setFitWidth(85);

        //Cart Button
        Button cartBt03 = new Button();
        cartBt03.setGraphic(cartIc03);
        cartBt03.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CART
        cartBt03.setOnAction(e->{stage.setScene(scene9);});

        //----Brand Page----
        //Brand Page Image
        ImageView brandIc03 = new ImageView("https://mrkzgulfup.com/do.php?img=73588");
        brandIc03.setFitHeight(85);
        brandIc03.setFitWidth(85);

        //Brand Button
        Button brandBt03 = new Button();
        brandBt03.setGraphic(brandIc03);
        brandBt03.setStyle("-fx-background-color: transparent");
        brandBt03.setOnAction(e->{           stage.setScene(sceneBr); });
      
        //----Account Page----
        //Account Page Image
        ImageView acontIc03 = new ImageView("https://mrkzgulfup.com/do.php?img=73586");
        acontIc03.setFitHeight(85);
        acontIc03.setFitWidth(85);

        //Account Button
        Button acontBt03 = new Button();
        acontBt03.setGraphic(acontIc03);
        acontBt03.setStyle("-fx-background-color: transparent");
        acontBt03.setOnAction(e->{   stage.setScene(AcontScene);});
        //-------Buttons Background-------
        ImageView icnBG03 = new ImageView("https://mrkzgulfup.com/do.php?img=73593");
        icnBG03.setFitHeight(120);
        icnBG03.setFitWidth(600);

        HBBot03.getChildren().addAll(hPBt03, catoBt03, cartBt03, brandBt03, acontBt03);
        HBBot03.setAlignment(Pos.BOTTOM_CENTER);

        StackPane stack03 = new StackPane(icnBG03, HBBot03);

        //Set Buttons in the Bottom
        border4.setTop(stackTop03);
        border4.setCenter(listView4);
        border4.setBottom(stack03);
        border4.setStyle("-fx-background-color: #FDF8F8");
        scene4 = new Scene(border4, 600, 750);
        //---------------------------------------------
        //---------------------------------------------
        
        //    **********  LIPS SCENE  **********
        
        //---------------------------------------------
        //---------------------------------------------
        BorderPane borderLC = new BorderPane();

        //Images
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(15);

        // adding the price and add to cart
        HBox linerprice = new HBox(15);
        HBox lipsprice = new HBox(10);
        HBox glossprice = new HBox(15);

        //add children
        VBox lipliner = new VBox(10);
        VBox lipstick = new VBox(10);
        VBox lipgloss = new VBox(10);

        //Logo
        HBox HBTopL02 = new HBox(50);
        ImageView logoImage02 = new ImageView("https://mrkzgulfup.com/do.php?img=73590");
        logoImage02.setFitHeight(150);
        logoImage02.setFitWidth(150);
        logoImage02.setTranslateY(5);

        //logo Background
        ImageView logoBGImage02 = new ImageView("https://mrkzgulfup.com/do.php?img=73584");
        logoBGImage02.setFitWidth(600);

        HBTopL02.getChildren().add(logoImage02);
        HBTopL02.setAlignment(Pos.CENTER);

        HBox HBTopLBg02 = new HBox();
        HBTopLBg02.getChildren().add(logoBGImage02);
        HBTopLBg02.setAlignment(Pos.TOP_CENTER);

        HBox HBBack02 = new HBox();
        ImageView back02 = new ImageView("https://mrkzgulfup.com/do.php?img=73591");
        back02.setFitHeight(65);
        back02.setFitWidth(65);
        Button back002 =new Button();
        back002.setGraphic(back02);
        back002.setBackground(null);
        HBBack02.getChildren().add(back002);
        HBBack02.setAlignment(Pos.CENTER_LEFT);

        StackPane stackTop02 = new StackPane();
        stackTop02.getChildren().addAll(HBTopLBg02, HBTopL02,HBBack02);
//---------------------------------
        //LIPS-
        Image liplinerwineIMG=new Image("https://mrkzgulfup.com/do.php?img=73787");
        ImageView liplinerimg = new ImageView(liplinerwineIMG);
        liplinerimg.setFitHeight(200);
        liplinerimg.setFitWidth(200);

        Image lipstickcharryIMG=new Image("https://mrkzgulfup.com/do.php?img=73788");
        ImageView lipstickimg = new ImageView(lipstickcharryIMG);
        lipstickimg.setFitHeight(200);
        lipstickimg.setFitWidth(200);

        Image lipglossdelightIMG=new Image("https://mrkzgulfup.com/do.php?img=73789");
        ImageView lipglossimg = new ImageView(lipglossdelightIMG);
        lipglossimg.setFitHeight(200);
        lipglossimg.setFitWidth(200);

        //FACE PRODUCTS COLORS ON BUTTONS
        ComboBox<String> cboliner = new ComboBox<>();
        cboliner.getItems().addAll("BROWN", "Brick Red", "NATURAL PINK", "Puce"); //lipliner colors
        cboliner.setEditable(false);
        cboliner.setPrefWidth(120);
        cboliner.setValue("COLORS");
        cboliner.setVisibleRowCount(2);

        Label colorliner = new Label("no color Selected ");
        colorliner.setStyle("-fx-font-size: 12px;");

            cboliner.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "BROWN":
                        cboliner.setStyle("-fx-background-color:rgb(149, 69, 53)");
                        colorliner.setText(" DARK BROWN");
                        break;
                    case "Brick Red":
                        cboliner.setStyle("-fx-background-color:rgb(170, 74, 68)");
                        colorliner.setText(" Brick Red");
                        break;
                    case "NATURAL PINK":
                        cboliner.setStyle("-fx-background-color:rgb(248, 131, 121)");
                        colorliner.setText(" NATURAL PINK");
                        break;
                    case "Puce":
                        cboliner.setStyle("-fx-background-color:rgb(169, 92, 104)");
                        colorliner.setText(" Puce");
                        break;
                    default:
                        cboliner.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootlipliner = new StackPane();
        rootlipliner.getChildren().add(cboliner);

        ComboBox<String> cbostick = new ComboBox<>();
        cbostick.getItems().addAll("NATURAL PINK", "SOFT RASPBERRY", "Red", "Cerise", "MERLOT"); //lipliner colors
        cbostick.setEditable(false);
        cbostick.setPrefWidth(120);
        cbostick.setValue("COLORS");
        cbostick.setVisibleRowCount(2);
        cbostick.setStyle("-fx-text-fill:transparent;");

        Label colorstick = new Label("no color Selected ");
        colorstick.setStyle("-fx-font-size: 12px;");
        cbostick.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "NATURAL PINK":
                        cbostick.setStyle("-fx-background-color:rgb(248, 131, 121)");//done
                        colorstick.setText(" NATURAL PINK");
                        break;
                    case "SOFT RASPBERRY":
                        cbostick.setStyle("-fx-background-color:rgb(227, 115, 94)");//done
                        colorstick.setText(" SOFT RASPBERRY");
                        break;
                    case "Red":
                        cbostick.setStyle("-fx-background-color:rgb(164, 42, 4)");//done
                        colorstick.setText(" Red");

                        break;
                    case "Cerise":
                        cbostick.setStyle("-fx-background-color:rgb(222, 49, 99)");//done
                        colorstick.setText("  Cerise");

                        break;
                    case "MERLOT":
                        cbostick.setStyle("-fx-background-color:rgb(196, 30, 58)");//done
                        colorstick.setText("  MERLOT");

                        break;
                    default:
                        cbostick.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootlipstick = new StackPane();
        rootlipstick.getChildren().add(cbostick);

        ComboBox<String> cbogloss = new ComboBox<>();
        cbogloss.getItems().addAll("PEACH PINK", "Poppy", "LILAC"); //lipliner colors
        cbogloss.setEditable(false);
        cbogloss.setPrefWidth(120);
        cbogloss.setValue("COLORS");
        cbogloss.setVisibleRowCount(2);
        Label colorloss = new Label("no color Selected ");
        colorloss.setStyle("-fx-font-size: 12px;");
        cbogloss.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                switch (newValue) {
                    case "PEACH PINK":
                        cbogloss.setStyle("-fx-background-color:rgb(250, 160, 160)");
                        colorloss.setText("PEACH PINK");
                        break;
                    case "Poppy":
                        cbogloss.setStyle("-fx-background-color:rgb(227, 83, 53)");
                        colorloss.setText("Poppy");
                        break;
                    case "LILAC":
                        cbogloss.setStyle("-fx-background-color:rgb(250, 128, 114)");
                        colorloss.setText(" LILAC");
                        break;
                    default:
                        cbogloss.setStyle(""); // Reset style for other items
                }
            }
        });
        StackPane rootlipgloss = new StackPane();
        rootlipgloss.getChildren().add(cbogloss);

        //LABELS "NAMES" OF PRODUCTS
        Label lblipliner = new Label("Velvet Wine");
        lblipliner.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label lblipstick = new Label("Velvet cherry");
        lblipstick.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label lblipgloss = new Label("Velvet Delight");
        lblipgloss.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        //PRODUCTS'S PRICE
        Label priceliner = new Label("133 SR");
        priceliner.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 11));

        Label pricestick = new Label("149 SR");
        pricestick.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 11));

        Label pricegloss = new Label("236 SR");
        pricegloss.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 11));

        Button addliner = new Button("Add to cart");
        Button addstick = new Button("Add to cart");
        Button addgloss = new Button("Add to cart");




        //price and quantity
        linerprice.getChildren().addAll(priceliner, addliner);
        lipsprice.getChildren().addAll(pricestick, addstick);
        glossprice.getChildren().addAll(pricegloss, addgloss);

        //add all items
        lipliner.getChildren().addAll(liplinerimg, lblipliner, rootlipliner, linerprice);
        lipstick.getChildren().addAll(lipstickimg, lblipstick, rootlipstick,  lipsprice);
        lipgloss.getChildren().addAll(lipglossimg, lblipgloss, rootlipgloss, glossprice);

        grid.add(lipliner, 0, 0);
        grid.add(lipstick, 0, 1);
        grid.add(lipgloss, 0, 2);

        grid.setAlignment(Pos.CENTER);
        ListView<GridPane> listView = new ListView<>();
        listView.getItems().add(grid);
        listView.setFocusTraversable(false);

        //---------------BOTTOM------------------//
        HBox HBBot02 = new HBox(20);

//----Home page----
//Home page Image
        ImageView homePageIc02 = new ImageView("https://mrkzgulfup.com/do.php?img=73585");
        homePageIc02.setFitHeight(85);
        homePageIc02.setFitWidth(85);

//Home Page Button
        Button hPBt02 = new Button();
        hPBt02.setGraphic(homePageIc02);
        hPBt02.setStyle("-fx-background-color: transparent");
        hPBt02.setOnAction(e->{stage.setScene(HPScene);  });

//----Catetoreies Page----
//Catetoreies Page Image
        ImageView categoryIc02 = new ImageView("https://mrkzgulfup.com/do.php?img=73589");
        categoryIc02.setFitHeight(85);
        categoryIc02.setFitWidth(85);

//Catetoreies Button
        Button catoBt02 = new Button();
        catoBt02.setGraphic(categoryIc02);
        catoBt02.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CATEGORIES
        catoBt02.setOnAction(e->{stage.setScene(scene1);});

//----Cart Page----
//Cart Page Image
        ImageView cartIc02 = new ImageView("https://mrkzgulfup.com/do.php?img=73587");
        cartIc02.setFitHeight(85);
        cartIc02.setFitWidth(85);
        
//Cart Button
        Button cartBt02 = new Button();
        cartBt02.setGraphic(cartIc02);
        cartBt02.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CART
        cartBt02.setOnAction(e->{stage.setScene(scene9);});
        
//----Brand Page----
//Brand Page Image
        ImageView brandIc02 = new ImageView("https://mrkzgulfup.com/do.php?img=73588");
        brandIc02.setFitHeight(85);
        brandIc02.setFitWidth(85);

//Brand Button
        Button brandBt02 = new Button();
        brandBt02.setGraphic(brandIc02);
        brandBt02.setStyle("-fx-background-color: transparent");
        brandBt02.setOnAction(e->{           stage.setScene(sceneBr); });
      
//----Account Page----
//Account Page Image
        ImageView acontIc02 = new ImageView("https://mrkzgulfup.com/do.php?img=73586");
        acontIc02.setFitHeight(85);
        acontIc02.setFitWidth(85);

//Account Button
        Button acontBt02 = new Button();
        acontBt02.setGraphic(acontIc02);
        acontBt02.setStyle("-fx-background-color: transparent");
        acontBt02.setOnAction(e->{   stage.setScene(AcontScene);});
      
//-------Buttons Background-------
        ImageView icnBG02 = new ImageView("https://mrkzgulfup.com/do.php?img=73593");
        icnBG02.setFitHeight(120);
        icnBG02.setFitWidth(600);

        HBBot02.getChildren().addAll(hPBt02, catoBt02, cartBt02, brandBt02, acontBt02);
        HBBot02.setAlignment(Pos.BOTTOM_CENTER);

        StackPane stack02 = new StackPane(icnBG02, HBBot02);

        //Set Buttons in the Bottom-
        borderLC.setTop(stackTop02);
        borderLC.setCenter(listView);
        borderLC.setBottom(stack02);
        borderLC.setStyle("-fx-background-color: #FDF8F8");
        scene = new Scene(borderLC, 600, 750);
        
        
        //---------------------------------------------
        //---------------------------------------------
        
        //    **********  EYES SCENE  **********
        
        //---------------------------------------------
        //---------------------------------------------

        BorderPane border2 = new BorderPane();

        //Images
        GridPane grid2 = new GridPane();
        grid2.setHgap(20);
        grid2.setVgap(15);

        // adding the price and add to cart
        HBox priceSadow = new HBox(10);
        HBox pricepen = new HBox(15);
        HBox pricelash = new HBox(15);
        HBox pricemascara = new HBox(15);
        HBox pricgel = new HBox(15);

        //add children
        VBox eShadow = new VBox(10);
        VBox pincel = new VBox(10);
        VBox lashes = new VBox(10);
        VBox Mmascara = new VBox(10);
        VBox bgel = new VBox(10);

        //Logo
        HBox HBTopL01 = new HBox(50);
        ImageView logoImage01 = new ImageView("https://mrkzgulfup.com/do.php?img=73590");
        logoImage01.setFitHeight(150);
        logoImage01.setFitWidth(150);
        logoImage01.setTranslateY(5);

        //logo Background
        ImageView logoBGImage01 = new ImageView("https://mrkzgulfup.com/do.php?img=73584");
        logoBGImage01.setFitWidth(600);

        HBTopL01.getChildren().add(logoImage01);
        HBTopL01.setAlignment(Pos.CENTER);

        HBox HBTopLBg01 = new HBox();
        HBTopLBg01.getChildren().add(logoBGImage01);
        HBTopLBg01.setAlignment(Pos.TOP_CENTER);

        HBox HBBack01 = new HBox();
        ImageView back01 = new ImageView("https://mrkzgulfup.com/do.php?img=73591");
        back01.setFitHeight(65);
        back01.setFitWidth(65);
        Button back001 =new Button();
        back001.setGraphic(back01);
        back001.setBackground(null);
        HBBack01.getChildren().add(back001);
        HBBack01.setAlignment(Pos.CENTER_LEFT);

        StackPane stackTop01 = new StackPane();
        stackTop01.getChildren().addAll(HBTopLBg01, HBTopL01,HBBack01);

        //---------------eye PRODUCTS--------------------
        Image shadowimg=new Image("https://mrkzgulfup.com/do.php?img=74041");
        ImageView eyeshadow = new ImageView(shadowimg);
        eyeshadow.setFitHeight(200);
        eyeshadow.setFitWidth(200);

        Image pinimg=new Image("https://mrkzgulfup.com/do.php?img=74040");
        ImageView pin = new ImageView(pinimg);
        pin.setFitHeight(200);
        pin.setFitWidth(200);

        Image lashimg=new Image("https://mrkzgulfup.com/do.php?img=74038");
        ImageView lash = new ImageView(lashimg);
        lash.setFitHeight(200);
        lash.setFitWidth(200);


        Image mascaraimg=new Image("https://mrkzgulfup.com/do.php?img=74037");
        ImageView mascara = new ImageView(mascaraimg);
        mascara.setFitHeight(200);
        mascara.setFitWidth(200);

        Image gelimg=new Image("https://mrkzgulfup.com/do.php?img=74039");

        ImageView gel = new ImageView(gelimg);
        gel.setFitHeight(200);
        gel.setFitWidth(200);
        //---------------COLORS OF EYEBROW PENCIL--------------
        ComboBox<String> pincolor = new ComboBox<>();
        pincolor.getItems().addAll("DARK BROWN", "BROWN", "BLOND");

        Label colorLabel = new Label("no color Selected ");
        colorLabel.setStyle("-fx-font-size: 12px;");
        pincolor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "DARK BROWN":
                        pincolor.setStyle("-fx-background-color:#3F2A13;");
                        colorLabel.setText(" DARK BROWN");
                        break;
                    case "BROWN":
                        pincolor.setStyle("-fx-background-color:#66441C; ");
                        colorLabel.setText(" BROWN");
                        break;
                    case "BLOND":
                        pincolor.setStyle("-fx-background-color:#9B7447; ");
                        colorLabel.setText(" BLOND");
                        break;
                    default:
                        pincolor.setStyle("");
                        colorLabel.setText(" None");
                }
            }
        });
        StackPane rootpincolor = new StackPane();
        rootpincolor.getChildren().add(pincolor);

        //-----------EYE'S LABELS UNDER IMAGES------------
        Label shadow = new Label("Velvet Eyeshadow");
        shadow.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label pinsl = new Label("Velvet Eyebrow Pencil");
        pinsl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label eyelaash = new Label("Velvet Eyelashes");
        eyelaash.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label mascaraL = new Label("Velvet Mascara");
        mascaraL.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label gell = new Label("Velvet Eyebrow Gel");
        gell.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        //--------------------PRODUCTS'S PRICE--------------------
        Label shadprice = new Label("300 SR");

        Label penprice = new Label("100 SR");

        Label lashprice = new Label("60 SR");

        Label mascaraprice = new Label("80 SR");

        Label gelprice = new Label("50 SR");

        Button addSadow = new Button("Add to cart");
        Button addpen = new Button("Add to cart");
        Button addlash = new Button("Add to cart");
        Button addmascara = new Button("Add to cart");
        Button addgel = new Button("Add to cart");
        //------------SET ACTION TO THE ADD TO CART BUTTONS-------------
        priceSadow.getChildren().addAll(shadprice, addSadow);
        pricepen.getChildren().addAll(penprice, addpen);
        pricelash.getChildren().addAll(lashprice, addlash);
        pricemascara.getChildren().addAll(mascaraprice, addmascara);
        pricgel.getChildren().addAll(gelprice, addgel);

        eShadow.getChildren().addAll(eyeshadow, shadow, priceSadow);
        pincel.getChildren().addAll(pin, pinsl, rootpincolor,  pricepen);
        lashes.getChildren().addAll(lash, eyelaash,  pricelash);
        Mmascara.getChildren().addAll(mascara, mascaraL,  pricemascara);
        bgel.getChildren().addAll(gel, gell,  pricgel);

        grid2.add(eShadow, 0, 0);
        grid2.add(pincel, 0, 1);
        grid2.add(lashes, 0, 2);
        grid2.add(Mmascara, 1, 0);
        grid2.add(bgel, 1, 1);

        grid2.setAlignment(Pos.CENTER);
        ListView<GridPane> listView2 = new ListView<>();
        listView2.getItems().add(grid2);
        listView2.setFocusTraversable(false);
        //---------------BOTTOM------------------//
        HBox HBBot01 = new HBox(20);

//----Home page----
//Home page Image
        ImageView homePageIc01 = new ImageView("https://mrkzgulfup.com/do.php?img=73585");
        homePageIc01.setFitHeight(85);
        homePageIc01.setFitWidth(85);

//Home Page Button
        Button hPBt01 = new Button();
        hPBt01.setGraphic(homePageIc01);
        hPBt01.setStyle("-fx-background-color: transparent");
        hPBt01.setOnAction(e->{stage.setScene(HPScene);  });

//----Catetoreies Page----
//Catetoreies Page Image
        ImageView categoryIc01 = new ImageView("https://mrkzgulfup.com/do.php?img=73589");
        categoryIc01.setFitHeight(85);
        categoryIc01.setFitWidth(85);

//Catetoreies Button
        Button catoBt01 = new Button();
        catoBt01.setGraphic(categoryIc01);
        catoBt01.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CATEGORIES
        catoBt01.setOnAction(e->{stage.setScene(scene1);});

//----Cart Page----
//Cart Page Image
        ImageView cartIc01 = new ImageView("https://mrkzgulfup.com/do.php?img=73587");
        cartIc01.setFitHeight(85);
        cartIc01.setFitWidth(85);

//Cart Button
        Button cartBt01 = new Button();
        cartBt01.setGraphic(cartIc01);
        cartBt01.setStyle("-fx-background-color: transparent");
        
        //ACTION DONE FOR CART
        cartBt01.setOnAction(e->{stage.setScene(scene9);});

//----Brand Page----
//Brand Page Image
        ImageView brandIc01 = new ImageView("https://mrkzgulfup.com/do.php?img=73588");
        brandIc01.setFitHeight(85);
        brandIc01.setFitWidth(85);

//Brand Button
        Button brandBt01 = new Button();
        brandBt01.setGraphic(brandIc01);
        brandBt01.setStyle("-fx-background-color: transparent");
        brandBt01.setOnAction(e->{           stage.setScene(sceneBr); });


//----Account Page----
//Account Page Image
        ImageView acontIc01 = new ImageView("https://mrkzgulfup.com/do.php?img=73586");
        acontIc01.setFitHeight(85);
        acontIc01.setFitWidth(85);

//Account Button
        Button acontBt01 = new Button();
        acontBt01.setGraphic(acontIc01);
        acontBt01.setStyle("-fx-background-color: transparent");
        acontBt01.setOnAction(e->{   stage.setScene(AcontScene);});
        
//-------Buttons Background-------
        ImageView icnBG01 = new ImageView("https://mrkzgulfup.com/do.php?img=73593");
        icnBG01.setFitHeight(120);
        icnBG01.setFitWidth(600);

        HBBot01.getChildren().addAll(hPBt01, catoBt01, cartBt01, brandBt01, acontBt01);
        HBBot01.setAlignment(Pos.BOTTOM_CENTER);

        StackPane stack01 = new StackPane(icnBG01, HBBot01);

        //-----set Buttons in the Bottom-----
        border2.setTop(stackTop01);
        border2.setCenter(listView2);
        border2.setBottom(stack01);
        border2.setStyle("-fx-background-color: #FDF8F8");
        scene2 = new Scene(border2, 600, 750);

        
        

        //---------------------------------------------
        //---------------------------------------------
        
        //    **********  CART SCENE  **********
        
        //---------------------------------------------
        //---------------------------------------------


        //top porder
        HBox topC = new HBox();
        topC.setStyle("-fx-border-color: #ffffff; -fx-background-color: #dbc5c4");
        topC.setAlignment(Pos.CENTER_RIGHT);


        Text toptext = new Text("Shopping bag");
        topC.getChildren().add(toptext);
        topC.setMargin(toptext, new Insets(0, 170, 0, 80));//b,l,t,r


        Image logoImage1C = new Image("https://mrkzgulfup.com/do.php?img=73679");
        ImageView logo1C = new ImageView(logoImage1C);//Setting the image view
        logo1C.setFitHeight(60); //setting the fit height and width of the image view
        logo1C.setFitWidth(80);

        topC.getChildren().add(logo1C);

        //center porder
        //eye
        //background of orders
        Rectangle primerback = new Rectangle(530, 90);
        primerback.setFill(Color.web("db798d",0.3));

        Rectangle plushback = new Rectangle(530, 90);
        plushback.setFill(Color.web("db798d",0.3));

        Rectangle concealback = new Rectangle(530, 90);
        concealback.setFill(Color.web("db798d",0.3));

        Rectangle highlback = new Rectangle(530, 90);
        highlback.setFill(Color.web("db798d",0.3));

        Rectangle fondback = new Rectangle(530, 90);
        fondback.setFill(Color.web("db798d",0.3));

        Rectangle sparyback = new Rectangle(530, 90);
        sparyback.setFill(Color.web("db798d",0.3));

        ImageView primimageview = new ImageView(primerIMG);
        primimageview.setFitWidth(70);
        primimageview.setFitHeight(70);

        ImageView plushimageview = new ImageView(plushIMG);
        plushimageview.setFitWidth(70);
        plushimageview.setFitHeight(70);

        ImageView concealrimageview = new ImageView(conselIMG);
        concealrimageview.setFitWidth(70);
        concealrimageview.setFitHeight(70);

        ImageView highlimageview = new ImageView(highlhIMG);
        highlimageview.setFitWidth(70);
        highlimageview.setFitHeight(70);

        ImageView fondimageview = new ImageView(fondIMG);
        fondimageview.setFitWidth(70);
        fondimageview.setFitHeight(70);

        ImageView sparyimageview = new ImageView(sparyhIMG);
        sparyimageview.setFitWidth(70);
        sparyimageview.setFitHeight(70);
        //FACE'S LABELS UNDER IMAGES
        Label tprimer = new Label("Velvet Primer");
        tprimer.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label tconc = new Label("Velvet Concealer");
        tconc.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label tfon = new Label("Velvet fondation");
        tfon.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label tplusher = new Label("Velvet plush");
        tplusher.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label thigh = new Label("Velvet highliter");
        thigh.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label tspr = new Label("Velvet spray");
        tspr.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label PPrimprice = new Label("83 SR");
        PPrimprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label CConcprice = new Label("249 SR");
        CConcprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label FFonprice = new Label("119 SR");
        FFonprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label PPlushprice = new Label("165 SR");
        PPlushprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label HHighliterprice = new Label("139 SR");
        HHighliterprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Label SSparyprice = new Label("75 SR");
        SSparyprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

        //conting the item lebals
        Button primminus = new Button("-");
        Button primplus = new Button("+");
        primminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        primplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button plushminus = new Button("-");
        Button plushplus = new Button("+");
        plushminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        plushplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button fondminus = new Button("-");
        Button fondplus = new Button("+");
        fondminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        fondplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button sparyminus = new Button("-");
        Button sparyplus = new Button("+");
        sparyminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        sparyplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button conceminus = new Button("-");
        Button conceplus = new Button("+");
        conceminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        conceplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button highminus = new Button("-");
        Button highplus = new Button("+");
        highminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        highplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");
        // conting the item quintity

        Label primcount = new Label("" + count1primer);
        primcount.setMaxSize(15, 15);
        primcount.setMinSize(15, 15);
        primcount.setAlignment(Pos.TOP_CENTER);

        Label plushcount = new Label("" + count2plush);
        plushcount.setMaxSize(15, 15);
        plushcount.setMinSize(15, 15);
        plushcount.setAlignment(Pos.CENTER);

        Label concealerlashescount = new Label("" + count3concealer);
        concealerlashescount.setMaxSize(15, 15);
        concealerlashescount.setMinSize(15, 15);
        concealerlashescount.setAlignment(Pos.CENTER);

        Label highlitercount = new Label("" + count4highliter);
        highlitercount.setMaxSize(15, 15);
        highlitercount.setMinSize(15, 15);
        highlitercount.setAlignment(Pos.CENTER);

        Label fondcount = new Label("" + count5fondation);
        fondcount.setMaxSize(15, 15);
        fondcount.setMinSize(15, 15);
        fondcount.setAlignment(Pos.CENTER);

        Label spraycount = new Label("" + count6spray);
        spraycount.setMaxSize(15, 15);
        spraycount.setMinSize(15, 15);
        spraycount.setAlignment(Pos.CENTER);

        //remove button
        Button primeRemove = new Button("Remove");
        primeRemove.setStyle("-fx-background-color: #db798d;");

        Button plushRemove = new Button("Remove");
        plushRemove.setStyle("-fx-background-color: #db798d;");

        Button concealRemove = new Button("Remove");
        concealRemove.setStyle("-fx-background-color: #db798d;");

        Button highRemove = new Button("Remove");
        highRemove.setStyle("-fx-background-color: #db798d;");

        Button fondRemove = new Button("Remove");
        fondRemove.setStyle("-fx-background-color: #db798d;");

        Button sparyRemove = new Button("Remove");
        sparyRemove.setStyle("-fx-background-color: #db798d;");

        //for prim
        HBox primScount = new HBox(10,primminus, primcount, primplus);
        VBox primScontrol = new VBox(23, primScount, primeRemove);
        VBox primStext = new VBox(15, tprimer,primercolor, PPrimprice);
        HBox primSrorder = new HBox(75, primimageview, primStext, primScontrol);
        primScount.setAlignment(Pos.CENTER);
        primScontrol.setAlignment(Pos.CENTER);
        primStext.setAlignment(Pos.CENTER);
        primSrorder.setAlignment(Pos.CENTER);
        StackPane primstack = new StackPane(primerback, primSrorder);

        //for plush
        HBox plushScount = new HBox(10,plushminus, plushcount, plushplus);
        VBox plushScontrol = new VBox(23, plushScount, plushRemove);
        VBox plushStext = new VBox(15, tplusher, PPlushprice);
        HBox plushSrorder = new HBox(75, plushimageview, plushStext, plushScontrol);
        plushScount.setAlignment(Pos.CENTER);
        plushScontrol.setAlignment(Pos.CENTER);
        plushStext.setAlignment(Pos.CENTER);
        plushSrorder.setAlignment(Pos.CENTER);
        StackPane plushstack = new StackPane(plushback, plushSrorder);

//        //for high
        HBox highScount = new HBox(10,highminus, highlitercount, highplus);
        VBox highScontrol = new VBox(23, highScount, highRemove);
        VBox highStext = new VBox(15, thigh, HHighliterprice);
        HBox highSrorder = new HBox(75, highlimageview, highStext, highScontrol);
        highScount.setAlignment(Pos.CENTER);
        highScontrol.setAlignment(Pos.CENTER);
        highStext.setAlignment(Pos.CENTER);
        highSrorder.setAlignment(Pos.CENTER);
        StackPane highstack = new StackPane(highlback, highSrorder);
//        //for fond
        HBox fonScount = new HBox(10,fondminus, fondcount, fondplus);
        VBox fonScontrol = new VBox(23, fonScount, fondRemove);
        VBox fonStext = new VBox(15, tfon,fondcolor, FFonprice);
        HBox fonSrorder = new HBox(75, fondimageview, fonStext, fonScontrol);
        fonScount.setAlignment(Pos.CENTER);
        fonScontrol.setAlignment(Pos.CENTER);
        fonStext.setAlignment(Pos.CENTER);
        fonSrorder.setAlignment(Pos.CENTER);
        StackPane fonstack = new StackPane(fondback, fonSrorder);
//        //for spary
        HBox sparyScount = new HBox(10,sparyminus, spraycount, sparyplus);
        VBox sparyScontrol = new VBox(23, sparyScount, sparyRemove);
        VBox sparyStext = new VBox(15, tspr, SSparyprice);
        HBox sparySrorder = new HBox(75, sparyimageview, sparyStext, sparyScontrol);
        sparyScount.setAlignment(Pos.CENTER);
        sparyScontrol.setAlignment(Pos.CENTER);
        sparyStext.setAlignment(Pos.CENTER);
        sparySrorder.setAlignment(Pos.CENTER);
        StackPane sparystack = new StackPane(sparyback, sparySrorder);

        //        //for CONC
        HBox concScount = new HBox(10,conceminus, concealerlashescount, conceplus);
        VBox concScontrol = new VBox(23, concScount, concealRemove);
        VBox concStext = new VBox(15, tconc,concealrcolor, CConcprice);
        HBox concSrorder = new HBox(75, concealrimageview, concStext, concScontrol);
        concScount.setAlignment(Pos.CENTER);
        concScontrol.setAlignment(Pos.CENTER);
        concStext.setAlignment(Pos.CENTER);
        concSrorder.setAlignment(Pos.CENTER);
        StackPane concstack = new StackPane(concealback, concSrorder);
        //background of orders
        Rectangle shadowback = new Rectangle(530, 90);
        shadowback.setFill(Color.web("db798d",0.3));

        Rectangle mascaraback = new Rectangle(530, 90);
        mascaraback.setFill(Color.web("db798d",0.3));

        Rectangle pencilback = new Rectangle(530, 90);
        pencilback.setFill(Color.web("db798d",0.3));

        Rectangle gelback = new Rectangle(530, 90);
        gelback.setFill(Color.web("db798d",0.3));

        Rectangle lashback = new Rectangle(530, 90);
        lashback.setFill(Color.web("db798d",0.3));
        //lmg view to show img
        ImageView shadowimageview = new ImageView(shadowimg);
        shadowimageview.setFitWidth(70);
        shadowimageview.setFitHeight(70);

        ImageView pinceilimageview = new ImageView(pinimg);
        pinceilimageview.setFitWidth(70);
        pinceilimageview.setFitHeight(70);

        ImageView lashimageview = new ImageView(lashimg);
        lashimageview.setFitWidth(70);
        lashimageview.setFitHeight(70);

        ImageView mascaraimageview = new ImageView(mascaraimg);
        mascaraimageview.setFitWidth(70);
        mascaraimageview.setFitHeight(70);

        ImageView galimageview = new ImageView(gelimg);
        galimageview.setFitWidth(70);
        galimageview.setFitHeight(70);

        //text show price and name
        Text tshadow = new Text("Velvet Eyeshadow");
        tshadow.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tshadow.setWrappingWidth(100);
        Text SHADOWprice = new Text("300 SR");
        SHADOWprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        SHADOWprice.setWrappingWidth(100);

        Text tmascara = new Text("Velvet Mascara");
        tmascara.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tmascara.setWrappingWidth(100);
        Text mascprice = new Text("80 SR");
        mascprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        mascprice.setWrappingWidth(100);

        Text tpin = new Text("Velvet Eyebrow Pencil");
        tpin.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        tpin.setWrappingWidth(100);
        Text pinprice = new Text("100 SR");
        pinprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        pinprice.setWrappingWidth(100);

        Text tgal = new Text("Velvet Eyebrow Gel");
        tgal.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        tgal.setWrappingWidth(100);
        Text galprice = new Text("50 SR");
        galprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        galprice.setWrappingWidth(100);

        Text tlash = new Text("Velvet Eyelashes");
        tlash.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        tlash.setWrappingWidth(100);
        Text lashsprice = new Text("60 SR");
        lashsprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 13));
        lashsprice.setWrappingWidth(100);

        //conting the item lebals
        Button shadminus = new Button("-");
        Button shadplus = new Button("+");
        shadminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        shadplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button mascarminus = new Button("-");
        Button mascarplus = new Button("+");
        mascarminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        mascarplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button pinminus = new Button("-");
        Button pinplus = new Button("+");
        pinminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        pinplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button galminus = new Button("-");
        Button galplus = new Button("+");
        galminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        galplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button lashesminus = new Button("-");
        Button lashesplus = new Button("+");
        lashesminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        lashesplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");
        // conting the item quintity

        Label shadcount = new Label("" + count1);
        shadcount.setMaxSize(15, 15);
        shadcount.setMinSize(15, 15);
        shadcount.setAlignment(Pos.TOP_CENTER);

        Label pincount = new Label("" + count2);
        pincount.setMaxSize(15, 15);
        pincount.setMinSize(15, 15);
        pincount.setAlignment(Pos.CENTER);

        Label lashescount = new Label("" + count3);
        lashescount.setMaxSize(15, 15);
        lashescount.setMinSize(15, 15);
        lashescount.setAlignment(Pos.CENTER);

        Label masccount = new Label("" + count4);
        masccount.setMaxSize(15, 15);
        masccount.setMinSize(15, 15);
        masccount.setAlignment(Pos.CENTER);

        Label galcount = new Label("" + count5);
        galcount.setMaxSize(15, 15);
        galcount.setMinSize(15, 15);
        galcount.setAlignment(Pos.CENTER);

        //remove button
        Button shadowRemove = new Button("Remove");
        shadowRemove.setStyle("-fx-background-color: #db798d;");

        Button pinRemove = new Button("Remove");
        pinRemove.setStyle("-fx-background-color: #db798d;");

        Button lashRemove = new Button("Remove");
        lashRemove.setStyle("-fx-background-color: #db798d;");

        Button mascRemove = new Button("Remove");
        mascRemove.setStyle("-fx-background-color: #db798d;");

        Button galRemove = new Button("Remove");
        galRemove.setStyle("-fx-background-color: #db798d;");
          //for shadow
        HBox shadowScount = new HBox(10,shadminus, shadcount, shadplus);
        VBox shadowScontrol = new VBox(23, shadowScount, shadowRemove);
        VBox shadowStext = new VBox(15, tshadow, SHADOWprice);
        HBox shadowSrorder = new HBox(75, shadowimageview, shadowStext, shadowScontrol);
        shadowScount.setAlignment(Pos.CENTER);
        shadowScontrol.setAlignment(Pos.CENTER);
        shadowStext.setAlignment(Pos.CENTER);
        shadowSrorder.setAlignment(Pos.CENTER);
        StackPane SHADOWstack = new StackPane(shadowback, shadowSrorder);

        //for pencil
        HBox pinScount = new HBox(10,pinminus, pincount, pinplus);
        VBox pinScontrol = new VBox(23, pinScount, pinRemove);
        VBox pinStext = new VBox(15, tpin,colorLabel, pinprice);
        HBox pinSrorder = new HBox(75, pinceilimageview, pinStext, pinScontrol);
        pinScount.setAlignment(Pos.CENTER);
        pinScontrol.setAlignment(Pos.CENTER);
        pinStext.setAlignment(Pos.CENTER);
        pinSrorder.setAlignment(Pos.CENTER);
        StackPane Pinstack = new StackPane(pencilback, pinSrorder);

        //for mascare
        HBox mascScount = new HBox(10,mascarminus, masccount, mascarplus);
        VBox mascScontrol = new VBox(23, mascScount, mascRemove);
        VBox mascStext = new VBox(15, tmascara, mascprice);
        HBox mascSrorder = new HBox(75, mascaraimageview, mascStext, mascScontrol);
        mascScount.setAlignment(Pos.CENTER);
        mascScontrol.setAlignment(Pos.CENTER);
        mascStext.setAlignment(Pos.CENTER);
        mascSrorder.setAlignment(Pos.CENTER);
        StackPane Mascstack = new StackPane(mascaraback, mascSrorder);
        //for gel
        HBox gelScount = new HBox(10,galminus, galcount, galplus);
        VBox gelScontrol = new VBox(23, gelScount, galRemove);
        VBox gelStext = new VBox(15, tgal, galprice);
        HBox gelSrorder = new HBox(75, galimageview, gelStext, gelScontrol);
        gelScount.setAlignment(Pos.CENTER);
        gelScontrol.setAlignment(Pos.CENTER);
        gelStext.setAlignment(Pos.CENTER);
        gelSrorder.setAlignment(Pos.CENTER);
        StackPane Gelstack = new StackPane(gelback, gelSrorder);
        //for lashes
        HBox lasheScount = new HBox(10,lashesminus, lashescount, lashesplus);
        VBox lashScontrol = new VBox(23, lasheScount, lashRemove);
        VBox lashStext = new VBox(15, tlash, lashprice);
        HBox lashSrorder = new HBox(75, lashimageview, lashStext, lashScontrol);
        lasheScount.setAlignment(Pos.CENTER);
        lashScontrol.setAlignment(Pos.CENTER);
        lashStext.setAlignment(Pos.CENTER);
        lashSrorder.setAlignment(Pos.CENTER);
        StackPane Lashstack = new StackPane(lashback, lashSrorder);
        //lips
        //center porder
        //background of orders
        Rectangle linerback = new Rectangle(530, 90);
        linerback.setFill(Color.web("db798d",0.3));

        Rectangle stickback = new Rectangle(530, 90);
        stickback.setFill(Color.web("db798d",0.3));

        Rectangle glossback = new Rectangle(530, 90);
        glossback.setFill(Color.web("db798d",0.3));

        //lmg view to show img
        ImageView linerimageview = new ImageView(liplinerwineIMG);
        linerimageview.setFitWidth(70);
        linerimageview.setFitHeight(70);

        ImageView stickimageview = new ImageView(lipstickcharryIMG);
        stickimageview.setFitWidth(70);
        stickimageview.setFitHeight(70);

        ImageView glossimageview = new ImageView(lipglossdelightIMG);
        glossimageview.setFitWidth(70);
        glossimageview.setFitHeight(70);

        //name and price
        Text tstick = new Text("Velvet cherry");
        tstick.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tstick.setWrappingWidth(100);
        Text stickprice = new Text("149 SR");
        stickprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        stickprice.setWrappingWidth(100);

        Text tliner = new Text("Velvet Wine");
        tliner.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tliner.setWrappingWidth(100);
        Text Linerprice = new Text("133 SR");
        Linerprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        Linerprice.setWrappingWidth(100);

        Text tgloss = new Text("Velvet Delight");
        tgloss.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tgloss.setWrappingWidth(100);
        Text Glossprice = new Text("236 SR");
        Glossprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        Glossprice.setWrappingWidth(100);

        //conting the item lebals
        Button linerminus = new Button("-");
        Button linerplus = new Button("+");
        linerminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        linerplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button stickminus = new Button("-");
        Button stickplus = new Button("+");
        stickminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        stickplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        Button glossminus = new Button("-");
        Button glossplus = new Button("+");
        glossminus.setStyle("-fx-background-color: #db798d; -fx-font-size: 10px; -fx-font-weight: bold;");
        glossplus.setStyle("-fx-background-color: #db798d;  -fx-font-size: 10px; -fx-font-weight: bold;");

        // conting the item quintity

        Label leballinercount = new Label("" + count1wine );
        leballinercount.setMaxSize(15, 15);
        leballinercount.setMinSize(15, 15);
        leballinercount.setAlignment(Pos.TOP_CENTER);

        Label lebalstickcount = new Label("" + count2charry);
        lebalstickcount.setMaxSize(15, 15);
        lebalstickcount.setMinSize(15, 15);
        lebalstickcount.setAlignment(Pos.TOP_CENTER);

        Label lebalglosscount = new Label("" + count3delight);
        lebalglosscount.setMaxSize(15, 15);
        lebalglosscount.setMinSize(15, 15);
        lebalglosscount.setAlignment(Pos.TOP_CENTER);

        //remove button
        Button linerRemove = new Button("Remove");
        linerRemove.setStyle("-fx-background-color: #db798d;");

        Button stickRemove = new Button("Remove");
        stickRemove.setStyle("-fx-background-color: #db798d;");

        Button glossRemove = new Button("Remove");
        glossRemove.setStyle("-fx-background-color: #db798d;");
        // for liner
        HBox linerScount = new HBox(10,linerminus, leballinercount, linerplus);
        VBox linercontrol = new VBox(23, linerScount, linerRemove);
        VBox linertext = new VBox(15, tliner,colorliner, Linerprice);
        HBox linerrorder = new HBox(75, linerimageview, linertext, linercontrol);
        linerScount.setAlignment(Pos.CENTER);
        linercontrol.setAlignment(Pos.CENTER);
        linertext.setAlignment(Pos.CENTER);
        linerrorder.setAlignment(Pos.CENTER);
        StackPane linerstack = new StackPane(linerback, linerrorder);
//
//        //for stick
        HBox stickScount = new HBox(10,stickminus,lebalstickcount, stickplus);
        VBox stickScontrol = new VBox(23, stickScount, stickRemove);
        VBox stickStext = new VBox(15, tstick,colorstick, stickprice);
        HBox stickSrorder = new HBox(75, stickimageview, stickStext, stickScontrol);
        stickScount.setAlignment(Pos.CENTER);
        stickScontrol.setAlignment(Pos.CENTER);
        stickStext.setAlignment(Pos.CENTER);
        stickSrorder.setAlignment(Pos.CENTER);
        StackPane stickstack = new StackPane(stickback, stickSrorder);
//
        //for gloss
        HBox glossScount = new HBox(10,glossminus, lebalglosscount, glossplus);
        VBox glossScontrol = new VBox(23, glossScount, glossRemove);
        VBox glossStext = new VBox(15, tgloss,colorloss, Glossprice);
        HBox glossSrorder = new HBox(75, glossimageview, glossStext, glossScontrol);
        glossScount.setAlignment(Pos.CENTER);
        glossScontrol.setAlignment(Pos.CENTER);
        glossStext.setAlignment(Pos.CENTER);
        glossSrorder.setAlignment(Pos.CENTER);
        StackPane glossstack = new StackPane(glossback, glossSrorder);

        //||\\
        Orders.setFocusTraversable(false);
        //
       GridPane check =  new GridPane();
        Label items=new Label("total items: ");
        Label totalitems= new Label(" "+totalitemsofAll );
        Label prices=new Label("total price SR: " );
       Label totalprices= new Label("" +totalpriceofAll );
       TextField discount= new TextField("add diccount");
       Button discountB = new Button(" diccount");
 
        

        check.add(items,0,0);
        check.add(totalitems,1,0);
        check.add(prices,2,0);
        check.add(totalprices,3,0);
        check.add(discount,3,1);
        check.add(discountB,2,1);
         
        check.setHgap(20);
        check.setVgap(15);
        check.setAlignment(Pos.CENTER);

        Button Confirmation = new Button("Confirm the order");
        Confirmation.setStyle("-fx-color: #db798d;-fx-background-color: #db798d; -fx-font: normal bold 15px 'Bell MT';");

        BooleanBinding listNotEmpty = Bindings.isNotEmpty(ProductToCart);
        Confirmation.visibleProperty().bind(listNotEmpty);
        

        HBox checklist = new HBox(50);
        checklist.getChildren().addAll(check, Confirmation);
        checklist.setAlignment(Pos.CENTER);
        checklist.setStyle("-fx-background-color: #dbc5c4;");

        VBox order_p = new VBox(checklist);
       

        Orders.setStyle("-fx-control-inner-background: #ffffff;");
        
        //
        //eye
        //prime
        primminus.setOnAction(e -> {
            if (count1primer >= 2) {// int
                count1primer = count1primer - 1;
                // lebel contain the int up value if bread
                primcount.setText("" + count1primer);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 83) + " SR");
            }
        });
        primplus.setOnAction(e -> {
            count1primer = count1primer + 1;

            primcount.setText("" + count1primer);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 83) + " SR");
        });
        primeRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count1primer));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count1primer * 83)) + " SR");
            Orders.getItems().remove(primstack);
        });
        //plush
        plushminus.setOnAction(e -> {
            if (count2plush >= 2) {// int
                count2plush = count2plush - 1;
                // lebel contain the int up value if bread
                plushcount.setText("" + count2plush);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 165) + " SR");
            }
        });
        plushplus.setOnAction(e -> {
            count2plush = count2plush + 1;

            plushcount.setText("" + count2plush);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 165) + " SR");
        });
        plushRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count2plush));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count2plush * 165)) + " SR");
            Orders.getItems().remove(plushstack);
        });
        //conc
        conceminus.setOnAction(e -> {
            if (count3concealer >= 2) {// int
                count3concealer = count3concealer - 1;
                // lebel contain the int up value if bread
                concealerlashescount.setText("" + count3concealer);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 249) + " SR");
            }
        });
        conceplus.setOnAction(e -> {
            count3concealer = count3concealer + 1;

            concealerlashescount.setText("" + count3concealer);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 249) + " SR");
        });
        concealRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count3concealer));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count3concealer * 249)) + " SR");
            Orders.getItems().remove(concstack);
        });
        //HIGHLIT
        highminus.setOnAction(e -> {
            if (count4highliter >= 2) {// int
                count4highliter = count4highliter - 1;
                // lebel contain the int up value if bread
                highlitercount.setText("" + count4highliter);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 139) + " SR");
            }
        });
        highplus.setOnAction(e -> {
            count4highliter = count4highliter + 1;

            highlitercount.setText("" + count4highliter);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 139) + " SR");
        });
        highRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count4highliter));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count4highliter * 139)) + " SR");
            Orders.getItems().remove(highstack);
        });
        //fon
        fondminus.setOnAction(e -> {
            if (count5fondation >= 2) {// int
                count5fondation = count5fondation - 1;
                // lebel contain the int up value if bread
                fondcount.setText("" + count5fondation);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 119) + " SR");
            }
        });
        fondplus.setOnAction(e -> {
            count5fondation = count5fondation + 1;

            fondcount.setText("" + count5fondation);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 119) + " SR");
        });
        fondRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count5fondation));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count5fondation * 119)) + " SR");
            Orders.getItems().remove(fonstack);
        });
        //spra
        sparyminus.setOnAction(e -> {
            if (count6spray >= 2) {// int
                count6spray = count6spray - 1;
                // lebel contain the int up value if bread
                spraycount.setText("" + count6spray);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 75) + " SR");
            }
        });
        sparyplus.setOnAction(e -> {
            count6spray = count6spray + 1;

            spraycount.setText("" + count6spray);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 75) + " SR");
        });
        sparyRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count6spray));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count6spray * 75)) + " SR");
            Orders.getItems().remove(sparystack);
        });

        //add
        addprim.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(primstack)) {
                ProductToCart.add(primstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 83) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });

        addplush.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(plushstack)) {
                ProductToCart.add(plushstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 165) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });

        addcon.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(concstack)) {
                ProductToCart.add(concstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 249) + " SR");
            } else {
                System.out.println("The button has been clicked!");
            }
        });
        addhighliter.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(highstack)) {
                ProductToCart.add(highstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 139) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        addfon.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(fonstack)) {
                ProductToCart.add(fonstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 119) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        addspray.setOnAction( event ->{
            // the ob list
            if (!ProductToCart.contains(sparystack)) {
                ProductToCart.add(sparystack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 75) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //face
        //shad
        shadminus.setOnAction(e -> {
            if (count1 >= 2) {// int
                count1 = count1 - 1;
                // lebel contain the int up value if bread
                shadcount.setText("" + count1);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 300) + " SR");
            }
        });
        shadplus.setOnAction(e -> {
            count1 = count1 + 1;

            shadcount.setText("" + count1);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 300) + " SR");
        });
        shadowRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count1));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count1 * 300)) + " SR");
            Orders.getItems().remove(SHADOWstack);
        });

        //pin action
        pinminus.setOnAction(e -> {
            if (count2 >= 2) {// int
                count2 = count2 - 1;
                // lebel contain the int up value if bread
                pincount.setText("" + count2);
                // dont add
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 100) + " SR");
            }
        });
        pinplus.setOnAction(e -> {
            count2 = count2 + 1;

            pincount.setText("" + count2);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 100) + " SR");
        });
        pinRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count2));
            // remove usenig same way of + -
            //totalprices.setText((totalpriceofAll = totalpriceofAll - (count2 * 100)) + " SR");
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count2 * 100)) + " SR");
            Orders.getItems().remove(Pinstack);
        });
       // mascara
        mascarminus.setOnAction(e -> {
            if (count4 >= 2) {// int
                count4 = count4 - 1;
                // lebel contain the int up value if bread
                masccount.setText("" + count4);
                // dont add
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 80) + " SR");
            }
        });
        mascarplus.setOnAction(e -> {
            count4 = count4 + 1;

            masccount.setText("" + count4);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 80) + " SR");
        });

        mascRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count4));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count4 * 80)) + " SR");
            Orders.getItems().remove(Mascstack);
        });
//        //gel
        galRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count5));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count5 * 50)) + " SR");
            Orders.getItems().remove(Gelstack);
        });

        galminus.setOnAction(e -> {
            if (count5 >= 2) {// int
                count5 = count5 - 1;
                // lebel contain the int up value if bread
                galcount.setText("" + count5);
                // dont add
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 50) + " SR");
            }
        });
        galplus.setOnAction(e -> {
            count5 = count5 + 1;

            galcount.setText("" + count5);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 50) + " SR");
        });
//        //lashes
        lashRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count3));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count3 * 60)) + " SR");
            Orders.getItems().remove(Lashstack);
        });

        lashesminus.setOnAction(e -> {
            if (count3 >= 2) {// int
                count3 = count3 - 1;
                // lebel contain the int up value if bread
                lashescount.setText("" + count3);
                // dont add
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 60) + " SR");
            }
        });
        lashesplus.setOnAction(e -> {
            count3 = count3 + 1;

            lashescount.setText("" + count3);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 60) + " SR");
        });
        
        //ADD TO CART ACTOIN FOR EYES PRODUCT---------------
        addSadow.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(SHADOWstack)) {
                ProductToCart.add(SHADOWstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 300) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });


        addpen.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(Pinstack)) {
                ProductToCart.add(Pinstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll = totalpriceofAll + 100) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //ADD MASCARA
        addmascara.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(Mascstack)) {
                ProductToCart.add(Mascstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 80) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //GEL
        addgel.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(Gelstack)) {
                ProductToCart.add(Gelstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 50) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
         //ADD LASHES
        addlash.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(Lashstack)) {
                ProductToCart.add(Lashstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 60) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //
        //liner
        linerminus.setOnAction(e -> {
            if (count1wine >= 2) {// int
                count1wine = count1wine - 1;
                // lebel contain the int up value if bread
                leballinercount.setText("" + count1wine);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 133) + " SR");
            }
        });
        linerplus.setOnAction(e -> {
            count1wine = count1wine + 1;

            leballinercount.setText("" + count1wine);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 133) + " SR");
        });
        linerRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count1wine));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count1wine * 133)) + " SR");
            Orders.getItems().remove(linerstack);
        });
        //stick
        stickminus.setOnAction(e -> {
            if (count2charry >= 2) {// int
                count2charry = count2charry - 1;
                // lebel contain the int up value if bread
                lebalstickcount.setText("" + count2charry);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 149) + " SR");
            }
        });
        stickplus.setOnAction(e -> {
            count2charry = count2charry + 1;

            lebalstickcount.setText("" + count2charry);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 149) + " SR");
        });
        stickRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count2charry));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count2charry * 149)) + " SR");
            Orders.getItems().remove(stickstack);
        });
        //gloss
        glossminus.setOnAction(e -> {
            if (count3delight >= 2) {// int
                count3delight = count3delight - 1;
                // lebel contain the int up value if bread
                lebalglosscount.setText("" + count3delight);
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll - 1));
                // lebal ncontain the first price up there
                totalprices.setText((totalpriceofAll = totalpriceofAll - 236) + " SR");
            }
        });
        glossplus.setOnAction(e -> {
            count3delight = count3delight + 1;

            lebalglosscount.setText("" + count3delight);
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
            totalprices.setText((totalpriceofAll = totalpriceofAll + 236) + " SR");
        });
        glossRemove.setOnAction(e -> {
            totalitems.setText("" + (totalitemsofAll = totalitemsofAll - count3delight));
            // remove usenig same way of + -
            totalprices.setText((totalpriceofAll = totalpriceofAll - (count3delight * 236)) + " SR");
            Orders.getItems().remove(glossstack);
        });

        //ADD TO CART ACTOIN
        addliner.setOnAction( e ->{
            // the ob list
            if (!ProductToCart.contains(linerstack)) {
                ProductToCart.add(linerstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 133) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //ADD stick
        addstick.setOnAction( e ->{
            // the ob list
            if (!ProductToCart.contains(stickstack)) {
                ProductToCart.add(stickstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 149) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //add gloss
       discountB.setStyle("-fx-color: #db798d;");
              discountB.setOnAction(event -> {
    String discountCode = discount.getText();
    int totalPriceWdis = totalpriceofAll; // Assuming totalpriceofAll is a double variable

    // Check the discount code and apply the corresponding discount
    if (discountCode.equalsIgnoreCase("HELLO25")) {
        totalPriceWdis =(int) (totalpriceofAll * 0.75); // Apply a 25% discount
    } else if (discountCode.equalsIgnoreCase("Score")) {
        totalPriceWdis= (int) (totalpriceofAll * 0.9); // Apply a 10% discount
    } else if (discountCode.equalsIgnoreCase("22FebV")) {
        totalPriceWdis =(int) (totalpriceofAll * 0.87);// Apply a 22% discount
    }

    // Update the total price label
    totalprices.setText(String.valueOf(totalPriceWdis));
});

        addgloss.setOnAction(event -> {
            // the ob list
            if (!ProductToCart.contains(glossstack)) {
                ProductToCart.add(glossstack);
                System.out.println("The button has been clicked!");
                totalitems.setText("" + (totalitemsofAll = totalitemsofAll + 1));
                //sitting thr numbrtvof total
                totalprices.setText((totalpriceofAll=totalpriceofAll + 236) + " SR");
            } else {
                System.out.println("The product has been added to the cart!");
            }
        });
        //bottom brder
        VBox bottom = new VBox();
        bottom.setStyle("-fx-border-color: #ffffff; -fx-background-color: #dbc5c4");
        bottom.setAlignment(Pos.CENTER);


        //lebels for transtion
        HBox HBBot09 = new HBox(10);

//----Home page----
//Home page Image
        ImageView homePageIc09 = new ImageView("https://mrkzgulfup.com/do.php?img=73585");
        homePageIc09.setFitHeight(80);
        homePageIc09.setFitWidth(80);

//Home Page Button
        Button hPBt09 = new Button();
        hPBt09.setGraphic(homePageIc09);
        hPBt09.setStyle("-fx-background-color: transparent");
        hPBt09.setOnAction(e->{stage.setScene(HPScene);  });
//----Catetoreies Page----
//Catetoreies Page Image
        ImageView categoryIc09 = new ImageView("https://mrkzgulfup.com/do.php?img=73589");
        categoryIc09.setFitHeight(80);
        categoryIc09.setFitWidth(80);

//Catetoreies Button
        Button catoBt09 = new Button();
        catoBt09.setGraphic(categoryIc09);
        catoBt09.setStyle("-fx-background-color: transparent");
        
        catoBt09.setOnAction(e->{stage.setScene(scene1);});

//----Cart Page----
//Cart Page Image
        ImageView cartIc09 = new ImageView("https://mrkzgulfup.com/do.php?img=73587");
        cartIc09.setFitHeight(80);
        cartIc09.setFitWidth(80);

//Cart Button
        Button cartBt09 = new Button();
        cartBt09.setGraphic(cartIc09);
        cartBt09.setStyle("-fx-background-color: transparent");

//----Brand Page----
//Brand Page Image
        ImageView brandIc09 = new ImageView("https://mrkzgulfup.com/do.php?img=73588");
        brandIc09.setFitHeight(80);
        brandIc09.setFitWidth(80);
//Brand Button
        Button brandBt09 = new Button();
        brandBt09.setGraphic(brandIc09);
        brandBt09.setStyle("-fx-background-color: transparent");
brandBt09.setOnAction(e->{           stage.setScene(sceneBr); });

//----Account Page----
//Account Page Image
        ImageView acontIc09 = new ImageView("https://mrkzgulfup.com/do.php?img=73586");
        acontIc09.setFitHeight(80);
        acontIc09.setFitWidth(80);

//Account Button
        Button acontBt09 = new Button();
        acontBt09.setGraphic(acontIc09);
        acontBt09.setStyle("-fx-background-color: transparent");
        acontBt09.setOnAction(e->{   stage.setScene(AcontScene);});
       
//-------Buttons Background-------
        ImageView icnBG09 = new ImageView("https://mrkzgulfup.com/do.php?img=73593");
        icnBG09.setFitHeight(100);
        icnBG09.setFitWidth(580);

        HBBot09.getChildren().addAll(hPBt09, catoBt09, cartBt09, brandBt09, acontBt09);
        HBBot09.setAlignment(Pos.BOTTOM_CENTER);

        StackPane stack09 = new StackPane(icnBG09, HBBot09);

        bottom.getChildren().addAll( order_p,stack09);

        //end

        BorderPane panecartV = new BorderPane();
        panecartV.setPadding(new Insets(5, 10, 10, 10));
        panecartV.setBottom(bottom);
        panecartV.setCenter(Orders);
        panecartV.setTop(topC);
        panecartV.setStyle("-fx-background-image: url('https://sweetmoneybee.com/wp-content/uploads/2022/01/pretty-pink-wallpaper-23-577x1024.png');" + "-fx-background-size: cover;" + "-fx-background-color: #dbc5c4; -fx-font: normal bold 20px 'Bell MT';");


        scene9 = new Scene(panecartV, 600, 750);
        stage.setResizable(false);
        
       //---------------------------------------------
        //---------------------------------------------
        
        //    **********  CATEGORY SCENE  **********
        
        //---------------------------------------------
        //---------------------------------------------
        BorderPane pane = new BorderPane();
        StackPane centerca1 = new StackPane();
        StackPane centerca2 = new StackPane();
        StackPane centerca3 = new StackPane();
        VBox mainCenter = new VBox();
        
       
        
        //setting label(top)
        //Logo
        HBox HBTopL04 = new HBox(50);
        ImageView logoImage04 = new ImageView("https://mrkzgulfup.com/do.php?img=73590");
        logoImage04.setFitHeight(150);
        logoImage04.setFitWidth(150);
        logoImage04.setTranslateY(5);

        //logo Background
        ImageView logoBGImage04 = new ImageView("https://mrkzgulfup.com/do.php?img=73584");
        logoBGImage04.setFitWidth(600);

        HBTopL04.getChildren().add(logoImage04);
        HBTopL04.setAlignment(Pos.CENTER);

        HBox HBTopLBg04 = new HBox();
        HBTopLBg04.getChildren().add(logoBGImage04);
        HBTopLBg04.setAlignment(Pos.TOP_CENTER);
        
        

        StackPane stackTop04 = new StackPane();
        stackTop04.getChildren().addAll(HBTopLBg04, HBTopL04);
       
       //setting categories(center)
       
       //face:
        Rectangle rec1 = new Rectangle();
        rec1.setWidth(370);
        rec1.setHeight(100);
        rec1.setArcWidth(30.0);
        rec1.setArcHeight(20.0);
        rec1.setFill(Color.rgb(255, 255, 255));
        
        Button b1 = new Button();
        b1.setBackground(null);
        ImageView face = new ImageView("https://mrkzgulfup.com/do.php?img=73683");
        face.setFitWidth(260);
        face.setFitHeight(140);
        b1.setGraphic(face);
        
        
        Text fText = new Text("Face Product");
        fText.setFont(Font.font("Georgia", FontWeight.NORMAL, 20));
        
        
        centerca1.setMargin(b1, new Insets(0, 260, 0, 0));
        centerca1.getChildren().addAll(rec1,b1,fText);
        
       //lips:
        Rectangle rec2 = new Rectangle();
        rec2.setWidth(370);
        rec2.setHeight(100);
        rec2.setArcWidth(30.0);
        rec2.setArcHeight(20.0);
        rec2.setFill(Color.rgb(255, 255, 255));
        
        Button b2 = new Button();
        b2.setBackground(null);
        ImageView lips = new ImageView("https://mrkzgulfup.com/do.php?img=73681");
        lips.setFitWidth(260);
        lips.setFitHeight(140);
        b2.setGraphic(lips);
        
        
        
        Text lCText = new Text("Lips Product");
        lCText.setFont(Font.font("Georgia", FontWeight.NORMAL, 20));
        
        centerca2.setMargin(b2, new Insets(0, 260, 0, 0));
        centerca2.getChildren().addAll(rec2,b2,lCText);
        
        //eyes:
        Rectangle rec3 = new Rectangle();
        rec3.setWidth(370);
        rec3.setHeight(100);
        rec3.setArcWidth(30.0);
        rec3.setArcHeight(20.0);
        rec3.setFill(Color.rgb(255, 255, 255));
        
        Button b3 = new Button();
        b3.setBackground(null);
        ImageView eyes = new ImageView("https://mrkzgulfup.com/do.php?img=73682");
        eyes.setFitWidth(260);
        eyes.setFitHeight(140);
        b3.setGraphic(eyes);
        
        Text eText = new Text("Eyes Product");
        eText.setFont(Font.font("Georgia", FontWeight.NORMAL, 20));
        
        centerca3.setMargin(b3, new Insets(0, 260, 0, 0));
        centerca3.setMargin(eText, new Insets(0, 0, 0, 0));
        centerca3.getChildren().addAll(rec3,b3,eText);
        
        //----------SETTING ACTION OF THE CATEGORIES BUTTONS-----------
        
//        action for the FACE category
         b1.setOnAction(e->{
            stage.setScene(scene4);
        });
        
//        action for the LIPS category
         b2.setOnAction(e->{
            stage.setScene(scene);
        });
         
        //action for the EYES category
         b3.setOnAction(e->{
            stage.setScene(scene2);
        });
        
         HBox HBBot04 = new HBox(20);

//----Home page----
//Home page Image
        ImageView homePageIc04 = new ImageView("https://mrkzgulfup.com/do.php?img=73585");
        homePageIc04.setFitHeight(85);
        homePageIc04.setFitWidth(85);

//Home Page Button
        Button hPBt04 = new Button();
        hPBt04.setGraphic(homePageIc04);
        hPBt04.setStyle("-fx-background-color: transparent");

        hPBt04.setOnAction(e->{stage.setScene(HPScene);  });

//----Catetoreies Page----
//Catetoreies Page Image
        ImageView categoryIc04 = new ImageView("https://mrkzgulfup.com/do.php?img=73589");
        categoryIc04.setFitHeight(85);
        categoryIc04.setFitWidth(85);

//Catetoreies Button
        Button catoBt04 = new Button();
        catoBt04.setGraphic(categoryIc04);
        catoBt04.setStyle("-fx-background-color: transparent");

//----Cart Page----
//Cart Page Image
        ImageView cartIc04 = new ImageView("https://mrkzgulfup.com/do.php?img=73587");
        cartIc04.setFitHeight(85);
        cartIc04.setFitWidth(85);

//Cart Button
        Button cartBt04 = new Button();
        cartBt04.setGraphic(cartIc04);
        cartBt04.setStyle("-fx-background-color: transparent");
        
        //CART ACTION IS DONE
        cartBt04.setOnAction(e->{stage.setScene(scene9);});

//----Brand Page----
//Brand Page Image
        ImageView brandIc04 = new ImageView("https://mrkzgulfup.com/do.php?img=73588");
        brandIc04.setFitHeight(85);
        brandIc04.setFitWidth(85);

//Brand Button
        Button brandBt04 = new Button();
        brandBt04.setGraphic(brandIc04);
        brandBt04.setStyle("-fx-background-color: transparent");
        brandBt04.setOnAction(e->{           stage.setScene(sceneBr); });
      

//----Account Page----
//Account Page Image
        ImageView acontIc04 = new ImageView("https://mrkzgulfup.com/do.php?img=73586");
        acontIc04.setFitHeight(85);
        acontIc04.setFitWidth(85);

//Account Button
        Button acontBt04 = new Button();
        acontBt04.setGraphic(acontIc04);
        acontBt04.setStyle("-fx-background-color: transparent");
        acontBt04.setOnAction(e->{   stage.setScene(AcontScene);});
       
//-------Buttons Background-------
        ImageView icnBG04 = new ImageView("https://mrkzgulfup.com/do.php?img=73593");
        icnBG04.setFitHeight(120);
        icnBG04.setFitWidth(600);

        HBBot04.getChildren().addAll(hPBt04, catoBt04, cartBt04, brandBt04, acontBt04);
        HBBot04.setAlignment(Pos.BOTTOM_CENTER);

        StackPane stack04 = new StackPane(icnBG04, HBBot04);
        
        
        //set the main center position and get the children
        mainCenter.setMargin(centerca1, new Insets(50, 0, 0, 0));
        mainCenter.getChildren().addAll(centerca1,centerca2,centerca3);
        
        //set the scene 
        scene1 = new Scene(pane, 600, 750);
        //------SET THE BACK TO THE CATEGORY SCENE--------
        back003.setOnAction(e->{stage.setScene(scene1);});//FROM FACE TO CATEGORY
        back002.setOnAction(e->{stage.setScene(scene1);});//FROM LIPS TO CATEGORY
        back001.setOnAction(e->{stage.setScene(scene1);});//FROM EYES TO CATEGORY
        pane.setTop(stackTop04);
        pane.setCenter(mainCenter);
        pane.setBottom(stack04);
        pane.setStyle("-fx-background-color: #FDF8F8");
        //stage.setScene(scene1);
        /////////////////////////////////////////////
     
//_____________________________________
//-------------Shipping info----------
//_____________________________________


StackPane shRevStack=new StackPane();

 Shscene = new Scene(shRevStack, 600, 750);
    Confirmation.setOnAction(e->{        stage.setScene(Shscene);
     Session session3 = HibernateUtil.getSessionFactory().openSession();

cart insert2 =
    new cart("987",NametextTFS.getText(),totalitems.getText(),totalprices.getText());
   
        Transaction tx2 = session3.beginTransaction();
    session3 = HibernateUtil.getSessionFactory().openSession();

    tx2 = session3.beginTransaction();
    session3.save(insert2);
     tx2.commit();
     session3.close();

});    

ImageView shRevrs= new ImageView("https://mrkzgulfup.com/do.php?img=73591");
shRevrs.setFitHeight(65); 
shRevrs.setFitWidth(65);
Button shRevrsBt=new Button();
shRevrsBt.setGraphic(shRevrs);
shRevrsBt.setStyle("-fx-background-color: transparent");

shRevrsBt.setTranslateX(-250);
shRevrsBt.setTranslateY(-280);

shRevrsBt.setOnAction(e->{
               stage.setScene(scene9);

});  



ImageView logoShip=new ImageView("https://mrkzgulfup.com/do.php?img=73590");
logoShip.setFitHeight(150); 
logoShip.setFitWidth(150);
logoShip.setTranslateY(-20);


ImageView logoSBGImage=new ImageView("https://mrkzgulfup.com/do.php?img=73584");
logoSBGImage.setFitWidth(600); 


Text ShippingInfo=new Text("  Shipping\ninformation");
ShippingInfo.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 30));
ShippingInfo.setFill(titleCP);
ShippingInfo.setStyle("-fx-alignment: CENTER ;");

Text contactSh=new Text("Contact");
contactSh.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 23));
contactSh.setFill(headersCB);
contactSh.setStyle(" -fx-alignment: CENTER ;");
        
Tooltip tooltip = new Tooltip("Required field");
   
        
TextField tfContact = new TextField(); 
Label contactLb = new Label("Email or phone number:",tfContact); 
contactLb.setContentDisplay(ContentDisplay.BOTTOM);
tfContact.setTooltip(tooltip);
contactLb.setStyle("-fx-text-inner-color: #F29393;-fx-alignment: CENTER ; ");

TextField tfFullName = new TextField();
Label FullNameLb=new Label("Full Name:",tfFullName);
FullNameLb.setContentDisplay(ContentDisplay.BOTTOM);
tfFullName.setTooltip(tooltip);;
FullNameLb.setStyle("-fx-text-inner-color: #F29393;-fx-alignment: CENTER ; ");

CheckBox notiCB = new CheckBox("Get notification");
notiCB.setStyle("-fx-text-color: #393646; -fx-text-alignment: CENTER ;");

//-----------------------------
Text Shipping=new Text("Shipping");
Shipping.setFill(headersCB);
Shipping.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 23));
Shipping.setStyle("-fx-alignment: CENTER ;");


TextField tfCity = new TextField(); 
Label cityLb=new Label("City:",tfCity);
cityLb.setContentDisplay(ContentDisplay.BOTTOM);
cityLb.setStyle("-fx-text-inner-color: #F29393; ");
tfCity.setTooltip(tooltip);;

TextField tfStreet = new TextField(); 
Label streetLb=new Label("Street:",tfStreet);
streetLb.setContentDisplay(ContentDisplay.BOTTOM);
streetLb.setStyle("-fx-text-inner-color: #F29393;-fx-alignment: CENTER ; ");
tfStreet.setTooltip(tooltip);;

TextField tfZipCode = new TextField(); 
Label ZipCodeLb=new Label("ZIP COde:",tfZipCode);
ZipCodeLb.setContentDisplay(ContentDisplay.BOTTOM);
tfZipCode.setTooltip(tooltip);
ZipCodeLb.setStyle("-fx-text-inner-color: #F29393;-fx-alignment: CENTER ; ");

Button saveBut = new Button("    Save    ");
saveBut.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");

VBox ShippingPane=new VBox(7);
ShippingPane.getChildren().addAll(logoSBGImage,logoShip,ShippingInfo,contactSh,FullNameLb,contactLb,
        notiCB,Shipping,cityLb,streetLb,ZipCodeLb,saveBut);
ShippingPane.setAlignment(Pos.TOP_CENTER);

shRevStack.getChildren().addAll(ShippingPane,shRevrsBt);


        
        
 //______________________________________      
 //-------------PAYMENT PAGE-------------
 //______________________________________   
StackPane pyRevStack=new StackPane();
BorderPane panePay = new BorderPane();
Scene Payscene = new Scene(pyRevStack, 600, 750);

saveBut.setOnAction(e->{
    
     if(!tfContact.getText().isEmpty()
             &&!tfFullName.getText().isEmpty()
             &&!tfCity.getText().isEmpty()  
             &&!tfStreet.getText().isEmpty() 
             &&!tfZipCode.getText().isEmpty()){
        
             stage.setScene(Payscene);
     }
     
     if(tfContact.getText().isEmpty()){
         tfContact.setPromptText("This Field is Required");
     }
     if(tfFullName.getText().isEmpty()){
         tfFullName.setPromptText("This Field is Required");
     }
     if(tfCity.getText().isEmpty()){
         tfCity.setPromptText("This Field is Required");
     }
     if(tfStreet.getText().isEmpty()){
         tfStreet.setPromptText("This Field is Required");
     }
     
     if(tfZipCode.getText().isEmpty()|| !tfZipCode.getText().matches("\\d{3}")){
        if(tfZipCode.getText().isEmpty()) {
         tfZipCode.setPromptText("This Field is Required");
        }
        else{
            tfZipCode.clear();
             tfZipCode.setPromptText("It must be integer");  
        }
         
     }
     
   
       });
        




        ////The beganing of the next scene
        VBox Payroot = new VBox(100);
        Payroot.setPadding(new Insets(35));
        VBox Payinfo = new VBox(15);
        VBox Paytext = new VBox(20);
        HBox Payimg1 = new HBox(10);
        HBox Payimg2 = new HBox(10);
        HBox Payimg3 = new HBox(10);

        ImageView pyRevrs= new ImageView("https://mrkzgulfup.com/do.php?img=73591");
        pyRevrs.setFitHeight(65); 
        pyRevrs.setFitWidth(65);
        Button pyRevrsBt=new Button();
        pyRevrsBt.setGraphic(pyRevrs);
        pyRevrsBt.setStyle("-fx-background-color: transparent");

        pyRevrsBt.setTranslateX(-250);
        pyRevrsBt.setTranslateY(-280);
 
        pyRevrsBt.setOnAction(e->{
        
        stage.setScene(Shscene);
        });

       
        
        Text PText = new Text("\nPayment Method");
        PText.setFont(Font.font("Georgia", FontWeight.BOLD, 30));
        ImageView Paylogo = new ImageView("https://mrkzgulfup.com/do.php?img=70056");
        Paylogo.setFitWidth(135);
        Paylogo.setFitHeight(135);
        HBox PaylogoHB=new HBox();
        PaylogoHB.setAlignment(Pos.CENTER);
        PaylogoHB.getChildren().add(Paylogo);
        
        ImageView a = new ImageView("https://mrkzgulfup.com/do.php?img=68116");
        a.setFitWidth(25);
        a.setFitHeight(25);
        ImageView b = new ImageView("https://mrkzgulfup.com/do.php?img=68115");
        b.setFitWidth(25);
        b.setFitHeight(25);
        ImageView c = new ImageView("https://mrkzgulfup.com/do.php?img=68118");
        c.setFitWidth(35);
        c.setFitHeight(25);
        ImageView d = new ImageView("https://mrkzgulfup.com/do.php?img=68117");
        d.setFitWidth(25);
        d.setFitHeight(25);
        ImageView f = new ImageView("https://mrkzgulfup.com/do.php?img=68114");
        f.setFitWidth(25);
        f.setFitHeight(25);

        CardButton = new RadioButton("Card");
        CardButton.setAlignment(Pos.CENTER);
        applePayButton = new RadioButton("Apple Pay");
        applePayButton.setAlignment(Pos.CENTER);
        CashButton = new RadioButton("Cash");
        CashButton.setAlignment(Pos.CENTER);
        ToggleGroup paymentGroup = new ToggleGroup();
        CardButton.setToggleGroup(paymentGroup);
        applePayButton.setToggleGroup(paymentGroup);
        CashButton.setToggleGroup(paymentGroup);

        Payimg1.getChildren().addAll(CardButton, a, b, c);
        Payimg1.setAlignment(Pos.CENTER);
        Payimg2.getChildren().addAll(applePayButton, d);
        Payimg2.setAlignment(Pos.CENTER);
        Payimg3.getChildren().addAll(CashButton, f);
        Payimg3.setAlignment(Pos.CENTER);
        
        cardNumber = new TextField();
        cardNumber.setMinWidth(250);
        cardNumber.setMaxWidth(250);
        cardNumber.setPromptText("Card number");
        cardNumber.setStyle("-fx-prompt-text-fill: #DB798D");

        expiryDate = new TextField();
        expiryDate.setMinWidth(250);
        expiryDate.setMaxWidth(250);
        expiryDate.setPromptText("Expiration date");
        expiryDate.setStyle("-fx-prompt-text-fill: #DB798D");

        cardHolder = new TextField();
        cardHolder.setMinWidth(250);
        cardHolder.setMaxWidth(250);
        cardHolder.setPromptText("Card holder");
        cardHolder.setStyle("-fx-prompt-text-fill: #DB798D");

        cvv = new TextField();
        cvv.setMinWidth(250);
        cvv.setMaxWidth(250);
        cvv.setPromptText("CVV");
        cvv.setStyle("-fx-prompt-text-fill: #DB798D");

        Label Paylblmsg = new Label();
        Paylblmsg.setStyle("-fx-text-fill: #BE4F63");
        Paylblmsg.setFont(new Font(13.0));
        Paylblmsg.setAlignment(Pos.CENTER);

        // set  the textField as invisible
        setFieldsVisibility(false);

        paymentGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == CardButton) {
                setFieldsVisibility(true);
            } else {
                setFieldsVisibility(false);
            }
        });

        Button submitButton = new Button("Submit");
        submitButton.setStyle("    -fx-background-color:#FEE0DF; -fx-alignment: CENTER ; -fx-text-color:#393646; ");

        Paytext.getChildren().addAll(cardNumber, expiryDate, cardHolder, cvv, Paylblmsg, submitButton);
        Paytext.setAlignment(Pos.CENTER);
        Payinfo.getChildren().addAll(Payimg1, Payimg2, Payimg3, Paytext);
        Payinfo.setAlignment(Pos.CENTER);
        Payroot.getChildren().addAll(PText, Payinfo);
        Payroot.setAlignment(Pos.TOP_CENTER);
        panePay.setTop(PaylogoHB);
        panePay.setCenter(Payroot);
        panePay.setStyle("-fx-background-color: #FCF0F0");
        pyRevStack.getChildren().addAll(panePay,pyRevrsBt);

       //_____________________________________
       //------------END PAYMENT PAGE---------
       //_____________________________________
       
       
       
       //_____________________________________
       //------------ LAST PAGE------------
       //_____________________________________
       BorderPane Bor = new BorderPane();     

       Scene LAscene = new Scene(Bor,600,750);
       Color cLa = Color.web("EDD5D5",1.0);
       LAscene.setFill(cLa);

         
       //////////////////////////////
       
       
       
       
       
       
          VBox LaCenterV = new VBox();
Color bn = Color.web("4C3A5E",1.0);
   
ImageView imageViewLa = new ImageView(new Image("https://uxwing.com/wp-content/themes/uxwing/download/checkmark-cross/success-green-check-mark-icon.png"));
imageViewLa.setFitHeight(120); 
imageViewLa.setFitWidth(120);
imageViewLa.setTranslateX(250);
imageViewLa.setTranslateY(10);
LaCenterV.getChildren().addAll(imageViewLa); 
        
ImageView imageView2La = new ImageView(new Image("https://www.basicinvite.com/media/wysiwyg/2022/BI/Homepage/congrats_heading_mobile.png"));
imageView2La.setFitHeight(150); 
imageView2La.setFitWidth(520);
imageView2La.setTranslateX(50);
imageView2La.setTranslateY(-10);
LaCenterV.getChildren().addAll(imageView2La); 
                
Text textLA = new Text();
textLA.setText("YOUR ORDER HAS BEEN COMPLETED SUCCESSFULLY"); 
textLA.setFont(Font.font("Georgia",FontPosture.REGULAR ,17)); 
textLA.setFill(Color.BLACK);
textLA.setTranslateX(85); 
textLA.setTranslateY(-2); 
LaCenterV.getChildren().addAll(textLA);        
        
   
Rectangle rectangleLa = new Rectangle();
rectangleLa.setWidth(700); 
rectangleLa.setHeight(200);
Color bLa = Color.web("DB798E",1.0);
rectangleLa.setFill(bLa);
rectangleLa.setTranslateY(20); 
LaCenterV.getChildren().addAll(rectangleLa);

Text text3La = new Text();
text3La.setText("GET 25% OFF YOUR NEXT ORDER"); 
text3La.setFont(Font.font("Time New Roman",FontPosture.REGULAR, 23)); 
text3La.setFill(bn);//Setting the color 
text3La.setStrokeWidth(1);//setting the Stork
text3La.setStroke(Color.BLACK);//Setting the stroke color 
text3La.setTranslateX(120); 
text3La.setTranslateY(-150); 
LaCenterV.getChildren().addAll(text3La); 

Rectangle rectangle2La = new Rectangle();
rectangle2La.setWidth(165); 
rectangle2La.setHeight(80);
Color dLa = Color.web("EEA19F",1.0);
rectangle2La.setFill(dLa);
rectangle2La.setTranslateX(210); 
rectangle2La.setTranslateY(-120);
LaCenterV.getChildren().addAll(rectangle2La);
  
Text text4La = new Text();
text4La.setText("HELLO25"); 
text4La.setFont(Font.font("Time New Roman",FontPosture.REGULAR, 25)); 
text4La.setFill(Color.BLACK);//Setting the color 
text4La.setStrokeWidth(1);//setting the Stork
text4La.setStroke(Color.BLACK);//Setting the stroke color 
text4La.setTranslateX(240); 
text4La.setTranslateY(-180); 
LaCenterV.getChildren().addAll(text4La); 


ImageView imageView3La = new ImageView(new Image("https://png.pngtree.com/png-vector/20230423/ourmid/pngtree-powder-tube-lipstick-cartoon-lipstick-png-image_6718764.png"));
imageView3La.setFitHeight(195); 
imageView3La.setFitWidth(265);
imageView3La.setTranslateX(240);
imageView3La.setTranslateY(-290);
LaCenterV.getChildren().addAll(imageView3La); 

Text text5La = new Text();
text5La.setText("THANK YOU FOR YOUR SUPPORT"); 
text5La.setFont(Font.font("Georgia",FontPosture.ITALIC ,20)); 
text5La.setFill(Color.BLACK);
text5La.setTranslateX(140); 
text5La.setTranslateY(-290); 
LaCenterV.getChildren().addAll(text5La);    
Text textRandom = new Text();
textRandom.setText("ORDER NUMBER :");
textRandom.setFont(Font.font("Georgia",FontPosture.REGULAR, 18)); 
textRandom.setTranslateX(195); 
textRandom.setTranslateY(-280);






























ImageView ImageLa3=new ImageView("https://cdn0.iconfinder.com/data/icons/modern-ui-glyph-1/64/modern-ui-glyph-1-03-512.png"); 
ImageLa3.setFitWidth(25);
ImageLa3.setFitHeight(25);
Button BackHome = new Button("BACK TO HOMEPAGE",ImageLa3);
BackHome.setTranslateY(-267);
BackHome.setTranslateX(175);
BackHome.setPrefWidth(250);
BackHome.setPrefHeight(200);
BackHome.setStyle("-fx-background-color: #EEA19F; -fx-font-size: 17px;");
//BackHome.setStyle("-fx-font-size: 17px;");
LaCenterV.getChildren().addAll(BackHome);

Text text7La = new Text();
text7La.setText("IF YOU DIDN'T CREATE AN ACCOUNT USING THIS EMAIL ADDRESS, PLEASE IGNORE THIS EMAIL OR UNSUSBSCRIRE. "); 
text7La.setFont(Font.font("Time New Roman",FontPosture.REGULAR, 11)); 
text7La.setFill(bn);//Setting the color 
text7La.setTranslateX(15); 
text7La.setTranslateY(-200);
LaCenterV.getChildren().addAll(text7La);   
BackHome.setOnAction(e->{
             stage.setScene(HPScene);


});

Bor.setCenter(LaCenterV);     

      
        
        
        ///////////////////////////////////////////
 
 
 

               submitButton.setOnAction(e -> {
            if (CardButton.isSelected()) {
                if (cardNumber.getText().equals("") || expiryDate.getText().equals("") || cardHolder.getText().equals("") || cvv.getText().equals("")) {
                    Paylblmsg.setText("Enter the required fields");
                } else if (!cardNumber.getText().matches("\\d{18}")) {
                    Paylblmsg.setText("Card number holds only 18 digit.");
                } else if (!expiryDate.getText().matches("^\\d{2}" + "/" + "\\d{2}")) {
                    Paylblmsg.setText("Expiration date holds only card expiry date\n in the form 00/00.");
                } else if (cardHolder.getText().matches("^\\d+$")) {
                    Paylblmsg.setText("Card holder holds only the name of the card holder.");
                } else if (!cvv.getText().matches("\\d{3}")) {
                    Paylblmsg.setText("CVV holds only 3 numbers.");
                } else {
                    stage.setScene(LAscene);  
         
                    submitting();
            System.out.print("Order saving");
            String cardNumber1=cardNumber.getText().toString();
            String expiryDate1=expiryDate.getText().toString();
            String cardHolder1=cardHolder.getText().toString();
            String cvv1=cvv.getText().toString();
            
            card userPayinf=new card();
            
            userPayinf.setCardNumber(cardNumber1);
            userPayinf.setCardDate(expiryDate1);
            userPayinf.setCcv(cvv1);
            userPayinf.setCardHolderName(cardHolder1);
            
                    
             Session session = HibernateUtil.getSessionFactory().openSession();
               Transaction txop = session.beginTransaction();
 
 
                //insert new student
                session = HibernateUtil.getSessionFactory().openSession();

                txop = session.beginTransaction();
                session.save(userPayinf);
                txop.commit();
                session.close();


String orderContactNum=tfContact.getText();

String userOrderName=(tfFullName.getText());

String userStreet=new String (tfStreet.getText().toString());
String userCity= new String (tfCity.getText().toString());
String userZipCode=new String (tfZipCode.getText().toString());


                   Date orderDate = new Date();
                   String orderDateS=orderDate.toString();
                                   
               Session session1 = HibernateUtil.getSessionFactory().openSession();
               Transaction txop1 = session1.beginTransaction();
               orders userO1=new orders();
               System.err.println("\n\n Order here \n\n");

                  userO1.setOrder_date(orderDateS);
                    userO1.setCity(userCity);
                    userO1.setStreet(userStreet);
                    userO1.setZip_code(userZipCode);
                    userO1.setUser_id(userOrderName);
                    userO1.setTotal_price(totalprices+"");
                    userO1.setContact_user(orderContactNum);
                    int OrderNumLPP=userO1.getOrder_number();

                 
                session1.save(userO1);
                txop1.commit();
                session1.close();
                    
                
                    
 //retrive student list
 Session sessionOR = HibernateUtil.getSessionFactory().openSession();
 Transaction txor = sessionOR.beginTransaction();

 sessionOR = HibernateUtil.getSessionFactory().openSession();
 List<orders> oList = null;
 String queryStr = "from orders";
 Query query = sessionOR.createQuery(queryStr);
 oList = query.list();
 sessionOR.close();
 
 for(orders s: oList)
    
 {
      ordnumDB=s.getOrder_number();
        orderPrice.getChildren().addAll(new Label(totalprices.getText().toString()+""));
    orderNum.getChildren().addAll(new Label ( "VEL"+ordnumDB+""));
 }


Label randomNumberLabel = new Label();


randomNumberLabel.setText("VEL" +       ordnumDB);
randomNumberLabel.setFont(Font.font("Bell MT",FontPosture.REGULAR, 24)); 
randomNumberLabel.setTranslateX(220); 
randomNumberLabel.setTranslateY(-270);
LaCenterV.getChildren().addAll(textRandom,randomNumberLabel);


                }
//////////////////////////////////////////////////////////////
            }else if (applePayButton.isSelected()) {
                submitting();
                stage.setScene(LAscene);
                
            

String orderContactNum=tfContact.getText();

String userOrderName=(tfFullName.getText());

String userStreet=new String (tfStreet.getText().toString());
String userCity= new String (tfCity.getText().toString());

String userZipCode=new String (tfZipCode.getText().toString());


                   Date orderDate = new Date();
                   String orderDateS=orderDate.toString();
                                   
               Session session1 = HibernateUtil.getSessionFactory().openSession();
               Transaction txop1 = session1.beginTransaction();
               orders userO1=new orders();
               System.err.println("\n\n Order here \n\n");

                  userO1.setOrder_date(orderDateS);
                    userO1.setCity(userCity);
                    userO1.setStreet(userStreet);
                    userO1.setZip_code(userZipCode);
                    userO1.setUser_id(userOrderName);
                    userO1.setTotal_price(totalprices+"");
                    userO1.setContact_user(orderContactNum);
                  int OrderNumLPP=userO1.getOrder_number();

                session1.save(userO1);
                txop1.commit();
                session1.close();
                    
 //retrive student list
 Session sessionOR = HibernateUtil.getSessionFactory().openSession();
 Transaction txor = sessionOR.beginTransaction();

 sessionOR = HibernateUtil.getSessionFactory().openSession();
 List<orders> oList = null;
 String queryStr = "from orders";
 Query query = sessionOR.createQuery(queryStr);
 oList = query.list();
 sessionOR.close();
 
 for(orders s: oList)
    
 {
      ordnumDB=s.getOrder_number();
      orderPrice.getChildren().addAll(new Label(totalprices.getText().toString()));
    orderNum.getChildren().addAll(new Label ( "VEL"+ordnumDB+""));
    
Label randomNumberLabel = new Label();

randomNumberLabel.setText("VEL" +       ordnumDB);
randomNumberLabel.setFont(Font.font("Bell MT",FontPosture.REGULAR, 24)); 
randomNumberLabel.setTranslateX(220); 
randomNumberLabel.setTranslateY(-270);
LaCenterV.getChildren().addAll(textRandom,randomNumberLabel);


 }


                    
      }
            //////////////////////////////////
            
            else if(CashButton.isSelected()){
                 submitting();
                 
                stage.setScene(LAscene);  
         
            System.out.print("Order saving");
          
String orderContactNum=tfContact.getText();

String userOrderName=(tfFullName.getText());

String userStreet=new String (tfStreet.getText().toString());
String userCity=  new String (tfCity.getText().toString());

String userZipCode=new String (tfZipCode.getText().toString());


                   Date orderDate = new Date();
                   String orderDateS=orderDate.toString();
                                   
               Session session1 = HibernateUtil.getSessionFactory().openSession();
               Transaction txop1 = session1.beginTransaction();
               orders userO1=new orders();
               System.err.println("\n\n Order here \n\n");

                  userO1.setOrder_date(orderDateS);
                    userO1.setCity(userCity);
                    userO1.setStreet(userStreet);
                    userO1.setZip_code(userZipCode);
                    userO1.setUser_id(userOrderName);
                    userO1.setTotal_price(totalprices+"");
                    userO1.setContact_user(orderContactNum);
                    

    
                session1.save(userO1);
                txop1.commit();
                session1.close();
                    
                
                
 //retrive student list
 Session sessionOR = HibernateUtil.getSessionFactory().openSession();
 Transaction txor = sessionOR.beginTransaction();

 sessionOR = HibernateUtil.getSessionFactory().openSession();
 List<orders> oList = null;
 String queryStr = "from orders";
 Query query = sessionOR.createQuery(queryStr);
 oList = query.list();
 sessionOR.close();
 
 for(orders s: oList)
    
 {
           ordnumDB=s.getOrder_number();

     orderPrice.getChildren().addAll(new Label(totalprices.getText().toString()));
    orderNum.getChildren().addAll(new Label ( "VEL"+ordnumDB+""));
    
    
Label randomNumberLabel = new Label();

 
randomNumberLabel.setText("VEL" +       ordnumDB);
randomNumberLabel.setFont(Font.font("Bell MT",FontPosture.REGULAR, 24)); 
randomNumberLabel.setTranslateX(220); 
randomNumberLabel.setTranslateY(-270);
LaCenterV.getChildren().addAll(textRandom,randomNumberLabel);


 }


                    
                
            }
                
                
        });
        
 
 
 
 
 
 
 




 
 
 
 
 
 ////______________________________________________
 ////______________________________________________
 ////---------------- COLORS PAGE----------------
 ////______________________________________________
 ////______________________________________________
   BorderPane BorC=new BorderPane();

  Scene sceneTry = new Scene(BorC, 600, 750);
      
 
 
colorBt.setOnAction(e->{
        stage.setScene(sceneTry);

});
  
       // InputStream imageStream = new FileInputStream("images/makeup.png");
        //Image backgroundImage = new Image(imageStream);
        Image backgroundImage = new Image("https://mrkzgulfup.com/do.php?img=73370");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(true); // Preserve the aspect ratio of the image
        backgroundImageView.setFitWidth(Double.MAX_VALUE); // Set the width to match its parent
        backgroundImageView.setFitHeight(330); // Set the height to 250
        redLabel = new Label("Red");
        greenLabel = new Label("Green");
        blueLabel = new Label("Blue");
        redScroller = new ScrollBar();
        greenScroller = new ScrollBar();
        blueScroller = new ScrollBar();
        selectedColorShape = new Rectangle();
        selectedColorShape1 = new Rectangle();
        selectedColorShape2 = new Rectangle();
        selectedColorLabel = new Label();
        redScroller.setBlockIncrement(1);
        redScroller.setMin(0);
        redScroller.setMax(255);
        redScroller.setValue(202);
        redScroller.setOrientation(Orientation.HORIZONTAL);
        greenScroller.setBlockIncrement(1);
        greenScroller.setMin(0);
        greenScroller.setMax(255);
        greenScroller.setValue(101);
        greenScroller.setOrientation(Orientation.HORIZONTAL);
        blueScroller.setBlockIncrement(1);
        blueScroller.setMin(0);
        blueScroller.setMax(255);
        blueScroller.setValue(128);
        blueScroller.setOrientation(Orientation.HORIZONTAL);

        selectedColorLabel.setText(getColorValue());
        redLabel.setPrefSize(60, 25);
        greenLabel.setPrefSize(60, 25);
        blueLabel.setPrefSize(60, 25);
        redScroller.setPrefSize(200, 25);
        greenScroller.setPrefSize(200, 25);
        blueScroller.setPrefSize(200, 25);
        selectedColorShape.setWidth(60);
        selectedColorShape.setHeight(20);
        selectedColorShape1.setWidth(60);
        selectedColorShape1.setHeight(20);
        selectedColorShape2.setWidth(60);
        selectedColorShape2.setHeight(20);
        selectedColorLabel.setPrefSize(145, 25);

        redLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        greenLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        blueLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        selectedColorLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: gray");
        redScroller.setStyle("-fx-background-color: red");
        greenScroller.setStyle("-fx-background-color: green");
        blueScroller.setStyle("-fx-background-color: blue");

        selectedColorShape.setFill(color);
        selectedColorShape.setTranslateY(-60);
        selectedColorShape1.setFill(color);
        selectedColorShape1.setTranslateY(-60);
        selectedColorShape2.setFill(color);
        selectedColorShape2.setTranslateY(-60);
        ChangeListener myListener = (ChangeListener) (ObservableValue observable, Object oldValue, Object newValue) -> {

            int red = (int) redScroller.getValue();
            int green = (int) greenScroller.getValue();
            int blue = (int) blueScroller.getValue();
            color = Color.rgb(red, green, blue, 1);
            selectedColorShape.setFill(color);
            selectedColorShape1.setFill(color);
            selectedColorShape2.setFill(color);
            selectedColorLabel.setText(getColorValue());

        };
        redScroller.valueProperty().addListener(myListener);
        greenScroller.valueProperty().addListener(myListener);
        blueScroller.valueProperty().addListener(myListener);

        // Create a VBox container to hold the label
        VBox vboxTry = new VBox();
        vboxTry.setAlignment(Pos.TOP_CENTER);
        
        Text texttry = new Text();
        texttry.setText("Choose the right color for your skin \n             we will make it for you"); 
        texttry.setFont(Font.font("Georgia",FontWeight.BOLD ,30)); 
        texttry.setFill(Color.BLACK);
        texttry.setStrokeWidth(2);
        texttry.setTranslateX(5); 
        texttry.setTranslateY(68);  
        vboxTry.getChildren().addAll(texttry);

        // label on teeth of girle
        HBox colorShapeContainer = new HBox();
        colorShapeContainer.setAlignment(Pos.TOP_CENTER);
        // Set margin to center the image vertically
        HBox.setMargin(selectedColorShape, new Insets(294+30, 10, 0, 60));
        HBox.setMargin(selectedColorShape1, new Insets(282+30, 10, 0, 65));
        HBox.setMargin(selectedColorShape2, new Insets(290+30, 10, 0, 90));
        // Add three selectedColorShape objects to the HBox
        colorShapeContainer.getChildren().addAll(selectedColorShape, selectedColorShape1, selectedColorShape2);
        //Button Node
        // Create submit button
        Button submitButtonTry = new Button("Submit");
        submitButtonTry.setPrefWidth(150);
        submitButtonTry.setOnAction(e -> {
            Alert alertTry = new Alert(Alert.AlertType.INFORMATION);
            alertTry.setTitle("New Request");
            alertTry.setHeaderText("Success!");
            alertTry.setContentText("We have received your order! We will prepare it as soon as possible and inform you");
            alertTry.getDialogPane().setStyle("-fx-background-color: #EEA19F;");
            alertTry.showAndWait();
        });

        // Create the GridPane and set its properties
        GridPane gridPaneTry = new GridPane();
        gridPaneTry.setHgap(10);
        gridPaneTry.setVgap(10);
        gridPaneTry.setAlignment(Pos.BOTTOM_CENTER);
        gridPaneTry.setPadding(new Insets(20));
        // Set margin from the top for the GridPane
        gridPaneTry.setMargin(gridPaneTry, new Insets(60, 0, 0, 0));

        gridPaneTry.add(redLabel, 0, 1);
        gridPaneTry.add(redScroller, 1, 1);
        gridPaneTry.add(greenLabel, 0, 2);
        gridPaneTry.add(greenScroller, 1, 2);
        gridPaneTry.add(blueLabel, 0, 3);
        gridPaneTry.add(blueScroller, 1, 3);
        gridPaneTry.add(submitButtonTry, 1, 6);
        StackPane stackPaneTry = new StackPane();

        stackPaneTry.getChildren().addAll(backgroundImageView, vboxTry, colorShapeContainer, gridPaneTry);
        stackPaneTry.setAlignment(backgroundImageView, javafx.geometry.Pos.CENTER);
        stackPaneTry.setTranslateY(-35);
        gridPaneTry.setTranslateY(45);
        

//--------------------------------------


//---------------BOTTOM------------------//
HBox HBBotTry=new HBox(20);

//----Home page----
//Home page Image
ImageView homePageIcTry=new ImageView("https://mrkzgulfup.com/do.php?img=74173");
homePageIcTry.setFitHeight(85); 
homePageIcTry.setFitWidth(85);

//Home Page Button
Button hPBtTry=new Button(); 
hPBtTry.setGraphic(homePageIcTry);
hPBtTry.setStyle("-fx-background-color: transparent");
hPBtTry.setOnAction(e->{
stage.setScene(HPScene);

});
//----Catetoreies Page----
//Catetoreies Page Image
ImageView categoryIcTry= new ImageView("https://mrkzgulfup.com/do.php?img=74172");
categoryIcTry.setFitHeight(85); 
categoryIcTry.setFitWidth(85);

//Catetoreies Button

Button catoBtTry=new Button(); 
catoBtTry.setGraphic(categoryIcTry );
catoBtTry.setStyle( "-fx-background-color: transparent");
catoBtTry.setOnAction(e->{stage.setScene(scene1);});

  

//----Cart Page----
//Cart Page Image

ImageView cartIcTry= new ImageView("https://mrkzgulfup.com/do.php?img=74171");
cartIcTry.setFitHeight(85); 
cartIcTry.setFitWidth(85);

//Cart Button

Button cartBtTry=new Button(); 
cartBtTry.setGraphic(cartIcTry );
cartBtTry.setStyle( "-fx-background-color: transparent");


//----Brand Page----
//Brand Page Image

ImageView brandIcTry= new ImageView("https://mrkzgulfup.com/do.php?img=74170");
brandIcTry.setFitHeight(85); 
brandIcTry.setFitWidth(85);

//Brand Button

Button brandBtTry=new Button(); 
brandBtTry.setGraphic(brandIcTry);
brandBtTry.setStyle( "-fx-background-color: transparent");

brandBtTry.setOnAction(e->{           stage.setScene(sceneBr); });


//----Account Page----
//Account Page Image

ImageView acontIcTry= new ImageView("https://mrkzgulfup.com/do.php?img=74169");
acontIcTry.setFitHeight(85); 
acontIcTry.setFitWidth(85);

//Account Button

Button acontBtTry=new Button(); 
acontBtTry.setGraphic(acontIcTry);
acontBtTry.setStyle( "-fx-background-color: transparent");


acontBtTry.setOnAction(e->{
   stage.setScene(AcontScene);
           }); 

//-------Buttons Background-------
ImageView icnBGTry= new ImageView("https://mrkzgulfup.com/do.php?img=74174");
icnBGTry.setFitHeight(120); 
icnBGTry.setFitWidth(600);
icnBGTry.setTranslateY(-5);
HBBotTry.getChildren().addAll(hPBtTry ,catoBtTry,cartBtTry,brandBtTry,acontBtTry);
HBBotTry.setAlignment(Pos.BOTTOM_CENTER);

StackPane stackTry2= new StackPane(icnBGTry,HBBotTry);

//-----set Buttons in the Bottom-----

BorC.setBottom(stackTry2);
BorC.setCenter(stackPaneTry);
stackTry2.setTranslateY(10); 
BorC.setStyle("-fx-background-color: #FDF8F8;");

  //--------------END COLORS------------------
  
  //________________________________________
  //------------SNAKE GAME------------------
  //_______________________________________
  
     try {
            newFood();
            BorderPane rootS = new BorderPane();

            VBox rootSnake = new VBox();
            Canvas cC = new Canvas(width * cornersize, height * cornersize);
            GraphicsContext gc = cC.getGraphicsContext2D();
            rootSnake.getChildren().add(cC);

      
   
            
            // Instruction text
            Label control = new Label("Control The Snake :\n");
            control.setTranslateY(-20); 
            control.setFont(Font.font("Georgia",FontWeight.BOLD,14));
            Label instructionLabel = new Label(" Move Up : Arrow Up ↑ \n Move Down : Arrow Down ↓ \n Move Left : Arrow Left ← \n Move Right : Arrow Right →");
            instructionLabel.setFont(Font.font("Georgia",13));
            instructionLabel.setTextFill(Color.BLACK);
            instructionLabel.setAlignment(Pos.TOP_CENTER);

            // Create the "startBtn" button to start game
            Button startBtn = new Button("Start");
            startBtn.setOnAction(e -> {
                snake.clear(); // Clear the snake
                snake.add(new Corner(width / 2, height / 2));
                snake.add(new Corner(width / 2, height / 2));
                snake.add(new Corner(width / 2, height / 2));
                gameOver = false;
                alertShown = false;
                totalScore = 0;
                speed = 1;
                direction = Dir.left;

            });
            VBox.setMargin(startBtn, new Insets(30, 0, 0, 0));
            startBtn.setPrefWidth(100);

            // Create the "Reset" button
            Button resetBtn = new Button("Reset");
            resetBtn.setOnAction(e -> {
                snake.clear(); // Clear the snake
                direction = Dir.left; // Reset the direction
                snake.add(new Corner(width / 2, height / 2));
                snake.add(new Corner(width / 2, height / 2));
                snake.add(new Corner(width / 2, height / 2));
                gameOver = false;
                alertShown = false;
                totalScore = 0;
                speed = 1;

            });
            VBox.setMargin(resetBtn, new Insets(20, 0, 0, 0));
            // Set preferred width for the button
            resetBtn.setPrefWidth(100);
            //ProductsScreen
            // Create the "New Request" button
            Button backBtn = new Button("Back to home");
            backBtn.setOnAction(e -> {
             stage.setScene(HPScene);

            });

        
            VBox.setMargin(backBtn, new Insets(20, 0, 0, 0));
            // Set preferred width for the button
            backBtn.setPrefWidth(100);
            VBox rightBox = new VBox();
            rightBox.setAlignment(Pos.CENTER);
            rightBox.setStyle("-fx-background-color: #EEA19F;");
            rightBox.getChildren().addAll(control,instructionLabel, startBtn, resetBtn, backBtn);

            // Set the content on the left side of the BorderPane
            rootS.setLeft(rootSnake);
            // Setthe right side of the BorderPane
            rootS.setRight(rightBox);

            new AnimationTimer() {
                long lastTick = 0;

                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }

                    if (now - lastTick > 1000000000 / speed) {
                        lastTick = now;
                        tick(gc);
                    }
                }

            }.start();

            Scene sceneSn = new Scene(rootS, 600, 700);

            // control
            sceneSn.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
                if (key.getCode() == KeyCode.UP) {
                    direction = Dir.up;
                }
                if (key.getCode() == KeyCode.LEFT) {
                    direction = Dir.left;
                }
                if (key.getCode() == KeyCode.DOWN) {
                    direction = Dir.down;
                }
                if (key.getCode() == KeyCode.RIGHT) {
                    direction = Dir.right;
                }

            });

            // add start snake parts
            snake.add(new Corner(width / 2, height / 2));
            snake.add(new Corner(width / 2, height / 2));
            snake.add(new Corner(width / 2, height / 2));
            // If you do not want to use css style, you can just delete the next line.
            // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            stage.setTitle("VelvetVixen");
             
         gameBt.setOnAction(e->{
        stage.setScene(sceneSn);
         });
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
     
  //---------------------------------------------
  //home page buttons//
  
cartBt.setOnAction(e->{   stage.setScene(scene9);});
catoBt.setOnAction(e->{   stage.setScene(scene1);});
/////////////////////////////

//Brand Page buttons
cartBrBt.setOnAction(e->{   stage.setScene(scene9);});
catoBrBt.setOnAction(e->{   stage.setScene(scene1);});

  /////////////////////////
  
  //account page
  
cartAcBt.setOnAction(e->{   stage.setScene(scene9);});
catoAcBt.setOnAction(e->{   stage.setScene(scene1);}); 
  
  /////////////
//account setting page buttons
cartAcSBt.setOnAction(e->{   stage.setScene(scene9);});
catoAcSBt.setOnAction(e->{   stage.setScene(scene1);}); 
//////////////
//account Order page buttons

cartAcOBt.setOnAction(e->{   stage.setScene(scene9);});
catoAcOBt.setOnAction(e->{   stage.setScene(scene1);}); 
//////
     
    stage.show();
    }
     public static void tick(GraphicsContext gc) {
        if (gameOver) {
            gc.setFill(Color.rgb(76, 58, 94));
            gc.setFont(new Font("Georgia", 50));
            gc.fillText("GAME OVER", 70, 300);
            return;
        }
        if (alertShown) {
            return;

        }

        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        switch (direction) {
            case up:
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    gameOver = true;
                }
                break;
            case down:
                snake.get(0).y++;
                if (snake.get(0).y > height) {
                    gameOver = true;
                }
                break;
            case left:
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    gameOver = true;
                }
                break;
            case right:
                snake.get(0).x++;
                if (snake.get(0).x > width) {
                    gameOver = true;
                }
                break;

        }

        // eat food
        if (foodX == snake.get(0).x && foodY == snake.get(0).y) {
            snake.add(new Corner(-1, -1));
            newFood();
            speed++;
        }

        // self destroy
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = true;
            }
        }

        // fill
        // background
        gc.setFill(Color.rgb(237, 213, 213));
        gc.fillRect(0, 0, width * cornersize, height * cornersize);

       gc.setFill(Color.BLACK);
       gc.setFont(new Font("Georgia", 30));
       gc.fillText("Score : " + (totalScore), 175, 30);
    
       

        // random foodcolor
        Color cc = Color.rgb(219, 121, 142);

        gc.setFill(cc);
        gc.fillOval(foodX * cornersize, foodY * cornersize, cornersize, cornersize);

        // snake
        for (Corner c : snake) {
            gc.setFill(Color.LIGHTGREEN);
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
            gc.setFill(Color.rgb(76, 58, 94));
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);

        }
        if (totalScore == 3 && !alertShown) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Score");
                 alert.getDialogPane().setStyle("-fx-background-color: #FDEEF4;");  
                alert.setHeaderText("Congrats! u can use a 10% discount code (Score) \nThanks for your time");
                alert.setContentText("Score is : " + totalScore);
                alert.showAndWait();
            });

            alertShown = true; // Set the flag to true to indicate the alert has been shown
        }

    }

    // food
    public static void newFood() {
        start:
        while (true) {
            foodX = rand.nextInt(width);
            foodY = rand.nextInt(height);

            for (Corner c : snake) {
                if (c.x == foodX && c.y == foodY) {
                    continue start;
                }
            }
            foodcolor = rand.nextInt(5);
            totalScore++;

            break;

        }
    }

 
    private void setFieldsVisibility(boolean visible) {
        cardNumber.setVisible(visible);
        expiryDate.setVisible(visible);
        cardHolder.setVisible(visible);
        cvv.setVisible(visible);
    }

    private void submitting() {
        if (CardButton.isSelected()) {
            System.out.println("Payment Method: " + CardButton.getText());
            System.out.println("Card Number: " + cardNumber.getText());
            System.out.println("Expiry Date: " + expiryDate.getText());
            System.out.println("Card Holder: " + cardHolder.getText());
            System.out.println("CVV: " + cvv.getText());
            System.out.println("\n Your payment was successful\n\n   ***THANK YOU FOR SHOPPING WITH US***");
        } else if (applePayButton.isSelected()) {
            System.out.println("Payment Method: " + applePayButton.getText());
            System.out.println("\n Your payment was successful\n\n   ***THANK YOU FOR SHOPPING WITH US***");
        } else if (CashButton.isSelected()) {
            System.out.println("Payment Method: " + CashButton.getText());
            System.out.println("\n Your payment was successful\n\n    ***THANK YOU FOR SHOPPING WITH US***");
        }

    
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}