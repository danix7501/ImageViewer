package imageviwer.control;

import imageviwer.view.ImageDisplay;

public class IncreaseImageCommand implements Command {

    private final ImageDisplay imageDisplay;

    public IncreaseImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().increase(), 0, (float) 100);
    }
}
