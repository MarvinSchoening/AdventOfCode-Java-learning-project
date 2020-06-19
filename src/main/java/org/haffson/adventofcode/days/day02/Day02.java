package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Implementation for <i>Day 2: Inventory Management System</i>.
 */
@Component
public class Day02 implements Days {

    /**
     * The puzzle status {@code HashMap}
     */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    protected List<String> inputList;

    /**
     * Causes the input file to be parsed into the frequencies array ({@code frequencies}).
     *
     * @param fileReaders {@code @Autowired} fileReader //TODO: inject what you need
     */
    @Autowired
    Day02(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
        inputList = fileReaders.readFileAsStringList("input\\day2\\day2input");
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Checksum: " + checksum();
    }

    @Override
    public String secondPart() {
        return "Common: " + getCommonString();
    }

    /**
     * FIRST PART
     */
    private int checksum() {
        int exactTwo = 0;
        int exactThree = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if (hasNExactMembers(2, countLetters(inputList.get(i)))) {
                exactTwo++;
            }

            if (hasNExactMembers(3, countLetters(inputList.get(i)))) {
                exactThree++;
            }
        }

        return exactTwo * exactThree;
    }

    private boolean hasNExactMembers(int n, Map<Character, Integer> map) {
        AtomicBoolean exactly = new AtomicBoolean(false);

        map.forEach((key, value) -> {
            if (value == n) {
                exactly.set(true);
            }
        });

        return exactly.get();
    }


    /**
     * Counts how often a single letter is used in a string
     *
     * @param input Input string
     * @return Map letter as key and count as value
     */
    private Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                int cValue = map.get(c);
                map.put(c, ++cValue);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }


    /**
     * SECOND PART
     */
    private String getCommonString() {


        return "";
    }

}
