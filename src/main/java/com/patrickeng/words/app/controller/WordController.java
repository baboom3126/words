package com.patrickeng.words.app.controller;

import com.patrickeng.words.app.entity.*;
import com.patrickeng.words.app.model.WordAllBo;
import com.patrickeng.words.app.repository.WordSenRepository;
import com.patrickeng.words.app.service.WordDefService;
import com.patrickeng.words.app.service.WordHashtagService;
import com.patrickeng.words.app.service.WordSenService;
import com.patrickeng.words.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private WordDefService wordDefService;
    @Autowired
    private WordHashtagService wordHashtagService;
    @Autowired
    private WordSenService wordSenService;

    @RequestMapping(value = "/newOne")
    public String NewWordAutoPage() {
        return "word/NewWordAutoPage";
    }

    @RequestMapping(value = "/newBatch")
    public String NewWordByBatchPage() {
        return "word/NewWordByBatchPage";
    }

    @RequestMapping(value = "/simpleWordList")
    public String SimpleWordListPage() {
        return "word/SimpleWordListPage";
    }

    @RequestMapping(value = "/detailWordList")
    public String DetailWordListPage() {
        return "word/DetailWordListPage";
    }

    public Map<String,Object> getWordAllBo(String theQueryWord){

//        WordAllBo wordAllBo = new WordAllBo();
//        wordAllBo.setTheWord(theQueryWord);

        WordEntity wordEntity = wordService.findByTheWord(theQueryWord);
        List<WordDefEntity> wordDefEntities = wordDefService.findByTheWord(theQueryWord);
        List<WordSenEntity> wordSenEntities = wordSenService.findByTheWord(theQueryWord);
//        List<WordHashtagEntity> wordHashtagEntities = wordHashtagService.findByTheWord(theQueryWord);

//        wordAllBo.setTheWord(theQueryWord);
//        wordAllBo.setWordEntity(wordEntity);
//        wordAllBo.setWordDefEntities(wordDefEntities);
//        wordAllBo.setWordSenEntities(wordSenEntities);
//        wordAllBo.setWordHashtagEntities(wordHashtagEntities);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wordEntity",wordEntity);
        map.put("wordDefEntities",wordDefEntities);
        map.put("wordSenEntities",wordSenEntities);
//        map.put("wordHashtagEntities",wordHashtagEntities);

        return map;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/query/{theQueryWord}",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> getOneWord(HttpServletRequest request, HttpServletResponse response, @PathVariable final String theQueryWord) {

        Map<String, Object> map = new HashMap<String, Object>();

        map = getWordAllBo(theQueryWord);

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/queryAllDetail" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> queryAllDetail(HttpServletRequest request, HttpServletResponse response) {

        List<Map<String,Object>> WordAllBoList = new ArrayList<>();

        List<WordEntity> WordEntityList = wordService.findAll();



        for(WordEntity wordEntity : WordEntityList){
            String theWord = wordEntity.getTheWord();

            WordAllBoList.add(getWordAllBo(theWord));


        }



        return new ResponseEntity<List<Map<String,Object>>>(WordAllBoList, HttpStatus.OK);


    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/queryAllSimple" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> queryAllSimple(HttpServletRequest request, HttpServletResponse response) {

        List<WordEntity> WordEntityList = wordService.findAll();





        return new ResponseEntity<List<WordEntity>>(WordEntityList, HttpStatus.OK);


    }


    @RequestMapping(method = RequestMethod.POST, value = "/new" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> addNewWord(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Map<String, Object> wordMap) {
        try {


            LinkedHashMap word = (LinkedHashMap) wordMap.get("word");
            String theWord = word.get("theWord").toString();

            WordEntity wordInSql = wordService.findByTheWord(theWord);

            if (wordInSql == null) {

                /////////////
                WordAllBo wordAllBo = new WordAllBo();
                wordAllBo.setTheWord(theWord);
                /////////////

                ArrayList wordDef = (ArrayList) wordMap.get("wordDef");
                ArrayList wordSen = (ArrayList) wordMap.get("wordSen");
                ArrayList wordHashtag = (ArrayList) wordMap.get("wordHashtag");


                ////wordentity
                WordEntity wordEntity = new WordEntity();

                String speech = word.get("speech").toString();
                String remarks = word.get("remarks").toString();
                String audioPath = word.get("audioPath").toString();
                Date now = new Date();

                wordEntity.setTheWord(theWord);
                wordEntity.setSpeech(speech);
                wordEntity.setRemarks(remarks);
                wordEntity.setAudioPath(audioPath);
                wordEntity.setModifyTime(now);
                wordEntity.setCreateTime(now);
                wordEntity.setStatus("1");

                wordService.save(wordEntity);
                ///
                wordAllBo.setWordEntity(wordEntity);

                ////wordDef///
                for (int i = 0; i < wordDef.size(); i++) {

                    String chiDefinition = ((LinkedHashMap) wordDef.get(i)).get("chiDefinition").toString();
                    String engDefinition = ((LinkedHashMap) wordDef.get(i)).get("engDefinition").toString();

                    WordDefEntity wordDefEntity = new WordDefEntity();

                    wordDefEntity.setTheWord(theWord);
                    wordDefEntity.setChiDefinition(chiDefinition);
                    wordDefEntity.setEngDefinition(engDefinition);
                    wordDefEntity.setMyOrder((i + 1));
                    wordDefEntity.setStatus("1");

                    wordDefService.save(wordDefEntity);
                    ///
                    wordAllBo.addWordDefEntities(wordDefEntity);
                }

                ///wordSen///
                for (int i = 0; i < wordSen.size(); i++) {

                    String chiSentence = ((LinkedHashMap) wordSen.get(i)).get("chiSentence").toString();
                    String engSentence = ((LinkedHashMap) wordSen.get(i)).get("engSentence").toString();

                    WordSenEntity wordSenEntity = new WordSenEntity();

                    wordSenEntity.setTheWord(theWord);
                    wordSenEntity.setChiSentence(chiSentence);
                    wordSenEntity.setEngSentence(engSentence);
                    wordSenEntity.setMyOrder((i + 1));
                    wordSenEntity.setStatus("1");

                    wordSenService.save(wordSenEntity);
                    ///
                    wordAllBo.addWordSenEntities(wordSenEntity);
                }
                ///word hashtag///
                for (int i = 0; i < wordHashtag.size(); i++) {

                    String tag = wordHashtag.get(i).toString();

                    WordHashtagEntity wordHashtagEntity = new WordHashtagEntity();

                    wordHashtagEntity.setTheWord(theWord);
                    wordHashtagEntity.setTag(tag);
                    wordHashtagEntity.setStatus("1");

                    wordHashtagService.save(wordHashtagEntity);
                    ///
                    wordAllBo.addWordHashtagEntities(wordHashtagEntity);
                }


                return new ResponseEntity<WordAllBo>(wordAllBo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("find existing word", HttpStatus.OK);

            }

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
        }


    }
}
