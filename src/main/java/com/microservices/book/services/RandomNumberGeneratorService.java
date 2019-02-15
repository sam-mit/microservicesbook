package com.microservices.book.services;

/**
 * The interface Random number generator service.
 */
public interface RandomNumberGeneratorService {


  /**
   * Generate random factor int.
   *
   * @return the int, a random generated factor between 11 - 99
   */
  int generateRandomFactor();

}
