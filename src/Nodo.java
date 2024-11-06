public class Nodo {
    //Aqui se hizo la clase nodo, la cual nos ayuda a guardar los datos y a mostrar el siguiente nodo en la pila
    public int dato;
    public Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}