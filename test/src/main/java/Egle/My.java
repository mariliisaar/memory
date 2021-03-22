package Egle;

public class My {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public int square(int x){
        return x*x;
    }
    public int[] toArray(int ...args){
        int lenght= args.length;
        int[] array= new int[lenght];

        for(int i = 0 ; i<lenght; i++){
            array[i]=args[i];
        }
        return array;
    }
}
