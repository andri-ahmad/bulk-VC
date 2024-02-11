package bulk_vc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import Amdocs.Adapter.*;

public class Main {
   
    public static void main(String[] args) throws Exception {
        
        PrintOutput printOutput = new PrintOutput(); 
        Parameters apiParams = new Parameters();
        printOutput.initOutput(apiParams, printOutput);
        
        printOutput.printToShell(apiParams, "OPENING DATABASE CONNECTION", "");
        DataBaseLayer dbl = new DataBaseLayer();
        dbl.loadDblConnection();
        dbl.connect();
        
        
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String tgl = sdf.format(new Date());
        
        // object Amdocs API
        UnAssignedCard unAssignedCardAPI = new UnAssignedCard();
        
        
        String query1 =    "SELECT * FROM BULK_VC WHERE STATUS = 'NEW' ";
        
        
        rs = dbl.selectQuery(query1);       
        while(rs.next()){
            printOutput.printToShell(apiParams, "PROCESSING RECORD TO AMDOCS", "");           
            printOutput.printToShell(apiParams, "RECORD : "+  rs.getString(1) + " - VC : " + rs.getString(5) + " - Cust ID : " + rs.getString(6), "");
        
        
            // Processing the record to remove.
            // Create object Adapter
            try {
                unAssignedCardAPI.RemoveCard(rs.getString(6), rs.getString(5) );  
                
                //Update with success
                dbl.updateQuery("UPDATE BULK_VC SET STATUS = 'DONE' WHERE ID = " + rs.getString(1) );
                
            } catch (Exception exp) {
                
                System.out.println("ANDRI>>MAIN PROGRAM : --> " + exp.toString());
                
                dbl.updateQuery("UPDATE BULK_VC SET STATUS = 'FAILED', NOTES = '"+ exp.toString()+"' WHERE ID = " + rs.getString(1) );
                
            }       
        
        }
        rs.close();      
        
        printOutput.printToShell(apiParams, "FINISH, CLOSING CONNECTION", "");
        
    }
}
