import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence) {

        List<WordInfo> wordInfoList = calculateWordFrequency(sentence);

        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordFrequency() - firstWord.getWordFrequency());

        return getJoinedWordInfo(wordInfoList);
    }

    private String getJoinedWordInfo(List<WordInfo> wordInfoList) {
        StringJoiner joinedWordInfo = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String wordInfoLine = String.format("%s %d", wordInfo.getWord(), wordInfo.getWordFrequency());
            joinedWordInfo.add(wordInfoLine);
        }
        return joinedWordInfo.toString();
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
