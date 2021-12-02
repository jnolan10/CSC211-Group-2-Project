package com.mycompany.playingcards24_fxml;


import java.io.FileInputStream;
import java.util.Scanner;


public class cardInfo {
    
    private cardInfo club2;
    private cardInfo club3;
    private cardInfo club4;
    private cardInfo club5;
    private cardInfo club6;
    private cardInfo club7;
    private cardInfo club8;
    private cardInfo club9;
    private cardInfo club10;
    private cardInfo clubJack;
    private cardInfo clubQueen;
    private cardInfo clubKing;
    private cardInfo clubAce;
    private cardInfo spade2;
    private cardInfo spade3;
    private cardInfo spade4;
    private cardInfo spade5;
    private cardInfo spade6;
    private cardInfo spade7;
    private cardInfo spade8;
    private cardInfo spade9;
    private cardInfo spade10;
    private cardInfo spadeJack;
    private cardInfo spadeQueen;
    private cardInfo spadeKing;
    private cardInfo spadeAce;
    private cardInfo heart2;
    private cardInfo heart3;
    private cardInfo heart4;
    private cardInfo heart5;
    private cardInfo heart6;
    private cardInfo heart7;
    private cardInfo heart8;
    private cardInfo heart9;
    private cardInfo heart10;
    private cardInfo heartJack;
    private cardInfo heartQueen;
    private cardInfo heartKing;
    private cardInfo heartAce;
    private cardInfo diamond2;
    private cardInfo diamond3;
    private cardInfo diamond4;
    private cardInfo diamond5;
    private cardInfo diamond6;
    private cardInfo diamond7;
    private cardInfo diamond8;
    private cardInfo diamond9;
    private cardInfo diamond10;
    private cardInfo diamondJack;
    private cardInfo diamondQueen; 
    private cardInfo diamondKing ;
    private cardInfo diamondAce ;
    private String cardName;
    private int cardNum;
    
    cardInfo(int num, String name){
        this.cardNum = num;
        this.cardName = name;
    }
    
    cardInfo(){
        initializeCards();
    }
    
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    
    public void initializeCards(){
    club2 = new cardInfo(2,"2_of_clubs.png");
    club3 = new cardInfo(3,"3_of_clubs.png");
    club4 = new cardInfo(4,"4_of_clubs.png");
    club5 = new cardInfo(5,"5_of_clubs.png");
    club6 = new cardInfo(6,"6_of_clubs.png");
    club7 = new cardInfo(7,"7_of_clubs.png");
    club8 = new cardInfo(8,"8_of_clubs.png");
    club9 = new cardInfo(9,"9_of_clubs.png");
    club10 = new cardInfo(10,"10_of_clubs.png");
    clubJack = new cardInfo(11,"jack_of_clubs.png");
    clubQueen = new cardInfo(12,"queen_of_clubs.png");
    clubKing = new cardInfo(13,"king_of_clubs.png");
    clubAce = new cardInfo(1,"ace_of_clubs.png");
    spade2 = new cardInfo(2,"2_of_spades.png");
    spade3 = new cardInfo(3,"3_of_spades.png");
    spade4 = new cardInfo(4,"4_of_spades.png");
    spade5 = new cardInfo(5,"5_of_spades.png");
    spade6 = new cardInfo(6,"6_of_spades.png");
    spade7 = new cardInfo(7,"7_of_spades.png");
    spade8 = new cardInfo(8,"8_of_spades.png");
    spade9 = new cardInfo(9,"9_of_spades.png");
    spade10 = new cardInfo(10,"10_of_spades.png");
    spadeJack = new cardInfo(11,"jack_of_spades.png");
    spadeQueen = new cardInfo(12,"queen_of_spades.png");
    spadeKing = new cardInfo(13,"king_of_spades.png");
    spadeAce = new cardInfo(1,"ace_of_spades.png");
    heart2 = new cardInfo(2,"2_of_hearts.png");
    heart3 = new cardInfo(3,"3_of_hearts.png");
    heart4 = new cardInfo(4,"4_of_hearts.png");
    heart5 = new cardInfo(5,"5_of_hearts.png");
    heart6 = new cardInfo(6,"6_of_hearts.png");
    heart7 = new cardInfo(7,"7_of_hearts.png");
    heart8 = new cardInfo(8,"8_of_hearts.png");
    heart9 = new cardInfo(9,"9_of_hearts.png");
    heart10 = new cardInfo(10,"10_of_hearts.png");
    heartJack = new cardInfo(11,"jack_of_hearts.png");
    heartQueen = new cardInfo(12,"queen_of_hearts.png");
    heartKing = new cardInfo(13,"king_of_hearts.png");
    heartAce = new cardInfo(1,"ace_of_hearts.png");
    diamond2 = new cardInfo(2,"2_of_diamonds.png");
    diamond3 = new cardInfo(3,"3_of_diamonds.png");
    diamond4 = new cardInfo(4,"4_of_diamonds.png");
    diamond5 = new cardInfo(5,"5_of_diamonds.png");
    diamond6 = new cardInfo(6,"6_of_diamonds.png");
    diamond7 = new cardInfo(7,"7_of_diamonds.png");
    diamond8 = new cardInfo(8,"8_of_diamonds.png");
    diamond9 = new cardInfo(9,"9_of_diamonds.png");
    diamond10 = new cardInfo(10,"10_of_diamonds.png");
    diamondJack = new cardInfo(11,"jack_of_diamonds.png");
    diamondQueen = new cardInfo(12,"queen_of_diamonds.png");
    diamondKing = new cardInfo(13,"king_of_diamonds.png");
    diamondAce = new cardInfo(1,"ace_of_diamonds.png");
    
    }
    
    public cardInfo[] initializeArr(){
        cardInfo[] cInfo = {
    club2,
    club3,
    club4,
    club5,
    club6,
    club7,
    club8,
    club9,
    club10,
    clubJack,
    clubQueen,
    clubKing,
    clubAce,
    spade2,
    spade3,
    spade4,
    spade5,
    spade6,
    spade7,
    spade8,
    spade9,
    spade10,
    spadeJack,
    spadeQueen,
    spadeKing,
    spadeAce,
    heart2,
    heart3,
    heart4,
    heart5,
    heart6,
    heart7,
    heart8,
    heart9,
    heart10,
    heartJack,
    heartQueen,
    heartKing,
    heartAce,
    diamond2,
    diamond3,
    diamond4,
    diamond5,
    diamond6,
    diamond7,
    diamond8,
    diamond9,
    diamond10,
    diamondJack,
    diamondQueen, 
    diamondKing ,
    diamondAce };
        return cInfo;
    }

}
