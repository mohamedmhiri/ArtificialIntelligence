package javacode.search.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.Math;
import java.lang.StringBuilder;

public class TreeBuilder{

    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public int nodesNumber(int nbChildren, int level){
        int s=0;
        for(int i=1;i<=level;i++)
            s+=Math.pow(nbChildren,i-1);
        return s;
    }
    public Tree build(int levels,int nbChildren, int[] numbers){
        Tree tree = new Tree();
        List<Leaf> leafs = new ArrayList<Leaf>();
        StringBuilder str = new StringBuilder();
        for(int i=0; i<this.nodesNumber(nbChildren,levels);i++)
            leafs.add(new Leaf());
        int j=0,k=0,f=0,l=0,s=0,t=0;
        while((j<levels) && (k<this.nodesNumber(nbChildren,levels)) && (f<Math.pow(nbChildren,j)) ){

            if(j>2)
                l=j-2;
            leafs.get(k).setKernel(numbers[k]);
            leafs.get(k).setLevel(j);
            if ((k>0) && (leafs.get(k).getLevel() > leafs.get(k-1).getLevel()))
                str.append('\n');
            str.append("[ "+numbers[k]+" ]");

            f++;
            if(j == 0)
                s=0;
            else if(j == 1)
                s=f;
            else if((j > 1)&& (leafs.get(k).getLevel() == leafs.get(k-1).getLevel()))
                s++;
            else if((j > 1) && (leafs.get(k).getLevel() > leafs.get(k-1).getLevel())){
                s=f;
                s+=Math.pow(nbChildren,j-1);
                t=l;
                while(l>0){
                    s+=Math.pow(nbChildren,j-(1+l));
                    l--;
                }
                l=t;
            }
            if(k<this.nodesNumber(nbChildren,levels-1))
                leafs.get(k).setChildren(leafs.subList((nbChildren*s)+1,(nbChildren*s)+3));
            k++;

            if(f==Math.pow(nbChildren,j)){
                f=0;
                j++;
            }

        }
        int r =this.nodesNumber(nbChildren,levels)-1;
        while(r>this.nodesNumber(nbChildren,levels-1)-1){
            leafs.get(r).setChildren(null);
            r--;
        }
        tree.setRepresentation(str.toString());
        tree.setRoot(leafs.get(0));
        tree.setLevels(levels);
        return tree;
    }


}