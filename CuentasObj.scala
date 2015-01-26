import java.rmi.server.{UnicastRemoteObject}
import java.rmi.{RemoteException}

class CuentasObj extends UnicastRemoteObject with Cuentas {
    @throws(classOf[RemoteException]) def suma(x: Double, y: Double): Double = x + y
    @throws(classOf[RemoteException]) def resta(x: Double, y: Double): Double = x - y
    @throws(classOf[RemoteException]) def mul(x: Double, y: Double): Double = x * y
    @throws(classOf[RemoteException]) def div(x: Double, y: Double): Double = x / y
}
