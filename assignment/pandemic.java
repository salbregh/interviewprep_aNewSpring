import java.util.*;

public class pandemic {

/*
**	if the grid is only 2 by 2 a person has a maximum of 3 neighbors
**	if the grid is bigger a person can have a maximum of 8 neighbors
**	in both these cases this will be seen as invalid input 
**	seeing that no one will be infected.

**	Also do a check if the coordinates are within the grid
**	if the right amount of coordinates are given
*/

static int inputCheck(int grid, int rounds, int infection_threshold, int recovery_threshold) {
	if ((infection_threshold > 3 && grid <= 2) || infection_threshold > 8) {
		System.out.println("Invalid input");
		System.exit(0);
	}
	return (0);
}

static int[][] 	createGrid(int grid, LinkedList<Integer> coordinatesArray) {
	int[][]	array = new int[grid][grid];
	for (int i = 0; i < grid; i++) {
		for (int j = 0; j < grid; j++) {
			array[i][j] = 0;
		}
	}
	
	// fill the grid with the coordinates
	ListIterator<Integer>	it = coordinatesArray.listIterator();
	Integer x = 0;
	Integer y = 0;
	System.out.println("HIER");
	while (it.hasNext()) {
		x = it.next() - 1;
		y = it.next() - 1;
		System.out.println("X" + x);
		System.out.println("Y" + y);
		array[x][y] = 1;
		// System.out.println("current" + it.next());
		// System.out.println("next" + it.next());
		// break ;
	}

	for (Integer i = 0; i < grid; i++)
		System.out.println(Arrays.toString(array[i]));
	return (array);
}

static LinkedList<Integer>	getCoordinates(String Coordinates, int grid) {
	Integer		i = 0;
	Integer		numb = 0;
	char		pos;
	LinkedList<Integer> coordinatesArray = new LinkedList<Integer>();
	
	//	split coordinates into a list
	while (i < Coordinates.length()) {
		if (Coordinates.charAt(i) >= '0' && Coordinates.charAt(i) <= '9') {
			pos = Coordinates.charAt(i);
			numb = Integer.parseInt(String.valueOf(pos));
			if (numb > grid) {
				System.out.println("invalid input");
				System.exit(0);
			}
			coordinatesArray.add(numb);
		}
		i++;
	}
	return (coordinatesArray);
}

public static void main(String[] args) {
	// a check to see if all arguments are passed in 
	if (args.length != 5)
	{
		System.out.println("invalid input");
		return ;
	}
    int 	grid = Integer.parseInt(args[0]);
    int 	rounds = Integer.parseInt(args[1]);
    int 	infection_threshold = Integer.parseInt(args[2]);
    int     recovery_threshold = Integer.parseInt(args[3]);
    String  coordinates = args[4];

   
	// comment out later
    System.out.println("Grid: " + grid);
    System.out.println("Rounds: " + rounds);
    System.out.println("Infection threshold: " + infection_threshold);
    System.out.println("Recovery threshold: " + recovery_threshold);
	System.out.println("Coordinates: " + coordinates);

	int[][] gridArray = new int[grid][grid];
	LinkedList<Integer> coordinatesArray = new LinkedList<Integer>();

	coordinatesArray = getCoordinates(coordinates, grid);

	// printing all the coordinates
	System.out.println(coordinatesArray);


	// stop program if input is not valid
	inputCheck(grid, rounds, infection_threshold, recovery_threshold);

	gridArray = createGrid(grid, coordinatesArray);
}

}