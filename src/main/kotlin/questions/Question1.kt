package questions

/*
비교 연산자 없이 숫자가 동일한지 알아보기

비교 연산자를 사용할 수 없으면 비트 연산자로 숫자 비교를 진행해야한다.

xor연산을 이용한다.
그러면 if문 내에 있는 비교 연산자는?
 */
fun main(args : Array<String>){
    val one = 3
    val two = 7

    if(one.xor(two) == 0){
        println("is Same")
    }else
        println("is Not Same")
}