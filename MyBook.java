

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyBook {
    // Member variables
    private String name;
    private String author;
    private double price;
    private int numPages;

    // Constructor to initialize the book details
    public MyBook(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return numPages;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String toString() {
        return "Book Name: " + name +
               ", Author: " + author +
               ", Price: $" + price +
               ", Number of Pages: " + numPages;
    }
}



public class MyBookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MyBook> books = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int num = sc.nextInt();
        sc.nextLine(); // Consume the newline

        for (int i = 0; i < num; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            
            System.out.print("Author: ");
            String author = sc.nextLine();
            
            System.out.print("Price: ");
            double price = sc.nextDouble();
            
            System.out.print("Number of Pages: ");
            int numPages = sc.nextInt();
            sc.nextLine(); // Consume the newline

            MyBook book = new MyBook(name, author, price, numPages);
            books.add(book);
        }

        System.out.println("\nBook Details:");
        for (MyBook book : books) {
            System.out.println(book);
        }

        sc.close();
    }
}
