package se.mooldi.otherclasses;

import java.util.Random;

public class Game {
	
	private String gameType = "";
	int[][] resultArr = new int[13][13];
	final int EASY = 2;  //TODO
	final int HARD = 1;	 //TODO
	Random rand = new Random();
	Integer currX = 0;
	Integer currY = 0;
		
	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void newMultArray(){
		for (int y = 0; y <=12; y++){
			resultArr[0][y] = EASY;
			resultArr[1][y] = EASY;
			resultArr[2][y] = EASY;
			resultArr[3][y] = HARD;
			resultArr[4][y] = HARD;
			resultArr[5][y] = HARD;
			resultArr[6][y] = HARD;
			resultArr[7][y] = HARD;
			resultArr[8][y] = HARD;
			resultArr[9][y] = HARD;			
			resultArr[10][y] = EASY;
			resultArr[11][y] = HARD;
			resultArr[12][y] = HARD;
		}
		for (int x = 0; x <= 12; x++){
			if ((x <= 2) || (x == 10)){
				resultArr[x][0] = EASY;
				resultArr[x][1] = EASY;
				resultArr[x][2] = EASY;
				resultArr[x][3] = EASY;
				resultArr[x][4] = EASY;
				resultArr[x][5] = EASY;
				resultArr[x][6] = EASY;
				resultArr[x][7] = EASY;
				resultArr[x][8] = EASY;
				resultArr[x][9] = EASY;			
				resultArr[x][10] = EASY;
				resultArr[x][11] = EASY;
				resultArr[x][12] = EASY;
			}			
		}
	}
	
	public String runGame(){
		do{
			currX = rand.nextInt(13);
			currY = rand.nextInt(13);
		} while (resultArr[currX][currY] == 0);	
		
		String ret = currX.toString() + " * " + currY.toString();
		return ret;
	}
	
	public boolean checkAnswer(int answer){
		boolean result = false;
		if ((currX.intValue() * currY.intValue()) == answer){ 
			resultArr[currX][currY]--;
			result = true;
		}		
		return result;
	}
	
	public boolean isCleared(){
		return (resultArr[currX][currY] == 0);
	}

	public void startGame(){
		
	}

	public void saveGame(){
		
	}
	
	public int[][] getResultArr(){
		return resultArr;
	}
	
}
