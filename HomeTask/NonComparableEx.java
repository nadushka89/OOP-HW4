package HomeTask;

public class NonComparableEx extends Exception{
    public NonComparableEx (String type){
        super(String.format("Извините %s  не существует", type));
    }
}
