package social.socialmanager.dao.resourceDAO;

import social.socialmanager.model.Resource;

import java.util.List;

public interface ResourceDAO {

    void insertResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(int id);

    Resource getByID(int id);

    List<Resource> getResources();
}
