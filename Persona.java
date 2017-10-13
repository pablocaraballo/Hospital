import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Persona {
	
	private String nom;
	private String ape;
	private Date nacimiento=new Date();
	private Genero sexo;
	private int edad;
	
	public int getEdad(){
		return Persona.calcularEdad(this.nacimiento);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getApe() {
		return ape;
	}

	public void setApe(String ape) {
		this.ape = ape;
	}


	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) throws PersonaNotBornException {
		
		Date today=new Date();
		
		if(nacimiento.after(today)){
			
			throw new PersonaNotBornException("La fecha introducida no puede ser igual o mayor que la fecha actual"); 
			
		}
		this.nacimiento = nacimiento;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}


	public enum Genero{
		
		HOMBRE,MUJER
		
	}
	
	private static int calcularEdad(Date nacimiento) {
		
	   Calendar today = Calendar.getInstance();
	   Calendar Temp=new GregorianCalendar();
	   Temp.setTime(nacimiento);
	
	   int diffYear = today.get(Calendar.YEAR) - Temp.get(Calendar.YEAR);
		
	   int diffMonth = today.get(Calendar.MONTH) - Temp.get(Calendar.MONTH);
		
	   int diffDay = today.get(Calendar.DAY_OF_MONTH) - Temp.get(Calendar.DAY_OF_MONTH);
		
	   // Si está en ese año pero todavía no los ha cumplido
		
	   if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
		
	   diffYear = diffYear - 1; 
	   }
		
	return diffYear;
			        
	}
	

}
