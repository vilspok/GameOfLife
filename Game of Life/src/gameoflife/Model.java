package gameoflife;


import java.util.Random;

public class Model {

	private	int[][] cells;
	private int height, width;
	View view;
	
	Model(int h, int w, View v){
		height = h;
		view = v;
		width = w;
		cells = new int[height][width];	
		randomize();	
		
	}
	
	//fill table with random life
	private void randomize() {
		for (int i  = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Random random = new Random();
				int randomInt = random.nextInt(100);
				if(randomInt < 26) {
					cells[i][j] = 1;
				}
				else {
					cells[i][j] = 0;
				}
			}
		}
	}
	
	//toggle state of cell in (h,w) and tell view to update
	public void toggleState(int h, int w) {
		if(cells[h][w] == 1)
		{
			cells[h][w] = 0;
		}else {
			cells[h][w] = 1;
		}
		view.updateView();
	}
	
	public int getState(int h,int w) {
		return cells[h][w];
	}
	public int[][] getData(){
		return cells;
	}
	
	//returns number of live neighbours around cell in (h,w)
	private int countLiveNeighbours(int h, int w) {
		
		int count = 0;
		int row = h;
		int col = w;
		//if cell(h,w) is alive, substract count by 1
		if(getState(h,w) == 1) {
			count--;
		}
		//handle cases where h or w is 0
		if(row == 0) {
			row++;
		}
		if(col == 0) {
			col++;
		}
		//count neighbours (and cell itself, if alive)
		for(int i = row-1; i < height && i <= h+1; i++) {
			for (int j = col-1; j < width && j <= w+1; j++) {
				if(getState(i,j) == 1){
					count++;
				}
			}
		}
		return count;
	}
	
	/*Updates cells to next generation and after that tells view to update
	 *
     * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     * Any live cell with two or three live neighbours lives on to the next generation.
     * Any live cell with more than three live neighbours dies, as if by overpopulation.
     * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 */
	public void nextGeneration() {
		int newCells[][] = new int[height][width];
		
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				//cell with 3 neighbours will live,
				//whether it is dead or alive
				if(countLiveNeighbours(i, j) == 3) { 
					newCells[i][j] = 1;
				} else if(getState(i,j) == 1){ //cell is alive
					//live cell will keep living, if it has 2 or 3 neighbours
					//3 we already handled
					if(countLiveNeighbours(i, j) == 2) {
						newCells[i][j] = 1;
					}else { //other alive cells will die
						newCells[i][j] = 0;
					}
				}else { //in other cases, dead cells stay dead
					newCells[i][j] = 0;
				}
			}
		}
		cells = newCells;
		view.updateView();
	}
	
	
	
	
	
}
