package com.lambda03;


import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * METHODS AS LAMBDAS
 *
 * Another feature of Java 8 is we can now take any type of method and convert it into a lambda including static method, instance
 * methods, and even constructors. I have a sample program open that is available in your exercise files folder, chapter 01, 0103. Take a minute
 * to look at the code. Do you notice any syntax that looks a little different? If you've programmed in C++ before you might recognize this
 * symbol that I'm referring to. Notice on line 28 on the right hand side where the lambda notation would normally be, we have
 * integer::ToString.
 *
 * This is the structure that creates a lambda from a method. It's called a method reference and it enables us to pass references of methods or
 * constructors via the colon colon syntax. Let's walk through each of the examples here. I started by providing an example that does not use
 * the colon colon syntax and then I did the exact same one using that new approach. On line 23 we have the interface int function which is
 * going to return a string and take in an integer.
 *
 * It's a special function in function, we don't have to specify the data type of our argument num because the interface provides enough
 * information to the compiler for it to infer that num is going to be an integer. On the right hand side of our arrow we have integer.twoString
 * which takes num, converts it to a string. On lines 24 and 25 we're printing out the value, intTwoString.apply where apply is the functional
 * method of the int function interface.
 *
 * It'll convert the number, 123, to a string and get the length. And as I stated on line 28 we're using this new method reference, the colon
 * colon. So this time we don't even specify the variable name or the argument on the right hand side. We just have integer::TwoString. Now
 * the compiler is smart enough to know that it should expect an integer and return a string. On line 30 I'm actually going to use the number
 * 4567 which is an integer which will be converted to a string.
 *
 * I'm going to scroll down a little bit. There's a few more examples. On line 33 I'm using the function interface which has two values in the
 * angle brackets. It's saying I'm going to give you a string and I want you to return a big integer. On the right hand side I have an example of
 * how we can use the colon colon with a constructor. So it's saying that whatever string is coming in I'm going to create a new big integer. So
 * I'm going to convert the string value to a big integer.
 *
 * On line 35 we use the dot apply for the function interface and I'm giving it a string that has the values one through nine and it will convert
 * that to an integer. Line 38 is the consumer interface. Remember the consumer interface consumes data but does not return anything.So on
 * line 39 I have print.accept. That is the method name of the functional method for the consumer interface. And I'm giving it the string coming
 * to you directly from a lambda.
 *
 * Now on line 38 in the right hand side notice the print line is an instance method of system.out. It will automatically take in the string, provide it
 * on line 39 and print it to the console. The last example is the unary operator which is going to operate on a string. It has the value
 * hello::concat. The concat is the method that I'm actually going to be using, and again I'm not specifying the fact that I'm going to provide a
 * second string.
 *
 * It can infer that. On line 43 I use the print line statement to print out makegreeting.apply and I have the word Peggy in double quotes to
 * indicate a string, so it'll concat hello with Peggy. Let's run the program and take a look at the output. As you can see the first two, the int
 * functions, both work as we expected. Next we have the interface that took the string, 123456789, and converted it to a big int. Then we used
 * the consumer to pass in a string and print it out coming to you directly from a lambda, and then the last one we used the unary operator to
 * concatinate hello with Peggy.
 *
 * Hello Peggy. As you can see in Java 8 it's starting to make things a little simpler as far as the amount of code that we need to write. In this
 * particular example we were making methods into lambdas whether those methods were static methods, instant methods or even
 * constructors.
 *
 *
 * Created by ÊBelu on 25/2/2018.
 */
public class Lambda03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("expected value 3, actual value: " +
                intToString.apply(123).length());

        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value:  " +
                intToString2.apply(4567).length());

        //lambdas made using a constructor
        Function<String,BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: "+
                newBigInt.apply("123456789"));

        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");

        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("World"));

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));


    }
}
