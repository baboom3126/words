package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "WordDefSen")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordDefSenEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordDefSenId", length = 32)
    private String wordDefSenId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "EngDefinition")
    private String engDefinition;

    @Column(name = "ChiDefinition")
    private String chiDefinition;

    @Column(name = "EngSentence")
    private String engSentence;

    @Column(name = "ChiSentence")
    private String chiSentence;

    public String getWordDefSenId() {
        return wordDefSenId;
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

    public String getEngSentence() {
        return engSentence;
    }

    public String getChiSentence() {
        return chiSentence;
    }

    public void setWordDefSenId(String wordDefSenId) {
        this.wordDefSenId = wordDefSenId;
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

    public void setEngSentence(String engSentence) {
        this.engDefinition = engSentence;
    }

    public void setChiSentence(String chiSentence) {
        this.chiDefinition = chiSentence;
    }

}
