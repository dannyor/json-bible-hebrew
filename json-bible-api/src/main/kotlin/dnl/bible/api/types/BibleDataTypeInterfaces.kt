package dnl.bible.api.types

interface Tora {
    fun getHumash(book: BibleBook): Book
    fun getParasha(parasha: ParashaEnum) : Parasha
}

interface Parasha {
    fun getName():String
    fun getVerses(): List<Verse>
}


interface Bible {
    fun getBook(book: BibleBook): Book
}

interface Book {
    fun getName():String
    /**
     * Gets a chapter by a (1 based) index. That is, first chapter index is 1.
     */
    fun getChapter(index:Int) : Chapter
}

interface Humash : Book {

}

interface Chapter {
    fun getParent(): Book
    fun getIndex(): Int
    /**
     * Gets a verse by a (1 based) index. That is, first verse index is 1.
     */
    fun getVerse(index:Int) : Verse
    fun getVerseAsString(index:Int) : String

}

interface Verse {
    fun getParent(): Chapter
    fun getIndex(): Int
    fun getWords(): List<String>
    fun getText(): String
}