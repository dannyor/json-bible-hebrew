package dnl.bible.api.types

import dnl.bible.api.types.BibleBook.*
import dnl.bible.api.types.ParashaEnum.*
import java.lang.IllegalArgumentException


enum class BibleGroups(val groupName: String, vararg book: BibleBook) {
    TORA("תורה", GENESIS, EXODUS, LEVITICUS, NUMBERS, DEUTERONOMY),
    NEVIIM(
        "נביאים",
        JOSHUA, JUDGES, SAMUEL_1, SAMUEL_2, KINGS_1, KINGS_2,
        ISAIAH, JEREMIAH, EZEKIEL, HOSEA, JOEL, AMOS, OBADIAH, JONAH, MICAH,
        NAHUM, HABAKKUK, ZEPHANIAH, HAGGAI, ZECHARIAH, MALACHI
    ),
    KETUVIM(
        "כתובים",
        PSALMS, PROVERBS, JOB, SONG_OF_SONGS, RUTH, LAMENTATIONS,
        ECCLESIASTES, ESTHER, DANIEL, EZRA, NEHEMIAH, CHRONICLES_1, CHRONICLES_2
    )
}

enum class BibleBook(val englishName: String, val hebrewName: String, vararg parasha: ParashaEnum) {
    GENESIS("Genesis", "בראשית",
        BEREISHIS, NOACH, LECH_LECHA, VAYERA, CHAYEI_SARAH,
        TOLDOS, VAYEITZEI, VAYISHLACH, VAYEISHEV, MIKETZ, VAYIGASH, VAYECHI),
    EXODUS("Exodus", "שמות", SHEMOS),
    LEVITICUS("Leviticus", "ויקרא"),
    NUMBERS("Numbers", "במדבר"),
    DEUTERONOMY("Deuteronomy", "דברים"),
    JOSHUA("Joshua", "יהושע"),
    JUDGES("Judges", "שופטים"),
    SAMUEL_1("Samuel_1", "שמואל א"),
    SAMUEL_2("Samuel_2", "שמואל ב"),
    KINGS_1("Kings_1", "מלכים א"),
    KINGS_2("Kings_2", "מלכים ב"),
    ISAIAH("Isaiah", "ישעיה"),
    JEREMIAH("Jeremiah", "ירמיה"),
    EZEKIEL("Ezekiel", "יחזקאל"),
    HOSEA("Hosea", "הושע"),
    JOEL("Joel", "יואל"),
    AMOS("Amos", "עמוס"),
    OBADIAH("Obadiah", "עובדיה"),
    JONAH("Jonah", "יונה"),
    MICAH("Micah", "מיכה"),
    NAHUM("Nahum", "נחום"),
    HABAKKUK("Habakkuk", "חבקוק"),
    ZEPHANIAH("Zephaniah", "צפניה"),
    HAGGAI("Haggai", "חגי"),
    ZECHARIAH("Zechariah", "זכריה"),
    MALACHI("Malachi", "מלאכי"),
    PSALMS("Psalms", "תהילים"),
    PROVERBS("Proverbs", "משלי"),
    JOB("Job", "איוב"),
    SONG_OF_SONGS("Song of songs", "שיר השירים"),
    RUTH("Ruth", "רות"),
    LAMENTATIONS("Lamentations", "איכה"),
    ECCLESIASTES("Ecclesiastes", "קהלת"),
    ESTHER("Esther", "אסתר"),
    DANIEL("Daniel", "דניאל"),
    EZRA("Ezra", "עזרא"),
    NEHEMIAH("Nehemiah", "נחמיה"),
    CHRONICLES_1("Chronicles_1", "דברי הימים א"),
    CHRONICLES_2("Chronicles_2", "דברי הימים ב");

    fun byHebrewName(hebrewName: String): BibleBook {
        values().forEach {
            if (it.hebrewName == hebrewName) return it
        }
        throw IllegalArgumentException()
    }
    fun byEnglishName(hebrewName: String): BibleBook {
        values().forEach {
            if (it.englishName == hebrewName) return it
        }
        throw IllegalArgumentException()
    }
}

enum class ParashaEnum(val englishName: String, val hebrewName: String) {
    BEREISHIS("Bereishis", "בראשית"),
    NOACH("Noach", "נח"),
    LECH_LECHA("Lech Lecha", "לך לך"),
    VAYERA("Vayera", "וירא"),
    CHAYEI_SARAH("Chayei Sarah", "חיי שרה"),
    TOLDOS("Toldos", "תולדות"),
    VAYEITZEI("Vayeitzei", "ויצא"),
    VAYISHLACH("Vayishlach", "וישלח"),
    VAYEISHEV("Vayeishev", "וישב"),
    MIKETZ("Miketz", "מקץ"),
    VAYIGASH("Vayigash", "ויגש"),
    VAYECHI("Vayechi", "ויחי"),
    SHEMOS("Shemos", "שמות"),
    VAERA("Vaera", "וארא"),
    BO("Bo", "בא"),
    BESHALACH("Beshalach", "בשלח"),
    YISRO("Yisro", "יתרו"),
    MISHPATIM("Mishpatim", "משפטים"),
    TERUMAH("Terumah", "תרומה"),
    TETZAVEH("Tetzaveh", "תצוה"),
    KI_SISA("Ki Sisa", "כי תשא"),
    VAYAKHEL("Vayakhel", "ויקהל"),
    PEKUDEI("Pekudei", "פקודי"),
    VAYIKRA("Vayikra", "ויקרא"),
    TZAV("Tzav", "צו"),
    SHEMINI("Shemini", "שמיני"),
    TAZRIA("Tazria", "תזריע"),
    METZORAH("Metzorah", "מצורע"),
    ACHAREI_MOS("Acharei Mos", "אחרי מות"),
    KEDOSHIM("Kedoshim", "קדושים"),
    EMOR("Emor", "אמור"),
    BEHAR("Behar", "בהר"),
    BECHUKOSAI("Bechukosai", "בחוקותי"),
    BAMIDBAR("Bamidbar", "במדבר"),
    NASO("Naso", "נשא"),
    BEHAALOSCHA("Behaaloscha", "בהעלותך"),
    SHLACH("Shlach", "שלח"),
    KORACH("Korach", "קרח"),
    CHUKAS("Chukas", "חקת"),
    BALAK("Balak", "בלק"),
    PINCHAS("Pinchas", "פנחס"),
    MATOS("Matos", "מטות"),
    MASEI("Masei", "מסעי"),
    DEVARIM("Devarim", "דברים"),
    VAESCHANAN("Vaeschanan", "ואתחנן"),
    EIKEV("Eikev", "עקב"),
    REEH("Reeh", "ראה"),
    SHOFTIM("Shoftim", "שופטים"),
    KI_SEITZEI("Ki Seitzei", "כי תצא"),
    KI_SAVO("Ki Savo", "כי תבוא"),
    NETZAVIM("Netzavim", "נצבים"),
    VAYEILECH("Vayeilech", "וילך"),
    HAAZINU("Haazinu", "האזינו"),
    VZOS_HABRACHA("Vzos Habracha", "וזאת הברכה");

    fun byHebrewName(hebrewName: String): BibleBook {
        BibleBook.values().forEach {
            if (it.hebrewName == hebrewName) return it
        }
        throw IllegalArgumentException()
    }
    fun byEnglishName(hebrewName: String): BibleBook {
        BibleBook.values().forEach {
            if (it.englishName == hebrewName) return it
        }
        throw IllegalArgumentException()
    }
}