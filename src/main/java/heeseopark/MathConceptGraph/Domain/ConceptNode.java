package heeseopark.MathConceptGraph.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "node")
@Getter @Setter
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


}

