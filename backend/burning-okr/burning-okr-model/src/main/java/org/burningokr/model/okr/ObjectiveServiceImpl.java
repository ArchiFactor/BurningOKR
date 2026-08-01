package org.burningokr.model.okr;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectiveServiceImpl implements ObjectiveService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Objective> getObjectivesByParentOkrUnitId(Long parentOkrUnitId) {
        if (parentOkrUnitId == null) {
            return List.of();
        }
        return entityManager.createQuery("SELECT e FROM Objective e WHERE e.parentOkrUnitId = :parentOkrUnitId", Objective.class)
                .setParameter("parentOkrUnitId", parentOkrUnitId)
                .getResultList();
    }

}
