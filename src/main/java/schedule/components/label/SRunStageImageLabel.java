package schedule.components.label;

/**
 * サーモンランのステージ画像を表示するラベルのクラスです。
 * このクラスは、{@link ImageLabel} を継承し、特定のサイズ設定を適用したステージ画像ラベルを提供します。
 *
 * @see ImageLabel
 */
public class SRunStageImageLabel extends ImageLabel {

    /**
     * コンストラクタ。
     * 指定されたリソースパスからステージ画像を読み込んでSRun_StageImageLabelを作成します。
     *
     * @param resourcePath 画像のリソースパス
     */
    public SRunStageImageLabel(String resourcePath) {
        super(null, 300, 150, resourcePath);
    }
}