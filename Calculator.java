import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {

   Scanner scan = new Scanner(System.in);

   public void start() { //starts the calculator by asking to add or subtract, find the magnitude, or cancel.

      int input = 0;

      try {
         System.out.println("Press 1 to add and subtract, press 2 to find a magnitude, enter 3 to terminate");
         input = scan.nextInt();
      } catch (InputMismatchException e) {
         scan.next();
         System.out.println("Error! Invalid number.Try again.\n");
         this.start();
      }

      if (input == 1) {
         operations();
      } else if (input == 2) {
         magnitude();
      } else if (input == 3) {
        System.out.print("\033[H\033[2J");  
         System.out.println("see you next time!");
      } else {
         System.out.println("NOT AN INPUT");
         this.start();
      }
   }

   public void magnitude() { // begins magnitude calculation by prompting for the size of the vector, calls the method to create the vector, calls the method to calculate the magnitude, and prints the magnitude.

      int input = 0;

      do {
         try {
            System.out.println("How large would you like your vector to be?");
            input = scan.nextInt();
         } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error! Invalid number.Try again.\n");
            continue;
         }
         if (input < 1 || input > 999) {
            System.out.println("MUST BE GREATER THAN 0 AND LESS THAN 1000!!!");
         }
      } while (input < 1 || input > 999);

      double[] vector1 = getVector(input, 1);

      System.out.println("\n THE MAGNITUDE IS: " + magnitudeFunction(vector1));
      System.out.println("");
      this.start();
   }

   public void operations() { //begins adding or subtracting vectors. It prompts for their size, calls the method to create the vectors, prompts to add or subtract, and finally calls for their calculation and prints.

      int input = 0;

      do {
         try {
            System.out.println("How large would you like your vectors to be?");
            input = scan.nextInt();
         } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error! Invalid number.Try again.\n");
            continue;
         }
         if (input < 1 || input > 999) {
            System.out.println("MUST BE GREATER THAN 1 AND LESS THAN 1000!!!");
         }
      } while (input < 1 || input > 999);

      double[] vector1 = getVector(input, 1);
      double[] vector2 = getVector(input, 2);

      do {
         try {
            System.out.println("press 1 to add vectors, press 2 to subtract, and 3 to cancel");
            input = scan.nextInt();
         } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error! Invalid number.Try again.\n");
            continue;
         }
         if (input < 1 || input > 4) {
            System.out.println("NOT A VALID NUMBER");
         }
      } while (input < 1 || input > 4);

      if (input == 1) {

         print(vector1);
         System.out.println("\n+");
         print(vector2);
         System.out.println("\n=\n");
         print(add(vector1, vector2));
         System.out.println("");
         this.start();

      } else if (input == 2) {

         print(vector1);
         System.out.println("\n-");
         print(vector2);
         System.out.println("\n=\n");
         print(subtract(vector1, vector2));
         System.out.println("");
         this.start();

      } else {
         this.start();
      }
   }

   public double[] getVector(int size, int turn) { //creates the vectors with inputs for the size of the vector and if it is a vector 1 or 2.

      double[] vector = new double[size];

      for (int i = 0; i < size; i++) {
         try {
            System.out.println("Enter number " + (i + 1) + " for vector " + turn);
            vector[i] = scan.nextDouble();
         } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error! Invalid number.Try again.\n");
            i -= 1;
            continue;
         }
      }
      return vector;
   }

   public static void print(double[] vector) { // prints out an array or vector.
      System.out.println("");
      for (int i = 0; i < vector.length; i++) {
         System.out.println(vector[i]);
      }
   }

   public static double[] subtract(double[] vector1, double[] vector2) { // subtracts two arrays or vectors
      double[] result = new double[vector1.length];

      for (int i = 0; i < vector1.length; i++) {
         result[i] = vector1[i] - vector2[i];
      }
      return result;
   }

   public static double[] add(double[] vector1, double[] vector2) { // adds two arrays or vectors
      double[] result = new double[vector1.length];

      for (int i = 0; i < vector1.length; i++) {
         result[i] = vector1[i] + vector2[i];
      }
      return result;
   }

   public static double magnitudeFunction(double[] vector) { //calculates the magnitude of an array or vector.
      double temp = 0;
      for (int i = 0; i < vector.length; i++) {
         temp += (vector[i] * vector[i]);
      }
      return Math.sqrt(temp);
   }
}