package bulk_vc;

import java.io.FileNotFoundException;
import java.io.IOException;
import oracle.jdbc.pool.OracleDataSource; 
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;

public class DataBaseLayer {
    
    /** Creates a new instance of DataBaseLayer */
    private Properties dataBaseProperties = new Properties();
    private Connection conn;
    private int trxTypeSync;
    
    public DataBaseLayer() {
        System.out.println("Creating DataBaseLayer class [DONE]");
            this.trxTypeSync = 1;
    }
    
    public void loadProperties(String propFileName) throws FileNotFoundException, IOException {
        this.dataBaseProperties.load(new FileInputStream(new File(propFileName)));
      }

      public void loadDblConnection() throws SQLException,IOException {
        this.dataBaseProperties.load(this.getClass().getResourceAsStream("db.properties"));
        this.conn = connect();
      }

      public void releaseDblConnection() throws SQLException {
        this.conn.close();
      }

    public Connection getConnection() throws SQLException{
        return this.conn;
    }

      public Connection connect() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(this.dataBaseProperties.getProperty("Username").toString());
        ods.setPassword(this.dataBaseProperties.getProperty("Password").toString());
        ods.setURL(this.dataBaseProperties.getProperty("ConnectionString").toString());
        Connection c = ods.getConnection();
        return c;
      }
      
      public void CMconnect() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(this.dataBaseProperties.getProperty("CMUsername").toString());
        ods.setPassword(this.dataBaseProperties.getProperty("CMPassword").toString());
        ods.setURL(this.dataBaseProperties.getProperty("CMConnectionString").toString());
        this.conn = ods.getConnection();
      }  
      
      public void CRMDBconnect() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(this.dataBaseProperties.getProperty("CRMDBUsername").toString());
        ods.setPassword(this.dataBaseProperties.getProperty("CRMDBPassword").toString());
        ods.setURL(this.dataBaseProperties.getProperty("CRMDBConnectionString").toString());
        this.conn = ods.getConnection();
      }      

      public void close() throws SQLException {
        this.conn.close();
      }

      public Properties getDataBaseProperties() {
        return this.dataBaseProperties;
      }

      public void setDataBaseProperties(Properties DataBaseProperties) {
        this.dataBaseProperties = DataBaseProperties;
      }

      public int updateQuery(String query) throws SQLException {
        Statement queryStatement = this.conn.createStatement();
        int i = queryStatement.executeUpdate(query);
        queryStatement.close();
        return i;
      }

        public ResultSet selectQuery(String query) throws SQLException{
            Statement queryStatement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = queryStatement.executeQuery(query);
            return rs;
        }
}
