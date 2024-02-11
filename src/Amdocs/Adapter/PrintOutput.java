package Amdocs.Adapter;


import amdocs.amsp.exception.AmspServiceException;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;



public class PrintOutput {
    
   
    private PrintWriter txtWriter = null;
    private PrintWriter xmlWriter = null;
    private String txtFileName = null;
    private String xmlFileName = null;
    
    static Logger log = Logger.getLogger(PrintOutput.class.getName());
    
    public PrintOutput() {
        super();
    }
    
    public void initOutput(Parameters apiParams, PrintOutput printOutput){
            
            
    }
    
    private void openFileFromExplorer(String fileName) {    
            try {
                    Runtime.getRuntime().exec("notepad " +  fileName);
            } catch (IOException e) {
                    System.out.println("Java IO Exception: " + e.getMessage());
            }
    }
    
    public void finishOutput (Parameters apiParams, PrintOutput printOutput){
           
    }
    
    public void printToShell (Parameters apiParams, String txtIn, String xmlIn) {
            
            System.out.println(txtIn);
            
            log.info(txtIn);
            
            
            /*
            switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
            case 0:
                    System.out.println(txtIn);
                    break;
            case 1:
                    textToDisplay.append(txtIn + "\n");
                    break;
            case 2:
                    textToDisplay.append(txtIn + "\n");
                    txtWriter.println(txtIn);
                    
                    if (xmlIn != null) {
                            xmlWriter.println(xmlIn);
                    }
                    break;
            }
*/
    }
    
    public void printExceptionToShell (Parameters apiParams, String offendingClass, AmspServiceException e) {
            StackTraceElement elements[] = e.getStackTrace();
            
            System.out.println(offendingClass + "<AmspServiceException>\n" +
                             "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                             "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                             "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                             "   <cause>"        + e.getCause()            + "</cause>\n" +
                             "</AmspServiceException>" + "\n"              +
                             "<StackTrace>\n");
            
            log.info(offendingClass + "<AmspServiceException>\n" +
                             "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                             "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                             "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                             "   <cause>"        + e.getCause()            + "</cause>\n" +
                             "</AmspServiceException>" + "\n"              +
                             "<StackTrace>\n");
            
            for (int i = 0, n = elements.length; i < n; i++) {       
                    System.out.println("   " + elements[i].getFileName()
                + ":" + elements[i].getLineNumber() 
                + ">> "
                + elements[i].getMethodName() + "()\n");
                    log.info("   " + elements[i].getFileName()
                    + ":" + elements[i].getLineNumber()
                    + ">> "
                    + elements[i].getMethodName() + "()\n");
        }
            
            System.out.println("</StaceTrace>\n");
        log.info("</StaceTrace>\n");
            
            /*switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
            case 0:

                    System.out.println(offendingClass + "<AmspServiceException>\n" +
                                     "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                                     "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                                     "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                                     "   <cause>"        + e.getCause()            + "</cause>\n" +
                                     "</AmspServiceException>" + "\n"              +
                                     "<StackTrace>\n");
                    for (int i = 0, n = elements.length; i < n; i++) {       
                            System.out.println("   " + elements[i].getFileName()
                        + ":" + elements[i].getLineNumber() 
                        + ">> "
                        + elements[i].getMethodName() + "()\n");
                }
                    System.out.println("</StaceTrace>\n");
                    break;
            case 1:
                    textToDisplay.append(offendingClass + "<AmspServiceException>\n" +
                                     "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                                     "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                                     "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                                     "   <cause>"        + e.getCause()            + "</cause>\n" +
                                     "</AmspServiceException>" + "\n"              +
                                     "<StackTrace>\n");
                    for (int i = 0, n = elements.length; i < n; i++) {       
                            textToDisplay.append("   " + elements[i].getFileName()
                        + ":" + elements[i].getLineNumber() 
                        + ">> "
                        + elements[i].getMethodName() + "()\n");
                }
                    textToDisplay.append("</StaceTrace>\n");
                    break;
            case 2:
                    textToDisplay.append(offendingClass + "<AmspServiceException>\n" +
                                     "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                                     "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                                     "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                                     "   <cause>"        + e.getCause()            + "</cause>\n" +
                                     "</AmspServiceException>" + "\n"              +
                                     "<StackTrace>\n");
                    for (int i = 0, n = elements.length; i < n; i++) {       
                            textToDisplay.append("   " + elements[i].getFileName()
                        + ":" + elements[i].getLineNumber() 
                        + ">> "
                        + elements[i].getMethodName() + "()\n");
                }
                    textToDisplay.append("</StaceTrace>\n");
                    
                    txtWriter.println(offendingClass + "<AmspServiceException>\n" +
                                     "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
                                     "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
                                     "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
                                     "   <cause>"        + e.getCause()            + "</cause>\n" +
                                     "</AmspServiceException>" + "\n"              +
                                     "<StackTrace>\n");
                    for (int i = 0, n = elements.length; i < n; i++) {       
                            txtWriter.println("   " + elements[i].getFileName()
                        + ":" + elements[i].getLineNumber() 
                        + ">> "
                        + elements[i].getMethodName() + "()\n");
                }
                    txtWriter.println("</StaceTrace>\n");
                    break;
            }*/
    }
}
