package com.example.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CreditOrgServiceImpl implements CreditOrgService {

    private final Map<String, String> cacheMap;
    private final CreditOrgInfoDelegate delegate;

    public CreditOrgServiceImpl(CreditOrgInfoDelegate delegate) {
        this.delegate = delegate;
        this.cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public String getCreditOrgInfo(String bikCode) {
        return cacheMap.computeIfAbsent(bikCode, s -> {
            double intCode = delegate.getIntCode(bikCode);
            return delegate.getCreditOrgInfo(intCode);
        });
    }
}
