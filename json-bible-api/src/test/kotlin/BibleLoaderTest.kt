import bible.data.types.BibleLoader
import org.junit.Test
import java.io.File

class BibleLoaderTest {

    @Test
    fun loadTest() {
        val bible = BibleLoader.loadFrom(File("../bible-json-files/bible-just_letters-1.0.zip"))
        val book = bible.books[3]
        println(book.chapters[4].verses[0])
    }
}