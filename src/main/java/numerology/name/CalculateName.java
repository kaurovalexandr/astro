package numerology.name;

import java.util.*;
import java.util.stream.Collectors;

public class CalculateName {
    public static InfoAboutName getMagicNames(String fullName, HashMap<String, Integer> dictionary) {

        List<MagicName> magicNames = Arrays.stream(fullName.split(" ")).map(name -> {
            List<Letter> letters = getLetters(name, dictionary);
            Integer fullNumber = getFullNumber(letters);
            Integer finalNumber = getFinalNumber(fullNumber);
            return MagicName.builder()
                    .name(name)
                    .fullNumber(fullNumber)
                    .finalNumber(finalNumber)
                    .letters(letters)
                    .build();
        }).collect(Collectors.toList());

        Integer fullNumber = getFullNumberFullName(magicNames);
        Integer finalNumber = getFinalNumber(fullNumber);
        return InfoAboutName.builder()
                .magicNames(magicNames)
                .fullNumber(fullNumber)
                .finalNumber(finalNumber).build();
    }

    public static Integer getFullNumberFullName(List<MagicName> magicNames){
        return magicNames.stream()
                .map(x->x.getFinalNumber())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Letter> getLetters(String partName, HashMap<String, Integer> dictionary) {
        List<Letter> mapLettersNumber = new ArrayList<>();
        char[] letters = partName.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);
            Integer number = dictionary.getOrDefault(letter.toLowerCase(), 0);
            mapLettersNumber.add(new Letter(letter, number));
        }
        return mapLettersNumber;
    }

    public static Integer getFullNumber(List<Letter> letters) {
        return letters.stream()
                .map(letter -> letter.getNumber())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer getFinalNumber(Integer number) {
        Integer finalNumber = getCalculateFinalNumberIteration(number);
        while (finalNumber > 9) {
            finalNumber = getCalculateFinalNumberIteration(finalNumber);
        }
        return finalNumber;
    }

    public static Integer getCalculateFinalNumberIteration(Integer number) {
        if (number <= 9) return number;
        return number % 10 + getFinalNumber(number / 10);
    }
}
