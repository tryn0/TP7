import java.util.ArrayList;
import java.io.Console;
import java.lang.Error;
import java.io.FileReader;
import java.io.BufferedReader;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tienda{
	public static void main(String args[]) throws Exception {
		DAOCompra daocompra = new JDBCCompra();//para las consultas
		//a continuacion, el codigo es para leer el fichero json, que corresponde al catalogo de productos.	
		String line = new String("");
		String lin = null;
		ArrayList<String> listaProds = new ArrayList<String>();	
		BufferedReader br = new BufferedReader(new FileReader("productos.json"));		
		while((lin = br.readLine()) != null) {
          	line = line + lin;
        }
        JSONArray jsonProductos = new JSONArray(line);

        for (Object obj : jsonProductos){
        		String nombre = ((JSONObject) obj).getString("nombre");
        		String precio = ((JSONObject) obj).getString("precio");
        		listaProds.add(nombre + ":" + precio);//los datos se pasan a una lista,para tenerlos guardados y poder usarlos
        		if(precio.equals("1")){
        			System.out.println(nombre + ": " + precio + " euro");
        		}
        		else{
        			System.out.println(nombre + ": " + precio + " euros");
        		}
        	}
        //una vez leidos y guardados, se empieza con la compra
		Compra c;
		ArrayList<Compra> lista1 = new ArrayList<Compra>();
		Console console = null;
		console = System.console();
		while(true){//aqui se pone en bucle para que puedan haber mas de una persona con su respectiva id de compra
			c = new Compra();
			Person p = new Person();
			System.out.println("Nombre persona: ");
			String persona = console.readLine();
			if(persona.equals("")){
					break;
				}
			p.setName(persona);
			System.out.println("ID de compra: ");
			String idcomp = console.readLine();
			int idcom=Integer.parseInt(idcomp);
			
			while(true){//este while es para que una persona pueda comprar mas de un articulo en una compra
				c.setId(idcom);
				System.out.println("Articulos: ");
				String articulo = console.readLine();
				if(articulo.equals("")){
					break;
				}
				for(int i = 0;i<listaProds.size();i++){//aqui esta la informacion del json
					String[] a = listaProds.get(i).split(":");
					
					if(articulo.equals(a[0])){
						c.getArt().setNombre(articulo);

						int preciop=Integer.parseInt(a[1]);
						System.out.println("Cantidad: ");
						String canti = console.readLine();
						if(canti.equals("")){
							break;
						}
						int cant = Integer.parseInt(canti);
						c.getArt().setPrecio(preciop * cant);
						c.setCant(cant);
						c.getPer().setName(p.getName());
						Date fechaFactura = new Date();
						c.setFecha(fechaFactura);
						lista1.add(c);
						daocompra.grabar(c);//se guarda en la base de datos
					}
				}
				System.out.println("Mas articulos? s/n ");
				String masart = console.readLine();
				if(masart.equals("n")){
					c.setArticulos(lista1);
					break;
				}
				else{
					c = new Compra();
				}
			}
			System.out.println("Mas entradas? s/n ");
			String masper = console.readLine();
			if(masper.equals("n")){
				break;
			}
		}

		System.out.println("Los datos han quedado guardados en la base de datos. Con fecha: "+ new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(c.getFecha()));
		while(true){//aqui es donde esta la parte de consultas.
			System.out.println("Quieres consultar datos? S|N");
			String respuesta = console.readLine();
			if (respuesta.equals("s")){
				daocompra.consultart();//te muestra todos los datos guardados
				System.out.println("Para consultar por persona: N|para consultar por producto: P|para mostrar por ID: I");
				String respuesta2 = console.readLine();
				if(respuesta2.equals("n")){
					System.out.println("intrduce nombre");
					String r = console.readLine();
					daocompra.consultarn(r);//te muestra los datos que contienen el nombre introducido
				}
				else if(respuesta2.equals("p")){
					System.out.println("intrduce producto");
					String r = console.readLine();//te muestra los datos que contienen el producto introducido
					daocompra.consultarp(r);
				}
				else if(respuesta2.equals("i")){
					System.out.println("intrduce id");
					String r = console.readLine();
					int r2=Integer.parseInt(r);
					daocompra.consultari(r2);//te muestra la compra de una persona
				}
				else{
					System.out.println("Lo sentimos! esa opcion no esta disponible");
				}
			}
			else{
				System.out.println("ADIOS");
				break;
			}
		}
	}
}