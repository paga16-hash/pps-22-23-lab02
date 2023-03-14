package u02.lab02

object lab02 extends App:

  val intToString: Int => String = _ match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"

  def intToStringDef(n: Int): String = n match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"


/*val res = v match
    case n if n > 0 => "pos"
    case 0 => "zero"
    case _ => "neg" // default case, makes it a total function
  println(res)*/ // "pos"
