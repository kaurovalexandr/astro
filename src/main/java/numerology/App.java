package numerology;

import lombok.SneakyThrows;
import numerology.name.AstroСalculator;
import numerology.name.InfoAboutBirthday;
import numerology.name.InfoAboutName;

import java.util.HashMap;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        String fullName = "Каурова настя Сергеевна";
        String birthday = "03.04.1994";
        HashMap<String, Integer> dictionary = Reader.getDictionary();
        InfoAboutName infoAboutName = AstroСalculator.getMagicNames(fullName, dictionary);
        System.out.println("полное имя: " + fullName);
        System.out.println("полное число имени: " + infoAboutName.getFullNumber());
        System.out.println("финальное число имени: " + infoAboutName.getFinalNumber());
        infoAboutName.getMagicNames().stream().forEach(name -> {
            System.out.println("-".repeat(40));
            System.out.println("имя: " + name.getName());
            System.out.println("полное число: " + name.getFullNumber());
            System.out.println("финальное число: " + name.getFinalNumber());
        });

        System.out.println("+".repeat(40));
        System.out.println("информация о дате рождения");
        InfoAboutBirthday infoAboutBirthday = AstroСalculator.getBirthday(birthday);
        infoAboutBirthday.getTable().forEach((x, y) ->
                System.out.print(x + "\t"));
        System.out.println();
        infoAboutBirthday.getTable().forEach((x, y) ->
                System.out.print(y + "\t"));
        System.out.println();
        System.out.println("вывод положительного и отрицательного качества в карте");
        infoAboutBirthday.getQuality().forEach((x, y) ->
                System.out.print(x + "\t"));
        System.out.println();
        infoAboutBirthday.getQuality().forEach((x, y) ->
                System.out.print(y + "\t"));
        System.out.println();
        System.out.println("рассчет точек сборки (стихии)");
        infoAboutBirthday.getAssemblyPoint().forEach(x ->
                System.out.println(x.getName() + "\t" + x.getFullNumber() + "\t" + x.getFinalNumber()));
        System.out.println();


    }

}
