package org.burningokr.model.okr;

import java.util.List;

public interface NoteTopicDraftService {
    List<NoteTopicDraft> getNoteTopicDraftsByParentTopicDraftId(Long parentTopicDraftId);
}
