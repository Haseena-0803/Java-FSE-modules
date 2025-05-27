# Hello World Program

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

# Simple Calculator

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);
        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }
        System.out.println("Result: " + result);
    }
}

# Even or Odd Checker

import java.util.Scanner;

public class EvenOrOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}

# Leap Year Checker

import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}

# Multiplication Table

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}

# Data Type Demonstration

public class DataTypeDemonstration {
    public static void main(String[] args) {
        int intValue = 10;
        float floatValue = 10.5f;
        double doubleValue = 20.99;
        char charValue = 'A';
        boolean booleanValue = true;

        System.out.println("Integer: " + intValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Character: " + charValue);
        System.out.println("Boolean: " + booleanValue);
    }
}

# Type Casting Example

public class TypeCastingExample {
    public static void main(String[] args) {
        double doubleValue = 9.78;
        int intValue = (int) doubleValue;
        System.out.println("Double to Int: " + intValue);
        
        int anotherIntValue = 10;
        double anotherDoubleValue = (double) anotherIntValue;
        System.out.println("Int to Double: " + anotherDoubleValue);
    }
}

# Operator Precedence

public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2: " + result);
    }
}

# Grade Calculator

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        int marks = scanner.nextInt();
        char grade;

        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade: " + grade);
    }
}

# Number Guessing Game

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;
        
        do {
            System.out.print("Guess the number (1-100): ");
            guess = scanner.nextInt();
            if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            }
        } while (guess != numberToGuess);
        
        System.out.println("Congratulations! You've guessed the number.");
    }
}

# Factorial Calculator

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}

# Method Overloading

public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println("Sum of two integers: " + add(5, 10));
        System.out.println("Sum of two doubles: " + add(5.5, 10.5));
        System.out.println("Sum of three integers: " + add(5, 10, 15));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}

# Recursive Fibonacci

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci number at position " + n + " is " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

# Array Sum and Average

import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        double average = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}

# String Reversal

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }
}

# Palindrome Checker

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}

# Class and Object Creation

public class Car {
    String make;
    String model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Car Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2021);
        car1.displayDetails();
        car2.displayDetails();
    }
}

# Inheritance Example

class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.makeSound();
        dog.makeSound();
    }
}

# Interface Implementation

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Playing guitar");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing piano");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}

# Try-Catch Example

import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

# Custom Exception

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older.");
            }
            System.out.println("Age is valid.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}

# File Writing

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String input = scanner.nextLine();
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}

# File Reading

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}

# ArrayList Example

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;
        
        while (true) {
            System.out.print("Enter a name (or 'exit' to stop): ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            names.add(name);
        }
        System.out.println("Names entered: " + names);
    }
}

# HashMap Example

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;

        while (true) {
            System.out.print("Enter student ID (or -1 to stop): ");
            id = scanner.nextInt();
            if (id == -1) {
                break;
            }
            System.out.print("Enter student name: ");
            name = scanner.next();
            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve name: ");
        int searchId = scanner.nextInt();
        System.out.println("Student Name: " + studentMap.get(searchId));
    }
}

# Thread Creation

class MessageThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Message from thread: " + Thread.currentThread().getName());
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        MessageThread thread1 = new MessageThread();
        MessageThread thread2 = new MessageThread();
        thread1.start();
        thread2.start();
    }
}

# Lambda Expressions

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);
    }
}

# Stream API

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                                            .filter(n -> n % 2 == 0)
                                            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
    }
}

# Records

public record Person(String name, int age) {}

import java.util.ArrayList;
import java.util.List;

public class RecordsExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.forEach(person -> System.out.println(person));
    }
}

# Pattern Matching for switch

public class PatternMatching {
    public static void main(String[] args) {
        Object obj = "Hello";
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }
}

# Basic JDBC Connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

# Insert and Update Operations in JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertUpdateJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, "John Doe");
                preparedStatement.setInt(2, 20);
                preparedStatement.executeUpdate();
            }

            String updateSQL = "UPDATE students SET age = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setInt(1, 21);
                preparedStatement.setString(2, "John Doe");
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

# Transaction Handling in JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandlingJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);
            try {
                String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
                try (PreparedStatement debitStatement = connection.prepareStatement(debitSQL)) {
                    debitStatement.setDouble(1, 100);
                    debitStatement.setInt(2, 1);
                    debitStatement.executeUpdate();
                }

                String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
                try (PreparedStatement creditStatement = connection.prepareStatement(creditSQL)) {
                    creditStatement.setDouble(1, 100);
                    creditStatement.setInt(2, 2);
                    creditStatement.executeUpdate();
                }
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

# Create and Use Java Modules

module com.greetings {
    exports com.greetings;
}

module com.utils {
    exports com.utils;
}

# TCP Client-Server Chat

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                output.println("Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

# HTTP Client API (Java 11+)

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}

# Using javap to Inspect Bytecode

// Create a class with a method and compile it, then run javap -c ClassName in terminal.

# Decompile a Class File

// Write a simple Java program, compile it, and open the .class file in a decompiler.

# Reflection in Java

import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

# Virtual Threads (Java 21)

public class VirtualThreadsExample {
    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread!");
            });
        }
    }
}

# Executor Service and Callable

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });
        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(1000);
            return 2;
        });

        System.out.println("Result: " + (future1.get() + future2.get()));
        executor.shutdown();
    }
}
