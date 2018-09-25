
import java.util.*;
import java.lang.*;
import java.io.*;

class StickerProblem {

    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Input No of Test");
        int iNoOfTest = scanner.nextInt();
        //System.out.println("No of test to execute "+iNoOfTest);

        for(int i=1;i<=iNoOfTest;i++) {
            //System.out.println("Input No input for test \""+i+"\"");
            int iNoOfInputForTest = scanner.nextInt();
            //System.out.println("No of input to execute "+iNoOfInputForTest);
            int[] inputArray = new int[iNoOfInputForTest];
            for (int j=1;j<=iNoOfInputForTest;j++) {
                inputArray[j-1] = scanner.nextInt();
            }
            //System.out.println("Input Array "+Arrays.toString(inputArray));
            //System.out.println("Find Equilibrium of Data ");
            //System.out.println("Equilibrium is at position "+findEquilibrium(inputArray));
            stickler(inputArray);
        }
    }

    public static void stickler(int[] inputArray) {
        int length = inputArray.length;
        if (length == 1) {
            System.out.println(inputArray[0]);
            return;
        }
        if (length == 2) {
            System.out.println(Math.max(inputArray[0], inputArray[1]));
            return;
        }
        int[] tmp = new int[length];
        tmp[0] = inputArray[0];
        tmp[1] = Math.max(inputArray[0], inputArray[1]);
        for (int i=2; i<length; i++) {
            tmp[i] = Math.max(tmp[i-1], tmp[i-2]+inputArray[i]);
        }
        System.out.println(tmp[length-1]);
    }
}