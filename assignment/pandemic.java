import java.util.Arrays;

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
		return (1);
	}
	return (0);
}

static int[][] 	createGrid(int grid, String Coordinates) {
	int[][]	array = new int[grid][grid];

	for (int i = 0; i < grid; i++) {
		for (int j = 0; j < grid; j++) {
			array[i][j] = 0;
		}
	}

	System.out.println(Arrays.deepToString(array));
	return (array);
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

	// stop program if input is not valid
	if (inputCheck(grid, rounds, infection_threshold, recovery_threshold) == 1)
		return ;
	
	int[][] gridArray = new int[grid][grid];
	gridArray = createGrid(grid, coordinates);
}

}