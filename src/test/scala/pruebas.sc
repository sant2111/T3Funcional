import Anagramas._

val p1_1: Boolean = lOcPal("invisible") == List(('b',1),('e',1),('i',3),('l',1),('n',1),('s',1),('v',1))
val p1_2: Boolean = lOcPal("monotono") == List(('m',1),('n',2),('o',4),('t',1))
val p1_3: Boolean = lOcPal("perro") == List(('e', 1), ('o', 1), ('p', 1), ('r', 2))
val p1_4: Boolean = lOcPal("") == Nil
val p1_5: Boolean = lOcPal("abcdefghijklmnopqrst") == List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1), ('f', 1), ('g', 1), ('h', 1), ('i', 1), ('j', 1), ('k', 1), ('l', 1), ('m', 1), ('n', 1), ('o', 1), ('p', 1), ('q', 1), ('r', 1), ('s', 1), ('t', 1))


// Pruebas para lOcFrase (5 casos)

val p2_1: Boolean = lOcFrase(List("hello", "world")) == List(('d',1),('e',1),('h',1),('l',3),('o',2),('r',1),('w',1))
val p2_2: Boolean = lOcFrase(List("linux", "mint")) == List(('i',2),('l',1),('m',1),('n',2),('t',1),('u',1),('x',1))
val p2_3: Boolean = lOcFrase(List()) == Nil
val p2_4: Boolean = lOcFrase(List("a", "b", "c")) == List(('a', 1), ('b', 1), ('c', 1))
val p2_5: Boolean = lOcFrase(List("uno", "dos", "uno")) == List(('d',1),('n',2),('o',3),('s',1),('u',2))

// Pruebas para diccionarioPorOcurrencias (5 casos)
val p3_1: Boolean = diccionarioPorOcurrencias.get(lOcPal("yo"))         == Some(List("yo"))
val p3_2: Boolean = diccionarioPorOcurrencias.get(lOcPal("como"))       == Some(List("como", "moco"))
val p3_3: Boolean = diccionarioPorOcurrencias.get(lOcPal("cosas"))      == Some(List("cosas"))
val p3_4: Boolean = diccionarioPorOcurrencias.get(lOcPal("computador")) == None
val p3_5: Boolean = diccionarioPorOcurrencias.get(lOcPal("roca"))       == Some(List("roca", "arco", "caro", "cora"))


// Pruebas para combinaciones (5 casos)
val p4_1: Boolean = combinaciones(List()) == List(List())
val p4_2: Boolean = combinaciones(List(('x', 1))) == List(List(), List(('x', 1)))
val p4_3: Boolean = combinaciones(List(('m', 2))) == List(List(), List(('m', 1)), List(('m', 2)))
val p4_4: Boolean = combinaciones(List(('a',1),('b',1))) == List(List(), List(('a',1)), List(('b',1)), List(('a',1),('b',1)))
val p4_5: Boolean = combinaciones(lOcPal("sol")) == List(List(), List(('l',1)), List(('o',1)), List(('l',1),('o',1)), List(('s',1)), List(('l',1),('s',1)), List(('o',1),('s',1)), List(('l',1),('o',1),('s',1)))

// 5. Pruebas para complemento (5 casos)
val p5_1: Boolean = complemento(List(('a', 2), ('b', 1)), List(('a', 2), ('b', 1))) == Nil
val p5_2: Boolean = complemento(List(('x', 3), ('y', 1)), List()) == List(('x', 3), ('y', 1))
val p5_3: Boolean = complemento(List(('a', 3), ('b', 2)), List(('a', 1))) == List(('a', 2), ('b', 2))
val p5_4: Boolean = complemento(List(('c', 2), ('o', 2), ('s', 2)), List(('c', 1), ('o', 1), ('s', 1))) == List(('c', 1), ('o', 1), ('s', 1))
val p5_5: Boolean = complemento(lOcPal("programacion"), lOcPal("grama")) == List(('c',1),('i',1),('n',1),('o',2),('p',1),('r',1))

// 1. Grupo de 4 anagramas (incluye la palabra original y sus variantes)
val p6_1: Boolean = anagramasDePalabra("roca").sorted == List("arco", "caro", "cora", "roca")

// 2. Grupo de 2 anagramas (par clásico del diccionario base)
val p6_2: Boolean = anagramasDePalabra("como").sorted == List("como", "moco")

// 3. Grupo de 3 anagramas (5 letras)
val p6_3: Boolean = anagramasDePalabra("trapo").sorted == List("parto", "potra", "trapo")

// 4. Caso borde: palabra en el diccionario sin otros anagramas (solo ella misma)
val p6_4: Boolean = anagramasDePalabra("sos") == List("sos")

// 5. Caso borde: palabra inexistente en el diccionario -> lista vacía
val p6_5: Boolean = anagramasDePalabra("casa") == Nil

// 6. Caso borde: insensibilidad a mayúsculas/minúsculas (case-insensitive)
val p6_6: Boolean = anagramasDePalabra("ROCA").sorted == List("arco", "caro", "cora", "roca")

// 7. Palabra ausente del diccionario cuyas ocurrencias SI existen: no devuelve Nil
val p6_7: Boolean = anagramasDePalabra("orca").sorted == List("arco", "caro", "cora", "roca")

// 1. Frase de una sola palabra con múltiples anagramas (4 resultados)
val p7_1: Boolean = anagramasDeFrase(List("roca")).toSet == Set(
  List("roca"), List("arco"), List("caro"), List("cora")
)

// 2. Frase de una palabra con 3 anagramas posibles
val p7_2: Boolean = anagramasDeFrase(List("cosa")).toSet == Set(
  List("caso"), List("cosa"), List("saco")
)

// 3. Frase compuesta de dos palabras (permutaciones de orden y sinónimos: 2 x 2 = 4)
val p7_3: Boolean = anagramasDeFrase(List("como", "yo")).toSet == Set(
  List("como", "yo"),
  List("moco", "yo"),
  List("yo", "como"),
  List("yo", "moco")
)

// 4. Frase de una sola palabra sin anagramas adicionales (1 resultado)
val p7_4: Boolean = anagramasDeFrase(List("sos")) == List(List("sos"))

// 5. Caso borde: frase con letras que no forman ninguna palabra del diccionario
val p7_5: Boolean = anagramasDeFrase(List("casa")) == Nil

// 6. Caso borde: frase vacía -> lista con la frase vacía List(Nil)
val p7_6: Boolean = anagramasDeFrase(List()) == List(Nil)

// 7. Caso de estres: "ostra" [4] x "trapo" [3] x 2 ordenes = 24 frases
val resOstraTrapo = anagramasDeFrase(List("ostra", "trapo"))
val esperadoOstraTrapo =
  (for { a <- List("ostra", "astro", "ratos", "rotas")
         b <- List("trapo", "parto", "potra") } yield List(a, b)).toSet ++
  (for { a <- List("trapo", "parto", "potra")
         b <- List("ostra", "astro", "ratos", "rotas") } yield List(a, b)).toSet
val p7_7: Boolean = resOstraTrapo.toSet == esperadoOstraTrapo && esperadoOstraTrapo.size == 24

// 8. Frase que solo se resuelve con 3 palabras (la recursion baja mas de dos niveles)
val p7_8: Boolean = {
  val r = anagramasDeFrase(List("sol", "es", "la"))
  r.size == 72 && r.toSet.contains(List("la", "es", "sol"))
}