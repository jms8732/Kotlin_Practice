import kotlin.random.Random

@OptIn(ExperimentalStdlibApi::class)
fun main(args : Array<String>){
    val str = "Hello"

    str.run {
        println("The receiver string length: $length")
    }

    str.let{
        println("The receiver string's length is ${it.length}")
    }

    val i = getRandomInt()
    println(i)

    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
        .apply {
            add(2.71)
            add(3.14)
            add(1.0)
        }
        .also{ println("Sorting the list")}
        .sort()


    //lambda result
    val numbers = mutableListOf("one", "two","three")
    val countEndWithE = numbers.run{
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndWithE elements that end with e.")

    with(numbers){
        val firstItem = first()
        val lastItem = last()

        println("First item: $firstItem, last item: $lastItem")
    }

    val modifiedFirstItem = numbers.first().let{ firstItem ->
        println("The first item of the list is $firstItem")
        if(firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.uppercase()

    println("First Item after modifications: $modifiedFirstItem")


    with(numbers){
        println("`with` is called with argument $this")
        println("It contains $size elements")
    }

    val firstAndLast = with(numbers){
        "The first elements is ${first()}," +
                " the last element is ${last()}"
    }

    println(firstAndLast)

    val service = MultiportService("https://example.kotlinlang.org",80)
    service.run{
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    numbers.also{println("The list elements before adding new one : $it")}
        .add("four")

}


fun getRandomInt() : Int{
    return Random.nextInt(100).also {
        println("getRandomInt() generated value $it")
    }
}

data class MultiportService(var url : String, var port : Int){
    fun query(q : String){
        println(q)
    }
    fun prepareRequest() = url
}