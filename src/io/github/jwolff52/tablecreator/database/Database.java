package io.github.jwolff52.tablecreator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	
	private static Connection conn;

	private static final String URL = "jdbc:mysql://localhost:3306/pcmrbot?";

	public static final String DATABASE = "pcmrbot";

	static final Logger logger = Logger.getLogger(Database.class + "");

	/**
	 * Creates a connection to the database.
	 * 
	 * @return - true if connection is successful
	 */
	public static boolean initDBConnection(String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			logger.log(
					Level.SEVERE,
					"Unable to find Driver in classpath!"
							,e);
		}
		try {
			conn = DriverManager.getConnection(String.format("%suser=bot&password=%s", URL, pass));
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * Creates the tables for the provided channel
	 * 
	 * @param channelNoHash - the channel we are connecting to.
	 * @return - true if it has to create the tables
	 */
	public static void getChannelTables(String channelNoHash) {
		Statement stmt1;
		Statement stmt2;
		Statement stmt3;
		Statement stmt4;
		Statement stmt5;
		Statement stmt6;
		Statement stmt7;
		Statement stmt8;
		try {
			stmt1 = conn.createStatement();
			stmt1.closeOnCompletion();
			stmt1.executeUpdate(String.format("CREATE TABLE %s.%sMods(userID varchar(25), PRIMARY KEY (userID))", DATABASE, channelNoHash));
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Mods table already exists!");
		}
		try {
			stmt2 = conn.createStatement();
			stmt2.closeOnCompletion();
			stmt2.executeUpdate(String.format("CREATE TABLE %s.%sOptions(optionID varchar(50), value varchar(4000), PRIMARY KEY (optionID))", DATABASE, channelNoHash));
		} catch (SQLException ex) {
			logger.log(Level.INFO, "Options table already exists!");
		}
		try {
			stmt3 = conn.createStatement();
			stmt3.closeOnCompletion();
			stmt3.executeUpdate(String.format("CREATE TABLE %s.%sSpam(word varchar(25), PRIMARY KEY (word))", DATABASE, channelNoHash));
		} catch (SQLException ex) {
			logger.log(Level.INFO, "Spam table already exists!");
		}
		try {
			stmt4 = conn.createStatement();
			stmt4.closeOnCompletion();
			stmt4.executeUpdate(String.format("CREATE TABLE %s.%sAutoReplies(keyWord varchar(255), reply varchar(4000), PRIMARY KEY (keyWord))", DATABASE, channelNoHash));
		} catch (SQLException ex) {
			logger.log(Level.INFO, "AutoReplies table already exists!");
		}
		try {
			stmt5 = conn.createStatement();
			stmt5.closeOnCompletion();
			stmt5.executeUpdate(String.format("CREATE TABLE %s.%sWhitelist(userID varchar(30), PRIMARY KEY (userID))", DATABASE, channelNoHash));
		} catch (SQLException ex) {
			logger.log(Level.INFO, "Whitelist table already exists!");
		}
		try{
            stmt6=conn.createStatement();
            stmt6.closeOnCompletion();
            stmt6.executeUpdate(String.format("CREATE TABLE %s.%sPoints(userID varchar(25), points INTEGER, PRIMARY KEY (userID))", DATABASE, channelNoHash));
        }catch(SQLException ex){
            logger.log(Level.INFO, "Points table already exists!");
        }
        try{
            stmt7=conn.createStatement();
            stmt7.closeOnCompletion();
            stmt7.executeUpdate(String.format("CREATE TABLE %s.%sRegulars(userID varchar(25), PRIMARY KEY (userID))", DATABASE, channelNoHash));
        }catch(SQLException ex){
            logger.log(Level.INFO, "Regulars table already exists!");
        }
        try{
            stmt8=conn.createStatement();
            stmt8.closeOnCompletion();
            stmt8.executeUpdate(String.format("CREATE TABLE %s.%sCommands(command varchar(25), parameters varchar(255), PRIMARY KEY (command))", DATABASE, channelNoHash));
        }catch(SQLException ex){
            logger.log(Level.INFO, "Commands table already exists!");
        }
	}
}
