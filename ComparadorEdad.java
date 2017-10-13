import java.util.Comparator;

public class ComparadorEdad implements Comparator<Paciente> {

	@Override
	public int compare(Paciente o, Paciente o2) {
		
		int res=0;
		
		if(o.getEdad()>o2.getEdad()) res=1;
		else if (o2.getEdad()<o.getEdad())res=-1;
		
		return res;
	}

}
