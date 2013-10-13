package mikaelhg.example;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("examples")
@Produces("application/json")
public class ExampleResource {

    @PersistenceContext
    private EntityManager em;

    @GET @Path("/")
    public List<Example> listExamples() {
        final CriteriaQuery<Example> cq = em.getCriteriaBuilder()
                .createQuery(Example.class);
        return em.createQuery(cq).getResultList();
    }

}
