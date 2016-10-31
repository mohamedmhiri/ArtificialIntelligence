package javacode.chaining;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;


public class ForwardChaining{

    private Util util = new Util();

    /**
     * returns all releasable rules
     * @param regles
     * @param hypothesis
     * @return List<Regle>
     */
    public List<Regle> releasableRules(List<Regle> rules, List<String> hypothesis){
        List<Regle> tmpSet = new ArrayList<Regle>();
        for(Iterator<Regle> i = rules.iterator(); i.hasNext(); ) {
            Regle rule = i.next();
            if(util.allExists(rule.getPremisses(), hypothesis) == true)
                tmpSet.add(rule);
        }
        return tmpSet;
    }
    public Regle chosen (String choice, List<Regle> tmpRules, Fait fait){

        Regle rule = new Regle();
        //fifo
        if(choice.equals("1")){
            rule = tmpRules.get(0);
        }else{
            int max = 0, index = -1;
            for(int i =0; i<tmpRules.size(); i++){
                for(int j = 0; j< tmpRules.get(i).getConclusions().size(); j++){
                    if((tmpRules.get(i).getPremisses().size() > max) && (!fait.getHypothesis().contains("non" + tmpRules.get(i).getConclusions().get(j) ))){
                        max = tmpRules.get(i).getPremisses().size();
                        index = i;
                    }
                }

            }
            rule = tmpRules.get(index);
        }
        return rule;
    }
/*
    //add rule.getConclusions() to hypothesis
    //test before that !concl is not in hypothesis and that concl is not in hypothesis
    */

    /**
     * returns weather ForwardChaining is succesful or not
     * @param rules
     * @param faits
     * @param buts
     * @return boolean
     */
    public boolean verify(List<String> buts, List<Regle>rules,Fait fait, String choice){


        boolean res = false;
        List<Regle> tmpRules ;
        List<Regle> _rules = new ArrayList<Regle>();
        tmpRules = this.releasableRules(rules, fait.getHypothesis());
        while((tmpRules.size() != 0)) {
            int l = 0;
            while((l < tmpRules.size()) && (util.allExists(buts, fait.getHypothesis()) == false)){
                Regle rule = this.chosen(choice, tmpRules.subList(l,tmpRules.size()), fait);
                List<String> concls = rule.getConclusions();
                for (int j = 0; j < concls.size(); j++) {
                    if (!fait.getHypothesis().contains(concls.get(j))) {
                        fait.getHypothesis().add(concls.get(j));
                    }
                }
                System.out.println("RULE        :\n"+rule);
                l++;
            }
            System.out.println("     HYPOTHESIS        \n"+fait.getHypothesis());
            for (int t = 0; t < tmpRules.size(); t++)
                _rules = util.delRegle(rules, tmpRules.get(t));
            tmpRules=this.releasableRules(_rules, fait.getHypothesis());

        }
        if(util.allExists(buts, fait.getHypothesis()) == true)
            return true;
        else
            return false;

    }

}


