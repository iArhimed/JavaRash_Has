package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader (ImageTypes imageTypes) {
        ImageReader imageReader = null;
        if (imageTypes == null) throw new IllegalArgumentException();
        if (imageTypes.name().equals("BMP") ) {
            imageReader = new BmpReader();
        } else if (imageTypes.name().equals("JPG")) {
            imageReader = new JpgReader();
        } else if (imageTypes.name().equals("PNG")) {
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException();
        }
        return imageReader;
    }
}
