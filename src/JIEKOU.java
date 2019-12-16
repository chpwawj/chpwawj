public class JIEKOU
{
    public static void main(String[] args)
    {
        double d=Math.pow(2,0.5);
        Rectangle a=new Rectangle(1,1,5,4) ;
        Circle b=new Circle(0,0,3) ;
        Triangle c=new Triangle (2,2,4,3,3,4,5) ;
        a.getArea();
        a.getPerimeter();
        b.getArea();
        b.getPerimeter();
        c.getArea();
        c.getPerimeter();
    }
}
 interface Shape
{
    public abstract void getArea();
    public abstract void getPerimeter();
}
class Coordinate
{
    long x;
    long y;
   public Coordinate(long x,long y)
    {
        this.x=x;
        this.y=y;
    }
}
class Rectangle extends Coordinate implements Shape
{
    long x0,y0;
    double chang,kuan;
    public Rectangle( long x0,long y0,double chang,double kuan)
    {
        super(x0,y0);
       this.chang=chang;
       this.kuan=kuan;
        System.out.println("这个矩形的起点是("+x0+","+y0+")");
    }
    public void getArea()
    {
        System.out.println("矩形的面积："+chang*kuan);
    }
    public void getPerimeter()
    {
        System.out.println("矩形的周长："+2*(chang+kuan));
    }
}
class Circle extends Coordinate implements Shape
{
    long x0,y0;
    double banjing;
    public Circle( long x0,long y0,double banjing)
    {
        super(x0,y0);
        this.banjing=banjing;
        System.out.println("这个圆的圆心是("+x0+","+y0+")");
    }
    public void getArea()
    {
        System.out.println("圆形的面积："+Math.PI*Math.pow(banjing,2));
    }
    public void getPerimeter()
    {
        System.out.println("圆形的周长："+2*banjing*Math.PI);
    }
}
class Triangle extends Coordinate implements Shape
{
    long x0,y0;
    double di,gao,bian1,bian2,bian3;
    public Triangle( long x0,long y0,double di,double gao,double bian1,double bian2,double bian3)
    {
        super(x0,y0);
        this.di=di;
        this.gao=gao;
        this.bian1=bian1;
        this.bian2=bian2;
        this.bian3=bian3;
        System.out.println("这个三角形的起点是("+x0+","+y0+")");
    }
    public void getArea()
    {
        System.out.println("三角形的面积："+di*gao/2);
    }
    public void getPerimeter()
    {
        double a=bian1+bian2+bian3;
        System.out.println("三角形的周长："+a);
    }
}


