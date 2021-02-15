package com.androidnerds.doordash.core.domain

import com.androidnerds.doordash.core.rx.SchedulerProvider
import io.reactivex.*

/*abstract class UseCase(
    private val threadExecutor: SchedulerProvider,
    private val postExecutionThread: SchedulerProvider
)

abstract class UseCaseWithoutParam<out T>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) : UseCase(threadExecutor, postExecutionThread) {

    abstract fun build(): T

    abstract fun execute(): T
}

abstract class UseCaseWithParam<out T, in P>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) : UseCase(threadExecutor, postExecutionThread) {

    abstract fun build(param: P): T

    abstract fun execute(param: P): T
}

abstract class CompletableWithParamUseCase<in P>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) : UseCaseWithParam<Completable, P>(
    threadExecutor,
    postExecutionThread
)

abstract class CompletableUseCase(threadExecutor: SchedulerProvider, postExecutionThread: SchedulerProvider) :
    UseCaseWithoutParam<Completable>(
        threadExecutor,
        postExecutionThread
    )

abstract class ObservableWithParamUseCase<T, in P>(
    private val threadExecutor: SchedulerProvider,
    private val postExecutionThread: SchedulerProvider
) : UseCaseWithParam<Observable<T>, P>(
    threadExecutor,
    postExecutionThread
) {
    override fun execute(param: P): Observable<T> {
        return build(param)
            .subscribeOn(threadExecutor.get())
            .observeOn(postExecutionThread.get())
    }
}

abstract class ObservableWithoutParamUseCase<T>(
    private val threadExecutor: SchedulerProvider,
    private val postExecutionThread: SchedulerProvider
) : UseCaseWithoutParam<Observable<T>>(
    threadExecutor,
    postExecutionThread
) {
    override fun execute(): Observable<T> {
        return build()
            .subscribeOn(threadExecutor.get())
            .observeOn(postExecutionThread.get())
    }
}

abstract class SingleWithParamUseCase<T, in P>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) : UseCaseWithParam<Single<T>, P>(
    threadExecutor,
    postExecutionThread
) {

}

abstract class SingleUseCase<T>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) :
    UseCaseWithoutParam<Single<T>>(
        threadExecutor,
        postExecutionThread
    )

abstract class MaybeWithParamUseCase<T, in P>(
    private val threadExecutor: SchedulerProvider,
    private val postExecutionThread: SchedulerProvider
) : UseCaseWithParam<Maybe<T>, P>(
    threadExecutor,
    postExecutionThread
) {

    override fun execute(param: P): Maybe<T> {
        return build(param)
            .subscribeOn(threadExecutor.get())
            .observeOn(postExecutionThread.get())
    }
}

abstract class MaybeUseCase<T>(
    private val threadExecutor: SchedulerProvider,
    private val postExecutionThread: SchedulerProvider
) : UseCaseWithoutParam<Maybe<T>>(
    threadExecutor,
    postExecutionThread
) {
    override fun execute(): Maybe<T> =
        build()
            .subscribeOn(threadExecutor.get())
            .observeOn(postExecutionThread.get())

}

abstract class FlowableWithParamUseCase<T, in P>(
    threadExecutor: SchedulerProvider,
    postExecutionThread: SchedulerProvider
) : UseCaseWithParam<Flowable<T>, P>(
    threadExecutor,
    postExecutionThread
)

abstract class FlowableUseCase<StreamT>(threadExecutor: SchedulerProvider, postExecutionThread: SchedulerProvider) :
    UseCaseWithoutParam<Flowable<StreamT>>(
        threadExecutor,
        postExecutionThread
    )

 */