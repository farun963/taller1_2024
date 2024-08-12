¿Qué es un servicio REST?
Un servicio REST (Representational State Transfer) es una arquitectura que permite la comunicación entre sistemas mediante el uso de HTTP para realizar operaciones CRUD (Create, Read, Update, Delete) sobre recursos representados en formato JSON, XML u otros.

¿Cuáles son los principios del diseño RESTful?
Los principios del diseño RESTful incluyen la identificación de recursos mediante URI, el uso de métodos HTTP adecuados, la representación de los recursos en un formato estándar (como JSON), la comunicación sin estado (stateless), y la capacidad de vincular recursos a través de hipermedios.

¿Qué es HTTP y cuáles son los métodos HTTP más comunes?
HTTP (HyperText Transfer Protocol) es un protocolo de comunicación utilizado para enviar y recibir información en la web. Los métodos HTTP más comunes son GET (para obtener recursos), POST (para crear recursos), PUT (para actualizar recursos), DELETE (para eliminar recursos) y PATCH (para modificar parcialmente recursos).

¿Qué es un recurso en el contexto de un servicio REST?
Un recurso es una entidad identificable dentro de un servicio REST, representando datos o información que se puede manipular mediante operaciones HTTP. Cada recurso se accede mediante un URI único.

¿Qué es un endpoint?
Un endpoint es una URL específica dentro de un servicio REST que define una ruta para acceder a un recurso particular o realizar una acción específica, utilizando un método HTTP.

¿Qué es un URI y cómo se define?
Un URI (Uniform Resource Identifier) es una cadena de caracteres que identifica un recurso en la web. En un servicio REST, el URI se define para cada recurso y actúa como la dirección para interactuar con ese recurso mediante operaciones HTTP.

¿Qué es una API RESTful?
Una API RESTful es una interfaz que permite la interacción con un sistema basado en los principios de REST, utilizando métodos HTTP para realizar operaciones sobre recursos identificados por URI y representados en formatos como JSON.

¿Qué son los códigos de estado HTTP y cómo se usan en REST?
Los códigos de estado HTTP son respuestas del servidor que indican el resultado de una solicitud HTTP. En un servicio REST, estos códigos informan si la operación fue exitosa, si hubo un error, o si se requiere alguna acción adicional.

Códigos HTTP de respuesta más comunes:

Código	Significado
200	OK (Operación exitosa)
201	Created (Recurso creado)
400	Bad Request (Solicitud incorrecta)
401	Unauthorized (No autorizado)
403	Forbidden (Prohibido)
404	Not Found (Recurso no encontrado)
500	Internal Server Error (Error del servidor)
¿Qué es JSON y por qué se usa comúnmente en APIs REST?
JSON (JavaScript Object Notation) es un formato ligero de intercambio de datos que es fácil de leer y escribir para los humanos, y sencillo de parsear para las máquinas. Se usa comúnmente en APIs REST porque es eficiente y ampliamente compatible con múltiples lenguajes de programación.
________