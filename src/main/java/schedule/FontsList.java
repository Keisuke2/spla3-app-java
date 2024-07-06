package schedule;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

import static javax.swing.WindowConstants.*;

/**
 * フォント一覧を表示するクラスです。
 * システムにインストールされているフォントを取得し、表示可能なフォントをリストアップします。
 */
public class FontsList {
    // システムにインストールされているフォントを取得
    private static final Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();

    /**
     * フォント一覧を取得します。
     *
     * @param as 表示可能なフォントを絞り込むための文字列（オプション）
     * @return フォント名のリスト
     */
    public static List<String> getAllFonts(String[] as) {
        List<String> fontsList = new ArrayList<>();
        char dsp = 0;
        int sp;
        if (as.length > 0) dsp = as[0].charAt(0);

        for (Font font : fonts) {
            // フォントが表示可能かチェック
            if (dsp != 0) {
                if (!font.canDisplay(dsp)) continue;
            }

            String fns = font.getName();

            if (fns.contains("bold")) continue;
            if (fns.contains("Bold")) continue;
            if (fns.contains("italic")) continue;
            if (fns.contains("Italic")) continue;
            if (fns.contains("イタリック")) continue;
            if (fns.contains("ボールド")) continue;
            sp = fns.indexOf(".plain");
            if (-1 != sp) fns = fns.substring(0, sp);
            sp = fns.indexOf(" Regular");
            if (-1 != sp) fns = fns.substring(0, sp);
            sp = fns.indexOf("-Regular");
            if (-1 != sp) fns = fns.substring(0, sp);

            fontsList.add(fns);
            System.out.println(fns);
        }
        return fontsList;
    }

    /**
     * フォント一覧を表示するウィンドウを作成し、フォント名とテキストを表示します。
     *
     * @param args コマンドライン引数（使用されません）
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("フォントチェック");
        frame.setSize(700, 500);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        String jpText = "日本語　スプラトゥーン3　全角３";
        for (String font : FontsList.getAllFonts(args)) {
            JLabel label2 = new JLabel();
            label2.setText(font + ":  " + jpText);
            label2.setAlignmentX(Component.LEFT_ALIGNMENT);
            label2.setFont(new Font(font, Font.PLAIN, 18));
            panel2.add(label2);
        }

        frame.add(scrollPane);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}