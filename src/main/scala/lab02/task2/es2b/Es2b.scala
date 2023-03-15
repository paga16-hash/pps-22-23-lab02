package lab02.task2.es2b

object Es2b {
  val checkNotCarrVal: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  val checkCarrVal: Int => (Int => (Int => Boolean)) = x => y => z => x <= y && y == z

  def checkNotCarrDef: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  def checkCarrDef(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))
}
