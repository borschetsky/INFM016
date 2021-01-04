package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
      CircularQueue<Integer> firstQueue = new CircularQueue<>();

      try {
          URL path = Main.class.getResource("nubers1.txt");
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
      firstQueue.dequeue();
      firstQueue.enqueue(4);
        firstQueue.enqueue(45);
        firstQueue.enqueue(46);

        firstQueue.sort();
        firstQueue.print();
//        LinkedList list = firstQueue.generateLinkedList();
//        list.printList();

    }
}
