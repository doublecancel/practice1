package retrofit

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {


    test1()


}


fun test1(){


    val observer = object : Observer<Int>{

        override fun onNext(value: Int?) {
            println (value)
        }

        override fun onComplete() { }

        override fun onError(e: Throwable?) { }

        override fun onSubscribe(d: Disposable?) { }
    }

    Observable.just(1)
            .subscribe(observer)

    Observable.just(1, 2, 3)
            .subscribe(observer)
}