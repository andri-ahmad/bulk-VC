package Amdocs.Adapter;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.system.AmspAccessFacade;

public class Login {
        
    // variables            
    private static int LOGIN = 0;
    private static int LOGOUT = 1;
    private String ticketP = null;
    private AmspAccessFacade amspAccessF = new AmspAccessFacade();
    
    public boolean loginAndri (int action, Parameters apiParams, PrintOutput printOutput) {
        try {
                // login
                System.out.println("..Start to call amspAccessF.login...");
                ticketP = amspAccessF.login(apiParams.getUserid(),
                                                    apiParams.getPasswd(), 
                                                    apiParams.getLocale());
                
                if (ticketP == null) {
                        printOutput.printToShell(apiParams, getClass().getName() + " Login failed!", null);
                        return (false);
                }
                else {
                        printOutput.printToShell(apiParams, getClass().getName() + " Login succeeded", null);
                        printOutput.printToShell(apiParams, getClass().getName() + ":<ticketP>" + ticketP + "</ticketP>", null);
                        return (true);
                }
        } catch (Exception e) {
                System.out.println("Error from Class Login.LoginAndri() ++" + e.toString());
        }
        
        return (false);
    }
    
    
    public boolean logInOut (int action, Parameters apiParams, PrintOutput printOutput){
            switch (action){
                    case 0: {
                            try {
                                    // login
                                    ticketP = amspAccessF.login(apiParams.getUserid(),
                                                                        apiParams.getPasswd(), 
                                                                        apiParams.getLocale());
                                    
                                    if (ticketP == null) {
                                            printOutput.printToShell(apiParams, getClass().getName() + " Login failed!", null);
                                            return (false);
                                    }
                                    else {
                                            printOutput.printToShell(apiParams, getClass().getName() + " Login succeeded", null);
                                            printOutput.printToShell(apiParams, getClass().getName() + ":<ticketP>" + ticketP + "</ticketP>", null);
                                            return (true);
                                    }
                            } catch (AmspServiceException e) {
                                    printOutput.printExceptionToShell(apiParams, getClass().getName() + " Ada Eksepsi berikut : ", e);
                            }
                            break;
                    }
                    case 1: {
                            try {
                                    // logout
                                            if (amspAccessF.logout(ticketP)){
                                                    printOutput.printToShell(apiParams, getClass().getName() + ": Logout succeeded", null);
                                                    if (apiParams.getOutputMode() > 0 ) {
                                                            printOutput.printToShell(apiParams, "", null);
                                                            printOutput.printToShell(apiParams, "Close window to end run", null);
                                                    }
                                                    ticketP = null;
                                                    return (true);
                                            }
                                            else {
                                                    printOutput.printToShell(apiParams, getClass().getName() + ": Logout failed!", null);
                                                    if (apiParams.getOutputMode() > 0 ) {
                                                            printOutput.printToShell(apiParams, "", null);
                                                            printOutput.printToShell(apiParams, "Close window to end run", null);
                                                    }
                                                    ticketP = null;
                                                    return (false);
                                            }
                                    }
                                    catch (AmspServiceException e) {
                                            printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
                                    }
                            break;
                    }
                    default: {
                            printOutput.printToShell(apiParams, getClass().getName() + ": Unknown value passed", null);
                            break;
                    }
            } // end of switch
            return (false);
    } // end of LoginOut
    
    public String getTicket () {return (ticketP);}
    
    public int LOGIN() {return (LOGIN);}
    public int LOGOUT() {return (LOGOUT);}
}
