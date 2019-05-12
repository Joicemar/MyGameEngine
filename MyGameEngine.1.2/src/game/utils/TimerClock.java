package game.utils;

public class TimerClock {

	static double timer = System.currentTimeMillis();
	static int segundos = 0;
	static int minutos = 0;
	static int horas = 0;
	private int timeEnergiaRecovery;
	private int startFrameTime = 0;
	private int stopFrameTime = 60;
	
	public static void time() {

		if (System.currentTimeMillis() - timer >= 1000) {
			// System.currentTimeMillis() Retorna a hora atual em milissegundos
			if (segundos == 60) {
				minutos++;
				segundos = 0;
			}
			if (minutos == 60) {
				horas++;
				minutos = 0;
			}
			System.out.println("tempo corrido: " + horas + " :" + minutos + " :" + segundos++);
			timer = System.currentTimeMillis();

		}
	}
 
	 /* Este método conta em segundos até o valor passado e depois volta a conta desde zero. 
	 * Serve para updates do jogo que são feitos conforme o tempo que deseja*/
	public static int countSeconds(int MaxSeconds) {
		
		if (System.currentTimeMillis() - timer >= 1000) {
			//System.currentTimeMillis() Retorna a hora atual em milissegundos
			if (segundos == MaxSeconds) {
				minutos ++;
				segundos = 0;
			}
			if ( minutos == 60) {
				horas ++;
				minutos = 0;
			}
			System.out.println("tempo corrido: " + horas + " :" + minutos + " :" + segundos++);
			timer = System.currentTimeMillis();
			
		}
		return segundos;
	}

	/*
	 * recebe o tempo que deve atualizar, e devolve o valor de (returnValue) conforme o
	 * tempo.
	 */
	public int attriutesUpdateByTime(int timeByUpdate, int returnValue) {

		TimerClock.countSeconds(timeByUpdate);
		timeEnergiaRecovery = TimerClock.countSeconds(timeByUpdate);

		if (timeEnergiaRecovery >= timeByUpdate) {
			startFrameTime++;
			if (startFrameTime >= stopFrameTime) {

				startFrameTime = 0;
				return returnValue;
			}
		}
		return 0;
	}

}
