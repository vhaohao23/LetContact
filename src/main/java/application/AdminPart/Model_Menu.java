
package application.AdminPart;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {
    private String icon;
    private String name;
    private MenuType type;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    public Model_Menu(){
        
    }
    
    public Icon toIcon(){
//    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = getClass().getResource("/application/AdminImage/" + icon + ".png");
    if (resource == null) {
        System.out.println("Can't find: " + "/application/AdminImage/" + icon + ".png");
        return null;
    }
    return new ImageIcon(resource);
}
    
    public static enum MenuType{
    TITLE, MENU, EMTY
}
}
