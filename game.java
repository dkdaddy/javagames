import java.util.*;
import java.io.*;


class GameCollection {
    public ArrayList<Game> games; 
    public int getCount() {
        return games.size();
    }
    public GameCollection() {
        games = new ArrayList<Game>();
    }
    public void addGame(Game game) {
        games.add(game);
    }
    public void sort() {
        Collections.sort(games);
    }
    public void read() {
        String filename = "games.txt";
        try {

            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println("loading " + line);
                String[] temp = line.split(":");
                addGame(new Game(temp[0], Integer.parseInt(temp[1])));
            }
        }
        catch(IOException exception)
        {
            System.out.println(exception);
        }
    }
};

class Game implements Comparable<Game> {
    private String _name;
    private int _price;
    public Game(String name, int priceInPounds) {
        _name = name;
        _price = priceInPounds;
    }
    public String getName() {
        return _name;
    }
    public int getPrice() {
        return _price;
    }
    @Override
    public int compareTo(Game g){
        if (g._price<_price)
            return 1;
        else if (g._price>_price)
            return -1;

        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        GameCollection col = new GameCollection();
        col.addGame( new Game("Mario", 12));
        col.addGame( new Game("Sonic", 19));

        int c = col.getCount();
        System.out.println("count is  " + c );

        col.read();
        System.out.println("count is now " + col.getCount() );

        for (int i=0;i<col.games.size(); i++) {
            System.out.println(col.games.get(i).getName());
        }
        col.sort();
        System.out.println("---- sorted -----");
        for (int i=0;i<col.games.size(); i++) {
            System.out.println(col.games.get(i).getName() + " " + col.games.get(i).getPrice());
        }
    }
}