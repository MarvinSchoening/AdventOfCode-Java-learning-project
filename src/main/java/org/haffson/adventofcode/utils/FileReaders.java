package org.haffson.adventofcode.utils;

import org.springframework.stereotype.Component;
import sun.nio.cs.UTF_8;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * File readers to load and parse input files for the puzzles.
 */
@Component
public class FileReaders {
    public static String readFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int[] readFileAsIntArr(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

            int[] intArray = new int[lines.size()];

            for(int i = 0; i < lines.size(); i++){
                intArray[i] = Integer.parseInt(lines.get(i));
            }

            return intArray;
        }
        catch ( IOException e ) {
            System.err.println( "cat: Fehler beim Verarbeiten von " + fileName );
        }
        return new int[0];
    }
}