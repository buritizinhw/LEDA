package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

	public double raiz(int numero, int raiz, double erro) {
		double low = 0;
        double high = numero;
        return raizRecursivo(numero, raiz, erro, low, high);
    }

    private double raizRecursivo(int numero, int raiz, double erro, double low, double high) {
        double mid = (low + high) / 2;
        double approx = approximate(mid, raiz);

        if (Math.abs(approx - numero) <= erro) {
            return mid;
        }

        
        if (approx < numero) {
            return raizRecursivo(numero, raiz, erro, mid, high);
        } else {
            return raizRecursivo(numero, raiz, erro, low, mid);
        }
    }


    private double approximate(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

}