package org.fuse.usecase;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.cxf.jaxrs.impl.ResponseImpl;
import org.apache.cxf.message.MessageContentsList;
import org.globex.Account;
import org.globex.CorporateAccount;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ProcessorBean {

    public void convertEntityToString(Exchange exchange) throws IOException {
        int c;
        StringBuffer buf = new StringBuffer();
        Message msg = exchange.getIn();
        ResponseImpl resp = (ResponseImpl)msg.getBody();
        InputStream stream = (InputStream) resp.getEntity();
        while ((c = stream.read()) != -1) {
            buf.append((char) c);
        }
        stream.close();
        String response = buf.toString();
        exchange.getIn().setBody(response);
    }

    public Map<String, Object> defineNamedParameters(@Body Account ac) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("CLIENT_ID",ac.getClientId());
        map.put("SALES_CONTACT",ac.getSalesRepresentative());
        map.put("COMPANY_NAME",ac.getCompany().getName());
        map.put("COMPANY_GEO",ac.getCompany().getGeo());
        map.put("COMPANY_ACTIVE",ac.getCompany().isActive());
        map.put("CONTACT_FIRST_NAME",ac.getContact().getFirstName());
        map.put("CONTACT_LAST_NAME",ac.getContact().getLastName());
        map.put("CONTACT_ADDRESS",ac.getContact().getStreetAddr());
        map.put("CONTACT_CITY",ac.getContact().getCity());
        map.put("CONTACT_STATE",ac.getContact().getState());
        map.put("CONTACT_ZIP",ac.getContact().getZip());
        map.put("CONTACT_PHONE",ac.getContact().getPhone());
        map.put("CREATION_DATE",getCurrentTime());
        map.put("CREATION_USER","fuse_usecase");
        return map;
    }

    private static Timestamp getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        return currentTimestamp;
    }
}
