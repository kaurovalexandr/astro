package numerology.name;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class Dictionaries {
    private final static Path BASE = Paths.get("src","main","resources","dictionaries");
    public final static String RU = BASE + File.separator + "ru.csv";
}

/*
* 1 аисъ
* 2 бйты
* 3 вкуь
* 4 глфэ
* 5 дмхю
* 6 енця
* 7 ёоч
* 8 жпщ
* 9 зрщ
* */