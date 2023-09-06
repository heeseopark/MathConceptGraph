package heeseopark.Temporary.Domain;

public class Concept {

    private Long id;
    private String conceptName;
    private Expression sourceExpression;
    private Expression targetExpression;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public Expression getSourceExpression(){
        return sourceExpression;
    }

    public void setSourceExpression(Expression sourceExpression){
        this.sourceExpression = sourceExpression;
    }

    public Expression getTargetExpression(){
        return targetExpression;
    }

    public void setTargetExpression(Expression targetExpression){
        this.targetExpression = targetExpression;
    }

}
