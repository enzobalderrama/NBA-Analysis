public class NBAPlayer {
    private String player;
    private int index;
    private int age;
    private String team;
    private double height;
    private double weight;
    private String college;
    private int gamesp;
    private double pts;
    private double reb;
    private double asts;

    public NBAPlayer(String p, int i, int a, String t, double h, double w, String c, int g, double pt, double r, double as){
        player = p;
        index = i;
        age = a;
        team = t;
        height = h;
        weight = w;
        college = c;
        gamesp = g;
        pts = pt;
        reb = r;
        asts = as;
    }

    public int getAge() {
        return age;
    }

    public String getPlayer() {
        return player;
    }

    public int getIndex() {
        return index;
    }

    public String getTeam() {
        return team;
    }

    public double getAsts() {
        return asts;
    }

    public double getHeight() {
        return height;
    }

    public double getPts() {
        return pts;
    }

    public double getReb() {
        return reb;
    }

    public double getWeight() {
        return weight;
    }

    public int getGamesp() {
        return gamesp;
    }

    public String getCollege() {
        return college;
    }

    public void setAsts(double asts) {
        this.asts = asts;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setGamesp(int gamesp) {
        this.gamesp = gamesp;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPts(double pts) {
        this.pts = pts;
    }

    public void setReb(double reb) {
        this.reb = reb;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
