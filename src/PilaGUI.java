import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JButton invertirButton;


    public PilaGUI() {
        invertirButton.addActionListener(new ActionListener() { //Aqui describimos que hace el boton para invertir
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText().trim(); //Sacamos los numeros que ingresamos y trim nos ayuda a remover los espacios iniciales y finales

                if (!input.isEmpty()) {//Si no esta vacio el campo de texto se procesa la entrada
                    String[] numeros = input.split(" "); //El metodo split separa elementos definiendo el separador, en este caso vamos a utilizar el espacio
                    //y creo que esta es la razon por la que nos dijo profe que los numeros deben estar separados por espacios
                    Pila pila = new Pila(); //Hacemos una nueva pila

                    //Apilamos cada número en la pila
                    for (String num : numeros) {
                        try { //Aqui un try y catch para que solo se pueda introducir numeros enteros para que no exisistan confusiones
                            int valor = Integer.parseInt(num); //Convertimos a numero entero
                            pila.apilar(valor); //Apilamos el numero
                        } catch (NumberFormatException ex) { //Mensaje de error
                            JOptionPane.showMessageDialog(null, "Introduce solo números enteros separados por espacios.");
                            return;
                        }
                    }

                    //Desapilamos cada numero para obtener la secuencia invertida
                    StringBuilder resultadoInvertido = new StringBuilder(); //Usamos un StringBuilder para construir el resultado.
                    while (!pila.estaVacia()) {
                        resultadoInvertido.append(pila.desapilar()).append(" "); //Desapilamos y agregamos el nuemero y lo separamos con un espacio
                    }

                    //Ponemos los numeros invertidos en el JTextArea
                    txtResultado.setText("Invertido: " + resultadoInvertido.toString().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce una secuencia de números.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PilaInvertirGUI");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200); //Como se veia feo le quite el frame predeterminado del main
        frame.setVisible(true);
    }
}