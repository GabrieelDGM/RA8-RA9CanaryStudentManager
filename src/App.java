import java.util.Scanner;
import java.util.UUID;
import net.com.salesianos.model.Student;
import net.com.salesianos.persistence.DBManager;
import net.com.salesianos.persistence.StudentDAO;

public class App {
    static Scanner sc = new Scanner(System.in);
    static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Crear estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Modificar estudiante");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            switch (sc.nextLine()) {
                case "1":
                    create();
                    break;
                case "2":
                    list();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    update();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        DBManager.close();
    }

    static void create() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellido = sc.nextLine();
        System.out.print("Año nacimiento: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.print("Centro: ");
        String centro = sc.nextLine();

        String id = UUID.randomUUID().toString();
        dao.save(new Student(id, nombre, apellido, año, centro));
        System.out.println("Creado con ID: " + id);
    }

    static void list() {
        dao.findAll().forEach(System.out::println);
    }

    static void delete() {
        System.out.print("ID a eliminar: ");
        System.out.println(dao.deleteById(sc.nextLine()) ? "Eliminado" : "No encontrado");
    }

    static void update() {
        System.out.print("ID a modificar: ");
        String id = sc.nextLine();
        Student s = dao.findById(id);
        if (s == null) {
            System.out.println("No existe");
            return;
        }

        System.out.print("Nuevo nombre (" + s.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.isEmpty())
            s.setNombre(nombre);

        System.out.print("Nuevos apellidos (" + s.getApellidos() + "): ");
        String apellido = sc.nextLine();
        if (!apellido.isEmpty())
            s.setApellidos(apellido);

        System.out.print("Nuevo año (" + s.getAñoNacimiento() + "): ");
        String año = sc.nextLine();
        if (!año.isEmpty())
            s.setAñoNacimiento(Integer.parseInt(año));

        System.out.print("Nuevo centro (" + s.getCentro() + "): ");
        String centro = sc.nextLine();
        if (!centro.isEmpty())
            s.setCentro(centro);

        dao.update(s);
        System.out.println("Modificado");
    }
}
