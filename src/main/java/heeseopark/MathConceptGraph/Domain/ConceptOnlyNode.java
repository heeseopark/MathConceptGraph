package heeseopark.MathConceptGraph.Domain;

public class ConceptOnlyNode {

    private Long id;
    private String name;
    private int grade;

    // Default constructor
    public ConceptOnlyNode() {
    }

    // Parameterized constructor
    public ConceptOnlyNode(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 7 || grade > 12) {
            throw new IllegalArgumentException("Grade must be between 7 and 12.");
        }
        this.grade = grade;
    }

    // You might also want to override toString(), equals(), and hashCode() methods as appropriate.
}

