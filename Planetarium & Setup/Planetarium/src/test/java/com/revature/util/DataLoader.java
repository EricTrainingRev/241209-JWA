package com.revature.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataLoader {

    public static Object[] createDataCollection(String dataFilePath) throws FileNotFoundException {
        File dataFile = new File(dataFilePath);
        List<String[]> dataSets = new ArrayList<>();
        try(Scanner scanner = new Scanner(dataFile)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");
                dataSets.add(dataSplit);
            }
            return dataSets.toArray();
        }
    }

}
