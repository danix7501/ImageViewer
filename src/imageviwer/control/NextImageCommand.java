
package imageviwer.control;

import imageviwer.view.ImageDisplay;


public class NextImageCommand implements Command {

    private final ImageDisplay imageDispaly;

    public NextImageCommand(ImageDisplay imageDispaly) {
        this.imageDispaly = imageDispaly;
    }
    
    @Override
    public void execute() {
        imageDispaly.show(imageDispaly.image().next(),0,1);
    }

}
