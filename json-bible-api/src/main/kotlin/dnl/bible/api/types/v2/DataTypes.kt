package dnl.bible.api.types.v2

import kotlinx.serialization.Serializable

@Serializable
data class Bible(val books:List<Book>)

@Serializable
data class Book(val name: String) {
    val chapters = mutableListOf<Chapter>()
}

@Serializable
data class Chapter(val chapterIndex:Int) {
    val verses = mutableListOf<Verse>()
}

@Serializable
data class Verse(val name: String, val numOfChapters: Int, val numOfVerses: Int) {
    val words = mutableListOf<String>()
}
