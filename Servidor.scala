// servidor
import java.rmi.{Naming}

object Servidor {
    def main(args: Array[String]): Unit = {
	try {
	    val co = new CuentasObj
	    Naming.rebind("rmi://localhost:8080/calc", co)
	}
	catch {
	    case e: Exception => println("Error " ++ e.toString()) 
	}
    }
}
