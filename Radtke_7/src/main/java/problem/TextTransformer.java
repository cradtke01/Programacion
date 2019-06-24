package problem;

public class TextTransformer {

    /**
     * Isolates the even lines of a given String.
     *
     * @param text
     * @return
     */
    public static String getEvenLines(String text) {
        String[] textLine = text.split("\n");
        String newText = "";
        for (int i = 1; i < textLine.length; i += 2) {
            newText += textLine[i] + "\n";
        }
        return newText.substring(0, newText.length() - 1);
    }

    /**
     * Removes all line breaks of a given String.
     *
     * @param text
     * @return
     */
    public static String removeLineBreaks(String text) {
        String newText = text.replaceAll("\n", "");
        return newText;
    }
}
