package imageviwer.control;

import imageviwer.view.ImageDisplay;


public class ReduceImageCommand implements Command{
    
    private final ImageDisplay imageDisplay;

    public ReduceImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().reduce(),0, (float) -100);
    }
    
}
