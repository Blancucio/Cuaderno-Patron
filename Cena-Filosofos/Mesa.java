import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
    private boolean[] tenedores;
    private boolean[] vino;

    public Mesa(int numTenedores, int numVino) {
        this.tenedores = new boolean[numTenedores];
        this.vino = new boolean[numVino];
        this.vino[0] = false;
        this.vino[1] = false;
    }

    public int tenedorIzquierda(int indiceComensal) {
        return indiceComensal;
    }

    public int tenedorDerecha(int indiceComensal) {
        if (indiceComensal == 0) {
            return this.tenedores.length - 1;
        } else {
            return indiceComensal - 1;
        }
    }

    public synchronized int cogerVino() {
        boolean vino1 = vino[0]; // 1ª jarra
        boolean vino2 = vino[1]; // 2ª jarra

        while (vino1 && vino2) { // true true
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // por huevsss, hay una a false
        // VINO LIBRE
        if (vino1 == false) {
            vino[0] = true;
            return 0;
        } else {
            vino[1] = true;
            return 1;
        }
    }

    public synchronized void dejarVino(int indiceVino) {

        if (indiceVino == 0) { // ¿cuál es la que he cogido? // No sé cuál he cogido
            vino[0] = false;
        } else {
            vino[1] = false;
        }
        notifyAll();
    }

    public synchronized void cogerTenedores(int comensal) {
        boolean izquierda = tenedores[tenedorIzquierda(comensal)];
        boolean derecha = tenedores[tenedorDerecha(comensal)];
        // TENEDORES OCUPADOS
        while (izquierda || derecha) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TENEDORES LIBRES
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }

    public synchronized void dejarTenedores(int comensal) {
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        notifyAll();
    }
}
