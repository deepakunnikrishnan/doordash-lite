package com.androidnerds.doordash.domain.usecase;

import com.androidnerds.doordash.core.domain.BaseUseCase;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * UseCase implementation for fetching the storeFeed from the data layer.
 * Returns the result to the presentation layer via the liveData.
 */
public class GetStoreFeedUseCase extends BaseUseCase<Result<StoreFeedViewData, Throwable>> {

    private final IStoreFeedRepository storeFeedRepository;
    private final SchedulerProvider schedulerProvider;
    private final Mapper<StoreFeed, StoreFeedViewData> mapper;

    public GetStoreFeedUseCase(IStoreFeedRepository storeFeedRepository,
                               Mapper<StoreFeed, StoreFeedViewData> mapper,
                               SchedulerProvider schedulerProvider) {
        this.storeFeedRepository = storeFeedRepository;
        this.mapper = mapper;
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(Location location, int limit, long offset) {
        Disposable disposable = this.storeFeedRepository.getStoreFeed(location, limit, offset)
                .map(mapper::map)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::onSuccess, this::onFailure);
        track(disposable);
    }

    private void onSuccess(StoreFeedViewData storeFeed) {
        liveData.postValue(new Result<>(storeFeed, null));
    }

    private void onFailure(Throwable throwable) {
        liveData.postValue(new Result<>(null, throwable));
    }

}
