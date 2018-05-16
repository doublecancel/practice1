package retrofit

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.Exceptions

fun main(args: Array<String>) {


    val observable = MyObservable(ServiceImpl())

    val executor = ExecuteObserable(observable)
    val name = executor.blockingFirst()
    println(name)
}


class MyObserver : Observer<String> {


    override fun onNext(value: String?) {
        println("观察者onnext：$value")
    }

    override fun onComplete() {
        println("观察者onComplete")
    }

    override fun onSubscribe(d: Disposable?) {
        println("观察者onSubscribe")
    }

    override fun onError(e: Throwable?) {
        println("onError")
    }
}

class MyObservable(val service: IService?) : Observable<String>() {

    override fun subscribeActual(observer: Observer<in String>?) {
        val disposable = object : Disposable {

            @Volatile
            var disposbale: Boolean = false

            override fun isDisposed() = disposbale

            override fun dispose() {
                disposbale = true
            }
        }
        try {
            val name = service?.getName()
            observer?.onSubscribe(disposable)

            if (!disposable.disposbale) {
                observer?.onNext(name)
            }

            if (!disposable.disposbale) {
                observer?.onComplete()
            }
        }catch (e : Throwable){
            Exceptions.throwIfFatal(e)
            observer?.onError(e)
        }


    }
}

class ExecuteObserable(val observable: Observable<String>?) : Observable<String>() {

    override fun subscribeActual(observer: Observer<in String>?) {
        observable?.subscribe(observer)
    }
}


interface IService {
    fun getName(): String
}

class ServiceImpl : IService {
    override fun getName(): String {
        return "liuxianglei"
    }
}

