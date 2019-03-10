package com.microservices.book.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.microservices.book.domain.Multiplication;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiplicationServiceImplTest {

  private MultiplicationServiceImpl multiplicationServiceImpl;

  @Mock
  private RandomNumberGeneratorService randomNumberGeneratorService;

  @Before
  public void setup() {
    // tell Mockito to process the annotations
    MockitoAnnotations.initMocks(this);

    multiplicationServiceImpl = new MultiplicationServiceImpl(randomNumberGeneratorService);
  }

  @Test
  public void createRandomMultiplicationTest() {
    // Given
    // Mocked random returns first 50 then 30
    given(randomNumberGeneratorService.generateRandomFactor()).willReturn(50, 30);


    //when
    Multiplication multiplication =
        multiplicationServiceImpl.createRandomMultiplication();

    assertThat(multiplication.getFactorA()).isEqualTo(50);
    assertThat(multiplication.getFactorB()).isEqualTo(30);
    assertThat(multiplication.getResult()).isEqualTo(1500);
  }
}
