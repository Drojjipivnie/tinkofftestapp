package com.example.dao;

public interface OrgInfoDAO {

    Double getIntCode(String bicCode);

    void updateIntCode(String bicCode, double intCode);

    String getCreditOrgInfo(double intCode);

    void updateCreditOrgInfo(double intCode, String orgInfo);
}
