
package org.javaserverfaces.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Create Connection
 * 
 * @author juneau
 */
public class CreateConnection {
    
    static Properties props = new Properties();
    
    
    String hostname = null;
    String port = null;
    String database = null;
    String username = null;
    String password = null;
    String jndi = null;
    
    public CreateConnection(){
        InputStream in = null;
        try {
            // Looks for properties file in the root of the src directory in Netbeans project
            in = Files.newInputStream(FileSystems.getDefault().getPath(System.getProperty("user.dir") + File.separator + "db_props.properties"));
           // in = new FileInputStream("/path-to-file/db_props.properties");
            props.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        loadProperties();

    }

    public void loadProperties(){
        hostname = props.getProperty("host_name");
        port = props.getProperty("port_number");
        database = props.getProperty("db_name");
        username = props.getProperty("username");
        password = props.getProperty("password");
        jndi = props.getProperty("jndi");

    }
    
    /**
     * Demonstrates obtaining a connection via DriverManager
     * @return
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        loadProperties();
        String jdbcUrl = "jdbc:oracle:thin:@" + this.hostname + ":" + 
                        this.port  + ":" + this.database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Successfully connected");
        return conn;
    }
    
    /**
     * Demonstrates obtaining a connection via a DataSource object
     * @return 
     */
    public Connection getDSConnection() {
        Connection conn = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup(this.jndi);
            conn = ds.getConnection();

        } catch (NamingException ex) { 
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args){
        CreateConnection createConnection = new CreateConnection();
        try {
            createConnection.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
