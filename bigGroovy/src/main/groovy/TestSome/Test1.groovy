package TestSome

/**
 * Created by Administrator on 2017/11/22.
 */
class Test1 {

    static main(args){
        def test = new Test1()


//        test.test1()
//        test.test3()
//        test.test4()
        test.test5()

    }



    def test1(){
        def list = ['a', 'b', 'c']

        list.each {a ->
            println a
        }

        list.each {println it}

        def list2 = []
        list.each {list2 << "${it}y"}
        println list2

        list.eachWithIndex { it, int i ->
            println "${i} - ${it}"
        }


    }

    def test2(){

        def list = [1, 2, 3 ,4 ,5]
        println list.collect {it * 2}

        println list

        def list2 = [0, 10]

        println list.collect(list2){it * 2}

    }


    def test3(){

        assert [1, 2, 3, 4, 5].find{it > 3} == 4
        assert [1, 2, 3, 4, 5].findAll {it > 3} == [4, 5]
        assert ['a', 'b', 'c', 'd'].findIndexOf {it == 'c'} == 2

        assert [1, 2, 3, 4].every {it > 0} == true
        assert [1, 2, 3, 4].any {it > 3} == true

        assert [1, 2, 3, 4].sum(100) == 110

        assert [1, 2, 3, 4].join('-') == '1-2-3-4'

        assert [1, 2, 3, 4].min() == 1

        assert ['1', '123', 'fasdfdsa'].max {it.length()} == 'fasdfdsa'
        assert ['a', 'b', 'c'].grep{it.length() == 1} == ['a', 'b', 'c']

        assert ['a', 'ba', 'caa'].groupBy {it.length()} == [1:['a'], 2:['ba'], 3:['caa']]

        assert [1, 2, 3, 4].count {it > 2} == 2

    }


    def test4(){

        def map = [1:"a", 2:"b"]
        map.each {println "${it.key} - ${it.value}"}

        map.each {key, value -> println "${key} - ${value}"}

    }

    def test5(){
        def range = 1 .. 10
        range.each {println "${it}"}

        println range.contains(2)

    }



}
