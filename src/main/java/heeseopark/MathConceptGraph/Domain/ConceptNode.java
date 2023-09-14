package heeseopark.MathConceptGraph.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@Builder
public class ConceptNode {

    @Id @GeneratedValue
    @Column(name = "node_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GradeLevel grade;

    private String meaning;

    @OneToMany(mappedBy = "startNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConceptEdge> sourceEdges;

    @OneToMany(mappedBy = "endNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConceptEdge> targetEdges;

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
