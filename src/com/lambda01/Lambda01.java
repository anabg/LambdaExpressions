package com.lambda01;

import java.util.function.*;

/**
 * FUNCTIONAL INTERFACES
 *
 *  Java It's considered an object oriented programming language but with Java 8, we do have functional interfaces. With the introduction
 *  of Java 8, Oracle added two new packages, the java.util.function and the java.util.stream. The lambda expressions, also introduced with Java 8,
 *  use both of these new packages.
 *
 *  Let's start with the definition of functional interface. It is defined as an interface that contains only one abstract function or method. Functional
 *  interfaces can represent abstract concepts such as functions, actions or predicates. To see a list of all the functional interfaces available, check out
 *  the Javadoc for java.util.function.
 *
 *  Some of the more commonly used interfaces include Predicate. Predicates are Boolean valued functions of one argument meaning they
 *  take in one argument, use a test method to evaluate it and return either true or false. Since this is an interface, we will have to override the
 *  test method with logic that determines what should be evaluated. Next, we have Consumer. The Consumer interface consumes the argument. It accepts a
 *  single argument and does not return a result.
 *
 *  Then we have Function which transforms a value from one type to another. It accepts one argument and produces a result. Supplier supplies
 *  a value. It produces a result of a given type. Unlike Functions, Suppliers do not accept arguments but they do return a result. UnaryOperator
 *  interface takes a single argument and returns a single value and the BinaryOperator interface takes two arguments and returns one.
 *
 *
 *
 *  I'm using the Predicate interface. As you can see, in the angle brackets after the word Predicate I'm forming the interface to expect a string.
 *  It has a name of stringLen and it's equal to on the right hand side is where implementing my method.
 *
 *  I'm used lambda notation so it might look a little different than what you're used to. On the right hand side in parentheses, I list either no
 *  arguments, a single argument or multiple arguments. For Predicate, I need to pass in a single argument then I have the arrow which is a
 *  hyphen and a greater than sign. Make sure those two are together. If you put a space between, the compiler will not know what you mean.
 *  After that, I have the logic of my Predicate. So in this case, I'm saying if the string.length or the length of the string is less than 10, return true.
 *
 *  Otherwise, return false. For each of my examples, I print out the result. So line 18 is calling stringLen.test with the value Apples and it'll print
 *  out true or false. Line 21, I'm using the Consumer interface. Remember, the Consumer interface accepts a value but does not return anything.
 *  So on the right hand side, I'm passing it, the argument s but the actual method itself is just going to print out that value in all lowercase
 *  letters. It doesn't return anything.
 *
 *  I have a Function interface which has two values in the angle brackets. The Function interface, the first value represents the
 *  value coming in for the argument and the second value represents the return value. So in this case, I'm passing in an integer and I'm going to
 *  return a string. The logic that I use to do that is on the right hand side of the arrow that says integer.toString num where num is my argument.
 *  On line 26, I'm going to pass in a value of 26 which gets converted to a string which will just be the characters two and six which will have a
 *  length of two.
 *
 *  Line 29 is my Supplier interface. Remember, the Supplier does not contain any arguments. That's why I have the open and closed
 *  parentheses with nothing inside. It's important to make sure that you understand you have to include the empty argument list. Otherwise, the
 *  compiler will think you made a mistake. So we have an empty argument list, our arrow and on the right hand side, I have a string that says
 *  Java is fun. Line 30 uses the get method which is the functional method for Supplier to get the value of the string and I have that inside of a
 *  print line statement so it'll print it out.
 *
 *  The last two, the BinaryOperator and the UnaryOperator. The BinaryOperator on line 33 is going to return an integer.
 *  On the right hand side, you can see it expects two values, a and b. It's going to then add them together and return those values.
 *  Now it is so far that none of my arguments have their data types explicitly mentioned. That's because when we're using lambda notation, it is
 *  inferred. So since the BinaryOperator is returning an integer, it knows that the two values coming in as arguments, a and b, must also be
 *  integers.
 *
 *  On line 34, I'm using the apply method of the BinaryOperator to add 10 and 25. Line 37, the UnaryOperator is going to return a string. It takes
 *  in a string, msg, the message, and it converts it to uppercase. On line 38, I'm going to print that out using the UnaryOperator method apply.
 *  Let's run the program so you can see how it works. In the Output window, the first was the Predicate which returned true that the string
 *  Apples is less than 10 characters.
 *
 *  Next, I used the Consume interface to take in a series of letters representing the alphabet in all upper and lowercase letters mixed. It used
 *  the two lower to print it back out in all lowercase followed by the Function interface which took in an integer, 26, converted it to a string of
 *  two characters, two and six and then found the length of that string which was two. The Supplier actually supplied the string, Java is fun. So
 *  you can see in line 30 right above, I'm using the s.get.
 *
 *  It gets the value, Java is fun and prints it to the command line followed by the BinaryOperator which took 10 and 25, added them together
 *  and gave us 35 and the last one was the UnaryOperator that took in a message that was in mixed case and returned that message in all
 *  uppercase. So these are a few of the more commonly used functional interfaces available with Java 8. Remember, there are a lot more that
 *  you can use so don't forget to check out that Javadoc on java.util.function.
 *
 * Created by ÊBelu on 25/2/2018.
 */
public class Lambda01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //using the test method of Predicate
        Predicate<String> stringLen  = (s)-> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        //Consumer example uses accept method
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

        //Function example
        Function<Integer,String> converter = (num)-> Integer.toString(num);
        System.out.println("length of 26: " + converter.apply(26).length());

        //Supplier example
        Supplier<String> s  = ()-> "Java is fun";
        System.out.println(s.get());

        //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));

        //Unary Operator example
        UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
    }
}
