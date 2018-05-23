public class Word {
    private String word;
    private String ipa;
    private String plural;
    private String pluralIpa;
    private PartOfSpeech partOfSpeech;
    private String classification;
    private String definition;
    private String specialNotes;

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

    private String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    private String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    private String getPluralIpa() {
        return pluralIpa;
    }

    public void setPluralIpa(String pluralIpa) {
        this.pluralIpa = pluralIpa;
    }

    private PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    private String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    private String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    private String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    @Override
    public String toString() {
        return getWord() + "||" + getIpa() + "||" + getPlural() + "||" + getPluralIpa() + "||" + getPartOfSpeech()  +
                "||" + getClassification()  + "||" + getDefinition()  + "||" + getSpecialNotes();
    }
}
