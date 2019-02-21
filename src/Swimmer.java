public class Swimmer {
    String name;
    float time;
    int age;
    char sex;
    String ageGroup;

    public Swimmer(String aname, float atime, int aage,String ageGroup, char asex){
        name = aname;
        time = atime;
        age =aage;
        sex =asex;
        this.ageGroup =ageGroup;
    }
    @Override
    public String toString(){
        return String.format("%-20.20s  \t\t%-20.2f \t%-20d  %-20s %c", name, time, age, ageGroup, sex);
    }
}
