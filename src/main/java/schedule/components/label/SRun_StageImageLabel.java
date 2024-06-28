package schedule.components.label;

public class SRun_StageImageLabel extends StageImageLabel {
    public SRun_StageImageLabel(String resourcePass) {
        super(resourcePass);
        super.resourcePath = resourcePass;
        int width = 300;
        int height = 150;
        setStageSize(width, height);
    }
}
