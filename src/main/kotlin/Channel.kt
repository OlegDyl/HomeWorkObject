object Channel {
    val channelList = listOf("RU.TV", "Sony Sci-Fi", "International", "FILMUADRAMA", // Список каналов доступный в нашей стране
        "Fox Life", "Fox", "Dorama", "Star Family", "BOLT", "TRASH", "STAR Cinema")
}
fun channelmix(): List<String> {   // функция смешивает каналы случайным образом.
    val randomChannel = Channel.channelList.shuffled()
    return randomChannel
}