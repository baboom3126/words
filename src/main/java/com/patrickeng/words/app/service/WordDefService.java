package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.WordDefEntity;
import com.patrickeng.words.app.repository.WordDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordDefService {

    @Autowired
    private WordDefRepository wordDefRepository;

    public void save(WordDefEntity wordDefEntity){
        wordDefRepository.save(wordDefEntity);
    }

    public List<WordDefEntity> findByTheWord(String theWord){
        return wordDefRepository.findByTheWord(theWord);
    }

    public List<WordDefEntity> findAll(){
        return wordDefRepository.findAll();
    }
}
