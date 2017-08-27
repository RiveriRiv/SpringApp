package social;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import social.socialmanager.model.Participant;
import social.socialmanager.service.participantservice.ParticipantService;

public class ParticipantServiceTest {

    @Test
    public void insertParticipantTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ParticipantService participantService = (ParticipantService) context.getBean("participantService");

        Participant participant = new Participant();
        participant.setLogin("ololo");
        participant.setName("ololoshka");
        participant.setPassword("ololo1234");
        participantService.insertParticipant(participant);
    }
}
