package social;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import social.socialmanager.model.Participant;
import social.socialmanager.service.participantservice.ParticipantService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath:context.xml"})
@Transactional
public class ParticipantServiceTest {

    @Autowired
    public SessionFactory sessionFactory;

    @Test
    public void insertParticipantTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ParticipantService participantService = (ParticipantService) context.getBean("participantService");

        Participant participant = new Participant();
        participant.setLogin("ololo");
        participant.setName("ololoshka");
        participant.setPassword("ololo1234");
        participantService.insertParticipant(participant);

        Session session = sessionFactory.getCurrentSession();
        List<Participant> list = (ArrayList<Participant>) session.createQuery("from Participant where NAME like 'ololoshka'").list();
        assertNotNull(list);
        assertEquals(0, list.size());
    }
}
