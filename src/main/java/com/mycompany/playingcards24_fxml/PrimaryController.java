package com.mycompany.playingcards24_fxml;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author jonat
 */
public class PrimaryController {
    
    @FXML
    private TextField expTxtField;
    
    @FXML
    private ImageView imgView1;

    @FXML
    private ImageView imgView2;

    @FXML
    private ImageView imgView3;

    @FXML
    private ImageView imgView4;
    
    @FXML 
    private Image img1;
    
    @FXML 
    private Image img2;
    
    @FXML 
    private Image img3;
    
    @FXML 
    private Image img4;
    
    @FXML 
    private cardInfo card1;
    
    @FXML 
    private cardInfo card2;
    
    @FXML 
    private cardInfo card3;
    
    @FXML 
    private cardInfo card4;
    
    @FXML
    private TextField solutionTxtField;

    @FXML
    private Label timeLabel;
    
    @FXML
    private Timeline timeline;
    
    @FXML
    private int seconds;
    
    /**
    * this method will refresh the 4 images on the screen when the refresh button is pushed.
    * The method will also clear any text in the solution text field that may be left over from
    * previous attempts
    */
    @FXML
    void refreshImages(ActionEvent event) throws FileNotFoundException {
        //clearing text
        solutionTxtField.setText("");
        solutionTxtField.setEditable(false);
        
        //creates a timer that increments every 1000 milliseconds(1 second)
        // and updates the time used label with the seconds value until
        // the problem is solved, and will then stop 
        KeyFrame key = new KeyFrame(Duration.millis(1000), e -> {
         seconds++;
         timeLabel.setText("Time Used: " + seconds);
        });
        timeline = new Timeline(key);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        //create instance of the card info class 
        cardInfo cI = new cardInfo();
        cardInfo[] cardNames = cI.initializeArr();
        
        //each card is randomly assigned a string from the array in cardInfo, giving
        // each card a randomly selected image from resource folder
        int randNum1 = (int)(Math.random() * (cardNames.length));
        card1 = cardNames[randNum1];
        img1 = new Image(new FileInputStream("src/main/resources/png/"+card1.getCardName()));
        imgView1.setImage(img1); 
        
        //additional while loops make sure a card isnt reused 
        int randNum2 = (int)(Math.random() * (cardNames.length));
        while(randNum1 == randNum2)
        {
            randNum2 = (int)(Math.random() * (cardNames.length));
        }
        card2 = cardNames[randNum2];
        img2 = new Image(new FileInputStream("src/main/resources/png/"+card2.getCardName()));
        imgView2.setImage(img2);
        
        int randNum3 = (int)(Math.random() * (cardNames.length));
        while((randNum3 == randNum2) || (randNum3 == randNum1))
        {
            randNum3 = (int)(Math.random() * (cardNames.length));
        }
        card3 = cardNames[randNum3];
        img3 = new Image(new FileInputStream("src/main/resources/png/"+card3.getCardName()));
        imgView3.setImage(img3);
        
        int randNum4 = (int)(Math.random() * (cardNames.length));
        while((randNum4 == randNum2) || (randNum4 == randNum1) || (randNum4 == randNum3))
        {
            randNum4 = (int)(Math.random() * (cardNames.length));
        }
        card4 = cardNames[randNum4];
        img4 = new Image(new FileInputStream("src/main/resources/png/"+card4.getCardName()));
        imgView4.setImage(img4);
        
    }
    /**
     * when verify button is checked it calls the verify method to assure both 24 is achieved, and every number from 
     * the cards is used once and only once
     * @param event 
     */
    @FXML
    void verifyBtnAction(ActionEvent event) {
        
        //if statement creates an alert box based on solution result
        if(verify(expTxtField.getText()) == true)
        {
            Alert alertWin = new Alert(AlertType.INFORMATION);
            alertWin.setTitle("Attempt Result:");
            alertWin.setContentText("You have answered Correctly, good job!");
            alertWin.setHeaderText(null);
            timeline.stop();
            alertWin.showAndWait();
        } else{
            
            Alert alertLose = new Alert(AlertType.ERROR);
            alertLose.setTitle("Attempt Result:");
            alertLose.setContentText("You have answered Incorrectly, try again.");
            alertLose.setHeaderText("Incorrect Response");
            
            alertLose.showAndWait();

        }
        
        //try catch block for filewriter which writes to existing txt file containing all 
        //attempted user solutions and the numbers for cards to go along with said attempted
        //solutions. 
        try{
        
        FileWriter fileW = new FileWriter("src/main/resources/userLog.txt", true);
        BufferedWriter buffW = new BufferedWriter(fileW);
        PrintWriter printW = new PrintWriter(buffW);
        
        printW.println("\nNumbers for given Solution: " + card1.getCardNum() + "," + card2.getCardNum() + "," +card3.getCardNum() + "," +card4.getCardNum() + "\n" + expTxtField.getText());
            
            printW.close();
            buffW.close();
            fileW.close();
        }catch(IOException io){
            
        }
                 
    }
    
    //verify method instantiates a counter for each number for both the input string, as well as an array made up of the 
    //numbers pulled from cardInfo getcardNum() method
    @FXML 
    boolean verify(String str){
        
    int cardCount1 = 0;
    int cardCount2 = 0;
    int cardCount3 = 0;
    int cardCount4 = 0;
    int cardCount5 = 0;
    int cardCount6 = 0;
    int cardCount7 = 0;
    int cardCount8 = 0;
    int cardCount9 = 0;
    int cardCount10 = 0;
    int cardCount11 = 0;
    int cardCount12 = 0;
    int cardCount13 = 0;
    int stringCount1 = 0;
    int stringCount2 = 0;
    int stringCount3 = 0;
    int stringCount4 = 0;
    int stringCount5 = 0;
    int stringCount6 = 0;
    int stringCount7 = 0;
    int stringCount8 = 0;
    int stringCount9 = 0;
    int stringCount10 = 0;
    int stringCount11 = 0;
    int stringCount12 = 0;
    int stringCount13 = 0;
        
        //arrays created to count the occurances of each number from both the string and the cards
        int[] cardNumbers = {card1.getCardNum(), card2.getCardNum(), card3.getCardNum(), card4.getCardNum()};
        int [] cardCounts = {cardCount1,cardCount2,cardCount3,cardCount4,cardCount5,cardCount6,cardCount7,cardCount8,cardCount9,cardCount10,cardCount11,cardCount12,cardCount13};
        int [] stringCounts = {stringCount1,stringCount2,stringCount3,stringCount4,stringCount5,stringCount6,stringCount7,stringCount8,stringCount9,stringCount10,stringCount11,stringCount12,stringCount13};
         
        //loop through card number integer array and count up each occurance of every digit
        for(int i = 0; i < cardNumbers.length;i++)
        {
            switch(cardNumbers[i])
            {
                case 1:
                    cardCount1++;
                    break;
                case 2:
                    cardCount2++;
                    break;
                case 3:
                    cardCount3++;
                    break;
                case 4:
                    cardCount4++;
                    break;
                case 5:
                    cardCount5++;
                    break;
                case 6:
                    cardCount6++;
                    break;    
                case 7:
                    cardCount7++;
                    break;
                case 8:
                    cardCount8++;
                    break;
                case 9:
                    cardCount9++;
                    break;
                case 10:
                    cardCount10++;
                    break;
                case 11:
                    cardCount11++;
                    break;
                case 12:
                    cardCount12++;
                    break;
                case 13:
                    cardCount13++; 
                    break;
            }
        }
        
        //for loop counts up each occurance of every number from the string 
        for(int i = 0; i < str.length(); i++)
        {
            switch(str.charAt(i))
            {
                //special attention to the case at '1' to assure digits arent tallied multiple times when dealing with
                // a number in the double digits
                case '1':   
                    if((i != str.length()) && (Character.isDigit(str.charAt(i+1))))
                    {
                        
                        if(str.charAt(i+1) == '0')
                         stringCount10++;
                        if(str.charAt(i+1) == '1')
                         stringCount11++;
                        if(str.charAt(i+1) == '2')
                         stringCount12++;
                        if(str.charAt(i+1) == '3')
                         stringCount13++;
                        i++;
                        break;
                    }
                    stringCount1++;
                    break;
                case '2':
                    stringCount2++;
                    break;
                case '3':
                    stringCount3++;
                    break;
                case '4':
                    stringCount4++;
                    break;
                case '5':
                    stringCount5++;
                    break;
                case '6':
                    stringCount6++;
                    break;    
                case '7':
                    stringCount7++;
                    break;
                case '8':
                    stringCount8++;
                    break;
                case '9':
                    stringCount9++;
                    break;
                default:
                    break;
            }
              
            }
        // re-creating new arrays with the tallied up values
        int [] cardCounters = {cardCount1,cardCount2,cardCount3,cardCount4,cardCount5,cardCount6,cardCount7,cardCount8,cardCount9,cardCount10,cardCount11,cardCount12,cardCount13};
        int [] stringCounters = {stringCount1,stringCount2,stringCount3,stringCount4,stringCount5,stringCount6,stringCount7,stringCount8,stringCount9,stringCount10,stringCount11,stringCount12,stringCount13};
        
        //calls helper method to verify contents of both arrays are equal, as well as calling on EvalMethod
        //to verify expression equals 24
        if((helper(stringCounters,cardCounters)) && (EvalMethod.evaluateString(expTxtField.getText()) == 24))
        {
            return true;
        }
        else{
            return false;
        }
            
    }
    
    //attempts to create an automatic solution for the given numbers.
    //if the 4 numbers from the card can be added up to 24, will display said result
    //otherwise, will output no automatic solution available
    @FXML
    void solBtnAction(ActionEvent event) {
           int sum = card1.getCardNum() + card2.getCardNum() + card3.getCardNum() + card4.getCardNum(); 
         if(sum == 24)
         {
             solutionTxtField.setText(card1.getCardNum() + " + " + card2.getCardNum() + " + " + card3.getCardNum() + " + " + card4.getCardNum());
             solutionTxtField.setEditable(false);
         } else{
             solutionTxtField.setText("No Auto Solve Available: ");
             solutionTxtField.setEditable(false);
         }
    }
    
    //helper method to verify the contents of 2 integer arrays are the same
    boolean helper(int[] int1, int[] int2)
    {
        if(int1.length != int2.length)
        {
            return false;
        }
        
        for(int i = 0; i < int1.length; i++){
            if(int1[i] != int2[i])
                return false;
        }
        
        return true;
    }
    
}
