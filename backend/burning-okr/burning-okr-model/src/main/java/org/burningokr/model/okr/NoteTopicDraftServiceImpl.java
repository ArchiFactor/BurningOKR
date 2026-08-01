package org.burningokr.model.okr;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteTopicDraftServiceImpl implements NoteTopicDraftService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<NoteTopicDraft> getNoteTopicDraftsByParentTopicDraftId(Long parentTopicDraftId) {
        if (parentTopicDraftId == null) {
            return List.of();
        }
        return entityManager.createQuery("SELECT e FROM NoteTopicDraft e WHERE e.parentTopicDraftId = :parentTopicDraftId", NoteTopicDraft.class)
                .setParameter("parentTopicDraftId", parentTopicDraftId)
                .getResultList();
    }

}
