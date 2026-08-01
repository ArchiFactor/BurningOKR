package org.burningokr.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;import org.springframework.stereotype.Component;

import org.burningokr.model.okrUnits.OkrUnitService;
import org.burningokr.model.okr.ObjectiveService;
import org.burningokr.model.okr.KeyResultService;
import org.burningokr.model.okr.NoteTopicDraftService;
import org.burningokr.model.okr.okrTopicDraft.OkrTopicDraftService;

@Component
public class ServiceFactory implements ApplicationContextAware {
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = (ConfigurableApplicationContext) context;
    }

    public static boolean isContainerAvailable() {
        return applicationContext != null && applicationContext.isActive();
    }

    public static OkrUnitService getOkrUnitService() {
        return applicationContext.getBean(OkrUnitService.class);
    }

    public static ObjectiveService getObjectiveService() {
        return applicationContext.getBean(ObjectiveService.class);
    }

    public static KeyResultService getKeyResultService() {
        return applicationContext.getBean(KeyResultService.class);
    }

    public static NoteTopicDraftService getNoteTopicDraftService() {
        return applicationContext.getBean(NoteTopicDraftService.class);
    }

    public static OkrTopicDraftService getOkrTopicDraftService() {
        return applicationContext.getBean(OkrTopicDraftService.class);
    }

}
