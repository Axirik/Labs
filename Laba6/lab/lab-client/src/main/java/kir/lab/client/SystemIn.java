package kir.lab.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String readLine() throws IOException {
        return reader.readLine();
    }

    public static void printLine(String massage) {
        System.out.println(massage);
    }
}
