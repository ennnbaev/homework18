public class Main {
    public static void main(String[] args) {
        LogicOfGame simulations = new LogicOfGame(15, 10);
        simulations.setLive(1, 1);
        simulations.setLive(2, 2);
        simulations.setLive(3, 0);
        simulations.setLive(3, 1);
        simulations.setLive(3, 2);
        for (int i = 0; i < 20; i++) {
            simulations.printBoard();
            simulations.act();
        }
    }
}
