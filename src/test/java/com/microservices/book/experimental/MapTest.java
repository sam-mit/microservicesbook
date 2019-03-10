package com.microservices.book.experimental;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.data.Index;
import org.junit.Test;

public class MapTest {

  @Test
  public void mapArrayOfNumbersToSquares() {
    List<Integer> number = Arrays.asList(1, 2, 3, -7);
    List<Integer>  square = number.stream().map(x->x*x).collect(Collectors.toList());
    assertThat(square.get(1)).isEqualTo(number.get(1)*number.get(1));
    assertThat(square.get(1)).isGreaterThan(number.get(1));


    number.stream().map(x->x*x).forEach(y-> assertThat(y).isEqualTo(number.get(square.indexOf(y))  * number.get(square.indexOf(y))));
  }

}
