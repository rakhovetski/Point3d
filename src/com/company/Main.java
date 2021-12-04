package com.company;

import java.util.Objects;

class Point3D{
    private double x;
    private double y;
    private double z;

    public Point3D(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    public void printPoint(){
        System.out.println("x: " + x + "\ny: " + y + "\nz: " + z);
    }

    public boolean equals(Point3D point){
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();
        boolean check;

        if(Double.compare(this.x, x) == 0 && Double.compare(this.y, y) == 0 && Double.compare(this.z, z) == 0){
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }

    /* Филиппов А.В. 04.12.2021 Комментарий не удалять.
     Правильный equals выглядит так.
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.x, x) == 0 && Double.compare(point3D.y, y) == 0 && Double.compare(point3D.z, z) == 0;
    }

 }

class Vector3D{
    private double x;
    private double y;
    private double z;

    public Vector3D(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D point1, Point3D point2){
        double x1 = point1.getX();
        double y1 = point1.getY();
        double z1 = point1.getZ();

        double x2 = point1.getX();
        double y2 = point1.getY();
        double z2 = point1.getZ();

        this.x = x2 - x1;
        this.y = y2 - y1;
        this.z = z2 - z1;
    }

    public void show(){
        System.out.println("x: " + this.x + "\ny: " + this.y + "\nz: " + this.z);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }

    public void setX(double value) {
        x = value;
    }

    public void setY(double value) {
        y = value;
    }

    public void setZ(double value) {
        z = value;
    }

    public double lenght(){
        return Math.sqrt((double)x*x + (double)y*y + (double)z*z);
    }

    public boolean equals(Vector3D vector){
        double x = vector.getX();
        double y = vector.getY();
        double z = vector.getZ();

        boolean check;
        if (Double.compare(this.x, x) == 0 && Double.compare(this.y, y) == 0 && Double.compare(this.z, z) == 0) {
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }
}


class Vector3DProcessor{
    private Vector3D vector1;
    private Vector3D vector2;

    public Vector3DProcessor(double x1,double y1,double z1, double x2, double y2, double z2){
        this.vector1 = new Vector3D(x1, y1, z1);
        this.vector2 = new Vector3D(x2, y2, z2);
    }

    public Vector3DProcessor(Vector3D vector1, Vector3D vector2){
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    public Vector3D vectorSum(){
        double x1 = this.vector1.getX() + this.vector2.getX();
        double y1 = this.vector1.getY() + this.vector2.getY();
        double z1 = this.vector1.getZ() + this.vector2.getZ();
        Vector3D vector = new Vector3D(x1,y1,z1);
        return vector;
    }

    public Vector3D vectorDifference(){
        double x1 = this.vector1.getX() - this.vector2.getX();
        double y1 = this.vector1.getY() - this.vector2.getY();
        double z1 = this.vector1.getZ() - this.vector2.getZ();
        Vector3D vector = new Vector3D(x1,y1,z1);
        return vector;
    }

    public double vectorSkalyar(){
        double skalyar = (this.vector1.getX() * this.vector2.getX()) + (this.vector1.getY() * this.vector2.getY()) + (this.vector1.getZ() * this.vector2.getZ());
        return skalyar;
    }

    public Vector3D vectorVector(){
        double x1 = this.vector1.getX();
        double y1 = this.vector1.getY();
        double z1 = this.vector1.getZ();

        double x2 = this.vector2.getX();
        double y2 = this.vector2.getY();
        double z2 = this.vector2.getZ();

        double x = y1*z2 - z1*y2;
        double y = -(x1*z2 - z1*x2);
        double z = x1*y2 - y1*x2;
        Vector3D vector = new Vector3D(x,y,z);
        return vector;
    }

    /* Филиппов А.В. 04.12.2021 Комментарий не удалять.
     Не работает! В main написал пример.
     А вообще странный класс. Чтобы сложить два вектора нужно создавать новый объект...
     Более разумным был бы класс со статическими методами вида
       public static boolean vectorKollinear(Vector3D x, Vector3D y){

    */
    public boolean vectorKollinear(){
        double x1 = this.vector1.getX();
        double y1 = this.vector1.getY();
        double z1 = this.vector1.getZ();

        double x2 = this.vector2.getX();
        double y2 = this.vector2.getY();
        double z2 = this.vector2.getZ();

        boolean check = false;
        if(Double.compare(x1 / x2, y1 / y2) == 0 && Double.compare(x1 / x2, z1 / z2) == 0 && Double.compare(y1 / y2, z1 / z2) == 0){
            check = true;
        }
        return check;
    }
}

class Vector3DArray {
    private int length;
    private Vector3D[] vector;

    public Vector3DArray(int n){
        this.length = n;
        this.vector = new Vector3D[this.length];
        for(int i = 0; i < n; i++){
            vector[i] = new Vector3D();
        }
    }

    public int getLength(){
        return length;
    }

    public void replaceVector(Vector3D replVector, int i){
        vector[i] = replVector;
    }

    /* Филиппов А.В. 04.12.2021 Комментарий не удалять.
     Не работает! Если создать массив нулевой длины (а это полезный объект т.к. иначе пустой массив придется обозначать null),
     то будет исключение.
    */
    public double vectorMaxLong(){
        double x = vector[0].lenght();
        for(int i = 1; i < length; i++){
            if(x < vector[i].lenght()){
                x = vector[i].lenght();
            }
        }
        return x;
    }

    public int searchVector(Vector3D sVector){
        for(int i = 0; i < length; i++){
            if(vector[i].equals(sVector)){
                return i;
            }
        }
        return -1;
    }

    public Vector3D sumVectors(){
        double x1 = 0;
        double y1 = 0;
        double z1 = 0;
        for(int i = 0; i < length; i++){
            x1 = x1+vector[i].getX();
            y1 = y1+vector[i].getY();
            z1 = z1+vector[i].getZ();
        }
        Vector3D sumVector = new Vector3D(x1,y1,z1);
        return sumVector;
    }

    /* Филиппов А.В. 04.12.2021 Комментарий не удалять.
     Не работает! А где тест?
    */
    public Vector3D lineCombination(double[] x, int Long){
        if(Long != length){
            Vector3D vector = new Vector3D();
            return vector;
        }
        else{
            double x1 = 0;
            double y1 = 0;
            double z1 = 0;
            Vector3D linevector = new Vector3D();
            for(int i = 0; i < length; i++){
                x1 = x1 + vector[i].getX()*x[i];
                y1 = y1 + vector[i].getY()*x[i];
                z1 = z1 + vector[i].getZ()*x[i];
            }
            linevector.setX(x1);
            linevector.setY(y1);
            linevector.setZ(z1);
            return linevector;
        }
    }

    public Point3D[] move(Point3D P)
    {
        Point3D[] shiftPoints= new Point3D[vector.length];
        double x1, y1, z1;
        for(int i = 0; i < vector.length; i++)
        {
            x1 = P.getX()+vector[i].getX();
            y1 = P.getY()+vector[i].getY();
            z1 = P.getZ()+vector[i].getZ();
            shiftPoints[i] = new Point3D(x1, y1, z1);
        }
        return shiftPoints;
    }
}

public class Main {

    public static void main(String[] args) {
	    Point3D point1 = new Point3D(1,2,3);
	    Point3D point2 = new Point3D(2,4,1);
        System.out.println(point1 == point2);
        System.out.println(point1.equals(point2));

        Vector3D vector1 = new Vector3D(1,2,3);
        Vector3D vector2 = new Vector3D(2,3,4);
        System.out.println(vector1.lenght());
        vector1.show();

        Vector3DProcessor vector3DProcessor1 = new Vector3DProcessor(1,2,3,4,5,6);
        System.out.println(vector3DProcessor1.vectorSum());
        System.out.println(vector3DProcessor1.vectorDifference());
        System.out.println(vector3DProcessor1.vectorVector());
        System.out.println(vector3DProcessor1.vectorSkalyar());
        System.out.println(vector3DProcessor1.vectorKollinear());

        Vector3DArray vector3DArray1 = new Vector3DArray(4);
        System.out.println(vector3DArray1.getLength());
        vector3DArray1.replaceVector(vector1, 0);
        System.out.println(vector3DArray1.vectorMaxLong());
        System.out.println(vector3DArray1.searchVector(vector1));
        /* Филиппов А.В. 04.12.2021 Комментарий не удалять.
         Не работает! На экран выводится не то что ожидалось
        */
        System.out.println(vector3DArray1.sumVectors());
        System.out.println(vector3DArray1.move(point1));

        Vector3DProcessor vector3DProcessor2 = new Vector3DProcessor(0,1,1,0,2,2);
        System.out.println("должно быть тру, а получилось " + vector3DProcessor2.vectorKollinear());

    }
}
