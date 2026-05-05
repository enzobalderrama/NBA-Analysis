import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // 1. Load the list from the CSV
        List<NBAPlayer> loadedList = loadPlayers("all_seasons.csv");

        // 2. Create your NBA object and add the players to it
        NBA seasonData = new NBA();
        for (NBAPlayer p : loadedList) {
            seasonData.add(p);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the NBA! Choose what you want to do: ");
        while (true) {
            System.out.println("1) Sort by points");
            System.out.println("2) Find the youngest Player");
            System.out.println("3) Find the top college");
            System.out.println("4) Find a player off of name");
            System.out.println("5) Exit.");
            int answer = scan.nextInt();
            if (answer == 1){
                seasonData.pointsSort();
                System.out.println("It is sorted!");
            }
            if (answer == 2){
                System.out.println("The youngest player is: " + seasonData.minAge());
            }
            if (answer == 3){
                System.out.println("The top college is: " + seasonData.findbstCollege());
            }
            if (answer == 4){
                System.out.println("What player are you looking for?");
                scan.nextLine();
                String player = scan.nextLine();
                System.out.println("Is your player in the seasons? The answer is: " + seasonData.find(player));
            }
            if (answer == 5){
                System.out.println("OK! Thanks for playing!");
                break;
            }
            System.out.println("Go Again!");
        }
    }

    public static List<NBAPlayer> loadPlayers(String csvFile) {
        List<NBAPlayer> players = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split by comma
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Map CSV index to Constructor
                // index, player_name, team_abbreviation, age, player_height,
                // player_weight, college, gp, pts, reb, ast

                int index = Integer.parseInt(data[0]);
                String p = data[1];
                String t = data[2];
                int a = Integer.parseInt(data[3]);
                double h = Double.parseDouble(data[4]);
                double w = Double.parseDouble(data[5]);
                String c = data[6];
                int g = Integer.parseInt(data[7]);
                double pt = Double.parseDouble(data[8]);
                double r = Double.parseDouble(data[9]);
                double as = Double.parseDouble(data[10]);

                // Match constructor order:
                // (String p, int i, int a, String t, double h, double w, String c, int g, double pt, double r, double as)
                players.add(new NBAPlayer(p, index, a, t, h, w, c, g, pt, r, as));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}