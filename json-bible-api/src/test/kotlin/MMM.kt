import org.apache.commons.lang3.StringUtils

fun main() {

    val s = "Genesis\n" +
            "Bereishis\n" +
            "Noach\n" +
            "Lech Lecha\n" +
            "Vayera\n" +
            "Chayei Sarah\n" +
            "Toldos\n" +
            "Vayeitzei\n" +
            "Vayishlach\n" +
            "Vayeishev\n" +
            "Miketz\n" +
            "Vayigash\n" +
            "Vayechi\n" +
            "Exodus\n" +
            "Shemos\n" +
            "Vaera\n" +
            "Bo\n" +
            "Beshalach\n" +
            "Yisro\n" +
            "Mishpatim\n" +
            "Terumah\n" +
            "Tetzaveh\n" +
            "Ki Sisa\n" +
            "Vayakhel\n" +
            "Pekudei\n" +
            "Leviticus\n" +
            "Vayikra\n" +
            "Tzav\n" +
            "Shemini\n" +
            "Tazria\n" +
            "Metzorah\n" +
            "Acharei Mos\n" +
            "Kedoshim\n" +
            "Emor\n" +
            "Behar\n" +
            "Bechukosai\n" +
            "Numbers\n" +
            "Bamidbar\n" +
            "Naso\n" +
            "Behaaloscha\n" +
            "Shlach\n" +
            "Korach\n" +
            "Chukas\n" +
            "Balak\n" +
            "Pinchas\n" +
            "Matos\n" +
            "Masei\n" +
            "Deuteronomy\n" +
            "Devarim\n" +
            "Vaeschanan\n" +
            "Eikev\n" +
            "Reeh\n" +
            "Shoftim\n" +
            "Ki Seitzei\n" +
            "Ki Savo\n" +
            "Netzavim\n" +
            "Vayeilech\n" +
            "Haazinu\n" +
            "Vzos Habracha"

    val splits = StringUtils.split(s, "\n")
    splits.forEach {

        println("${it.toUpperCase().replace(' ', '_')}(\"$it\", \"\"),")
    }
}