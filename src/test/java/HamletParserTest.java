import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Leon");
        Assert.assertTrue(hamletText.contains("Leon"));
    }

    @Test
    public void testChangeHamletToLeon1() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Leon");
        Assert.assertFalse(hamletText.contains("Hamlet"));

    }

    @Test
    public void testChangedHamletToLeon2() {
        String real = "O Hamlet, speak no more:";
        String actual = hamletParser.changeHamletToLeon(real);
        String expected = "O Leon, speak no more:";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangedHamletToLeon3() {
        String real = "HAMLET\n" +
                "O, that this too too solid flesh would melt";
        String actual = hamletParser.changeHamletToLeon(real);
        String expected = "Leon\n" +
                "O, that this too too solid flesh would melt";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Tariq");
        Assert.assertTrue(hamletText.contains("Tariq"));
    }

    @Test
    public void testChangeHaratioToTariq1() {
        Pattern pattern = Pattern.compile("Haratio");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Tariq");
        Assert.assertFalse(hamletText.contains("Tariq"));
    }

    @Test
    public void testChangeHoratioToTariq2() {
        String real = "O good Horatio, I'll take the ghost's word for a";
        String actual = hamletParser.changeHoratioToTariq(real);
        String expected = "O good Tariq, I'll take the ghost's word for a";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testChangeHoratioToTariq3() {
        String real = "He may approve our eyes and speak to it.\n" + "HORATIO"; //case sensitive?
        String actual = hamletParser.changeHoratioToTariq(real);
        String expected = "He may approve our eyes and speak to it.\n" +  "Tariq";
        Assert.assertEquals(expected, actual);
    }
}