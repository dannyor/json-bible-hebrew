package bible.data.types

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.java.truevfs.access.*
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import java.io.File

object BibleLoader {
    fun loadFrom(f: File) : Bible {
        if(f.name.endsWith(".json")) {
            val fileContents = FileUtils.readFileToString(f, "UTF-16")
            return Json { prettyPrint = true }.decodeFromString<Bible>(fileContents)
        }
        else if(f.name.endsWith(".zip")) {
            val zipFile = TFile(f)
            val tFile = zipFile.listFiles()!![0]
            val fileContents = IOUtils.toString(TFileInputStream(tFile), "UTF-16")
//            TVFS.umount()
            return Json { prettyPrint = true }.decodeFromString<Bible>(fileContents)
        }
        throw IllegalArgumentException("Only json or zipped json are supported")
    }
}

