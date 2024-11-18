package esercizi.astrattismo.figureGeometriche;

public class BootStrap{
	public static void main(String[] args){
		FiguraGeometrica[] fg = new FiguraGeometrica[5];
		fg[0] = new Rettangolo(2, 3);
		fg[1] = new Isoscele(2, 3, 1);
		fg[2] = new Scaleno(2, 3, 1, 3);
		fg[3] = new Equilatero(2, 3);
		fg[4] = new Cerchio(2);
		fg[0].setNome("Rettangolo: ");
		fg[1].setNome("T Isocele: ");
		fg[2].setNome("T Scaleno: ");
		fg[3].setNome("T Equilatero: ");
		fg[4].setNome("Cerchio: ");
		for(int i=0;i<5;i++){
			System.out.println(fg[i].getNome() + "Area:" + fg[i].calcolaArea() + "Perimetro:" + fg[i].calcolaPerimetro());
		}
	}
}