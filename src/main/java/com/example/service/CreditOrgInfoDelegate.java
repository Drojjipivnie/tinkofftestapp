package com.example.service;

import com.example.dao.OrgInfoDAO;
import com.example.utils.Parser;
import org.w3c.dom.Element;
import ru.cbr.web.ArrayOfDouble;
import ru.cbr.web.CreditInfoByIntCodeExXMLResponse;
import ru.cbr.web.CreditOrgInfo;
import ru.cbr.web.CreditOrgInfoSoap;

public class CreditOrgInfoDelegate {

    private final CreditOrgInfoSoap service;
    private OrgInfoDAO orgInfoDAO;

    public CreditOrgInfoDelegate(OrgInfoDAO dao) {
        this.orgInfoDAO = dao;
        this.service = new CreditOrgInfo().getCreditOrgInfoSoap();
    }

    public double getIntCode(String bicCode) {
        Double intCode = orgInfoDAO.getIntCode(bicCode);
        if (intCode == null) {
            intCode = service.bicToIntCode(bicCode);
            orgInfoDAO.updateIntCode(bicCode, intCode);
        }

        return intCode;
    }

    public String getCreditOrgInfo(double intCode) {
        String orgInfo = orgInfoDAO.getCreditOrgInfo(intCode);
        if (orgInfo == null) {
            ArrayOfDouble arrayOfDouble = new ArrayOfDouble();
            arrayOfDouble.getDouble().add(intCode);
            CreditInfoByIntCodeExXMLResponse.CreditInfoByIntCodeExXMLResult creditInfoByIntCodeExXMLResult = service.creditInfoByIntCodeExXML(arrayOfDouble);
            orgInfo = Parser.parseDocumentToString(((Element) creditInfoByIntCodeExXMLResult.getContent().get(0)).getOwnerDocument());
            orgInfoDAO.updateCreditOrgInfo(intCode, orgInfo);
        }

        return orgInfo;
    }

}
