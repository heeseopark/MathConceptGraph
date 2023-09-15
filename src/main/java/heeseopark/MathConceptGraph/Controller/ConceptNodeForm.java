package heeseopark.MathConceptGraph.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConceptNodeForm {

    private Long id;

    private String name;

    private String meaning;

    private String grade;

    private String sourceEdge;

    private String targetEdge;

}
