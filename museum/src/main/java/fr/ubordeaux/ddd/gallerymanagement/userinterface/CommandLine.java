package fr.ubordeaux.ddd.gallerymanagement.userinterface;

import java.io.IOException;

public class CommandLine {
	public static void main(String[] args) {
		try {
			TextualMenu tm = new TextualMenu(System.in, System.out);
			tm.handleUserInstructions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}    
}