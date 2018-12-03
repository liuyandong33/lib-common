package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class QRCodeUtils {
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;
    public static final String FORMAT_NAME = "png";

    public static void generateQRCode(int width, int height, String text, OutputStream outputStream) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        ImageIO.write(bufferedImage, FORMAT_NAME, outputStream);
    }

    public static String parseQRCode(InputStream inputStream) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        Binarizer binarizer = new HybridBinarizer(luminanceSource);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        HashMap<DecodeHintType, Object> decodeHints = new HashMap<DecodeHintType, Object>();
        decodeHints.put(DecodeHintType.CHARACTER_SET, Constants.CHARSET_NAME_UTF_8);
        Result result = new MultiFormatReader().decode(binaryBitmap, decodeHints);
        return result.getText();
    }

    public static String parseQRCode(File file) throws IOException, NotFoundException {
        return parseQRCode(new FileInputStream(file));
    }
}
