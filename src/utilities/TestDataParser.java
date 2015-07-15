package utilities;

import java.util.logging.Logger;

import utilities.DBConnection.ConnectionData;

/**
 * Class containing methods for accessing the testdata.
 * 
 * @author dabrowsm
 */

public class TestDataParser {
	
    protected static final Logger logger = Logger.getLogger(TestDataParser.class.getName());
        
    public static void updateUserRegister() {
        final String sql = String.format("DELETE from sendit_api.user where login = 'REGISTRATION_TEST'");
        System.out.println("Connecting to a selected database...");
        final DBConnection dbConnection = new DBConnection(ConnectionData.SendIT_LOKAL);
        System.out.println("Connected database successfully...");
        //dbConnection.runSqlStatement(sql); // Nie wiedzieæ czemu nie ³yka tego
        System.out.println("Creating statement...");
        dbConnection.runSqlUpdate(sql);
        System.out.println("Execute...");
        dbConnection.disconnect();
        System.out.println("DONE!");
    }
    
    public static void getLatesUserOrder() {
        final String sql = String.format(
        		"SELECT order_nr FROM sendit_api.`order` WHERE date = (SELECT MAX(date) FROM sendit_api.`order` "
        		+ "WHERE s_email = 'dariusz.juzwik@allegro.pl') AND s_email = 'dariusz.juzwik@allegro.pl';");
        System.out.println("Connecting to a selected database...");
        final DBConnection dbConnection = new DBConnection(ConnectionData.SendIT_LOKAL);
        System.out.println("Connected database successfully...");
        //dbConnection.runSqlStatement(sql); // Nie wiedzieæ czemu nie ³yka tego
        System.out.println("Creating statement...");
        dbConnection.runSqlUpdate(sql);
        System.out.println("Execute...");
        dbConnection.disconnect();
        System.out.println("DONE!");
    }
	
}
