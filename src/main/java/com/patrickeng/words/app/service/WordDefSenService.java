package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.WordDefSenEntity;
import com.patrickeng.words.app.repository.WordDefSenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordDefSenService {

    @Autowired
    private WordDefSenRepository wordDefSenRepository;

    public void save(WordDefSenEntity wordDefSenEntity){
        wordDefSenRepository.save(wordDefSenEntity);
    }

    public List<WordDefSenEntity> findAll(){
        return wordDefSenRepository.findAll();
    }
}
