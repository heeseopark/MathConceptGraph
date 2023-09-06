package heeseopark.Temporary.Domain;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private Long id;
    private String expressionName;

    private List<Expression> subExpressions = new ArrayList<>();

    private Concept sourceConcept;

    private Concept targetConcept;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpressionName() {
        return expressionName;
    }

    public void setExpressionName(String expressionName) {
        this.expressionName = expressionName;
    }

    public List<Expression> getSubExpressions() {
        return subExpressions;
    }

    public void addSubExpression(Expression expression) {
        this.subExpressions.add(expression);
    }

    public Concept getSourceConcept() {
        return sourceConcept;
    }

    public void setSourceConcept(Concept sourceConcept) {
        this.sourceConcept = sourceConcept;
    }

    public Concept getTargetConcept() {
        return targetConcept;
    }

    public void setTargetConcept(Concept targetConcept) {
        this.targetConcept = targetConcept;
    }
}
