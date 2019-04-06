import java.util.ArrayList;
import java.util.Date;

public class Compra {
  private Person per;
  private Articulo art;
  private int cant;
  private int id;
  private ArrayList<Compra> articulos;
  private Date fecha;
  private String idFactura;
  public Compra() {
    per = new Person();
    art = new Articulo();
    cant = 0;
    id=0;
    fecha = new Date();
    idFactura = null;
  }
  public void setPer(Person unPerson) {
    per = unPerson;
  }
  public void setArt(Articulo art) {
    this.art = art;
  }
  public void setCant(int cant) {
    this.cant = cant;
  }
  public void setId(int id){
    this.id=id;
  }
  public Person getPer() {
    return per;
  }
  public Articulo getArt() {
    return art;
  }
  public int getCant() {
    return cant;
  }
  public int getId(){
    return id;
  }
  public void setArticulos(ArrayList<Compra> d ){
    this.articulos = d;
  }
  public ArrayList<Compra> getArticulos(){
    return articulos;
  }
  public void setFecha(Date fecha){
  	this.fecha = fecha;
  }
  public Date getFecha() {
  	return fecha;
  }
}
