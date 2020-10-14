package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WordDef",
        indexes = {@Index(name = "index_of_WordDef_theWord", columnList = "TheWord",unique = false)}
)
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordDefEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordDefId", length = 32)
    private String wordDefId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "EngDefinition")
    private String engDefinition;

    @Column(name = "ChiDefinition")
    private String chiDefinition;

    @Column(name = "Myorder")
    private int myOrder;

    @Column(name = "Status")
    private String status;

    public String getWordDefId() {
        return wordDefId;
    }

    public String getTheWord() {
        return theWord;
    }

    public String getEngDefinition() {
        return engDefinition;
    }

    public String getChiDefinition() {
        return chiDefinition;
    }

    public int getMyOrder() {
        return myOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setWordDefId(String wordDefId) {
        this.wordDefId = wordDefId;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public void setEngDefinition(String engDefinition) {
        this.engDefinition = engDefinition;
    }

    public void setChiDefinition(String chiDefinition) {
        this.chiDefinition = chiDefinition;
    }

    public void setMyOrder(int myOrder) {
        this.myOrder = myOrder;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
