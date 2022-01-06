package gui;

/**
 *
 * @author Scott
 */
import java.util.ArrayList;
import java.util.List;

// implementing Comparable for sorting.. Not actually needed for the sort we have been asked for,
//But I have done it jsut to show how. 
public class Person implements Comparable<Person>   {

	// Variables 
	 private String name;
	 private String gender;
	 private String alive;
	 private String trait;
	 private List<Edge> connection;
	
	//constructor 
	 public Person (String name, String gender,String alive, String trait,
                 List<Edge> connection) {
		 
		 connection = new ArrayList<>();
                 this.name = name;
                 this.gender = gender;
                 this.alive = alive;
                 this.trait = trait;
		 this.connection = connection;

			
		}
	
	 // Getters
	 public String getName() {
	        return name;
	    }

	 public String getGender() {
	        return gender;
	    }
	 
	 public String getAlive() {
	        return alive;
	    }
	 public String getrait() {
	        return trait;
	    }

	 public List<Edge> getConnection() {
	        return connection;
	    }

        public void setName(String name) {
        this.name = name;
            }

         public void setGender(String gender) {
         this.gender = gender;
            }

        public void setAlive(String alive) {
        this.alive = alive;
            }

        public void setTrait(String trait) {
        this.trait = trait;
            }

        public void setConnection(List<Edge> connection) {
        this.connection = connection;
            }
         
         
// Compare method for sorting list 	 
	 @Override
		public int compareTo(Person nIn) {
			
			return name.compareTo(nIn.name);
		}
	 
}