package com.mycompany.playingcards24_fxml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {
    
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
    void refreshImages(ActionEvent event) throws FileNotFoundException {
        cardInfo cI = new cardInfo();
        cardInfo[] cardNames = cI.initializeArr();
        
        int randNum1 = (int)(Math.random() * (cardNames.length));
        card1 = cardNames[randNum1];
        img1 = new Image(new FileInputStream("C:\\Users\\jonat\\OneDrive\\Desktop\\png\\"+card1.getCardName()));
        imgView1.setImage(img1); 
        
        int randNum2 = (int)(Math.random() * (cardNames.length));
        card2 = cardNames[randNum2];
        img2 = new Image(new FileInputStream("C:\\Users\\jonat\\OneDrive\\Desktop\\png\\"+card2.getCardName()));
        imgView2.setImage(img2);
        
        int randNum3 = (int)(Math.random() * (cardNames.length));
        card3 = cardNames[randNum3];
        img3 = new Image(new FileInputStream("C:\\Users\\jonat\\OneDrive\\Desktop\\png\\"+card3.getCardName()));
        imgView3.setImage(img3);
        
        int randNum4 = (int)(Math.random() * (cardNames.length));
        card4 = cardNames[randNum4];
        img4 = new Image(new FileInputStream("C:\\Users\\jonat\\OneDrive\\Desktop\\png\\"+card4.getCardName()));
        imgView4.setImage(img4);
         
    }
}
