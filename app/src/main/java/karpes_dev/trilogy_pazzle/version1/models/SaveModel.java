package karpes_dev.trilogy_pazzle.version1.models;

import karpes_dev.trilogy_pazzle.version1.abstractions.IFigure;

public class SaveModel {

    private IFigure figure;
    private int id;

    public SaveModel(IFigure figure, int id) {
        this.figure = figure;
        this.id = id;
    }

    public IFigure getFigure() {
        return figure;
    }

    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
