package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WordHashtag",
        indexes = {@Index(name = "index_of_WordHashtag_theWord", columnList = "TheWord",unique = false)}
)
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordHashtagEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordHashTagId", length = 32)
    private String wordHashTagId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "Tag")
    private String tag;

    @Column(name = "Status")
    private String status;

    public String getWordHashTagId() {
        return wordHashTagId;
    }

    public String getTheWord() {
        return theWord;
    }

    public String getTag() {
        return tag;
    }

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

}
