package com.solvd.logistic.wordcounter;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordCounterInFile {

    public static void countWord(String keyword, String inputFileName, String outputFileName) throws IOException {

        ClassLoader classLoader = WordCounterInFile.class.getClassLoader();
        File inputFile = new File(classLoader.getResource(inputFileName).getFile());
        File outputFile = new File(outputFileName);

        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
        String lcContent = content.toLowerCase();
        List<String> contentList = Arrays.asList(lcContent.split("[\\s,.;]+"));
        int count = Collections.frequency(contentList, keyword.toLowerCase());

        String result = String.format("Result : %s : %d%n", keyword, count);

        FileUtils.writeStringToFile(outputFile, result + "\n", StandardCharsets.UTF_8, true);
    }

}
