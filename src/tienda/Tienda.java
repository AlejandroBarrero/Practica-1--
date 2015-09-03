package tienda;
import java.util.Scanner;

public class Tienda {
    
    Scanner lector = new Scanner(System.in);
    
    public int menu()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n            TiendaSoft V 1.0");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Seleccione la opción:\n ");
        System.out.println("[1] Agregar producto");
        System.out.println("[2] Buscar producto");
        System.out.println("[3] Eliminar producto");
        System.out.println("[4] Mostrar inventario");
        System.out.println("[5] Realizar venta");
        System.out.println("[6] Mostrar ganancias totales");
        System.out.println("[7] Salir");        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return lector.nextInt();        
    }   
        
    public static void main(String[] args) 
    {
        Scanner lector = new Scanner(System.in);
        int seleccion,n=0,i,j;
        double gananciat=0,cuantos;
        boolean in = true;
        String objetivo;
        Tienda tiendav1 = new Tienda();        
        Producto productos[] = new Producto[100]; //Máximo 100 productos en stock         
              
        while(in)
        {
            seleccion = tiendav1.menu();
        
            switch(seleccion)
            {
                case 1: //Agregar
                    productos[n] = new Producto();
                    productos[n].agregar();
                    n++;
                    System.out.println("Producto agregado");
                    break;
                    
                case 2: //Buscar
                    j=0;
                    System.out.print("Ingrese el nombre del producto que busca: ");
                    objetivo = lector.nextLine();
                    
                    for (i=0;i<n;i++)
                    {
                        if(objetivo.equals(productos[i].getNombre()))
                        {
                            System.out.println("Producto encontrado: "+productos[i].getNombre());
                            System.out.println("Cantidad: "+productos[i].getCantidad());
                            System.out.println("Valor: "+productos[i].getValor());     
                            j=0;
                            break;
                        }
                        else
                            j=1;
                    }     
                    if(j==1)
                        System.out.println("El producto no existe");     
                    break;
                    
                case 3: //Eliminar
                    j=0;
                    System.out.println("Escriba el nombre del producto que desea eliminar");
                    objetivo = lector.nextLine();
                     for (i=0;i<n;i++)
                    {
                        if(objetivo.equals(productos[i].getNombre()))
                        {
                            productos[i].eliminar();
                            j=0;
                            System.out.println("Producto eliminado");
                            break;
                        }
                        else
                            j=1;
                    }
                      if(j==1)
                        System.out.println("El producto no existe");     
                    break;
                    
                case 4: //Inventario
                    System.out.println("Inventario de productos:");
                    for (i=0;i<n;i++)
                    {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Producto: "+productos[i].getNombre());
                        System.out.println("Cantidad: "+productos[i].getCantidad());
                        System.out.println("Valor: "+productos[i].getValor()); 
                    }
                    break;
                    
                case 5: //Venta
                    j=0;
                    System.out.print("Escriba el nombre del producto que desea vender: ");
                    objetivo = lector.nextLine();
                     for (i=0;i<n;i++)
                    {
                        if(objetivo.equals(productos[i].getNombre()))
                        {
                            System.out.print("Ingrese la cantidad que desea vender: ");
                            cuantos = lector.nextDouble();
                            lector.nextLine();
                            productos[i].Vender(cuantos);
                            gananciat += productos[i].getValor()*cuantos;
                            System.out.println("Vendido");
                            j=0;
                            break;
                        }
                        else
                            j=1;
                    }
                      if(j==1)
                        System.out.println("El producto no existe");     
                    break;
                    
                case 6: //Ganancias
                    System.out.println("Ganancias:");
                    for (i=0;i<n;i++)
                    {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Producto: "+productos[i].getNombre());
                        System.out.println("Cantidad ventas: "+productos[i].getVendidos());
                        System.out.println("Valor total ventas: "+productos[i].getVtotal()); 
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Valor total vendido: "+gananciat);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                    
                case 7:
                    System.out.println("¡Hasta luego!");
                    in = false;
                    break;
                    
                default:
                    System.out.println("Ha ingresado un valor incorrecto");                      
            }
        }
    }
    
}