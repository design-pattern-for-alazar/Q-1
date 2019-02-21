import java.util.ArrayList;
import java.util.Comparator;

/*Implements the cloneable interface so it could be cloned.
 *This class serves as a prototype.
* */
public class SwimmersData implements Cloneable{
    ArrayList<Swimmer> swimmers;
    static final String TEEN_AGE_GROUP =  "13-19";
    static final String CHILD_AGE_GROUP = "10-12";
    static final String YOUTH_AGE_GROUP = "20-27";
    static final String ADULT_AGE_GROUP = "28-55";
    static final String OLD_AGE_GROUP =   "56-70";

    public SwimmersData(){
        swimmers = new ArrayList<>();
        swimmers.add(new Swimmer("Steve", 4.12f, 21, YOUTH_AGE_GROUP, 'M'));
        swimmers.add(new Swimmer("Abel", 8.12f, 23,YOUTH_AGE_GROUP, 'M'));
        swimmers.add(new Swimmer("Man1", 1.12f, 32, ADULT_AGE_GROUP, 'M'));
        swimmers.add(new Swimmer("Woman2", 49.12f, 29, ADULT_AGE_GROUP, 'M'));
        swimmers.add(new Swimmer("Woman1", 499.12f, 16,TEEN_AGE_GROUP, 'F'));
        swimmers.add(new Swimmer("Girl1", 319.12f, 12,CHILD_AGE_GROUP, 'F'));
        swimmers.add(new Swimmer("Girl2", 119.12f, 10,CHILD_AGE_GROUP, 'F'));
        swimmers.add(new Swimmer("Old1", 219.12f, 60,OLD_AGE_GROUP, 'M'));
        swimmers.add(new Swimmer("Old2", 219.12f, 59,OLD_AGE_GROUP, 'F'));
        swimmers.sort(new Comparator<Swimmer>() {
            @Override
            public int compare(Swimmer o1, Swimmer o2) {
                return o1.ageGroup.compareTo( o2.ageGroup );
            }
        });
    }
    public void addSwimmer(Swimmer swimmer){
        swimmers.add(swimmer);
    }
    public ArrayList<Swimmer> getSwimmers(){
        return swimmers;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
