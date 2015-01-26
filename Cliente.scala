
// cliente

import java.rmi._

abstract class Operation
case class Suma(x: Int, y: Int) extends Operation
case class Resta(x: Int, y: Int) extends Operation
case class Div(x: Int, y: Int) extends Operation
case class Mul(x: Int, y: Int) extends Operation
case object Exit extends Operation

object Cliente {
  def menu: Operation = {
	   println("Selecciona Operación")
	   println("1. Suma")
	   println("2. Resta")
	   println("3. Multiplicación")
	   println("4. Division")
	   println("0. Salir")

	  val op = Console.readInt()

    val (x, y) = if ((1 to 4) contains op) {
	    println("Introduce el primer valor")
      val x = Console.readInt()
      println("Introduce el segundo valor")
      val y = Console.readInt()
      (x,y) } else (0,0)

    op match {
      case 1 => Suma(x, y)
      case 2 => Resta(x, y)
      case 3 => Mul(x, y)
      case 4 => Div(x,y)
      case _ => Exit
	 }
  }

    def main(args: Array[String]): Unit = {

	    val op = menu

	    try {
	      val c = Naming.lookup("rmi://localhost:8080/calc") match {
          case s: Cuentas => s
          case o => throw new RuntimeException("Es de tipo incorrento" + o )
        }

	      op match {
	         case Suma(x, y) => println("La suma de " +  x  + " + "  + y + " es: " + (c.suma(x, y)))
	         case Resta(x, y) => println("La resta de " +  x + " - "  + y + " es: " + (c.resta(x, y)))
	         case Mul(x, y) => println("La multiplicación de " +  x + " * "  + y + " es: "+ (c.mul(x, y)))
	         case Div(x, y) => if (y == 0) println("No se puede dividir entre 0")
                             else println("La division de " +  x + " / "  + y + " es: " + (c.div(x, y)))
	         case _ => return 
	      }
     } catch {
		     case e: Exception => println("Error " ++ e.toString);
	   }
    
    main(Array[String](""))
    }
}