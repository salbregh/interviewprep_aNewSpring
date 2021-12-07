# Virus spread simulation
Technical interview practise, an assignment given by aNewSpring

The assignment given by aNewSpring is to be coded in Java. This is a practise technical interview simulation provided by Codam. This is my first time writing code in Java, so it might be a bit messy :innocent:.
<!-- add in about anewspring? -->

## Assignment
The current pandemic is of course all over the news these days. Trying to get it under control requires the right information and one of the key pieces of information is how the virus spreads. In order to investigate this, simulations of the spread of the virus are used. 

Your mission, should you choose to accept it, is to build a simulation (using JAVA) that models this spread on a grid of n*n persons. The simulation, running over the course of a number of iterations, or “rounds”, will be based on the simple assumption that the virus spreads through contact between adjacent people. If the number of contacts reaches a certain threshold, a person will become infected. When an infected person is surrounded by more than a certain threshold of infected people, the virus will die out and that person will recover and become uninfected again.


For example, a simulation on an 8x8 grid, with 7 rounds, an infection threshold of 3, a recovery threshold of 6 and 3 infected persons to start with can be run with a command similar to the following:

`java pandemic 8 7 3 6 [<4,7>,<4,8>,<5,8>]`

After a number of rounds the output should be displayed.

> program name: pandemic

> 1st parameter: n * n grid: `8`

> 2nd parameter: numer of rounds: `7`

> 3rd parameter: infection threshold: `3`

> 4th parameter: recovery threshold: `6`

> 5th parameter: coordinates infected people: `[<4,7>,<4,8>,<5,8>]`

#### How I will handle the input
Seeing I can't figure out how to read the coordinates as argmuments I choose to add double quotes to the last argument so that I am able to parse through it as a string `"[<4,7>,<4,8>,<5,8>]"`.
So the input I will be working with will be : `java pandemic 8 7 3 6 "[<4,7>,<4,8>,<5,8>]"`

###### Error checking on the given input
The program will exit if:
- An incorrect amount of arguments is passed.
- An argument is passed as 0 or negative. 
- An coordinate is outside of the grid.


## Rules
The spread of the pandemic is covered by a limited set of rules:
- Any person with a number of infected contacts larger than the infection threshold will become infected
- Any infected person with more than the recovery threshold  infected contacts, will recover and become uninfected.
- All others don’t change.
A “contact” is defined as a person that’s directly adjacent to the infected, horizontally, vertically or diagonally (not wrapping around the edges of the grid)

## TO DO
- [x] how to compile a file in java
- [x] learn java basics
- [x] check input validation
- [x] make a 2d array
- [ ] how to check for contacts
- [ ] write a main to test some cases
- [ ] add in a makefile
- [ ] scripts that will runs tests

# JAVA

#### Compiling java
- `java -version` -- check which version of java is downloaded
- `javac -version` -- check which version of javac is downloaded
- `javac FileName.java` -- the .java file will be translated into .class file
- `java FileName` -- execute the program, you should not append the .java etension to the file name while running the program

- on my laptop I had to `brew install openjdk`, following `brew info openjdk` and run the command `sudo ln -sfn /usr/local/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk` to symlink, to get the javac command working.

#### First program
```java
public class FirstJavaProgram {
    public static void main(String []args) {
        System.out.println("VIRUS SPREAD");
    }
}
```

- `public class FirstJavaProgram {` -- Every java application must have at least one class definition that consists of `class` keyword followed by class name. Java can have only one public class, the filename should be the same as the public class name. 
- `public static void main(String []args) {` -- `public` makes the main method public which makes this method callable from outside the class. `static` we dont need to reacte a method for static methods to run. `main` the methods name, this is the entry point method from which the program starts running. `String []args` used for command line arguments that are passes as  string.
- `System.out.println("Hello");` -- This method prints the contents into the consule and adds a new line.

#### Basic syntax
- Java is case sensitive
- For all class names the first letter of every word should be uppercase `MyClassName`
- All method names should start with lowercase and every inner word with uppercase `myMethodName()`
- Program file name must match the public class name and append .java to it otherwise the program will not compile. In case there is no public class present, the file name can be different than the class name.
- Java program start from the main() method, this is mandatory




<!-- CONTINUE HERE -->
<!-- https://www.tutorialspoint.com/java/java_variable_types.htm -->

<!-- https://www.tutorialspoint.com/java/index.htm -->
<!-- https://www.guru99.com/java-platform.html -->
<!-- https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/ -->
<!-- https://www.youtube.com/watch?v=_JYlD7tzwFw -->
<!-- https://www.w3schools.com/java/java_methods.asp -->