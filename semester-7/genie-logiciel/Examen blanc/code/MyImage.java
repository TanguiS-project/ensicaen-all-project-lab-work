import java.awt.*;
import java.awt.image.BufferedImageOp;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyImage extends JPanel {
    private BufferedImage _image;
    private Dimension _size = new Dimension();

    public MyImage( String path ) {
        try {
            this._image = ImageIO.read(new File(path));
            _size.setSize(_image.getWidth(), _image.getHeight());
        } catch (Exception e) {
            System.out.println("Error creating image with path " + path);
            System.out.println(e);
        }
    }

    public MyImage( MyImage i ) {
        _size = new Dimension(i._size);
        _image = i._image.getSubimage(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void paintComponent( Graphics g ) {
        int x = (getWidth() - _size.width) / 2;
        int y = (getHeight() - _size.height) / 2;
        g.drawImage(_image, x, y, this);
    }

    public void display() {
        try {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.add(new JScrollPane(this));
            f.setSize(_image.getWidth(), _image.getHeight());
            f.setLocation(10, 10);
            f.setVisible(true);
        } catch (Exception e) {
        }
    }

    public void paintUnder( MyImage otherimage, int xShift, int yShift ) {
        BufferedImage newImage = otherimage._image;
        int sizeX = newImage.getWidth();
        int sizeY = newImage.getHeight();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int pixel = newImage.getRGB(x, y);
                int alphaNew = (pixel >> 24) & 0xFF;
                if (((x + xShift) < _image.getWidth()) &&
                        ((y + yShift) < _image.getHeight()) &&
                        ((x + xShift) >= 0) &&
                        ((y + yShift) >= 0)) {
                    int pixelOrig = _image.getRGB(x + xShift, y + yShift);
                    int alphaOrig = ((pixelOrig >> 24) & 0xFF);
                    if (alphaOrig < 255) {
                        double alpha = alphaOrig / 255.0;
                        int redOrig = ((pixelOrig >> 16) & 0xFF);
                        int greenOrig = ((pixelOrig >> 8) & 0xFF);
                        int blueOrig = (pixelOrig & 0xFF);
                        int redNew = ((pixel >> 16) & 0xFF);
                        int greenNew = ((pixel >> 8) & 0xFF);
                        int blueNew = (pixel & 0xFF);
                        int finalRed = (int) (redOrig * alpha + redNew * (1.0 - alpha));
                        int finalGreen = (int) (greenOrig * alpha + greenNew * (1.0 - alpha));
                        int finalBlue = (int) (blueOrig * alpha + blueNew * (1.0 - alpha));
                        int alphaFinal = (int) ((1.0 - (1.0 - alpha) * (1.0 - alphaNew / 255.0)) * 255.0);
                        int pixelFinal = 65536 * 256 * alphaFinal + finalRed * 65536 + finalGreen * 256 + finalBlue;
                        _image.setRGB(x + xShift, y + yShift, pixelFinal);
                    }
                }
            }
        }
    }

    public void paintOver( MyImage otherimage, int xShift, int yShift ) {
        BufferedImage newImage = otherimage._image;
        int sizeX = newImage.getWidth();
        int sizeY = newImage.getHeight();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int pixel = newImage.getRGB(x, y);
                int alphaNew = (pixel >> 24) & 0xFF;
                if (alphaNew > 0) {
                    if (((x + xShift) < _image.getWidth()) &&
                            ((y + yShift) < _image.getHeight()) &&
                            ((x + xShift) >= 0) &&
                            ((y + yShift) >= 0)) {
                        double alpha = alphaNew / 255.0;
                        int pixelOrig = _image.getRGB(x + xShift, y + yShift);
                        int alphaOrig = ((pixelOrig >> 16) & 0xFF);
                        int redOrig = ((pixelOrig >> 16) & 0xFF);
                        int greenOrig = ((pixelOrig >> 8) & 0xFF);
                        int blueOrig = (pixelOrig & 0xFF);
                        int redNew = ((pixel >> 16) & 0xFF);
                        int greenNew = ((pixel >> 8) & 0xFF);
                        int blueNew = (pixel & 0xFF);
                        int finalRed = (int) (redNew * alpha + redOrig * (1.0 - alpha));
                        int finalGreen = (int) (greenNew * alpha + greenOrig * (1.0 - alpha));
                        int finalBlue = (int) (blueNew * alpha + blueOrig * (1.0 - alpha));
                        int alphaFinal = (int) ((1.0 - (1.0 - alpha) * (1.0 - alphaOrig / 255.0)) * 255.0);
                        int pixelFinal = 65536 * 256 * alphaFinal + finalRed * 65536 + finalGreen * 256 + finalBlue;
                        _image.setRGB(x + xShift, y + yShift, pixelFinal);
                    }
                }
            }
        }
    }

    public void pixelate( int factor ) {
        BufferedImageOp op = new AffineTransformOp(
                AffineTransform.getScaleInstance(1.0 / factor, 1.0 / factor),
                new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        BufferedImage small = op.filter(_image, null);
        int sizeX = _image.getWidth();
        int sizeY = _image.getHeight();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int pixel = small.getRGB(x / factor, y / factor);
                _image.setRGB(x, y, pixel);
            }
        }
    }


    public void blackAndWhite() {
        int sizeX = _image.getWidth();
        int sizeY = _image.getHeight();

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int pixel = _image.getRGB(x, y);
                int alpha = ((pixel >> 24) & 0xFF);
                int r = ((pixel >> 16) & 0xFF);
                int g = ((pixel >> 8) & 0xFF);
                int b = (pixel & 0xFF);
                r = (r + g + b) / 3;
                pixel = alpha * 256 * 65536 + r * 65536 + r * 256 + r;
                _image.setRGB(x, y, pixel);
            }
        }
    }

    public void fourBitsColor() {
        int sizeX = _image.getWidth();
        int sizeY = _image.getHeight();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int pixel = _image.getRGB(x, y);
                int alpha = ((pixel >> 24) & 0xFF);
                int r = ((pixel >> 16) & 0xFF);
                int g = ((pixel >> 8) & 0xFF);
                int b = (pixel & 0xFF);
                r = r - r % 16;
                g = g - g % 16;
                b = b - b % 16;
                pixel = 65536 * 256 * alpha + r * 65536 + g * 256 + b;
                _image.setRGB(x, y, pixel);
            }
        }
    }
}