package com.androidnerds.doordash.core.domain;

import androidx.lifecycle.LiveData;

public interface UseCase<T> {

    LiveData<T> getLiveData();

    void cleanUp();
}

