package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class OrgInfoDAOImpl implements OrgInfoDAO {

    private final JdbcTemplate template;

    public OrgInfoDAOImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Double getIntCode(String bicCode) {
        return template.query("SELECT intCode FROM cachedb.int_codes WHERE bicCode = ?", resultSet -> {
            if (resultSet.next()) {
                return resultSet.getDouble("intCode");
            } else {
                return null;
            }
        }, bicCode);
    }

    @Override
    public void updateIntCode(String bicCode, double intCode) {
        template.update("INSERT INTO cachedb.int_codes (bicCode, intCode) VALUES (?,?)", bicCode, intCode);
    }

    @Override
    public String getCreditOrgInfo(double intCode) {
        return template.query("SELECT orgInfo FROM cachedb.credit_org_info WHERE intCode = ?", resultSet -> {
            if (resultSet.next()) {
                return resultSet.getString("orgInfo");
            } else {
                return null;
            }
        }, intCode);
    }

    @Override
    public void updateCreditOrgInfo(double intCode, String orgInfo) {
        template.update("INSERT INTO cachedb.credit_org_info (intCode, orgInfo) VALUES (?,?)", intCode, orgInfo);
    }
}
