package org.burningokr.model.okr;

import java.util.List;

public interface ObjectiveService {
    List<Objective> getObjectivesByParentOkrUnitId(Long parentOkrUnitId);
}
