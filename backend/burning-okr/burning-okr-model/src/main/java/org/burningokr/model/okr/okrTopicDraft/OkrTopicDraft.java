package org.burningokr.model.okr.okrTopicDraft;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.burningokr.model.ServiceFactory;
import org.burningokr.model.okr.NoteTopicDraft;
import org.burningokr.model.okr.NoteTopicDraftService;
import org.burningokr.model.okr.OkrTopicDescription;
import org.burningokr.model.okr.histories.OkrTopicDraftHistory;
import org.burningokr.model.okrUnits.OkrUnit;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class OkrTopicDraft extends OkrTopicDescription {

  @Nullable
  @ManyToOne
  private OkrUnit parentUnit;

  @ManyToOne
  private OkrTopicDraftHistory history;

  @Enumerated(EnumType.STRING)
  private OkrTopicDraftStatusEnum currentStatus;

  @Transient
@ToString.Exclude
  private Collection<NoteTopicDraft> notes = new ArrayList<>();

  public Collection<NoteTopicDraft> getNotes() {
	if (notes.isEmpty() && getId() != null && ServiceFactory.isContainerAvailable()) {
		NoteTopicDraftService noteTopicDraftService = ServiceFactory.getNoteTopicDraftService();
		notes.addAll(noteTopicDraftService.getNoteTopicDraftsByParentTopicDraftId(getId()));
	}
	return notes;
  }
}
