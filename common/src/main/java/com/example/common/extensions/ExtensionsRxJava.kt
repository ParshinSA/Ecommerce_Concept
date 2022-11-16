package com.example.common.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.add(container: CompositeDisposable) {
    container.add(this)
}