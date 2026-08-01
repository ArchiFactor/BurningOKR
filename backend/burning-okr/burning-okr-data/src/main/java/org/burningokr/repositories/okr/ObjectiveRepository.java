package org.burningokr.repositories.okr;

import org.burningokr.model.okr.Objective;
import org.burningokr.repositories.ExtendedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectiveRepository extends ExtendedRepository<Objective, Long> {
  @Query("SELECT o FROM Objective o WHERE o.parentOkrUnitId = ?1 ORDER BY sequence")
  List<Objective> findByUnitIdAndOrderBySequence(Long departmentId);

  List<Objective> findByParentObjectiveId(long id);
}
