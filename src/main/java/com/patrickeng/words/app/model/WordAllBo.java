package com.patrickeng.words.app.model;

import java.util.ArrayList;
import java.util.Arrays;

public class WordAllBo {

    private String theWord;

    private String speech;

    private String remarks;

    private String audioPath;

    private ArrayList<String> tag;

    private ArrayList<String> engDefinition;

    private ArrayList<String> chiDefinition;

    private ArrayList<String> engSentence;

    private ArrayList<String> chiSentence;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("theWord:").append(theWord).append(",");
        sb.append("speech:").append(speech).append(",");
        sb.append("remarks:").append(remarks).append(",");
        sb.append("audioPath:").append(audioPath).append(",");
        sb.append("tag[]:").append(tag).append(",");
        sb.append("engDefinition[]:").append(engDefinition).append(",");
        sb.append("chiDefinition[]:").append(chiDefinition).append(",");
        sb.append("engSentence[]:").append(engSentence).append(",");
        sb.append("chiSentence[]:").append(chiSentence).append(",");

        return sb.toString();
    }

    public String getTheWord() {
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

    public ArrayList<String> getTag() {
        return tag;
    }

    public ArrayList<String> getEngDefinition() {
        return engDefinition;
    }

    public ArrayList<String> getChiDefinition() {
        return chiDefinition;
    }

    public ArrayList<String> getEngSentence() {
        return engSentence;
    }

    public ArrayList<String> getChiSentence() {
        return chiSentence;
    }
}
