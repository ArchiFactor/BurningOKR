package org.burningokr.model.okr.okrTopicDraft;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OkrTopicDraftServiceImpl implements OkrTopicDraftService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public OkrTopicDraft getOkrTopicDraftById(Long id) {
        return entityManager.find(OkrTopicDraft.class, id);
    }

}
