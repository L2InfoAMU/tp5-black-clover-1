package image;

public class NotSupportedException extends RuntimeException{
    public NotSupportedException(String error){
        System.out.println(error);
    }
}
