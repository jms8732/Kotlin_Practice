fun main(args: Array<String>) {
    val ex = Example()
    ex.setFunction {
        println("High Order Function...")
    }
}


class Example{
    fun setFunction(argFun : () -> Unit) = argFun()
}



fun example2(args : Int, argFun1 : (Int) -> Int , argFun2 : (Int) -> Int = {x : Int -> x * x}){
    println(argFun1(args))
    println(argFun2(args))
}


fun example1(args : Int, argFun1 : (Int) -> Int, argFun2 : (Int) -> Boolean){
    println(argFun1(args))
    println(argFun2(args))
}


