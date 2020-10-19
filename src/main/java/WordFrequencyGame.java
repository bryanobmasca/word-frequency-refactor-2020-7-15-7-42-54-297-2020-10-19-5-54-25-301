import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){


        if (sentence.split(WHITE_SPACES).length==1) {
            return sentence + " 1";
        } else {

            try {

                List<WordInfo> wordInfoList = calculateWordFrequency(sentence);

                wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfo wordInfo : wordInfoList) {
                    String wordInfoLine = String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount());
                    joiner.add(wordInfoLine);
                }
                return joiner.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private List<WordInfo> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String word : new HashSet<>(words)){
            int frequency = Collections.frequency(words, word);
            wordInfos.add(new WordInfo(word, frequency));
        }
        return wordInfos;
    }
}
