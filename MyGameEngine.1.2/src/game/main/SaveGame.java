package game.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGame {
	public static boolean pause = false;
	public static boolean saveGameExists = false;
	public static boolean saveGame = false;

	static String workinDir = System.getProperty("user.dir");
	
//	World world;
//
//	Game game;

	public static void applySave(String str) {
		String[] spl = str.split("/");
		for (int i = 0; i < spl.length; i++) {
			String[] spl2 = spl[i].split(":");

			switch (spl2[0]) {

			case "map":
//				World.changeScene("map" + spl2[1] + ".png");
//				Game.gameState = "normal";
//				pause = false;
				break;
			case "vida":
//				Game.player.life = Integer.parseInt(spl2[1]);
				break;
			}

		}
	}

	public static String loadGame(int encode) {

		String line = "";
		if (new File(workinDir + "\\folder\\"+ "save.txt").exists()) {
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader(workinDir + "\\folder\\"+ "save.txt"));
				try {
					while ((singleLine = reader.readLine()) != null) {

						String[] transaction = singleLine.split(":");
						char[] val = transaction[1].toCharArray();

						transaction[1] = "";

						for (int i = 0; i < val.length; i++) {
							val[1] -= encode;
							transaction[1] += val[1];

						}
						line = line + transaction[0];
						line = line + ":";
						line = line + transaction[1];
						line = line + "/";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return line;

	}

	public static String loadGame( ) {
		
		String line = "";
		System.out.println( new File(workinDir + "\\folder\\"+ "save.txt").exists() );
		if (new File(workinDir + "\\folder\\"+ "save.txt").exists()) {
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader(workinDir + "\\folder\\"+ "save.txt"));
				try {
					while ((singleLine = reader.readLine()) != null) {
//						System.out.println(singleLine);
//						
						String[] transaction = singleLine.split(":");
//						System.out.println( transaction[0] );
//						char[] val = transaction[1].toCharArray();
//						
//						System.out.println( "  " + val);
//						transaction[1] = "";
//						for (int i = 0; i < val.length; i++) {
//							transaction[1] += val[1];
//						}
							
						line = line + transaction[0];
						line = line + ":";
						line = line + transaction[1];
						line = line + "/";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return line;
		
	}

	public static void save(String[] value1, int[] value2, int encode) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter( workinDir + "\\folder\\"+ "save.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < value1.length; i++) {
			String current = value1[i];
			current = current + ":";

			char[] value = Integer.toString(value2[i]).toCharArray();

			for (int n = 0; n < value.length; n++) {
				value[n] += encode;
				current += value[n];
			}
			try {
				writer.write(current);
				if (i < value1.length - 1) {
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void save(String[] value1, int[] value2) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(workinDir + "\\folder\\"+ "save.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < value1.length; i++) {
			String current = value1[i];
			current = current + ":";

			char[] value = Integer.toString(value2[i]).toCharArray();

			for (int n = 0; n < value.length; n++) {
				current += value[n];
			}
			try {
				writer.write(current);
				if (i < value1.length - 1) {
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
