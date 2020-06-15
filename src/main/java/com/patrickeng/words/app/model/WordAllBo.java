package com.patrickeng.words.app.model;

import com.patrickeng.words.app.entity.WordDefEntity;
import com.patrickeng.words.app.entity.WordEntity;
import com.patrickeng.words.app.entity.WordHashtagEntity;
import com.patrickeng.words.app.entity.WordSenEntity;


import java.util.ArrayList;
import java.util.List;

public class WordAllBo {

    private String theWord;

    private WordEntity wordEntity;

    private List<WordDefEntity> wordDefEntities;

    private List<WordSenEntity> wordSenEntities;

    private List<WordHashtagEntity> wordHashtagEntities;

    public WordAllBo(){
        this.wordDefEntities = new ArrayList<WordDefEntity>();
        this.wordSenEntities = new ArrayList<WordSenEntity>();
        this.wordHashtagEntities = new ArrayList<WordHashtagEntity>();
    }

    public String getTheWord() {
        return theWord;
    }

    public WordEntity getWordEntity() {
        return wordEntity;
    }

    public List<WordDefEntity> getWordDefEntities(){
        return wordDefEntities;
    }

    public List<WordSenEntity> getWordSenEntities(){
        return wordSenEntities;
    }

    public List<WordHashtagEntity> getWordHashtagEntities() {
        return wordHashtagEntities;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public void setWordEntity(WordEntity wordEntity) {
        this.wordEntity = wordEntity;
    }

    public void addWordDefEntities(WordDefEntity wordDefEntity){
        this.wordDefEntities.add(wordDefEntity);
    }

    public void setWordDefEntities(List<WordDefEntity> wordDefEntities) {
        this.wordDefEntities = wordDefEntities;
    }

    public void addWordSenEntities(WordSenEntity wordSenEntity){
        this.wordSenEntities.add(wordSenEntity);
    }

    public void setWordSenEntities(List<WordSenEntity> wordSenEntities) {
        this.wordSenEntities = wordSenEntities;
    }

    public void addWordHashtagEntities(WordHashtagEntity wordHashtagEntity){
        this.wordHashtagEntities.add(wordHashtagEntity);
    }

    public void setWordHashtagEntities(List<WordHashtagEntity> wordHashtagEntities) {
        this.wordHashtagEntities = wordHashtagEntities;
    }
}
