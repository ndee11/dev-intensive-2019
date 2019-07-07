package Utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName != null && firstName.trim() == "") {
            firstName = null
        }
        if (lastName != null && lastName.trim() == "") {
            lastName = null
        }

        return Pair(firstName, lastName)
    }

    fun toItitials(firstName: String?, lastName: String?): String? {
        var s1: String? = null
        if (firstName != null && firstName.trim() != "") {
            s1 = firstName.substring(0, 1)
        }

        var s2: String? = null
        if (lastName != null && lastName.trim() != "") {
            s2 = lastName.substring(0, 1)
        }

        if (s1 == null && s2 == null) {
            return null
        }

        if (s1 == null) {
            s1 = ""
        }
        if (s2 == null) {
            s2 = ""
        }

        return "$s1 $s2".trim()
    }

    fun transliteration(payload : String, devider : String = " ") : String {
        var ret : String
        ret = payload
        ret = ret.replace('а', 'a')
        ret = ret.replace('б', 'b')
        ret = ret.replace('в', 'v')
        ret = ret.replace('г', 'g')
        ret = ret.replace('д', 'd')
        ret = ret.replace('е', 'e')
        ret = ret.replace('ё', 'e')
        ret = ret.replace("ж", "zh")
        ret = ret.replace('з', 'z')
        ret = ret.replace('и', 'i')
        ret = ret.replace('й', 'i')
        ret = ret.replace('к', 'k')
        ret = ret.replace('л', 'l')
        ret = ret.replace('м', 'm')
        ret = ret.replace('н', 'n')
        ret = ret.replace('о', 'o')
        ret = ret.replace('п', 'p')
        ret = ret.replace('р', 'r')
        ret = ret.replace('с', 's')
        ret = ret.replace('т', 't')
        ret = ret.replace('у', 'u')
        ret = ret.replace('ф', 'f')
        ret = ret.replace('х', 'h')
        ret = ret.replace('ц', 'c')
        ret = ret.replace("ч", "ch")
        ret = ret.replace("ш", "sh")
        ret = ret.replace("щ", "sh")
        ret = ret.replace("ъ", "")
        ret = ret.replace('ы', 'i')
        ret = ret.replace("ь", "")
        ret = ret.replace('э', 'e')
        ret = ret.replace("ю", "yu")
        ret = ret.replace("я", "ya")
        ret = ret.replace('А', 'A')
        ret = ret.replace('Б', 'B')
        ret = ret.replace('В', 'V')
        ret = ret.replace('Г', 'G')
        ret = ret.replace('Д', 'D')
        ret = ret.replace('Е', 'E')
        ret = ret.replace('Ё', 'E')
        ret = ret.replace("Ж", "ZH")
        ret = ret.replace('З', 'Z')
        ret = ret.replace('И', 'I')
        ret = ret.replace('Й', 'I')
        ret = ret.replace('К', 'K')
        ret = ret.replace('Л', 'L')
        ret = ret.replace('М', 'M')
        ret = ret.replace('Н', 'N')
        ret = ret.replace('О', 'O')
        ret = ret.replace('П', 'P')
        ret = ret.replace('Р', 'R')
        ret = ret.replace('С', 'S')
        ret = ret.replace('Т', 'T')
        ret = ret.replace('У', 'U')
        ret = ret.replace('Ф', 'F')
        ret = ret.replace('Х', 'H')
        ret = ret.replace('Ц', 'C')
        ret = ret.replace("Ч", "CH")
        ret = ret.replace("Ш", "SH")
        ret = ret.replace("Щ", "SH")
        ret = ret.replace("Ъ", "")
        ret = ret.replace('Ы', 'I')
        ret = ret.replace("Ь", "")
        ret = ret.replace('Э', 'E')
        ret = ret.replace("Ю", "YU")
        ret = ret.replace("Я", "YA")
ret =
        return ret
    }
}