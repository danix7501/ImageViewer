
package imageviwer.control;

import imageviwer.model.Image;
import imageviwer.view.ImageDisplay;

public class RotateImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public RotateImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image(),90,1);
    }
    
}
