package src.VisitorPattern;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
      	//implement this
        return this.result;
        //return 0;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        this.result = this.result + 0;
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        this.result = this.result + leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int result = 1;
    public int getResult() {
      	//implement this
        if ( this.result == 0 ){
            return 1;
        }
        
        return this.result % ( (int) Math.pow(10, 9) + 7 );
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if ( node.getColor() == Color.RED ){ 
            this.result = this.result * node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if ( leaf.getColor() == Color.RED ){ 
            this.result = this.result * leaf.getValue();
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafNodeSum = 0;
    private int leafNodeSum = 0;
    
    public int getResult() {
      	//implement this
        return Math.abs( this.nonLeafNodeSum - this.leafNodeSum );
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if ( ( node.getDepth() % 2 ) == 0 ){ 
            this.nonLeafNodeSum = this.nonLeafNodeSum + node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if ( leaf.getColor() == Color.GREEN ){ 
            this.leafNodeSum = this.leafNodeSum + leaf.getValue();
        }
    }
}

public class VisitorPattern {
  
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        
        // ########## Reading input portion ##########
        
        Scanner in = new Scanner(System.in);
        int numTrees = in.nextInt();
        
        in.nextLine();
        
        int nodeVals[] = new int[numTrees];
        int nodeColors[] = new int[numTrees];
        for ( int nodeValIdx = 0; nodeValIdx < numTrees; nodeValIdx++ ){ 
            nodeVals[nodeValIdx] = in.nextInt();
        } 
        
        in.nextLine();
        
        for ( int nodeColIdx = 0; nodeColIdx < numTrees; nodeColIdx++ ){ 
            nodeColors[nodeColIdx] = in.nextInt();
        }
                
        List<List<Integer>> edges = new ArrayList<>();
        Set<Integer> nonLeafNodes = new HashSet<>();
        for ( int edgeIdx = 0; edgeIdx < ( numTrees - 1 ); edgeIdx++ ){ 
            in.nextLine();
            List<Integer> edge = new ArrayList<Integer>();
            Integer src = Integer.valueOf(in.nextInt());
            Integer dst = Integer.valueOf(in.nextInt());
            
            edge.add(src);
            edge.add(dst);
            nonLeafNodes.add(src);
            edges.add(edge);
        }
        
        in.close();
        
        // ########## Reading input portion ##########
        
        // ########## Tree creation portion ##########
        
        Tree[] trees = new Tree[numTrees];
        TreeNode root = new TreeNode(nodeVals[0], getColor(nodeColors[0]), 0);
        trees[0]= root;
        
        for ( int edgeItr = 0; edgeItr < edges.size(); edgeItr++ ){ 
            List<Integer> currEdge = edges.get(edgeItr);
            Integer srcIdx = currEdge.get(0);
            Integer dstIdx = currEdge.get(1);

            int srcInfoIdx = srcIdx.intValue() - 1;            
            int dstInfoIdx = dstIdx.intValue() - 1;

            Tree src = trees[srcInfoIdx];
            Tree dst = null;
            
            if ( src == null ){ 
                trees[srcInfoIdx] = new TreeNode(
                    nodeVals[srcInfoIdx],
                    getColor(nodeColors[srcInfoIdx]),
                    0
                );
                
                src = trees[srcInfoIdx];
            }
            
            if ( nonLeafNodes.contains(dstIdx) ){
                dst = new TreeNode(
                                nodeVals[dstInfoIdx],
                                getColor(nodeColors[dstInfoIdx]),
                                src.getDepth() + 1
                            );
            } else { 
                dst = new TreeLeaf(
                                nodeVals[dstInfoIdx],
                                getColor(nodeColors[dstInfoIdx]),
                                src.getDepth() + 1
                            );
            }
            
            trees[dstInfoIdx] = dst;
            TreeNode par = (TreeNode)src;
            par.addChild(dst);
                        
        }
        // ########## Tree creation portion ##########

        return root;
    }
    
    public static Color getColor(int colorIndex) { 
        if ( colorIndex == 1 ){ 
            return Color.GREEN;
        }
        
        return Color.RED;
    }
    

    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
