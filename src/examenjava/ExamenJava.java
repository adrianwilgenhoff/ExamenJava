/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adrian
 */
//Metodo 1: ordene un arreglo numerico de mayor a menor sin importar el tamaño
//Metodo 2: reciba un arreglo numerico e indique si los numeros que lo componen estan ordenados de forma creciente
//          decreciente o se encuntran revueltos
//Metodo 3: metodo que indique si un numero es perfecto 
//Metodo 4: indique si una cadena es palidroma
//Metodo 5: metodo que a partir de una cadena indique cuales son los caracteres que la componen y cuantas veces esta
//          esta dentro de la cadena, en que posiciones y si solo contiene letras o si solo contiene numeros.
public class ExamenJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 8};

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        String[] arrayString = {"miriam", "fabian", "adrian"};
        Arrays.sort(arrayString);
        System.out.println(Arrays.toString(arrayString));

        System.out.println("El arreglo esta: " + metodoDos(array));

        System.out.println(metodoTres(8128));
        System.out.println(metodoTres(3));
        System.out.println(metodoTres(6));

        System.out.println(metodoCuatro("amoar a roma"));

        metodoCinco("amoar a roma");

    }

    public static void metodoCinco(String cadena) {
        Map<Character, List<Integer>> descripcion = new HashMap<>();
        for (int i = 0; i < cadena.length(); i++) {
            char a = cadena.charAt(i);
            List<Integer> lista = descripcion.get(a);
            if (lista == null) {
                lista = new ArrayList<>();
            }
            descripcion.put(a, lista);
            lista.add(i);
        }
        for (Map.Entry<Character, List<Integer>> entry : descripcion.entrySet()) {
            Character key = entry.getKey();
            List<Integer> value = entry.getValue();
            System.out.println("La letra: " + key + " se encuentra en las posiciones -> " + value + " y se repite: " + value.size() + " veces");
        }
    }

    public static String metodoCuatro(String str) {

        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr = reverseStr + str.charAt(i);
        }
        return str.equals(reverseStr) ? "String is palindrome" : "String is not palindrome";

        /*boolean palindromo = true;
       int inicio = 0;
       int fin = str.length()-1;
       System.out.println("La 1er letra es " + str.charAt(inicio) +" y la ultima es: " + str.charAt(fin) );
       while((inicio < fin) && palindromo){
           if(str.charAt(inicio) != str.charAt(fin))
               palindromo = false; 
           inicio++;
           fin--;
           System.out.println("inicio: "+ inicio+" fin: " + fin);
       }
        return palindromo? "Es palidroma" : "No Es palidroma";*/
    }

    public static String metodoTres(int numero) {
        int sum = 0;
        int i = numero - 1;
        while (i > 0) {
            if (numero % i == 0) {
                sum += i;
            }
            i--;
        }
        return sum == numero ? "Es perfecto" : "Es imperfecto";
    }

    public static String metodoDos(int[] array) {
        boolean asc = true;
        boolean desc = true;
        //int i = 0;
        int j = 1;
        while (j < array.length && (asc || desc)) {
            if (array[j - 1] > array[j]) {
                asc = false;
            }
            if (array[j - 1] < array[j]) {
                desc = false;
            }
            //i++;
            j++;
        }
        /*if (asc && desc)
            return "Todos los elementos son iguales";
        else if (!asc && !desc)
            return "Los elementos estas desordenados";
        else if (asc)
            return "Ordenado de forma ascendente";
        else return "Ordenado de forma descendente";*/
        if (asc || desc) {
            if (asc && desc) {
                return "Todos los elementos son iguales";
            } else {
                return asc ? "Ordenado de forma ascendente" : "Ordenado de forma descendente";
            }
        } else {
            return "Los elementos estas desordenados";
        }
    }

}
