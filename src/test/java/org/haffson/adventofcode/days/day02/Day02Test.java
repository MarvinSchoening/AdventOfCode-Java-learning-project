package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class Day02Test {
    @MockBean
    private FileReaders fileReaders;

    @Test
    public void testGetDay() {
        Day02 day02 = new Day02(fileReaders);
        int expectedResult = 1;
        int actualResult = day02.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_firstPart_returnsExpectedResult() {
        //arrange
        Day02 day02 = new Day02(fileReaders);

        List<String> actualList = new ArrayList<>();

        actualList.add("abcdef");
        actualList.add("bababc");
        actualList.add("abbcde");
        actualList.add("abcccd");
        actualList.add("aabcdd");
        actualList.add("abcdee");
        actualList.add("ababab");

        day02.inputList = actualList;

        String expectedResult = "Checksum: 12";

        //act
        String actualResult = day02.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_secondPart_returnsExpectedResult() {
        //arrange
        Day02 day02 = new Day02(fileReaders);

        String expectedResult = "Common: fgij";

        List<String> actualList = new ArrayList<>();

        actualList.add("abcde");
        actualList.add("fghij");
        actualList.add("klmno");
        actualList.add("pqrst");
        actualList.add("fguij");
        actualList.add("axcye");
        actualList.add("wvxyz");

        //act
        String actualResult = day02.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
