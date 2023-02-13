package Dropdown.DropdownPages;

import Dropdown.DropdownBase.DropdownBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropdownListPage extends DropdownBaseTest {
    public DropdownListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    public WebElement DropdownList;

    @FindBy(css = "option[selected = 'selected']")
    public List<WebElement> Placeholder;


    //------------------------

    public String getPlaceholderText() {
        return Placeholder.get(0).getText();
    }


}
