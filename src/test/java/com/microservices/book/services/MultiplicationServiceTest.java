package com.microservices.book.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.microservices.book.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

  @MockBean
  RandomNumberGeneratorService randomNumberGeneratorService;

  @Autowired
  MultiplicationService multiplicationService;

  @Test
  public void createRandomNumberGeneratorTest() {
    // Given our first random number generator will generator will
    // generate first 50 and then 30
    given(randomNumberGeneratorService.generateRandomFactor())
        .willReturn(50, 30);

    // when
    Multiplication multiplication = multiplicationService.createRandomMultiplication();

    //then
    assertThat(multiplication.getFactorA()).isEqualTo(50);
    assertThat(multiplication.getFactorB()).isEqualTo(30);
    assertThat(multiplication.getResult()).isEqualTo(1500);

  }
}