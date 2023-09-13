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

    public boolean existById(Long id){
        return findOne(id) != null;
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

    public void deleteById(Long id){
        em.remove(findOne(id));
    }

    // entity manager가 DB에 직접적으로 어떻게 연결되는지 볼 필요가 있을듯//
    // updat 관련해서는 jpa dirty checking으로 해결됨.
}

