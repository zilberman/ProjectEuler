package euler.level1;

public class LatticePaths {
	private static int DIMENSION = 20;
	
	public static void main(String[] args) {
		long[][] grid = new long[LatticePaths.DIMENSION + 1][LatticePaths.DIMENSION + 1];
		
		grid[0][0] = 0;
		
		for (int j = 1; j < LatticePaths.DIMENSION + 1; j++) {
			grid[0][j] = 1;	
		}
		
		for (int i = 1; i < LatticePaths.DIMENSION + 1; i++) {
			grid[i][0] = 1;	
		}
		
		for (int i = 1; i < LatticePaths.DIMENSION + 1; i++) {
			for (int j = 1; j < LatticePaths.DIMENSION + 1; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];	
			}
		}
		
		System.out.println(grid[LatticePaths.DIMENSION][LatticePaths.DIMENSION]);
	}
}
