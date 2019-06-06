package karpes_dev.trilogy_pazzle.models;

import karpes_dev.trilogy_pazzle.abstractions.ISettingModel;

public class SettingSaveModel implements ISettingModel {

    private int pathColor;
    private int numbersColor;
    private int difficulty;


    public SettingSaveModel(int pathColor, int numbersColor, int difficulty) {
        this.pathColor = pathColor;
        this.numbersColor = numbersColor;
        this.difficulty = difficulty;
    }

    @Override
    public int getPathColor() {
        return pathColor;
    }
    @Override
    public void setPathColor(int pathColor) {
        this.pathColor = pathColor;
    }
    @Override
    public int getNumbersColor() {
        return numbersColor;
    }
    @Override
    public void setNumbersColor(int numbersColor) {
        this.numbersColor = numbersColor;
    }
    @Override
    public int getDifficulty() {
        return difficulty;
    }
    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
