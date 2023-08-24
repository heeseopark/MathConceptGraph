package heeseopark.MathConceptGraph.Temporary.Domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Node {
    public enum Label {
        EXPRESSION, CONCEPT
    }

    private String id;
    private Label label;
    private Node superConcept; // Only populated if the label is CONCEPT
    private Map<String, Object> properties;

    public Node(String id, Label label) {
        this.id = id;
        this.label = label;
        this.properties = new HashMap<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public Label getLabel() {
        return label;
    }

    public Optional<Node> getSuperConcept() {
        return Optional.ofNullable(superConcept);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setSuperConcept(Node superConcept) {
        if (label == Label.CONCEPT) {
            this.superConcept = superConcept;
        } else {
            throw new IllegalStateException("SuperConcept can only be set for nodes with CONCEPT label.");
        }
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    // Utility methods for properties
    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Optional<Object> getProperty(String key) {
        return Optional.ofNullable(properties.get(key));
    }

    public void removeProperty(String key) {
        properties.remove(key);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", label=" + label +
                ", superConcept=" + (superConcept != null ? superConcept.getId() : "None") +
                ", properties=" + properties +
                '}';
    }

    // Other methods can be added as needed...
}


