import contract.IButton;
import contract.IGuiFactory;

public class SystemApp {
    private IButton button;

    public SystemApp(IGuiFactory factory) {
        this.button = factory.createButton();
    }

    public void paint(){
        this.button.paint();
    }
}
