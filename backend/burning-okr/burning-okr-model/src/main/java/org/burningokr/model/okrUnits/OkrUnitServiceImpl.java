package org.burningokr.model.okrUnits;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OkrUnitServiceImpl implements OkrUnitService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public OkrUnit getOkrUnitById(Long id) {
        return entityManager.find(OkrUnit.class, id);
    }

}
