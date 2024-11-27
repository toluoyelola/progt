package greeterlibrary;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

public class GreeterLibrary {

    private static final Map<String, String> GREETINGS = new HashMap<>() {{
        put("hungarian", "Szia, %s!");
        put("english", "Hello, %s!");
        put("yoruba", "Bawo ni, %s!");
    }};

    public static String greet(String name, String language) {

        if (language == null || language.isEmpty()) {
            language = "hun";
        }


        String normalizedLanguage = language.toLowerCase(Locale.ROOT);

        if (!GREETINGS.containsKey(normalizedLanguage)) {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }

        return String.format(GREETINGS.get(normalizedLanguage), name);
    }
}