package social.socialmanager.dao.participantDAO;

import social.socialmanager.model.Participant;

import java.util.List;

public interface ParticipantDao {

    void insertParticipant(Participant participant);

    void updateParticipant(Participant participant);

    void deleteParticipant(int id);

    Participant findByID(int id);

    List<Participant> getParticipant();

}
