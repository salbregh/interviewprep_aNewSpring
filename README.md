# Technical interview practive: assignment given by aNewSpring

The technical assignment given by aNewSpring is to be done in Java. This is a practise technical interview provided by Codam. This is my first time writing code in Java.

<!-- add in about anewspring? -->

## Assignment
The current pandemic is of course all over the news these days. Trying to get it under control requires the right information and one of the key pieces of information is how the virus spreads. In order to investigate this,simulations of the spread of the virus are used. 

Your mission, should you choose to accept it, is to build a simulation (using JAVA) that models this spread on a grid of n*n persons. The simulation, running over the course of a number of iterations, or “rounds”, will be based on the simple assumption that the virus spreads through contact between adjacent people. If the number of contacts reaches a certain threshold, a person will become infected. When an infected person is surrounded by more than a certain threshold of infected people, the virus will die out and that person will recover and become uninfected again.


For example, a simulation on an 8x8 grid, with 7 rounds, an infection threshold of 3, a recovery threshold of 6 and 3 infected persons to start with can be run with a command similar to the following:

`java pandemic 8 7 3 6 [<4,7>,<4,8>,<5,8>]`

After a number of rounds the output should be displayed.

> program name: pandemic

> 1st parameter: n * n grid: 8

> 2nd parameter: numer of rounds: 7

> 3rd parameter: infection threshold: 3

> 4th parameter: recovery threshold: 6

> 5th parameter: coordinates infected people: [<4,7>,<4,8>,<5,8>]

## Rules
The spread of the pandemic is covered by a limited set of rules:
- Any person with a number of infected contacts larger than the infection threshold will become infected
- Any infected person with more than the recovery threshold  infected contacts, will recover and become uninfected.
- All others don’t change.
A “contact” is defined as a person that’s directly adjacent to the infected, horizontally, vertically or diagonally (not wrapping around the edges of the grid)

## TO DO
- [ ] how to compile a file in java
- [ ] learn java basics
- [ ] check input validation
- [ ] make a 2d array
- [ ] figure out what algorithm to use, maybe floodfill?
- [ ] write a main to test some cases
- [ ] perfect the code

# JAVA

<!-- https://www.tutorialspoint.com/java/index.htm -->
<!-- https://www.guru99.com/java-platform.html -->
<!-- https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/ -->
<!-- https://www.youtube.com/watch?v=_JYlD7tzwFw -->

#### Compiling java
- `java -version` -- check which version of java is downloaded
- `javac -version` -- check which version of javac is downloaded
- `javac FileName.java` -- the .java file will be translated into .class file
- `java FileName` -- execute the program, you should not append the .java etension to the file name while running the program

#### First program
```java
public class FirstJavaProgram {
    public static void main(String []args) {
        System.out.println("Hello");
    }
}
```

- `public class FirstJavaProgram {` -- Every java application must have at least one class definition that consists of `class` keyword followed by class name. Java can have only one public class, the filename should be the same as the public class name. 
- `public static void main(String []args) {` -- `public` makes the main method public which makes this method callable from outside the class. `static` we dont need to reacte a method for static methods to run. `main` the methods name, this is the entry point method from which the program starts running. `String []args` used for command line argumentsthat are passes as string.
- `System.out.println("Hello");` -- This method prints the contents into the consule and adds a new line.

#### Basic syntax
- Java is case sensitive
- For all class names the first letter of every word should be uppercase `MyClassName`
- All method names should start with lowercase and every inner word with uppercase `myMethodName()`
- Program file name must match the public class name and append .java to it otherwise the program will not compile. In case there is no public class present, the file name can be different than the class name.
- Java program start from the main() method, this is mandatory

#### Objects and classes
- *Object* -- an instance of a class
- *Class* -- a tenplate/blueprint that descibes behavior/state of the object

An objects state is stored in fields and behavior is shown via methods. Methods operate on the internal state of an object and the object-to-object communication is down via methods.

```java
public class TechnicalInterview {
    String  assignment;
    int     days;
    String  company;

    public TechinicalInterview(String name){
        System.out.println("Name is : " + name);
    }
    
    void    calculateDaysLeft(){}
    void    getCompany(){}
}
```

A class can contain:
- *local variables* -- variables defined inside methods, the lifetime of these are within the methods
- *instance variables* -- variables within a class but outside of an method, these can be accessed within all the methods
- *class variables* -- variables declared within the class, outside a method, with static keyword.

##### Constructors
Every class has a constructor (default included), at least one constructor will be invoked when creating an object. The constructor has the same name as the class. 

##### Creating an object
An object is created from a class, the new keyword is used to create a new object. 
- declaration -- a variable declaration with a variable name with an object type
- instantiation -- new keyword is used to create the object
- initialization -- the new keyword is followed by a call to a constructor that initializes the new objct

```java
public static void main(String []args) {
    TechnicalInterview myTechnicalInterview = new TechnicalInterview("java");
}
```

#### Accessing instance variable and methods
Instance variables and methods are accessed via created objects:
- create an object: `Object Reference = new Constructir();`
- call a variable: `ObjectReference.variableName;`
- call a class method: `ObjectReference.method();`

#### Variable types

##### Local variables
- declared in methods, constructors or blocks
- created when the method, constructor or block is entered, and destroyed once this block. constructor or method ends
- only visible within the declared method, block or constructor
- no default value; must be assigned an initial value

##### Instance variables
- 