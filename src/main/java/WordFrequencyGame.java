import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence) {

        List<WordInfo> wordInfoList = calculateWordFrequency(sentence);

        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordFrequency() - firstWord.getWordFrequency());

        return getStringJoiner(wordInfoList);
    }

    private String getStringJoiner(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String wordInfoLine = String.format("%s %d", wordInfo.getWord(), wordInfo.getWordFrequency());
            joiner.add(wordInfoLine);
        }
        return joiner.toString();
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int frequency = Collections.frequency(words, word);
            wordInfos.add(new WordInfo(word, frequency));
        }
        return wordInfos;
    }
}
