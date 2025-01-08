package com.revature.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DataLoaderTest {

    @Parameterized.Parameter
    public String num;
    @Parameterized.Parameter(1)
    public String word;

    @Parameterized.Parameters
    public static Collection<Object> inputs() throws FileNotFoundException {
        return Arrays.asList(DataLoader.createDataCollection("src/test/java/com/revature/util/dummydata.csv"));
    }

    @Test
    public void testDataLoader(){
        System.out.println(Integer.parseInt(num));
        System.out.println(word);
    }

}
