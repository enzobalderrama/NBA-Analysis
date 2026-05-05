import java.util.ArrayList;
import java.util.Collections;

public class NBA {
    private ArrayList<NBAPlayer> NBA;
    public NBA(){
        NBA = new ArrayList<NBAPlayer>();
    }
    public void add(NBAPlayer n){
        NBA.add(n);
    }
    public int minAge(){
        int min = -1;
        for (int i = 0; i < NBA.size(); i++){
            if (min == -1 || NBA.get(i).getAge() < min){
                min = NBA.get(i).getAge();
            }
        }
        return min;
    }
    public boolean find(String n){
        for (int i = 0; i < NBA.size(); i++){
            if (NBA.get(i).getPlayer().contains(n)){
                return true;
            }
        }
        return false;
    }

    public void pointsSort(){
        for (int i = 0; i < NBA.size() - 1; i++) {
            for (int j = 0; j < NBA.size() - i - 1; j++) {
                if (NBA.get(j).getPts() < NBA.get(j + 1).getPts()) {
                    NBAPlayer temp = NBA.get(j);
                    NBA.set(j, NBA.get(j + 1));
                    NBA.set(j + 1, temp);
                }
            }
        }
    }

    public String findbstCollege() {
        if (NBA.isEmpty()){
            return "No data";
        }
        ArrayList<String> uniqueColleges = new ArrayList<>();
        for (NBAPlayer p : NBA) {
            if (!uniqueColleges.contains(p.getCollege())) {
                uniqueColleges.add(p.getCollege());
            }
        }
        double maxAvg = -1;
        String bestCollege = "";
        for (String college : uniqueColleges) {
            double totalPoints = 0;
            int count = 0;
            for (NBAPlayer p : NBA) {
                if (p.getCollege().equals(college)) {
                    totalPoints += p.getPts();
                    count++;
                }
            }
            double avg = totalPoints / count;
            if (avg > maxAvg) {
                maxAvg = avg;
                bestCollege = college;
            }
        }
        return bestCollege;
    }
}

