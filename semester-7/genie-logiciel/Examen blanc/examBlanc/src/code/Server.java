package code;

public final class Server {
    private int _numberOfPlayers;
    private static Server _instance;

    private Server() {
        try {
            Thread.sleep(200);
        } catch (Exception ignored) {
            Thread.currentThread().interrupt();
        }
        _numberOfPlayers = 0;
    }

    public static synchronized Server getInstance() {
        if ( _instance == null ) {
            _instance = new Server();
        }
        return _instance;
    }

    public synchronized Character getNewCharacter() {
        switch (_numberOfPlayers) {
            case 0 -> {
                try {
                    Thread.sleep(200);
                } catch (Exception ignored) {
                    Thread.currentThread().interrupt();
                }
                _numberOfPlayers++;
                return new ChuckGreene(Color.YELLOW);
            }
            case 1 -> {
                try {
                    Thread.sleep(200);
                } catch (Exception ignored) {
                    Thread.currentThread().interrupt();
                }
                _numberOfPlayers++;
                return new ChuckGreene(Color.BLUE);
            }
            case 2 -> {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                _numberOfPlayers++;
                return new ChuckGreene(Color.RED);
            }
            case 3 -> {
                try {
                    Thread.sleep(200);
                } catch (Exception ignored) {
                    Thread.currentThread().interrupt();
                }
                _numberOfPlayers++;
                return new ChuckGreene(Color.GREEN);
            }
            default -> {
                System.out.println("Error: too many players");
                return null;
            }
        }
    }
}
