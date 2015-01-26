import scala.remote
import java.rmi.{RemoteException}
trait Cuentas extends java.rmi.Remote {
   @throws(classOf[RemoteException]) def suma(x: Double, y: Double): Double
   @throws(classOf[RemoteException]) def resta(x: Double, y: Double): Double
   @throws(classOf[RemoteException]) def mul(x: Double, y: Double): Double
   @throws(classOf[RemoteException]) def div(x: Double, y: Double): Double
}
