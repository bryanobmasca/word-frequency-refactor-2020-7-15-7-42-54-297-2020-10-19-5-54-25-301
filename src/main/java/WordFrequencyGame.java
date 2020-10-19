import java.util.*;

public class WordFrequencyGame {

    public String getResult(String sentence) {
        List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
        sortListByWordFrequency(wordInfoList);
        return getJoinedWordInfo(wordInfoList);
    }

    private void sortListByWordFrequency(List<WordInfo> wordInfoList) {
        wordInfoList.sort((firstWord, secondWord) ->
                secondWord.getWordFrequency() - firstWord.getWordFrequency());
    }

    private String getJoinedWordInfo(List<WordInfo> wordInfoList) {
        StringJoiner joinedWordInfo = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String wordInfoLine = wordInfo.getWordInfo();
            joinedWordInfo.add(wordInfoLine);
        }
        return joinedWordInfo.toString();
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        final String WHITE_SPACES = "\\s+";
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int frequency = Collections.frequency(words, word);
            wordInfos.add(new WordInfo(word, frequency));
        }
        return wordInfos;
    }
}
