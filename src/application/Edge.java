package application;

import javafx.scene.control.Label;
import javafx.scene.shape.Shape;

/**
 *
 * @author sowme
 */
public class Edge {

    public Node source, target;
    public double weight;
    public Shape line;
    public Label weightLabel;

    public Shape getLine() {
        return line;
    }

    public Edge(Node argSource, Node argTarget) {
        source = argSource;
        target = argTarget;
        weight = 0;
    }

    public Edge(Node argSource, Node argTarget, double argWeight, Shape argline, Label weiLabel) {
        source = argSource;
        target = argTarget;
        weight = argWeight;
        line = argline;
        this.weightLabel = weiLabel;
    }

}
