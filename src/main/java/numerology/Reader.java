package numerology;

import lombok.SneakyThrows;
import numerology.name.Dictionaries;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Reader {

    @SneakyThrows
    public static HashMap<String,Integer> getDictionary(){
        HashMap<String,Integer> dictionaty = new HashMap<>();
        try(Scanner sc = new Scanner(new File(Dictionaries.RU))){
            while (sc.hasNextLine()) {
                String[] letterNumber = sc.nextLine().split(",");
                dictionaty.put(letterNumber[0], Integer.valueOf(letterNumber[1]));
            }
        }
        return dictionaty;
    }
}


