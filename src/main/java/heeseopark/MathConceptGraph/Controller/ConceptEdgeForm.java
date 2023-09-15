package heeseopark.MathConceptGraph.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConceptEdgeForm {

    private Long id;

    private String name;

    private String meaning;

    private String grade;

    private String startNode;

    private String endNode;

}
