package numerology.name;

import java.util.*;
import java.util.stream.Collectors;

public class AstroСalculator {
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

    public static Integer getFullNumberFullName(List<MagicName> magicNames) {
        return magicNames.stream()
                .map(x -> x.getFinalNumber())
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


    public static Integer getFullNumber(Integer number) {
        Integer iterationNumber = number;
        Integer result = 0;
        while (iterationNumber != 0) {
            result = result + iterationNumber % 10;
            iterationNumber = iterationNumber / 10;
        }
        return result;
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

    public static InfoAboutBirthday getBirthday(String birthday) {
        Integer integerBirthday = Integer.valueOf(birthday.replace(".", ""));
        Map<Integer, Integer> resultTable = new HashMap<>();
        Integer year = integerBirthday % 10000;
        Integer month = (integerBirthday / 10000) % 100;
        Integer day = integerBirthday / 1000000;
        resultTable.put(2, getFullNumber(integerBirthday));
        resultTable.put(1, getFinalNumber(resultTable.get(2)));
        resultTable.put(3, getFinalNumber(year));
        resultTable.put(4, getFinalNumber(month));
        resultTable.put(5, getFinalNumber(day));
        resultTable.put(6, getFinalNumber(resultTable.get(4) + resultTable.get(5)));
        resultTable.put(7, getFinalNumber(resultTable.get(4) + resultTable.get(3)));
        resultTable.put(8, getFinalNumber(Math.abs(resultTable.get(5) - resultTable.get(4))));
        resultTable.put(9, getFinalNumber(Math.abs(resultTable.get(3) - resultTable.get(4))));
        Map<String, Integer> quality = new HashMap<>();
        quality.put("+", getFinalNumber(resultTable.get(6) + resultTable.get(7)));
        quality.put("-", getFinalNumber(Math.abs(resultTable.get(8) - resultTable.get(9))));

        AssemblyPoint fire = new AssemblyPoint("Огонь", resultTable.get(1) * resultTable.get(5), getFinalNumber(resultTable.get(1) * resultTable.get(5)));
        AssemblyPoint water = new AssemblyPoint("Вода", resultTable.get(1) * resultTable.get(6), getFinalNumber(resultTable.get(1) * resultTable.get(6)));
        AssemblyPoint air = new AssemblyPoint("Воздух", resultTable.get(4) * resultTable.get(8), getFinalNumber(resultTable.get(4) * resultTable.get(8)));
        AssemblyPoint ground = new AssemblyPoint("Земля", resultTable.get(3) * resultTable.get(7), getFinalNumber(resultTable.get(3) * resultTable.get(7)));
        AssemblyPoint wood = new AssemblyPoint("Дерево", water.getFinalNumber() * ground.getFinalNumber(), getFinalNumber(water.getFinalNumber() * ground.getFinalNumber()));
        AssemblyPoint iron = new AssemblyPoint("Металл", fire.getFinalNumber() * air.getFinalNumber(), getFinalNumber(fire.getFinalNumber() * air.getFinalNumber()));
        AssemblyPoint gift = new AssemblyPoint("Дар", quality.get("+") * quality.get("-"), getFinalNumber(quality.get("+") * quality.get("-")));

        List<AssemblyPoint> assemblyPoint = new ArrayList<>() {{
            add(fire);
            add(water);
            add(air);
            add(ground);
            add(wood);
            add(iron);
            add(gift);
        }};


        return InfoAboutBirthday.builder()
                .table(resultTable)
                .quality(quality)
                .assemblyPoint(assemblyPoint)
                .build();
    }


}
