package org.ohnlp.medxn.backbone;

public class MedXNDrugBean {
    private String code;
    private String matchedText;
    private int matchBegin;
    private int matchEnd;
    private int matchSection;
    private String nlpDate;
    private String matchSentence;
    private String frequency;
    private String duration;
    private String route;
    private String dosage;
    private String strength;
    private String form;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMatchedText() {
        return matchedText;
    }

    public void setMatchedText(String matchedText) {
        this.matchedText = matchedText;
    }

    public int getMatchBegin() {
        return matchBegin;
    }

    public void setMatchBegin(int matchBegin) {
        this.matchBegin = matchBegin;
    }

    public int getMatchEnd() {
        return matchEnd;
    }

    public void setMatchEnd(int matchEnd) {
        this.matchEnd = matchEnd;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMatchSentence() {
        return matchSentence;
    }

    public void setMatchSentence(String matchSentence) {
        this.matchSentence = matchSentence;
    }

    public int getMatchSection() {
        return matchSection;
    }

    public void setMatchSection(int matchSection) {
        this.matchSection = matchSection;
    }

    public String getNlpDate() {
        return nlpDate;
    }

    public void setNlpDate(String nlpDate) {
        this.nlpDate = nlpDate;
    }
}
