import org.junit.Test;
import static org.junit.Assert.*;

public class Ex1Test {

    @Test
    public void testToStdNum() {
        // Valid cases
        assertEquals("123bA", Ex1.toStdNum("123bA")); // Already in standard form
        assertEquals("100111b2", Ex1.toStdNum("100111b2")); // Binary format
        assertEquals("1bA", Ex1.toStdNum("1")); // Base 10 is the default

        // Edge cases
        assertEquals("0bA", Ex1.toStdNum("0")); // Single zero
        assertEquals("9bA", Ex1.toStdNum("9")); // Single-digit number
        assertEquals("FFbG", Ex1.toStdNum("FFbG")); // Hexadecimal representation

        // Invalid cases (expect no transformation)
        assertEquals("1234b11", Ex1.toStdNum("1234b11")); // Invalid base
        assertEquals("GbG", Ex1.toStdNum("GbG")); // Invalid characters
    }

    @Test
    public void testCharToInt() {
        assertEquals(10, Ex1.charToInt('A'));
        assertEquals(0, Ex1.charToInt('0'));
        assertEquals(-1, Ex1.charToInt('Z')); // Invalid case.
    }

    @Test
    public void testIntToChar() {
        assertEquals('A', Ex1.intToChar(10));
        assertEquals('0', Ex1.intToChar(0));
        assertEquals('-', Ex1.intToChar(16)); // Invalid case.
    }

    @Test
    public void testIsNumber() {
        assertTrue(Ex1.isNumber("123bA"));
        assertTrue(Ex1.isNumber("100111b2"));
        assertFalse(Ex1.isNumber("b10")); // Missing digits before base.
        assertFalse(Ex1.isNumber("123b1")); // Invalid base.
        assertFalse(Ex1.isNumber(null)); // Null case.
        assertFalse(Ex1.isNumber("")); // Empty string.
        assertFalse(Ex1.isNumber("1234b11")); // Base out of range.
        assertFalse(Ex1.isNumber("GbG")); // Invalid characters in number.
    }

    @Test
    public void testNumber2Int() {
        assertEquals(29, Ex1.number2Int("1DbG"));
        assertEquals(4, Ex1.number2Int("11b3"));
        assertEquals(0, Ex1.number2Int("0b2"));
        assertEquals(-1, Ex1.number2Int("123b1")); // Invalid base.
        assertEquals(-1, Ex1.number2Int("b16")); // Missing number.
    }

    @Test
    public void testInt2Number() {
        assertEquals("1FbG", Ex1.int2Number(31, 16));
        assertEquals("100111b2", Ex1.int2Number(39, 2));
        assertEquals("12bA", Ex1.int2Number(12, 10));
        assertEquals("", Ex1.int2Number(10, 17)); // Base out of range.
        assertEquals("", Ex1.int2Number(-1, 10)); // Negative number.
    }

    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("1DbG", "29bA"));
       // assertTrue(Ex1.equals("0b2", "0b10"));
        assertFalse(Ex1.equals("1DbG", "30b10")); // Different numbers.
        assertFalse(Ex1.equals("1DbG", "30bA")); // Different bases.
    }

    @Test
    public void testMaxIndex() {
        String[] numbers = {"1DbG", "AAbB", "100111b2"};
        assertEquals(1, Ex1.maxIndex(numbers)); // AAbB has the maximum value.

        numbers = new String[]{"0b2", "123bA", "1FbG"};
        assertEquals(1, Ex1.maxIndex(numbers)); // 1FbG has the maximum value.

        numbers = new String[]{"GbG", "1234b11", "1DbG"};
        assertEquals(2, Ex1.maxIndex(numbers)); // Handles invalid numbers, chooses valid one.
    }
}