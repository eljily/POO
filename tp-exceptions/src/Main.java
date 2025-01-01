public class Main {
    public static void main(String[] args) {
        System.out.println("Debut d'application");
        try {
            EntierNaturel entierNaturel = new EntierNaturel(-7);
        }catch (Exception e){
            System.out.println("Encountered exception while trying to create an object with value : "+e.getMessage());
            NombreNegatifException.memorise(e.getMessage());
        }
        System.out.println("La valeur errone qui a entraine l'exception est : ");
        NombreNegatifException.afficherLeValeur();
        System.out.println("Fin du programme");
    }
}
class EntierNaturel {
    int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val<0){
            throw new NombreNegatifException(""+val+"");
        }
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val<0){
            throw new NombreNegatifException(""+val+"");
        }
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        int result = this.val -1;
        if (result<0){
            throw new NombreNegatifException(""+result+"");
        }
        this.val = result;
    }
}
class NombreNegatifException extends Exception {
    static String val ;

    public static void memorise(String v){
        val = v ;
    }
    public static String getValeurErrones(){
        return val;
    }
    public static void afficherLeValeur(){
        System.out.println(val);
    }

    public NombreNegatifException(String message) {
        super(message);
    }
}