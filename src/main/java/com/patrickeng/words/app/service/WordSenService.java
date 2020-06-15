package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.WordSenEntity;
import com.patrickeng.words.app.repository.WordSenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSenService {

    @Autowired
    private WordSenRepository wordSenRepository;

    public void save(WordSenEntity wordSenEntity) {
        wordSenRepository.save(wordSenEntity);
    }

    public List<WordSenEntity> findByTheWord(String theWord) {
        return wordSenRepository.findByTheWord(theWord);
    }
        public List<WordSenEntity> findAll() {
        return wordSenRepository.findAll();
    }
}
