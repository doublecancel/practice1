package learn_object

fun main(args: Array<String>) {

    val max = {
        a : Int, b : Int ->
            if(a > b) {
                a
            }else{
                b
            }
    }

    val c = max(1, 2)
    println (c)


    test6(123)

    val list = listOf<Int>(1, 2, 3, 4, 5)
    val testList = {
        a:Int ->
            when(a){
                1 -> println()
                else -> println()
            }
    }

}

fun test(x : Int) : Unit {

    when(x){
        1 -> println("1 -> $x")
        2 -> println ("2 -> $x")
        else -> println ("else -> $x")
    }

}

fun testWhen(x : Int) = when {
    x > 10 -> println ("$x")
    x < 10 -> println ("$x")
    else -> println ("else ")
}

fun test2(x : Any) = when(x){
    is String -> println ("is string -> $x")
    is Int -> println ("is int -> $x")
    else -> println ("else not string nor int $x")
}

fun test3(x : A) = when(x){
    is A.B -> println("B -> $x")
    is A.C -> println ("C -> $x")
    is A.D -> println ("D -> $x")
}

fun test4(x : Any) = when(x){
    in listOf(1, 2, 3, 4) -> println ("in list -> $x")
    in (1 .. 1000) -> println ("int range 1 - 1000")
    !in 2..20 -> println ("in range 2 .. 20")
    else -> println ("else $x")
}

fun test5(x : Any) = when(x){
    1, 2, 3, 4, 5 -> "ok"
    else -> "error"
}

fun test6(x : Any) : String {
    val res = when(x){
        1, 2, 3, 4, 5 -> "ok"
        2, 3, 4, 5, 6 -> "bad"
        else -> "normal"
    }
    return res
}

fun test5(){
    mapOf(1 to 2)
            .map { (k, b) -> println("$k + $b") }
}

fun test6 () {
    val (name, age) = E("name", 20)
    println ("$name + $age")

    mapOf(1 to 2)
            .map { (k, v) -> println ("$k + $v") }

    mapOf<String, String>( "name" to "name2")
            .map { entry -> println ("${entry.value} + ${entry.key}") }

    mapOf("ttt" to "aaa")
            .map { (_, k) -> println ("$k") }

    val (name1, realName) = test7()
    println ("$name1 + $realName")
}

fun test7() : Pair<String, String>{
    return "name" to "tttt"
}

data class E (val name : String, val age : Int)


sealed class A {
    data class B(val name : String) : A()
    data class C(val name : String, val age : Int) : A()
    data class D(val name : String, val age : Int, val gender : Boolean) : A()
}

