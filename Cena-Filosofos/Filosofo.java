public class Filosofo extends Thread {
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;

    public Filosofo(Mesa m, int comensal) {
        this.mesa = m;
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
    }

    @Override
    public void run() {
        /* ¿Tiene aspecto de patrón? */
        while (true) {
            this.pensando();
            this.mesa.cogerTenedores(indiceComensal);
            int indiceVino = this.mesa.cogerVino();
            this.comiendo();
            this.bebiendo();

            System.out.println("Filosofo->" + comensal + " deja de comer, tenedores libres "
                    + (this.mesa.tenedorIzquierda(this.indiceComensal) + 1) + ", "
                    + (this.mesa.tenedorDerecha(this.indiceComensal) + 1) + " .\n " + comensal
                    + " deja de beber , vino libre  " + indiceVino);
            this.mesa.dejarVino(indiceVino);

            this.mesa.dejarTenedores(this.indiceComensal);

        }

    }

    public void comiendo() {
        System.out.println("Filósofo->" + comensal + " esta Comiendo. ");
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pensando() {

        System.out.println("Filosofo->" + comensal + " Pensando. ");
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void bebiendo() {

        System.out.println("Filosofo->" + comensal + " Bebiendo. ");
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
