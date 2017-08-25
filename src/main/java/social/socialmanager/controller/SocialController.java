package social.socialmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import social.socialmanager.model.Participant;
import social.socialmanager.service.participantservice.ParticipantService;
import social.socialmanager.service.resourceservice.ResourceService;

@Controller
public class SocialController {

    private ParticipantService participantService;
    private ResourceService resourceService;

    @Autowired(required = true)
    @Qualifier(value = "participantService")
    public void setParticipantService(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @Autowired(required = true)
    @Qualifier(value = "resourceService")
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void insertParticipant(@ModelAttribute("participant") Participant participant) {
        if (participant.getId() == 0) {
            this.participantService.insertParticipant(participant);
        }
    }
}
