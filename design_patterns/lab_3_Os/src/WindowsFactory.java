import contract.IButton;
import contract.IGuiFactory;

public class WindowsFactory extends IGuiFactory {

    @Override
    public IButton createButton() {
        return new WindowsButton();
    }
}
