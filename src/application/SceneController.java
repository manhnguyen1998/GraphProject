package application;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class SceneController implements Initializable {
	@FXML
	private Pane side_pane;
	@FXML
	private RadioButton dfs_button;
	@FXML
	private RadioButton bfs_button;
	@FXML
	private RadioButton dijistra_button;
	@FXML
	private RadioButton add_node_button;
	@FXML
	private RadioButton add_edge_button;
	@FXML
	private Button clear_button;
	@FXML
	private ImageView start_button;
	@FXML
	private Pane canvasGroup;
	@FXML
	private NodeFX nodeList;
	
	List<NodeFX> circles = new ArrayList<>();
    List<Edge> mstEdges = new ArrayList<>(), realEdges = new ArrayList<>();
    List<Shape> edges = new ArrayList<>();
	ToggleGroup toggleGroup = new ToggleGroup();
	
	
	// event handler for add node
	EventType<MouseEvent> mousePress = MouseEvent.MOUSE_PRESSED;
	EventHandler<MouseEvent> addNode = new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent mouseEvent) {
	        System.out.println("mouse click detected! " + mouseEvent.getSource());
	        
               NodeFX circle = new NodeFX(mouseEvent.getX(), mouseEvent.getY(), 1.2, String.valueOf("1"));
//               circle.setRadius(10.0f);
               ScaleTransition tr = new ScaleTransition(Duration.millis(100), circle);
               tr.setByX(10f);
               tr.setByY(10f);
               tr.setInterpolator(Interpolator.EASE_OUT);
               tr.play();
           canvasGroup.getChildren().add(circle);
	    }
	};
	
	// event hanlder for add edge
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 dfs_button.setToggleGroup(toggleGroup);
		 bfs_button.setToggleGroup(toggleGroup);
		 dijistra_button.setToggleGroup(toggleGroup);
		 add_node_button.setToggleGroup(toggleGroup);
		 add_edge_button.setToggleGroup(toggleGroup);
		
		 
		 // add listener for radio group button
		 toggleGroup.selectedToggleProperty().addListener(new InvalidationListener() {
			 public void invalidated(javafx.beans.Observable ov) {
		            if (dfs_button.isSelected()) {
		            	//remove all event of addNode and addEdge
		            	canvasGroup.removeEventFilter(mousePress, addNode);
		                System.out.println("dfs clicked");
		            }
		            if (bfs_button.isSelected()) {
		            	//remove all event of addNode and addEdge
		            	canvasGroup.removeEventFilter(mousePress, addNode);
		                System.out.println("dfs clicked");
		            }
		            if (dijistra_button.isSelected()) {
		            	//remove all event of addNode and addEdge
		            	canvasGroup.removeEventFilter(mousePress, addNode);
		                System.out.println("dfs clicked");
		            }
		            if (add_node_button.isSelected()) {
		            	//remove all event of addNode and addEdge
		                System.out.println("add node clicked");
		                canvasGroup.addEventFilter(mousePress, addNode);
		            }
		            if (add_edge_button.isSelected()) {
		            	//remove all event of addNode and addEdge
		            	canvasGroup.removeEventFilter(mousePress, addNode);
		                System.out.println("dfs clicked");
		            }
		        }

			
		    });

		
		
	 }
	 
	 
//	 EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
//	   	 @FXML
//	   	    public void handle(MouseEvent ev) {
//	   	       
//
//	   	            if (!ev.getSource().equals(canvasGroup)) {
//	   	                if (ev.getEventType() == MouseEvent.MOUSE_RELEASED && ev.getButton() == MouseButton.PRIMARY) {
//	   	                        System.out.println("here" + ev.getEventType());
//	   	                        NodeFX circle = new NodeFX(ev.getX(), ev.getY(), 1.2, String.valueOf("1"));
//	   	                    canvasGroup.getChildren().add(circle);
//	   	                
//
//	   	                    circle.setOnMousePressed(mouseHandler);
//	   	                    circle.setOnMouseReleased(mouseHandler);
//	   	                    circle.setOnMouseDragged(mouseHandler);
//	   	                    circle.setOnMouseExited(mouseHandler);
//	   	                    circle.setOnMouseEntered(mouseHandler);
//
//	   	                    ScaleTransition tr = new ScaleTransition(Duration.millis(100), circle);
//	   	                    tr.setByX(10f);
//	   	                    tr.setByY(10f);
//	   	                    tr.setInterpolator(Interpolator.EASE_OUT);
//	   	                    tr.play();
//	   	                }
//	   	                }
//	   	            }
//	   	 };
	
	 
	 
//	 boolean edgeExists(NodeFX u, NodeFX v) {
//	        for (Edge e : realEdges) {
//	            if (e.source == u.node && e.target == v.node) {
//	                return true;
//	            }
//	        }
//	        return false;
//	    }
//	 
	 
	 public class NodeFX extends Circle {

	        Node node;
	        Point point;
	        Label distance = new Label("Dist. : INFINITY");
	        Label visitTime = new Label("Visit : 0");
	        Label lowTime = new Label("Low : 0");
	        Label id;
	        boolean isSelected = false;

	        public NodeFX(double x, double y, double rad, String name) {
	            super(x, y, rad);
	            point = new Point((int) x, (int) y);
	            id = new Label(name);
	            canvasGroup.getChildren().add(id);
	            id.setLayoutX(x - 18);
	            id.setLayoutY(y - 18);
	            this.setOpacity(0.5);
	            this.setBlendMode(BlendMode.MULTIPLY);
	            this.setId("node");

	        }
	    }
	    }
	