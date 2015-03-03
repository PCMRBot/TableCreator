/*	  Ensures tables exist for PCMRBot.
 *    Copyright (C) 2015 James Wolff
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
