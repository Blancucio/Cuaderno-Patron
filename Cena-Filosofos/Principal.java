public class Principal {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(5,2);
        for (int i = 1; i <= 5; i++) {
            Filosofo f = new Filosofo(mesa, i);
            f.start();
        }
    }
}
