package patron_adapter;

public class PATRON_ADAPTER {

    public static void main(String[] args) {
        Conectable lampara = new Lampara();
        Conectable ordenador = new Ordenador();
        encenderAparato(lampara);
        lampara.encender();
        System.out.println("esta encendidaa: " + lampara.isEncendida());

    }

    private static void encenderAparato(Conectable l1) {
        l1.encender();
        System.out.println(l1.isEncendida());
    }

}
