package object Anagramas {
  type Palabra = String
  type Frase = List [Palabra]
  type Occurrencias = List [(Char,Int)]

  val diccionario: List [Palabra] = List ("cosas","como","yo","y","ocasos","cayo","mocosos","roca","sos")
  
  def lOPal(p: Palabra): Occurrencias = {
    ...//usar group by,map,...
    
  }
  
  def IOcFrase (f: Frase): Occurrencias = {
  ... //usar IOPal,mkString
    
  }
  
  lazy val diccionarioPorOcurrencias: Map[Occurrencias,List[Palabra]] = {
  ... //usae groupBy, lOcPal,...
    
    
   def anagramasDePalabra(palabra: Palabra):List[Palabra] = {
   ...// usar diccionarioPorOcurrencias.get.LoPal
    
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    // usar una expresion for para producir el resultado
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    // usar recursion de cola
  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    // usar expresiones for y funciones auxiliares
  }

  
}
