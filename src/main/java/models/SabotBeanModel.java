package models;

public class SabotBeanModel {
    
    private int idNumber;
    private boolean etatSabot;
    private int etatBatterie;
   
    public SabotBeanModel(int idNumber,boolean etatSabot,int etatBatterie ){

      this.idNumber=idNumber;
      this.etatSabot=etatSabot;
      this.etatBatterie=etatBatterie;
     }

    public int getIdNumber() {
      return this.idNumber;
    }
    public void setIdNumber(int value) {
      this.idNumber = value;
    }

    public boolean getEtatSabot() {
      return this.etatSabot;
    }
    public void setEtatSabot(boolean value) {
      this.etatSabot = value;
    }

    public int getEtatBatterie() {
      return this.etatBatterie;
    }
    public void setEtatBatterie(int value) {
      this.etatBatterie = value;
    }

}
