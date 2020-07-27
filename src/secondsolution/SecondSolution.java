/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondsolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import static secondsolution.RunTime.endInMiliSeconds;
import static secondsolution.RunTime.startInMiliSeconds;

/**
 *
 * @author Lenovo-ideaPad-15isk
 */
public class SecondSolution {

    /**
     * @param args the command line arguments
     */
    public static City city;
    public static List<City> listCity = new ArrayList<>();
    public static long timeStart, timeFinish, runTime = 0;

    public static void main(String[] args) {
        // TODO code application logic here

        String fileName = "src\\secondsolution\\cities.csv";
        BufferedReader bufReader;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            String rowData = "";
            bufReader.readLine();
            String[] dataByRow;

            while ((rowData = bufReader.readLine()) != null) {
                dataByRow = rowData.split(";");
                city = new City(String.valueOf(dataByRow[0]), String.valueOf(dataByRow[1]), String.valueOf(dataByRow[2]), String.valueOf(dataByRow[3]));
                listCity.add(city);
            }

            bufReader.close();

            Scanner input = new Scanner(System.in);
            Info.info();
            Scanner in = new Scanner(System.in);
            System.out.print("Избери номер: ");
            int number = in.nextInt();
            FileWriter fileOut = new FileWriter("src\\secondsolution\\output.txt");
            fileOut.write("");
            fileOut.close();
            String text = "";
            byte[] mybytes;

            switch (number) {
                case 1:
                    System.out.print("Country: ");
                    String country = input.nextLine();
                    text = "Country: " + country + "\n\r";
                    Info.secondInfo(text);
                    timeStart = startInMiliSeconds();
                    listCity.stream().filter(line -> country.equals(line.nameOfConutry)).parallel().forEach(new Consumer<City>() {
                        @Override
                        public void accept(City s) {
                            String str = (s.name + "\n\r");
                            try {
                                Info.secondInfo(str);
                            } catch (IOException ex) {
                            }
                        }
                    });
                    timeFinish = endInMiliSeconds();
                    runTime = timeFinish - timeStart;
                    text = "Run time: " + runTime;
                    Info.secondInfo(text);

                    break;
                case 2:
                    timeStart = startInMiliSeconds();
                    text = "All regional cities in Bulgaria: " + "\n\r";
                    Info.secondInfo(text);
                    listCity.stream().filter(line -> "Bulgaria".equals(line.nameOfConutry)).parallel().forEach(new Consumer<City>() {
                        @Override
                        public void accept(City s) {
                            String str = (s.nameOfRegionalCity + "\n\r");
                            try {
                                Info.secondInfo(str);
                            } catch (IOException ex) {
                            }
                        }
                    });
                    timeFinish = endInMiliSeconds();
                    runTime = timeFinish - timeStart;
                    text = "Run time: " + runTime;
                    Info.secondInfo(text);

                    break;

                case 3:
                    System.out.print("String: ");
                    String str = input.nextLine();
                    timeStart = startInMiliSeconds();
                    int count = 0;
                    count = (int) listCity.stream().filter(line -> line.name.startsWith(str)).parallel().count();
                    listCity.stream().filter(line -> line.name.startsWith(str)).parallel().forEach(new Consumer<City>() {
                        @Override
                        public void accept(City s) {
                            String str = (s.name + "\n\r");
                            try {
                                Info.secondInfo(str);
                            } catch (IOException ex) {
                            }
                        }
                    });
                    String countInfo = "The count of cities which contains " + str + " string are: " + count + "\n\r";
                    Info.secondInfo(countInfo);
                    timeFinish = endInMiliSeconds();
                    runTime = timeFinish - timeStart;
                    text = "Run time: " + runTime;
                    Info.secondInfo(text);

                    break;

                case 4:
                    System.out.print("City:  ");
                    String city = input.nextLine();
                    timeStart = startInMiliSeconds();
                    text = "The cities with same names are from: \n\r";
                    Info.secondInfo(text);
                    listCity.parallelStream().filter(line -> city.equals(line.name)).parallel().forEach(new Consumer<City>() {
                        @Override
                        public void accept(City s) {
                            String str = (s.nameOfConutry + "\n\r");
                            try {
                                Info.secondInfo(str);
                            } catch (IOException ex) {
                            }

                        }
                    });
                    timeFinish = endInMiliSeconds();
                    runTime = timeFinish - timeStart;
                    text = "Run time: " + runTime;
                    mybytes = text.getBytes();
                    Info.secondInfo(text);
                    break;

                default:
                // code block
            }

        } catch (Exception e) {
        }

    }
}
