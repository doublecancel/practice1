package retrofit

import io.reactivex.Flowable
import io.reactivex.Observable
import learn_object.User
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.lang.reflect.Type


val mockWebServer = MockWebServer()

fun main(args: Array<String>) {
//    testGetName()
//    testGetUser()


    testObserable()

}

fun testObserable(){
//    mockWebServer.enqueue(MockResponse().setBody("123"))
//    val service = buildObservableService()
//    val res = service.test1().execute().body()
//    println (res)


//    mockWebServer.enqueue(MockResponse().setBody("123"))
    val service1 = buildObservableService()
//    val res1 = service1.test2().forEach(::println)

    mockWebServer.enqueue(MockResponse().setBody("123"))

    val result = service1.test2().blockingFirst()
    println ("result : $result")

}

fun buildObservableService() : ObservableService {
    val retrofit = Retrofit.Builder()
            .addConverterFactory(StringConvert)
//            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(mockWebServer.url("/"))
            .build()
    return retrofit.create(ObservableService::class.java)
}

fun testGetUser(){
    val user = User("lxl", 123)
    mockWebServer.enqueue(MockResponse().setHeader("Content-Type", "application/json;charset=utf-8")
            .setBody("{\"name\":\"lxl\", \"age\":123}"))
    val service = buildService(url = "/getObject/")
    val res = service.getUser().execute()

    assert(res.body() == user)
}


fun testGetName(){
    mockWebServer.enqueue(MockResponse().setBody("success"))
    val service = buildService()
    val res = service.getName().execute()
    assert(res.body() == "success")
}


fun buildService(url : String = "/") : UserService {
    val retrofit = Retrofit.Builder()
//            .addConverterFactory(StringConvert)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url(url))
            .client(OkHttpClient())
            .build()
    return retrofit.create(UserService::class.java)
}

interface UserService{
    @GET("/") fun getName() : Call<String>
    @GET("/getObject") fun getUser() : Call<User>

    @POST("/saveUser") fun saveUser(@Body user : retrofit.User)
    @GET("/findById/{id}") fun findUser(@Path("id") id : Int?)

}

interface ObservableService {
    @GET("/") fun test1() : Call<String>

    @GET("/") fun test2() : Observable<String>

    @GET("/") fun test3() : List<String>

    @GET("/") fun test4() : Flowable<String>
}

data class User(val name : String, val age : Int)


object StringConvert : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return Converter<ResponseBody, String> {
            a -> a.string()
        }
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        return Converter<String, RequestBody>{
            a -> RequestBody.create(MediaType.parse("text/plain"), a)
        }
    }

    override fun stringConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, String>? {
        return super.stringConverter(type, annotations, retrofit)
    }
}