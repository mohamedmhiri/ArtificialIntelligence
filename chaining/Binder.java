package javacode.chaining;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Binder{
    public List<Regle> bindRegle(String path){
        
        try (BufferedReader in =  new BufferedReader(new FileReader( path ))) {
            String line;
            List<Regle> regles = new ArrayList<Regle>();
            while((line = in.readLine()) != null) {
                Regle regle=new Regle();
                String _line=line.substring(line.lastIndexOf(":") + 1);
                String _nbr = line.substring(1,line.indexOf(":"));
                int nbr = Integer.parseInt(_nbr);
                //test if "ET" is in premisses
                String prepremisses=_line.substring(0,_line.indexOf("=>"));
                List<String> premisses = new ArrayList<String>();
                if(prepremisses.toLowerCase().contains("ET".toLowerCase())){
                    String[] pre = prepremisses.split("ET");
                    for (String p: pre){
                        if( !p.toLowerCase().contains("NON".toLowerCase()) ){
                            String pp = p.replace(" ","");
                            premisses.add(pp);
                        }

                    }
                }
                else{
                    premisses.add(prepremisses);
                }
                    
                //test if "ET" is in conclusions
                //if()
                String preconclusions=_line.substring(_line.lastIndexOf(">") + 1);
                List<String> conclusions = new ArrayList<String>();
                if(preconclusions.toLowerCase().contains("ET".toLowerCase())){
                    String[] pre = preconclusions.split("ET");
                    for (String p: pre){
                        String pp = p.replace(" ","");
                        conclusions.add(pp);
                    }
                }
                else{
                    conclusions.add(preconclusions);
                }
                regle.setNumero(nbr);
                regle.setPremisses( premisses );
                regle.setConclusions( conclusions );
                regles.add( regle );

            }
            return regles;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;       
        }
    }
    public List<Fait> bindFait(String path){
        try (BufferedReader in =  new BufferedReader(new FileReader( path ))) {
            String line;
            List<Fait> faits = new ArrayList<Fait>();
            while( ( ( line = in.readLine() ) != null ) && !( line.toLowerCase().contains( "BUT".toLowerCase() ) ) ) {
                //System.out.println( line );
                List<String> hypothesis = new ArrayList<String>();
                Fait fait = new Fait();
                if(line.contains(",")){
                    String[] pre = line.split(",");
                    for (String p: pre){
                        hypothesis.add(p);
                    }
                }
                else{
                    hypothesis.add(line);
                }
                fait.setExplication(0);
                fait.setHypothesis( hypothesis );
                faits.add( fait );
            }
            return faits;    
        } 
        catch (IOException e) {
            System.out.println("error" + e.getMessage());
            return null;
        }
    }

    public List<String> bindBut( String path){
        try (BufferedReader in =  new BufferedReader(new FileReader( path ))) {
            List<String> buts = new ArrayList<String>();
            String line;
            while( ( ( line = in.readLine() ) != null ) ){
                line = line.replace(" ", "");
                if( line.toLowerCase().contains( "BUT".toLowerCase() ) ){
                    String prebuts=line.substring(line.lastIndexOf(":") + 1);
                    if( prebuts.contains( "," ) ){
                        String[] pre = prebuts.split(",");
                        for (String p: pre){
                            buts.add(p);
                        }
                    }
                    else{
                        buts.add(prebuts);
                    }

                }
            }
            return buts;
        }
        catch (IOException e) {
            System.out.println("error" + e.getMessage());
            return null;
        }
    }
}
