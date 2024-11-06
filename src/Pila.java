import javax.swing.*;

public class Pila {
    private Nodo cima; //la parte de arriba del nodo
    private int tamano; //el tamaño de la pila

    // Constructor de la pila
    public Pila() {
        cima = null;
        tamano = 0;
    }

    //El metodo para apilar un nuevo elemento  .
    public void apilar(int dato) {
        Nodo nuevoNodo = new Nodo(dato); //hacemos un nuevo Nodo
        nuevoNodo.siguiente = cima; //El nuevo nodo ve a la cima
        cima = nuevoNodo; //La cima ahora apunta al nuevo nodo
        tamano++;
    }

    //El metodo para desapilar los elementos de la pila
    public int desapilar() {
        int dato = cima.dato; //guardamos el elemento de la cima
        cima = cima.siguiente;//la cima se actualiza como el siguiente nodo
        tamano--;
        return dato; //retornamos el valor del elemento guardado
    }

    // EL metodo para ver si la pila esta vacia
    public boolean estaVacia() {
        return cima == null;
    }
}