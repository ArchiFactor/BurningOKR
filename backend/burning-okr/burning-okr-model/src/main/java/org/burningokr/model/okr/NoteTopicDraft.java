package org.burningokr.model.okr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.burningokr.model.ServiceFactory;
import org.burningokr.model.okr.okrTopicDraft.OkrTopicDraft;
import org.burningokr.model.okr.okrTopicDraft.OkrTopicDraftService;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class NoteTopicDraft extends Note {

  @Transient
private OkrTopicDraft parentTopicDraft;
  @Column(name = "parentTopicDraft_id")
  private Long parentTopicDraftId;

  public NoteTopicDraft() {
    super();
  }

  public NoteTopicDraft(Note note) {
    super(note);
  }

  public OkrTopicDraft getParentTopicDraft() {
	if (parentTopicDraft == null && parentTopicDraftId != null && ServiceFactory.isContainerAvailable()) {
		OkrTopicDraftService okrTopicDraftService = ServiceFactory.getOkrTopicDraftService();
		parentTopicDraft = okrTopicDraftService.getOkrTopicDraftById(parentTopicDraftId);
	}
	return parentTopicDraft;
  }

  @PrePersist
  @PreUpdate
  private void syncUnmappedForeignKeys() {
	if (this.parentTopicDraft != null) {
		this.parentTopicDraftId = this.parentTopicDraft.getId();
	}
  }
}
