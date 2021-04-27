import dnl.bible.api.BibleLoader
import dnl.bible.api.types.Bible
import dnl.bible.api.types.BibleBook
import dnl.bible.api.types.VerseRangeFactory
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class BibleApiTest {
    companion object {
        lateinit var bible: Bible
        @BeforeClass @JvmStatic fun setup() {
            bible = BibleLoader.loadFrom(File("../bible-json-files/bible-just_letters-1.0.zip"))
        }
    }

    @Test
    fun testBibleBookEnum() {
        val bbook = BibleBook.byEnglishName("Numbers")
        assertEquals(BibleBook.NUMBERS, bbook)
    }

    @Test
    fun testVerseRangeFactory() {
        val range = VerseRangeFactory.newVerseRange("Numbers 1:1-1:5")
        assertEquals(BibleBook.NUMBERS, range.start.book)
        assertEquals(1, range.start.chapterIndex)
        assertEquals(1, range.start.verseIndex)
        assertEquals(BibleBook.NUMBERS, range.end.book)
        assertEquals(1, range.end.chapterIndex)
        assertEquals(5, range.end.verseIndex)
    }

    @Test
    fun testDirectAccess() {
        val bookOfNumbers = bible.getBook(BibleBook.NUMBERS)
        assertEquals("Numbers", bookOfNumbers.getName())
        val chapter5 = bookOfNumbers.getChapter(5)
        assertEquals("Numbers", chapter5.getParent().getName())
        assertEquals(5, chapter5.getIndex())
        val verse1 = chapter5.getVerse(1)
        val expected = "וידבר יהוה אל משה לאמר"
        assertEquals(expected, verse1.getText())
    }

    @Test
    fun testWithRangeIterator() {
        val iterator = bible.getVerseRange(VerseRangeFactory.newVerseRange("Numbers 1:1-1:5"))
        val verses = iterator.asSequence().toList()
        assertEquals(1, verses[0].getParent().getIndex())
        assertEquals(1, verses[0].getIndex())
        assertEquals("וידבר יהוה אל משה במדבר סיני באהל מועד באחד לחדש השני בשנה השנית לצאתם מארץ מצרים לאמר", verses[0].getText())

        assertEquals(1, verses[4].getParent().getIndex())
        assertEquals(5, verses[4].getIndex())
    }
}