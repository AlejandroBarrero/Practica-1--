package tienda;
import java.util.Scanner;

public class Producto
{
    Scanner lector = new Scanner(System.in);
    private String nombre;
    private double cantidad, valor, vendidos,vtotal;
    
     public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
     
    public String getNombre()
    {
        return nombre;
    }
    
      public void setcantidad(double cantidad)
    {
        this.cantidad = cantidad;
    }
      
     public double getCantidad()
    {
        return cantidad;
    }  
      
     public void setValor(double valor)
    {
        this.valor = valor;
    }  
     
     public double getValor()
    {
        return valor;
    } 
     
       public void setVendidos(double vendidos)
    {
        this.vendidos = vendidos;
    }  
     
     public double getVendidos()
    {
        return vendidos;
    }
     
        public void setVtotal(double vtotal)
    {
        this.vtotal = vtotal;
    }  
     
     public double getVtotal()
    {
        return vtotal;
    } 
     
    public void Vender(double cuantos)
    {
        if(cuantos>cantidad)
            System.out.println("No hay suficientes unidades");
        else
        {
        vendidos += cuantos;
        cantidad -= cuantos;
        vtotal += cuantos*valor;
        }
    }
     
       public void agregar()
    {
        System.out.print("Ingrese el nombre del producto: ");
        this.nombre = lector.nextLine();
        System.out.print("Ingrese la cantidad: ");
        this.cantidad = lector.nextDouble();
        lector.nextLine();
        System.out.print("Ingrese el valor unitario: ");
        this.valor = lector.nextDouble();        
        lector.nextLine();
    }    
       
       public void eliminar()
       {
           this.nombre = null;
           this.cantidad = 0;
           this.valor = 0;
           this.vendidos = 0;
       }
}