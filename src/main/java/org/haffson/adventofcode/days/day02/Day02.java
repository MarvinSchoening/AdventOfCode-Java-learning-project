package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Implementation for <i>Day 2: Inventory Management System</i>.
 */
@Component
public class Day02 implements Days {

    /**
     * The puzzle status {@code HashMap}
     */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    private final List<String> inputList;

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
        return null;
    }

    private int checksum() {

        Map<Character, Integer> inputMap;

        int exactTwo = 0;
        int exactThree = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if (hasNExactMembers(countLetters(inputList.get(i)), 2)) {
                exactTwo++;
            }

            if (hasNExactMembers(countLetters(inputList.get(i)), 3)) {
                exactThree++;
            }
        }

        return exactTwo * exactThree;
    }

    private boolean hasNExactMembers(Map<Character, Integer> map, int n) {
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        boolean exactly = false;

        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            if (mapEntry.getValue().equals(n)) {
                exactly = true;
            }
        }

        return exactly;
    }


    private Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
