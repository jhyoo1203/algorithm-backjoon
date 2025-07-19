import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    private static final String CARD_SPLIT_REGEX = "(\\d)([a-zA-Z])";
    private static final String REST_DAY = ":)";
    private static final String ALGORITHM_DAY = ":(";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] cardArr = new String[4];
            for (int j = 0; j < 4; j++) {
                cardArr[j] = st.nextToken();
            }

            List<String> cards = List.of(cardArr);

            System.out.println(isRestDay(cards) ? REST_DAY : ALGORITHM_DAY);
        }
    }

    private static boolean isRestDay(List<String> cards) {
        return hasContinuousThree(cards) || hasThreeOfAKind(cards) || canMakePairs(cards);
    }

    private static boolean hasContinuousThree(List<String> cards) {
        Map<Integer, List<String>> parsedCards = parseCards(cards);
        Map<String, List<Integer>> letterToNumbers = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : parsedCards.entrySet()) {
            int number = entry.getKey();
            for (String suit : entry.getValue()) {
                letterToNumbers.computeIfAbsent(suit, k -> new ArrayList<>()).add(number);
            }
        }

        for (List<Integer> numbers : letterToNumbers.values()) {
            List<Integer> sorted = numbers.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            for (int i = 0; i <= sorted.size() - 3; i++) {
                if (sorted.get(i + 1) == sorted.get(i) + 1 && sorted.get(i + 2) == sorted.get(i) + 2) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasThreeOfAKind(List<String> cards) {
        Map<String, Integer> cardCount = new HashMap<>();

        for (String card : cards) {
            cardCount.merge(card, 1, Integer::sum);
        }

        return cardCount.values().stream()
                .anyMatch(count -> count >= 3);
    }

    private static boolean canMakePairs(List<String> cards) {
        Map<String, Integer> cardCount = new HashMap<>();

        for (String card : cards) {
            cardCount.merge(card, 1, Integer::sum);
        }

        return cardCount.size() == 2 &&
                cardCount.values().stream().allMatch(count -> count == 2);
    }

    private static Map<Integer, List<String>> parseCards(List<String> cards) {
        Map<Integer, List<String>> parsedCards = new HashMap<>();
        Pattern pattern = Pattern.compile(CARD_SPLIT_REGEX);

        for (String card : cards) {
            Matcher matcher = pattern.matcher(card);

            if (matcher.matches()) {
                int number = Integer.parseInt(matcher.group(1));
                String letter = matcher.group(2);

                parsedCards.computeIfAbsent(number, k -> new ArrayList<>()).add(letter);
            }
        }

        return parsedCards;
    }
}
