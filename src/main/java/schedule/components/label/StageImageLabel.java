package schedule.components.label;

/**
 * 一般的なバトルのステージの画像を表示するラベルのクラスです。
 * このクラスは {@link ImageLabel} を継承し、特定のサイズ設定を適用したステージ画像ラベルを提供します。
 *
 * @see ImageLabel
 */
public class StageImageLabel extends ImageLabel {

    /**
     * コンストラクタ。
     * ステージ画像ラベルを作成します。
     *
     * @param resourcePath 画像リソースのパス
     */
    public StageImageLabel(String resourcePath) {
        super(null, 200, 100, resourcePath);
    }
}