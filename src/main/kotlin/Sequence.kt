import java.util.stream.Collectors

fun main(args: Array<String>) {
    val list = listOf("apple", "banana", "watermelon", "cherry")

    val list1 = list.stream().filter {
        println("Stream filter: $it")
        it.length > 5
    }.map {
        println("Stream map : $it")
    }.collect(Collectors.toList())

    println("============================")
    val list2 = list.filter {
        println("Not Stream filter : $it")
        it.length > 5
    }.map {
        println("Not Stream map : $it")
    }.toList()


    println("============================")
    val list3 = list.asSequence()
        .filter {
            println("AsSequence filter: $it")
            it.length > 5
        }.map {
            println("AsSequence map: $it")
        }.toList()

}
