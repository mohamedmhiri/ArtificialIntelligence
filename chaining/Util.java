package javacode.chaining;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * contains all methods used by Backward
 * and Forward Chaining
 */
public class Util{
    //returns all elements of words not existing in _set
    public List<String> diffLists( List<String> words, List<String> _set){
        int nb = 0;
        List<String> rest = new ArrayList<String>();
        for( int w =0; w< words.size() ; w++ ){
            int n = nb;
            //System.out.println( words.get( w ) );
            if( ! ( _set.contains( words.get( w ) ) ) ){
                nb++;
            }
            if( nb != n )
                rest.add( words.get( w ) );

        }
        return rest;
    }

    /**
     *
     * @param words
     * @param _set
     * @return boolean
     */
    public boolean bcContains( List<String> words, List<String> _set){
        int nb = 0;
        boolean rest = false;
        for( int w =0; w< words.size() ; w++ ){
            int n = nb;
            //System.out.println( words.get( w ) );
            if( ! ( _set.contains( words.get( w ) ) ) ){
                nb++;
            }
            if( nb == n )
                rest = true;

        }
        return rest;
    }

    /**
     * tests weather all list1 values exist in list2
     * @param list1
     * @param list2
     * @return boolean
     */
    public boolean allExists( List<String>list1, List<String>list2 ){
        int nb = list1.size();
        boolean rest = false;
        for( int w =0; w< list1.size() ; w++ ){
            //System.out.println( words.get( w ) );
            if(  list2.contains( list1.get( w ) ) ){
                nb--;
            }
            if( nb == 0 )
                rest = true;

        }
        return rest;
    }

    /**
     * returns regles - regle
     * @param regles
     * @param regle
     * @return List<Regle>
     */
    public List<Regle> delRegle( List<Regle> regles, Regle regle ){
        for (Iterator<Regle> iter = regles.listIterator(); iter.hasNext(); ) {
            Regle r = iter.next();
            if ( r.getNumero() == regle.getNumero() ) {
                iter.remove();
            }
        }
        return regles;
    }

    public int arraySum(int[]tab){
        int res=0;
        for (int i=0; i<tab.length;i++)
            res+=tab[i];
        return res;
    }


}