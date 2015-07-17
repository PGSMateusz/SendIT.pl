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
        //dbConnection.runSqlStatement(sql); 
        System.out.println("Creating statement...");
        dbConnection.runSqlUpdate(sql);
        System.out.println("Execute...");
        dbConnection.disconnect();
        System.out.println("DONE!");
    }
    
    public static String getLatesUserOrder() {
 
    	final String sql = String.format(
    			"SELECT MAX(order_nr) as MAX_NO FROM sendit_api.`order` where s_email = 'dariusz.juzwik@allegro.pl'");
        System.out.println("Connecting to a selected database...");
        final DBConnection dbConnection = new DBConnection(ConnectionData.SendIT_LOKAL);
        System.out.println("Connected database successfully...");
        final String lastNo = dbConnection.getSingleDbValue(sql);
        System.out.println("Creating statement...");
        System.out.println("Execute...");
        logger.info(String.format("lastNo='%s'", lastNo));
        dbConnection.disconnect();
        System.out.println("DONE!");
        return lastNo;
    }
       
}
