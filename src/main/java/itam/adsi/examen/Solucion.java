package itam.adsi.examen;

import org.apache.log4j.Logger;

/**
 * Esta clase puede crear listas ligadas, y, a traves de la clase Nodo,
 * tambien puede invertirlas e imprimirlas
 *
 * @version 1.1
 * @author Miguel Reyes
 *
 */
public class Solucion {
     
    private final static Logger LOG = Logger.getLogger(Solucion.class);
    
    /**
      * Esta clase es un nodo, porta un string en data y esta ligado a otro nodo en next
      *
      */
     class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
        /**
	 * Este metodo invierte las lista de nodos que este despues de quien lo llama
	 * Si se llama en el primer nodo, entonces invierte toda las lista
	 *
	 * @return regresa la linea invertida
	 */
        Node gus() {
	    //Si es el ultimo lo regresa
            if(next == null) return this;
	    //Si no es el ultimo llama al metodo en el siguiente, la lista se invierte 
            //de forma recursiva
            Node otro = next;
            next      = null;
            Node tavo = otro.gus();
            otro.next = this;
            return tavo;
        }
      
        /**
         * Imprime en la consola la secuencia de Nodos que 
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el método "build", la invocación de
         * este método escribe en la consola: 
         * 
         * A-->B-->C-->D-->E-->F-->
         * 
         * Lo anterior sería lo que se visualiza en la consola 
         * justo después de ejecutar las siguintes dos lineas:
         * 
         *         Node a = build();
         *         a.prn();
         *         
         */
        void prn() {
            //Si no es el ultimo le pongo flechita, si es, no le pongo y salto de linea
            //llamo de forma recursiva el metodo en el siguiente de la lista
	    if(next != null){
		 System.out.print(this.data + "-->");
		 next.prn();
 	    }else{
	         System.out.println(this.data);
            }
        }
        
    }// ends Node class
    
    /**
     * 
     * Método que crea 6 Nodos cada uno con una letra diferente y
     * luego a cada uno en su propiedad next le asigna en siguiente.
     * Crea una lista.
     *
     * @return Node Regresa toda la lista.
     */
    private Node build() {
	LOG.info("Creo lista ligada con Solucion.build() ");
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    /**
     * Prueba la funcionalidad de el método "gus" con distintos casos de prueba
     */
    public void ok() {
        Node a = build();
	LOG.info("Imprimo lista con Nodo.prn() ");
        a.prn();
        a = a.gus();
	LOG.info("Imprimo lista con Nodo.prn() ");
        a.prn();
        a = a.gus();
	LOG.info("Imprimo lista con Nodo.prn() ");
        a.prn();
        
        Node b = new Node("X");
        b = b.gus();
	LOG.info("Imprimo lista con Nodo.prn() ");
        b.prn();
        
        Node c = new Node("X");
        Node d = new Node("Y");
        c.next = d;
        c = c.gus();
	LOG.info("Imprimo lista con Nodo.prn() ");
        c.prn();   
    }
    
    /** 
     * Metodo main de la clase, en el se ejecuta el metodo ok()
     */
    public static void main(String...argv) {
	//Cambio esto para el conflicto
	LOG.info("Se hacen las pruebas a Nodo.prn() y Nodo.gus() a traves del metodo main ");
        new Solucion().ok();
    }

}
