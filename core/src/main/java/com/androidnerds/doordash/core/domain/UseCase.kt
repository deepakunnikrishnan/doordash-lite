package com.androidnerds.doordash.core.domain

import com.androidnerds.doordash.core.Either
import com.androidnerds.doordash.core.Result
import com.androidnerds.doordash.core.exception.Failure
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/*abstract class UseCase<out Type, in Params> where Type: Any {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun run(params: Params): Type

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        run(params)
        //val job = GlobalScope.async(Dispatchers.IO) { run(params) }
        //GlobalScope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    open fun clear() {
        compositeDisposable.clear()
    }
}*/

/*abstract class UseCase<out Type, in Params> where Type: Observable<Any> {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params): Observable<Any>
}*/


/**
 * abstract class UseCase<out Type, in Params> where Type: Any {

protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

abstract suspend fun run(params: Params)

open fun clear() {
compositeDisposable.clear()
}
}

 */

abstract class Usecase<T> {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    abstract fun executeUseCase(onStatus:(status: T) -> Unit)
    open fun clear() {
        compositeDisposable.clear()
    }
}
