package contract;

public abstract class IGuiFactory {
    public abstract IButton createButton();

    public void isDone(){
        System.out.println("Printing is done");
    }
}
