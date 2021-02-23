package com.androidnerds.doordash.core.domain;

import androidx.lifecycle.LiveData;

/**
 * Interface for the UseCase
 * @param <T>
 */
public interface UseCase<T> {

    LiveData<T> getLiveData();

    void cleanUp();
}

