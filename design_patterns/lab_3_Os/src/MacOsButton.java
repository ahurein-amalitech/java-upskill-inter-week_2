import contract.IButton;

public class MacOsButton implements IButton{

    @Override
    public void paint() {
        System.out.println("Rendering a button in a MacOs style");
    }
}
