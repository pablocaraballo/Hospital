import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Estadisticas {
	
	//CALCULA LA FRECUENCIA DE LAS EDADES PESO Y ALTURA DE TODOS LOS PACIENTES
	public static void frecuency_edad_peso_altura(){
		
		//int total=Paciente.pacientes.size();
		ArrayList<Integer> cantedad=new ArrayList<Integer>();
		
		for(int i=0; i<Paciente.pacientes.size(); i++){
			
			cantedad.add(Paciente.pacientes.get(i).getEdad());
			
			int freq=Collections.frequency(cantedad, Paciente.pacientes.get(i).getEdad());
			
			//HashMap<Integer, Integer> dictionary = new HashMap<cantedad, feq>();
			System.out.println(cantedad.get(i)+" : "+freq);
			
		}
	}
	
	//CALCULA LA FRECUENCIA ENTRE RANGOS DE EDAD, PESO O ALTURA DE LOS PACIENTES
	public static void frecuency_rangos(){
		
		
		
	}
	
	//CANTIDAD DE PACIENTES EN LISTA DE ESPERA
	public static void CuantListEsp(){
		
		System.out.println("Numero de pacientes en lista de espera: "+Paciente.espera.size());
	}

}
