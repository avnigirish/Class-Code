import java.awt.Color;
import edu.princeton.cs.algs4.*;
public class DrunkenTurtles {
    //client program
    public static void main (String[]args){
        StdOut.print("Enter the sanctuary number of turtles: ");
        int numberOfTurtles = StdIn.readInt();

        StdOut.print("Enter the number of steps for the turtles to take: ");
        int numberOfSteps = StdIn.readInt();

        StdOut.print("Enter the step size for the turtles (all turtles are of the same size): ");
        double stepSize = StdIn.readDouble();

        //allocate enough space to hold all numberOfTurtles turltes
        Turtle[] turtles = new Turtle[numberOfTurtles];

        //instantiate the turtles object
        // each turtle is one object, each turtle is on one array index
        //Running time
        //  tilde notation: ~t
        //  big O notation: O(t)
        for (int x=0; x<turtles.length; x++){
            //position
            double randX = StdRandom.uniformDouble(0.0,1.0);
            double randY = StdRandom.uniformDouble(0.0,1.0);
            
            //color
            int red = StdRandom.uniformInt(256);
            int green = StdRandom.uniformInt(256);
            int blue = StdRandom.uniformInt(256);

            //instantiate the turtle object - object of type turtle
            turtles[x] = new Turtle(randX, randY, 0.0, new Color(red, green, blue));
        }

        StdDraw.setXscale(-1,5);
        StdDraw.setYscale(-1,5);


        //Running time
        //  tilde notation: ~2ts
        //  big O notation: O(ts)
        for(int s = 1; s<=numberOfSteps; s++){
            //make each turtle take one step at a time for a total of numberOfSteps
            //traverse the entire to:
            //1. make each turtle tur left by a random angle
            //2. make each turtle take 1 step
            for (int x=0; x<turtles.length; x++){
                double angle = StdRandom.uniformDouble(0.0, 361.0);
                turtles[x].turnLeft(angle);
                turtles[x].moveForward(stepSize);
            }
        } 

    }
}
