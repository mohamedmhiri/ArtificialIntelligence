package javacode.search.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Leaf implements ILeaf{

    private List<Leaf> children;
    private int level;
    private int kernel;

    public Leaf(int kernel, List<Leaf> children, int level) {
        this.setKernel(kernel);
        this.setChildren(children);
        this.setLevel(level);
    }

    public Leaf() {
    }
    //getters and setters
    /**
     *
     * @return List<Leaf>
     */
    public int getKernel() {
        return kernel;
    }

    public List<Leaf> getChildren() {
        return children;
    }

    public int getLevel() {
        return level;
    }
    public void setChildren(List<Leaf> children) {
        this.children = children;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setKernel(int kernel) {
        this.kernel = kernel;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "{\n" +
                "kernel=" + getKernel() +
                ", level=" + getLevel() +
                ", children=" + getChildren() +
                '}';
    }
}