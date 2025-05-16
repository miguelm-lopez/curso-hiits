package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Venta {
    private Libro libro;
    private int cantidadvendida;
    private LocalDate fecha;

    public Venta(Libro libro, int cantidadvendida, LocalDate fecha) {
        this.libro = libro;
        this.cantidadvendida = cantidadvendida;
        this.fecha = fecha;
    }
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidadvendida() {
        return cantidadvendida;
    }

    public void setCantidadvendida(int cantidadvendida) {
        this.cantidadvendida = cantidadvendida;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "libro=" + libro +
                ", cantidadvendida=" + cantidadvendida +
                ", fecha=" + fecha +
                '}';
    }

    public String toCSV(){
        String linea = libro.getTitulo()+"|"+cantidadvendida+"|"+fecha;
        return linea;
    }

    public static Venta fromCSV(String linea, List<Libro> inventario){
        String[] elementos =linea.split("\\|");
        String titulo = elementos[0];
        int cantidad = Integer.parseInt(elementos[1]);
        LocalDate fecha = LocalDate.parse(elementos[2]);
        //Optional<Libro>
        Libro libro = inventario.stream()
                .filter(l->l.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
        if (libro==null)
            return null;
        Venta venta= new Venta(libro,cantidad,fecha);
        return venta;


    }




    }

