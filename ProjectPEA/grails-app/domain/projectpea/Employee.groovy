package projectpea

class Employee {

	String emid
	String passwords
	String nameem
	String numpeople

	String position
	String claim

	String address
	String tel

	String cedit
	String editin
	

    static constraints = {
    	emid unique: true
    }
}
