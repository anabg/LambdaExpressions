package com.lambda04;

/**
 * Although Java 8 has included a new package, java.util.function, that includes many different functional interfaces, sometimes we
 * just need to create our own functional interface. We can create a new functional interface by creating a new file or we can include the
 * functional interface inside of our class file. Either way when creating our own functional interfaces it's helpful to add annotation that says at
 * functional interface to help ensure this is a functional interface. Do you remember how to determine if an interface is actually considered a
 * functional interface? Let's switch over to the interface that I have here called calculate.
 *
 * As you can see on line 10 I have the at functional interface. Now this particular interface has only one method header. If I tried to add a
 * second method header maybe I want to do double calc(double x, double y). Notice the annotation is giving me an error and if you said
 * earlier that a functional interface is an interface that has only one method you're absolutely correct. This says that the calculate is not a
 * functional interface because it has more than one abstract method.
 *
 * So let me get rid of this and put it back to the way I had it and I'll save that and that means I can right click on the package and do New, and I
 * created a new java interface. The only code that I need in here is the name of the interface and then the method header or the method
 * signature. In this case it's on line 12, int calc is the name of my method and it takes two parameters that are both integers. I do need to
 * specify the data types for each value here.
 *
 * The return type and the two arguments. Alright let's go back to our program. In this particular example I am going to show you how you can
 * pass more than one value to a method, in this case a method that we actually created and an interface that we actually created, and the way
 * that this is going to work is that we're going to actually store the lambda operation, the method part of it, in a variable and then use that
 * variable to print out a call to that method where it will actually invoke different mathematical functions.
 *
 * So far I have add, subtract and divide. What we'll do is we'll run it once as it is and then we'll add multiplication. First let's go over the code
 * . So on line 18 I'm using my calculate interface, I created an object called add is equal to and then our lambda expression. We need to take in
 * two variables. Let me just show you I could actually specify the data type if I wanted to but part of the benefit of using lambda notation is the
 * fact that it reduces the amount of typing.
 *
 * So if I don't put int a and int b and just put a and b, the compiler will be able to infer the values of a and b because we have those values
 * specified in the interface. Okay, I have a and b is going to be a plus b. On line 19 the difference is going to find the absolute value of
 * subtracting b from a and in line 20 I have the divide which is going to take a and divide it by b. One thing you want to always keep in mind
 * when you use division is you don't want to divide by zero so the code on the right hand side is an example of using a conditional expression
 * and really what it's saying here is that if b is not equal to zero then the question mark, I divide a divided by b.
 *
 * If b is equal to zero I will skip over that and I will the value that's on the right side of the colon. In this case, a zero. On lines 22 to 24 I'm using
 * system.out.printline, I'm using the objects that I created from the interfaces, add, difference and divide, I'm using the calc method and giving
 * each one the two values. So three plus two will be five, five minus ten will be five because I'm using the absolute value and then twelve
 * divided by three will be four.
 *
 * So let's run it the way it is. And we have five five four as we expected. Okay. Now let's see what happens if I change my divide to 12,0. Again
 * I don't want the divisor to be zero but I handled that in my line 20 where I'm using my conditional if statement. So now I should get 550. And I
 * do. Everything looks good so far. Let's go ahead and add another reference so we can do multiplication.
 *
 * So I'm going to do calculate and I'll just say multiply equals, remember, I have to pass two values, a and b or it could be c and d. Let's do that,
 * let's do c,d. It doesn't really matter what the letters are as long as then I use them on the right hand side. And in order to do multiplication I'm
 * going to do c, asterisk, d, semicolon. Now I need to actually print that out. So we'll do multiply.calc, which is the method that I have.
 *
 * And let's just give it two numbers. We'll give it three and five. Now when I run the program it prints out 550 and 15. This is really nice because
 * my interface is very simple. It simply has the interface name and on line 12 the one method signature. And then using the lambdas I can
 * define that method signature in different ways. Add, difference, divide and multiply.
 *
 * Created by æBelu on 25/2/2018.
 */
public class Lambda04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //example of passing multiple values to a method using lambda
        //notice that I do NOT have to specify the data type of a and b
        Calculate add =(a,b)-> a + b;
        Calculate difference = (a,b) -> Math.abs(a-b);
        Calculate divide =(a,b)-> (b != 0 ? a/b : 0);

        System.out.println(add.calc(3,2));
        System.out.println(difference.calc(5,10));
        System.out.println(divide.calc(5, 0));
    }

}
