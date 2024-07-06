package schedule.components.label;

import schedule.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

/**
 * 画像を表示するラベルのクラスです。
 * このクラスは、指定された画像を表示するためのラベルの基本的な機能を提供します。
 * {@link JLabel} を継承しています。
 *
 * @see JLabel
 */
public class ImageLabel extends JLabel {
    protected int width; // 画像の幅
    protected int height; // 画像の高さ
    protected String resourcePath; // 画像リソースのパス

    /**
     * コンストラクタ。
     * 指定された画像でラベルを初期化し、中央揃えに設定します。
     *
     * @param image        表示する画像
     * @param width        画像の幅
     * @param height       画像の高さ
     * @param resourcePath 画像のリソースパス
     */
    public ImageLabel(ImageIcon image, int width, int height, String resourcePath) {
        super(image);
        this.width = width;
        this.height = height;
        this.resourcePath = resourcePath;
        setIcon(loadImage());
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * 指定されたパスから画像を読み込み、アイコンとして返します。
     *
     * @return 読み込んだ画像のアイコン。画像が読み込めない場合はnullを返します。
     */
    protected ImageIcon loadImage() {
        try {
            URL url = SplaScheduleUtils.getURL(resourcePath);
            if (url == null) {
                System.err.println("Incorrect URL: " + resourcePath);
                return null;
            }
            BufferedImage image = ImageIO.read(url);
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            System.err.println("Error loading image from: " + resourcePath + " - " + e.getMessage());
            return null;
        }
    }
}