fun main(args : Array<String>){
    create()
}

fun create(){
    val list = mutableListOf<Int>().apply {
        for(i in 0 .. 9){
            add(i)
        }
    }

    println(list)
    remove(list)

    println(list)
    changeValue(list)
    println(list)
}

fun remove(list : MutableList<Int>){
    list.removeAt(0)
}

fun changeValue(list : MutableList<Int>){
    list[0] = 100
}