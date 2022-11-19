package java_synchronized;

import java.util.ArrayList;
import java.util.List;

public class WebBrowser {

    private static final String SPACE = " ";

    private final List<String> webSiteNames = new ArrayList<>();

    private final int maxWebCount;

    public WebBrowser(final int maxWebCount) {
        this.maxWebCount = maxWebCount;
    }


    public boolean hasSpace() {
        return true;
    }

    public void createNewTab(String webSiteName) {

    }
}
