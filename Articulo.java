class Articulo {
    private String nombre;
    private int precio;
    public Articulo(){
    	nombre = "";
        precio = 0;
    }
    public void setNombre(String nombre){
      this.nombre = nombre;
    }
    public String getNombre(){
      return nombre;
    }
    public void setPrecio(int precio){
        this.precio=precio;
    }
    public int getPrecio(){
        return precio;
    }
}
