package com.company.app.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mdm.index.webservice.ApplicationConfigEntry;
import com.sun.mdm.index.webservice.CallerInfo;
import com.sun.mdm.index.webservice.CodeDescription;
import com.sun.mdm.index.webservice.CodeLookupException_Exception;
import com.sun.mdm.index.webservice.CustomLogicParameter;
import com.sun.mdm.index.webservice.CustomLogicResponse;
import com.sun.mdm.index.webservice.EnterprisePerson;
import com.sun.mdm.index.webservice.EoSearchOptions;
import com.sun.mdm.index.webservice.MatchColResult;
import com.sun.mdm.index.webservice.MatchWeight;
import com.sun.mdm.index.webservice.MergePersonResult;
import com.sun.mdm.index.webservice.ObjectDefinition;
import com.sun.mdm.index.webservice.OverlayDetectorResult;
import com.sun.mdm.index.webservice.PageException_Exception;
import com.sun.mdm.index.webservice.PersonBean;
import com.sun.mdm.index.webservice.PersonEJB;
import com.sun.mdm.index.webservice.PersonObject;
import com.sun.mdm.index.webservice.PotentialDuplicateResult;
import com.sun.mdm.index.webservice.PotentialDuplicateSearchObjectBean;
import com.sun.mdm.index.webservice.ProcessingException_Exception;
import com.sun.mdm.index.webservice.SbrOverWriteBean;
import com.sun.mdm.index.webservice.SbrPerson;
import com.sun.mdm.index.webservice.SbrPersonHistory;
import com.sun.mdm.index.webservice.ScoreElement;
import com.sun.mdm.index.webservice.SystemDefinition;
import com.sun.mdm.index.webservice.SystemObjectUIDBean;
import com.sun.mdm.index.webservice.SystemPerson;
import com.sun.mdm.index.webservice.SystemPersonHistory;
import com.sun.mdm.index.webservice.SystemPersonPK;
import com.sun.mdm.index.webservice.SystemPersonPKArray;
import com.sun.mdm.index.webservice.SystemUIDDefinition;
import com.sun.mdm.index.webservice.UserException_Exception;

public class PersonEJBImpl implements PersonEJB {
    private static final Logger LOG = LoggerFactory.getLogger(PersonEJBImpl.class);

    private CamelContext context;

    // For the DEMO this is the only method that is used,
    // it prints some ingo and then compares the Firstname to see if there is a match.
    // In reality it would look in a database to see if there is a match,
    // but since we're just mocking the functionality it's enough to compare to a known value
    @Override
    public MatchColResult executeMatchUpdate(CallerInfo callerInfo, SystemPerson sysObjBean) throws ProcessingException_Exception, UserException_Exception {
        LOG.info("Received payload in Nextgate Test Server");
        LOG.info("Caller Info: Application = " + callerInfo.getApplication() + " User = " + callerInfo.getAuthUser());
        LOG.info("SystemPerson: FirstName = " + sysObjBean.getPerson().getFirstName() + " Gender = " + sysObjBean.getPerson().getGender());

        Integer resultCode = -1;
        if ( sysObjBean.getPerson().getFirstName().equals("First") ) {
          resultCode = 1; //success
        } else {
          resultCode = 0; //not First
        }

        MatchColResult matchColResult = new MatchColResult();
        matchColResult.setEUID(callerInfo.getAuthUser());
        matchColResult.setMatchFieldChanged(false);
        matchColResult.setPotentialDuplicates(null);
        matchColResult.setResultCode(resultCode);

        return matchColResult;
    }

    @Override
    public List<ScoreElement> search(CallerInfo callerInfo, PersonBean objBean, EoSearchOptions searchOptions) throws ProcessingException_Exception,
                    UserException_Exception {
        LOG.info("Searching for score elements, this method will only return canned data");
        List<ScoreElement> elements = generateScoreElementData();

        return elements;
    }

    @Override
    public EnterprisePerson getEnterpriseRecordByEUID(CallerInfo callerInfo, String euid, boolean allowMergedEuid) throws ProcessingException_Exception,
                    UserException_Exception {
        List<EnterprisePerson> enterprisePersons = generateEnterprisePersonData();
        EnterprisePerson person = enterprisePersons.get(0);
        return person;

    }

    /*
     * --------------------------------------------- Unimplemented methods below
     * ---------------------------------------------
     */
    @Override
    public OverlayDetectorResult checkForOverlay(PersonBean beforeObj, PersonBean afterObj) throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult unmergeSystemRecord(CallerInfo callerInfo, String systemCode, String sourceLID, String destLID, boolean calculateOnly)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ApplicationConfigEntry> lookupApplicationConfig() throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PotentialDuplicateResult> lookupPotentialDuplicates(CallerInfo callerInfo, PotentialDuplicateSearchObjectBean potentialDuplicateSearchObjectBean)
                    throws ProcessingException_Exception, UserException_Exception, PageException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void assignRefObjectNodes(CallerInfo callerInfo, String systemCode, String localid, String objectType, List<String> referIds)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SystemObjectUIDBean> lookupSystemRecordUIDs(CallerInfo callerInfo, String systemCode, String lid) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deactivateEnterpriseRecord(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public String getEnterpriseRecordStatus(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void activateSystemRecord(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void resolvePotentialDuplicate(CallerInfo callerInfo, String potentialDuplicateId, boolean permanentResolve) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<String> getEUIDs(CallerInfo callerInfo, String systemCode, String localid, int maxRecs) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCodeDescription(String type, String code) throws CodeLookupException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateEnterpriseRecord(CallerInfo callerInfo, EnterprisePerson eoBean) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SystemDefinition> lookupSystemDefinitions() throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void undoSystemObjectUpdate(CallerInfo callerInfo, String systemCode, String lid, String transNum) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void addOrUpdateSystemRecord(CallerInfo callerInfo, String euid, SystemPerson sysObjBean, boolean checkDups) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<CodeDescription> getCodesByType(String type) throws CodeLookupException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SbrPerson getSBR(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SystemPerson> getSystemRecordsByEUIDStatus(CallerInfo callerInfo, String euid, String status) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SystemPersonPKArray> getMultipleLIDs(CallerInfo callerInfo, List<String> euids, boolean returnEuidsAsLids)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MergePersonResult> mergeMultipleEnterpriseRecords(CallerInfo callerInfo, List<String> sourceEUIDs, EnterprisePerson destinationEO,
                    List<String> srcRevisionNumbers, String destRevisionNumber, boolean calculateOnly, boolean setSourceSystemStatusToMerged)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemDefinition lookupSystemDefinition(String systemCode) throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult mergeEnterpriseRecordWithImage(CallerInfo callerInfo, String fromEUID, EnterprisePerson destinationEO, boolean calculateOnly,
                    boolean setSourceSystemStatusToMerged) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchWeight compareRecords(PersonBean record1, PersonBean record2) throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult unmergeEnterpriseRecord(CallerInfo callerInfo, String euid, boolean calculateOnly) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult mergeEnterpriseRecord(CallerInfo callerInfo, String fromEUID, String toEUID, boolean calculateOnly,
                    boolean setSourceSystemStatusToMerged) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EnterprisePerson> getSBRs(CallerInfo callerInfo, List<String> euids, boolean allowMergedEuid) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SbrPersonHistory getSBRHistory(CallerInfo callerInfo, String euid, String transnum) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomLogicResponse executeCustomLogic(CallerInfo callerInfo, String script, List<CustomLogicParameter> parameters)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchColResult executeMatch(CallerInfo callerInfo, SystemPerson sysObjBean) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addSystemRecord(CallerInfo callerInfo, String euid, SystemPerson sysObjBean) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SystemPerson> getSystemRecordsByEUID(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String splitSystemRecord(CallerInfo callerInfo, String systemCode, String localid, String euid) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getActiveEUID(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult mergeSystemRecord(CallerInfo callerInfo, String systemCode, String sourceLID, String destLID, boolean calculateOnly)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void activateEnterpriseRecord(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void transferSystemRecordUID(CallerInfo callerInfo, String destSystemCode, String destLID, String uidType, String uid)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SystemPersonPK> getLIDs(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] lookupResource(CallerInfo callerInfo, String resourceName) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchWeight getComparison(CallerInfo callerInfo, long comparisonId) throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemPersonPK lookupLIDBySUID(CallerInfo callerInfo, String uidType, String uid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLastSysInfoLogEntry(CallerInfo callerInfo) throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemPersonHistory getSystemRecordHistory(CallerInfo callerInfo, String systemCode, String localid, String transnum)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ObjectDefinition lookupObjectDefinition() throws ProcessingException_Exception, UserException_Exception, PageException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemPerson getSystemRecord(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult mergeEnterpriseRecordWithOverwrites(CallerInfo callerInfo, String fromEUID, String toEUID, boolean calculateOnly,
                    boolean setSourceSystemStatusToMerged, List<SbrOverWriteBean> overwrite) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchColResult recalculateMatch(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSystemRecordStatus(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SystemPersonPK> lookupLIDs(CallerInfo callerInfo, String sourceSystemCode, String sourceLID, String destSystemCode, String status)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String undoAssumedMatch(CallerInfo callerInfo, String assumedMatchId) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateSystemRecord(CallerInfo callerInfo, SystemPerson sysObjBean) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void assignRefObjectNode(CallerInfo callerInfo, String systemCode, String localid, String objectType, SystemPerson sysObjBean)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void transferSystemRecord(CallerInfo callerInfo, String toEUID, String systemCode, String localid) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public String getEUID(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deactivateSystemRecord(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SystemPersonPK> getLIDsByStatus(CallerInfo callerInfo, String euid, String status) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getMergedEUIDs(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unresolvePotentialDuplicate(CallerInfo callerInfo, String potentialDuplicateId) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public EnterprisePerson getEnterpriseRecordByLID(CallerInfo callerInfo, String systemCode, String localid) throws ProcessingException_Exception,
                    UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SystemUIDDefinition> lookupSystemUIDDefinitions() throws ProcessingException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EnterprisePerson> getEnterpriseRecords(CallerInfo callerInfo, List<String> euids, boolean allowMergedEuid)
                    throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MergePersonResult mergeSystemRecordWithImage(CallerInfo callerInfo, String systemCode, String sourceLID, String destLID, PersonObject destImage,
                    boolean calculateOnly) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getRevisionNumber(CallerInfo callerInfo, String euid) throws ProcessingException_Exception, UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    private List<ScoreElement> generateScoreElementData() {
        ArrayList<ScoreElement> e = new ArrayList<ScoreElement>();

        for (int i = 0; i < 25; i++) {
            ScoreElement element = new ScoreElement();
            element.setEUID("" + i);
            element.setComparisonId((long) i);
            element.setDecisionResult("decision result" + i);
            element.setFalsePositiveExplanation("false positive" + i);
            element.setPotentialFalsePositive(false);
            element.setWeight((double) i);
            element.setWeightExplanation("weight explanation" + i);
            e.add(element);
        }
        return e;
    }

    private List<EnterprisePerson> generateEnterprisePersonData() {
        List<EnterprisePerson> enterprisePersons = new ArrayList<EnterprisePerson>();

        for (int i = 0; i < 25; i++) {
            EnterprisePerson ep = new EnterprisePerson();
            ep.setEUID(i + "");
            ep.setSBRPerson(buildSbrPerson(i));
            ep.setStatus("status");
            enterprisePersons.add(ep);
        }

        return enterprisePersons;
    }

    private SbrPerson buildSbrPerson(int i) {
        SbrPerson sbr = new SbrPerson();
        sbr.setPerson(addPersonBean());
        return sbr;
    }

    private PersonBean addPersonBean() {
        PersonBean personBean = new PersonBean();
        personBean.setFirstName("firstname");
        personBean.setMiddleName("middlename");
        personBean.setLastName("lastname");
        personBean.setDOB("dob");
        personBean.setSuffix("suffix");
        personBean.setGender("gender");
        personBean.setMStatus("mstatus");
        personBean.setSSN("ssn");
        personBean.setEthnic("ethnicity");
        personBean.setLanguage("language");
        personBean.setSpouseName("spousename");
        personBean.setDod("dod");
        personBean.setCitizenship("citizenship");
        personBean.setPensionExpDate("pensionexpdate");

        return personBean;
    }

    public CamelContext getContext() {
        return context;
    }

    public void setContext(CamelContext context) {
        this.context = context;
    }
}
