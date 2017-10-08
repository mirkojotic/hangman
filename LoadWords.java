import java.io.*;
import java.nio.file.*;
import java.util.*;

class LoadWords {

    private ArrayList<String> words;

    public LoadWords(String fileName) {
        try {
            words = new ArrayList<String>();

            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for(String line : lines) {
                words.add(line.trim());
            }
        }
        catch(IOException ex) {
            System.out.println("io exception");
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }
}