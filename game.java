import java.util.*;
import java.io.*;

class GameCollection {
    public ArrayList<Game> games; 
    public int count;
    public int getCount() {
        return games.size();
    }
    public GameCollection() {
        games = new ArrayList<Game>();
    }
    public void addGame(String name) {
        games.add(new Game(name));
    }

    public void read() {
        String filename = "games.txt";
        try {

            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println("loading " + line);
                addGame(line);
            }
        }
        catch(IOException exception)
        {
            System.out.println(exception);
        }
    }
};

class Game {
    private String _name;
    public Game(String name) {
        _name = name;
    }
    public String getName() {
        return _name;
    }
}

class Main {
    public static void main(String[] args) {
        GameCollection col = new GameCollection();
        col.addGame("Mario");
        col.addGame("Sonic");

        int c = col.getCount();
        System.out.println("count is  " + c );

        col.read();
        System.out.println("count is now " + col.getCount() );

        for (int i=0;i<col.games.size(); i++) {
            System.out.println(col.games.get(i).getName());
        }
    }
}