package com.shikhardixit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0,"Sitting in front of computer, learning java",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        //tempExit.put("Q",0);
        locations.put(1, new Location(1,"Standing at end of road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",5);
        //tempExit.put("Q",0);
        locations.put(2, new Location(2,"At the top of the hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",1);
       // tempExit.put("Q",0);
        locations.put(3, new Location(3,"Inside a building, a well house for small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        //tempExit.put("Q",0);
        locations.put(4, new Location(4,"In full view of a valley, beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        //tempExit.put("Q",0);
        locations.put(5, new Location(5,"In a forest",tempExit));

        Map<String, String> vocab = new HashMap<String, String>();
        vocab.put("QUIT","Q");
        vocab.put("NORTH","N");
        vocab.put("EAST","E");
        vocab.put("SOUTH","S");
        vocab.put("WEST","W");


        int loc =1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit:exits.keySet()){
                System.out.print(exit+", ");
            }
            System.out.println();

            String direction = sc.nextLine().toUpperCase();
            if(direction.length()> 1){
                String[] words= direction.split(" ");
                for(String word:words){
                    if(vocab.containsKey(word)){
                        direction = vocab.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot move in that direction");
            }
        }

    }
}