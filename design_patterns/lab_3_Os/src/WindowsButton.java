import contract.IButton;

public class WindowsButton implements IButton {
    @Override
    public void paint() {
        System.out.println("Rendering a button in a Windows style");
    }
}
