package com.test.cmind.domain.usecase

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    fun execute(params: Params? = null): Single<T> {
        return buildUseCaseObservable(params).subscribeOn(Schedulers.io())
    }
}