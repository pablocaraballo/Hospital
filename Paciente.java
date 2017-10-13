import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Paciente extends Persona {
	
	private int altura=0;
	private float peso=0;
	private String tlf;
	private String dni;
	static DateFormat f1= new SimpleDateFormat("dd/MM/yyyy");
	static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
	static ArrayList<Paciente> archivados=new ArrayList<Paciente>();
	static ArrayList<Paciente> espera=new ArrayList<Paciente>();
	
	public Paciente(){
		
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Paciente(String dni, String nom, String ape, Date nacimiento, Genero sexo, String tlf, float peso, int altura){
		
		this.dni=dni;
		this.setNom(nom);
		this.setApe(ape);
		try {
			this.setNacimiento(nacimiento);
		} catch (PersonaNotBornException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSexo(sexo);
		this.setTlf(tlf);
		this.setPeso(peso);
		this.setAltura(altura);
	}
	
	public String toString() {
		return this.getDni()+" "+this.getNom()+" "+this.getApe()+" "+this.getEdad()+" "+this.getTlf()+" "+this.getPeso()+" "+this.getAltura();
	}
	
	public String toString2() {
		return "DNI: "+this.getDni()+"\n"+"Paciente: "+this.getNom()+" "+this.getApe()+"\n"+"Edad: "+this.getEdad()+"\n"+"Telefono: "+this.getTlf()+"\n"+"Peso: "+this.getPeso()+"\n"+"Altura: "+this.getAltura();
	}
	
	static public void cargaPacientes() throws IOException, NumberFormatException, ParseException{
		
		BufferedReader br=new BufferedReader(new FileReader("/home/tarda/pacientes.txt"));
		String linea=br.readLine();
			
		//Cargamos los pacientes del archivo al ArrayList
		while(linea!=null){
				
			StringTokenizer token=new StringTokenizer(linea, ",");
				
			while(token.hasMoreTokens()){
					
				Paciente p1= new Paciente(token.nextToken(),token.nextToken(),token.nextToken(),f1.parse(token.nextToken()),Genero.valueOf(token.nextToken()),token.nextToken(),Float.parseFloat(token.nextToken()),Integer.parseInt(token.nextToken()));
				
				if(comparaPacientes(p1)==true){
					
					System.out.println("El paciente "+p1.getNom()+" con dni "+p1.getDni()+" no ha sido introducido ya que su dni coincide con el de otro paciente");
					
				}
				else {
					pacientes.add(p1);
				}
			}
			linea=br.readLine();
		}
		
		//Muestra todos los pacientes cargados por pantalla.	
		for(int i=0; i<pacientes.size(); i++){
				
			System.out.println(pacientes.get(i).getApe());
		}
	}
	
	//Método que compara si hay 2 pacientes con el mismo dni
	static public boolean comparaPacientes(Paciente p1){
		
		boolean repe=false;
		
		for(int i=0; i<pacientes.size(); i++){
			
			if(pacientes.get(i).getDni().equals(p1.getDni())){
				
				repe=true;
				break;
			}
		}
		return repe;
	}
	
	//Metodo para crear un nuevo Paciente
	static public void introPacientes() throws ParseException{
		
		Scanner sc= new Scanner (System.in);
		Paciente p1=new Paciente();
		
		System.out.println("Introduce el dni del paciente:");
		p1.setDni(sc.nextLine());
		
		//Compara si el dni del nuevo paciente existe en la base de datos.
		for(int i=0; i<pacientes.size(); i++){
			
			if(pacientes.get(i).getDni().equals(p1.getDni())){
				
				System.out.println("El dni "+p1.getDni()+" ya consta en nuestra base de datos. Vuelva a intentarlo.");
				introPacientes();
			}
		}
		
		
		System.out.println("Introduce el nombre del paciente:");
		p1.setNom(sc.nextLine());
		
		System.out.println("Introduce el apellido del paciente:");
		p1.setApe(sc.nextLine());
		
		System.out.println("Introduce la fecha de nacimiento del paciente:");
		try {
			p1.setNacimiento(f1.parse(sc.nextLine()));
		} catch (PersonaNotBornException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Introduce el sexo del paciente:");
		p1.setSexo(Genero.valueOf(sc.nextLine()));
		
		System.out.println("Introduce el telefono del paciente:");
		p1.setTlf(sc.nextLine());
		
		System.out.println("Introduce el peso del paciente:");
		p1.setPeso(sc.nextFloat());
		sc.nextLine();
		
		System.out.println("Introduce la altura del paciente:");
		p1.setAltura(sc.nextInt());
		sc.nextLine();
		
		pacientes.add(p1);
		
		
		for(int i=0; i<pacientes.size(); i++){
			
			System.out.println(pacientes.get(i).getApe());
		}
	}
	
	//Metodo para archivar un paciente 
	public static void archivarPacientes(){
		
		String dni;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el dni del paciente que se va archivar:");
		dni=sc.nextLine();
		
		for(int i=0; i<pacientes.size(); i++){
			
			if(dni.equals(pacientes.get(i).getDni())){
				archivados.add(pacientes.get(i));
				System.out.println("El paciente con el dni "+pacientes.get(i).getDni()+" ha sido archivado.");
				pacientes.remove(pacientes.get(i));
			}
		}
	}
	
	//Metodo que borra un paciente de la base de datos
	public static void borrarPaciente(){
		
		String dni;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el dni del paciente que quieres :");
		dni=sc.nextLine();
		
		//Buscamos entre todos los pacientes
		for(int i=0; i<pacientes.size(); i++){
			
			if(dni.equals(pacientes.get(i).getDni())){
				System.out.println("El paciente con el dni "+pacientes.get(i).getDni()+" ha sido borrado.");
				pacientes.remove(pacientes.get(i));
			}
		}
		
		//Buscamos entre todos los pacientes archivados
		for(int i=0; i<archivados.size(); i++){
			
			if(dni.equals(archivados.get(i).getDni())){
				System.out.println("El paciente con el dni "+archivados.get(i).getDni()+" ha sido borrado.");
				archivados.remove(archivados.get(i));
			}
		}
	}
	
	//Metodo que muestra a un paciente seleccionado
	public static void muestraPaciente(){
		
		String dni;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el dni del paciente que quieres mostrar:");
		dni=sc.nextLine();
		
		for(int i=0; i<pacientes.size(); i++){
			
			if(dni.equals(pacientes.get(i).getDni())){
				System.out.println(pacientes.get(i).toString2());
			}
		}
	}
	
	//Metodo que pasa un paciente a la lista de espera
	public static void listaEspera(){
		
		String dni;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el dni del paciente que va a pasar a la lista de espera:");
		dni=sc.nextLine();
		
		for(int i=0; i<pacientes.size(); i++){
			
			if(dni.equals(pacientes.get(i).getDni())){
				espera.add(pacientes.get(i));
				System.out.println("El paciente con el dni "+pacientes.get(i).getDni()+" ha pasado a la lista de espera para operarse.");
				pacientes.remove(pacientes.get(i));
			}
		}
	}
	
	//Metodo que pasa a un paciente de la lista de espera a operarse
	public static void operacion(){
		
		String dni;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el dni del paciente que se va a operar ya:");
		dni=sc.nextLine();
		
		for(int i=0; i<espera.size(); i++){
			
			if(dni.equals(espera.get(i).getDni())){
				espera.remove(pacientes.get(i));
				System.out.println("El paciente con el dni "+espera.get(i).getDni()+" ha pasado a quirofano.");
			}
		}
	}
	
	
	
	
	

}
