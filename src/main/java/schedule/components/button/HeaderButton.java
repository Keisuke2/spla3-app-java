package schedule.components.button;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * ロビー画面のボタンの基本コンポーネントを提供するクラスです。
 * このクラスは {@link JButton} を拡張し、ボタンのサイズ、アイコン画像を設定します。
 *
 * @see JButton
 */
public class HeaderButton extends JButton {
    protected String resourcePath;

    /**
     * コンストラクタ。
     * 指定されたパスの画像をボタンのアイコンとして設定します。
     *
     * @param resourcePath ボタンのアイコン画像のパス
     */
    public HeaderButton(String resourcePath) {
        super((Icon) null);
        int width = 55;
        int height = 55;
        this.resourcePath = resourcePath;
        setIcon(loadButtonImage());
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * 指定されたパスから画像を読み込み、ボタンのアイコンとして設定します。
     *
     * @return 読み込んだ画像のアイコン。画像が読み込めない場合はnullを返します。
     */
    public ImageIcon loadButtonImage() {
        int width = 50;
        int height = 50;
        try {
            File file = new File(resourcePath);
            BufferedImage image = ImageIO.read(file);
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            System.err.println("Error loading image from: " + resourcePath + " - " + e.getMessage());
            return null;
        }
    }
}