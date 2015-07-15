package utilities;

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

        /** Driver class name for H2 db. */
        public static final String H2_DB_DRIVER = "com.mysql.jdbc.Driver";

        /** Connection string to SaSo db. */
        public static final String SendIT_LOKAL_DB_CONNECTION_STRING = "jdbc:mysql://192.168.50.50:3306";
        
        /** Connection string to H2 db. */
        public static final String H2_DB_CONNECTION_STRING =
                "jdbc:mysql://192.168.50.50:3306";

        /** DB user to SendIT_LOKAL db. */
        public static final String SendIT_LOKAL_DB_USER_NAME = "root";

        /** DB user password. */
        public static final String SendIT_LOKAL_DB_PASSWORD = "";

        /** The default directory where Firefox saves downloaded files. */
        public static final String FIREFOX_DEFAULT_DOWNLOAD_DIRECTORY =
                String.format("%s\\Downloads", System.getProperty("user.home"));
    }

    /***
     * Sales Solutions user informations.
     */
    public static class SaSo {

        /** The URL for SaSO. */
        public static final String SASO_URL =
                "http://krfeaas21.emea.vorwerk.org:8180/saso-core-pt/login.jsp";
       
        /** The logout URL for SaSO. */
        public static final String SASO_LOGOUT_URL =
                "http://krfeaas21.emea.vorwerk.org:8180/saso-core-pt/j_spring_security_logout";       
       
        /** The SaSO user name. */
        public static final String SASO_USER = "dev";

        /** The SaSo password. */
        public static final String SASO_PASSWORD = "dev";
        
        /** The URL for SaSO PL. */
        public static final String SASO_URL_PL =
                "http://krfeaas21.emea.vorwerk.org:8180/saso-core-pl/login.jsp";
        
        /** The logout URL for SaSO PL. */
        public static final String SASO_LOGOUT_URL_PL =
                "http://krfeaas21.emea.vorwerk.org:8180/saso-core-pl/j_spring_security_logout";
        
        /** The SaSO PL user name. */
        public static final String SASO_USER_PL = "dev";

        /** The SaSo PL password. */
        public static final String SASO_PASSWORD_PL = "dev";
        
        public static final String SASO_ENVIRONMENT_DEV_PATHNAME = "AMDEV";
    }
}