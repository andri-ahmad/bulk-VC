package Amdocs.Adapter;

import java.math.*;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import amdocs.core.Money;
import amdocs.amsp.AddressConstantsI;
import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.util.AmspUtil;
import amdocs.amsp.valueobject.opquery.QualifiersVO;
import amdocs.amsp.valueobject.servicepoint.ContractVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;

import java.util.Random;

public class Parameters {
    // add new operations that require specific parameter values to the bottom of this list and add
    // a matching case to the switch statement in the constructor

    private long startTime = 0;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
    private String startTimestamp = null;
    private String env_variable = null;
    
    // add new operations that require specific parameter values to the bottom of this list and add
    // a matching case to the switch statement in the constructor
    public static int TEMP_OPERATION              = 99;
    public static int NEW_PROSPECT                =  0;
    public static int NEW_PROSPECT_OFFER          =  1;
    public static int GET_AVAILABLE_PHONE_NUMBERS =  2;
    public static int DEMO                        =  3;
    public static int NEW_INSTALL                 =  4;
    public static int SEND_DIRECT_HIT             =  5;
    public static int CANCEL_SRO                  =  6;
    public static int OPERATOR                    =  7;
    public static int GET_TECH_JOBS               =  8;
    public static int ASSIGN_EQUIP                =  9;
    public static int CHANGE_UPGRADE_HOLD         = 10;
    public static int CREATE_NEW_ENT_SALESMAN     = 11;
    public static int UPDATE_ENT_SALESMAN         = 12;
    public static int CREATE_SITE                 = 13;
    public static int PROSPECT_OFFER_SITE         = 14;
    public static int UPDATE_CUST_DATA            = 15;
    public static int PROSPECT_OFFER_SITE_TOOL    = 16;
    public static int UPDATE_ENTERPRISE_OPERATOR  = 17;
    public static int PROSPECT_OFFER_SITE_DEMO    = 18;
    public static int RE_ASSIGN_TECH_JOBS         = 19;
    public static int CHANGE_OF_SERVICE           = 20;
    public static int CONSTRAINTS_DUMP            = 21;
    public static int PAYCARD_INFO                = 22;
    public static int CHANGE_OF_SERVICE_2         = 23;
    public static int RESCHEDULE_COS_CHANGE       = 24;
    public static int GET_TELEPHONY_SERVICES      = 25;
    public static int GET_ACCOUNT_SERVICE_POINTS  = 26;
    public static int LOCK                        = 27;
    public static int UPDATE_ENT_TECHNICIAN       = 28;
    public static int BROWSE_EQUIPMENT            = 29;
    public static int REMOVE_EQUIP                = 30;
    public static int GET_EQUIPMENT_DETAILS       = 31;
    public static int COMPLETE_COS_JOB            = 32;
    public static int NOT_DONE_ALERT_STATUS       = 33;
    public static int GET_CODE_TABLE              = 34;
    public static int RESCHEDULE_COS_DATES_ONLY   = 35;
    public static int RESCHEDULE_SRO              = 36;
    public static int COMPLETE_SRO_JOB            = 37;
    public static int PAYMENTS                    = 38;
    public static int LOGIN                       = 39;
    public static int STAY_ALIVE                  = 40;
    public static int BROWSE_BY_ADDRESS           = 41;
    public static int MOVE_EQUIP_OTHER_SP         = 42;
    public static int GET_PREDICTED_ENDING_BALANCE= 43;
    public static int DISCONNECT_NO_TRUCK         = 44;
    public static int CREATE_TC                   = 45;
    public static int CREATE_SRO                  = 46;
    public static int DISCONNECT_SCHEDULE         = 47;
    public static int UPDATE_ACCOUNT_COMMENTS     = 48;
    public static int GET_ALL_FINANCIALS          = 49;
    public static int COMPLETE_TC_JOB             = 50;
    public static int DIRECT_PAYMENT_ADJUSTMENT   = 51;
    public static int DIRECT_PAYMENT_ADJUSTMENT_TOOL = 53;
    public static int ADD_MDU_SITE_UNITS_TOOL     = 54;
    public static int GET_CONTRACTS               = 55;
    public static int GET_PACKAGES                = 56;
    public static int UPDATE_DAILY_CHECKIN_ACCOUNT_ADD_EQUIPMENT = 57;
    public static int NEW_INSTALL_WITH_EQUIP = 58;
    public static int RESCHEDULE_ORDER = 59;
    public static int RESCHEDULE_ORDER_WITH_EQUIP = 60;
    public static int EQUIPMENT_CHECK = 61;
    public static int UNASSIGN_EQP = 62;
    
    public static short EQUIPMENT_VO_ACTION_NO_CHANGE = 0; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
    public static short EQUIPMENT_VO_ACTION_CHANGE    = 1;
    public static short EQUIPMENT_VO_ACTION_ADD       = 2;
    public static short EQUIPMENT_VO_ACTION_REMOVE    = 3;
    
    public static short SERVICE_POINT_VO_ACTION_NO_CHANGE = 0; // valid values are :no change = 0, change = 1, add = 2, remove = 3
    public static short SERVICE_POINT_VO_ACTION_CHANGE    = 1;
    public static short SERVICE_POINT_VO_ACTION_ADD       = 2;
    public static short SERVICE_POINT_VO_ACTION_REMOVE    = 3;    

    public static short EQUIPMENT_VO_MOVEMENT_VALIDATION = -1; // Valid values -1 = Validation action, 0 = No equipment movement, 1 = equipment movement occured.
    public static short EQUIPMENT_VO_MOVEMENT_NO_MOVE    = 0;
    public static short EQUIPMENT_VO_MOVEMENT_MOVE       = 1;
            
    // App
    private String     appName          = "API Testing Client";
    private String     appVersion       = "1.2";
    private String     amspVersion      = "9.0";
    
    // API test app settings
    private String     file_name       = "API_output";
    private String     file_path       = "c:\\temp\\";  // Double backslashes are "escaped" single backslashes
    private int        outputMode      = 2;  // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
    
    // These values are set in the initParameters() Method based on environment variable API_TARGET (DMZ or ORT) set in launch script         
    //private String     corp            = "46099";
    private String     corp            = "46030";        
    private String     user            = null;
    private String     password        = null;
    
    private String     locale          = FrameworkConstantsI.DEFAULT_LOCALE;

    // Add new operational parameters here and to the printParameters in case statement
    //    1. Create and initialize them here
    //    2. Create a get method for them below
    //    3. Set and print the value in the appropriate section of the case statement
    private int        accountingArea           = -1;
    private int        accountCategory          = -1;
    private int        acctPriceStructId        = 0;
    private int        addressUse               = -1;
    private int        addressType              = -1;   // Valid Values: 1=business ,2= residential
    private Money      adjustmentAmount         = null;
    private String     adjustmentCode           = null;
    private String     aging                    = null; // Aging to which adjustment should be applied.Valid Values: 0 = Current, 1 = 30 day, 2 = 60 day, 3 = 90 day, 4 = 120 day
    private Money      amount                   = null;
    private Money      amountTendered           = null;
    private short      allowInvalidZip          = -1;   // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
    private Money      batchAmount                          = null; // The total amount for this batch. Valid Values: unknown .
    private Money      batchCash                            = null; // Drawer Tally cash amount. Valid Values: unknown
    private Money      batchCheque                          = null; // Drawer Tally Cheque amount. Valid Values: unknown
    private short      batchClose               = -1;   // Close an exiting batch. Valid Values : 0,1.
    private short      batchContinue            = -1;   // Continue an existing batch. Valid Values: 0,1
    private Money      batchCreditCard          = null; // Drawer Tally Credit Card amount. Valid Values: unknown 
    private String     batchCtrlgroup           = null; // Batch control group. Valid Values: unknown .
    private short      batchDone                = -1;   // Valid Values 0,1.
    private Money      batchElectronicCheq      = null; // Drawer Tally eCheck amount. Valid Values: unknown.
    private short      batchNew                 = -1;   // New batch to open. Valid Values : 0,1(open a new batch) .
    private int        batchNumber              = -1;   // Batch Number. Valid Values: 1-9999 .
    private int        batchNumberTarget        = -1;   // Batch Number. Valid Values: 1-9999 .
    private Money      batchOther               = null; // Drawer Tally other amount. Valid Values: unknown .
    private Money      batchPostal              = null; // Drawer Tally Postal amount. Valid Values: unknown .
    private String     batchStatus              = null; // Current status of the batch. Valid Values: Blank=Closed,3= Open/Busy
    private String     batchType                = null; // Batch Type. Valid Values: P = Payment and A = Adjustment.
    private Date       billDate                 = null;
    private String     billForm                 = null; // char(5) Billing form (36 code table number 124)
    private Date       beginDateTime            = null;
    private String     callerName               = null; // char(9)
    private String     campaignCode             = null; // char(20)
    private short      cancelNpd                = 0;
    private String     cancelReason             = null; // char(5) WIP Cancel reason (36 code table number 133
    private String     changeReason             = null; // char(5) WIP Change reason (36 code table number xxx
    private Date       changeTime               = null;
    private Date       cdwDate                  = null;
    private String     checkinAlert             = null;
    private String     codCode                  = null;
    private String     collStatAgencyCode       = null;
    public short       collStatClass            = 0;
    public short       collStatClose            = 0;
    public String      collStatComments         = null;
    private Date       collStatDate             = null;
    private String     collStatCancelReason     = null;
    private String     collStatPath             = null;
    private String     collStatStep             = null;
    private boolean    colStatPpvHold           = false;
    private String     comment                  = null; // varies by us
    private int        commentTypeSelect        = 0;
    private Date       completeDate             = null;
    private Date       completeTime             = null;
    private int        contractStatusOption     = 0;
    private long       contractTemplateId       = 0;
    private String[]   corpSet                  = {""};
    private String     corpSetTarget            = null;
    private String     cust_acct                = null; // char(8)
    private String     cust_acct2               = null; // char(8)
    private String     custClassCode            = null;
    private boolean    customPointsAllowed      = false;
    private int        cycle                    = -1;
    private Date       dateOfBirth              = null;
    private String     disconnectReasonCode     = null;
    private Money      dMoney                   = null; // Money collected on this job.Valid Values: 0-999999999999
    private String     dSeq                     = null; // Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.
    private boolean    duplicateAddressFlag     = false;
    private String     equipmentId              = null; // char(14) bmumb in boxinvtry
    private Date       effectiveDate            = null;
    private int        effectiveDateFlag        = 0;
    private String     equipmentLocation        = null;
    private short      equipmentVOaction        = -1;   //Valid Values:no change = 0, change = 1, add = 2, remove = 3
    private String     enterpriseId             = null;
    private String     firstName                = null; // char(20)
    private String     fromTech                 = null; // char(6)
    private Date       highDate                 = new Date("30-dec-3500");
    private String     homePhone                = null; // char(14)
    private String     houseInfo                = null; // char(5)
    private String     initial                  = null; // char(2)
    private boolean    isAdjustment             = false;
    private boolean    isProspect               = false;
    private short      blankOutFlag             = 0;
    private boolean    isEcheck                                     = false;
    private boolean    isFrontCounterMode       = false;
    private boolean    isMustDo                 = false;
    private boolean    isPayCard                = false;
    private boolean    isPayment                            = false;
    private int        installType              = -1;   // New move in type order. Valid Values: 1 = New move in order 
    private boolean    isOffer                  = false;
    private int        jobType                  = -1;
    private String     lastName                 = null; // char(20)
    private int        newCycle                 = 0;
    private BigDecimal offerNum                 = null; // = new BigDecimal("5909");
    private String     operatorId               = null; // char(3)
    private String     operatorStatus           = null; // char(1)
    private String     optionCode               = null; // char(5)
    private int        optionId                 = 0;
    private String     orderComment             = null;
    private short      orderInfoVOaction        = -1;
    private BigDecimal orderGroupSeq            = null;
    private int        orderType                = -1;
    private String[]   overriddenRuleIds        = {"",""};
    private String     otherPhone               = null;
    private int        outlet                   = 0;
    private int        outletTarget             = 0;
    private String     packageCode              = null; // char(2)
    private String     paymentKind                          = null;
    private String     paymentReference             = null;
    private ContractVO[] pendingContractIds     = null;
    private String     phoneClass               = null; // char(2) PHONE_NUM_CLAS column from PHONE_NUMBER_INVENTORY
    private String     phoneNumber              = null; // char(14)
    private boolean    phoneNumberReplaceFlag   = false;
    private int        phoneNumSearch           = -1;
    private short      phoneVOaction            = -1;
    private boolean    plant                    = false;
    private short      points                   = -1;
    private int        priceStructId            = 0;
    private String     printFileCode            = null; // char(1)
    private String     prevSerialNumber         = null;
    private String     productLanguage          = null; // char(5) Product Language identifier code 36 table 167
    private QualifiersVO[] qualifiersVOList = null;
    private short      quotaGroupCode           = 0;
    private short      quotaTimeSlotCode        = 0;
    private String     rateCode1                = null; // char(2)
    private String     rateCode2                = null; // char(2)
    private String     rateCode3                = null; // char(2)
    private String     rateCode4                = null; // char(2)
    private short      rateCodeVOaction         = -2;   // -1=Inactive, no change = 0, change = 1, add = 2, remove = 3
    private short      promoVOaction            = -2;   // -1=Inactive, no change = 0, change = 1, add = 2, remove = 3
    private String     reason                   = null; // adjustment reason
    private String     reasonCode               = null;
    private String     refrenceNumber                       = null; // 20 char alpha-numeric maps to batchdetil.pmt_ref
    private boolean    queueHsdsHitFlag         = false;
    private String     reminderScheme           = null; // char(5) Reminder scheme for collection process (36 code table number 122)
    private String     salesRepId               = null; // char(6) 
    private Date       scheduleDate             = null;
    private int        scheduleType             = -1;
    private int        scheduleAction           = -1;
    private short      scheduleVOaction         = -1;
    public String      serialNumber             = null;
    private int        serviceGroup             = -1;
    private String     servicePackage           = null; // char(2)
    private int        servicePoint             = -1;
    private boolean    servicePointEquipRemoval = false;
    private int        servicePointTarget       = -1;
    private String     servicePointLocationCode = null; // char(5) 36 code table number 163
    private ServicePointVO[] servicePointVOlist = null;
    private short      servicePointVOaction     = -1;   // valid values are :no change = 0, change = 1, add = 2, remove = 3
    private String     siteId                   = null; // char(8)
    private String     skillLevel               = null; // char(1)
    private Boolean    skipPayCard              = false;
    private Boolean    skipServicePointData     = false;
    private String     specialInstruct1Code     = null;
    private String     sroFixCode               = null;
    private String     sroFixDesc               = null;
    private Date       startStmtDate            = null;
    private Date       stopStmtDate             = null;
    private Date       statementDate            = null;
    private String     statementScheme          = null; // char(5) Valid Values: A - D Must be in the parameter statement scheme table
    private int        status                   = -1;   // used in SalesmanDetailsVO
    private short      statusCode               = 0;    // Job status code. Valid Values: 2 = Not done, 3 = Alert. Used in DispatchJobsFacade.notDoneAlertStatus() 
    private String[]   suiteList                = null;
    private String     tag                      = null; // char(7) Tag number for this drop. Valid Values: Alphanumeric String
    private String     taskCode                 = null; // char(10) code95 table number 201
    private String     tcFixCode                = null;
    private String     tcFixDesc                = null;
    private String     techId                   = null; // char(6)
    private String     toTech                   = null; // char(6)
    private String     type                     = null; // used in SalesmanDetailsVO
    private String     typeCode                 = null; // Customer Type
    private boolean    upgradeHold              = false;
    private String     userName                 = null; // used in getEnterpriseOperator
    private short      validateOnlyFlg          = 0;
    private short      checkinOption            = 0;
    private short      mvtStatusCode            = 0;
    private String     notDoneCode              = null;
    private short      sarSentFlag              = 0;
    private short      equipMovementFlag        = -1;
    private String     personnalId        = null;
    private String     emailAddress        = null;
    private String     mobilePhone        = null;

    @SuppressWarnings("deprecation")
    
    public void initParameters (int operation, Parameters apiParams, PrintOutput printOutput) {
                    
        printCommonParameters(apiParams, printOutput);
        
        switch (operation) {
        
            case 4: // NEW_INSTALL
                    printOutput.printToShell (apiParams, "   NEW_INSTALL Operation Initial Parameter Values",  null);
                    this.setAccountCategory(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
                    this.setAccountingArea(apiParams, printOutput, 1);
                    this.setAcctPriceStructId(apiParams, printOutput, 0); // Zero is default Price Structure
                    this.setBillDate(apiParams, printOutput, new Date(this.getSystemDate()));
                    this.setCampaignCode(apiParams, printOutput, "4");                    
                    this.setCallerName(apiParams, printOutput, "API");
                    this.setContractStatusOption(apiParams, printOutput, 1); // Contract status value. Valid values 1 - Active Contracts, 2 - Terminated Contracts, 4 - Expired contracts, 8 - Future effective contracts, 16 - Pending Termination contracts, 32 - Pending Addition contracts. For multiple contracts status' add the corresponding values.
                    this.setContractTemplateId(apiParams, printOutput, 0); // Updated at runtime 
                    this.setCust_acct(apiParams, printOutput, "0"); // must be 0 for new Account
                    this.setCustClassCode(apiParams, printOutput, "REGSV");                    
                    this.setDateOfBirth(apiParams, printOutput, new Date("14-Feb-1990"));
                    this.setCycle(apiParams, printOutput, 15);
                    this.setEffectiveDate(apiParams, printOutput, new Date(this.getSystemDate()));
                    this.setEffectiveDateFlag(apiParams, printOutput, 0); //This field is used only during COS order.Valid values are 1 - Add effective date before,2 - Add effective date after, 3 - Add with same effective date
                    this.setHomePhone(apiParams, printOutput, this.generateRandomNumberString(15));
                    this.setInstallType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
                    this.setIsMustDo(apiParams, printOutput, false);
                    this.setIsOffer(apiParams, printOutput, false);
                    this.setIsProspect(apiParams, printOutput, false);
                    this.setBlankOutFlag(apiParams, printOutput, (short)0);
                    this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue());
                    //this.setLastName(apiParams, printOutput, this.generateRandomNumberString(5));
                    this.setFirstName(apiParams, printOutput, "DODOL_GARUT");
                    this.setLastName(apiParams, printOutput, "YUMARTHA");
                    this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
                    this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
                    this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
                    this.setOverriddenRuleIds(apiParams, printOutput, "");
                    this.setPackageCode(apiParams, printOutput, null); // Set at runtime
                    this.setPendingContractIds(apiParams, printOutput, null); // Optional parameter not needed for new Install Order
                    this.setPoints(apiParams, printOutput, (short)0);
                    this.setProductLanguage(apiParams, printOutput, "1");
                    this.setRateCode1(apiParams, printOutput, "VP");
                    this.setRateCodeVOaction(apiParams, printOutput, (short)2); // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
                    this.setReminderScheme(apiParams, printOutput, "1    "); 
                    this.setSalesRepId(apiParams, printOutput, "000001");
                    this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_SCHEDULE);
                    this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 = Add
                    this.setServiceGroup(apiParams, printOutput, 1);
                    this.setServicePackage(apiParams, printOutput,""); // To be set at runtime eventually
                    this.setServicePoint(apiParams, printOutput, 1); 
                    this.setServicePointLocationCode(apiParams, printOutput, "1"); // API Test location
                    this.setServicePointVOaction(apiParams, printOutput, (short)2); // no change = 0, change = 1, add = 2, remove = 3
                    this.setSiteId(apiParams, printOutput, "00000016");
                    this.setSpecialInstruct1Code(apiParams, printOutput, "5");
                    this.setStatementScheme(apiParams, printOutput, "A    ");
                    this.setTaskCode(apiParams, printOutput, "1");
                    this.setTechId(apiParams, printOutput, "999");
                    this.setTypeCode(apiParams, printOutput, "TEST");
                    this.setPersonnalId(apiParams, printOutput, "3175051306810004");
                    this.setEmailAddress(apiParams, printOutput, "LOLA LUBELA");
                    this.setMobilePhone(apiParams, printOutput, "0818126374");
        
                    break;
        
            case 9: // ASSIGN_EQUIP
                    appName = "Assign Equipment";
                    printOutput.printToShell (apiParams, "   ASSIGN_EQIP Operation Parameter Values",  null);
                    cust_acct = "10281489";                    
                    equipmentId = "   42668773866"; // Equipment that is not on an Account
                    equipmentVOaction = 2; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
                    orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
                    orderType = ServiceConstantsI.OrderType.ORDER_CHANGE_BOX.getOrderTypeValue();
                    outlet = 1;
                    overriddenRuleIds[0] = "";
                    overriddenRuleIds[1] = "";
                    serviceGroup = 1;
                    servicePointVOaction = 1; // valid values are :no change = 0, change = 1, add = 2, remove = 3
                    siteId   = "00217231";
                    this.setServicePoint(apiParams, printOutput, 1);
                    this.setCallerName(apiParams, printOutput, "TEST-API");
            
            
                    printOutput.printToShell (apiParams, "Parameter:Cust_acct           : " + cust_acct,            null);
                    printOutput.printToShell (apiParams, "Parameter:equipmentId         : " + equipmentId,          null);
                    printOutput.printToShell (apiParams, "Parameter:equipmentVOaction   : " + equipmentVOaction,    null);
                    printOutput.printToShell (apiParams, "Parameter:orderGroupSeq       : " + orderGroupSeq,        null);
                    printOutput.printToShell (apiParams, "Parameter:orderType           : " + orderType,            null);
                    printOutput.printToShell (apiParams, "Parameter:outlet              : " + outlet,               null);
                    printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds   : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
                    printOutput.printToShell (apiParams, "Parameter:serviceGroup        : " + serviceGroup,         null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointVOaction: " + servicePointVOaction, null);
                    printOutput.printToShell (apiParams, "Parameter:siteId             : " + siteId,              null);
                    break;
        
            case 13: //CREATE_SITE
                    printOutput.printToShell (apiParams, "   CREATE_SITE Operation Initial Parameter Values",  null);
                    
                    addressType = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
                    addressUse = AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue();
                    allowInvalidZip = 0; // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
                    callerName = "API"; // char(9) causes FML buffer error if too big
                    corpSet[0] = this.getCorp();
                    cust_acct = "0"; // must be zero to work
                    duplicateAddressFlag = false;
                    orderType = ServiceConstantsI.NO_TRUCK;
                    plant = false;
                    scheduleAction = ServiceConstantsI.NO_TRUCK;
                    siteId   = "00001519"; // 99504 base site to be used in browse
                    printOutput.printToShell (apiParams, "Parameter:addressType         : " + addressType,          null);
                    printOutput.printToShell (apiParams, "Parameter:addressUse          : " + addressUse,           null);
                    printOutput.printToShell (apiParams, "Parameter:allowInvalidZip     : " + allowInvalidZip,      null);
                    printOutput.printToShell (apiParams, "Parameter:callerName          : " + callerName,           null);
                    printOutput.printToShell (apiParams, "Parameter:corpSet[0]         : " + corpSet[0],          null);
                    printOutput.printToShell (apiParams, "Parameter:Cust_acct           : " + cust_acct,            null);
                    printOutput.printToShell (apiParams, "Parameter:duplicateAddressFlag: " + duplicateAddressFlag, null);
                    printOutput.printToShell (apiParams, "Parameter:plant               : " + plant,                null);
                    printOutput.printToShell (apiParams, "Parameter:siteId             : " + siteId,              null);
                    break;
        
            case 20: // CHANGE_OF_SERVICE
                    printOutput.printToShell (apiParams, "   CHANGE_OF_SERVICE Operation Initial Parameter Values",  null);
                    billDate = new Date(this.getSystemDate());
                    billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
                    callerName = "APIclient"; // char(9)
                    codCode = "2";
                    changeReason = "API";
                    cust_acct = "10213085";
                    installType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
                    //installType = 1; // installType - New move in flag
                    isMustDo = false;
                    isProspect = false;
                    jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue();
                    orderGroupSeq = new BigDecimal(1); // Zero to get all Service Points
                    orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
                    orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
                    overriddenRuleIds[0] = "";
                    overriddenRuleIds[1] = "";
                    queueHsdsHitFlag = false;                    
                    this.setRateCode1(apiParams, printOutput, "RX");
                    this.setRateCodeVOaction(apiParams, printOutput, (short)2); // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
                    this.setPromoVOaction(apiParams, printOutput, (short)2);
                    
                    salesRepId = "000001";
                    scheduleDate = new Date(this.getSystemDate());
                    scheduleType = ServiceConstantsI.NO_TRUCK;
                    scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
                    servicePoint = 1;
                    servicePointTarget = 2; // Service Point number to add to
                    servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
                    //siteId   = "00273961";
                    taskCode = "API";
                    techId = "999";  // No Truck Tech
                    this.setSpecialInstruct1Code(apiParams, printOutput, "5");
                    
                    printOutput.printToShell (apiParams, "   CHANGE_OF_SERVICE Operation Initial Parameter Values",          null);
                    printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
                    printOutput.printToShell (apiParams, "Parameter:billForm             : " + billForm,             null);
                    printOutput.printToShell (apiParams, "Parameter:callerName           : " + callerName,           null);
                    printOutput.printToShell (apiParams, "Parameter:changeReason         : " + changeReason,         null);
                    printOutput.printToShell (apiParams, "Parameter:codCode              : " + codCode,              null);
                    printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
                    printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
                    printOutput.printToShell (apiParams, "Parameter:isProspect        : " + isProspect,              null);
                    printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
                    printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
                    printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
                    printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
                    printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
                    printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
                    printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
                    printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
                    printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);

                    break;
                
        case 30: // PAYMENTS    
                printOutput.printToShell (apiParams, "   PAYMENTS Operation Parameter Values", null);
                amount = new Money(0.00);
                printOutput.printToShell (apiParams, "Parameter:amount            : " + amount, null);
                amountTendered = new Money(0.00);
                printOutput.printToShell (apiParams, "Parameter:amountTendered    : " + amountTendered, null);
                batchClose = 0; // Close an exiting batch. Valid Values : 0,1.
                printOutput.printToShell (apiParams, "Parameter:batchClose        : " + batchClose, null);
                batchContinue = 0; // Continue an existing batch. Valid Values: 0,1
                printOutput.printToShell (apiParams, "Parameter:batchContinue     : " + batchContinue, null);
                batchCtrlgroup = "API";
                printOutput.printToShell (apiParams, "Parameter:batchCtrlgroup    : " + batchCtrlgroup, null);
                batchDone= 0; //Valid Values 0,1.
                printOutput.printToShell (apiParams, "Parameter:batchDone         : " + batchDone, null);
                batchNew = 1; //New batch to open. Valid Values : 0,1(open a new batch) .
                printOutput.printToShell (apiParams, "Parameter:batchNew          : " + batchNew, null);
                batchNumber = 0; // Batch Number. Valid Values: 1-9999 .
                printOutput.printToShell (apiParams, "Parameter:batchNumber       : " + batchNumber, null);
                batchNumberTarget = 9290; // Batch Number. Valid Values: 1-9999 .
                printOutput.printToShell (apiParams, "Parameter:batchNumberTarget : " + batchNumberTarget, null);
                batchStatus = "3"; // Current status of the batch. Valid Values: Blank=Closed,3= Open/Busy
                printOutput.printToShell (apiParams, "Parameter:batchStatus       : " + batchStatus, null);
                batchType = "P"; // Batch Type. Valid Values: P = Payment and A = Adjustment.
                printOutput.printToShell (apiParams, "Parameter:batchType         : " + batchType, null);
                callerName = "API";
                printOutput.printToShell (apiParams, "Parameter:callerName        : " + callerName, null);
                cust_acct = "10000226";                    
                printOutput.printToShell (apiParams, "Parameter:cust_acct         : " + cust_acct, null);
                cust_acct2 = "45466258";                    
                printOutput.printToShell (apiParams, "Parameter:cust_acct2        : " + cust_acct2, null);
                isEcheck = false;
                printOutput.printToShell (apiParams, "Parameter:isEcheck          : " + isEcheck, null);
                isFrontCounterMode = false;
                printOutput.printToShell (apiParams, "Parameter:isFrontCounterMode: " + isFrontCounterMode, null);
                isPayment = true;
                printOutput.printToShell (apiParams, "Parameter:isPayment         : " + isPayment, null);
                paymentKind = "32";
                printOutput.printToShell (apiParams, "Parameter:paymentKind       : " + paymentKind, null);
                serviceGroup = 1;
                printOutput.printToShell (apiParams, "Parameter:serviceGroup      : " + serviceGroup, null);
                siteId   = null;                     
                printOutput.printToShell (apiParams, "Parameter:siteId            : " + siteId,               null);
        break;
        
        case 31: // LOGIN
                printOutput.printToShell (apiParams, "   LOGIN Operation Parameter Values", null);
                printOutput.printToShell (apiParams, "Parameter:corpd            : " + corp, null);
                printOutput.printToShell (apiParams, "Parameter:user            : " + user, null);
                printOutput.printToShell (apiParams, "Parameter:password    : " + password, null);
        break;
        
        
        case 57:   //UPDATE_DAILY_CHECKIN_ACCOUNT_ADD_EQUIPMENT
            
                printOutput.printToShell (apiParams, "   UPDATE_DAILY_CHECKIN_ACCOUNT_ADD_EQUIPMENT Operation Parameter Values",  null);
                //this.setCdwDate(apiParams, printOutput, new Date("5-JAN-2018"));
                this.setCancelReason(apiParams, printOutput, "API");
                this.setCheckinOption(apiParams, printOutput, (short)1); //The check - in options 1 - complete, 2- bypass, 3 - cancel
                this.setCust_acct(apiParams, printOutput, "10286563");
                this.setDseq(apiParams, printOutput, " 1A"); // Note: A leading space must be used when Dseq is less that 3 characters
                                                            //12345678901234
                this.setEquipmentId(apiParams, printOutput,  "   42611574841");
                this.setSerialNumber(apiParams, printOutput, "   42611574841");
                this.setEquipmentLocation(apiParams, printOutput, "1    ");
                this.setEquipMovementFlag(apiParams, printOutput, (Parameters.EQUIPMENT_VO_MOVEMENT_NO_MOVE)); // Valid values -1 = Validation action, 0 = No equipment movement, 1 = equipment movement occured.
                this.setEquipmentVOaction(apiParams, printOutput, (short)2); //Valid Values:no change = 0, change = 1, add = 2, remove = 3
                this.setMvtStatusCode(apiParams, printOutput, (short)1); // Job status keyed in dispatch.Valid Values: 1 = Complete, 2 = Not done, 3 = Alert number, 4 = Next, 5 = Reschedule, 6 = Cancel, 9 = Reassign
                this.setNotDoneCode(apiParams, printOutput, null);
                this.setOfferNum(apiParams, printOutput, new BigDecimal(2027179));
                this.setOptionCode(apiParams, printOutput, "");
                this.setOptionId(apiParams, printOutput, ServiceConstantsI.WipOrderType.WIP_ORDER_TYPE_INSTALL.getWipOrderTypeValue());
                this.setOrderInfoVOaction(apiParams, printOutput, (short)1);
                this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
                this.setOutlet(apiParams, printOutput, 1);
                this.setOverriddenRuleIds(apiParams, printOutput, "");
                this.setSarSentFlag(apiParams, printOutput, (short)0);
                this.setServicePointVOaction(apiParams, printOutput, (short)1); // no change = 0, change = 1, add = 2, remove = 3
                this.setSiteId(apiParams, printOutput, "00217231");
                this.setSkipPayCard(apiParams, printOutput, true);
                this.setTechId(apiParams, printOutput, "999");
                this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_TRUCK);
                this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 = Add
                this.setIsMustDo(apiParams, printOutput, false);
            
            
        break;
        
            case 58: // NEW_INSTALL_WITH_EQUIP
                    printOutput.printToShell (apiParams, "   NEW_INSTALL_WITH_EQUIP Operation Initial Parameter Values",  null);
                    this.setAccountCategory(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
                    this.setAccountingArea(apiParams, printOutput, 1);
                    this.setAcctPriceStructId(apiParams, printOutput, 0); // Zero is default Price Structure
                    this.setBillDate(apiParams, printOutput, new Date(this.getSystemDate()));
                    this.setCampaignCode(apiParams, printOutput, "113");                    
                    this.setCallerName(apiParams, printOutput, "API");
                    this.setContractStatusOption(apiParams, printOutput, 1); // Contract status value. Valid values 1 - Active Contracts, 2 - Terminated Contracts, 4 - Expired contracts, 8 - Future effective contracts, 16 - Pending Termination contracts, 32 - Pending Addition contracts. For multiple contracts status' add the corresponding values.
                    this.setContractTemplateId(apiParams, printOutput, 0); // Updated at runtime 
                    this.setCust_acct(apiParams, printOutput, "0"); // must be 0 for new Account
                    this.setCustClassCode(apiParams, printOutput, "REGSV");
                    this.setDateOfBirth(apiParams, printOutput, new Date("14-Feb-1990"));
                    this.setCycle(apiParams, printOutput, 15);
                    this.setEffectiveDate(apiParams, printOutput, new Date(this.getSystemDate()));
                    this.setEffectiveDateFlag(apiParams, printOutput, 0); //This field is used only during COS order.Valid values are 1 - Add effective date before,2 - Add effective date after, 3 - Add with same effective date
                    this.setHomePhone(apiParams, printOutput, this.generateRandomNumberString(10));
                    this.setInstallType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
                    this.setIsMustDo(apiParams, printOutput, false);
                    this.setIsOffer(apiParams, printOutput, false);
                    this.setIsProspect(apiParams, printOutput, false);
                    this.setBlankOutFlag(apiParams, printOutput, (short)0);
                    this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue());
                    //this.setLastName(apiParams, printOutput, this.generateRandomNumberString(5));
                    this.setFirstName(apiParams, printOutput, "DODOL_GARUT");
                    this.setLastName(apiParams, printOutput, "YUMARTHA");
                    this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
                    this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
                    this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
                    this.setOverriddenRuleIds(apiParams, printOutput, "");
                    this.setPackageCode(apiParams, printOutput, null); // Set at runtime
                    this.setPendingContractIds(apiParams, printOutput, null); // Optional parameter not needed for new Install Order
                    this.setPoints(apiParams, printOutput, (short)0);
                    this.setProductLanguage(apiParams, printOutput, "1");
                    this.setRateCode1(apiParams, printOutput, "PL");
                    this.setRateCodeVOaction(apiParams, printOutput, (short)2); // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
                    this.setReminderScheme(apiParams, printOutput, "1    "); 
                    this.setSalesRepId(apiParams, printOutput, "000001");
                    this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_TRUCK);
                    this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 = Add
                    this.setServiceGroup(apiParams, printOutput, 1);
                    this.setServicePackage(apiParams, printOutput,""); // To be set at runtime eventually
                    this.setServicePoint(apiParams, printOutput, 1); 
                    this.setServicePointLocationCode(apiParams, printOutput, "1"); // API Test location
                    this.setServicePointVOaction(apiParams, printOutput, (short)2); // no change = 0, change = 1, add = 2, remove = 3
                    this.setSiteId(apiParams, printOutput, "00217231");
                    this.setSpecialInstruct1Code(apiParams, printOutput, "5");
                    this.setStatementScheme(apiParams, printOutput, "A    ");
                    this.setTaskCode(apiParams, printOutput, "1");
                    this.setTechId(apiParams, printOutput, "999");
                    this.setTypeCode(apiParams, printOutput, "MMP ");
            
                    this.setEquipmentId(apiParams, printOutput,  "   41475316224");
                    this.setSerialNumber(apiParams, printOutput, "   41475316224");
                    this.setEquipmentLocation(apiParams, printOutput, "2    ");
                    this.setEquipMovementFlag(apiParams, printOutput, (Parameters.EQUIPMENT_VO_MOVEMENT_NO_MOVE)); // Valid values -1 = Validation action, 0 = No equipment movement, 1 = equipment movement occured.
                    this.setEquipmentVOaction(apiParams, printOutput, (short)2); //Valid Values:no change = 0, change = 1, add = 2, remove = 3
                    this.setMvtStatusCode(apiParams, printOutput, (short)1); // Job status keyed in dispatch.Valid Values: 1 = Complete, 2 = Not done, 3 = Alert number, 4 = Next, 5 = Reschedule, 6 = Cancel, 9 = Reassign
                    
                    break;
        
        case 59:     // RE-SCHEDULE ORDER
                    billDate = new Date(this.getSystemDate());
                    cancelReason = "API"; 
                    corp = "46099";
                    cust_acct = "10286680"; // 99517 Test 2B
                    isMustDo = false;
                    jobType = ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue();
                    offerNum = new BigDecimal(2027294); // 99517 Test 2B
                    orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
                    orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
                    orderType = ServiceConstantsI.OrderType.ORDER_RESCHEDULE_DATES_ONLY.getOrderTypeValue();
                    overriddenRuleIds[0] = "";
                    overriddenRuleIds[1] = "";
                    queueHsdsHitFlag = false;
                    rateCode1  = "TA";
                    rateCodeVOaction = 0; // To be set in operation -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
                    salesRepId = "000001";
                    scheduleDate = new Date(this.getSystemDate());
                    scheduleType = ServiceConstantsI.NO_TRUCK;
                    scheduleVOaction = 1; //1=Change 2 should mean add - CR submitted for javadoc updateservicePointVOaction = 0; // no change = 0, change = 1, add = 2, remove = 3siteId   = "00217231"; // 99517 Test 2B 
                    skipServicePointData = false;
                    taskCode = "1";
                    techId = "999";  // No Truck Tech
                    this.setSpecialInstruct1Code(apiParams, printOutput, "5");
                    
                    printOutput.printToShell (apiParams, "   RESCHEDULE_ORDER Operation Initial Parameter Values",        null);
                    printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
                    printOutput.printToShell (apiParams, "Parameter:cancelReason         : " + cancelReason,         null);
                    printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
                    printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
                    printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
                    printOutput.printToShell (apiParams, "Parameter:Offernum             : " + offerNum,             null);
                    printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
                    printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
                    printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
                    printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
                    printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode3            : " + rateCode3,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode4            : " + rateCode4,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
                    printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
                    printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
                    printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);

                    break;
            
            case 60:     // RE-SCHEDULE ORDER WITH EQUIPMENT
                    billDate = new Date(this.getSystemDate());
                    cancelReason = "API"; 
                    corp = "46099";
                    cust_acct = "10286612"; // 99517 Test 2B
                    isMustDo = false;
                    jobType = ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue();
                    offerNum = new BigDecimal(2027235); // 99517 Test 2B
                    orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
                    orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
                    orderType = ServiceConstantsI.OrderType.ORDER_RESCHEDULE_DATES_ONLY.getOrderTypeValue();
                    overriddenRuleIds[0] = "";
                    overriddenRuleIds[1] = "";
                    queueHsdsHitFlag = false;
                    rateCode1  = "TA";
                    rateCodeVOaction = 0; // To be set in operation -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
                    salesRepId = "000001";
                    scheduleDate = new Date(this.getSystemDate());
                    scheduleType = ServiceConstantsI.NO_TRUCK;
                    scheduleVOaction = 1; //1=Change 2 should mean add - CR submitted for javadoc updateservicePointVOaction = 0; // no change = 0, change = 1, add = 2, remove = 3siteId   = "00217231"; // 99517 Test 2B 
                    skipServicePointData = false;
                    taskCode = "1";
                    techId = "999";  // No Truck Tech
                    this.setServicePoint(apiParams, printOutput, 1); 
                    this.setSpecialInstruct1Code(apiParams, printOutput, "5");
            
                    this.setEquipmentId(apiParams, printOutput,  "   42611371750");
                    this.setSerialNumber(apiParams, printOutput, "   42611371750");
                    this.setEquipmentLocation(apiParams, printOutput, "2    ");
                    this.setEquipMovementFlag(apiParams, printOutput, (Parameters.EQUIPMENT_VO_MOVEMENT_NO_MOVE)); // Valid values -1 = Validation action, 0 = No equipment movement, 1 = equipment movement occured.
                    this.setEquipmentVOaction(apiParams, printOutput, (short)2); //Valid Values:no change = 0, change = 1, add = 2, remove = 3
                    this.setMvtStatusCode(apiParams, printOutput, (short)1); // Job status keyed in dispatch.Valid Values: 1 = Complete, 2 = Not done, 3 = Alert number, 4 = Next, 5 = Reschedule, 6 = Cancel, 9 = Reassign
                    
                    
                    printOutput.printToShell (apiParams, "   RESCHEDULE_ORDER WITH EQUIPMENT Operation Initial Parameter Values",        null);
                    printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
                    printOutput.printToShell (apiParams, "Parameter:cancelReason         : " + cancelReason,         null);
                    printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
                    printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
                    printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
                    printOutput.printToShell (apiParams, "Parameter:Offernum             : " + offerNum,             null);
                    printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
                    printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
                    printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
                    printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
                    printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode3            : " + rateCode3,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCode4            : " + rateCode4,            null);
                    printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
                    printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
                    printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
                    printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
                    printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
                    printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
                    printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);
            

                    break;
        
            case 61: // EQUIPMENT_CHECK
                    printOutput.printToShell (apiParams, "   EQUIPMENT CHECKING..",  null);
                                
                    this.setEquipmentId(apiParams, printOutput,  "   41475316224");
                    this.setSerialNumber(apiParams, printOutput, "   41475316224");
                    
                    break;
            
            case 62: // UNASSIGN_EQP
                appName = "UNAssign Equipment";
                printOutput.printToShell (apiParams, "   UNASSIGN_EQIP Operation Parameter Values",  null);
                cust_acct = "";                    
                equipmentId = ""; // Equipment that is not on an Account
                equipmentVOaction = 3; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
                orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
                orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
                outlet = 1;
                overriddenRuleIds[0] = "";
                overriddenRuleIds[1] = "";
                serviceGroup = 1;
                servicePointEquipRemoval = true;
                servicePointVOaction = 1; // valid values are :no change = 0, change = 1, add = 2, remove = 3
                siteId   = "";
                this.setServicePoint(apiParams, printOutput, 2);
                this.setCallerName(apiParams, printOutput, "BE-API");
                
                
                printOutput.printToShell (apiParams, "Parameter:Cust_acct           : " + cust_acct,            null);
                printOutput.printToShell (apiParams, "Parameter:equipmentId         : " + equipmentId,          null);
                printOutput.printToShell (apiParams, "Parameter:equipmentVOaction   : " + equipmentVOaction,    null);
                printOutput.printToShell (apiParams, "Parameter:orderGroupSeq       : " + orderGroupSeq,        null);
                printOutput.printToShell (apiParams, "Parameter:orderType           : " + orderType,            null);
                printOutput.printToShell (apiParams, "Parameter:outlet              : " + outlet,               null);
                printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds   : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
                printOutput.printToShell (apiParams, "Parameter:serviceGroup        : " + serviceGroup,         null);
                printOutput.printToShell (apiParams, "Parameter:servicePointVOaction: " + servicePointVOaction, null);
                printOutput.printToShell (apiParams, "Parameter:siteId             : " + siteId,              null);
                break;
            
                
        } // end of Switch 
        
        printOutput.printToShell (apiParams, "", null);
    }
    
    // Internal method to get system date
    private String getSystemDate () {
            
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        
        return (dateFormat.format(calendar.getTime()));
    }
    
    // Internal method to print common parameter values
    private void printCommonParameters(Parameters apiParams, PrintOutput printOutput) {
            String amspHome = System.getenv("AMSP_HOME");
            printOutput.printToShell (apiParams, amspHome, null);
            /*String[] fileNames = {"", ""};
            fileNames = printOutput.getFileNames();*/

            printOutput.printToShell (apiParams, "   Runtime Configuration Values",                             null);
            printOutput.printToShell (apiParams, "getOPPort()           : " + Configuration.getOPPort(),        null);
            printOutput.printToShell (apiParams, "getOPIp()             : " + Configuration.getOPIp(),          null);
            printOutput.printToShell (apiParams, "getSysUser()          : " + Configuration.getSysUser(),       null);
            printOutput.printToShell (apiParams, "getDefaultLocale()    : " + Configuration.getDefaultLocale(), null);
            printOutput.printToShell (apiParams, "",                                                            null);
            printOutput.printToShell (apiParams, "   Runtime Common Parameter Values",                          null);
            printOutput.printToShell (apiParams, "AMSP_HOME             : " + amspHome,                         null);
            printOutput.printToShell (apiParams, "Parameter:Corp        : " + corp,                             null);
            /*printOutput.printToShell (apiParams, "Parameter:Text file   : " + fileNames[0],                     null);
            printOutput.printToShell (apiParams, "Parameter:XML file    : " + fileNames[1],                     null);*/
            printOutput.printToShell (apiParams, "Parameter:Locale      : " + locale,                           null);
            printOutput.printToShell (apiParams, "Parameter:Password    : " + password,                         null);
            printOutput.printToShell (apiParams, "Parameter:outputMode  : " + outputMode,                       null);
            printOutput.printToShell (apiParams, "Parameter:User        : " + user,                             null);
            printOutput.printToShell (apiParams, "",                                                            null);
    }
    
    // good for phone numbers
    public String generateRandomNumberString (int length) {
            
            String numberString = "";
            Random rn = new Random();
            
            for(int i =0; i < length; i++)
            {
                int answer = rn.nextInt(9) + 1;
                numberString = numberString + Integer.toString(answer);
            }
            
            return numberString;
    }
    
    // get methods
    public int        getAccountingArea()           {return accountingArea;}
    public int        getAccountCategory()          {return accountCategory;}
    public int        getAcctPriceStructId()        {return acctPriceStructId;}
    public int        getAddressUse()               {return addressUse;}
    public int        getAddressType()              {return addressType;}
    public String     getAdjustmentCode()           {return adjustmentCode;}
    public String     getAging()                    {return aging;}
    public short      getAllowInvalidZip()          {return allowInvalidZip;}
    public Money      getAdjustmentAmount()                 {return adjustmentAmount;}
    public Money      getAmount()                                   {return amount;}
    public Money      getAmountTendered()           {return amountTendered;}
    public String     getAmspVersion()              {return amspVersion;}
    public String     getAppName()                  {return appName;}
    public String     getAppVersion()               {return appVersion;}
    public Money      getBatchAmount()                              {return batchAmount;}
    public Money      getBatchCash()                        {return batchCash;}
    public Money      getBatchCheque()                              {return batchCheque;}
    public short      getBatchClose()                               {return batchClose;}
    public short      getBatchContinue()                    {return batchContinue;}
    public Money      getBatchCreditCard()                  {return batchCreditCard;}
    public String     getBatchCtrlgroup()                   {return batchCtrlgroup;}
    public short      getBatchDone()                                {return batchDone;}
    public Money      getBatchElectronicCheq()              {return batchElectronicCheq;}
    public short      getBatchNew()                                 {return batchNew;}
    public int        getBatchNumber()                              {return batchNumber;}
    public int        getBatchNumberTarget()        {return batchNumberTarget;}
    public Money      getBatchOther()                               {return batchOther;}
    public Money      getBatchPostal()                              {return batchPostal;}
    public String     getBatchStatus()                              {return batchStatus;}
    public String     getBatchType()                                {return batchType;}
    public Date       getBeginDateTime()            {return beginDateTime;}
    public Date       getBillDate()                 {return billDate;}
    public String     getBillForm()                 {return billForm;}
    public String     getCampaignCode()             {return campaignCode;}
    public short      getCancelNpd()                {return cancelNpd;}
    public String     getCancelReason()             {return cancelReason;}
    public String     getCallerName()               {return callerName;}
    public Date       getCdwDate()                  {return cdwDate;}
    public String     getCodCode()                  {return codCode;}
    public String     getCollStatAgencyCode()       {return collStatAgencyCode;}
    public String     getCollStatCancelReason()     {return collStatCancelReason;}
    public short      getCollStatClass()            {return collStatClass;}
    public short      getCollStatClose()            {return collStatClose;}
    public String     getCollStatComments()         {return collStatComments;}
    public Date       getCollStatDate()             {return collStatDate;}
    public String     getCollStatPath()             {return collStatPath;}
    public boolean    getCollStatPpvHold()          {return colStatPpvHold;}
    public String     getCollStatStep()             {return collStatStep;}
    public String     getComment()                  {return comment;}
    public int        getCommentTypeSelect()        {return commentTypeSelect;}
    public int        getContractStatusOption()     {return contractStatusOption;}
    public long       getContractTemplateId()       {return contractTemplateId;}
    public String     getCheckinAlert()             {return checkinAlert;}
    public String     getChangeReason()             {return changeReason;}
    public String     getCustClassCode()            {return custClassCode;}
    public Date       getCompleteDate()             {return completeDate;}
    public Date       getCompleteTime()             {return completeTime;}
    public String     getCorp()                     {return corp;}
    public String[]   getCorpSet()                  {return corpSet;}
    public String     getCorpSetTarget()            {return corpSetTarget;}
    public String     getCust_acct()                {return cust_acct;}
    public String     getCust_acct2()               {return cust_acct2;}
    public boolean    getCustomPointsAllowed()      {return customPointsAllowed;}
    public int        getCycle()                    {return cycle;}
    public Date       getDateOfBirth()              {return dateOfBirth;}
    public Money      getDMoney()                   {return dMoney;}
    public String     getDSeq()                     {return dSeq;}
    public String     getDisconnectReasonCode()     {return disconnectReasonCode;}
    public boolean    getDuplicateAddressFlag()     {return duplicateAddressFlag;}
    public Date       getEffectiveDate()            {return effectiveDate;}
    public int        getEffectiveDateFlag()        {return effectiveDateFlag;}
    public String     getEquipmentId()              {return equipmentId;}
    public String     getEquipmentLocation()        {return equipmentLocation;}
    public short      getEquipmentVOaction()        {return equipmentVOaction;}
    public String     getEnterpriseId()             {return enterpriseId;}
    public String     getFileName()                 {return file_name;}
    public String     getFilePath()                 {return file_path;}
    public String     getFirstName()                {return firstName;}
    public String     getFromTech()                 {return fromTech;}
    public Date       getHighDate()                 {return highDate;}
    public String     getHomePhone()                {return homePhone;}
    public String     gethouseInfo()                {return houseInfo;}
    public String     getInitial()                  {return initial;}
    public int        getInstallType()              {return installType;}
    public boolean    getIsAdjustment()             {return isAdjustment;}
    public boolean    getIsEcheck()                                 {return isEcheck;}
    public boolean    getIsFrontCounterMode()       {return isFrontCounterMode;}
    public boolean    getIsMustDo()                 {return isMustDo;}
    public boolean    getIsOffer()                  {return isOffer;}
    public int        getOptionId()                 {return optionId;}
    public boolean    getIsPayCard()                                {return isPayCard;}
    public boolean    getIsPayment()                                {return isPayment;}
    public boolean    getIsProspect()               {return isProspect;}
    public short    getBlankOutFlag()               {return blankOutFlag;}
    public int        getJobType()                  {return jobType;}
    public String     getLastName()                 {return lastName;}
    public String     getLocale()                   {return locale;}
    public int        getNewCycle()                 {return newCycle;}
    public BigDecimal getOffernum()                 {return offerNum;}
    public String     getOperatorId()               {return operatorId;}
    public String     getOperatorStatus()           {return operatorStatus;}
    public String     getOptionCode()               {return optionCode;}
    public String     getOrderComment()             {return orderComment;}
    public short      getOrderInfoVOaction()        {return orderInfoVOaction;}
    public BigDecimal getOrderGroupSeq()            {return orderGroupSeq;}
    public int        getOrderType()                {return orderType;}
    public String     getOtherPhone()               {return otherPhone;}
    public int        getOutlet()                   {return outlet;}
    public int        getOutletTarget()             {return outletTarget;}
    public int        getOutputMode()               {return outputMode;}
    public String[]   getOverriddenRuleIds()        {return overriddenRuleIds;}
    public String     getPackageCode()              {return packageCode;}
    public String     getPasswd()                   {return password;}
    public String     getPaymentKind()                              {return paymentKind;}
    public String     getPaymentReferenced()            {return paymentReference;}
    public ContractVO[] getpendingContractIds()     {return pendingContractIds;}
    public String     getPhoneClass()               {return phoneClass;}
    public String     getPhoneNumber()              {return phoneNumber;}
    public boolean    getPhoneNumberReplaceFlag()   {return phoneNumberReplaceFlag;}
    public int        getPhoneNumSearch()           {return phoneNumSearch;}
    public short      getPhoneVOaction()            {return phoneVOaction;} 
    public boolean    getPlant()                    {return plant;}
    public short      getPoints()                   {return points;}
    public String     getPrevSerialNumber()         {return prevSerialNumber;}
    public int        getPriceStructId()            {return priceStructId;}
    public String     getPrintFileCode()            {return printFileCode;}
    public String     getProductLanguage()          {return productLanguage;}
    public QualifiersVO[] getQualifiersVOList()     {return qualifiersVOList;}
    public boolean    getQueueHsdsHitFlag()         {return queueHsdsHitFlag;}
    public short      getQuotaGroupCode()           {return quotaGroupCode;}
    public short      getQuotaTimeSlotCode()        {return quotaTimeSlotCode;}
    public String     getRateCode1()                {return rateCode1;}
    public String     getRateCode2()                {return rateCode2;}
    public String     getRateCode3()                {return rateCode3;}
    public String     getRateCode4()                {return rateCode4;}
    public short      getRateCodeVOaction()         {return rateCodeVOaction;}
    public short      getPromoVOaction()            {return promoVOaction;}
    public String     getReasonCode()                               {return reasonCode;}
    public String     getRefrenceNumber()           {return refrenceNumber;}
    public String     getReminderScheme()           {return reminderScheme;}
    public String     getSalesRepId()               {return salesRepId;}
    public int        getScheduleAction()           {return scheduleAction;}
    public Date       getScheduleDate()             {return scheduleDate;}
    public int        getScheduleType()             {return scheduleType;}
    public short      getScheduleVOaction()         {return scheduleVOaction;}
    public String     getSerialNumber()             {return serialNumber;}
    public int        getServiceGroup()             {return serviceGroup;}
    public String     getServicePackage()           {return servicePackage;}
    public int        getServicePoint()             {return servicePoint;}
    public boolean    getServicePointEquipRemoval() {return servicePointEquipRemoval;}
    public String     getServicePointLocationCode() {return servicePointLocationCode;}
    public int        getServicePointTarget()       {return servicePointTarget;}
    public ServicePointVO[] getServicePointVOlist() {return servicePointVOlist;}
    public short      getServicePointVOaction()     {return servicePointVOaction;}
    public String     getsiteId()                   {return siteId;}
    public String     getSkillLevel()               {return skillLevel;}
    public Boolean    getSkipPayCard()              {return skipPayCard;}
    public Boolean    getSkipServicePointData()     {return skipServicePointData;}
    public String     getSpecialInstruct1Code()     {return specialInstruct1Code;}
    public String     getSroFixCode()               {return sroFixCode;}
    public String     getSroFixDesc()               {return sroFixDesc;}
    public Date       getStartStmtDate()            {return startStmtDate;}
    public Date       getStopStmtDate()             {return stopStmtDate;}
    public Date       getStatementDate()            {return statementDate;}
    public String     getStatementScheme()          {return statementScheme;}
    public int        getStatus()                   {return status;}
    public String     getSuiteListElement(int idx)  {return suiteList[idx];}
    public int        getSuiteListLength()          {return suiteList.length;}
    public String     getTag()                      {return tag;}
    public String     getTaskCode()                 {return taskCode;}
    public String     getTcFixCode()                {return tcFixCode;}
    public String     getTcFixDesc()                {return tcFixDesc;}
    public String     getTechId()                   {return techId;}
    public String     getToTech()                   {return toTech;}
    public String     getType()                     {return type;}
    public String     getTypeCode()                 {return typeCode;}
    public String     getUserid()                   {return user;}
    public boolean    getUpgradeHold()              {return upgradeHold;}
    public String     getUserName()                 {return userName;}
    public short      getValidateOnlyFlg()          {return validateOnlyFlg;}
    public short      getEquipMovementFlag()        {return equipMovementFlag;}
    public short      getCheckinOption()            {return checkinOption;}
    public String     getNotDoneCode()              {return notDoneCode;}
    public short      getSarSentFlag()              {return sarSentFlag;}
    public short      getMvtStatusCode()            {return mvtStatusCode;}
    
    // add a set method whenever a parameter value needs to change during an operation
    public void setAccountCategory (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating accountCategory from: " + accountCategory + " to: " + new_val, null);
            accountCategory = new_val;
    }
    public void setAccountingArea (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating accountingArea from: " + accountingArea + " to: " + new_val, null);
            accountingArea = new_val;
    }
    public void setAcctPriceStructId (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating acctPriceStructId from: " + acctPriceStructId + " to: " + new_val, null);
            acctPriceStructId = new_val;
    }
    public void setAddressType (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating addressType from: " + addressType + " to: " + new_val, null);
            addressType = new_val;
    }
    public void setAddressUse (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating addressUse from: " + addressUse + " to: " + new_val, null);
            addressUse = new_val;
    }
    public void setAdjustmentCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating adjustmentCode from: " + adjustmentCode + " to: " + new_val, null);
            adjustmentCode = new_val;
    }
    public void setAging (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating aging from: " + aging + " to: " + new_val, null);
            aging = new_val;
    }
    public void setAdjustmentAmount (Parameters apiParams, PrintOutput printOutput, Money new_val) {
            printOutput.printToShell (apiParams, "Updating adjustmentAmount from: " + adjustmentAmount + " to: " + new_val, null);
            adjustmentAmount = new_val;
    }
    public void setAllowInvalidZip (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating allowInvalidZip from: " + allowInvalidZip + " to: " + new_val, null);
            allowInvalidZip = new_val;
    }
    public void setAmount (Parameters apiParams, PrintOutput printOutput, Money new_val) {
            printOutput.printToShell (apiParams, "Updating amount from: " + amount + " to: " + new_val, null);
            amount = new_val;
    }
    public void setAmountTendered (Parameters apiParams, PrintOutput printOutput, Money new_val) {
            printOutput.printToShell (apiParams, "Updating amountTendered from: " + amountTendered + " to: " + new_val, null);
            amountTendered = new_val;
    }
    public void setBatchClose (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating batchClose from: " + batchClose + " to: " + new_val, null);
            batchClose = new_val;
    }
    public void setBatchContinue (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating batchContinue from: " + batchContinue + " to: " + new_val, null);
            batchContinue = new_val;
    }
    public void setBatchNew (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating batchNew from: " + batchNew + " to: " + new_val, null);
            batchNew = new_val;
    }
    public void setBatchNumber (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating batchNumber from: " + batchNumber + " to: " + new_val, null);
            batchNumber = new_val;
    }
    public void setBatchCtrlgroup (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating batchCtrlgroup from: " + batchCtrlgroup + " to: " + new_val, null);
            batchCtrlgroup = new_val;
    }
    public void setBatchType (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating batchType from: " + batchType + " to: " + new_val, null);
            batchType = new_val;
    }
    public void setBillDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating billDate from: " + billDate + " to: " + new_val, null);
            billDate = new_val;
    } 
    public void setBillForm (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating billForm from: " + billForm + " to: " + new_val, null);
            billForm = new_val;
    } 
    public void setCallerName (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating callerName from: " + callerName + " to: " + new_val, null);
            callerName = new_val;
    }
    public void setCampaignCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating campaignCode from: " + campaignCode + " to: " + new_val, null);
            campaignCode = new_val;
    }
    public void setCancelNpd (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating cancelNpd from: " + cancelNpd + " to: " + new_val, null);
            cancelNpd = new_val;
    }
    public void setCancelReason (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating cancelReason from: " + cancelReason + " to: " + new_val, null);
            cancelReason = new_val;
    }
    public void setCdwDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating cdwDate from: " + cdwDate + " to: " + new_val, null);
            cdwDate = new_val;
    }
    public void setCustClassCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating custClassCode from: " + custClassCode + " to: " + new_val, null);
            custClassCode = new_val;
    }
    public void setCollStatAgencyCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating collStatAgencyCode from: " + collStatAgencyCode + " to: " + new_val, null);
            collStatAgencyCode = new_val;
    }
    public void setCollStatCancelReason (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating collStatCancelReason from: " + collStatCancelReason + " to: " + new_val, null);
            collStatCancelReason = new_val;
    }
    public void setCollStatClass (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating collStatClass from: " + collStatClass + " to: " + new_val, null);
            collStatClass = new_val;
    }
    public void setCollStatClose (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating collStatClose from: " + collStatClose + " to: " + new_val, null);
            collStatClose = new_val;
    }
    public void setCollStatDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating collStatDate from: " + collStatDate + " to: " + new_val, null);
            collStatDate = new_val;
    }
    public void setCollStatComments (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating collStatComments from: " + collStatComments + " to: " + new_val, null);
            collStatComments = new_val;
    }
    public void setCollStatPath (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating collStatPath from: " + collStatPath + " to: " + new_val, null);
            collStatPath = new_val;
    }
    public void setCollStatStep (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating collStatStep from: " + collStatStep + " to: " + new_val, null);
            collStatStep = new_val;
    }       
    public void setCollStatPpvHold (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating colStatPpvHold from: " + colStatPpvHold + " to: " + new_val, null);
            colStatPpvHold = new_val;
    }
    public void setComment (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating comment from: " + comment + " to: " + new_val, null);
            comment = new_val;
    }
    public void setCommentTypeSelect (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating commentTypeSelect from: " + commentTypeSelect + " to: " + new_val, null);
            commentTypeSelect = new_val;
    }
    public void setContractStatusOption (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating contractStatusOption from: " + contractStatusOption + " to: " + new_val, null);
            contractStatusOption = new_val;
    }
    public void setContractTemplateId (Parameters apiParams, PrintOutput printOutput, long new_val) {
            printOutput.printToShell (apiParams, "Updating contractTemplateId from: " + contractTemplateId + " to: " + new_val, null);
            contractTemplateId = new_val;
    }
    public void setCorp (String new_val) {corp = new_val;} // For tool use
    
    public void setCorp (Parameters apiParams, PrintOutput printOutput, String new_val)  {
            printOutput.printToShell (apiParams, "Updating corp from: " + corp + " to: " + new_val, null);
            corp = new_val;
    }
    public void setCorpSet (String new_val) {corpSet[0] = new_val;} // For tool use
    
    public void setCorpSetList (Parameters apiParams, PrintOutput printOutput, int elem, String new_val)  {
            printOutput.printToShell (apiParams, "Updating corpSet[" + elem + "] from: " + corpSet[elem] + " to: " + new_val, null);
            corpSet[elem] = new_val;
    }
    public void setCust_acct (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating cust_acct from: " + cust_acct + " to: " + new_val, null);
            cust_acct = new_val;
    }
    public void setCycle (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating cycle from: " + cycle + " to: " + new_val, null);
            cycle = new_val;
    }
    public void setDateOfBirth (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating dateOfBirth from: " + dateOfBirth + " to: " + new_val, null);
            dateOfBirth = new_val;
    }
    public void setDisconnectReasonCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating disconnectReason from: " + disconnectReasonCode + " to: " + new_val, null);
            disconnectReasonCode = new_val;
    }
    public void setDuplicateAddressFlag (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating duplicateAddressFlag from: " + duplicateAddressFlag + " to: " + new_val, null);
            duplicateAddressFlag = new_val;
    }
    public void setEffectiveDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating effectiveDate from: " + effectiveDate + " to: " + new_val, null);
            effectiveDate = new_val;
    }
    public void setEffectiveDateFlag (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating effectiveDateFlag from: " + effectiveDateFlag + " to: " + new_val, null);
            effectiveDateFlag = new_val;
    }
    public void setEquipmentId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating equipmentId from: " + equipmentId + " to: " + new_val, null);
            equipmentId = new_val;
    } 
    public void setEquipmentLocation (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating equipmentLocation from: " + equipmentLocation + " to: " + new_val, null);
            equipmentLocation = new_val;
    } 
    public void setEquipmentVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating equipmentVOaction from: " + equipmentVOaction + " to: " + new_val, null);
            equipmentVOaction = new_val;
    }
    public void setFirstName (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating firstName from: " + firstName + " to: " + new_val, null);
            firstName = new_val;
    }
    public void setInstallType (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating installType from: " + installType + " to: " + new_val, null);
            installType = new_val;
    }
    public void setJobType (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating jobType from: " + jobType + " to: " + new_val, null);
            jobType = new_val;
    }
    public void setHomePhone (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating homePhone from: " + homePhone + " to: " + new_val, null);
            homePhone = new_val;
    }
    public void setHouseInfo (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating houseInfo from: " + houseInfo + " to: " + new_val, null);
            houseInfo = new_val;
    }
    public void setInitial (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating initial from: " + initial + " to: " + new_val, null);
            initial = new_val;
    }
    public void setIsAdjustment (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isAdjustment from: " + isAdjustment + " to: " + new_val, null);
            isAdjustment = new_val;
    }
    public void setIsFrontCounterMode (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isFrontCounterMode from: " + isFrontCounterMode + " to: " + new_val, null);
            isFrontCounterMode = new_val;
    }
    public void setIsMustDo (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isMustDo from: " + isMustDo + " to: " + new_val, null);
            isMustDo = new_val;
    }
    public void setIsOffer (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isOffer from: " + isOffer + " to: " + new_val, null);
            isOffer = new_val;
    }
    public void setIsProspect (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isProspect from: " + isProspect + " to: " + new_val, null);
            isProspect = new_val;
    }
    public void setBlankOutFlag(Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating isProspect from: " + isProspect + " to: " + new_val, null);
            blankOutFlag = new_val;
    }
    public void setNewCycle (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating newCycle from: " + newCycle + " to: " + new_val, null);
            newCycle = new_val;
    }
    public void setOverriddenRuleIds (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating overriddenRuleIds[0] from: " + overriddenRuleIds[0] + " to: " + new_val, null);
            printOutput.printToShell (apiParams, "Updating overriddenRuleIds[1] from: " + overriddenRuleIds[1] + " to: " + new_val, null);
            overriddenRuleIds[0] = new_val;
            overriddenRuleIds[1] = new_val;
    }
    public void setIsPayment (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating isPayment from: " + isPayment + " to: " + new_val, null);
            isPayment = new_val;
    } 
    public void setPrevSerialNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating prevSerialNumber from: " + prevSerialNumber + " to: " + new_val, null);
            prevSerialNumber = new_val;
    }
    public void setLastName (String new_val) {lastName = new_val;} // For tool use
    public void setLastName (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating lastName from: " + lastName + " to: " + new_val, null);
            lastName = new_val;
    }
    public void setOfferNum (Parameters apiParams, PrintOutput printOutput, BigDecimal new_val) {
            printOutput.printToShell (apiParams, "Updating offerNum from: " + offerNum + " to: " + new_val, null);
            offerNum = new_val;
    }
    public void setOperatorId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating operatorId from: " + operatorId + " to: " + new_val, null);
            operatorId = new_val;
    }
    public void setOptionCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating optionCode from: " + optionCode + " to: " + new_val, null);
            optionCode = new_val;
    }
    public void setOrderGroupSeq (Parameters apiParams, PrintOutput printOutput, BigDecimal new_val) {
            printOutput.printToShell (apiParams, "Updating orderGroupSeq from: " + orderGroupSeq + " to: " + new_val, null);
            orderGroupSeq = new_val;
    }
    public void setOrderInfoVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating orderInfoVOaction from: " + orderInfoVOaction + " to: " + new_val, null);
            orderInfoVOaction = new_val;
    }
    public void setOrderType (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating orderType from: " + orderType + " to: " + new_val, null);
            orderType = new_val;
    } 
    public void setOutlet (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating outlet from: " + outlet + " to: " + new_val, null);
            outlet = new_val;
    }
    public void setOutputMode (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating outputMode from: " + outputMode + " to: " + new_val, null);
            outputMode = new_val;
    }
    public void setPackageCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating packageCode from: " + packageCode + " to: " + new_val, null);
            packageCode = new_val;
    }
    public void setPassword (String new_val) {password = new_val;} // For tool use
    
    public void setPassword (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating password from: " + password + " to: " + new_val, null);
            password = new_val;
    }
    public void setPaymentKind (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating paymentKind from: " + paymentKind + " to: " + new_val, null);
            paymentKind = new_val;
    }
    public void setPaymentReference (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating paymentReference from: " + paymentReference + " to: " + new_val, null);
            paymentReference = new_val;
    }
    public void setPendingContractIds (Parameters apiParams, PrintOutput printOutput, ContractVO[] new_val) {
            printOutput.printToShell (apiParams, "Updating pendingContractIds from: " + pendingContractIds + " to: " + new_val, null);
            pendingContractIds = new_val; // This only works for null right now
    }
    public void setPhoneClass (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating phoneClass from: " + phoneClass + " to: " + new_val, null);
            phoneClass = new_val;
    }
    public void setPhoneNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating phoneNumber from: " + phoneNumber + " to: " + new_val, null);
            phoneNumber = new_val;
    }
    public void setPhoneNumSearch (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating phoneNumSearch from: " + phoneNumSearch + " to: " + new_val, null);
            phoneNumSearch = new_val;
    }
    public void setPlant (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating plant from: " + plant + " to: " + new_val, null);
            plant = new_val;
    }
    public void setPoints (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating points from: " + points + " to: " + new_val, null);
            points = new_val;
    }
    public void setPriceStructId (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating priceStructId from: " + priceStructId + " to: " + new_val, null);
            priceStructId = new_val;
    }
    public void setProductLanguage (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating productLanguage from: " + productLanguage + " to: " + new_val, null);
            productLanguage = new_val;
    }
    public void setQualifiersVOList (Parameters apiParams, PrintOutput printOutput, QualifiersVO[] new_val) {
            printOutput.printToShell (apiParams, "Updating qualifiersVOList from: " + qualifiersVOList + " to: " + new_val, null);
            qualifiersVOList = new_val;
    }
    public void setQueueHsdsHitFlag (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating queueHsdsHitFlag from: " + queueHsdsHitFlag + " to: " + new_val, null);
            queueHsdsHitFlag = new_val;
    }
    public void setQuotaGroupCode (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating quotaGroup from: " + quotaGroupCode + " to: " + new_val, null);
            quotaGroupCode = new_val;
    }
    public void setQuotaTimeSlotCode (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating quotaTimeSlot from: " + quotaTimeSlotCode + " to: " + new_val, null);
            quotaTimeSlotCode = new_val;
    }
    public void setRateCode1 (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating rateCode1 from: " + rateCode1 + " to: " + new_val, null);
            rateCode1 = new_val;
    }
    public void setRateCode2 (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating rateCode2 from: " + rateCode2 + " to: " + new_val, null);
            rateCode2 = new_val;
    }
    public void setRateCodeVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating rateCodeVOaction from: " + rateCodeVOaction + " to: " + new_val, null);
            rateCodeVOaction = new_val;
    }
    public void setPromoVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating promoVOAction from: " + promoVOaction + " to: " + new_val, null);
            promoVOaction = new_val;
    }
    public void setReminderScheme (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating reminderScheme from: " + reminderScheme + " to: " + new_val, null);
            reminderScheme = new_val;
    }
    public void setSalesRepId (String new_val) {salesRepId = new_val;} // For tool use
    
    public void setSalesRepId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating salesRepId from: " + salesRepId + " to: " + new_val, null);
            salesRepId = new_val;
    }
    public void setSerialNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating serialNumber from: " + serialNumber + " to: " + new_val, null);
            serialNumber = new_val;
    }
    public void setScheduleDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating scheduleDate from: " + scheduleDate + " to: " + new_val, null);
            scheduleDate = new_val;
    }
    public void setScheduleType (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating scheduleType from: " + scheduleType + " to: " + new_val, null);
            scheduleType = new_val;
    }
    public void setScheduleVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating scheduleVOaction from: " + scheduleVOaction + " to: " + new_val, null);
            scheduleVOaction = new_val;
    }
    public void setSiteId (String new_val) {siteId = new_val;}
    
    public void setSiteId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating siteId from: " + siteId + " to: " + new_val, null);
            siteId = new_val;
    } 
    public void setServicePoint (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating servicePoint from: " + servicePoint + " to: " + new_val, null);
            servicePoint = new_val;
    }
    public void setServiceGroup (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating serviceGroup from: " + serviceGroup + " to: " + new_val, null);
            serviceGroup = new_val;
    }
    public void setServicePackage (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating servicePackage from: " + servicePackage + " to: " + new_val, null);
            servicePackage = new_val;
    }
    public void setServicePointEquipRemoval (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating servicePointEquipRemoval from: " + servicePointEquipRemoval + " to: " + new_val, null);
            servicePointEquipRemoval = new_val;
    }
    public void setServicePointLocationCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating servicePointLocationCode from: " + servicePointLocationCode + " to: " + new_val, null);
            servicePointLocationCode = new_val;
    }
    public void setServicePointVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating servicePointVOaction from: " + servicePointVOaction + " to: " + new_val, null);
            servicePointVOaction = new_val;
    }
    public void setSpecialInstruct1Code (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating specialInstruct1Code from: " + specialInstruct1Code + " to: " + new_val, null);
            specialInstruct1Code = new_val;
    }
    public void setSroFixCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating sroFixCode from: " + sroFixCode + " to: " + new_val, null);
            sroFixCode = new_val;
    }
    public void setSroFixDesc (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating sroFixDesc from: " + sroFixDesc + " to: " + new_val, null);
            sroFixDesc = new_val;
    }
    public void setStartStmtDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating startStmtDate from: " + startStmtDate + " to: " + new_val, null);
            startStmtDate = new_val;
    }
    public void setStopStmtDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating stopStmtDate from: " + stopStmtDate + " to: " + new_val, null);
            stopStmtDate = new_val;
    }
    public void setStatementDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
            printOutput.printToShell (apiParams, "Updating statementDate from: " + statementDate + " to: " + new_val, null);
            statementDate = new_val;
    }
    public void setStatementScheme (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating statementScheme from: " + statementScheme + " to: " + new_val, null);
            statementScheme = new_val;
    }
    public void setStatus (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating status from: " + status + " to: " + new_val, null);
            status = new_val;
    }
    public void setTaskCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating taskCode from: " + taskCode + " to: " + new_val, null);
            taskCode = new_val;
            }
    public void setTcFixCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating tcFixCode from: " + tcFixCode + " to: " + new_val, null);
            tcFixCode = new_val;
    }
    public void setTcFixDesc (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating tcFixDesc from: " + tcFixDesc + " to: " + new_val, null);
            tcFixDesc = new_val;
    }
    public void setTechId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating techId from: " + techId + " to: " + new_val, null);
            techId = new_val;
    }
    public void setType (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating type from: " + type + " to: " + new_val, null);
            type = new_val;
    }
    public void setTypeCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating typeCode from: " + typeCode + " to: " + new_val, null);
            typeCode = new_val;
    }
    public void setUpgradeHold (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
            printOutput.printToShell (apiParams, "Updating upgradeHold from: " + upgradeHold + " to: " + new_val, null);
            upgradeHold = new_val;
    }
    public void setUser (String new_val) {user = new_val;} // For tool use
    
    public void setUser (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating user from: " + user + " to: " + new_val, null);
            user = new_val;
    }
    public void setValidateOnlyFlg (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating validateOnlyFlg from: " + validateOnlyFlg + " to: " + new_val, null);
            validateOnlyFlg = new_val;
    }    
    public void setCheckinOption (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating checkinOption from: " + checkinOption + " to: " + new_val, null);
            checkinOption = new_val;
    }    
    public void setDseq (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating dSeq from: " + dSeq + " to: " + new_val, null);
            dSeq = new_val;
    }
    public void setMvtStatusCode (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating mvtStatusCode from: " + mvtStatusCode + " to: " + new_val, null);
            mvtStatusCode = new_val;
    }
    public void setNotDoneCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating notDoneCode from: " + notDoneCode + " to: " + new_val, null);
            notDoneCode = new_val;
    }
    public void setOptionId (Parameters apiParams, PrintOutput printOutput, int new_val) {
            printOutput.printToShell (apiParams, "Updating optionId from: " + optionId + " to: " + new_val, null);
            optionId = new_val;
    }
    public void setSarSentFlag (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating sarSentFlag from: " + sarSentFlag + " to: " + new_val, null);
            sarSentFlag = new_val;
    }
    public void setSkipPayCard (Parameters apiParams, PrintOutput printOutput, boolean new_val) { 
            printOutput.printToShell (apiParams, "Updating skipPayCard from: " + skipPayCard + " to: " + new_val, null);
            skipPayCard = new_val;
    }
    public void setEquipMovementFlag (Parameters apiParams, PrintOutput printOutput, short new_val) {
            printOutput.printToShell (apiParams, "Updating equipMovementFlag from: " + equipMovementFlag + " to: " + new_val, null);
            equipMovementFlag = new_val;
    }
    public void setPersonnalId (Parameters apiParams, PrintOutput printOutput, String new_val) {
            printOutput.printToShell (apiParams, "Updating personnalId from: " + personnalId + " to: " + new_val, null);
            personnalId = new_val;
    }
    public void setEmailAddress (Parameters apiParams, PrintOutput printOutput, String new_val) {
        printOutput.printToShell (apiParams, "Updating emailAddress from: " + emailAddress + " to: " + new_val, null);
        emailAddress = new_val;
    }
    public void setMobilePhone (Parameters apiParams, PrintOutput printOutput, String new_val) {
        printOutput.printToShell (apiParams, "Updating mobilePhone from: " + mobilePhone + " to: " + new_val, null);
        mobilePhone = new_val;
    }
    
    public void finishOutput(Parameters apiParams, PrintOutput printOutput) {
            long elapsedTime = System.nanoTime() - startTime;
            double seconds = (double)elapsedTime / 1000000000.0;
            Calendar calendar = Calendar.getInstance();
            printOutput.printToShell (apiParams, "", null);
            printOutput.printToShell (apiParams, "Start  : " + startTimestamp, null);
            printOutput.printToShell (apiParams, "Stop   : " + simpleDateFormat.format(calendar.getTime()), null);
            printOutput.printToShell (apiParams, "Elapsed: " + seconds + " seconds" , null);
    }
}
