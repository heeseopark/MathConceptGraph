package heeseopark.MathConceptGraph.Domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ConceptEdge {

    @Id
    @GeneratedValue
    @Column(name = "edge_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GradeLevel grade;

    private String meaning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_node_id")
    private ConceptNode startNode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_node_id")
    private ConceptNode endNode;

    /**
     * 
     * need to build custom setters like setName, setGrade etc
     * 
     * entity create 때 build design pattern을 써서 create을 다루고
     * 
     * update는 builder design pattern과 비슷한 느낌으로 method를 만들자.
     * 
     * updating methods
     * updateName
     * updateGrade
     * updateMeaning
     * 
     */

}