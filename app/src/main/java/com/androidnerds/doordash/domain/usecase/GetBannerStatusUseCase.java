package com.androidnerds.doordash.domain.usecase;

import com.androidnerds.doordash.core.domain.BaseUseCase;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * UseCase implementation for fetching the storeFeed from the data layer.
 * Returns the result to the presentation layer via the liveData.
 */
public class GetBannerStatusUseCase extends BaseUseCase<Result<Boolean, Throwable>> {

    private final IStoreFeedRepository storeFeedRepository;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public GetBannerStatusUseCase(IStoreFeedRepository storeFeedRepository,
                                  SchedulerProvider schedulerProvider) {
        this.storeFeedRepository = storeFeedRepository;
        this.schedulerProvider = schedulerProvider;
    }

    public void execute() {
        Disposable disposable = this.storeFeedRepository.getBannerStatus()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::onSuccess, this::onFailure);
        track(disposable);
    }

    private void onSuccess(Boolean status) {
        liveData.postValue(new Result<>(status, null));
    }

    private void onFailure(Throwable throwable) {
        liveData.postValue(new Result<>(null, throwable));
    }

}
