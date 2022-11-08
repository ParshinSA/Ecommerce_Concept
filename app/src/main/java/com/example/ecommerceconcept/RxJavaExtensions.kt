package com.example.core.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addContainer(container: CompositeDisposable) {
    container.add(this)
}