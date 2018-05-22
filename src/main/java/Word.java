public class Word {
    public String word;
    public String ipa;
    public String plural;
    public String pluralIpa;
    public PartOfSpeech partOfSpeech;
    public String classification;
    public String definition;
    public String specialNotes;

    public Word(String word, String ipa, String plural, String pluralIpa, PartOfSpeech partOfSpeech, String classification, String definition, String specialNotes) {
        this.word = word;
        this.ipa = ipa;
        this.plural = plural;
        this.pluralIpa = pluralIpa;
        this.partOfSpeech = partOfSpeech;
        this.classification = classification;
        this.definition = definition;
        this.specialNotes = specialNotes;
    }

    public Word(String word, String ipa, PartOfSpeech partOfSpeech, String classification, String definition, String specialNotes) {
        this.word = word;
        this.ipa = ipa;
        this.partOfSpeech = partOfSpeech;
        this.classification = classification;
        this.definition = definition;
        this.specialNotes = specialNotes;
    }

    public Word(String word, String ipa, PartOfSpeech partOfSpeech, String definition, String specialNotes) {
        this.word = word;
        this.ipa = ipa;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.specialNotes = specialNotes;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getPluralIpa() {
        return pluralIpa;
    }

    public void setPluralIpa(String pluralIpa) {
        this.pluralIpa = pluralIpa;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }


}
