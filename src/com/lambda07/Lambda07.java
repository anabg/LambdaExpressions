package com.lambda07;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 *
 * PRIMITIVE STREAMS
 *
 * In Java 8, in addition to the streams that we mentioned earlier, it also includes special streams for some of the primitive data
 * types, specifically int, long, and double. They are int stream, long stream, and double stream. In your exercise files folder, under Ch02,
 * 02_03, I have a sample program that shows some of these functionalities. Primitive streams use specialized lambda expressions as well. We
 * have, for example, int function instead of function, or int predicate instead of predicate.
 *
 * And primitive streams support the additional terminal operations of sum and average. Let's walk through these examples, and then we'll run
 * the program to see how it works. On line 22, I'm using the new int stream. I'm using a .range to get the values from one to four, but not
 * inclusive of the four. So it'd only get the values one, two, and three. On line 23, I'm using the terminal for each operator, which'll print out
 * those values. On line 26, I wanted to show you some of those aggregate operations that are available with these primitive data types, the
 * .average.
 *
 * So on line 26, I create arrays.stream, and I create a new int array that has four values. Line 27, I'm showing how you can use the .map,
 * which'll take each value, and it'll actually put back into the stream that value squared. On line 28, I'm going to use the .average, which'll add
 * up all my new values in the stream, and in this case divide them by four, since there's four elements. And on line 29, I'm using the .ifPresent
 * to print out the results.
 *
 * On line 32, I'm creating a stream that includes doubles. So I use stream.of, and since there's three double values in the parentheses, I am
 * getting a double stream. On line 33, I have .map to int. I can take a double and convert it to an int. And then on line 34, I'm printing out the
 * results. What do you think's going to happen to the integer values 1.5, 2.3, and 3.7? Will they round up? Will they round down? Or will it
 * truncate? Just like in most Java operations, if you take a double and you cast it as an int, it truncates the decimal portion.
 *
 * So in our case, I'll only get the numbers one, two, and three. All right, let's go ahead and run the program, and see the results. The first set of
 * numbers, one, two, and three, is from the int stream .range. Next, we have 7.5, which is the average of adding one squared plus two squared
 * plus three squared plus four squared. And then, finally, if I scroll down in the top window, we can see that the stream of doubles, the double
 * stream, when I mapped it to int, it took the double value and converted it to an int value, and it did truncate, as we thought.
 *
 * And then the four each printed out.
 *
 *
 * Created by æBelu on 25/2/2018.
 */
    public class Lambda07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntStream.range(1, 4)
                .forEach(System.out::println);

        //find the average of the numbers squared
        Arrays.stream(new int[]{1, 2, 3, 4})
                .map(n -> n * n)
                .average()
                .ifPresent(System.out::println);

        //map doubles to ints
        Stream.of(1.5, 2.3, 3.7)
                .mapToInt(Double::intValue)
                .forEach(System.out::println);
    }
}
