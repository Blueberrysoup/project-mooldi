package se.mooldi.otherclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

	public void saveGameToFile(Player player, Game game){
		int points = player.getPoints();
		int completed = player.getCompleted();
		int[][] resultArr = game.getResultArr();
		String fileName = "gamefiles/" + player.getName() + ".txt";
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		try{
			file.createNewFile();
		
			FileWriter writer = new FileWriter(file);
			
			System.out.println(points);
			writer.write(points);
			
			System.out.println(completed);
			writer.write(completed);
			
			for (int x = 0; x < 13; x++){
				for (int y = 0; y < 13; y++){
					System.out.println(resultArr[x][y]);
					writer.write(resultArr[x][y]);
				}
			}
			
			writer.flush();
			writer.close();
		
		} catch(IOException e){
			System.out.println(e.getMessage());
		} catch(SecurityException e){
			System.out.println(e.getMessage());
		}
	}
	

	public boolean startGame(Player player, Game game){
		String fileName = "gamefiles/" + player.getName() + ".txt";
		File file = new File(fileName);
		int next = 0;
		
		try{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			player.setPoints(bufferedReader.read());
			player.setCompleted(bufferedReader.read());
			
			for (int x = 0; x < 13; x++){
				for (int y = 0; y < 13; y++){
					resultArr[x][y] = bufferedReader.read();
				}
			}
			bufferedReader.close();
		} catch (IOException e){
			e.getMessage();
		} catch (FileNotFoundException e){
			e.getMessage();
		}

		//player.setName();
		//player.setPoints();
		//player.setCompleted();
		//game.setResultArr();
		return true;
	}

}
