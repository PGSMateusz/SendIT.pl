package utilities;

import utilities.GetDate;
/**
 * Class holding static test data like DB, usernames etc.
 * 
 * @author dabrowsm
 */

public class Settings {

    public static class Common {

        /** Standard time when waiting for an action to be completed. */
        public static final int SHORT_WAITING_TIME = 2500;
        
        /** Standard time when waiting for an action to be completed. */
        public static final int WAITING_TIME = 5000;

        /** Long time when waiting for an action to be completed. */
        public static final int LONG_WAITING_TIME = 30000;

        /** Maximum number of periods an action is executed (e.g. refresh of an page) */
        public static final int MAX_WAITING_PERIODS = 20;

        /** Driver class name for SaSo db. */
        public static final String SendIT_LOKAL_DB_DRIVER = "com.mysql.jdbc.Driver";

        /** Connection string to SaSo db. */
        public static final String SendIT_LOKAL_DB_CONNECTION_STRING = "jdbc:mysql://192.168.50.50:3306";

        /** DB user to SendIT_LOKAL db. */
        public static final String SendIT_LOKAL_DB_USER_NAME = "root";

        /** DB user password. */
        public static final String SendIT_LOKAL_DB_PASSWORD = "";

        /** The default directory where Firefox saves downloaded files. */
        public static final String FIREFOX_DEFAULT_DOWNLOAD_DIRECTORY =
                String.format("%s\\Downloads", System.getProperty("user.home"));
    }

    /***
     * SendIT user informations.
     */
    public static class SendIT {

        /** The URL for SendIT. */
        public static final String SendIT_URL = "http://www.sendit/logowanie";
       
        /** The logout URL for SendIT. */
        public static final String SendIT_LOGOUT_URL = "";       
       
        /** The SendIT user name. */
        public static final String SendIT_USER = "TESTY_AUTOMATYCZNE";

        /** The SendIT password. */
        public static final String SendIT_PASSWORD = "rambo_" + GetDate.main(null);
        
    }
}