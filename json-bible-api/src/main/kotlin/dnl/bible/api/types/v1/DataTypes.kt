package dnl.bible.api.types.v1

import dnl.bible.api.types.BibleBook
import dnl.bible.api.types.Verse
import kotlinx.serialization.Serializable
import org.apache.commons.lang3.StringUtils

@Serializable
data class Bible(val books:List<Book>) : dnl.bible.api.types.Bible {
    override fun getBook(book: BibleBook): dnl.bible.api.types.Book {
        books.forEach { if(it.getName().equals(book.englishName)) return it }
        throw IllegalArgumentException("No such book: ${book.englishName}")
    }
}

@Serializable
data class Book(private val name: String, val numOfChapters: Int, val numOfVerses: Int) : dnl.bible.api.types.Book {
    val chapters = mutableListOf<Chapter>()

    override fun getName(): String {
        return name
    }

    override fun getChapter(index: Int): dnl.bible.api.types.Chapter {
        val chapter = chapters[index - 1]
        chapter.book = this // this is a hack because these classes are attached to the file format
        return chapter
    }
}

@Serializable
data class Chapter(val chapterIndex:Int, val numOfVerses: Int) : dnl.bible.api.types.Chapter {
    val verses = mutableListOf<String>()
    @kotlinx.serialization.Transient lateinit var book : Book

    override fun getParent(): dnl.bible.api.types.Book {
        return book
    }

    override fun getIndex(): Int {
        return chapterIndex
    }

    override fun getVerse(index: Int): Verse {
        return dnl.bible.api.types.v1.Verse(this, index, getVerseAsString(index))
    }

    override fun getVerseAsString(index: Int): String {
        return verses[index-1]
    }
}

data class Verse(val parent: Chapter, private val index: Int, private val text:String) : dnl.bible.api.types.Verse {
    override fun getParent(): dnl.bible.api.types.Chapter {
        return parent
    }

    override fun getIndex(): Int {
        return index
    }

    override fun getWords(): List<String> {
        return StringUtils.split(text, ' ').toList()
    }

    override fun getText(): String {
        return text
    }


}