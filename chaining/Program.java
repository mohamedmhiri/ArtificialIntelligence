package javacode.chaining;
import java.io.*;
import java.io.IOException;
// import IA.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// import org.apache.commons.lang.StringUtils;

public class Program{
    public static void main(String []args){

        String rulepath = "./base_regle.txt";
        String faitpath = "./base_fait.txt";
        Binder bdr = new Binder();
        List<Regle> regles = bdr.bindRegle( rulepath );
        List<Fait> faits = bdr.bindFait( faitpath );
        /*for( Regle r : regles )
          System.out.println( r );
        for( Fait f : faits )
          System.out.println( f );*/
        BackwardChaining bc = new BackwardChaining();
        ForwardChaining fc = new ForwardChaining();
        List<String> words = bdr.bindBut( faitpath );

        //System.out.println( regles.get(0).getPremisses().get(0) instanceof String );
        /*List<String> res = bc.bcContains( words, regles.get(0).getPremisses() );*/
        for ( String re : words )
          System.out.println( re );
        System.out.println( "\n\n=====================" + fc.verify( words, regles, faits.get( 0 ), "1" ) + "=====================" );
        
    }

}
