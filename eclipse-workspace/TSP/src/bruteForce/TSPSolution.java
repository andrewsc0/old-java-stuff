package bruteForce;

import java.io.FileNotFoundException;

public class TSPSolution {

	public static void main(String[] args) throws FileNotFoundException {		
		String fileLocation = "src/mini1.tsp.txt";
		TSPSolver solution = new BruteForceSolver(fileLocation);
		String outputFile = solution.solve();
		solution.getData();
		// System.out.println("TSP Solution placed in " + outputFile);
	}
}

