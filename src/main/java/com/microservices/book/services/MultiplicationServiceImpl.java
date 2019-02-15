package com.microservices.book.services;

import com.microservices.book.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

  private RandomNumberGeneratorService randomNumberGeneratorService;

  @Autowired
  public MultiplicationServiceImpl(
      RandomNumberGeneratorService randomNumberGeneratorService) {
    this.randomNumberGeneratorService = randomNumberGeneratorService;
  }


  @Override
  public Multiplication createRandomMultiplication() {
    int factorA = randomNumberGeneratorService.generateRandomFactor();
    int factorB = randomNumberGeneratorService.generateRandomFactor();
    return new Multiplication(factorA, factorB);
  }
}
