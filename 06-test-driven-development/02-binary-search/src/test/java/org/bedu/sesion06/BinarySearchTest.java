package org.bedu.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BinarySearchTest {

  @Test
  @DisplayName("Cualquier número en un arreglo vacío da -1")
  public void emptyArray() {
    int[] array = {};

    int index = BinarySearch.search(array, 100);

    assertEquals(-1, index);
  }

  @Test
  @DisplayName("Que un arreglo con un número debería encontrar un numero")
  public void oneSizedArray() {
    int[] array = { 2 };

    int index = BinarySearch.search(array, 2);

    assertEquals(0, index);
  }

  @Test
  @DisplayName("Dado el arreglo con un numero no encontrado, regresa -1")
  public void indexNotFoundOneSizedArray() {
    int[] array = { 3 };

    int index = BinarySearch.search(array, 4);

    assertEquals(-1, index);
  }

  // Caso
  // Arreglo de tamaño impar (3) [100, 200, 300]
  // Que el elemento se encuentre exactamente en medio: 200

  @ParameterizedTest
  @MethodSource("mediumArrayNumberPreconditions")
  @DisplayName("Dado en el arreglo impar el elemento se encuentra en medio")
  public void mediumArrayNumber(int[] array, int number, int expectedIndex) {
    int index = BinarySearch.search(array, number);

    assertEquals(expectedIndex, index);
  }

  static Stream<Arguments> mediumArrayNumberPreconditions() {
    return Stream.of(
        Arguments.of(new int[] { 100, 200, 300 }, 200, 1),
        Arguments.of(new int[] { 100, 200, 300, 400, 500 }, 300, 2),
        Arguments.of(new int[] { 100, 200, 300, 400, 500, 600, 700 }, 400, 3));
  }

  // Caso
  // Arreglo de tamaño par (4) [100, 200, 300, 400]
  // Que el elemento se encuentre exactamente en medio: 200
  @Test
  @DisplayName("Que el elemento se encuentre exactamente en medio")
  public void pairNumber() {
    int[] array = { 100, 200, 300, 400 };

    int index = BinarySearch.search(array, 200);
    
    assertEquals(1, index);
  }
}
