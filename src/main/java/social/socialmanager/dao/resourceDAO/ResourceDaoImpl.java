package social.socialmanager.dao.resourceDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import social.socialmanager.model.Resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDAO {

    private static final Logger logger = LoggerFactory.getLogger(ResourceDaoImpl.class);

    private SessionFactory sessionFactory;

    public ResourceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertResource(Resource resource) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(resource);
        logger.info("Resource with url: " + resource.getUrl() + ", id: " + resource.getId() + " was inserted");
    }

    public void updateResource(Resource resource) {
        Session session = sessionFactory.getCurrentSession();
        session.update(resource);
        logger.info("Resource with url: " + resource.getUrl() + ", id: " + resource.getId() + " was updated");
    }

    public void deleteResource(int id) {
        Session session = sessionFactory.getCurrentSession();
        Resource resource = (Resource) session.load(Resource.class, id);

        if (resource != null) {
            session.delete(resource);
            logger.info("Resource with url: " + resource.getUrl() + ", id: " + resource.getId() + " was deleted");
        }
    }

    public Resource getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Resource resource = (Resource) session.load(Resource.class, id);
        return resource;
    }

    public List<Resource> getResources() {
        Session session = sessionFactory.getCurrentSession();
        List<Resource> list = (ArrayList<Resource>) session.createQuery("select * from SPR_RESOURCE");
        return list;
    }
}
