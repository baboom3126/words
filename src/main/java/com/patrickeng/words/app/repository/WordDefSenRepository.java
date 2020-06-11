package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.WordDefSenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WordDefSenRepository extends JpaRepository<WordDefSenEntity,String>, CrudRepository<WordDefSenEntity,String> {
}
