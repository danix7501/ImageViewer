package imageviwer.view;

import imageviwer.model.Image;

public interface ImageDisplay {

    public Image image();
    public void show(Image image, int grades, float zoom);

}
