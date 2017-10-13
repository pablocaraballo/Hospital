import java.util.Collections;
import java.util.Scanner;

public class ListadosPacientes {
	
		//BUSCA UN PACIENTE POR SU NOMBRE, SUS APELLIDOS o SI DNI
		public static void buscaNomDni(){
		
			String dato;
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce el nombre, el apellido o el dni del paciente para buscarlo:");
			dato=sc.nextLine();
		
			for(int i=0; i<Paciente.pacientes.size(); i++){
		
				if(dato.equals(Paciente.pacientes.get(i).getNom()) || Paciente.pacientes.get(i).getApe().contains(dato) || dato.equals(Paciente.pacientes.get(i).getDni())){
			
					System.out.println(Paciente.pacientes.get(i).toString2());
					break;
				}
			}
		}
		
		//Muestra pacientes entre un rango de edad ordenados de menor a mayor
		public static void comparaEdad(){
			
			int edad1;
			int edad2;
			Scanner sc=new Scanner(System.in);
			
			System.out.println("####Buscador con rango de edades####");
			System.out.println("Introduce la edad donde se inicia el rango: ");
			edad1=sc.nextInt();
			System.out.println("Introduce la edad donde finaliza el rango: ");
			edad2=sc.nextInt();
			
			//ORDENA POR EDADES
			ComparadorEdad edades=new ComparadorEdad();
			Collections.sort(Paciente.pacientes,edades);
			
			for(int i=0; i<Paciente.pacientes.size(); i++){
				
				if(Paciente.pacientes.get(i).getEdad()>=edad1 && Paciente.pacientes.get(i).getEdad()<=edad2){
				
					System.out.println(Paciente.pacientes.get(i).toString2());
					System.out.println("*********************************************");
				}
			}
		}
		
		//SACA TODOS LOS PACIENTES CON EL APELLIDO INDICADO ORDENADOS ALFABETICAMENTE
		public static void comparaApellido(){
			
			String ape;
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce el apellido que quieres buscar:");
			ape=sc.nextLine();
			
			ComparadorApellidos apellidos=new ComparadorApellidos();
			Collections.sort(Paciente.pacientes, apellidos);
			
			for(int i=0; i<Paciente.pacientes.size(); i++){
				
				if(Paciente.pacientes.get(i).getApe().contains(ape)){
					
					System.out.println(Paciente.pacientes.get(i).toString2());
					System.out.println("*********************************************");
				}
			}
		}
		
		//MUESTRA TODOS LOS PESOS HASTA EL INDICADO
		public static void muestraPeso(){
			
			float peso;
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce un peso:");
			peso=sc.nextFloat();
			
			for(int i=0; i<Paciente.pacientes.size(); i++){
				
				if(Paciente.pacientes.get(i).getPeso()<=peso){
					
					System.out.println(Paciente.pacientes.get(i).toString2());
					System.out.println("*********************************************");
				}
			}
		}
		
		//MUESTRA TODOS LOS ALTURA HASTA EL INDICADO
		public static void muestraAltura(){
					
			int altura;
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce la altura:");
			altura=sc.nextInt();
					
			for(int i=0; i<Paciente.pacientes.size(); i++){
						
				if(Paciente.pacientes.get(i).getAltura()<=altura){
							
					System.out.println(Paciente.pacientes.get(i).toString2());
					System.out.println("*********************************************");
				}
			}
		}
		
		//ENCUENTRA TODOS LOS TELEFONOS QUE ACABAN POR LOS TRES NUMEROS DADOS
		public static void numsTlf(){
			
			String num;
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce los tres ultimos numeros de telefono:");
			num=sc.nextLine();
			
			for(int i=0; i<Paciente.pacientes.size(); i++){
				
				if(Paciente.pacientes.get(i).getTlf().endsWith(num)){
					
					System.out.println(Paciente.pacientes.get(i).toString());
				}
			}
		}
		
		//MUESTRA LOS PACIENTES QUE ESTAN EN LA LISTA DE ESPERA
		public static void listaEspera(){
			
			System.out.println("#####LISTA DE ESPERA#####");
			
			for(int i=0; i<Paciente.espera.size(); i++){
				
				System.out.println(Paciente.espera.get(i));
				System.out.println("*********************************************");
			}
			System.out.println("#########################");
		}
}
