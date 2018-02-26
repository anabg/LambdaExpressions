package com.lambda06;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


/**
 * STREAMS
 *
 * The new stream package. The java.util.stream package contains the majority of the interfaces and classes for the stream
 * functionality. I feel it's important to mention that this new package is not related at all to the Java IO streams. This was a little confusing to me
 * at first. A stream in this case represents a sequence of elements. The stream package was added in Java 8 specifically to help traverse
 * collections. Most stream operations accept some kind of lambda expression parameter which is a functional interface specifying the exact
 * behavior of the operation.
 *
 * Stream operations are categorized as either intermediate or terminal. Terminal operations are either void or return a result of a certain type
 * where intermediate operations return the stream itself. Intermediate operations are useful to allow us to chain multiple method calls in a row
 * on a single stream. Some of the commonly used operations include map, filter and forEach where map and filter are intermediate operations.
 *
 * They allow us to map one value to another or to filter the results using a Predicate. The forEach is a terminal operator. Two more commonly
 * used operations are sorted and collect. These are also very helpful. Sorted is an intermediate operation which returns a sorted view of the
 * stream but remember, the original collection is not being changed. Collect is an extremely useful terminal operation to transform the
 * elements of a stream into a different kind of result.
 *
 * Remember, elements in a collection cannot be changed or mutated with streams but you can save them to a new collection if that's what you
 * need. Let's take a look at some examples in NetBeans. In your Exercise Files folder Chapter 2 0202, I have a sample program that shows a
 * little bit of the stream capability. Let's walk through the examples starting on line 23. On line 23, I'm using Arrays.asList to create a list that
 * includes three strings, red, green and blue.
 *
 * On line 24, I'm using the .stream to create a stream of those three strings. Line 25, I'm using the sorted operation to sort them. Line 26, I'm
 * using findFirst. So which value will it find? Will it find red or will it find blue? If you said blue, you're correct 'cause remember, the stream is
 * going sequentially through these operations. So it sorted it first. Now, it's going to find the first element which will be blue and then on line
 * 27, I'm going to actually print that out.
 *
 * The next example starts on line 30. Line 30 says Stream.of. This is another way to create a collection using a stream. In this case, I have five
 * different fruits, apple, pear, banana, cherry and apricot. I wanted to use the intermediate filter operation. On line 31, I used .filter and you can
 * see, here's out lambda expression. I take each fruit which is going to represent a string and I return fruit.startsWith a.
 *
 * On line 37, I'm using the terminal operator .forEach which is going to take in the fruit that starts with an a because I used the filter to get rid
 * of everything else and it's going to print out the fruits that start with a. I am going to point out I do have a comment here that we'll take a look at.
 * It says, if the forEach is removed, 'cause remember, the forEach is a terminal operation, if that happens, nothing will get printed. The forEach
 * makes it a terminal operation so the code actually invokes the filter and then the forEach.
 *
 * Otherwise, it will skip over the filter operation. And finally, on line 40, I have another string collection that contains two strings, Java and
 * Rocks. On line 41, I'm mapping those strings to all uppercase. Again, there's another lambda notation in the .map operation. On line 42, I
 * used the .collect which is a terminal operator to allow me to retain whatever values came into the .map operation.
 *
 * In this case, I am creating a new collection called collected and I'm printing that out on line 43. Let's run this program and see what the
 * results look like. Okay, we got blue like we expected. It prints out the two values of fruits that start with the letter a and then my new
 * collection contains both Java and Rocks with all capital letters. I'm going to close the Output window and let's see what would happen if I did
 * not include the terminal forEach. So I'm going to comment that out and I'm going to stop the Stream.of right here.
 *
 * Now, if I run it again, notice I don't get any of the fruit that starts with a because that particular section of code does not have a terminal
 * operator. Alright, let's close the Output window again and let's put this back to the way it was and there is one more thing that I wanted to
 * show you. On line 32, I added a System.out.printline. Let me uncomment that. I want to show you the order in which these operations
 * process the list.
 *
 *In this case, we have a list, apple, pear, banana, cherry, apricot. It goes to the filter operation and now, what I'm going to do is I'm going to
 * actually print out the word filter with the fruit name before I identify which ones start with a. Let's see what happens when I run it with that
 * print statement. Okay, we still have blue but now, notice it says filter apple and then it says starts with a apple. So what happened was it went
 * through the whole process with apple and printed out the results along the way.
 *
 * Next, it went to pear but pear does not start with a so it didn't get to the forEach then it went to banana, cherry and then when it got to
 * apricot, it actually printed out starts with a apricot. So it's important to notice how each value goes through only one time. It's not going to
 * search through the entire list looking for fruit that start with a and then go through and print them out. It's actually going to go through one,
 * find the ones with a and pass them on to the forEach.
 *
 * These are just a few examples of this powerful new feature that allows us to work with collections by using stream operations.
 *
 *
 * Created by æBelu on 25/2/2018.
 */
public class Lambda06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arrays.asList("red", "green", "blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //example of Stream.of with a filter
        Stream.of("apple", "pear", "banana", "cherry", "apricot")
                .filter(fruit -> {
                    //  System.out.println("filter: " + fruit);
                    return fruit.startsWith("a"); //predicate
                })
                        //if the foreach is removed, nothing will print,
                        //the foreach makes it a terminal event
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        //using a stream and map operation to create a list of words in caps
        List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(toList());
        System.out.println(collected.toString());




    }
}
