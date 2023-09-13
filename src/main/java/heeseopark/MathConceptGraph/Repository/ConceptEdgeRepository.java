package heeseopark.MathConceptGraph.Repository;

import heeseopark.MathConceptGraph.Domain.ConceptEdge;
import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Domain.GradeLevel;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConceptEdgeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ConceptEdge edge){
        em.persist(edge);
    }

    public ConceptEdge findOne(Long id){
        return em.find(ConceptEdge.class, id);
    }

    public boolean existById(Long id){
        return findOne(id) != null;
    }

    public List<ConceptEdge> findAll(){
        return em.createQuery("select e from ConceptEdge e", ConceptEdge.class)
                .getResultList();
    }

    public List<ConceptEdge> findByName(String name){
        return em.createQuery("select n from ConceptEdge n where n.name = :name", ConceptEdge.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<ConceptEdge> findByGrade(GradeLevel grade){
        return em.createQuery("select e from ConceptEdge e where e.grade = :grade", ConceptEdge.class)
                .setParameter("grade", grade)
                .getResultList();
    }

    public void deleteById(Long id){
        em.remove(findOne(id));
    }

}

