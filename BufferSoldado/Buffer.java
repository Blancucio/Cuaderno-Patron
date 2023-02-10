public class Buffer {
    // MENSAJE TIPO CADENA QUE COMPARTEN LOS HILOS
    private String packet;
    //private Cerveza cerveza;
   
    private boolean puedoEnviar = true;

    public synchronized void sender(String packet) {
        while (!puedoEnviar) { //false false
            try {
                wait(); // alguien está recibiendo el mensaje
                //System.out.println("Espera, alguien está pidiendo una cerveza");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Soy el " + packet + " y quiero una cerveza.");
        // EN CASO DE QUE PUEDA ENVIAR
        puedoEnviar = false;
        this.packet = packet;
        //this.cerveza.setQuienMepide(nombre);
        notifyAll();
    }

    public synchronized String receive() {
        while (puedoEnviar) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        puedoEnviar = true;
        String returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}
