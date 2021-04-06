package org.haffson.adventofcode.days.day01;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Day01Test {

    @MockBean
    private FileReaders fileReaders;

    @Test
    public void testGetDay() {
        Day01 day01 = new Day01(fileReaders);
        int expectedResult = 1;
        int actualResult = day01.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_firstPart_returnsExpectedResult() {
        //arrange
        Day01 day01 = new Day01(fileReaders);

        day01.frequencyArr = new int[4];
        day01.frequencyArr[0] = 1;
        day01.frequencyArr[1] = -2;
        day01.frequencyArr[2] = 3;
        day01.frequencyArr[3] = 1;

        String expectedResult = "Part 1 - Frequency: 3";

        //act
        String actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[3];
        day01.frequencyArr[0] = 1;
        day01.frequencyArr[1] = 1;
        day01.frequencyArr[2] = 1;

        expectedResult = "Part 1 - Frequency: 3";

        //act
        actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[3];
        day01.frequencyArr[0] = 1;
        day01.frequencyArr[1] = 1;
        day01.frequencyArr[2] = -2;

        expectedResult = "Part 1 - Frequency: 0";

        //act
        actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[3];
        day01.frequencyArr[0] = -1;
        day01.frequencyArr[1] = -2;
        day01.frequencyArr[2] = -3;

        expectedResult = "Part 1 - Frequency: -6";

        //act
        actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);


    }

    @Test
    public void test_secondPart_returnsExpectedResult() {
        //arrange
        Day01 day01 = new Day01(fileReaders);

        day01.frequencyArr = new int[6];
        day01.frequencyArr[0] = 1;
        day01.frequencyArr[1] = -2;
        day01.frequencyArr[2] = 3;
        day01.frequencyArr[3] = 1;
        day01.frequencyArr[4] = 1;
        day01.frequencyArr[5] = -2;

        String expectedResult = "Part 2 - Duplicated Frequency: 2";

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[2];
        day01.frequencyArr[0] = 1;
        day01.frequencyArr[1] = -1;

        expectedResult = "Part 2 - Duplicated Frequency: 0";

        //act
        actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[5];
        day01.frequencyArr[0] = 3;
        day01.frequencyArr[1] = 3;
        day01.frequencyArr[2] = 4;
        day01.frequencyArr[3] = -2;
        day01.frequencyArr[4] = -4;

        expectedResult = "Part 2 - Duplicated Frequency: 10";

        //act
        actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);

        day01.frequencyArr = new int[5];
        day01.frequencyArr[0] = 7;
        day01.frequencyArr[1] = 7;
        day01.frequencyArr[2] = -2;
        day01.frequencyArr[3] = -7;
        day01.frequencyArr[4] = -4;

        expectedResult = "Part 2 - Duplicated Frequency: 14";

        //act
        actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

}
