package modelo;

public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private String genero;
    private int stock;

    public Libro(String titulo, String autor, double precio, String genero, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.genero = genero;
        this.stock = stock;


    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                ", stock=" + stock +
                '}';
    }

    public static Libro fromCSV(String linea){
        String[] elemento = linea.split("\\|");
        Libro libro = new Libro(elemento[0],elemento[1],
                Double.parseDouble(elemento[2]),elemento[3],
                Integer.parseInt(elemento[4]));

        return libro;
    }

    public String toCSV(){
        String linea =titulo +"|"+autor+"|"+precio+"|"+genero+"|"+stock;
        return linea;
    }
}
