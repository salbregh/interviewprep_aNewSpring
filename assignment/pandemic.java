import java.util.*;

public class pandemic {

/*
**	if the grid is only 2 by 2 a person has a maximum of 3 neighbors
**	if the grid is bigger a person can have a maximum of 8 neighbors
**	in both these cases this will be seen as invalid input 
**	seeing that no one will be infected.
*/

static int inputCheck(int grid, int rounds, int infection_threshold, int recovery_threshold) {
	if (grid < 2 || rounds < 1 || infection_threshold < 1 || recovery_threshold < 1 ||
		(infection_threshold > 3 && grid <= 2) || infection_threshold > 8 || recovery_threshold > 8) {
		System.out.println("Invalid input.");
		System.exit(0);
	}
	return (0);
}

/*
**	Creates a 2D array with the coordinates added in.
*/

static int[][] 	createGrid(int grid, LinkedList<Integer> coordinatesArray) {
	int[][]	array = new int[grid][grid];
	for (int i = 0; i < grid; i++) {
		for (int j = 0; j < grid; j++) {
			array[i][j] = 0;
		}
	}
	ListIterator<Integer>	it = coordinatesArray.listIterator();
	Integer x = 0;
	Integer y = 0;
	while (it.hasNext()) {
		x = it.next() - 1;
		y = it.next() - 1;
		array[y][x] = 1;
	}
	return (array);
}

/*
**	Function that gets the coordinates out of the string argument given.
**	Also checks if the coordinates are within the given grid, if not
**	an error is returned and the program exits.
*/

static LinkedList<Integer>	getCoordinates(String Coordinates, int grid) {
	Integer				i = 0;
	Integer				numb = 0;
	String				pos = "";
	LinkedList<Integer> coordinatesArray = new LinkedList<Integer>();
	
	while (i < Coordinates.length()) {
		if (Coordinates.charAt(i) >= '0' && Coordinates.charAt(i) <= '9' ) {
			while (Coordinates.charAt(i) >= '0' && Coordinates.charAt(i) <= '9') {
				pos = pos + Coordinates.charAt(i);
				i++;
			}
			numb = Integer.parseInt(String.valueOf(pos));
			if (numb > grid || numb < 1) {
				System.out.println("invalid input");
				System.exit(0);
			}
			coordinatesArray.add(numb);
			pos = "";
		}
		i++;
	}
	return (coordinatesArray);
}

/*
**	Print color functions to visualize the infection spread.
**	0 = not infected: green
**	1 = infected: red
**	2 = newly infected: yellow
**	3 = recovering: white
*/

static void	print(int[][] array, int grid) {
	for (Integer i = 0; i < grid; i++) {
		for (Integer j = 0; j < grid; j++) {
			if (array[i][j] == 0)
				System.out.printf(Colors.GREEN_BACKGROUND + "%s", " 0 " + Colors.RESET);
			if (array[i][j] == 1)
				System.out.printf(Colors.RED_BACKGROUND + "%s", " 1 " + Colors.RESET);
			if (array[i][j] == 2)
				System.out.printf(Colors.YELLOW_BACKGROUND + "%s", " 2 " + Colors.RESET);
			if (array[i][j] == 3)
				System.out.printf(Colors.WHITE_BACKGROUND + "%s", " 3 " + Colors.RESET);
		}
		System.out.println();
	}
}

/*
**	Function that checks all neighbors of every person.
**	If count increases everytime a neighbor is infected, change the persons infection state
**	depended on its state en its number of infected neigbors.
*/

static void infection(int[][] array, int grid, int infection, int recovery, int round) {
	Integer		count = 0;
	
	for (Integer y = 0; y < grid; y++) {
		for (Integer x = 0; x < grid; x++) {
			if (x + 1 < grid && (array[y][x+1] == 1 || array[y][x+1] == 3))	
				count++;
			if (x > 0 && (array[y][x-1] == 1 || array[y][x-1] == 3))
				count++;
			if (y + 1 < grid && (array[y+1][x] == 1 || array[y+1][x] == 3))
				count++;
			if (y > 0 && (array[y-1][x] == 1 || array[y-1][x] == 3))
				count++;
			if (y + 1 < grid && x + 1 < grid && (array[y+1][x+1] == 1 || array[y+1][x+1] == 3))
				count++;
			if (y + 1 < grid && x > 0 && (array[y+1][x-1] == 1 || array[y+1][x-1] == 3))
				count++;
			if (y > 0 && x + 1 < grid && (array[y-1][x+1] == 1 || array[y-1][x+1] == 3))
				count++;
			if (y > 0 && x > 0 && (array[y-1][x-1] == 1 || array[y-1][x-1] == 3))
				count++;

			if (count > infection && array[y][x] == 0)
				array[y][x] = 2;
			else if (count > recovery && array[y][x] == 1)
				array[y][x] = 3;
			count = 0;
		}
	}

	/* UNCOMMENT TO SEE HOW THE VIRUS SPREADS */
	// System.out.println("SEE SPREAD ROUND : " + round);
	// print(array, grid);
	
	for (Integer x = 0; x < grid; x++) {
		for (Integer y = 0; y < grid ; y++) {
			if (array[y][x] == 2)
				array[y][x] = 1;
			if (array[y][x] == 3)
				array[y][x] = 0;
		}
	}

	/* UNCOMMENT TO SEE HOW THE VIRUS SPREADS */
	// System.out.println("SEE OUTCOME SPREAD ROUND: " + round);
	// print(array, grid);
}


public static void main(String[] args) {
	if (args.length != 5) {
		System.out.println("invalid input");
		System.exit(0);
	}
	
    int 	grid = Integer.parseInt(args[0]);
    int 	rounds = Integer.parseInt(args[1]);
    int 	infection_threshold = Integer.parseInt(args[2]);
    int     recovery_threshold = Integer.parseInt(args[3]);
    String  coordinates = args[4];
   
	inputCheck(grid, rounds, infection_threshold, recovery_threshold);

	LinkedList<Integer> coordinatesArray = getCoordinates(coordinates, grid);
	int[][]				array = createGrid(grid, coordinatesArray);

	System.out.println("BEGIN STATE");
	print(array, grid);

	Integer round = 0;
	while (round < rounds) {
		round++;
		infection(array, grid, infection_threshold, recovery_threshold, round);
	}

	System.out.println("FINAL STATE");
	print(array, grid);
}

}