package org.burningokr.model.okr;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyResultServiceImpl implements KeyResultService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public KeyResult getKeyResultById(Long id) {
        return entityManager.find(KeyResult.class, id);
    }

}
