import java.text.ParseException;
import java.util.Scanner;


public class PruebaException {
	

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		Paciente p1=new Paciente();
		
		
	try{
		System.out.println("Introduce el nombre del paciente:");
		p1.setNom(sc.nextLine());
		
		System.out.println("Introduce el apellido del paciente:");
		p1.setApe(sc.nextLine());
		
		System.out.println("Introduce la fecha de nacimiento del paciente:");
		p1.setNacimiento(Paciente.f1.parse(sc.nextLine()));
		
		System.out.println("Introduce el sexo del paciente:");
		sc.nextLine();
		
		System.out.println("Introduce el telefono del paciente:");
		p1.setTlf(sc.nextLine());
		
		System.out.println("Introduce el peso del paciente:");
		p1.setPeso(sc.nextFloat());
		sc.nextLine();
		
		System.out.println("Introduce la altura del paciente:");
		p1.setAltura(sc.nextInt());
		sc.nextLine();
		
		
		//p1.setNacimiento(Paciente.f1.parse("12/02/2020"));
	}catch(PersonaNotBornException e){
		e.printStackTrace();
	}

}
}
