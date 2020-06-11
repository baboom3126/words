package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "WordHashtag")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordHashtagEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordHashTagId", length = 32)
    private String wordHashTagId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "Tag")
    private String tag;

    public String getWordHashTagId() {
        return wordHashTagId;
    }

    public String getTheWord() {
        return theWord;
    }

    public String getTag() {
        return tag;
    }

    public void setWordHashTagId(Long id) {
        this.wordHashTagId = wordHashTagId;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
