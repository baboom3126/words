package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.WordEntity;
import com.patrickeng.words.app.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public void save(WordEntity wordEntity) {
        wordRepository.save(wordEntity);
    }

    public List<WordEntity> findAll() {
        return wordRepository.findAll();
    }

}
