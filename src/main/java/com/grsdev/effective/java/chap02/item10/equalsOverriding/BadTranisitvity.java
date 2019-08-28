package com.grsdev.effective.java.chap02.item10.equalsOverriding;

public class BadTranisitvity {

    public static void main(String[] args) {

        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);

        //System.out.println(p1.equals(p2));

        ColourPoint cp1 = new ColourPoint(1,2,3);
        ColourPoint cp2 = new ColourPoint(1,2,3);
        ColourPoint cp3 = new ColourPoint(1,2,3);

        //System.out.println(cp1.equals(cp2));
        //System.out.println(cp2.equals(cp3));
       // System.out.println(cp1.equals(cp3));

        System.out.println(p1.equals(cp1));
        System.out.println(cp1.equals(p1));

    }
}

class Point {

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Point) && equalityXy((Point) obj);
    }

    private boolean equalityXy(Point obj) {

        return obj.x == this.x && obj.y == this.y;
    }
}

class ColourPoint extends  Point{

    private final int colour;


    ColourPoint(int colour, int x, int y) {
        super(x,y);
        this.colour = colour;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof  ColourPoint) && ((ColourPoint) obj).colour==this.colour;
    }
}
