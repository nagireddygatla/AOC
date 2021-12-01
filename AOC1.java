package com.pandora.yellowpages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AOC1 {

    public static void main(String [] args){
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("input.txt"));
            String line = br.readLine();

            int prev = Integer.parseInt(line);
            int first = prev;
            int second = 0;
            int third = 0;
            int prevSum=0;
            int count=0;
            int sumCounter=0;
            line = br.readLine();
            int pos = 2;
            while (line != null) {
                int curr = Integer.parseInt(line);

                if(prev < curr)
                    count++;
                prev = curr;

                if(pos < 4){
                    if(pos==2){
                        second = curr;
                    }else if (pos==3){
                        third = curr;
                        prevSum = first+second+third;
                    }
                    pos++;
                }
                else{
                    if(prevSum < prevSum - first + curr){
                        sumCounter++;
                    }
                    prevSum = prevSum - first + curr;
                    first = second;
                    second=third;
                    third = curr;
                }

                line = br.readLine();
            }
            //Day 1 part 1 solution
            System.out.println(count);
            //Day 1 part 2 solution
            System.out.println(sumCounter);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
