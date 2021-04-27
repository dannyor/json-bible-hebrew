import dnl.bible.api.BibleLoader
import dnl.bible.api.types.*
import dnl.bible.api.types.v1.ToraImpl
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class ToraApiTest {
    companion object {
        lateinit var tora: Tora
        @BeforeClass @JvmStatic fun setup() {
            val bible = BibleLoader.loadFrom(File("../bible-json-files/bible-just_letters-1.0.zip"))
            tora = ToraImpl(bible)
        }
    }

    @Test
    fun testParasha() {
        var parasha = tora.getParasha(ParashaEnum.BALAK)
        var verses = parasha.getVerses()
        assertEquals(104, verses.size)

        parasha = tora.getParasha(ParashaEnum.BEREISHIS)
        verses = parasha.getVerses()
        assertEquals(146, verses.size)

    }

}