package karpes_dev.trilogy_pazzle.version1.help;

import android.os.AsyncTask;

import karpes_dev.trilogy_pazzle.version1.models.SaveModel;
import io.paperdb.Paper;


public class SaveTask extends AsyncTask<Void, Void, Void> {

    private SaveModel saveModel;
    private int CODE;

    public SaveTask() {

    }

    public void setModel(SaveModel saveModel, int code){
        this.saveModel = saveModel;
        this.CODE = code;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        Paper.book().write("figure " + String.valueOf(saveModel.getId()), saveModel);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

    public static SaveModel getSaveModel(String key){
        SaveModel saveModel = Paper.book().read(key);
        return saveModel;
    }
}