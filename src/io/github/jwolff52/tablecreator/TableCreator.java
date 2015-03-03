package io.github.jwolff52.tablecreator;

import io.github.jwolff52.tablecreator.database.Database;

import java.util.Scanner;

public class TableCreator {

	public static void main(String[] args) {
		Database.initDBConnection(args[0]);
		System.out.println("Input the channel name to verify.");
		try(Scanner scan = new Scanner(System.in)) {
			Database.getChannelTables(scan.nextLine());
		}
	}
}
