/*
Algorithm to extract digits of integer number and store it in Linked List.
*/
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        int x = -1459121; //user input
        extract(x);
    }

    public static void extract(int x) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        //extract digits of positive numbers
        if (x > 0) {
            while (x > 0) {
                stack.push(x % 10);
                x = x / 10;
            }
        }
        else {
            int remainder;
            while (x <= -1) {
            	//mod the negative number
                remainder = x % 10; 

                //add 10 to get correct remainder
                remainder = remainder + 10; 

                /*subtract to get the right most digit. 
                this is necessary for negative numbers*/
                remainder = 10 - remainder; 

                if ((x / 10) <= -1) {
                	//push right most digit to stack
                    stack.push(remainder); 
                }
                else {
                	//if the final left most digit is reached, make it negative
                    stack.push((-1) * remainder); 
                }
                
                x = x / 10;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
