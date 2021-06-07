import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Main {
	
	
	public static void main(String[] args) {
		EntityManagerFactory e =  Persistence.createEntityManagerFactory("loto") ;
		EntityManager en = e.createEntityManager();
		BetModel d = en.find(BetModel.class, 209);
		System.out.println(d.getName());
		System.out.println(d.getContent());
	}
}
