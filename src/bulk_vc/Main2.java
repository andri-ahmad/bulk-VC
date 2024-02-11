package bulk_vc;

import Amdocs.Adapter.Login;
import Amdocs.Adapter.Parameters;
import Amdocs.Adapter.PrintOutput;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpMainOrderOptionFacade;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.accountconstraints.VideoEquipmentConstraintsVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opmainorderoption.EquipmentValidationVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2 {
    
    public static void main(String[] args) throws Exception {
        
        // variables
        boolean session;
        boolean kartuValidUntukRemove = false;
        boolean customerValiduntukRemove = false;
        boolean siteLock         = false;
        boolean acctLock         = false;
        boolean varLock          = false;
        String customerID = "";
        String customerStatusCur = "";
        Login aLogin = new Login();
        int posisiEquipmentServicepoint = 1;
        
        // Objects
        EquipmentVO equipmentVO = new EquipmentVO();
        ServicePointFacade servicePointFacade = new ServicePointFacade();
        CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
        CustomerFacade customerFacade = new CustomerFacade();
        VideoEquipmentConstraintsVO videoEquipmentConstraintsVO = new VideoEquipmentConstraintsVO();        
        ServicePointVO[] servicePointVOList = null;
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        EquipmentVO[] equipmentVOlist = new EquipmentVO[1];
        OpMainOrderOptionFacade opMainOrderOptionFacade = new OpMainOrderOptionFacade();
        OrderResultVO orderResultVO = new OrderResultVO();
        LockServiceFacade lockServiceFacade = new LockServiceFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();
        
        PrintOutput printOutput = new PrintOutput(); 
        Parameters apiParams = new Parameters();
        apiParams.setUser("ANDRI");
        apiParams.setPassword("4NDR1@@");
        printOutput.initOutput(apiParams, printOutput);  
        apiParams.initParameters(Parameters.UNASSIGN_EQP , apiParams, printOutput);
        
        printOutput.printToShell(apiParams, "----------------------------", "");
        printOutput.printToShell(apiParams, "OPENING DATABASE CONNECTION", "");
        DataBaseLayer dbl = new DataBaseLayer();
        dbl.loadDblConnection();
        dbl.connect();     
        printOutput.printToShell(apiParams, "OPENING DATABASE CONNECTION [DONE]", "");       
        
        printOutput.printToShell(apiParams, "", "");
        printOutput.printToShell(apiParams, "LOGING IN INTO AMDOCS SYSTEM....", "");
        session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);
        
        if (session) { 
            
            // prepare query from database
            ResultSet rs = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String tgl = sdf.format(new Date());
            
            //string query
            String query1 =    "SELECT * FROM BULK_VC WHERE STATUS = 'NEW' ";       
            rs = dbl.selectQuery(query1);
            
            // looping data hasil query
            printOutput.printToShell(apiParams, "", "");
            printOutput.printToShell(apiParams, "PROCESSING RECORD TO AMDOCS", ""); 
            while(rs.next()){
                
                printOutput.printToShell(apiParams, "", "");                          
                printOutput.printToShell(apiParams, "RECORD : "+  rs.getString(1) + " - VC : " + rs.getString(5), "");
            
                // Global Try and catch
                try {
                    // Cek validasi Kartu
                    try {
                        equipmentVO = servicePointFacade.getEquipmentDetails(rs.getString(5), 
                                                                             apiParams.getCorp(), 
                                                                             aLogin.getTicket());
                    
                        if (equipmentVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI :<equipmentVO>" +       equipmentVO.toString() + "</equipmentVO>",
                                equipmentVO.toXml());
                                printOutput.printToShell(apiParams, rs.getString(5) + " - " + equipmentVO.getBoxStatus(), "");
                        }
                        else {
                                throw new Exception("equipmentVO is null");
                        }
                        
                    } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "servicePointFacade", e);
                    }
                    
                    // Bukan D, bisa A,B,C,F,
                    if (!equipmentVO.getBoxStatus().equals("D")) {
                        kartuValidUntukRemove = false;                    
                    } else {
                        // ini status D
                        kartuValidUntukRemove = true;                    
                    }
                    
                    if (kartuValidUntukRemove) {
                        //cek status customer
                        customerID = equipmentVO.getCustAcct();
                        printOutput.printToShell(apiParams, "Found Customer ID for " + rs.getString(5) + ", Cust ID = " + customerID, "");
                        
                                        
                        // cek status customer
                        try {
                            customerDetailsVO = customerFacade.getCustomerDetail(customerID, 
                                                                                 false, apiParams.getCorp(), aLogin.getTicket());                          
                            
                            if (customerDetailsVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI GETDATA customerFacade.getCustomerDetail:<customerDetailsVO>" + customerDetailsVO.toString() + "</CustomerDetailsVO>",
                                customerDetailsVO.toXml());
                                customerStatusCur = customerDetailsVO.getStatus();
                                printOutput.printToShell(apiParams, "Status Customer current " + customerStatusCur, "");
                            }
                            else {
                                throw new Exception("customerDetailsVO is null");
                            }
                            
                            }
                        catch (AmspServiceException e)  {
                            printOutput.printExceptionToShell(apiParams, "customerFacade.getCustomerDetail", e);
                        }
                        
                        /*
                        // Jika bukan Disconnect status
                        if (!customerStatusCur.equals("6")) {
                            customerValiduntukRemove = false;
                        } else {
                            // yang statusnya disconnect masuk sini
                            customerValiduntukRemove= true;
                        }
                        */
                        
                        // Untuk Pak sigit, semua valid di remove.
                        customerValiduntukRemove= true;
                        
                        
                        printOutput.printToShell(apiParams, "customerValiduntukRemove " + customerValiduntukRemove,"");
                        printOutput.printToShell(apiParams, "kartuValidUntukRemove " + kartuValidUntukRemove,"");
                        if (customerValiduntukRemove && kartuValidUntukRemove ) {
                            
                            //Eksekusi remove card
                            printOutput.printToShell(apiParams, "Prepare execution remove card...", "");                            
                          
                            // ini constraint
                            try {
                                videoEquipmentConstraintsVO = accountConstraintsFacade.getVideoEquipmentConstraints(apiParams.getOrderType(),
                                                                                    apiParams.getEquipmentVOaction(),
                                                                                    equipmentVO,
                                                                                    customerDetailsVO.getSiteId(),
                                                                                    apiParams.getCorp(), 
                                                                                    aLogin.getTicket());

                                if (videoEquipmentConstraintsVO != null) {
                                       // printOutput.printToShell(apiParams, 
                                                      //   "<<ANDRI :<videoEquipmentConstraintsVO>" + videoEquipmentConstraintsVO.toString() + "</videoEquipmentConstraintsVO>",
                                                      //  videoEquipmentConstraintsVO.toXml());
                                }
                                else {
                                        throw new Exception("videoEquipmentConstraintsVO is null");
                                }
                                
                            }
                            catch (AmspServiceException e)  {
                                    printOutput.printExceptionToShell(apiParams, "accountConstraintsFacade", e);
                                throw new Exception(e.toString());
                            }
                            
                            // service point
                            try {
                                servicePointVOList = servicePointFacade.getAllServicePoints(customerID,
                                                                                        customerDetailsVO.getSiteId(),
                                                                                        apiParams.getOrderGroupSeq(),
                                                                                        apiParams.getCorp(),
                                                                                        aLogin.getTicket());
                                                                                        
                                                                                        
                                if (servicePointVOList != null) {
                                        for (int i = 0; i != servicePointVOList.length; i++) {
                                                printOutput.printToShell(apiParams, 
                                                                "servicePointVOList" + ":<servicePointVO id=" + i + ">" + servicePointVOList[i].toString() + "</servicePointVO>",
                                                                servicePointVOList[i].toXml());
                                            
                                            // kalo tidak null, buat list
                                            
                                            if (servicePointVOList[i].getEquipment() != null) {
                                                printOutput.printToShell(apiParams, "Equipment Tidak null di service point " + i + "Length nya " + servicePointVOList[i].getEquipment().length,"");
                                                
                                                if (servicePointVOList[i].getEquipment().length != 0) {
                                                    if (servicePointVOList[i].getEquipment()[0].getSerialNumber().trim().equals(rs.getString(5))) {
                                                        posisiEquipmentServicepoint = i + 1;
                                                        printOutput.printToShell(apiParams, "FOUND equipment " + rs.getString(5) + " on Servicepoint ke " + posisiEquipmentServicepoint,"");
                                                    }
                                                }
                                                                                                
                                            } else {
                                                printOutput.printToShell(apiParams, "Equipment null di service point " + i ,"");
                                            }   

                                        }
                                        
                                        
                                }
                                else {
                                        printOutput.printToShell(apiParams, "servicePointVOList" + ":<servicePointVO> is null", null);
                                    
                                }
                            }
                            catch (AmspServiceException e)  {
                                    printOutput.printExceptionToShell(apiParams, "servicePointVOList", e);
                                throw new Exception(e.toString());
                            }
                            
                            // Set the equipment.
                            equipmentVO.setAction(apiParams.getEquipmentVOaction());                        
                            if (videoEquipmentConstraintsVO.getRating().getRequired()) {
                                equipmentVO.setRating("2"); //Valid Values: 0 = G, 1 = PG, 2 = R, 3 = X
                            }                        
                            equipmentVO.setLocation("1");
                            
                            // ini adalah equipment yg akan di masukin ke subscriber
                            equipmentVOlist[0] = equipmentVO;                            
                            
                             printOutput.printToShell(apiParams,
                                      ":<equipmentVO>" + equipmentVO.toString() + "</equipmentVO>",
                                     equipmentVO.toXml());                            
                            
                            // Set the service point                    
                            servicePointVOList[posisiEquipmentServicepoint-1].setAction(apiParams.getServicePointVOaction());
                            servicePointVOList[posisiEquipmentServicepoint-1].setServicePointEquipRemoval(apiParams.getServicePointEquipRemoval());
                            servicePointVOList[posisiEquipmentServicepoint-1].setEquipment(equipmentVOlist);  
                            
                            //Locking Account
                            lockOutputVO = lockServiceFacade.getAccountLock(customerID, 
                                                                            FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(), 
                                                                            apiParams.getCorp(), 
                                                                            aLogin.getTicket());
                            printOutput.printToShell(apiParams, "Account Lock Message: " + lockOutputVO.getMessage(), null);
                            
                            if (lockOutputVO.getStatus()){acctLock = true;}
                            else {acctLock = false;} 
                            
                            // Lock site dari site di customer detail.    
                            lockOutputVO = lockServiceFacade.getSiteLock(customerDetailsVO.getSiteId(), 
                                                                         FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
                                                                         apiParams.getCorp(), 
                                                                         aLogin.getTicket());
                            printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);                    
                            if (lockOutputVO.getStatus()){siteLock = true;}
                            else {siteLock = false;}
                            
                            // Lock Variable APC
                            lockOutputVO = lockServiceFacade.getApcVarLock(customerDetailsVO.getSiteId(), 
                                                                                   customerID, 
                                                                                   apiParams.getCorp(), 
                                                                                   aLogin.getTicket());
                            printOutput.printToShell(apiParams, "Variable Lock Message: " + lockOutputVO.getMessage(), null);
                            if (lockOutputVO.getStatus()){varLock = true;}
                            else {varLock = false;}
                            
                            if (siteLock && varLock && varLock) {
                                
                                try {
                                                        
                                    orderResultVO = opMainOrderOptionFacade.updateBoxData(servicePointVOList, 
                                                                                          customerID, 
                                                                                          customerDetailsVO.getSiteId(), 
                                                                                          apiParams.getServiceGroup(), 
                                                                                          apiParams.getCallerName(), 
                                                                                          apiParams.getOverriddenRuleIds(), 
                                                                                          false, 
                                                                                          apiParams.getCorp(), 
                                                                                          aLogin.getTicket());
                                    printOutput.printToShell(apiParams, 
                                    ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
                                     orderResultVO.toXml());
                                   printOutput.printToShell(apiParams,"SUCCESS REMOVE VC " + rs.getString(5) + " from Cust Id = " + customerID,"");

                                } catch (AmspServiceException e) {
                                        printOutput.printExceptionToShell(apiParams, "opMainOrderOptionFacade.updateBoxData", e);
                                    throw new Exception(e.toString());
                                }
                                
                            } else {
                                
                                throw new Exception("Locking issue, siteLock, varLock, AccountLock = " + siteLock + "," + varLock + ", " + acctLock );
                            }                              
                            
                            // Release Locking
                            // 11. Unlock site
                            lockOutputVO = lockServiceFacade.unLockSite( customerDetailsVO.getSiteId(), apiParams.getCorp(), aLogin.getTicket());
                            
                            printOutput.printToShell(apiParams, "Site unlock message: " + lockOutputVO.getMessage(), null);                 
                            
                            
                            // 11.B Unlock VAR
                            lockOutputVO = lockServiceFacade.unLockApcVarLock(customerDetailsVO.getSiteId(), customerID, apiParams.getCorp(), 
                                                                              aLogin.getTicket());
                            
                            printOutput.printToShell(apiParams, "Var unlock message: " + lockOutputVO.getMessage(), null);
                            
                            // 11.C Unlock Account
                            lockOutputVO = lockServiceFacade.unLockAccount(customerID, apiParams.getCorp(), aLogin.getTicket());
                            printOutput.printToShell(apiParams, "Account unlock message: " + lockOutputVO.getMessage(), null); 
                            
                            
                            // update DB kalo sukses di remove
                            dbl.updateQuery("UPDATE BULK_VC SET sys_update_date=sysdate, STATUS = 'DONE',NOTES='', CUSTOMER_ID='"+ customerID +"', SERVICEPOINT='"+posisiEquipmentServicepoint+"'  WHERE ID = " + rs.getString(1) );
                            printOutput.printToShell(apiParams, "Updating to database success..", null);                  
                            
                            
                        } else {
                            
                            printOutput.printToShell(apiParams, "Customer tidak valid di remove " + customerStatusCur, "");
                            dbl.updateQuery("UPDATE BULK_VC SET sys_update_date=sysdate, STATUS = 'FAILED', CUSTOMER_ID='"+ customerID +"', NOTES = '"+ "Customer tidak valid di remove, cust status =  " + customerStatusCur+"' WHERE ID = " + rs.getString(1) );
                        
                        }
                        
                    } 
                    else {
                        
                        printOutput.printToShell(apiParams, "Kartu tidak valid di remove " + equipmentVO.getBoxStatus(), "");
                        dbl.updateQuery("UPDATE BULK_VC SET sys_update_date=sysdate, STATUS = 'FAILED', NOTES = '"+ "Kartu tidak valid di remove , card status =  " + equipmentVO.getBoxStatus()+"' WHERE ID = " + rs.getString(1) );
                        
                    }
                    
                } catch (Exception exp) {
                    
                    printOutput.printToShell(apiParams, "Global Amdocs Expception " + exp.toString(), "");
                    dbl.updateQuery("UPDATE BULK_VC SET sys_update_date=sysdate, STATUS = 'FAILED', NOTES = SUBSTR('"+ "Global Amdocs Expception " + exp.toString()+"',1,498) WHERE ID = " + rs.getString(1) );
                                        
                }         
            
            }
            // Closing database connection
            rs.close();      
            dbl.releaseDblConnection();
            
            printOutput.printToShell(apiParams, "FINISH, CLOSING DB CONNECTION", "");
            printOutput.printToShell(apiParams, "-----------------------------", "");
            
            // 12. Logout
            aLogin.logInOut(aLogin.LOGOUT(), apiParams, printOutput); 
            
            //cleanup display and print file
            apiParams.finishOutput(apiParams, printOutput);
            printOutput.finishOutput(apiParams, printOutput);            
            
        }
        else {
            System.out.println("Login session is expired, please Relogin");
        }      
    }    
}
