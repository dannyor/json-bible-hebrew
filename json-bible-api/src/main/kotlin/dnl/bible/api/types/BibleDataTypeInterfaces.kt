package dnl.bible.api.types

import java.util.regex.Pattern

interface Tora {
    fun getHumash(humash: HumashEnum): Book
    fun getParasha(parasha: ParashaEnum): Parasha
}

interface Parasha {
    fun getName(): String
    fun getVerses(): List<Verse>
}


interface Bible {
    fun getBook(book: BibleBook): Book
    fun getVerseRange(verseRange: VerseRange): Iterator<Verse> {
        return VerseRangeIterator(getBook(verseRange.start.book), verseRange)
    }
}

interface Book {
    fun getName(): String
    fun getBookEnumVal(): BibleBook {
        return BibleBook.byEnglishName(getName())
    }
    /**
     * Gets a chapter by a (1 based) index. That is, first chapter index is 1.
     */
    fun getChapter(index: Int): Chapter

    fun getVerse(location: VerseLocation): Verse {
        return getChapter(location.chapterIndex).getVerse(location.verseIndex)
    }

    fun getVerseRange(verseRange: VerseRange): Iterator<Verse> {
        return VerseRangeIterator(this, verseRange)
    }
}

interface Humash : Book {

}

interface Chapter : Iterator<dnl.bible.api.types.Chapter> {
    fun getParent(): Book
    fun getIndex(): Int

    /**
     * Gets a verse by a (1 based) index. That is, first verse index is 1.
     */
    fun getVerse(index: Int): Verse
    fun getVerseAsString(index: Int): String

}

interface Verse : Iterator<dnl.bible.api.types.Verse> {
    fun getParent(): Chapter
    fun getIndex(): Int
    fun getWords(): List<String>
    fun getText(): String
    fun getLocation(): VerseLocation {
        return VerseLocation(getParent().getParent().getBookEnumVal(), getParent().getIndex(), getIndex())
    }
}

data class VerseLocation(val book: BibleBook, val chapterIndex: Int, val verseIndex: Int)

/**
 * Describes an inclusive range of verses.
 */
data class VerseRange(val start: VerseLocation, val end: VerseLocation) {
    init {
        if(start.book != end.book)
            throw IllegalArgumentException("Ranges are allowed only on the same book")
    }
}

object VerseRangeFactory {
    private val rangePattern = Pattern.compile("(\\w+) (\\d+):(\\d+).+?(\\d+):(\\d+)")
    fun newVerseRange(str: String): VerseRange {
        val matcher = rangePattern.matcher(str)
        matcher.find()
        val book = BibleBook.byEnglishName(matcher.group(1))
        return VerseRange(
            VerseLocation(book, matcher.group(2).toInt(), matcher.group(3).toInt()),
            VerseLocation(book, matcher.group(4).toInt(), matcher.group(5).toInt())
        )
    }
}

class VerseRangeIterator(private val book: Book, private val range: VerseRange) : Iterator<dnl.bible.api.types.Verse> {
    private lateinit var current:dnl.bible.api.types.Verse

    override fun hasNext(): Boolean {
        if(!this::current.isInitialized) return true
        if(current.getParent().getIndex() == range.end.chapterIndex && current.getIndex() == range.end.verseIndex)
            return false
        return current.hasNext()
    }

    override fun next(): Verse {
        current = if(!this::current.isInitialized)
            book.getVerse(range.start)
        else {
            current.next()
        }
        return current
    }
}