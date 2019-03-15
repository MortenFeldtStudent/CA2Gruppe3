package generator;

/**
 * @author Morten
 */
public class HobbyPersonTestData {

    private int hobby_id;
    private int person_id;

    public HobbyPersonTestData(int hobby_id, int person_id) {
        this.hobby_id = hobby_id;
        this.person_id = person_id;
    }

    public int getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(int hobby_id) {
        this.hobby_id = hobby_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

}
