import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuHospital {
	
	public static void menu() throws NumberFormatException, IOException, ParseException{
		
		int op,opcion, op2;
		Scanner sc= new Scanner(System.in);
		
				
		do{
			op=menu1(sc);
			
			switch(op){
			case 1: Paciente.cargaPacientes(); break;
			case 2: Paciente.introPacientes(); break;
			case 3: Paciente.archivarPacientes(); break;
			case 4: Paciente.borrarPaciente(); break;
			case 5: Paciente.muestraPaciente(); break;
			case 6: Paciente.listaEspera(); break;
			case 7: Paciente.operacion(); break;
			case 8: do{
				
				opcion=menulistados(sc);
				switch(opcion){
				case 1: ListadosPacientes.buscaNomDni(); break;
				case 2: ListadosPacientes.comparaEdad(); break;
				case 3: ListadosPacientes.comparaApellido(); break;
				case 4: ListadosPacientes.muestraPeso(); break;
				case 5: ListadosPacientes.muestraAltura(); break;
				case 6: ListadosPacientes.numsTlf(); break;
				case 7: ListadosPacientes.listaEspera(); break;
				case 0: break;
				default: break;
				}
				
			}while(opcion!=0);
			break;
			case 9:do{
				
				op2=menuEstadisticas(sc);
				
				switch(op2){
				
				case 1: Estadisticas.frecuency_edad_peso_altura(); break;
				case 2: break;
				case 3:Estadisticas.CuantListEsp(); break;
				
				}
				
			}while(op2!=0);
				
				break;
			case 0: System.out.println("Gracias por usar este Software, hasta pronto.");break;
			default:  break;
			}
			
		}while(op!=0);
		
	}
		
	public static int menu1(Scanner sc){
		int op=0;
		
		System.out.println("**************MENU HOSPITAL**************");
		System.out.println("1. Cargar Pacientes");
		System.out.println("2. Nuevo paciente");
		System.out.println("3. Archivar paciente");
		System.out.println("4. Borrar paciente");
		System.out.println("5. Ver paciente");
		System.out.println("6. Añadir paciente a la lista de espera para operarse");
		System.out.println("7. Envia paciente a operar");
		System.out.println("8. Listados");
		System.out.println("9. Estadisticas");
		System.out.println("0. Salir");
		System.out.println("*****************************************");
		System.out.print("Elige una opcion:");
		op=sc.nextInt();
		
		return op;
	}
	
	public static int menulistados(Scanner sc){
		
		int opcion=0;
		
		System.out.println("**************MENU LISTADOS**************");
		System.out.println("1. Buscar paciente");
		System.out.println("2. Listar pacientes entre rango de edades");
		System.out.println("3. Listar pacientes por apellido");
		System.out.println("4. Listar pacientes por peso");
		System.out.println("5. Listar pacientes por altura");
		System.out.println("6. Listar por los tres ultimos numeros de tlf");
		System.out.println("7. Lista pacientes que esperan para operarse");
		System.out.println("0. Salir");
		System.out.println("*****************************************");
		System.out.print("Elige una opcion:");
		opcion=sc.nextInt();
		
		return opcion;
	}
	
	public static int menuEstadisticas(Scanner sc){
		
		int op2=0;
		
		System.out.println("**************MENU ESTADISTICAS**************");
		System.out.println("1. Estadistica por edad, peso y altura");
		System.out.println("2. Frecuencia por rango");
		System.out.println("3. Cantidad de pacientes en lista de espera");
		System.out.println("*****************************************");
		System.out.print("Elige una opcion:");
		op2=sc.nextInt();
		return op2;
	}

}




