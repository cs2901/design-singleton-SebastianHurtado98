public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler single_instance = null; 

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() 
    { 
        if (single_instance == null) 
        {
            synchronized(ChocolateBoiler.class){
            single_instance = new ChocolateBoiler(); 
            }
        }
        return single_instance; 
    } 

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
}
