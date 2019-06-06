package karpes_dev.trilogy_pazzle.version1.models;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IReader;

public class ReaderSVG implements IReader<IPolygon> {

    private int id;
    private Scanner scanner;

    public ReaderSVG(Context context, int id){
        this.id = id;
        readFile(context);
    }

    /**
     * Считывает текст из файла построчно, каждая строка это обьект String.
     * Созздает список и заполняет его строками.
     * @throws IOException
     */
    private Scanner readFile(Context context){
        try {
            scanner = new Scanner(context.getResources().getAssets().open(id + ".svg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scanner;
    }
    /**
     * Сканирует список строк, создает список координат и заполняет его.
     * @return Список координат(double)
     */
    public  List<IPolygon> read() {
        List<IPolygon> polygons = new ArrayList<>();
        //Читаем строку
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            //Если треугольник то читаем координаты
            if(line.contains("offset=\"0\"")){
                color = line.substring(37, 44);
            }else if(line.contains("polygon")){
                //Заменить запятые на точки
                line = line.replace(",", " ");
                Scanner sc = new Scanner(line);
                //Читаем по слову
                readPoints(sc, polygons);
            }
        }
        return polygons;
    }

    private String color;

    private void readPoints(Scanner sc, List<IPolygon> polygons){
        boolean frf = false;
        int count = 1;
        float[] points = new float[6];
        while (sc.hasNext()){
            String s = sc.next();
            //считываем еще 5 координат
            if(s.contains("points")){
                points[0] = Float.parseFloat(s.substring(8));
                frf = true;
            }
            //Если точки, то обрезаем слово "points" b считываем координату
            else if(frf) {
                points[count] = Float.parseFloat(s);
                count++;
                //Считали 6 координат и вышли из цикла
                if(count >= 6) {
                    IPolygon polygon = new Polygon(points);
                    polygon.setNumber(polygons.size());
                    polygon.setColor(color);
                    polygons.add(polygon);
                    break;
                }
            }
        }
    }





}
