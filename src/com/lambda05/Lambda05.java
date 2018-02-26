package com.lambda05;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 *
 * COLLECTIONS
 *
 *
 * Since collections are used so heavily in Java 8 lambda notation, I wanted to do a quick review. The Collections API was
 * introduced with Java 7. A collection is an object that groups multiple elements into a single unit. Collections are used to store, retrieve,
 * manipulate, and communicate aggregate data. The collections API provides the following interfaces, set, which is a collection that does not
 * contain duplicates, list, which is just an ordered collection based on the way the user entered the data, map is an object that maps keys to
 * values.
 *
 * The collection interface contains methods that perform basic operations such as int size, which gets the size of the collection. boolean
 * isEmpty returns true if it's empty, false if it's not. boolean contains checks to see if an element is inside the collection, returning true if it is and
 * false if not, and add an element returns true if it was able to add the element, or false if there was an error. We also have boolean remove,
 * which tries to remove an element.
 *
 * If the element is not found, it returns false. If it successfully removes it, it'll return true. And finally, Iterator<E> iterator(), it returns an iterator
 * over the elements in this collection. Now let's switch to NetBeans and review some examples of collections. In your Exercise Files folder
 * under chapter two 02-01 I have a program that lists some collections. I'm going to start by using collections and not using the lambda
 * notation, then I'm going to show how the lambda notations can simplify our code.
 *
 * On line 26 I create a list of names. I have List<String> names = Arrays.asList, and I have four names in my list. In order to sort those, prior to
 * using the Java 8 lambdas, we could say Collections.sort and provide the variable names, comma, new Comperator<String>, and then we'd
 * have to override the collections interface, the method compare, to tell it how to do the compare.
 *
 * On line 35 I have the next iteration which uses lambda, but it's still not quite the most concise. In this case I have Collections.sort (names,
 * string a, string b, and then I have my arrow and it says that in order to sort return b.compareTo(a). On line 40 is the best version of this code
 * using lambda notation. Let me scroll down a little bit. Remember we don't have to specify the data types in the lambda notation because it
 * can be inferred since there is only one method inside the Collections interface.
 *
 * In this case the sort method takes in a list called names, it takes in two values, a and b, and compares b to a, returning them in the right
 * order. All right, next I wanted to show you how we could do a book collection. So I've created three random books here. I do have a Book
 * class, so let's take a quick look at that. In my Book class I have the title of the book, the author's first name, last name, and the number of
 * pages. I try to keep it really simple. I have a constructor that takes all the values and then I have all my get and set methods.
 *
 * Let me go back over to Lambdas_02_01. So on lines 43 to 47 I'm just creating three books, Miss Peregrine's Home for Peculiar Children,
 * Harry Potter and the Sorcerers Stone, and The Cat in the Hat. What I wanted to show you is how I can put these books into a list on line 51.
 * Let me spell collect correctly, there we go, and here I have a list called books = Arrays.asList and I'm adding the three books that I created
 * above.
 *
 * On line 52 I wanted to show you how we could use the .collect. So the .collect uses the Collections, so it uses Collectors.summingInt and it
 * uses the getPages method of the Book class to get the number of pages. It adds them all together and puts them into the variable total and
 * then prints them out. Let me scroll down to the next example. On line 58 I am creating another list = books.stream, I'm using the .map to get
 * the last name of the author.
 *
 * Notice I'm using our method reference that we talked about earlier, the ::, line 60 I'm using the .collect again, this time instead of adding
 * together the values of an integer variable as getPages, this time I'm putting a list together of the authors' last names and then I'm printing out
 * the list on line 61. The next example creates a list that has duplicate books. So on the right hand side I just added book one and book two in
 * a second time.
 *
 * I'm printing them out so we can see what it looks like before we eliminate the duplicates. Then on line 69 I'm creating a new collection and
 * this time I'm using a HashSet. Remember, the set interface will automatically eliminate duplicates, so on line 71 I'm printing out this new list of
 * books. Finally, I wanted to show you how we could use the set interface, and this time I'm also using HashSet, I'm providing a list that has
 * several numbers, and many of them are repeated.
 *
 * What will happen is it will actually take the values in the list and it will eliminate all the duplicates and then print it out. Let's run the program to
 * take a look. I'm going to scroll up to the top of my output window. At the very top, remember we added up the total pages of all the books?
 * Next we use the .collect to collect the last names of the authors and printed those out, so we have Riggs, Rowling, and Seuss. Next I print
 * out the names of the books and the authors for each of the books in our list.
 *
 * Notice Miss Peregrine's Home for Peculiar Children appears two times, and so does Harry Potter and the Sorcerer's Stone. Then when I
 * created the set using the exact same list, notice this time it removes the duplicates, because the set interface does not allow duplicates. And
 * finally, the very last thing I did was use a list that had the numbers 4, 3, 3, 3, 2, 1, 1, 1, and when I used the set interface, it automatically
 * removes duplicates and puts them in sorted order.
 *
 * In JDK 8 and later, the preferred method of iterating over a collection is to obtain a stream and perform aggregate operations on that.
 * Aggregate operations are often used in conjunction with lambda operations to make programming more expressive and using less lines of
 * code. For more information on collections, check out the Oracle tutorial here at https://docs.oracle.com/javase/tutorial
 * /collections/interfaces/collection.html
 *
 * Created by ÊBelu on 25/2/2018.
 */
public class Lambda05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");
        //way to sort prior to Java 8 lambdas
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));


        //total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);

        List<Book> books = Arrays.asList(book1, book2, book3);
        int total = books.stream()
                .collect(Collectors.summingInt(Book::getPages));
        System.out.println(total);

        //create a list with duplicates
        List<Book> dupBooks = Arrays.asList(book1, book2, book3, book1, book2);
        System.out.println("Before removing duplicates: ");
        System.out.println(dupBooks.toString());

        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates: ");
        System.out.println(noDups.toString());


        //aggregate author first names into a list
        List<String> list = books.stream()
                .map(Book::getAuthorLName)
                .collect(Collectors.toList());
        System.out.println(list);

        //example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 3, 3, 2, 1, 1, 1));
        System.out.println(numbers.toString());


    }
}
