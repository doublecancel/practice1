package learn_object

fun main(args: Array<String>) {

    println ("${getStringLength("")}")

    println ("${getStringLength(null)}")

    println ("${getStringLength("abc")}")

    val user = User(null, null)
    println(user.name)


    val t = test567("1111111")
    println (t)

    println ("${test567(null)}")

}

fun test567(a : Any?) : String?{
    return a as String?
}


fun getStringLength(a : String?) : Int {
    val b = "123".toInt()
    println (b is Int)


//    return a !!.length
    return a?.length ?: -1
}



data class User(var name : String? , val age : Int?)



