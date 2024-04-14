package com.graphqljava.tutorial.retail.repository;

import java.util.List;

public interface AllLimited<T> {
    List<T> findAllLimitedTo(int limit);

}
