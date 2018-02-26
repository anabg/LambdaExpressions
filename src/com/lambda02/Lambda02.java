package com.lambda02;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * LAMBDA SINTAX
 *
 *  Let's take a closer look at the lambda syntax. To review the syntax, I want to start with an example. When working with graphical
 *  user interface components, or GUI components such as buttons, lambda expressions will really simplify your code. Here is a sample GUI
 *  program created with JavaFX. It has a button that is displayed with an ActionEventListener that prints "Hello World!" when the button is
 *  clicked. Let's run it. Here's my window with a title of Hello World! When I click on the button, it prints Hello World! to the output window.
 *
 *  Alright, let's close this and close our output window. In Java, anonymous inner classes, which is what we're using here, provide a way to
 *  implement classes that may occur only once in an application. For a fully functional user interface, or UI, a number of event handlers might
 *  be required for keyboard and mouse events. If we do not include this anonymous inner class, a separate class that implements
 *  ActionListener will be required for each event.
 *
 *  As you can see, this approach requires quite a bit of code for a very simple operation. Starting on line 25, we have the btn.setOnAction. This
 *  is where we define what happens with the interface for EventHandler. We have to override the handle method because the EventHandler
 *  interface is an abstract interface. And all we want to do is, when they push the button, print out Hello World! Let's use our new lambda
 *  notation. Lambda expressions let you express instances of single-method classes a lot more concisely.
 *
 *  First, I'm going to comment out the current btn.setOnAction, and that means I have a nice button in the toolbar here that will automatically
 *  comment out whatever I have highlighted. I'm going to scroll down 'cause I already have the code I need here on line 33. Notice I still have
 *  btn.setOnAction, but this time, instead of all that other code, I'm using the lambda notation, which says pass in the event, so whatever the
 *  user is doing, in this case, they're pushing a button, and when the ActionListener receives that event, it will print Hello World! You might have
 *  noticed that there's no return value for this expression.
 *
 *  These types of expressions are called consumer interfaces, as we saw before. Now let's run the program LambdaEventHandler to make
 *  sure it still works the way we expect it. I'm going to right-click on LambdaEventHandler, and then I'm going to choose Run. There's our
 *  window, and when I click on the button, it still says Hello World! Let me close the window and close the output window. Notice we went from
 *  about, I don't know, five lines of code to just one, so as you can see, the lambda syntax simplifies the expression quite a bit.
 *
 *  The syntax of the lambda notation includes an argument list, which may be empty, in this case, was the argument event, an arrow token, and
 *  a body which can contain one statement or a block of statements. In this case, it only had System.out.println("Hello World!"). We are using an
 *  existing interface with this example, but I wanted you to see what the interface looked like. Notice that this interface only has one method.
 *  Do you remember why that's important? Because a functional interface can have only one method.
 *
 *  So lines 35 to 39 is just a comment, but this shows us what the EventHandler interface looks like. Let me scroll down a little bit so we can
 *  see it better. public interface ActionListener extends EventListener. public void actionPerformed(ActionEvent e). As you can see, the method
 *  actionPerformed is expecting to receive an event. That's why we passed it the event. Then we use the System.out.println as the code for our
 *  actionPerformed method.
 *
 *  As I stated, lambda expressions can have zero, one, or more arguments. You might be wondering, what does the syntax of a lambda
 *  expression with zero arguments look like? It simply has a set of parentheses with no values. Let me switch over to the other program inside
 *  this package, and I'm going to scroll down a little bit. If you've ever written programs that involve threads, you're familiar with the concept of a
 *  Runnable interface. If you want to learn more about threads, check out my series on managing threads in Java. The Runnable interface does
 *  not take any arguments, and we can use lambda notation to help us write the inner class needed to implement this interface.
 *
 *  On lines 22 through 27, I'm using the old style of creating an anonymous inner class. One interesting note is you see that little light bulb,
 *  meaning that there is something that NetBeans is trying to tell me? If I mouse over that, it tells me that the anonymous inner class creation
 *  can be turned into a lambda expression. So even NetBeans knows now with Java 8, that we can change this to be a lambda expression. On
 *  line 30 is the new version of implementing that inner class using Runnable r2 equals.
 *
 *  Open and close parentheses to indicate no arguments, and we're printing out run 2. On lines 33 and 34, we start r1 and r2 by using r1.run,
 *  r2.run, and that'll initiate those methods. Let me scroll down a little further. I have some additional examples so you can see some more
 *  lambda syntax. On line 37 is the BiFunction interface, which has angle brackets with three string values inside. This indicate the two values
 *  that are coming in are going to be strings, and the return value will be a string.
 *
 *  On the right-hand side is what we call our lambda notation: parentheses around the two arguments, a comma b, our arrow notation, and then
 *  a plus b. When you use a plus b and you have strings, it puts them together. I use the concat.apply to put together Today is a great day. On
 *  line 42, I'm showing a consumer interface. In this case, we're passing in a name and printing out hello with that name.
 *
 *  This is a little bit different because on line 43, I'm actually going to use a string of names. What'll happen is I have it set up so that string name
 *  is going to take each name in the Arrays.asList, Duke, Mickey, and Minnie, and then it'll invoke the hello.accept(name), which'll print out Hello,
 *  Duke; Hello, Mickey; and Hello, Minnie. And finally, on line 48, we have an example of passing one value. We have GreetingFunction
 *  greeting is equal to message.
 *
 *  message is the one parameter that's getting passed, and the function is actually that on line 49, System.out.println, I'm printing out Java
 *  Programming plus the message. On line 50, I'm using greeting.sayMessage, and I pass in a message. Notice on line 52, we're actually
 *  creating the functional interface called GreetingFunction. I wanted to show you how you can create your own interface, as well as use the
 *  existing ones in the java.util.function. Now if I run this program, you'll see the first two threads print out run 1 and run 2, then we have the
 *  concat, which says Today is a great day, then we have the three hello messages, and finally, Java Programming Rocks with lambda
 *  expressions.
 *
 *  I hope these examples are starting to make sense as far as the syntax of a lambda notation. So you have your argument, your arrow, and
 *  then on the right-hand side, the body.
 *
 * Created by æBelu on 25/2/2018.
 */
public class Lambda02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Anonymous Inner Class: Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1");
            }
        };

        // Lambda version of Runnable (no arguments)
        Runnable r2 = () -> System.out.println("run 2");

        // Start both threads
        r1.run();
        r2.run();

        //using an existing functional interface BiFunction
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        String sentence = concat.apply("Today is ", "a great day");
        System.out.println(sentence);

        //example of the Consumer functional interface
        Consumer<String> hello = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
            hello.accept(name);
        }

        //example of passing one value
        GreetingFunction greeting = message ->
                System.out.println("Java Programming " + message);
        greeting.sayMessage("Rocks with lambda expressions");
    }
    //custom functional interface
    @FunctionalInterface
    interface GreetingFunction {
        void sayMessage(String message);
    }
}
