package heeseopark.MathConceptGraph.Repository;

import heeseopark.MathConceptGraph.Domain.ConceptEdge;
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

    public List<ConceptEdge> findAll(){
        return em.createQuery("select e from ConceptEdge e", ConceptEdge.class)
                .getResultList();
    }

    public List<ConceptEdge> findByGrade(GradeLevel grade){
        return em.createQuery("select e from ConceptEdge e where e.grade = :grade", ConceptEdge.class)
                .setParameter("grade", grade)
                .getResultList();
    }

    public void delete(Long id){
        ConceptEdge edge = findOne(id);
        if (edge != null) {
            em.remove(edge);
        }
    }
}

