package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    /**
     * Connection object for later use.
     */
    private Connection connection;

    /**
     * Statement object for later use.
     */
    private Statement statement;

    public enum ConnectionData {
        /** Application database. */
        SendIT_LOKAL(Settings.Common.SendIT_LOKAL_DB_DRIVER, Settings.Common.SendIT_LOKAL_DB_CONNECTION_STRING,
                Settings.Common.SendIT_LOKAL_DB_USER_NAME, Settings.Common.SendIT_LOKAL_DB_PASSWORD),

        H2(Settings.Common.H2_DB_DRIVER, Settings.Common.H2_DB_CONNECTION_STRING, "", "");

        /**
         * The JDBC-Driver class.
         */
        private final String driver;

        /**
         * The URL for accessing the database.
         */
        private final String connectionString;

        /**
         * The user name.
         */
        private final String user;

        /**
         * The password.
         */
        private final String password;

        /**
         * Private constructor.
         * 
         * @param driver The JDBC-Driver class
         * @param connectionString The URL to access database
         * @param user The user name
         * @param password The password
         */
        private ConnectionData(final String driver, final String connectionString, final String user,
                final String password) {
            this.driver = driver;
            this.connectionString = connectionString;
            this.user = user;
            this.password = password;
        }

        /**
         * Gets the JDBC-Driver class.
         * 
         * @return String
         */
        public String getDriver() {
            return driver;
        }

        /**
         * Gets the database connection string.
         * 
         * @return String
         */
        public String getConnectionString() {
            return connectionString;
        }

        /**
         * Gets the user name.
         * 
         * @return String
         */
        public String getUser() {
            return user;
        }

        /**
         * Gets the password.
         * 
         * @return String
         */
        public String getPassword() {
            return password;
        }
    }

    /**
     * Public constructor.
     * 
     * @param connectionData The data used to connect to the database
     */
    public DBConnection(ConnectionData connectionData) {
        this.connect(connectionData);
    }

    /***
     * Runs the given SQL statement and returns the value of the first column of the row of the result.
     * 
     * @param sql The query to execute
     * 
     * @return Object
     */
    public String getSingleDbValue(String sql) {
        try {
            ResultSet rs = runSqlStatement(sql);
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            throw new SqlException(String.format("Error while executing sql '%s'.", sql), e);
        }
    }

    /**
     * Runs the given SQL statement.
     * 
     * @param sql The query to execute
     * 
     * @return ResultSet
     */
    public ResultSet runSqlStatement(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new SqlException(String.format("Error while executing sql '%s'.", sql), e);
        }
    }

    /**
     * Execute the given SQL statement.
     * 
     * @param sql The query to execute
     * 
     * @return int - number of updated rows
     */
    public int runSqlUpdate(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SqlException(String.format("Error while executing sql '%s'.", sql), e);
        }
    }

    /**
     * Disconnects from the database.
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new SqlException("Error while closing sql connection.", e);
        }
    }

    /**
     * Creates the connection to the database.
     * 
     * @param connectionData The data used to connect to the database
     */
    private void connect(ConnectionData connectionData) {
        try {
            // Load the JDBC driver
            Class.forName(connectionData.getDriver());

            // Create a connection to the database
            this.connection = DriverManager.getConnection(connectionData.getConnectionString(),
                    connectionData.getUser(), connectionData.getPassword());
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            throw new SqlException(String.format("Cannot find driver class '%s'.", connectionData.getDriver()), e);
        } catch (SQLException e) {
            throw new SqlException(String.format("Error occurred while connection to database '%s'.",
                    connectionData.getConnectionString()), e);
        }
    }
}

