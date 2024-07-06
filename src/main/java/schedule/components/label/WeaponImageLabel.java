package schedule.components.label;

/**
 * サーモンランの武器画像を表示するラベルのクラスです。
 * このクラスは {@link ImageLabel} を継承し、武器画像を表示するためのラベルを提供します。
 *
 * @see ImageLabel
 */
public class WeaponImageLabel extends ImageLabel {

    /**
     * 指定されたリソースパスから武器画像を読み込んでWeaponImageLabelを作成します。
     *
     * @param resourcePath 画像のリソースパス
     */
    public WeaponImageLabel(String resourcePath) {
        super(null, 70, 70, resourcePath);
    }
}