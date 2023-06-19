package com.example.handlingformsubmission;

//configurations:
//oowwgwrbryyygygbobbwogrr
//rrrrwwwwyyyyooooggggbbbb
//wgwrrobwyyboroyoggbwgybr

// public class solve {
//     public String test123() {
//         return "R";
//     }
// }

//imports all classes and interfaces from the java.util package.
//instead of just java.util.ArrayList; etc, java.util.* imports all util classes at once
// things in util: linkedlist, ArrayList, HashSet, HashMap, PriorityQueue, Iterator, Comparable, TreeMap
import java.util.*;

//this class solves a rubiks cube by searching every possible cube configuration (using legal moves from the inital cube) until one is solved
public class solve {

   //array of strings representing the possible moves in the Rubik's cube
   //R represents the clockwise rotation of the right face, whereas R' represents the counterclockwise rotation of the right face
   static final String moves[] = new String[] { "R", "R'", "U", "U'", "F", "F'" };

   //this method takes in a string which represents the initial state of the rubiks cube
   //It then converts this string into a byte array to represent the colours on the cube
   //Then each colour is assigned a number so it can be worked with easier
   //The function will return an array numbers, so it could be called by a different method and then give back an easy array to use
   //Once we connect to the html, this function is irrelevant because we will already have the array of colours
   static byte[] convertScrambleToStickerArray(String scramble) {
       byte[] cube = new byte[25];
       for (int i = 1; i < cube.length; i++) {
           switch (scramble.charAt(i - 1)) {
           case 'w':
               cube[i] = 0;
               break;
           case 'r':
               cube[i] = 1;
               break;
           case 'o':
               cube[i] = 2;
               break;
           case 'y':
               cube[i] = 3;
               break;
           case 'g':
               cube[i] = 4;
               break;
           case 'b':
               cube[i] = 5;
               break;


           }
       }
       return cube;
   }


   //This method will check to see if the cube is solved or not
   // It will take in the array of bytes and it will enter a for loop
   // For loop iterates over every byte in the cube array, and compares its colour with the first colour of that face
   // if the colour is different to the first of the face, it returns false, if it makes it all the way through it will return true
   static boolean checkSolved(byte[] cube) {
       int color = 0;
       for (int i = 1; i < cube.length; i++) {
           //this will set the colour to the first colour of the face (every 4 colours is a new face)
           if (i % 4 == 1) {
               color = cube[i];
           }
           //for the other three colours, if they arent the same as the first one then the function returns false
           if (cube[i] != color) {
               return false;
           }
       }
       //if made it through the entire function then every face has been checked and all colours match appropriately
       return true;
   }


   //the method will take in an object of the cube's configuration, and a Map object. It will return a list of strings representing the moves needed to solve the cube
   static List<String> traceSteps(configuration c, Map<configuration, configuration> graph) {
       //creates an empty list to be returned
       List<String> steps = new ArrayList<>();

       //while the state of the cube exists keep adding the last move from the cube's state
       //then update the c variable using the map
       while (c != null) {
           steps.add(moves[c.prevMove]);
           c = graph.get(c);
       }
       //remove original configuration
       steps.remove(steps.size() - 1);
       //must start from the scrambled state
       Collections.reverse(steps);
       return steps;
   }


   //This method will take in the state of the cube, and solve it using BFS
   // Uses a HashMap to store previous states of the cube
   // Starts the BFS from the configuration and continues until a solved state is found
   // If a solved state is finally found, then calls trace steps method above to retrieve the list of moves
   // With the returned steps of the tracesteps method, it can return this. If no solution then returns null
   static List<String> solver(configuration configuration) {
       //creaate hashmap, what are the two parameters again?
       Map<configuration, configuration> prev = new HashMap<>();


       //create queue of configurations
       Queue<configuration> q = new ArrayDeque<>();


       // add the current configuration to the queue
       q.add(configuration);


       //put the current cube state in the first part of map, there is no previous so its null
       prev.put(configuration, null);


       //now we can go through the queue
       while (!q.isEmpty()) {
           //poll() removes and returns the head of the q, could do this with pop()?
           configuration curr = q.poll();

           //check to see if the current state is solved, if it is then trace the steps and return that as the final solution
           if (checkSolved(curr.colours)) {
               return traceSteps(curr, prev);
           }

           //create list of all the configurations one move away
           List<configuration> oneAwayList = curr.oneAway();
                for (int i = 0; i < oneAwayList.size(); i++) {
                    configuration oneAway = oneAwayList.get(i);
                    if (!prev.containsKey(oneAway)) {
                        prev.put(oneAway, curr);
                        q.add(oneAway);
                    }
                }
       }
       //no solution found, return null
       return null;
   }

   //this main method will first give terminal output to the user
   public String notmain(String scramble) {
/*
 * 
 * HERE WE WILL PARSE THE JSON FILE CONTAINING THE ARRAY OF COLOURS
 * 
 * 
 * 
 */
        byte[] cube = convertScrambleToStickerArray(scramble);


        //starts timer
        long tic = System.currentTimeMillis();


        //initial cube state to feed into the solving algorithm
        configuration init = new configuration(cube, 0);


        //call solving algorithm on the configuration and set the output to a list of strings
        List<String> solution = solver(init);

        //make into one presentable string:
        StringBuilder stringBuilder = new StringBuilder();
        if(solution.size() <= 0){
            return "Cube is already solved!";
        }

        for (int i = 0; i < solution.size(); i++) {
            String listItem = (i + 1) + ". " + solution.get(i);
            stringBuilder.append(listItem);
            
            if (i < solution.size() - 1) {
                stringBuilder.append("   "); // Add spacing between list items
            }
        }

        String newString = stringBuilder.toString();

        //solution and time taken to solve it
        //System.out.println("" + solution);
       // System.out.printf("Solution found in %f seconds", (System.currentTimeMillis() - tic) / 1000f);

        //"" so that we return a string
        return newString;

   }
}


