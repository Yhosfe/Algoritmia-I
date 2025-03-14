package Ejercicicios.Ejercicio01;

public class Verificador {
    public static double menorX = 0;
    public static double mayorX = 0;
    public static double menorY = 0;
    public static double mayorY = 0;


    // Comentarios
    public static void calcularVars(Rectangulo r1) {
        // Condicional se cumple si x1 es menos que x2 ???
        if (r1.getEsquina1().getX() < r1.getEsquina2().getX()) {
            menorX = (double) r1.getEsquina1().getX();
            mayorX = (double) r1.getEsquina2().getX();
        } else {
            mayorX = (double) r1.getEsquina1().getX();
            menorX = (double) r1.getEsquina2().getX();
        }

        if (r1.getEsquina1().getY() < r1.getEsquina2().getY()) {
            menorY = (double) r1.getEsquina1().getY();
            mayorY = (double) r1.getEsquina2().getY();
        } else {
            mayorY = (double) r1.getEsquina1().getY();
            menorY = (double) r1.getEsquina2().getY();
        }
    }



    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        calcularVars(r1);
        double r1minX = menorX;
        double r1maxX = mayorX;
        double r1minY = menorY;
        double r1maxY = mayorY;
        calcularVars(r2);
        double r2minX = menorX;
        double r2maxX = mayorX;
        double r2minY = menorY;
        double r2maxY = mayorY;

        return (Math.max(r1minX, r2minX) < Math.min(r1maxX, r2maxX)) &&
                (Math.max(r1minY, r2minY) < Math.min(r1maxY, r2maxY));
    }
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        calcularVars(r1);

        if (menorX == (double) r2.getEsquina1().getX() || menorX == (double) r2.getEsquina2().getX()) {
            return true;
        } else if (mayorX == (double) r2.getEsquina1().getX() || mayorX == (double) r2.getEsquina2().getX()) {
            return true;
        } else {
            if (menorY == (double) r2.getEsquina1().getY() || menorY == (double) r2.getEsquina2().getY()) {
                return true;
            } else if (mayorY == (double) r2.getEsquina1().getY() || mayorY == (double) r2.getEsquina2().getY()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1,r2);
    }
}
