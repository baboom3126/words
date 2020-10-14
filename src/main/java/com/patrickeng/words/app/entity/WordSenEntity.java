package com.patrickeng.words.app.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WordSen",
        indexes = {@Index(name = "index_of_WordSen_theWord", columnList = "TheWord",unique = false)}
)
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordSenEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordSenId", length = 32)
    private String wordSenId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "EngSentence")
    private String engSentence;

    @Column(name = "ChiSentence")
    private String chiSentence;

    @Column(name = "Myorder")
    private int myOrder;

    @Column(name = "Status")
    private String status;

    public String getWordSenId() {
        return wordSenId;
    }

    public String getTheWord() {
        return theWord;
    }

    public String getEngSentence() {
        return engSentence;
    }

    public String getChiSentence() {
        return chiSentence;
    }

    public int getMyOrder() {
        return myOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setWordSenId(String wordSenId) {
        this.wordSenId = wordSenId;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public void setEngSentence(String engSentence) {
        this.engSentence = engSentence;
    }

    public void setChiSentence(String chiSentence) {
        this.chiSentence = chiSentence;
    }

    public void setMyOrder(int myOrder) {
        this.myOrder = myOrder;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
