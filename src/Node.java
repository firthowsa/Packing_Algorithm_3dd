public class Node {
    public boolean isroot = false;
    public String name;
    public double x;
    public double y;
    public double z;
    public double l;
    public double w;
    public double h;
    public boolean used = false;
    public Node right = null;
    public Node down = null;
    public Node up=null;
    public Node fit = null;

    public Node(String name, double l, double w,double h) {
        this.name = name;
        this.l = l;
        this.w = w;
        this.h=h;
    }

    public Node(double x, double y, double z,double l, double w,double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.l= l;
        this.w = w;
        this.h = h;
        if(x == 0 && y == 0 && z==0){
            this.isroot = true;//this is only necessary for me to print 'Pack Starts Here' in the example code
        }
    }

}
