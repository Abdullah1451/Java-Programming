public class LocalVariable{
    public static void main(String[] args) {
        LocalVariable lv = new LocalVariable();
        lv.locVarError();
    }

    //checking for uninitialized local variable error
    void locVarError(){
        int a=0;
        System.out.print(a); //variable a might not have been initialized
    }

    //checking for allowed access modifiers
    void checkSpecifiers(){
        //static int a=0;  
        // Illegal start of Expression ; Only final can be used for both static 
        // and non static methods.
    }

    
}