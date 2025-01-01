package org.eljily.sidibrahim.ws;
import jakarta.jws.*;
import java.util.Date;
import java.util.List;
@WebService(serviceName = "BanqueWS")
public class BanqueService {
    @WebMethod(operationName = "Convert")
   public double conversion(@WebParam(name = "montant") double mt){
       return mt*10.54;
   }
   @WebMethod
   public Compte getCompte(@WebParam(name = "code") int code){
       return new Compte(code,Math.random()*9888,new Date());
   }

   public List<Compte> listComptes(){
       return List.of(
               new Compte(1,Math.random(),new Date()),
               new Compte(2,Math.random(),new Date()),
               new Compte(3,Math.random(),new Date())
       );
   }

}
