package object Anagramas {
  import scala.annotation.tailrec

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos")

  def lOcPal(p: Palabra): Ocurrencias = {
    p.toLowerCase.groupBy(identity).map { case(c, str) => (c, str.length) }.toList.sortBy(_._1)
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    lOcPal(f.mkString)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy(lOcPal)
  }


  def combinaciones(lOcurrencias: Ocurrencias): List[Ocurrencias] = {
    lOcurrencias match {
      case Nil => List(Nil)
      case (c, n)::resto => for {
          comb <- combinaciones(resto)
          k <- 0 to n
        } yield if (k == 0) comb else (c, k)::comb
    }
  }


  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    @tailrec
    def aux(l1: Ocurrencias, l2: Ocurrencias, acc: Ocurrencias): Ocurrencias = {
      (l1, l2) match {
        case (Nil, _) => acc.reverse
        case (resto, Nil) => acc.reverse ++ resto
        case ((c1, n1) :: t1, (c2, n2)::t2) =>
          if (c1 == c2) {
            val diff = n1 - n2
            if (diff > 0) aux(t1, t2, (c1, diff)::acc)
            else aux(t1, t2, acc)
          } else if (c1 < c2) {
            aux(t1, l2, (c1, n1)::acc)
          } else {
            aux(l1, t2,acc)
          }
      }
    }
    aux(lOc, slOc, Nil)
  }


  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    //  Persona 2 usar diccionarioPorOcurrencias y lOcPal
    ???
  }


  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    //  Persona 2 usar expresiones for, combinaciones, complemento y diccionarioPorOcurrencias
    ???
  }
}
