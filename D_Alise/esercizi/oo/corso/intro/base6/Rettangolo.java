package esercizi.oo.corso.intro.base6;
public class Rettangolo{
    private int altezza;
    private int lunghezza;

    public Rettangolo(int altezza,int lunghezza){
        this.altezza = altezza;
        this.lunghezza = lunghezza;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){ 
        	return true;
        }	
        if (!(obj instanceof Rettangolo)){
            return false;
        }    
        Rettangolo rettangolo3 = (Rettangolo) obj;
        return this.altezza== rettangolo3.altezza && this.lunghezza == rettangolo3.lunghezza;    
    }    

    public double calcolaPerimetro(){
        double perimetro = (altezza + lunghezza)*2;
        return perimetro;
    }
    public double calcolaArea(){
        double area = altezza * lunghezza;
        return area;
    }

}