// --== CS400 File Header Information ==--
// Name: Reva Kumthekar
// Email: rkumthekar@wisc.edu
// Team: BG
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: NONE

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 * 
 * @author revakumthekar
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-E
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        // insert edges from Week 09. Dijkstra's Activity
        graph.insertEdge("A","B",2);
        graph.insertEdge("A","D",4);
        graph.insertEdge("A","E",1);
        graph.insertEdge("B","C",5);
        graph.insertEdge("C","A",3);
        graph.insertEdge("D","B",3);
        graph.insertEdge("D","C",7);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","C",8);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled C to E
     * (should be 4), and from the vertex labelled A to C (should be 7).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost("C", "E") == 4);    
        assertTrue(graph.getPathCost("A", "C") == 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled C to E, and from the vertex labelled A to C.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, A, E]"
        ));
        assertTrue(graph.shortestPath("A", "C").toString().equals(
            "[A, B, C]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from my source vertex to the farthest vertex
     * in the activity, which is labeled C and D (should be 7).
     */
    @Test
    public void activityDistanceTest() {
      assertTrue(graph.getPathCost("C", "D") == 7);
    }
    
    /**
     * Checks the ordered sequence of data within vertices from my source vertex to the farthest vertex
     * in the activity, which is labeled C to E.
     */
    @Test
    public void activitySequenceTest()
    {
      assertTrue(graph.shortestPath("C", "D").toString().equals(
          "[C, A, D]"
      ));
    }
    
    /**
     * Checks the ordered sequence of data within vertices after removing the edge from A to E
     * in the activity, and how it affects the shortest path taken from C to E.
     */
    @Test
    public void removeEdgeTest()
    {
      graph.removeEdge("A", "E");
      assertTrue(graph.shortestPath("C", "E").toString().equals(
          "[C, A, D, E]"
      ));
    }
    
    /**
     * Checks the ordered sequence of data within vertices after changing the weight of
     * the edge from A to E from 1 to 7 in the activity, and how it affects the shortest
     * path taken from C to E.
     */
    @Test
    public void changeEdgeValueTest()
    {
      graph.insertEdge("A", "E", 7);
      assertTrue(graph.shortestPath("C", "E").toString().equals(
          "[C, A, D, E]"
      ));
    }
    
    /**
     * Checks if dijkstrasShortestPath's method throws a NoSuchElementException like it should
     * if the vertex specified is not in the graph.
     */
    @Test
    public void nullVertexTest()
    {

      try {
        graph.shortestPath("C", "F").toString().equals("[C, A, D, E]");
        Assertions.fail();
      }catch(NoSuchElementException e)
      {
        
      }
    }
    
    
    
}
