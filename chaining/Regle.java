package javacode.chaining;
import java.util.List;
import java.lang.StringBuilder;

public class Regle{
  private List<String> premisses;
  private List<String> conclusions;
  private int numero;

  public List<String> getPremisses(){
    return this.premisses;
  }
  public List<String> getConclusions(){
    return this.conclusions;
  }
  public int getNumero(){
    return this.numero;
  }

  public void setPremisses (List<String> premisses){
    this.premisses = premisses;
  }


  public void setConclusions (List<String> conclusions){
    this.conclusions = conclusions;
  }

  public void setNumero (int numero){
    this.numero = numero;
  }
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder(1000);
    return sb.append("Regle {\n numero : ").append(this.getNumero())
          .append(" \n premisses : ").append(this.getPremisses())
          .append("\n conclusions : ").append(this.getConclusions())
          .append("\n}")
          .toString();
  }
}
