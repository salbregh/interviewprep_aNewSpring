public class Colors {
	// print out colors
	public static final String RED = "\033[0;31m";     // RED
	public static final String RED_BACKGROUND = "\033[41m";    // RED
	// 1 state
	public static final String GREEN = "\033[0;32m";   // GREEN
	public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
	// 3 state recovering
	public static final String YELLOW = "\033[0;33m";  // YELLOW
	public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
	// 2 state newly infected
	public static final String WHITE = "\033[0;37m";   // WHITE
	public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
	// 0 state
	public static final String RESET = "\033[0m";  // Text Reset
}
