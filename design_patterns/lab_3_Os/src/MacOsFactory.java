import contract.IButton;
import contract.IGuiFactory;

public class MacOsFactory extends IGuiFactory {
    @Override
    public IButton createButton() {
        return new MacOsButton();
    }
}
