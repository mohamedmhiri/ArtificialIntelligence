package javacode.search.tree;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program{
    public static void main(String []args){

        TreeBuilder treeBuilder = new TreeBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println("To create a new Tree please follow the instructions");
        System.out.println("Tree's level followed by a white space followed by the number of children for each node");
        int levels = in.nextInt();
        int nbChildren = in.nextInt();
        System.out.println("Tree's level is : "+levels+" with "+nbChildren+" children in each node");
        int len = treeBuilder.nodesNumber(nbChildren, levels);
        System.out.println("Now let's insert "+ len +" numbers in the tree");
        int[] numbers = new int[len];
        int i=0;
        while (len > i){
            numbers[i]=in.nextInt();
            i ++;
        }
        Tree tree = treeBuilder.build(levels, nbChildren, numbers);
        System.out.println(tree.getRepresentation());
    }

}
