package imageviwer;

import imageviwer.model.Image;
import imageviwer.view.ImageReader;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class FileImageReader implements ImageReader {

    private static final String[] ImageExtensions = {".jpg", ".png", ".gift"};
    private final File[] files;

    public FileImageReader(String path) {
        this(new File(path));
    }

    public FileImageReader(File folder) {
        this.files = folder.listFiles(withImageExtension());
    }

    @Override
    public Image read() {

        return imageAt(0);
    }

    private FilenameFilter withImageExtension() {
        return new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                for (String extension : ImageExtensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    private Image imageAt(final int index) {
        return new Image() {

            @Override
            public Object bitMap() {

                try {
                    return ImageIO.read(files[index]);
                } catch (IOException ex) {
                    return null;
                }
            }

            @Override
            public Image prev() {
                return imageAt(index > 0 ? index - 1 : files.length - 1);
            }

            @Override
            public Image next() {
                return imageAt(index < files.length - 1 ? index + 1 : 0);
            }

            @Override
            public Image rotate() {
                return imageAt(index);
            }

            @Override
            public Image increase() {
                return imageAt(index);
            }

            @Override
            public Image reduce() {
                return imageAt(index);
            }

        };
    }

}
