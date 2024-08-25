package py.edu.ucom.Api2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    private final Path filePath = Paths.get("resources/users.csv");

    public UserService() {
        try {
            if (Files.notExists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, List.of("id,nombre,apellido,fechaNacimiento,contrasena"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(user.getId() + "," + user.getNombre() + "," + user.getApellido() + "," + user.getFechaNacimiento() + "," + user.getContrasena());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.skip(1)
                        .map(line -> line.split(","))
                        .filter(fields -> Integer.parseInt(fields[0]) == id)
                        .map(fields -> new User(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4]))
                        .findFirst()
                        .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
