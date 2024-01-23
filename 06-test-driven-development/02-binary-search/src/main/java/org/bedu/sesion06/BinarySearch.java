package org.bedu.sesion06;

public class BinarySearch {

  public static int search(int[] array, int number) {
    if (array.length == 0) {
      return -1;
    }

    if (array.length == 1 && array[0] == number){
        return 0;
    }
    
    int indice = (int)(Math.floor(array.length/2));
    
    if (array.length % 2 == 1 && array[indice] == number){
        return indice;
    } 

    if (array.length % 2 == 0 && array[indice - 1] == number){
        return indice - 1;
    } 

    return -1;
  }
}