package com.assh.supervisor.multitenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        return (tenant != null) ? tenant : "tenant1"; 
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}

