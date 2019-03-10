package com.microservices.book.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomNumberGeneratorServiceTest {

  @Autowired
  private RandomNumberGeneratorService randomNumberGeneratorService;

  @Test
  public void generateRandomFactorIsBetweenExpectedLimits() {
    // When good sample of randomly generated factors is generated.
    List<Integer> randomFactors = IntStream.range(0, 1000)
        .map(i -> randomNumberGeneratorService.generateRandomFactor())
        .boxed()
        .collect(Collectors.toList());

    // then all of them should be between 11 and 100
    // because we want a middle complexity calculation
    assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100)
    .boxed()
    .collect(Collectors.toList()));
  }

}