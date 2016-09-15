package org.kolokolov.unittests.figures;

public class Triangle {
    
    private Point verticeA;
    private Point verticeB;
    private Point verticeC;
    
    public Triangle(Point verticeA, Point verticeB, Point verticeC) {
        if (null == verticeA || null == verticeB || null == verticeC){
            throw new IllegalArgumentException("Triangle vertices must not be null");
        }
        if (Point.onOneLine(verticeA, verticeB, verticeC)) {
            throw new IllegalStateException("Triangle vertices must not lay on one line"); 
        }
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.verticeC = verticeC;
    }
    
    public double square() {
        double lineAB = new Line(verticeA,verticeB).length();
        double lineBC = new Line(verticeB,verticeC).length();
        double lineAC = new Line(verticeA,verticeC).length();
        double p = (lineAB + lineBC + lineAC) / 2;
        return Math.sqrt(p * (p - lineAB) * (p - lineBC) * (p - lineAC));
    }

    @Override
    public String toString() {
        return "[" + verticeA + "," + verticeB + "," + verticeC + "]";
    }
}
