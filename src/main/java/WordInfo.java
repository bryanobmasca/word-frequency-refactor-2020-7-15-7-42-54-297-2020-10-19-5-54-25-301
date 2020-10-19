public class WordInfo {
    private String word;
    private int frequency;

    public WordInfo(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordFrequency() {
        return this.frequency;
    }

    public String getWordInfo(){
        return String.format("%s %d", this.getWord(), this.getWordFrequency());
    }
}
