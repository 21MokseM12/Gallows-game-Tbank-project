package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import backend.academy.gallow_game.exceptions.GallowsStateNotFoundException;
import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.ui.enums.Logs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public final class GameFilesManager {

    private static final String PATH_TO_WORDS_CATEGORIES = "./src/main/resources/words_categories/";

    private static final String PATH_TO_DICTIONARY = "./src/main/resources/dictionary/dictionary.txt";

    private static final String PATH_TO_GALLOWS_STATES = "./src/main/resources/gallows_design/";

    public static List<String> getWordList(int category, int diffLevel) throws WordNotFoundException {
        String fullPath = addCategoryToPath(PATH_TO_WORDS_CATEGORIES, category);
        fullPath = addDiffLevelToPath(fullPath, diffLevel);

        try {
            return getDataFromFile(fullPath);
        } catch (IOException e) {
            log.error(Logs.WORD_NOT_FOUND_LOG.toString(), e);
            throw new WordNotFoundException(e);
        }
    }

    public static List<String> getDictionary() throws DictionaryNotFoundException {
        try {
            return getDataFromFile(PATH_TO_DICTIONARY);
        } catch (IOException e) {
            throw new DictionaryNotFoundException(e);
        }
    }

    public static List<String> getGallowsStates(int countFails) throws GallowsStateNotFoundException {
        try {
            return getDataFromFile(PATH_TO_GALLOWS_STATES + countFails + "_fail.txt");
        } catch (IOException e) {
            throw new GallowsStateNotFoundException(e);
        }
    }

    private String addCategoryToPath(String path, int category) {
        final String categoryString = String.valueOf(category);
        return switch (categoryString) {
            case "1" -> path
                .concat(Category.CITIES.getCategoryEN())
                .concat("/");
            case "2" -> path
                .concat(Category.CLOTHES.getCategoryEN())
                .concat("/");
            case "3" -> path
                .concat(Category.EAT.getCategoryEN())
                .concat("/");
            case "4" -> path
                .concat(Category.SPORT.getCategoryEN())
                .concat("/");
            case "5" -> path
                .concat(Category.TECHNIC.getCategoryEN())
                .concat("/");
            default -> path;
        };
    }

    private String addDiffLevelToPath(String path, int diffLevel) {
        final String diffLevelString = String.valueOf(diffLevel);
        return switch (diffLevelString) {
            case "1" -> path.concat(DifficultLevel.EASY.getFileName());
            case "2" -> path.concat(DifficultLevel.MEDIUM.getFileName());
            case "3" -> path.concat(DifficultLevel.HARD.getFileName());
            default -> path;
        };
    }

    private List<String> getDataFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
