import dnl.bible.api.BibleLoader
import dnl.bible.api.types.BibleBook
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class BibleLoaderTest {

    @Test
    fun loadTest() {
        val bible = BibleLoader.loadFrom(File("../bible-json-files/bible-just_letters-1.0.zip"))
        val book = bible.books[3]
        val verse = book.chapters[4].verses[0]
        val expected = "וידבר יהוה אל משה לאמר"
        println(verse)
        assertEquals(expected, verse)

        // test also interface API
        val genesis = bible.getBook(BibleBook.NUMBERS)
        assertEquals("Numbers", genesis.getName())
        val chapter5 = genesis.getChapter(5)
        assertEquals("Numbers", chapter5.getParent().getName())
        assertEquals(5, chapter5.getIndex())
        val verse1 = chapter5.getVerse(1)
        assertEquals(expected, verse1.getText())
    }
}