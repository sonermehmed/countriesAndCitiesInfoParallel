/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondsolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Lenovo-ideaPad-15isk
 */
public class Info {

    public static void info() {
        System.out.println("Номер (1) връща всички градове от указана държава.");
        System.out.println("Номер (2) връща всички областни градове в България.");
        System.out.println("Номер (3) връща броя на градовете, името на които започва със зададен низ.");
        System.out.println("Номер (4) връща градовете с еднакви имена от различни държави.");

    }

    public static void secondInfo(String text) throws FileNotFoundException, IOException {
        FileOutputStream writer = new FileOutputStream(new File("src\\secondsolution\\output.txt"), true);
        byte[] mybytes = text.getBytes();
        writer.write(mybytes);
        writer.flush();
        writer.close();
    }
}
