import org.junit.Test;
import static org.junit.Assert.*;

public class Ex1Test {

    @Test
    public void testToStdNum()
    {
        assertEquals("123bA", Ex1.toStdNum("123bA")); // Already in standard form
        assertEquals("100111b2", Ex1.toStdNum("100111b2")); // Binary format
        assertEquals("1bA", Ex1.toStdNum("1")); // Base 10 is the default

        assertEquals("0bA", Ex1.toStdNum("0")); // Single zero
        assertEquals("9bA", Ex1.toStdNum("9")); // Single-digit number
        assertEquals("FFbG", Ex1.toStdNum("FFbG")); // Hexadecimal representation

        assertEquals("1234b11", Ex1.toStdNum("1234b11")); // Invalid base
        assertEquals("GbG", Ex1.toStdNum("GbG")); // Invalid characters
    }

    @Test
    public void testCharToInt()
    {
        assertEquals(10, Ex1.charToInt('A'));
        assertEquals(0, Ex1.charToInt('0'));
        assertEquals(-1, Ex1.charToInt('Z'));
    }

    @Test
    public void testIntToChar()
    {
        assertEquals('A', Ex1.intToChar(10));
        assertEquals('0', Ex1.intToChar(0));
        assertEquals('-', Ex1.intToChar(16));
    }

    @Test
    public void testIsNumber()
    {
        // From the instruction:
        assertTrue(Ex1.isNumber("100111b2"));
        assertTrue(Ex1.isNumber("12345b6"));
        assertTrue(Ex1.isNumber("012b5"));
        assertTrue(Ex1.isNumber("123bG"));
        assertTrue(Ex1.isNumber("EFbG"));

        assertFalse(Ex1.isNumber("b2"));
        assertFalse(Ex1.isNumber("0b1"));
        assertFalse(Ex1.isNumber("123b"));
        assertFalse(Ex1.isNumber("1234b11"));
        assertFalse(Ex1.isNumber("3b3"));
        assertFalse(Ex1.isNumber("-3b5"));
        assertFalse(Ex1.isNumber("3 b4"));
        assertFalse(Ex1.isNumber("GbG"));
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber(""));


        assertTrue(Ex1.isNumber("123bA"));
        assertTrue(Ex1.isNumber("100111b2"));

        assertFalse(Ex1.isNumber("b10"));
        assertFalse(Ex1.isNumber("123b1"));
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("1234b11"));
        assertFalse(Ex1.isNumber("GbG"));
    }

    @Test
    public void testNumber2Int()
    {
        assertEquals(29, Ex1.number2Int("1DbG"));
        assertEquals(4, Ex1.number2Int("11b3"));
        assertEquals(0, Ex1.number2Int("0b2"));

        assertEquals(-1, Ex1.number2Int("123b1"));
        assertEquals(-1, Ex1.number2Int("b16"));
    }

    @Test
    public void testInt2Number() {
        assertEquals("1FbG", Ex1.int2Number(31, 16));
        assertEquals("100111b2", Ex1.int2Number(39, 2));
        assertEquals("12bA", Ex1.int2Number(12, 10));

        assertEquals("", Ex1.int2Number(10, 17));
        assertEquals("", Ex1.int2Number(-1, 10));
    }

    @Test
    public void testEquals()
    {

        //from the instruction

        // Needed to use the toStdNum because the equals function gets the already std number format
        assertTrue(Ex1.equals(Ex1.toStdNum("135"), "135bA"));

        assertTrue(Ex1.equals("1DbG", "29bA"));
        assertTrue(Ex1.equals("0b2", "0bA"));

        assertFalse(Ex1.equals("1DbG", "30b10"));
        assertFalse(Ex1.equals("1DbG", "30bA"));
    }

    @Test
    public void testMaxIndex()
    {
        String[] numbers = {"1DbG", "AAbB", "100111b2","10b2","000bG"};
        assertEquals(1, Ex1.maxIndex(numbers));

        numbers = new String[]{"0b2", "123bA", "1FbG"};
        assertEquals(1, Ex1.maxIndex(numbers));

        numbers = new String[]{"GbG", "1234b11", "1DbG"};
        assertEquals(2, Ex1.maxIndex(numbers));
    }
}