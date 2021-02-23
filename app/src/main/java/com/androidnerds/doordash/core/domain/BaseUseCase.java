package com.androidnerds.doordash.core.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Base class for the UseCase implementation.
 * The UseCase class outputs the result via the LiveData.
 * @param <T>
 */
public abstract class BaseUseCase<T> implements UseCase<T> {

    private final CompositeDisposable compositeDisposable  = new CompositeDisposable();
    protected MutableLiveData<T> liveData = new MutableLiveData<>();

    protected void track(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public LiveData<T> getLiveData() {
        return liveData;
    }

    @Override
    public void cleanUp() {
        compositeDisposable.clear();
    }
}