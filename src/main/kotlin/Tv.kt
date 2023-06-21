class TV(val brand: String, val model: String, val diagonal: String) {

    protected var tvIsOn = true  // телевизор по умолчанию включен
    var volume: Int = 20  // звук в телевизоре(по умолчанию на 20)
    private var channel:  List<String> = channelmix()  // список каналов для телевизора

}

fun tvOnOff()    {      // функция включения телевизора кнопка
    // this.tvIsOn
    return println ("Tv on")
}

fun channelsUp() {
    println("Сколько секунд вы жмете кнопку переключения передач?")
    var counter = 0
    var time: Int = readLine()?.toIntOrNull() ?: return
    val channel = channelmix()
    println(channel.size)
    repeat(time) {
        Thread.sleep(1000)
        println(channel[counter])
        if (counter >= (channel.size - 1)) counter = 0 else counter += 1
    }
}


fun channelsDown() {  // функция переключения каналов вниз, переключение каналов в порядке возрастания и убывания (аналог нажатия кнопок переключения каналов «Вверх» и «Вниз» на пульте); если телевизор выключен, то использование этих функций включает телевизор на канале, который был до выключения; переключение каналов непрерывно: после последнего канала включается первый из списка; кнопка 3
    println("Сколько секунд вы жмете кнопку переключения передач?")
    var counter = 0
    var time: Int = readLine()?.toIntOrNull() ?: return
    val channel = channelmix()
    repeat(time) {
        Thread.sleep(1000)
        println(channel[counter])
        if (counter <= 0) counter = (channel.size - 1) else counter -= 1
    }
}

fun channelManual() { // переключение канала на заданный (аналог нажатия кнопки с цифрой канала на пульте); если телевизор выключен, то использование этой функции включает телевизор и переключает канал на заданный; кнопка 4
    println("Введите номер канала")  // можно добавить от 1 до того числа сколько в данном телевизоре есть каналов, если введут не ту цифпу, то принт введите сново
    var channelManual: Int = readLine()?.toIntOrNull() ?: return
    val channel = channelmix()
    println(channel[channelManual])
}

fun volumeUp() {  // функция увеличения громкости на заданную величину
    println("Введите цифру на сколько хотите увеличить громкость:")  // добавить проверку, если мы имеем громкость + заданная величина > 100, то будет 100
    val c: Int = readLine()!!.toInt()
    var b = 20 + c
    if (b > 100) {
        b = 100
    }
    println("Теперь громкость $b")
}

fun volumeDown() {  // функция уменьшения громкости на заданную величинну
    println("Введите цифру на сколько хотите уменьшить громкость")
    val c: Int = readLine()!!.toInt()
    var b = 20 - c
    if (b < 0) {
        b = 0
    }
    println("Теперь громкость $b")
}

fun channelList() {   // функция предоставление списка каналов в виде порядковый номер - название канала для отображения
    val channel = channelmix().forEachIndexed { index, value ->
        println("${index + 1} - $value")
    }
    return println(channel)
}