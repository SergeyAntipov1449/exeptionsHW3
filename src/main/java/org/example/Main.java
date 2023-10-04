package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Person pers = Person.dataConsoleInput();
        System.out.println("pers = " + pers);
        try (FileWriter fw = new FileWriter(pers.getSurname() + ".txt", true)) {
            fw.write(pers.toString() + "\n");
        }
        catch (IOException e){
            throw new IOException("Невозможно записать данные в файл");
        }
    }
}
