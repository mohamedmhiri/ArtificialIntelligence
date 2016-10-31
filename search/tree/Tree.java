package javacode.search.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Tree{

    @java.lang.Override
    public java.lang.String toString() {
        return "Tree{\n" +
                "root=" + root +
                ", levels=" + levels +
                '}';
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public Leaf getRoot() {
        return root;
    }

    public void setRoot(Leaf root) {
        this.root = root;
    }

    private Leaf root;
    private int levels;

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    private String representation;
}