package com.example.handlingformsubmission;
//import java.util.* to import List, ArrayList, etc
import java.util.*;

class configuration {
  //define each possible move, and the previous move made as integers
  //there are only 6 possible moves on 2x2 because top moves are just the reverse of bottom moves, and etc 
  static final int R = 0;
  static final int Rprim = 1;
  static final int U = 2;
  static final int Uprim = 3;
  static final int F = 4;
  static final int Fprim = 5;
  
  int prevMove;

  //now define an array to represent the colours on the cube
  // 0 - white, 1 - red, 2 - orange, 3 - yellow, 4 - green, 5 - blue (although it wont matter for this file)
  //use bytes to make the final calculation quicker
  byte[] colours;

  //we can now track both with a configuration object
  configuration(byte[] arr, int move) {
      this.colours = arr;
      this.prevMove = move;
  }

    //type refers to which move is made (R, R', etc), colours is a configuration
    static byte[] move(int type, byte[] colours) {

        //creates an output array that represents a the new state of the cube after a specified move
        byte[] coloursAfterMove = Arrays.copyOf(colours, colours.length);
         
        //match the type (these are both integer representations), and complete the move
        if(type == R){
         moveR(coloursAfterMove, colours);
        }else if(type == Rprim){
         moveRprim(coloursAfterMove, colours);
        }if(type == U){
         moveU(coloursAfterMove, colours);
        }else if(type == Uprim){
         moveUprim(coloursAfterMove, colours);
        }if(type == F){
         moveF(coloursAfterMove, colours);
        }else if(type == Fprim){
         moveFprim(coloursAfterMove, colours);
        }
  
        //one of the moves has been made and the colours have been switched around
        return coloursAfterMove;
    }
  
  
    //these methods actually create the configuration that would occur if the move was made, for each move
   static void moveR(byte[] coloursAfterMove, byte[] colours) {
    //new front
    coloursAfterMove[2] = colours[22];
    coloursAfterMove[4] = colours[24];
    //new top
    coloursAfterMove[18] = colours[2];
    coloursAfterMove[20] = colours[4];
    //new back
    coloursAfterMove[9] = colours[20];
    coloursAfterMove[11] = colours[18];
    //new bottom
    coloursAfterMove[22] = colours[11];
    coloursAfterMove[24] = colours[9];
    //new right
     coloursAfterMove[5] = colours[7];
     coloursAfterMove[6] = colours[5];
     coloursAfterMove[7] = colours[8];
     coloursAfterMove[8] = colours[6];
 }
  static void moveRprim(byte[] coloursAfterMove, byte[] colours) {
    //new front
    coloursAfterMove[2] = colours[18];
    coloursAfterMove[4] = colours[20];
    //new top
    coloursAfterMove[18] = colours[11];
    coloursAfterMove[20] = colours[9];
    //new back
    coloursAfterMove[11] = colours[22];
    coloursAfterMove[9] = colours[24];
    //new bottom
    coloursAfterMove[22] = colours[2];
    coloursAfterMove[24] = colours[4];
    //new right
    coloursAfterMove[8] = colours[7];
    coloursAfterMove[7] = colours[5];
    coloursAfterMove[5] = colours[6];
    coloursAfterMove[6] = colours[8]; 
 }
  static void moveU(byte[] coloursAfterMove, byte[] colours) {
    //new front
    coloursAfterMove[1] = colours[5];
    coloursAfterMove[2] = colours[6];
    //new left
    coloursAfterMove[13] = colours[1];
    coloursAfterMove[14] = colours[2];
    //new back
    coloursAfterMove[9] = colours[13];
    coloursAfterMove[10] = colours[14];
    //new right
    coloursAfterMove[5] = colours[9];
    coloursAfterMove[6] = colours[10];
    //new top
    coloursAfterMove[17] = colours[19];
    coloursAfterMove[18] = colours[17];
    coloursAfterMove[19] = colours[20];
    coloursAfterMove[20] = colours[18];  
}


static void moveUprim(byte[] coloursAfterMove, byte[] colours) {
    //new front
    coloursAfterMove[1] = colours[13];
    coloursAfterMove[2] = colours[14];
    //new right
    coloursAfterMove[5] = colours[1];
    coloursAfterMove[6] = colours[2];
    //new back
    coloursAfterMove[9] = colours[5];
    coloursAfterMove[10] = colours[6];
    //new left
    coloursAfterMove[13] = colours[9];
    coloursAfterMove[14] = colours[10];
    //new top
    coloursAfterMove[17] = colours[18];
    coloursAfterMove[18] = colours[20];
    coloursAfterMove[19] = colours[19];
    coloursAfterMove[20] = colours[17];
}
  static void moveF(byte[] coloursAfterMove, byte[] colours) {
    //new top
    coloursAfterMove[19] = colours[16];
    coloursAfterMove[20] = colours[14];
    //new right
    coloursAfterMove[5] = colours[19];
    coloursAfterMove[7] = colours[20];
    //new bottom
    coloursAfterMove[22] = colours[5];
    coloursAfterMove[21] = colours[7];
    //new left
    coloursAfterMove[14] = colours[21];
    coloursAfterMove[16] = colours[22];
    ///new front
    coloursAfterMove[2] = colours[1];
    coloursAfterMove[1] = colours[3];
    coloursAfterMove[3] = colours[4];
    coloursAfterMove[4] = colours[2];
 }


 static void moveFprim(byte[] coloursAfterMove, byte[] colours) {
    //new top
    coloursAfterMove[19] = colours[5];
    coloursAfterMove[20] = colours[7];
    //new right
    coloursAfterMove[5] = colours[22];
    coloursAfterMove[7] = colours[21];
    //new bottom
    coloursAfterMove[21] = colours[14];
    coloursAfterMove[22] = colours[16];
    //new left
    coloursAfterMove[16] = colours[19];
    coloursAfterMove[14] = colours[20];
    //new front
    coloursAfterMove[1] = colours[2];
    coloursAfterMove[3] = colours[1];
    coloursAfterMove[4] = colours[3];
    coloursAfterMove[2] = colours[4];
 }

  //make a method to find all the cube configurations that are just one move away
  //will be able to use this to find every possible configuration within a certain number of moves
  //in knowing that a 2x2 cube can always be solved in 10 moves, if we exceed 12 we will know there is no possible solution.
  List<configuration> oneAway() {
      //initialize array list
      List<configuration> oneAway = new ArrayList<>();

      //there are only 6 possible moves as we have defined as integers above
      //iterate through them all and add the new configuration that would occur if the move was made on the "current" configuration
      int i = 0;
       while(i<6){
           byte[] oneAwayArray = move(i, colours);
           configuration n = new configuration(oneAwayArray, i);
           oneAway.add(n);
           i++;
       }

      //return the arraylist (list of the numbers representing colours of all 6 configurations that are one away)
      return oneAway;
  }




  //all these two override functions do is speed up the program
 
  //overrides the default implementation of generating a hash code
  @Override
  public int hashCode() {
     return Arrays.hashCode(colours);
  }
   //overrides the default implementation of object equality and checks if two states are the same
  @Override
  public boolean equals(Object o) {
     if (this == o)
          return true;
      if (o == null || getClass() != o.getClass())
          return false;
      configuration coloursState = (configuration) o;
      return Arrays.equals(colours, coloursState.colours);
  }
  
}












