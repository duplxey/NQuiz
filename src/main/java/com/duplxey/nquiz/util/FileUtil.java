package com.duplxey.nquiz.util;

import java.io.*;

public class FileUtil {

    /**
     * Gets file's content as a string.
     *
     * @param path  File's path
     * @return  Content
     */
    public static String getFileContent(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * Replaces file's content with the given string.
     *
     * @param path  File's path
     * @param content  Content
     */
    public static void writeToFile(String path, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
