fun main(){
    //1
    val newValue = readln().toInt()
    if(newValue % 2 == 0)
        println("Парне")
    else
        println("Непарне")
    //2
    var factorial = 1L
    for (i in 1..newValue) {
        factorial *= i
    }
    println("Факторіал для числа ${newValue} - ${factorial}")
    //3
    print("Введіть кількість чисел: ")
    val n = readLine()!!.toInt()
    val numbers = IntArray(n)

    println("Введіть $n число:")
    for (i in 0 until n) {
        numbers[i] = readLine()!!.toInt()
    }

    println("Зворотній порядок:")
    for (i in n - 1 downTo 0) {
        print("${numbers[i]} ")
    }
    //4
    print("\nВведіть ім’я: ")
    val name: String? = readLine()
    val greetingName = if (name.isNullOrBlank()) "Anonymous" else name
    println("Привіт, $greetingName")
    //5
    try {
        print("Введіть число: ")
        val number = readLine()!!.toInt()
        checkNumberInRange(number)
    } catch (e: IllegalArgumentException) {
        println("Помилка: ${e.message}")
    } catch (e: Exception) {
        println("Невірний ввід!")
    }
}
fun checkNumberInRange(number: Int) {
    if (number !in 1..100) {
        throw IllegalArgumentException("Число повинно бути в діапазоні від 1 до 100")
    }
    println("Число $number в межах допустимого діапазону.")
}
