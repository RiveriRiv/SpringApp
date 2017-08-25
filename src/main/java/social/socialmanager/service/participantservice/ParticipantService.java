package social.socialmanager.service.participantservice;

import social.socialmanager.model.Participant;

import java.util.List;

public interface ParticipantService {
    void insertParticipant(Participant participant);

    void updateParticipant(Participant participant);

    void deleteParticipant(int id);

    Participant findByID(int id);

    List<Participant> getParticipant();
}
