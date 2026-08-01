package org.burningokr.model.okrUnits;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.burningokr.model.ServiceFactory;
import org.burningokr.model.activity.Trackable;
import org.burningokr.model.okr.Objective;
import org.burningokr.model.okr.ObjectiveService;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@DiscriminatorColumn(name = "okr_unit_type")
public abstract class OkrUnit implements Trackable<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "hibernate_sequence_generator")
  @SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "hibernate_sequence", allocationSize = 1)
  protected Long id;

  @NotNull
  @Size(min = 1)
  protected String name;

  @NotNull
  @Size(min = 1)
  protected String label;

  @Transient
@EqualsAndHashCode.Exclude
  protected Collection<Objective> objectives = new ArrayList<>();

  public boolean hasObjectives() {
    return !this.getObjectives().isEmpty();
  }

  public Collection<Objective> getObjectives() {
	if (objectives.isEmpty() && id != null && ServiceFactory.isContainerAvailable()) {
		ObjectiveService objectiveService = ServiceFactory.getObjectiveService();
		objectives.addAll(objectiveService.getObjectivesByParentOkrUnitId(id));
	}
	return objectives;
  }
}
