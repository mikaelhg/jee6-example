package mikaelhg.example;

import org.joda.time.DateTime;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateful
@Named("data")
@SessionScoped
public class ExampleService implements Serializable {

    @PersistenceContext
    private EntityManager em;

    private List<Example> examples;

    private List<Example> comedies;

    private String newExampleText;

    @PostConstruct
    public void postConstruct() {
        System.out.println(DateTime.now() + " postConstruct");
        refreshData();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void refreshData() {
        examples = em.createQuery(em.getCriteriaBuilder().createQuery(Example.class)).getResultList();
        final String jql = "SELECT e FROM Example e WHERE e.name LIKE '%y%'";
        comedies = em.createQuery(jql, Example.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createExample() {
        em.persist(new Example(newExampleText));
        newExampleText = "";
        refreshData();
    }

    public List<Example> getExamples() {
        return this.examples;
    }

    public List<Example> getComedies() {
        return this.comedies;
    }

    public String getNewExampleText() {
        return newExampleText;
    }

    public void setNewExampleText(String newExample) {
        this.newExampleText = newExample;
    }

}
