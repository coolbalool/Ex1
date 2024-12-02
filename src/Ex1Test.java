import org.junit.Test;

import static org.junit.Assert.*;

public class Ex1Test
{

@Test
    public void testCharToInt()
{
    for (int i = -9; i <= 9;i++)
        if (i <= 9 && i >= 1)
            assertEquals(i,Ex1.charToInt((char)i));
    else assertEquals(-1,Ex1.charToInt((char)i));
}


}
