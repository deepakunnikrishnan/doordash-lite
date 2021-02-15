package com.androidnerds.doordash.storefeed.domain.usecase

import com.androidnerds.doordash.core.domain.*
import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.core.rx.disposeWith
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import com.androidnerds.doordash.storefeed.domain.Location
import com.androidnerds.doordash.storefeed.domain.StoreFeed
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class GetStoreFeedUseCase @Inject constructor(
    private val storeFeedRepository: IStoreFeedRepository,
    private val schedulerProvider: SchedulerProvider): Usecase<Status>() {

    //fun invoke(param: Params): Flowable<SimpleResult<StoreFeed>> = null
        /*storeFeedRepository.getStoreFeed(param.location, param.limit, param.offset)
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.mainThread)*/

    data class Params(val location: Location, val limit: Int, val offset: Int)

    override fun executeUseCase(onStatus: (status: Status) -> Unit) {
        storeFeedRepository.getStoreFeed(Location(10.0,10.0),50,0)
            .map<Status> { Status.Success(it) }
            .onErrorReturn(::onError)
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.mainThread)
            .subscribe(onStatus)
            .disposeWith(compositeDisposable)
    }

    private fun onError(throwable: Throwable): Status {
        return when(throwable) {
            is SocketTimeoutException -> Status.ConnectionError
            is UnknownHostException -> Status.ConnectionError
            else -> {
                Status.UnknownError
            }
        }
    }
}

sealed class Status {
    data class Success(val storeFeed: StoreFeed): Status()
    object ConnectionError: Status()
    object UnknownError: Status()
}


/*
class GetStoreFeedUseCase @Inject constructor(
    private val storeFeedRepository: IStoreFeedRepository,
    private val schedulerProvider: SchedulerProvider
): FlowableWithParamUseCase<Either<Error, StoreFeed>, Params>(
    schedulerProvider, schedulerProvider
) {
    override fun build(param: Params): Flowable<Either<Error, StoreFeed>> {
        storeFeedRepository.getStoreFeed(
            param.location,
            param.limit,
            param.offset
        ).map { it.fold(
            {Failure(Error.UnknownError)},
            {Success(it)}
        ) }
    }
    override fun execute(param: Params): Flowable<Either<Error, StoreFeed>> {
        TODO("Not yet implemented")
    }

}

data class Params(val location: Location, val limit: Int, val offset: Int)

sealed class Error {
    object UnknownError
}*/
