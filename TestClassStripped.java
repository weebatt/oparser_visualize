public class HitCheckBean {

    public HitCheckBean() { }

    private int x;
    private double y;
    private int r;

    public int getX() { }

    public void setX(int x) { }

    public double getY() { }

    public void setY(double y) { }

    public int getR() { }

    public void setR(int r) { }

    public List<Point> getResults() { }

    public void process() {
        boolean result = checkPoint(x, y, r);
        Point pointResult = new Point(x, y, r, result);
        results.add(pointResult);
        for (Point point : results) {
            System.out.println(point.getX() + " " + point.getY() + " " + point.getR() + " " + point.getResult());
        }
        System.out.println("Coordinates: x=" + x + ", y=" + y + ", r=" + r);
        System.out.println("Result: " + result);
        PrimeFaces.current().ajax().addCallbackParam("result", result);
    }

    public boolean checkPoint(int x, double y, int r) {
        if (x >= 0 && y >= 0 && x * x + y * y <= (double) 4/r*r) {
            return true;
        } else if (x <= 0 && y <= 0 && y >= -x - (double) 2/r) {
            return true;
        } else {
            return x >= 0 && y <= 0 && x <= (double) 1/r && y >= (double) -2/r;
        }
    }
}
