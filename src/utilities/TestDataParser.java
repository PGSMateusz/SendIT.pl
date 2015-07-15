package utilities;

import java.util.logging.Logger;

import utilities.DBConnection.ConnectionData;

public class TestDataParser {
	
    protected static final Logger logger = Logger.getLogger(TestDataParser.class.getName());
        
    public static void updateUserRegister() {
        final String sql = String.format(
                "DELETE from sendit_api.user where login = 'REGISTRATION_TEST'");

        final DBConnection dbConnection = new DBConnection(ConnectionData.SendIT_LOKAL);
        dbConnection.runSqlStatement(sql);
        dbConnection.runSqlUpdate(sql);
        dbConnection.disconnect();
    }
	
}
