package projectpea

class Logincheck {

    String user
	String claim
	String timelogin

    static constraints = {
    	user unique: true
    }
}
