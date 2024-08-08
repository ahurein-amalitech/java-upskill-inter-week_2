import contract.IGuiFactory;

public class Main {
    private static SystemApp getCurrentOsSystem(OsType type){
        SystemApp app;
        IGuiFactory factory;

        if(type == OsType.MacOs){
           factory = new MacOsFactory();
        }else{
            factory = new WindowsFactory();
        }
        app = new SystemApp(factory);
        return app;
    }
    public static void main(String[] args) {
        SystemApp app = getCurrentOsSystem(OsType.Windows);
        app.paint();
    }
}
