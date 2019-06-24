package problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextTransformerTest {

    @org.junit.jupiter.api.Test
    void getEvenLines() {
        assertEquals("2\n4\n6\n8",TextTransformer.getEvenLines("1\n2\n3\n4\n5\n6\n7\n8\n9"));
    }

    @org.junit.jupiter.api.Test
    void removeLineBreaks() {
        assertEquals("123456789",TextTransformer.removeLineBreaks("1\n2\n3\n4\n5\n6\n7\n8\n9"));
    }
}