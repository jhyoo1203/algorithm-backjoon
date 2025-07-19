import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    private static final String DELIMITER = " ";
    private static final String REST_DAY = ":)";
    private static final String ALGORITHM_DAY = ":(";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] cardArr = br.readLine().split(DELIMITER);
            List<String> cards = List.of(cardArr);

            System.out.println(isRestDay(cards) ? REST_DAY : ALGORITHM_DAY);
        }
    }

    private static boolean isRestDay(List<String> cards) {
        return hasContinuousThree(cards) || hasThreeOfAKind(cards) || canMakePairs(cards);
    }

    private static boolean hasContinuousThree(List<String> cardStrings) {
        Map<Integer, List<String>> parsedCards = parseCards(cardStrings);
        Map<String, List<Integer>> suitToNumbers = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : parsedCards.entrySet()) {
            int number = entry.getKey();
            for (String suit : entry.getValue()) {
                suitToNumbers.computeIfAbsent(suit, k -> new ArrayList<>()).add(number);
            }
        }

        for (List<Integer> numbers : suitToNumbers.values()) {
            List<Integer> sorted = numbers.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            for (int i = 0; i <= sorted.size() - 3; i++) {
                if (sorted.get(i + 1) == sorted.get(i) + 1 &&
                        sorted.get(i + 2) == sorted.get(i) + 2) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasThreeOfAKind(List<String> cardStrings) {
        Map<String, Integer> cardCount = new HashMap<>();

        for (String cardString : cardStrings) {
            cardCount.merge(cardString, 1, Integer::sum);
        }

        return cardCount.values().stream()
                .anyMatch(count -> count >= 3);
    }

    private static boolean canMakePairs(List<String> cardStrings) {
        Map<String, Integer> cardCount = new HashMap<>();

        for (String cardString : cardStrings) {
            cardCount.merge(cardString, 1, Integer::sum);
        }

        return cardCount.size() == 2 &&
                cardCount.values().stream().allMatch(count -> count == 2);
    }

    private static Map<Integer, List<String>> parseCards(List<String> cardStrings) {
        Map<Integer, List<String>> parsedCards = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\d+)([a-zA-Z]+)");

        for (String str : cardStrings) {
            Matcher matcher = pattern.matcher(str);

            if (matcher.matches()) {
                int number = Integer.parseInt(matcher.group(1));
                String suit = matcher.group(2);

                parsedCards.computeIfAbsent(number, k -> new ArrayList<>()).add(suit);
            }
        }

        return parsedCards;
    }
}
