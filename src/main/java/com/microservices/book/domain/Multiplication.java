package com.microservices.book.domain;

import lombok.Data;

/**
 * The type Multiplication.
 */
@Data
public class Multiplication {

  private int factorA;
  private int factorB;

 // product
  private int result;

  /**
   * Instantiates a new Multiplication.
   *
   * @param factorA the factor a
   * @param factorB the factor b
   */
  public Multiplication(int factorA, int factorB) {
    this.factorA = factorA;
    this.factorB = factorB;
    this.result = factorA * factorB;
  }

  /**
   * To string string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Multiplication{" +
        "factorA=" + factorA +
        ", factorB=" + factorB +
        ", result(A*B)=" + result +
        '}';
  }
}
