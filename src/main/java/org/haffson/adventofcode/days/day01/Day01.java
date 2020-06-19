package org.haffson.adventofcode.days.day01;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Implementation for <i>Day 1: Chronal Calibration</i>.
 */
@Component
public class Day01 implements Days {

    /**
     * The puzzle status {@code HashMap}
     */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /**
     * Our frequency's
     **/
    public int[] frequencyArr;

    /**
     * Causes the input file to be parsed into the frequencies array ({@code frequencies}).
     *
     * @param fileReaders {@code @Autowired} fileReader //TODO: inject what you need
     */
    @Autowired
    Day01(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
        frequencyArr = fileReaders.readFileAsIntArr("input\\day1\\day01Input");
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Frequency: " + calculateFrequency();
    }

    @Override
    public String secondPart() {
        return "Part 2 - Duplicated Frequency: " + findFirstDuplicatedFrequency();
    }

    /**
     * Primary method for Day 1, Part 1.
     * Calculates the final frequency as the sum of all frequencies.
     *
     * @return the final frequency
     */
    private int calculateFrequency() {
        int frequency = 0;

        for (int freq : frequencyArr) {
            frequency += freq;
        }
        return frequency;
    }

    private int findFirstDuplicatedFrequency() {
        int result = 0;
        Set<Integer> calculatedFrequencys = new HashSet<>();

        calculatedFrequencys.add(result);

        for (int i = 0; true; i++) {
            if (frequencyArr.length == i) {
                i = 0;
            }

            result += frequencyArr[i];

            if (!calculatedFrequencys.add(result)) {
                return result;
            }
        }
    }
}
