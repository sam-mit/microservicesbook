package com.microservices.book.services;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberGeneratorServiceImpl implements RandomNumberGeneratorService {

  private static final int MINIMUM_FACTOR = 11;
  private static final int MAXIMUM_FACTOR = 99;
  /**
   * Generate random factor int.
   *
   * @return the int, a random generated factor between 11 - 99
   */
  @Override
  public int generateRandomFactor() {
    return new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1 ) + MINIMUM_FACTOR;
  }
}
