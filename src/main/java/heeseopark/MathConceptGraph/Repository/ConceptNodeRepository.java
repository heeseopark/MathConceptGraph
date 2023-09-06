package heeseopark.MathConceptGraph.Repository;

import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Domain.GradeLevel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConceptNodeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ConceptNode node){
        em.persist(node);
    }

    public ConceptNode findOne(Long id){
        return em.find(ConceptNode.class, id);
    }

    public List<ConceptNode> findAll(){
        return em.createQuery("select n from ConceptNode n", ConceptNode.class)
                .getResultList();
    }

    public List<ConceptNode> findByName(String name){
        return em.createQuery("select n from ConceptNode n where n.name = :name", ConceptNode.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<ConceptNode> findByGrade(GradeLevel grade){
        return em.createQuery("select n from ConceptNode n where n.grade = :grade", ConceptNode.class)
                .setParameter("grade", grade)
                .getResultList();
    }

    public void delete(Long id){
        ConceptNode node = findOne(id);
        if (node != null) {
            em.remove(node);
        }
    }
}

