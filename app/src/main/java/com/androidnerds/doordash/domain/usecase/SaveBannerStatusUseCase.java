package com.androidnerds.doordash.domain.usecase;

import com.androidnerds.doordash.core.domain.BaseUseCase;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

/**
 * UseCase implementation for fetching the storeFeed from the data layer.
 * Returns the result to the presentation layer via the liveData.
 */
public class SaveBannerStatusUseCase extends BaseUseCase<Result<Boolean, Throwable>> {

    private final IStoreFeedRepository storeFeedRepository;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public SaveBannerStatusUseCase(IStoreFeedRepository storeFeedRepository,
                                   SchedulerProvider schedulerProvider) {
        this.storeFeedRepository = storeFeedRepository;
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(boolean status) {
        Disposable disposable = this.storeFeedRepository.saveBannerStatus(status)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        System.out.println("Completed");
                    }
                }, this::onFailure);
        track(disposable);
    }

    private void onSuccess(Boolean status) {
        liveData.postValue(new Result<>(status, null));
    }

    private void onFailure(Throwable throwable) {
        liveData.postValue(new Result<>(null, throwable));
    }

}
