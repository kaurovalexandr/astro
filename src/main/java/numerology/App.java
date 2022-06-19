package numerology;

import lombok.SneakyThrows;
import numerology.name.CalculateName;
import numerology.name.InfoAboutName;
import numerology.name.MagicName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        String fullName = "Каурова Настя Сергеевна";
        HashMap<String, Integer> dictionary = Reader.getDictionary();
        InfoAboutName infoAboutName = CalculateName.getMagicNames(fullName, dictionary);
        System.out.println("полное имя: " + fullName);
        System.out.println("полное число имени: " + infoAboutName.getFullNumber());
        System.out.println("финальное число имени: " + infoAboutName.getFinalNumber());
        infoAboutName.getMagicNames().stream().forEach(name -> {
            System.out.println("-".repeat(40));
            System.out.println("имя: " + name.getName());
            System.out.println("полное число: " + name.getFullNumber());
            System.out.println("финальное число: " + name.getFinalNumber());
        });
    }

}
