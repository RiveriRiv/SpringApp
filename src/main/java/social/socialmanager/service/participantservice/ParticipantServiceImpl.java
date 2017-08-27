package social.socialmanager.service.participantservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import social.socialmanager.dao.participantDAO.ParticipantDao;
import social.socialmanager.model.Participant;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantDao participantDao;

    public ParticipantServiceImpl(ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    @Transactional
    public void insertParticipant(Participant participant) {
        this.participantDao.insertParticipant(participant);
    }

    @Transactional
    public void updateParticipant(Participant participant) {
        this.participantDao.updateParticipant(participant);
    }

    @Transactional
    public void deleteParticipant(int id) {
        this.participantDao.deleteParticipant(id);
    }

    @Transactional
    public Participant findByID(int id) {
        return this.participantDao.findByID(id);
    }


    public List<Participant> getParticipant() {
        return this.participantDao.getParticipant();
    }
}
