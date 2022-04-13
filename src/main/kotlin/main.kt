fun main() {
    print("Сколько секунд назад вы были в сети?")
    val time = readLine()!!.toInt()
    val minutes = time / 60
    val hours = minutes / 60

    print(agoToText(time, minutes, hours))

}

fun agoToText(time:Int, minutes:Int, minutesHours:Int): String {
    val converterTime = when(time){
        in 0..60 -> "Была на сайте только что"
        in 61..(60*60) -> "Была в сети $minutes ${secondsToMinutes(minutes)}"
        in (60 * 60 + 1)..(24 * 60 * 60) -> "Была в сети $minutesHours ${minutesToHours(minutesHours)}"
        in (24 * 60 * 60)..((24 * 60 * 60)*2) -> "Была в сети сегодн"
        in ((24 * 60 * 60)*2)..((24 * 60 * 60)*3) -> "Была в сети вчера"
        in ((24 * 60 * 60)*3)..((24 * 60 * 60)*7) -> "Была в сети давно"
        else -> "Была в сети давно"
    }
    return converterTime
}

fun secondsToMinutes(minutes: Int):String{
    return if((minutes % 10 == 1) && (minutes % 100 != 11)) "минуту назад"
    else if(minutes %10 == 2 || minutes % 10 == 3 || minutes % 10 == 4) "минуты назад"
    else "минут назад"
}

fun minutesToHours(minutesHours:Int):String{
    return if(minutesHours % 10 == 1 && minutesHours % 100 != 11) "час назад"
    else if(minutesHours %10 == 2 || minutesHours % 10 == 3 || minutesHours % 10 == 4) "часа назад"
    else "часов назад"
}