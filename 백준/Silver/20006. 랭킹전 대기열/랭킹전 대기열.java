import java.io.*;
import java.util.*;

class Player {
    private int level;

    private String nickname;

    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }

    public Player() {
    }

    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}

class Room {
    private String state;

    private List<Player> players;

    public String getState() {
        return state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
public class Main {

    static int p, m;
    static List<Room> rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            Player player = new Player(l, n);
            if (!isMatch(player)) {
                Room room = new Room();
                room.setPlayers(new ArrayList<>());
                room.setState("Waiting!");

                room.getPlayers().add(player);
                if (room.getPlayers().size() == m) {
                    room.setState("Started!");
                }
                rooms.add(room);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.getState()).append("\n");
            List<Player> players = room.getPlayers();
            Collections.sort(players, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    return p1.getNickname().compareTo(p2.getNickname());
                }
            });
            for (Player player : players) {
                sb.append(player.getLevel() + " " + player.getNickname()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isMatch(Player player) {
        // if (rooms.isEmpty()) return false;

        for (Room room : rooms) {
            if (room.getState().equals("Waiting!") && Math.abs(room.getPlayers().get(0).getLevel() - player.getLevel()) <= 10) {
                room.getPlayers().add(player);
                if (room.getPlayers().size() == m) {
                    room.setState("Started!");
                }
                return true;
            }
        }

        return false;
    }
}