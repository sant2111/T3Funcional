import Anagramas._

val p1_1 = lOcPal("invisible")
val p1_2 = lOcPal("monotono")
val p1_3 = lOcPal("perro")
val p1_4 = lOcPal("")
val p1_5 = lOcPal("abcdfghijklmnopqrst")


// Pruebas para lOcFrase (5 casos)

val p2_1 = lOcFrase(List("hello", "world"))
val p2_2 = lOcFrase(List("linux", "mint"))
val p2_3 = lOcFrase(List())
val p2_4 = lOcFrase(List("a", "b", "c"))
val p2_5 = lOcFrase(List("uno", "dos", "uno"))

// Pruebas para diccionarioPorOcurrencias (5 casos)

val p3_1 = diccionarioPorOcurrencias.get(lOcPal("yo"))
val p3_2 = diccionarioPorOcurrencias.get(lOcPal("como"))
val p3_3 = diccionarioPorOcurrencias.get(lOcPal("cosas"))
val p3_4 = diccionarioPorOcurrencias.get(lOcPal("computador"))
val p3_5 = diccionarioPorOcurrencias.get(lOcPal("roca"))


// Pruebas para combinaciones (5 casos)
val p4_1 = combinaciones(List())
val p4_2 = combinaciones(List(('x', 1)))
val p4_3 = combinaciones(List(('m', 2)))
val p4_4 = combinaciones(List(('a', 1), ('b', 1)))
val p4_5 = combinaciones(lOcPal("sol"))

// 5. Pruebas para complemento (5 casos)
val p5_1 = complemento(List(('a', 2), ('b', 1)), List(('a', 2), ('b', 1)))
val p5_2 = complemento(List(('x', 3), ('y', 1)), List())
val p5_3 = complemento(List(('a', 3), ('b', 2)), List(('a', 1)))
val p5_4 = complemento(List(('c', 2), ('o', 2), ('s', 2)), List(('c', 1), ('o', 1), ('s', 1)))
val p5_5 = complemento(lOcPal("programacion"), lOcPal("grama"))
