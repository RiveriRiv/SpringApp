package social.socialmanager.dao.participantDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import social.socialmanager.model.Participant;

import java.util.ArrayList;
import java.util.List;


public class ParticipantDaoImpl implements ParticipantDao {

    private static final Logger logger = LoggerFactory.getLogger(ParticipantDaoImpl.class);

    private SessionFactory sessionFactory;

    public ParticipantDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertParticipant(Participant participant) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(participant);
        logger.info("Participant with name: " + participant.getName() + ", id: " + participant.getId() + " was inserted");
    }

    public void updateParticipant(Participant participant) {
        Session session = sessionFactory.getCurrentSession();
        session.update(participant);
        logger.info("Participant with name: " + participant.getName() + ", id: " + participant.getId() + " was updated");
    }

    public void deleteParticipant(int id) {
        Session session = sessionFactory.getCurrentSession();
        Participant participant = session.load(Participant.class, id);

        if (participant != null) {
            session.delete(participant);
            logger.info("Participant with name: " + participant.getName() + ", id: " + participant.getId() + " was deleted");
        }
    }

    public Participant findByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Participant participant = session.load(Participant.class, id);
        if (participant == null) {
            logger.debug("Participant with id: " + id + "was not found");
        }
        return participant;
    }

    public List<Participant> getParticipant() {
        Session session = sessionFactory.getCurrentSession();
        List<Participant> list = (ArrayList<Participant>) session.createQuery("select * from SPR_PARTICIPANT");
        return list;
    }
}
