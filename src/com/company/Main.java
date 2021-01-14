package com.company;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public  static String FILE_NAME = "results.txt";
    public  static String FILE_NAME_NUMBERS_1 = "nubers1.txt";
    public  static String FILE_NAME_NUMBERS_2 = "numbers2.txt";

    public static void main(String[] args) {
	// write your code here
        CircularQueue<Integer> firstQueue = new CircularQueue<>();
        CircularQueue<Integer> secondQueue = new CircularQueue<>();

        //Fill first queue
        readFileAndFillTheQueue(firstQueue, FILE_NAME_NUMBERS_1);
        readFileAndFillTheQueue(secondQueue, FILE_NAME_NUMBERS_2);

        firstQueue.sort();
        secondQueue.sort();

        LinkedList<Integer> list = new LinkedList<>();
        addElementsDevidedByNumberToList(firstQueue, list);
        addElementsDevidedByNumberToList(secondQueue, list);

        writeListToFile(FILE_NAME, list);
    }

    private static void readFileAndFillTheQueue(CircularQueue<Integer> firstQueue, String fileName) {
        try {
            URL path = Main.class.getResource(fileName);
            File myObj = new File(path.getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data= myReader.nextLine();
                try{
                    int currentNumber = Integer.parseInt(data);
                    firstQueue.enqueue(currentNumber);
                } catch (Exception e) {

                }

            }
            myReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addElementsDevidedByNumberToList(CircularQueue<Integer> queue, LinkedList<Integer> list){
        while (!queue.isEmpty()){
            int number = queue.dequeue();
            if(number % 7 == 0){
                list.add(number);
            }
        }
    }
    public static void writeListToFile(String filename, LinkedList<Integer> list) {

        try (OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(filename, true), StandardCharsets.UTF_8)){
            wr.write("List values modulus 7:" + "\r\n");
            try {
                var head = list.getFirst();

                while (head.getNext() != null){
                    wr.write(Integer.toString((Integer)head.getValue()) + " ");

                    head = head.getNext();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            wr.write("\r\n" + "Max value is:" + "\r\n");

            wr.write(Integer.toString(findMaxFromList(list)));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static int findMaxFromList(LinkedList<Integer> list){
        int max = 0;
        try {
            var head = list.getFirst();

            while (head.getNext() != null){
                int currentValue = (Integer)head.getValue();
                if(currentValue > max){
                    max = currentValue;
                }
                head = head.getNext();
            }
        } catch (Exception e){

        }

       return max;
    }
}


