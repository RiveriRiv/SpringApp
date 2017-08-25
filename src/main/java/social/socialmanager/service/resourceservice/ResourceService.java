package social.socialmanager.service.resourceservice;

import social.socialmanager.model.Resource;

import java.util.List;

public interface ResourceService {

    void insertResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(int id);

    Resource getByID(int id);

    List<Resource> getResources();
}
