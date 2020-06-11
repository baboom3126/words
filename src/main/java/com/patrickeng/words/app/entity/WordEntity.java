package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Word")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WordEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "WordId", length = 32)
    private String wordId;

    @Column(name = "TheWord")
    private String theWord;

    @Column(name = "Speech")
    private String speech;

    @Column(name = "Remarks")
    private String remarks;

    @Column(name = "AudioPath")
    private String audioPath;

    @Column(name = "CreateTime")
    private Date createTime;

    @Column(name = "ModifyTime")
    private Date modifyTime;


    public String getWordId() {
        return wordId;
    }

    public String getTheWord(){
       return theWord;
    }

    public String getSpeech() {
        return speech;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public void setSpeech(String speech){this.speech = speech;}

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setAudioPath(String audioPath) {
        this.remarks = audioPath;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}