package gui;

/**
 *
 * @author Scott
 */
public class Edge {
	
	// variables
    private Person parent;
    private Person child;
    private String relationship;
    
    // constructor 
    public Edge(Person parent,String relationship,Person child) {
        this.parent = parent;
        this.child = child;
        this.relationship = relationship;
    }
    // getters 
    public Person getParent() {
        return parent;
    }

    public Person getChild() {
        return child;
    }

    public String getRelationship() {
        return relationship;
    }
}
