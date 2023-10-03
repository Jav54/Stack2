import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Pila {

    private Stack <Character> pila;

    public Pila() {
        pila = new Stack<>();
    }

    public void insertar(Character dato){
        pila.push(dato);
    }

    public Character eliminar() throws Exception {
        if (pila.isEmpty()){
            throw new Exception(("pila vacia"));
        }
        return pila.pop();
    }

    public Character elementoTope() throws Exception {
        if (pila.isEmpty()){
            throw new Exception(("pila vacia"));
        }
        return pila.peek();
    }

    public boolean esVacia(){
        return pila.isEmpty();
    }

    @Override
    public String toString() {
        String resultado = "=Pila=\n";

        for (int i = pila.size()-1; i>=0; i--){
            resultado+=pila.get(i)+"\n";
        }
     return resultado;
    }
}
