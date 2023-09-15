package heeseopark.MathConceptGraph.Domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder
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

    // 단원 field 추가하기


}

