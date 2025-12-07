package net.com.salesianos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import net.com.salesianos.model.Student;

public class StudentDAO {
    public void save(Student s) {
        ObjectContainer db = DBManager.open();
        Student exists = findById(s.getId());
        if (exists != null) {
            throw new RuntimeException("ID duplicado");
        }
        db.store(s);
        db.commit();
    }

    public List<Student> findAll() {
        ObjectSet<Student> result = DBManager.open().query(Student.class);
        List<Student> list = new ArrayList<>();
        while (result.hasNext())
            list.add(result.next());
        return list;
    }

    public Student findById(String id) {
        Student proto = new Student();
        proto.setId(id);
        ObjectSet<Student> result = DBManager.open().queryByExample(proto);
        return result.hasNext() ? result.next() : null;
    }

    public boolean deleteById(String id) {
        Student s = findById(id);
        if (s == null)
            return false;
        DBManager.open().delete(s);
        DBManager.open().commit();
        return true;
    }

    public boolean update(Student updated) {
        Student s = findById(updated.getId());
        if (s == null)
            return false;

        s.setNombre(updated.getNombre());
        s.setApellidos(updated.getApellidos());
        s.setAñoNacimiento(updated.getAñoNacimiento());
        s.setCentro(updated.getCentro());

        DBManager.open().store(s);
        DBManager.open().commit();
        return true;
    }
}
