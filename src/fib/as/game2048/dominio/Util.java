package fib.as.game2048.dominio;

public abstract class Util {
	/**
	 * Metodo que genera un numero random indicando un rango
	 * @param min
	 * @param max
	 * @return
	 */
	public static Integer randomInterval(Integer min, Integer max) {
		return (min + (int)(Math.random()*max));
	}
}
