package social.socialmanager.service.resourceservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import social.socialmanager.dao.resourceDAO.ResourceDAO;
import social.socialmanager.model.Resource;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private ResourceDAO resourceDAO;

    public ResourceServiceImpl(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @Transactional
    public void insertResource(Resource resource) {
        this.resourceDAO.insertResource(resource);
    }

    @Transactional
    public void updateResource(Resource resource) {
        this.resourceDAO.updateResource(resource);
    }

    @Transactional
    public void deleteResource(int id) {
        this.resourceDAO.deleteResource(id);
    }

    @Transactional
    public Resource getByID(int id) {
        return this.resourceDAO.getByID(id);
    }

    @Transactional
    public List<Resource> getResources() {
        return this.resourceDAO.getResources();
    }
}
