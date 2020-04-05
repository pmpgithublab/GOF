package ua.tutorial.gof.behavioral;

// https://refactoring.guru/design-patterns/template-method
public class TemplateMethodPattern {
    public static void main(String[] args) {
        WebsiteTemplate template1 = new WelcomePage();
        WebsiteTemplate template2 = new NewsPage();
        WebsiteTemplate template3 = new AboutPage();

        template1.showPage();
        template2.showPage();
        template3.showPage();

    }
}

abstract class WebsiteTemplate {
    void showPage() {
        System.out.println("Header");
        showContent();
        System.out.println("Footer");
    }

    public abstract void showContent();
}


class WelcomePage extends WebsiteTemplate {
    @Override
    public void showContent() {
        System.out.println("Welcome");
    }
}

class NewsPage extends WebsiteTemplate {
    @Override
    public void showContent() {
        System.out.println("News");
    }
}

class AboutPage extends WebsiteTemplate {
    @Override
    public void showContent() {
        System.out.println("About");
    }
}