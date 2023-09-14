package com.exxcellent.fileReader.ReaderImpl;

import com.exxcellent.fileReader.MyFileReader;

import java.io.*;
import java.util.Collection;

/*
    This class CsvFileReader implements the interface MyFileReader,
    and should be used for reading a CSV file.
* */
public class CsvFileReader implements MyFileReader {

    @Override
    public void readFile(String url, Collection<String> collection) {
        File csv = new File(url);
        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String line = "";
            int index = 0;
            while ((line = textFile.readLine()) != null){
                if (index > 0){
                    collection.add(line);
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
