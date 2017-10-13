import java.util.Comparator;

public class ComparadorApellidos implements Comparator<Paciente> {

	//Comparamos las Strings con el CompareTO
	public int compare(Paciente o1, Paciente o2) {
		
		if(o1.getApe().compareTo(o2.getApe())>0) return 1;
		else if(o1.getApe().compareTo(o2.getApe())<0) return -1;
		
		return 0;
	}

}
