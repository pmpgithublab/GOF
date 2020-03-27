package ua.tutorial.gof.structural;

// https://refactoring.guru/design-patterns/proxy
public class ProxyPattern {
    public static void main(String[] args) {
        // load image during init
        Image image = new RealImage("image.gif");
        image.display();

        // load image before display
        image = new ProxyRealImage("image.gif");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String imageFileName;
    private String data;

    public RealImage(String imageFileName) {
        this.imageFileName = imageFileName;
        loadImage();
    }

    private void loadImage() {
        //data = new FileReader(image);
        System.out.println("Image loading...");
        data = imageFileName;
    }

    @Override
    public void display() {
        System.out.println("Display picture: " + data);
    }
}

class ProxyRealImage implements Image {
    private String imageFileName;
    private RealImage data;

    public ProxyRealImage(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public void display() {
        if (data == null) {
            data = new RealImage(imageFileName);
        }
        data.display();
    }
}

