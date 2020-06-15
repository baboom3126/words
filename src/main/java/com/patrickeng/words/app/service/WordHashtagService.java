package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.WordHashtagEntity;
import com.patrickeng.words.app.repository.WordHashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordHashtagService {

    @Autowired
    private WordHashtagRepository wordHashtagRepository;

    public void save(WordHashtagEntity wordHashtagEntity){
        wordHashtagRepository.save(wordHashtagEntity);
    }

    public List<WordHashtagEntity> findByTheWord(String theWord){
        return wordHashtagRepository.findByTheWord(theWord);
    }

    public List<WordHashtagEntity> findAll(){
        return wordHashtagRepository.findAll();
    }
}
