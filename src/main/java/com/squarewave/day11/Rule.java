package com.squarewave.day11;

import java.util.List;
import java.util.function.BiFunction;

public interface Rule extends BiFunction<Space, List<Space>, Space> {
}
