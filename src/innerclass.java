public class innerclass {

    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        charMaps[0] = new CharacterPatternMap('O', new String[]{
                "  ***  ",
                " ** ** ",
                "**   **",
                "**   **",
                "**   **",
                " ** ** ",
                "  ***  "
        });

        charMaps[1] = new CharacterPatternMap('P', new String[]{
                "****** ",
                "**   **",
                "**   **",
                "****** ",
                "**     ",
                "**     ",
                "**     "
        });

        charMaps[2] = new CharacterPatternMap('S', new String[]{
                " ***** ",
                "**     ",
                "**     ",
                " ***** ",
                "     **",
                "     **",
                " ***** "
        });

        charMaps[3] = new CharacterPatternMap(' ', new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "
        });

        return charMaps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return null;
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int patternHeight = 7;
        StringBuilder[] lines = new StringBuilder[patternHeight];

        for (int i = 0; i < patternHeight; i++) {
            lines[i] = new StringBuilder();
        }

        for (int i = 0; i < message.length(); i++) {
            String[] pattern = getCharacterPattern(message.charAt(i), charMaps);
            if (pattern != null) {
                for (int j = 0; j < patternHeight; j++) {
                    lines[j].append(pattern[j]);
                    if (i < message.length() - 1) {
                        lines[j].append("  ");
                    }
                }
            }
        }

        for (StringBuilder line : lines) {
            System.out.println(line.toString());
        }
    }

    /**
     * Main method - Entry point for the banner display application
     *
     * Initializes the character pattern maps and displays "OOPS" as an ASCII art banner.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        // Define the message to be displayed
        String message = "OOPS";
        // Print the banner message
        printMessage(message, charMaps);
    }
}
